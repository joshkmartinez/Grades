package com.aeries.mobileportal.dagger.components;

import android.accounts.AccountManager;
import com.aeries.mobileportal.dagger.modules.ChangePasswordPresenterModule;
import com.aeries.mobileportal.dagger.modules.ChangePasswordPresenterModule_ChangePasswordPresenterFactory;
import com.aeries.mobileportal.dagger.modules.ChangePasswordPresenterModule_ChangePasswordViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_ChangePasswordInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.change_password.ChangePasswordInteractor;
import com.aeries.mobileportal.presenters.change_password.ChangePasswordPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.ChangePasswordActivity;
import com.aeries.mobileportal.views.activities.ChangePasswordActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.change_password.ChangePasswordViewModel;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.PasswordService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerChangePasswordActivityComponent implements ChangePasswordActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AccountManager> accountManagerProvider;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private MembersInjector<ChangePasswordActivity> changePasswordActivityMembersInjector;
    private Provider<ChangePasswordInteractor> changePasswordInteractorProvider;
    private Provider<ChangePasswordPresenter> changePasswordPresenterProvider;
    private Provider<ChangePasswordViewModel> changePasswordViewModelProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<PasswordService> passwordServiceProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private ChangePasswordPresenterModule changePasswordPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public ChangePasswordActivityComponent build() {
            if (this.changePasswordPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerChangePasswordActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(ChangePasswordPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder changePasswordPresenterModule(ChangePasswordPresenterModule changePasswordPresenterModule) {
            this.changePasswordPresenterModule = (ChangePasswordPresenterModule) Preconditions.checkNotNull(changePasswordPresenterModule);
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

    private static class C0636xd5c90542 implements Provider<AccountManager> {
        private final PSPComponent pSPComponent;

        C0636xd5c90542(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AccountManager get() {
            return (AccountManager) Preconditions.checkNotNull(this.pSPComponent.accountManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0637x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0637x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0638x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0638x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0639xc236db58 implements Provider<PasswordService> {
        private final PSPComponent pSPComponent;

        C0639xc236db58(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public PasswordService get() {
            return (PasswordService) Preconditions.checkNotNull(this.pSPComponent.passwordService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0640xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0640xa10b3e48(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public TokenProvider get() {
            return (TokenProvider) Preconditions.checkNotNull(this.pSPComponent.tokenProvider(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_aeries_mobileportal_dagger_components_PSPComponent_userRepo implements Provider<UserRepository> {
        private final PSPComponent pSPComponent;

        com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public UserRepository get() {
            return (UserRepository) Preconditions.checkNotNull(this.pSPComponent.userRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerChangePasswordActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.changePasswordViewModelProvider = DoubleCheck.provider(ChangePasswordPresenterModule_ChangePasswordViewModelFactory.create(builder.changePasswordPresenterModule));
        this.analyticsServiceProvider = new C0637x70a50c51(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0638x2fda2dc6(builder.pSPComponent);
        this.tokenProvider = new C0640xa10b3e48(builder.pSPComponent);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.passwordServiceProvider = new C0639xc236db58(builder.pSPComponent);
        this.accountManagerProvider = new C0636xd5c90542(builder.pSPComponent);
        this.changePasswordInteractorProvider = DoubleCheck.provider(InteractorModule_ChangePasswordInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.userRepoProvider, this.configurationRepoProvider, this.tokenProvider, this.schoolRepoProvider, this.studentRepoProvider, this.passwordServiceProvider, this.accountManagerProvider));
        this.changePasswordPresenterProvider = DoubleCheck.provider(ChangePasswordPresenterModule_ChangePasswordPresenterFactory.create(builder.changePasswordPresenterModule, this.changePasswordViewModelProvider, this.changePasswordInteractorProvider));
        this.changePasswordActivityMembersInjector = ChangePasswordActivity_MembersInjector.create(this.changePasswordPresenterProvider);
    }

    public void inject(ChangePasswordActivity changePasswordActivity) {
        this.changePasswordActivityMembersInjector.injectMembers(changePasswordActivity);
    }
}
