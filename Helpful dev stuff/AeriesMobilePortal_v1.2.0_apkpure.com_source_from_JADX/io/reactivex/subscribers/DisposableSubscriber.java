package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final AtomicReference<Subscription> f374s = new AtomicReference();

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.setOnce(this.f374s, subscription, getClass()) != null) {
            onStart();
        }
    }

    protected void onStart() {
        ((Subscription) this.f374s.get()).request(LongCompanionObject.MAX_VALUE);
    }

    protected final void request(long j) {
        ((Subscription) this.f374s.get()).request(j);
    }

    protected final void cancel() {
        dispose();
    }

    public final boolean isDisposed() {
        return this.f374s.get() == SubscriptionHelper.CANCELLED;
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.f374s);
    }
}
