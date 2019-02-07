package com.aeries.mobileportal.interactors;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\u00020\b*\u00020\nH\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/interactors/BaseInteractor;", "", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "cancelRequests", "", "addToCompositeDisposable", "Lio/reactivex/disposables/Disposable;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: BaseInteractor.kt */
public abstract class BaseInteractor {
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();

    @NotNull
    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public final void cancelRequests() {
        if (!this.disposables.isDisposed()) {
            this.disposables.dispose();
        }
    }

    protected final void addToCompositeDisposable(@NotNull Disposable disposable) {
        Intrinsics.checkParameterIsNotNull(disposable, "$receiver");
        this.disposables.add(disposable);
    }
}
