package com.jakewharton.retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

final class CallObservable<T> extends Observable<Response<T>> {
    private final Call<T> originalCall;

    private static final class CallDisposable implements Disposable {
        private final Call<?> call;

        CallDisposable(Call<?> call) {
            this.call = call;
        }

        public void dispose() {
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }

    CallObservable(Call<T> call) {
        this.originalCall = call;
    }

    protected void subscribeActual(Observer<? super Response<T>> observer) {
        Throwable th;
        int i;
        Call clone = this.originalCall.clone();
        observer.onSubscribe(new CallDisposable(clone));
        try {
            Response execute = clone.execute();
            if (!clone.isCanceled()) {
                observer.onNext(execute);
            }
            if (!clone.isCanceled()) {
                try {
                    observer.onComplete();
                } catch (Throwable th2) {
                    th = th2;
                    i = 1;
                    Exceptions.throwIfFatal(th);
                    if (i != 0) {
                        RxJavaPlugins.onError(th);
                    } else if (!clone.isCanceled()) {
                        try {
                            observer.onError(th);
                        } catch (Observer<? super Response<T>> observer2) {
                            Exceptions.throwIfFatal(observer2);
                            RxJavaPlugins.onError(new CompositeException(th, observer2));
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
            Exceptions.throwIfFatal(th);
            if (i != 0) {
                RxJavaPlugins.onError(th);
            } else if (!clone.isCanceled()) {
                observer2.onError(th);
            }
        }
    }
}
