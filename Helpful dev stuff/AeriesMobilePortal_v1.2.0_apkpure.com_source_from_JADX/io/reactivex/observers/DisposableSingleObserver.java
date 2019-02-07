package io.reactivex.observers;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableSingleObserver<T> implements SingleObserver<T>, Disposable {
    final AtomicReference<Disposable> f208s = new AtomicReference();

    protected void onStart() {
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f208s, disposable, getClass()) != null) {
            onStart();
        }
    }

    public final boolean isDisposed() {
        return this.f208s.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f208s);
    }
}
