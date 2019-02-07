package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableScalarXMap {

    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final T value;

        ScalarXMapFlowable(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.value = t;
            this.mapper = function;
        }

        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call == null) {
                            EmptySubscription.complete(subscriber);
                            return;
                        }
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                        return;
                    }
                }
                publisher.subscribe(subscriber);
            } catch (Throwable th2) {
                EmptySubscription.error(th2, subscriber);
            }
        }
    }

    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (!(publisher instanceof Callable)) {
            return null;
        }
        try {
            publisher = ((Callable) publisher).call();
            if (publisher == null) {
                EmptySubscription.complete(subscriber);
                return true;
            }
            try {
                publisher = (Publisher) ObjectHelper.requireNonNull(function.apply(publisher), "The mapper returned a null Publisher");
                if ((publisher instanceof Callable) != null) {
                    try {
                        publisher = ((Callable) publisher).call();
                        if (publisher == null) {
                            EmptySubscription.complete(subscriber);
                            return true;
                        }
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, publisher));
                    } catch (Publisher<T> publisher2) {
                        Exceptions.throwIfFatal(publisher2);
                        EmptySubscription.error(publisher2, subscriber);
                        return true;
                    }
                }
                publisher2.subscribe(subscriber);
                return true;
            } catch (Publisher<T> publisher22) {
                Exceptions.throwIfFatal(publisher22);
                EmptySubscription.error(publisher22, subscriber);
                return true;
            }
        } catch (Publisher<T> publisher222) {
            Exceptions.throwIfFatal(publisher222);
            EmptySubscription.error(publisher222, subscriber);
            return true;
        }
    }

    public static <T, U> Flowable<U> scalarXMap(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(t, function));
    }
}
