package com.aeries.mobileportal.dagger.components;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.aeries.mobileportal.adapters.SettingsViewPagerAdapter;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_SettingsInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_NotificationsRepoFactory;
import com.aeries.mobileportal.dagger.modules.SettingsFragmentModule;
import com.aeries.mobileportal.dagger.modules.SettingsFragmentModule_FragmentManagerFactory;
import com.aeries.mobileportal.dagger.modules.SettingsFragmentModule_SettingsPresenterFactory;
import com.aeries.mobileportal.dagger.modules.SettingsFragmentModule_SettingsViewPagerAdapterFactory;
import com.aeries.mobileportal.interactors.settings.SettingsInteractor;
import com.aeries.mobileportal.presenters.settings.SettingsPresenter;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.views.fragments.SettingsFragment;
import com.aeries.mobileportal.views.fragments.SettingsFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerSettingsFragmentComponent implements SettingsFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<Context> contextProvider;
    private Provider<FragmentManager> fragmentManagerProvider;
    private Provider<NotificationsRepo> notificationsRepoProvider;
    private MembersInjector<SettingsFragment> settingsFragmentMembersInjector;
    private Provider<SettingsInteractor> settingsInteractorProvider;
    private Provider<SettingsPresenter> settingsPresenterProvider;
    private Provider<SettingsViewPagerAdapter> settingsViewPagerAdapterProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;
        private SettingsFragmentModule settingsFragmentModule;

        private Builder() {
        }

        public SettingsFragmentComponent build() {
            if (this.settingsFragmentModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerSettingsFragmentComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(SettingsFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder settingsFragmentModule(SettingsFragmentModule settingsFragmentModule) {
            this.settingsFragmentModule = (SettingsFragmentModule) Preconditions.checkNotNull(settingsFragmentModule);
            return this;
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder repoModule(RepoModule repoModule) {
            this.repoModule = (RepoModule) Preconditions.checkNotNull(repoModule);
            return this;
        }

        public Builder pSPComponent(PSPComponent pSPComponent) {
            this.pSPComponent = (PSPComponent) Preconditions.checkNotNull(pSPComponent);
            return this;
        }
    }

    private static class com_aeries_mobileportal_dagger_components_PSPComponent_context implements Provider<Context> {
        private final PSPComponent pSPComponent;

        com_aeries_mobileportal_dagger_components_PSPComponent_context(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public Context get() {
            return (Context) Preconditions.checkNotNull(this.pSPComponent.context(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerSettingsFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.contextProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_context(builder.pSPComponent);
        this.fragmentManagerProvider = DoubleCheck.provider(SettingsFragmentModule_FragmentManagerFactory.create(builder.settingsFragmentModule));
        this.settingsViewPagerAdapterProvider = DoubleCheck.provider(SettingsFragmentModule_SettingsViewPagerAdapterFactory.create(builder.settingsFragmentModule, this.contextProvider, this.fragmentManagerProvider));
        this.notificationsRepoProvider = RepoModule_NotificationsRepoFactory.create(builder.repoModule);
        this.settingsInteractorProvider = DoubleCheck.provider(InteractorModule_SettingsInteractorFactory.create(builder.interactorModule, this.notificationsRepoProvider));
        this.settingsPresenterProvider = DoubleCheck.provider(SettingsFragmentModule_SettingsPresenterFactory.create(builder.settingsFragmentModule, this.settingsInteractorProvider));
        this.settingsFragmentMembersInjector = SettingsFragment_MembersInjector.create(this.settingsViewPagerAdapterProvider, this.settingsPresenterProvider);
    }

    public void inject(SettingsFragment settingsFragment) {
        this.settingsFragmentMembersInjector.injectMembers(settingsFragment);
    }
}
