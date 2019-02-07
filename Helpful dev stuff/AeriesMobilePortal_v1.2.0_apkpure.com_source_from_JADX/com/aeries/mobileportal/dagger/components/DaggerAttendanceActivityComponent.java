package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.AttendancePresenterModule;
import com.aeries.mobileportal.dagger.modules.AttendancePresenterModule_AttendancePresenterFactory;
import com.aeries.mobileportal.dagger.modules.AttendancePresenterModule_AttendanceViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_AttendanceInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.attendance.AttendanceInteractor;
import com.aeries.mobileportal.presenters.attendance.AttendancePresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.AttendanceActivity;
import com.aeries.mobileportal.views.activities.AttendanceActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.attendance.AttendanceViewModel;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AttendanceService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAttendanceActivityComponent implements AttendanceActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private MembersInjector<AttendanceActivity> attendanceActivityMembersInjector;
    private Provider<AttendanceInteractor> attendanceInteractorProvider;
    private Provider<AttendancePresenter> attendancePresenterProvider;
    private Provider<AttendanceService> attendanceServiceProvider;
    private Provider<AttendanceViewModel> attendanceViewModelProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private AttendancePresenterModule attendancePresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public AttendanceActivityComponent build() {
            if (this.attendancePresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerAttendanceActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(AttendancePresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder attendancePresenterModule(AttendancePresenterModule attendancePresenterModule) {
            this.attendancePresenterModule = (AttendancePresenterModule) Preconditions.checkNotNull(attendancePresenterModule);
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

    private static class C0629x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0629x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0630xc3e367ca implements Provider<AttendanceService> {
        private final PSPComponent pSPComponent;

        C0630xc3e367ca(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AttendanceService get() {
            return (AttendanceService) Preconditions.checkNotNull(this.pSPComponent.attendanceService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0631x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0631x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0632xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0632xa10b3e48(PSPComponent pSPComponent) {
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

    private DaggerAttendanceActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.attendanceViewModelProvider = DoubleCheck.provider(AttendancePresenterModule_AttendanceViewModelFactory.create(builder.attendancePresenterModule));
        this.analyticsServiceProvider = new C0629x70a50c51(builder.pSPComponent);
        this.attendanceServiceProvider = new C0630xc3e367ca(builder.pSPComponent);
        this.tokenProvider = new C0632xa10b3e48(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0631x2fda2dc6(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.attendanceInteractorProvider = DoubleCheck.provider(InteractorModule_AttendanceInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.attendanceServiceProvider, this.tokenProvider, this.userRepoProvider, this.configurationRepoProvider, this.studentRepoProvider, this.schoolRepoProvider));
        this.attendancePresenterProvider = DoubleCheck.provider(AttendancePresenterModule_AttendancePresenterFactory.create(builder.attendancePresenterModule, this.attendanceViewModelProvider, this.attendanceInteractorProvider));
        this.attendanceActivityMembersInjector = AttendanceActivity_MembersInjector.create(this.attendancePresenterProvider);
    }

    public void inject(AttendanceActivity attendanceActivity) {
        this.attendanceActivityMembersInjector.injectMembers(attendanceActivity);
    }
}
