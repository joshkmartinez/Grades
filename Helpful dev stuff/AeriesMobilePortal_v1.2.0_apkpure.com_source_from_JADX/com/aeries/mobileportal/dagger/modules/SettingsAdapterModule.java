package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.SettingsAdapter;
import com.aeries.mobileportal.adapters.SettingsAdapter.SettingsListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.AccountSettingsInteractor;
import com.aeries.mobileportal.presenters.AccountSettingsPresenter;
import com.aeries.mobileportal.views.viewmodels.AccountSettingsViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\r\u001a\u00020\u0003H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/SettingsAdapterModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingsListener;", "vm", "Lcom/aeries/mobileportal/views/viewmodels/AccountSettingsViewModel;", "(Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingsListener;Lcom/aeries/mobileportal/views/viewmodels/AccountSettingsViewModel;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingsListener;", "getVm", "()Lcom/aeries/mobileportal/views/viewmodels/AccountSettingsViewModel;", "settingsAdapter", "Lcom/aeries/mobileportal/adapters/SettingsAdapter;", "settingsListener", "settingsPresenter", "Lcom/aeries/mobileportal/presenters/AccountSettingsPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/AccountSettingsInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: SettingsAdapterModule.kt */
public final class SettingsAdapterModule {
    @NotNull
    private final SettingsListener listener;
    @NotNull
    private final AccountSettingsViewModel vm;

    public SettingsAdapterModule(@NotNull SettingsListener settingsListener, @NotNull AccountSettingsViewModel accountSettingsViewModel) {
        Intrinsics.checkParameterIsNotNull(settingsListener, CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(accountSettingsViewModel, "vm");
        this.listener = settingsListener;
        this.vm = accountSettingsViewModel;
    }

    @NotNull
    public final SettingsListener getListener() {
        return this.listener;
    }

    @NotNull
    public final AccountSettingsViewModel getVm() {
        return this.vm;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SettingsListener settingsListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SettingsAdapter settingsAdapter(@NotNull SettingsListener settingsListener) {
        Intrinsics.checkParameterIsNotNull(settingsListener, CastExtraArgs.LISTENER);
        return new SettingsAdapter(settingsListener);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AccountSettingsPresenter settingsPresenter(@NotNull AccountSettingsInteractor accountSettingsInteractor) {
        Intrinsics.checkParameterIsNotNull(accountSettingsInteractor, "interactor");
        return new AccountSettingsPresenter(this.vm, accountSettingsInteractor);
    }
}
