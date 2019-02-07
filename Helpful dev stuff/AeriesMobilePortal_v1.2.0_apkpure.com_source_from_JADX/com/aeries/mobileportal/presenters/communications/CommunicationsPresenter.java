package com.aeries.mobileportal.presenters.communications;

import com.aeries.mobileportal.interactors.communications.CommunicationsCallback;
import com.aeries.mobileportal.interactors.communications.CommunicationsInteractor;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.communications.CommunicationsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/presenters/communications/CommunicationsPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/communications/CommunicationsViewModel;", "Lcom/aeries/mobileportal/interactors/communications/CommunicationsCallback;", "communicationsViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/communications/CommunicationsInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/communications/CommunicationsViewModel;Lcom/aeries/mobileportal/interactors/communications/CommunicationsInteractor;)V", "getCommunicationsViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/communications/CommunicationsViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/communications/CommunicationsInteractor;", "cancelRequests", "", "getSignalKitUrl", "onCreate", "onErrorReceived", "error", "", "onNetworkError", "e", "", "onURLReceived", "url", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CommunicationsPresenter.kt */
public final class CommunicationsPresenter extends BasePresenter<CommunicationsViewModel> implements CommunicationsCallback {
    @NotNull
    private final CommunicationsViewModel communicationsViewModel;
    @NotNull
    private final CommunicationsInteractor interactor;

    public CommunicationsPresenter(@NotNull CommunicationsViewModel communicationsViewModel, @NotNull CommunicationsInteractor communicationsInteractor) {
        Intrinsics.checkParameterIsNotNull(communicationsViewModel, "communicationsViewModel");
        Intrinsics.checkParameterIsNotNull(communicationsInteractor, "interactor");
        super(communicationsViewModel, communicationsInteractor);
        this.communicationsViewModel = communicationsViewModel;
        this.interactor = communicationsInteractor;
    }

    @NotNull
    public final CommunicationsViewModel getCommunicationsViewModel() {
        return this.communicationsViewModel;
    }

    @NotNull
    public final CommunicationsInteractor getInteractor() {
        return this.interactor;
    }

    public final void getSignalKitUrl() {
        this.interactor.getSignalKitUrl(this);
    }

    public final void cancelRequests() {
        this.interactor.cancelRequests();
    }

    public void onURLReceived(@Nullable String str) {
        CommunicationsViewModel communicationsViewModel = this.communicationsViewModel;
        if (str == null) {
            str = "";
        }
        communicationsViewModel.showWebView(str);
    }

    public void onErrorReceived(@Nullable String str) {
        CommunicationsViewModel communicationsViewModel = this.communicationsViewModel;
        if (str == null) {
            str = "";
        }
        communicationsViewModel.showFailureMessage(str);
    }

    public void onNetworkError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        th.printStackTrace();
        CommunicationsViewModel communicationsViewModel = this.communicationsViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "";
        }
        communicationsViewModel.showErrorMessage(th);
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }
}
