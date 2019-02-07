package com.aeries.mobileportal.dagger.components;

import android.content.Context;
import com.aeries.mobileportal.adapters.NotificationsAdapter;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_NotificationsInteractorFactory;
import com.aeries.mobileportal.dagger.modules.NotificationsFragmentModule;
import com.aeries.mobileportal.dagger.modules.NotificationsFragmentModule_NotificationsAdapterFactory;
import com.aeries.mobileportal.dagger.modules.NotificationsFragmentModule_NotificationsPresenterFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_NotificationsRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.interactors.notifications.NotificationsInteractor;
import com.aeries.mobileportal.presenters.NotificationsPresenter;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.fragments.NotificationsFragment;
import com.aeries.mobileportal.views.fragments.NotificationsFragment_MembersInjector;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerNotificationsFragmentComponent implements NotificationsFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<Context> contextProvider;
    private Provider<NotificationService> notificationServiceProvider;
    private Provider<NotificationsAdapter> notificationsAdapterProvider;
    private MembersInjector<NotificationsFragment> notificationsFragmentMembersInjector;
    private Provider<NotificationsInteractor> notificationsInteractorProvider;
    private Provider<NotificationsPresenter> notificationsPresenterProvider;
    private Provider<NotificationsRepo> notificationsRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private NotificationsFragmentModule notificationsFragmentModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public NotificationsFragmentComponent build() {
            if (this.notificationsFragmentModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerNotificationsFragmentComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(NotificationsFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder notificationsFragmentModule(NotificationsFragmentModule notificationsFragmentModule) {
            this.notificationsFragmentModule = (NotificationsFragmentModule) Preconditions.checkNotNull(notificationsFragmentModule);
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

    private static class C0705x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0705x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0706x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0706x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
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

    private static class C0707x9b984408 implements Provider<NotificationService> {
        private final PSPComponent pSPComponent;

        C0707x9b984408(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public NotificationService get() {
            return (NotificationService) Preconditions.checkNotNull(this.pSPComponent.notificationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0708xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0708xa10b3e48(PSPComponent pSPComponent) {
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

    private DaggerNotificationsFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.notificationsAdapterProvider = DoubleCheck.provider(NotificationsFragmentModule_NotificationsAdapterFactory.create(builder.notificationsFragmentModule));
        this.configurationRepoProvider = new C0706x2fda2dc6(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.notificationServiceProvider = new C0707x9b984408(builder.pSPComponent);
        this.notificationsRepoProvider = RepoModule_NotificationsRepoFactory.create(builder.repoModule);
        this.checkApplicationServiceProvider = new C0705x81c4dc2b(builder.pSPComponent);
        this.tokenProvider = new C0708xa10b3e48(builder.pSPComponent);
        this.contextProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_context(builder.pSPComponent);
        this.notificationsInteractorProvider = DoubleCheck.provider(InteractorModule_NotificationsInteractorFactory.create(builder.interactorModule, this.configurationRepoProvider, this.userRepoProvider, this.schoolRepoProvider, this.notificationServiceProvider, this.notificationsRepoProvider, this.checkApplicationServiceProvider, this.tokenProvider, this.contextProvider));
        this.notificationsPresenterProvider = DoubleCheck.provider(NotificationsFragmentModule_NotificationsPresenterFactory.create(builder.notificationsFragmentModule, this.notificationsInteractorProvider));
        this.notificationsFragmentMembersInjector = NotificationsFragment_MembersInjector.create(this.notificationsAdapterProvider, this.notificationsPresenterProvider);
    }

    public void inject(NotificationsFragment notificationsFragment) {
        this.notificationsFragmentMembersInjector.injectMembers(notificationsFragment);
    }
}
