package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.SettingsAdapter;
import com.aeries.mobileportal.adapters.SettingsAdapter.SettingsListener;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_AccountSettingsInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.SettingsAdapterModule;
import com.aeries.mobileportal.dagger.modules.SettingsAdapterModule_SettingsAdapterFactory;
import com.aeries.mobileportal.dagger.modules.SettingsAdapterModule_SettingsListenerFactory;
import com.aeries.mobileportal.dagger.modules.SettingsAdapterModule_SettingsPresenterFactory;
import com.aeries.mobileportal.interactors.AccountSettingsInteractor;
import com.aeries.mobileportal.presenters.AccountSettingsPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.views.fragments.AccountSettingsFragment;
import com.aeries.mobileportal.views.fragments.AccountSettingsFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAccountSettingsFragmentComponent implements AccountSettingsFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<AccountSettingsFragment> accountSettingsFragmentMembersInjector;
    private Provider<AccountSettingsInteractor> accountSettingsInteractorProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<SettingsAdapter> settingsAdapterProvider;
    private Provider<SettingsListener> settingsListenerProvider;
    private Provider<AccountSettingsPresenter> settingsPresenterProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;
        private SettingsAdapterModule settingsAdapterModule;

        private Builder() {
        }

        public AccountSettingsFragmentComponent build() {
            if (this.settingsAdapterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerAccountSettingsFragmentComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(SettingsAdapterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder settingsAdapterModule(SettingsAdapterModule settingsAdapterModule) {
            this.settingsAdapterModule = (SettingsAdapterModule) Preconditions.checkNotNull(settingsAdapterModule);
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

    private static class C0615x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0615x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerAccountSettingsFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.settingsListenerProvider = DoubleCheck.provider(SettingsAdapterModule_SettingsListenerFactory.create(builder.settingsAdapterModule));
        this.settingsAdapterProvider = DoubleCheck.provider(SettingsAdapterModule_SettingsAdapterFactory.create(builder.settingsAdapterModule, this.settingsListenerProvider));
        this.configurationRepoProvider = new C0615x2fda2dc6(builder.pSPComponent);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.accountSettingsInteractorProvider = DoubleCheck.provider(InteractorModule_AccountSettingsInteractorFactory.create(builder.interactorModule, this.configurationRepoProvider, this.schoolRepoProvider));
        this.settingsPresenterProvider = DoubleCheck.provider(SettingsAdapterModule_SettingsPresenterFactory.create(builder.settingsAdapterModule, this.accountSettingsInteractorProvider));
        this.accountSettingsFragmentMembersInjector = AccountSettingsFragment_MembersInjector.create(this.settingsAdapterProvider, this.settingsPresenterProvider);
    }

    public void inject(AccountSettingsFragment accountSettingsFragment) {
        this.accountSettingsFragmentMembersInjector.injectMembers(accountSettingsFragment);
    }
}
