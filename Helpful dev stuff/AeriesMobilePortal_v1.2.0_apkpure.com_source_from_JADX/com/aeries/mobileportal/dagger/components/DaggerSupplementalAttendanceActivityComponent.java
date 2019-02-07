package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.C0964x8bf4dcc7;
import com.aeries.mobileportal.dagger.modules.C0965x8f14806b;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_SupplementalAttendanceInteractorFactory;
import com.aeries.mobileportal.dagger.modules.SupplementalAttendancePresenterModule;
import com.aeries.mobileportal.interactors.supplementan_attendance.SupplementalAttendanceInteractor;
import com.aeries.mobileportal.presenters.supplemental_attendance.SupplementalAttendancePresenter;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.views.activities.SupplementalAttendanceActivity;
import com.aeries.mobileportal.views.activities.SupplementalAttendanceActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.SupplementalAttendanceViewModel;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerSupplementalAttendanceActivityComponent implements SupplementalAttendanceActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private MembersInjector<SupplementalAttendanceActivity> supplementalAttendanceActivityMembersInjector;
    private Provider<SupplementalAttendanceInteractor> supplementalAttendanceInteractorProvider;
    private Provider<SupplementalAttendancePresenter> supplementalAttendancePresenterProvider;
    private Provider<SupplementalAttendanceService> supplementalAttendanceServiceProvider;
    private Provider<SupplementalAttendanceViewModel> supplementalAttendanceViewModelProvider;
    private Provider<TokenRepository> tokenRepoProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private SupplementalAttendancePresenterModule supplementalAttendancePresenterModule;

        private Builder() {
        }

        public SupplementalAttendanceActivityComponent build() {
            if (this.supplementalAttendancePresenterModule != null) {
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerSupplementalAttendanceActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(SupplementalAttendancePresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder supplementalAttendancePresenterModule(SupplementalAttendancePresenterModule supplementalAttendancePresenterModule) {
            this.supplementalAttendancePresenterModule = (SupplementalAttendancePresenterModule) Preconditions.checkNotNull(supplementalAttendancePresenterModule);
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

    private static class C0727x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0727x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0728xc804bc86 implements Provider<SupplementalAttendanceService> {
        private final PSPComponent pSPComponent;

        C0728xc804bc86(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public SupplementalAttendanceService get() {
            return (SupplementalAttendanceService) Preconditions.checkNotNull(this.pSPComponent.supplementalAttendanceService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo implements Provider<TokenRepository> {
        private final PSPComponent pSPComponent;

        com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public TokenRepository get() {
            return (TokenRepository) Preconditions.checkNotNull(this.pSPComponent.tokenRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerSupplementalAttendanceActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.supplementalAttendanceViewModelProvider = DoubleCheck.provider(C0965x8f14806b.create(builder.supplementalAttendancePresenterModule));
        this.tokenRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0727x2fda2dc6(builder.pSPComponent);
        this.supplementalAttendanceServiceProvider = new C0728xc804bc86(builder.pSPComponent);
        this.supplementalAttendanceInteractorProvider = DoubleCheck.provider(InteractorModule_SupplementalAttendanceInteractorFactory.create(builder.interactorModule, this.tokenRepoProvider, this.configurationRepoProvider, this.supplementalAttendanceServiceProvider));
        this.supplementalAttendancePresenterProvider = DoubleCheck.provider(C0964x8bf4dcc7.create(builder.supplementalAttendancePresenterModule, this.supplementalAttendanceViewModelProvider, this.supplementalAttendanceInteractorProvider));
        this.supplementalAttendanceActivityMembersInjector = SupplementalAttendanceActivity_MembersInjector.create(this.supplementalAttendancePresenterProvider);
    }

    public void inject(SupplementalAttendanceActivity supplementalAttendanceActivity) {
        this.supplementalAttendanceActivityMembersInjector.injectMembers(supplementalAttendanceActivity);
    }
}
