package com.aeries.mobileportal.dagger.components;

import android.content.Context;
import com.aeries.mobileportal.adapters.ReportCardsAdapter;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_ReportCardsFragmentInteractorFactory;
import com.aeries.mobileportal.dagger.modules.ReportCardsFragmentModule;
import com.aeries.mobileportal.dagger.modules.ReportCardsFragmentModule_AdapterFactory;
import com.aeries.mobileportal.dagger.modules.ReportCardsFragmentModule_ReportCardsPresenterFactory;
import com.aeries.mobileportal.interactors.report_cards.ReportCardsFragmentInteractor;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsFragmentPresenter;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.views.fragments.ReportCardsFragment;
import com.aeries.mobileportal.views.fragments.ReportCardsFragment_MembersInjector;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ReportCardService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerReportCardsFragmentComponent implements ReportCardsFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<ReportCardsAdapter> adapterProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<Context> contextProvider;
    private Provider<ReportCardService> reportCardServiceProvider;
    private Provider<ReportCardsFragmentInteractor> reportCardsFragmentInteractorProvider;
    private MembersInjector<ReportCardsFragment> reportCardsFragmentMembersInjector;
    private Provider<ReportCardsFragmentPresenter> reportCardsPresenterProvider;
    private Provider<TokenProvider> tokenProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private ReportCardsFragmentModule reportCardsFragmentModule;

        private Builder() {
        }

        public ReportCardsFragmentComponent build() {
            if (this.interactorModule == null) {
                this.interactorModule = new InteractorModule();
            }
            StringBuilder stringBuilder;
            if (this.reportCardsFragmentModule == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ReportCardsFragmentModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.pSPComponent != null) {
                return new DaggerReportCardsFragmentComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public Builder reportCardsFragmentModule(ReportCardsFragmentModule reportCardsFragmentModule) {
            this.reportCardsFragmentModule = (ReportCardsFragmentModule) Preconditions.checkNotNull(reportCardsFragmentModule);
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

    private static class C0718x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0718x2fda2dc6(PSPComponent pSPComponent) {
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

    private static class C0719xf59b6fef implements Provider<ReportCardService> {
        private final PSPComponent pSPComponent;

        C0719xf59b6fef(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ReportCardService get() {
            return (ReportCardService) Preconditions.checkNotNull(this.pSPComponent.reportCardService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0720xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0720xa10b3e48(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public TokenProvider get() {
            return (TokenProvider) Preconditions.checkNotNull(this.pSPComponent.tokenProvider(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerReportCardsFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.configurationRepoProvider = new C0718x2fda2dc6(builder.pSPComponent);
        this.tokenProvider = new C0720xa10b3e48(builder.pSPComponent);
        this.reportCardServiceProvider = new C0719xf59b6fef(builder.pSPComponent);
        this.contextProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_context(builder.pSPComponent);
        this.reportCardsFragmentInteractorProvider = DoubleCheck.provider(InteractorModule_ReportCardsFragmentInteractorFactory.create(builder.interactorModule, this.configurationRepoProvider, this.tokenProvider, this.reportCardServiceProvider, this.contextProvider));
        this.reportCardsPresenterProvider = DoubleCheck.provider(ReportCardsFragmentModule_ReportCardsPresenterFactory.create(builder.reportCardsFragmentModule, this.reportCardsFragmentInteractorProvider));
        this.adapterProvider = DoubleCheck.provider(ReportCardsFragmentModule_AdapterFactory.create(builder.reportCardsFragmentModule));
        this.reportCardsFragmentMembersInjector = ReportCardsFragment_MembersInjector.create(this.reportCardsPresenterProvider, this.adapterProvider);
    }

    public void inject(ReportCardsFragment reportCardsFragment) {
        this.reportCardsFragmentMembersInjector.injectMembers(reportCardsFragment);
    }
}
