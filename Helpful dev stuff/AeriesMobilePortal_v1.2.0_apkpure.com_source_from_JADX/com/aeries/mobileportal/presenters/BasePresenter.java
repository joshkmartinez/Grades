package com.aeries.mobileportal.presenters;

import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH&J\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/presenters/BasePresenter;", "T", "Lcom/aeries/mobileportal/views/BaseViewModel;", "Lcom/aeries/mobileportal/presenters/Presenter;", "viewModel", "interactor", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "(Lcom/aeries/mobileportal/views/BaseViewModel;Lcom/aeries/mobileportal/interactors/BaseInteractor;)V", "Lcom/aeries/mobileportal/views/BaseViewModel;", "attachVM", "", "onCreate", "onDestroy", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: BasePresenter.kt */
public abstract class BasePresenter<T extends BaseViewModel> extends Presenter<T> {
    private final BaseInteractor interactor;
    private final T viewModel;

    public abstract void onCreate();

    public BasePresenter(@NotNull T t, @NotNull BaseInteractor baseInteractor) {
        Intrinsics.checkParameterIsNotNull(t, "viewModel");
        Intrinsics.checkParameterIsNotNull(baseInteractor, "interactor");
        this.viewModel = t;
        this.interactor = baseInteractor;
    }

    public final void attachVM() {
        attachView(this.viewModel);
    }

    public final void onDestroy() {
        detachView();
        this.interactor.cancelRequests();
    }
}
