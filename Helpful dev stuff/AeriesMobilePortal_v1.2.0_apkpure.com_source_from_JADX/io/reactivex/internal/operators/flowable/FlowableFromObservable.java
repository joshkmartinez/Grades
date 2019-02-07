package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    static class SubscriberObserver<T> implements Observer<T>, Subscription {
        private Disposable f74d;
        private final Subscriber<? super T> f75s;

        public void request(long j) {
        }

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f75s = subscriber;
        }

        public void onComplete() {
            this.f75s.onComplete();
        }

        public void onError(Throwable th) {
            this.f75s.onError(th);
        }

        public void onNext(T t) {
            this.f75s.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.f74d = disposable;
            this.f75s.onSubscribe(this);
        }

        public void cancel() {
            this.f74d.dispose();
        }
    }

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }
}
