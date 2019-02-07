package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_MainFragmentInteractorFactory;
import com.aeries.mobileportal.dagger.modules.MainFragmentModule;
import com.aeries.mobileportal.dagger.modules.MainFragmentModule_MainFragmentPresenterFactory;
import com.aeries.mobileportal.dagger.modules.MainFragmentModule_StudentDetailsAdapterFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_NotificationsRepoFactory;
import com.aeries.mobileportal.interactors.MainFragmentInteractor;
import com.aeries.mobileportal.presenters.MainFragmentPresenter;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.fragments.MainFragment;
import com.aeries.mobileportal.views.fragments.MainFragment_MembersInjector;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerMainFragmentComponent implements MainFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<MainFragmentInteractor> mainFragmentInteractorProvider;
    private MembersInjector<MainFragment> mainFragmentMembersInjector;
    private Provider<MainFragmentPresenter> mainFragmentPresenterProvider;
    private Provider<NotificationService> notificationServiceProvider;
    private Provider<NotificationsRepo> notificationsRepoProvider;
    private Provider<StudentDetailsAdapter> studentDetailsAdapterProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private MainFragmentModule mainFragmentModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public MainFragmentComponent build() {
            if (this.mainFragmentModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerMainFragmentComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(MainFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder mainFragmentModule(MainFragmentModule mainFragmentModule) {
            this.mainFragmentModule = (MainFragmentModule) Preconditions.checkNotNull(mainFragmentModule);
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

    private static class C0697x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0697x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0698x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0698x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0699x9b984408 implements Provider<NotificationService> {
        private final PSPComponent pSPComponent;

        C0699x9b984408(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public NotificationService get() {
            return (NotificationService) Preconditions.checkNotNull(this.pSPComponent.notificationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0700xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0700xa10b3e48(PSPComponent pSPComponent) {
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

    private DaggerMainFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.studentDetailsAdapterProvider = DoubleCheck.provider(MainFragmentModule_StudentDetailsAdapterFactory.create(builder.mainFragmentModule));
        this.configurationRepoProvider = new C0698x2fda2dc6(builder.pSPComponent);
        this.notificationsRepoProvider = RepoModule_NotificationsRepoFactory.create(builder.repoModule);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.notificationServiceProvider = new C0699x9b984408(builder.pSPComponent);
        this.checkApplicationServiceProvider = new C0697x81c4dc2b(builder.pSPComponent);
        this.tokenProvider = new C0700xa10b3e48(builder.pSPComponent);
        this.mainFragmentInteractorProvider = DoubleCheck.provider(InteractorModule_MainFragmentInteractorFactory.create(builder.interactorModule, this.configurationRepoProvider, this.notificationsRepoProvider, this.userRepoProvider, this.notificationServiceProvider, this.checkApplicationServiceProvider, this.tokenProvider));
        this.mainFragmentPresenterProvider = DoubleCheck.provider(MainFragmentModule_MainFragmentPresenterFactory.create(builder.mainFragmentModule, this.mainFragmentInteractorProvider));
        this.mainFragmentMembersInjector = MainFragment_MembersInjector.create(this.studentDetailsAdapterProvider, this.mainFragmentPresenterProvider);
    }

    public void inject(MainFragment mainFragment) {
        this.mainFragmentMembersInjector.injectMembers(mainFragment);
    }
}
