package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.CoursesAdapter;
import com.aeries.mobileportal.adapters.CoursesAdapter.CourseListener;
import com.aeries.mobileportal.dagger.modules.CourseSelectFragmentModule;
import com.aeries.mobileportal.dagger.modules.CourseSelectFragmentModule_CourseListenerFactory;
import com.aeries.mobileportal.dagger.modules.CourseSelectFragmentModule_CoursesAdapterFactory;
import com.aeries.mobileportal.dagger.modules.CoursesPresenterModule;
import com.aeries.mobileportal.dagger.modules.CoursesPresenterModule_CoursesPresenterFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_CoursesInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.grades.CoursesInteractor;
import com.aeries.mobileportal.presenters.grades.CoursesPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.fragments.CourseSelectFragment;
import com.aeries.mobileportal.views.fragments.CourseSelectFragment_MembersInjector;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerCourseSelectFragmentComponent implements CourseSelectFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<CourseListener> courseListenerProvider;
    private MembersInjector<CourseSelectFragment> courseSelectFragmentMembersInjector;
    private Provider<CoursesAdapter> coursesAdapterProvider;
    private Provider<CoursesInteractor> coursesInteractorProvider;
    private Provider<CoursesPresenter> coursesPresenterProvider;
    private Provider<GradesService> gradesServiceProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private CourseSelectFragmentModule courseSelectFragmentModule;
        private CoursesPresenterModule coursesPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public CourseSelectFragmentComponent build() {
            StringBuilder stringBuilder;
            if (this.courseSelectFragmentModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.coursesPresenterModule == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(CoursesPresenterModule.class.getCanonicalName());
                    stringBuilder.append(" must be set");
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (this.pSPComponent != null) {
                    return new DaggerCourseSelectFragmentComponent();
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(PSPComponent.class.getCanonicalName());
                    stringBuilder.append(" must be set");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(CourseSelectFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder courseSelectFragmentModule(CourseSelectFragmentModule courseSelectFragmentModule) {
            this.courseSelectFragmentModule = (CourseSelectFragmentModule) Preconditions.checkNotNull(courseSelectFragmentModule);
            return this;
        }

        public Builder coursesPresenterModule(CoursesPresenterModule coursesPresenterModule) {
            this.coursesPresenterModule = (CoursesPresenterModule) Preconditions.checkNotNull(coursesPresenterModule);
            return this;
        }

        public Builder repoModule(RepoModule repoModule) {
            this.repoModule = (RepoModule) Preconditions.checkNotNull(repoModule);
            return this;
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder pSPComponent(PSPComponent pSPComponent) {
            this.pSPComponent = (PSPComponent) Preconditions.checkNotNull(pSPComponent);
            return this;
        }
    }

    private static class C0653x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0653x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0654x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0654x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0655x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0655x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0656x5a7da2d7 implements Provider<GradesService> {
        private final PSPComponent pSPComponent;

        C0656x5a7da2d7(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GradesService get() {
            return (GradesService) Preconditions.checkNotNull(this.pSPComponent.gradesService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0657xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0657xa10b3e48(PSPComponent pSPComponent) {
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

    private DaggerCourseSelectFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.courseListenerProvider = DoubleCheck.provider(CourseSelectFragmentModule_CourseListenerFactory.create(builder.courseSelectFragmentModule));
        this.coursesAdapterProvider = DoubleCheck.provider(CourseSelectFragmentModule_CoursesAdapterFactory.create(builder.courseSelectFragmentModule, this.courseListenerProvider));
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0655x2fda2dc6(builder.pSPComponent);
        this.tokenProvider = new C0657xa10b3e48(builder.pSPComponent);
        this.checkApplicationServiceProvider = new C0654x81c4dc2b(builder.pSPComponent);
        this.analyticsServiceProvider = new C0653x70a50c51(builder.pSPComponent);
        this.gradesServiceProvider = new C0656x5a7da2d7(builder.pSPComponent);
        this.coursesInteractorProvider = DoubleCheck.provider(InteractorModule_CoursesInteractorFactory.create(builder.interactorModule, this.schoolRepoProvider, this.studentRepoProvider, this.userRepoProvider, this.configurationRepoProvider, this.tokenProvider, this.checkApplicationServiceProvider, this.analyticsServiceProvider, this.gradesServiceProvider));
        this.coursesPresenterProvider = DoubleCheck.provider(CoursesPresenterModule_CoursesPresenterFactory.create(builder.coursesPresenterModule, this.coursesInteractorProvider));
        this.courseSelectFragmentMembersInjector = CourseSelectFragment_MembersInjector.create(this.coursesAdapterProvider, this.coursesPresenterProvider);
    }

    public void inject(CourseSelectFragment courseSelectFragment) {
        this.courseSelectFragmentMembersInjector.injectMembers(courseSelectFragment);
    }
}
