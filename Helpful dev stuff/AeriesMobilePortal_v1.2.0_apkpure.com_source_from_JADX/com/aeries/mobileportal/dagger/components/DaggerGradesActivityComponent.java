package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.GradesPresenterModule;
import com.aeries.mobileportal.dagger.modules.GradesPresenterModule_GradesPresenterFactory;
import com.aeries.mobileportal.dagger.modules.GradesPresenterModule_GradesViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_GradesInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.grades.GradesInteractor;
import com.aeries.mobileportal.presenters.grades.GradesPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.GradesActivity;
import com.aeries.mobileportal.views.activities.GradesActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.grades.GradesViewModel;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.GradesService;
import com.aeries.mobileportal.web_services.services.WhatIfService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerGradesActivityComponent implements GradesActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private MembersInjector<GradesActivity> gradesActivityMembersInjector;
    private Provider<GradesInteractor> gradesInteractorProvider;
    private Provider<GradesPresenter> gradesPresenterProvider;
    private Provider<GradesService> gradesServiceProvider;
    private Provider<GradesViewModel> gradesViewModelProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;
    private Provider<WhatIfService> whatIfServiceProvider;

    public static final class Builder {
        private GradesPresenterModule gradesPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public GradesActivityComponent build() {
            if (this.gradesPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerGradesActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(GradesPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder gradesPresenterModule(GradesPresenterModule gradesPresenterModule) {
            this.gradesPresenterModule = (GradesPresenterModule) Preconditions.checkNotNull(gradesPresenterModule);
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

    private static class C0668x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0668x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0669x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0669x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0670x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0670x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0671x5a7da2d7 implements Provider<GradesService> {
        private final PSPComponent pSPComponent;

        C0671x5a7da2d7(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GradesService get() {
            return (GradesService) Preconditions.checkNotNull(this.pSPComponent.gradesService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0672xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0672xa10b3e48(PSPComponent pSPComponent) {
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

    private static class C0673xbc693bb2 implements Provider<WhatIfService> {
        private final PSPComponent pSPComponent;

        C0673xbc693bb2(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public WhatIfService get() {
            return (WhatIfService) Preconditions.checkNotNull(this.pSPComponent.whatIfService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerGradesActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.gradesViewModelProvider = DoubleCheck.provider(GradesPresenterModule_GradesViewModelFactory.create(builder.gradesPresenterModule));
        this.analyticsServiceProvider = new C0668x70a50c51(builder.pSPComponent);
        this.gradesServiceProvider = new C0671x5a7da2d7(builder.pSPComponent);
        this.checkApplicationServiceProvider = new C0669x81c4dc2b(builder.pSPComponent);
        this.whatIfServiceProvider = new C0673xbc693bb2(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0670x2fda2dc6(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.tokenProvider = new C0672xa10b3e48(builder.pSPComponent);
        this.gradesInteractorProvider = DoubleCheck.provider(InteractorModule_GradesInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.gradesServiceProvider, this.checkApplicationServiceProvider, this.whatIfServiceProvider, this.userRepoProvider, this.configurationRepoProvider, this.studentRepoProvider, this.schoolRepoProvider, this.tokenProvider));
        this.gradesPresenterProvider = DoubleCheck.provider(GradesPresenterModule_GradesPresenterFactory.create(builder.gradesPresenterModule, this.gradesViewModelProvider, this.gradesInteractorProvider));
        this.gradesActivityMembersInjector = GradesActivity_MembersInjector.create(this.gradesPresenterProvider);
    }

    public void inject(GradesActivity gradesActivity) {
        this.gradesActivityMembersInjector.injectMembers(gradesActivity);
    }
}
