package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final ObservableSource<? extends U> other;

    final class WithLastFrom implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> wlf;

        public void onComplete() {
        }

        WithLastFrom(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.wlf = withLatestFromObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.wlf.setOther(disposable);
        }

        public void onNext(U u) {
            this.wlf.lazySet(u);
        }

        public void onError(Throwable th) {
            this.wlf.otherError(th);
        }
    }

    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final Observer<? super R> actual;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<Disposable> other = new AtomicReference();
        final AtomicReference<Disposable> f181s = new AtomicReference();

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.actual = observer;
            this.combiner = biFunction;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f181s, disposable);
        }

        public void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.actual.onNext(ObjectHelper.requireNonNull(this.combiner.apply(t, obj), "The combiner returned a null value"));
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    dispose();
                    this.actual.onError(t2);
                }
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.actual.onError(th);
        }

        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.actual.onComplete();
        }

        public void dispose() {
            DisposableHelper.dispose(this.f181s);
            DisposableHelper.dispose(this.other);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f181s.get());
        }

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }

        public void otherError(Throwable th) {
            DisposableHelper.dispose(this.f181s);
            this.actual.onError(th);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.combiner = biFunction;
        this.other = observableSource2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        Object serializedObserver = new SerializedObserver(observer);
        observer = new WithLatestFromObserver(serializedObserver, this.combiner);
        serializedObserver.onSubscribe(observer);
        this.other.subscribe(new WithLastFrom(observer));
        this.source.subscribe(observer);
    }
}
