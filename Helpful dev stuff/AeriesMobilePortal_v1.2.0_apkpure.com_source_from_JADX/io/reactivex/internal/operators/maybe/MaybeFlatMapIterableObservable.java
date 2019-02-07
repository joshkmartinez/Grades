package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final MaybeSource<T> source;

    static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {
        final Observer<? super R> actual;
        volatile boolean cancelled;
        Disposable f321d;
        volatile Iterator<? extends R> it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.actual = observer;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f321d, disposable)) {
                this.f321d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            Observer observer = this.actual;
            try {
                t = ((Iterable) this.mapper.apply(t)).iterator();
                if (t.hasNext()) {
                    this.it = t;
                    if (this.outputFused) {
                        observer.onNext(null);
                        observer.onComplete();
                        return;
                    }
                    while (!this.cancelled) {
                        try {
                            observer.onNext(t.next());
                            if (!this.cancelled) {
                                try {
                                    if (!t.hasNext()) {
                                        observer.onComplete();
                                        return;
                                    }
                                } catch (T t2) {
                                    Exceptions.throwIfFatal(t2);
                                    observer.onError(t2);
                                    return;
                                }
                            }
                            return;
                        } catch (T t22) {
                            Exceptions.throwIfFatal(t22);
                            observer.onError(t22);
                            return;
                        }
                    }
                    return;
                }
                observer.onComplete();
            } catch (T t222) {
                Exceptions.throwIfFatal(t222);
                observer.onError(t222);
            }
        }

        public void onError(Throwable th) {
            this.f321d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void dispose() {
            this.cancelled = true;
            this.f321d.dispose();
            this.f321d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public void clear() {
            this.it = null;
        }

        public boolean isEmpty() {
            return this.it == null;
        }

        @Nullable
        public R poll() throws Exception {
            Iterator it = this.it;
            if (it == null) {
                return null;
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return requireNonNull;
        }
    }

    public MaybeFlatMapIterableObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlatMapIterableObserver(observer, this.mapper));
    }
}
