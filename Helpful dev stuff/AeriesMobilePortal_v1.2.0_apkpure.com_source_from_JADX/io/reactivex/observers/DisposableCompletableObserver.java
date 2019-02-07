package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableCompletableObserver implements CompletableObserver, Disposable {
    final AtomicReference<Disposable> f205s = new AtomicReference();

    protected void onStart() {
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f205s, disposable, getClass()) != null) {
            onStart();
        }
    }

    public final boolean isDisposed() {
        return this.f205s.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f205s);
    }
}
