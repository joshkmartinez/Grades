package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableBlockingSubscribe {
    private FlowableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void subscribe(Publisher<? extends T> publisher, Subscriber<? super T> subscriber) {
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
        publisher.subscribe(blockingSubscriber);
        Object poll;
        do {
            try {
                if (!blockingSubscriber.isCancelled()) {
                    poll = linkedBlockingQueue.poll();
                    if (poll == null) {
                        if (!blockingSubscriber.isCancelled()) {
                            BlockingHelper.verifyNonBlocking();
                            poll = linkedBlockingQueue.take();
                        } else {
                            return;
                        }
                    }
                    if (!blockingSubscriber.isCancelled()) {
                        if (publisher == BlockingSubscriber.TERMINATED) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } catch (Publisher<? extends T> publisher2) {
                blockingSubscriber.cancel();
                subscriber.onError(publisher2);
                return;
            }
        } while (!NotificationLite.acceptFull(poll, (Subscriber) subscriber));
    }

    public static <T> void subscribe(Publisher<? extends T> publisher) {
        CountDownLatch blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        Object lambdaSubscriber = new LambdaSubscriber(Functions.emptyConsumer(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.REQUEST_MAX);
        publisher.subscribe(lambdaSubscriber);
        BlockingHelper.awaitForComplete(blockingIgnoringReceiver, lambdaSubscriber);
        publisher = blockingIgnoringReceiver.error;
        if (publisher != null) {
            throw ExceptionHelper.wrapOrThrow(publisher);
        }
    }

    public static <T> void subscribe(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        subscribe(publisher, new LambdaSubscriber(consumer, consumer2, action, Functions.REQUEST_MAX));
    }
}
