package com.jakewharton.retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

final class BodyObservable<T> extends Observable<T> {
    private final Observable<Response<T>> upstream;

    private static class BodyObserver<R> implements Observer<Response<R>> {
        private final Observer<? super R> observer;
        private boolean terminated;

        BodyObserver(Observer<? super R> observer) {
            this.observer = observer;
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            try {
                this.observer.onError(new HttpException(response));
            } catch (Response<R> response2) {
                Exceptions.throwIfFatal(response2);
                RxJavaPlugins.onError(new CompositeException(r1, response2));
            }
        }

        public void onComplete() {
            if (!this.terminated) {
                this.observer.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.terminated) {
                Throwable assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
                assertionError.initCause(th);
                RxJavaPlugins.onError(assertionError);
                return;
            }
            this.observer.onError(th);
        }
    }

    BodyObservable(Observable<Response<T>> observable) {
        this.upstream = observable;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.upstream.subscribe(new BodyObserver(observer));
    }
}
