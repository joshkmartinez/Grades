package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    static final class DetachObserver<T> implements Observer<T>, Disposable {
        Observer<? super T> actual;
        Disposable f123s;

        DetachObserver(Observer<? super T> observer) {
            this.actual = observer;
        }

        public void dispose() {
            Disposable disposable = this.f123s;
            this.f123s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asObserver();
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f123s.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f123s, disposable)) {
                this.f123s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            Observer observer = this.actual;
            this.f123s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asObserver();
            observer.onError(th);
        }

        public void onComplete() {
            Observer observer = this.actual;
            this.f123s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asObserver();
            observer.onComplete();
        }
    }

    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DetachObserver(observer));
    }
}
