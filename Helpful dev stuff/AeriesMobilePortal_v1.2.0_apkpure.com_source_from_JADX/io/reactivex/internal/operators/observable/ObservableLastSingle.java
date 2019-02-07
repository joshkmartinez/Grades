package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {
    final T defaultItem;
    final ObservableSource<T> source;

    static final class LastObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> actual;
        final T defaultItem;
        T item;
        Disposable f139s;

        LastObserver(SingleObserver<? super T> singleObserver, T t) {
            this.actual = singleObserver;
            this.defaultItem = t;
        }

        public void dispose() {
            this.f139s.dispose();
            this.f139s = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f139s == DisposableHelper.DISPOSED;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f139s, disposable)) {
                this.f139s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.item = t;
        }

        public void onError(Throwable th) {
            this.f139s = DisposableHelper.DISPOSED;
            this.item = null;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f139s = DisposableHelper.DISPOSED;
            Object obj = this.item;
            if (obj != null) {
                this.item = null;
                this.actual.onSuccess(obj);
                return;
            }
            obj = this.defaultItem;
            if (obj != null) {
                this.actual.onSuccess(obj);
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t) {
        this.source = observableSource;
        this.defaultItem = t;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new LastObserver(singleObserver, this.defaultItem));
    }
}
