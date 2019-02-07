package com.aeries.mobileportal.presenters.settings;

import com.aeries.mobileportal.interactors.settings.SettingsCallback;
import com.aeries.mobileportal.interactors.settings.SettingsInteractor;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.settings.SettingsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/presenters/settings/SettingsPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/settings/SettingsViewModel;", "Lcom/aeries/mobileportal/interactors/settings/SettingsCallback;", "settingsVM", "interactor", "Lcom/aeries/mobileportal/interactors/settings/SettingsInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/settings/SettingsViewModel;Lcom/aeries/mobileportal/interactors/settings/SettingsInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/settings/SettingsInteractor;", "getSettingsVM", "()Lcom/aeries/mobileportal/views/viewmodels/settings/SettingsViewModel;", "getNotificationsSize", "", "onCreate", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SettingsPresenter.kt */
public final class SettingsPresenter extends BasePresenter<SettingsViewModel> implements SettingsCallback {
    @NotNull
    private final SettingsInteractor interactor;
    @NotNull
    private final SettingsViewModel settingsVM;

    public void onCreate() {
    }

    @NotNull
    public final SettingsInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final SettingsViewModel getSettingsVM() {
        return this.settingsVM;
    }

    public SettingsPresenter(@NotNull SettingsViewModel settingsViewModel, @NotNull SettingsInteractor settingsInteractor) {
        Intrinsics.checkParameterIsNotNull(settingsViewModel, "settingsVM");
        Intrinsics.checkParameterIsNotNull(settingsInteractor, "interactor");
        super(settingsViewModel, settingsInteractor);
        this.settingsVM = settingsViewModel;
        this.interactor = settingsInteractor;
    }

    public final int getNotificationsSize() {
        return this.interactor.getNewNotificationsSize();
    }
}
