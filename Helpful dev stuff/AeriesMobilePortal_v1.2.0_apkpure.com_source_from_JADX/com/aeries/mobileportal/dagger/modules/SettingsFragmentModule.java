package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.aeries.mobileportal.adapters.SettingsViewPagerAdapter;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.settings.SettingsInteractor;
import com.aeries.mobileportal.presenters.settings.SettingsPresenter;
import com.aeries.mobileportal.views.viewmodels.settings.SettingsViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0002\u001a\u00020\u0003H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/SettingsFragmentModule;", "", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "notificationsEnabled", "", "isStudent", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/settings/SettingsViewModel;", "(Landroid/support/v4/app/FragmentManager;ZZLcom/aeries/mobileportal/views/viewmodels/settings/SettingsViewModel;)V", "getFragmentManager", "()Landroid/support/v4/app/FragmentManager;", "()Z", "getNotificationsEnabled", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/settings/SettingsViewModel;", "settingsPresenter", "Lcom/aeries/mobileportal/presenters/settings/SettingsPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/settings/SettingsInteractor;", "settingsViewPagerAdapter", "Lcom/aeries/mobileportal/adapters/SettingsViewPagerAdapter;", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: SettingsFragmentModule.kt */
public final class SettingsFragmentModule {
    @NotNull
    private final FragmentManager fragmentManager;
    private final boolean isStudent;
    private final boolean notificationsEnabled;
    @NotNull
    private final SettingsViewModel viewModel;

    public SettingsFragmentModule(@NotNull FragmentManager fragmentManager, boolean z, boolean z2, @NotNull SettingsViewModel settingsViewModel) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
        Intrinsics.checkParameterIsNotNull(settingsViewModel, "viewModel");
        this.fragmentManager = fragmentManager;
        this.notificationsEnabled = z;
        this.isStudent = z2;
        this.viewModel = settingsViewModel;
    }

    @NotNull
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final boolean getNotificationsEnabled() {
        return this.notificationsEnabled;
    }

    public final boolean isStudent() {
        return this.isStudent;
    }

    @NotNull
    public final SettingsViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final FragmentManager fragmentManager() {
        return this.fragmentManager;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SettingsViewPagerAdapter settingsViewPagerAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
        return new SettingsViewPagerAdapter(context, fragmentManager, this.notificationsEnabled, this.isStudent);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SettingsPresenter settingsPresenter(@NotNull SettingsInteractor settingsInteractor) {
        Intrinsics.checkParameterIsNotNull(settingsInteractor, "interactor");
        return new SettingsPresenter(this.viewModel, settingsInteractor);
    }
}
