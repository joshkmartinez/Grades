package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.ClassCheckInPresenterModule;
import com.aeries.mobileportal.dagger.modules.ClassCheckInPresenterModule_ClassCheckInPresenterFactory;
import com.aeries.mobileportal.dagger.modules.ClassCheckInPresenterModule_ClassCheckInViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_ClassCheckInInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.supplementan_attendance.ClassCheckInInteractor;
import com.aeries.mobileportal.presenters.supplemental_attendance.ClassCheckInPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.ClassCheckInActivity;
import com.aeries.mobileportal.views.activities.ClassCheckInActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.ClassCheckInViewModel;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerClassCheckInActivityComponent implements ClassCheckInActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private MembersInjector<ClassCheckInActivity> classCheckInActivityMembersInjector;
    private Provider<ClassCheckInInteractor> classCheckInInteractorProvider;
    private Provider<ClassCheckInPresenter> classCheckInPresenterProvider;
    private Provider<ClassCheckInViewModel> classCheckInViewModelProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<SupplementalAttendanceService> supplementalAttendanceServiceProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private ClassCheckInPresenterModule classCheckInPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public ClassCheckInActivityComponent build() {
            if (this.classCheckInPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerClassCheckInActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(ClassCheckInPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder classCheckInPresenterModule(ClassCheckInPresenterModule classCheckInPresenterModule) {
            this.classCheckInPresenterModule = (ClassCheckInPresenterModule) Preconditions.checkNotNull(classCheckInPresenterModule);
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

    private static class C0641x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0641x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0642x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0642x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0643xc804bc86 implements Provider<SupplementalAttendanceService> {
        private final PSPComponent pSPComponent;

        C0643xc804bc86(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public SupplementalAttendanceService get() {
            return (SupplementalAttendanceService) Preconditions.checkNotNull(this.pSPComponent.supplementalAttendanceService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0644xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0644xa10b3e48(PSPComponent pSPComponent) {
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

    private DaggerClassCheckInActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.classCheckInViewModelProvider = DoubleCheck.provider(ClassCheckInPresenterModule_ClassCheckInViewModelFactory.create(builder.classCheckInPresenterModule));
        this.analyticsServiceProvider = new C0641x70a50c51(builder.pSPComponent);
        this.supplementalAttendanceServiceProvider = new C0643xc804bc86(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0642x2fda2dc6(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.tokenProvider = new C0644xa10b3e48(builder.pSPComponent);
        this.classCheckInInteractorProvider = DoubleCheck.provider(InteractorModule_ClassCheckInInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.supplementalAttendanceServiceProvider, this.userRepoProvider, this.configurationRepoProvider, this.studentRepoProvider, this.schoolRepoProvider, this.tokenProvider));
        this.classCheckInPresenterProvider = DoubleCheck.provider(ClassCheckInPresenterModule_ClassCheckInPresenterFactory.create(builder.classCheckInPresenterModule, this.classCheckInViewModelProvider, this.classCheckInInteractorProvider));
        this.classCheckInActivityMembersInjector = ClassCheckInActivity_MembersInjector.create(this.classCheckInPresenterProvider);
    }

    public void inject(ClassCheckInActivity classCheckInActivity) {
        this.classCheckInActivityMembersInjector.injectMembers(classCheckInActivity);
    }
}
