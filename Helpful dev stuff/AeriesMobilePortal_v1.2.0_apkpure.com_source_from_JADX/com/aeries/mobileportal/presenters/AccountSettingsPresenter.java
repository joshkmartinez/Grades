package com.aeries.mobileportal.presenters;

import com.aeries.mobileportal.interactors.AccountSettingsCallback;
import com.aeries.mobileportal.interactors.AccountSettingsInteractor;
import com.aeries.mobileportal.views.viewmodels.AccountSettingsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/aeries/mobileportal/presenters/AccountSettingsPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/AccountSettingsViewModel;", "Lcom/aeries/mobileportal/interactors/AccountSettingsCallback;", "vm", "interactor", "Lcom/aeries/mobileportal/interactors/AccountSettingsInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/AccountSettingsViewModel;Lcom/aeries/mobileportal/interactors/AccountSettingsInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/AccountSettingsInteractor;", "getVm", "()Lcom/aeries/mobileportal/views/viewmodels/AccountSettingsViewModel;", "getSettings", "", "onCreate", "onSettingsRetreived", "settings", "", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AccountSettingsPresenter.kt */
public final class AccountSettingsPresenter extends BasePresenter<AccountSettingsViewModel> implements AccountSettingsCallback {
    @NotNull
    private final AccountSettingsInteractor interactor;
    @NotNull
    private final AccountSettingsViewModel vm;

    public void onCreate() {
    }

    @NotNull
    public final AccountSettingsInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final AccountSettingsViewModel getVm() {
        return this.vm;
    }

    public AccountSettingsPresenter(@NotNull AccountSettingsViewModel accountSettingsViewModel, @NotNull AccountSettingsInteractor accountSettingsInteractor) {
        Intrinsics.checkParameterIsNotNull(accountSettingsViewModel, "vm");
        Intrinsics.checkParameterIsNotNull(accountSettingsInteractor, "interactor");
        super(accountSettingsViewModel, accountSettingsInteractor);
        this.vm = accountSettingsViewModel;
        this.interactor = accountSettingsInteractor;
    }

    public final void getSettings() {
        this.interactor.getSettings(this);
    }

    public void onSettingsRetreived(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "settings");
        this.vm.showSettings(list);
    }
}
