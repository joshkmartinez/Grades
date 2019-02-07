package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable f204s;

    protected void onStart() {
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.validate(this.f204s, disposable, getClass())) {
            this.f204s = disposable;
            onStart();
        }
    }

    protected final void cancel() {
        Disposable disposable = this.f204s;
        this.f204s = DisposableHelper.DISPOSED;
        disposable.dispose();
    }
}
