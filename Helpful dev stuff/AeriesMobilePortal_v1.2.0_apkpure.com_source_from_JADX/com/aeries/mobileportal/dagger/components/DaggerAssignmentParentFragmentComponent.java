package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.AssignmentParentFragmentModule;
import com.aeries.mobileportal.dagger.modules.AssignmentParentFragmentModule_PresenterFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_AssignmentParentInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.grades.AssignmentParentInteractor;
import com.aeries.mobileportal.presenters.grades.AssignmentParentPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.fragments.AssignmentParentFragment;
import com.aeries.mobileportal.views.fragments.AssignmentParentFragment_MembersInjector;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAssignmentParentFragmentComponent implements AssignmentParentFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private MembersInjector<AssignmentParentFragment> assignmentParentFragmentMembersInjector;
    private Provider<AssignmentParentInteractor> assignmentParentInteractorProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<GradesService> gradesServiceProvider;
    private Provider<AssignmentParentPresenter> presenterProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private AssignmentParentFragmentModule assignmentParentFragmentModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public AssignmentParentFragmentComponent build() {
            if (this.repoModule == null) {
                this.repoModule = new RepoModule();
            }
            if (this.interactorModule == null) {
                this.interactorModule = new InteractorModule();
            }
            StringBuilder stringBuilder;
            if (this.assignmentParentFragmentModule == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AssignmentParentFragmentModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.pSPComponent != null) {
                return new DaggerAssignmentParentFragmentComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public Builder assignmentParentFragmentModule(AssignmentParentFragmentModule assignmentParentFragmentModule) {
            this.assignmentParentFragmentModule = (AssignmentParentFragmentModule) Preconditions.checkNotNull(assignmentParentFragmentModule);
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

    private static class C0623x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0623x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0624x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0624x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0625x5a7da2d7 implements Provider<GradesService> {
        private final PSPComponent pSPComponent;

        C0625x5a7da2d7(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GradesService get() {
            return (GradesService) Preconditions.checkNotNull(this.pSPComponent.gradesService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0626xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0626xa10b3e48(PSPComponent pSPComponent) {
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

    private DaggerAssignmentParentFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.analyticsServiceProvider = new C0623x70a50c51(builder.pSPComponent);
        this.gradesServiceProvider = new C0625x5a7da2d7(builder.pSPComponent);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.configurationRepoProvider = new C0624x2fda2dc6(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.tokenProvider = new C0626xa10b3e48(builder.pSPComponent);
        this.assignmentParentInteractorProvider = DoubleCheck.provider(InteractorModule_AssignmentParentInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.gradesServiceProvider, this.schoolRepoProvider, this.studentRepoProvider, this.configurationRepoProvider, this.userRepoProvider, this.tokenProvider));
        this.presenterProvider = DoubleCheck.provider(AssignmentParentFragmentModule_PresenterFactory.create(builder.assignmentParentFragmentModule, this.assignmentParentInteractorProvider));
        this.assignmentParentFragmentMembersInjector = AssignmentParentFragment_MembersInjector.create(this.presenterProvider);
    }

    public void inject(AssignmentParentFragment assignmentParentFragment) {
        this.assignmentParentFragmentMembersInjector.injectMembers(assignmentParentFragment);
    }
}
