package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_LinkStudentInteractorFactory;
import com.aeries.mobileportal.dagger.modules.LinkStudentPresenterModule;
import com.aeries.mobileportal.dagger.modules.LinkStudentPresenterModule_LinkStudentPresenterFactory;
import com.aeries.mobileportal.dagger.modules.LinkStudentPresenterModule_LinkStudentViewModelFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.link_student.LinkStudentInteractor;
import com.aeries.mobileportal.presenters.link_student.LinkStudentPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.LinkStudentActivity;
import com.aeries.mobileportal.views.activities.LinkStudentActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.link_student.LinkStudentViewModel;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.LinkStudentService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerLinkStudentActivityComponent implements LinkStudentActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<GoogleSignInClient> googleSignInClientProvider;
    private MembersInjector<LinkStudentActivity> linkStudentActivityMembersInjector;
    private Provider<LinkStudentInteractor> linkStudentInteractorProvider;
    private Provider<LinkStudentPresenter> linkStudentPresenterProvider;
    private Provider<LinkStudentService> linkStudentServiceProvider;
    private Provider<LinkStudentViewModel> linkStudentViewModelProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private LinkStudentPresenterModule linkStudentPresenterModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public LinkStudentActivityComponent build() {
            if (this.linkStudentPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerLinkStudentActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(LinkStudentPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder linkStudentPresenterModule(LinkStudentPresenterModule linkStudentPresenterModule) {
            this.linkStudentPresenterModule = (LinkStudentPresenterModule) Preconditions.checkNotNull(linkStudentPresenterModule);
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

    private static class C0674x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0674x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0675x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0675x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0676x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0676x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0677x67334a88 implements Provider<GoogleSignInClient> {
        private final PSPComponent pSPComponent;

        C0677x67334a88(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GoogleSignInClient get() {
            return (GoogleSignInClient) Preconditions.checkNotNull(this.pSPComponent.googleSignInClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0678x18692616 implements Provider<LinkStudentService> {
        private final PSPComponent pSPComponent;

        C0678x18692616(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public LinkStudentService get() {
            return (LinkStudentService) Preconditions.checkNotNull(this.pSPComponent.linkStudentService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0679xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0679xa10b3e48(PSPComponent pSPComponent) {
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

    private DaggerLinkStudentActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.linkStudentViewModelProvider = DoubleCheck.provider(LinkStudentPresenterModule_LinkStudentViewModelFactory.create(builder.linkStudentPresenterModule));
        this.analyticsServiceProvider = new C0674x70a50c51(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.tokenProvider = new C0679xa10b3e48(builder.pSPComponent);
        this.configurationRepoProvider = new C0676x2fda2dc6(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.googleSignInClientProvider = new C0677x67334a88(builder.pSPComponent);
        this.linkStudentServiceProvider = new C0678x18692616(builder.pSPComponent);
        this.checkApplicationServiceProvider = new C0675x81c4dc2b(builder.pSPComponent);
        this.linkStudentInteractorProvider = DoubleCheck.provider(InteractorModule_LinkStudentInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.userRepoProvider, this.tokenProvider, this.configurationRepoProvider, this.studentRepoProvider, this.schoolRepoProvider, this.googleSignInClientProvider, this.linkStudentServiceProvider, this.checkApplicationServiceProvider));
        this.linkStudentPresenterProvider = DoubleCheck.provider(LinkStudentPresenterModule_LinkStudentPresenterFactory.create(builder.linkStudentPresenterModule, this.linkStudentViewModelProvider, this.linkStudentInteractorProvider));
        this.linkStudentActivityMembersInjector = LinkStudentActivity_MembersInjector.create(this.linkStudentPresenterProvider);
    }

    public void inject(LinkStudentActivity linkStudentActivity) {
        this.linkStudentActivityMembersInjector.injectMembers(linkStudentActivity);
    }
}
