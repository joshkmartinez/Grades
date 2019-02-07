package com.aeries.mobileportal.presenters;

import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\fJ\r\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/presenters/Presenter;", "T", "Lcom/aeries/mobileportal/views/BaseViewModel;", "", "()V", "mViewModel", "getMViewModel", "()Lcom/aeries/mobileportal/views/BaseViewModel;", "setMViewModel", "(Lcom/aeries/mobileportal/views/BaseViewModel;)V", "Lcom/aeries/mobileportal/views/BaseViewModel;", "attachView", "", "viewModel", "detachView", "getView", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Presenter.kt */
public abstract class Presenter<T extends BaseViewModel> {
    @Nullable
    private T mViewModel;

    @Nullable
    public final T getMViewModel() {
        return this.mViewModel;
    }

    public final void setMViewModel(@Nullable T t) {
        this.mViewModel = t;
    }

    public final void attachView(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "viewModel");
        this.mViewModel = t;
    }

    public final void detachView() {
        this.mViewModel = (BaseViewModel) null;
    }

    @Nullable
    public final T getView() {
        return this.mViewModel;
    }
}
