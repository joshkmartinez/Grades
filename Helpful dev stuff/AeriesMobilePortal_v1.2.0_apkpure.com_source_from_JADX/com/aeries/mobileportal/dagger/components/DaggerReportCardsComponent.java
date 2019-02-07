package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_ReportCardsInteractorFactory;
import com.aeries.mobileportal.dagger.modules.ReportCardsModule;
import com.aeries.mobileportal.dagger.modules.ReportCardsModule_ReportCardsPresenterFactory;
import com.aeries.mobileportal.interactors.report_cards.ReportCardsInteractor;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsPresenter;
import com.aeries.mobileportal.views.activities.ReportCardsActivity;
import com.aeries.mobileportal.views.activities.ReportCardsActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerReportCardsComponent implements ReportCardsComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<ReportCardsActivity> reportCardsActivityMembersInjector;
    private Provider<ReportCardsInteractor> reportCardsInteractorProvider;
    private Provider<ReportCardsPresenter> reportCardsPresenterProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private ReportCardsModule reportCardsModule;

        private Builder() {
        }

        public ReportCardsComponent build() {
            if (this.interactorModule == null) {
                this.interactorModule = new InteractorModule();
            }
            StringBuilder stringBuilder;
            if (this.reportCardsModule == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ReportCardsModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.pSPComponent != null) {
                return new DaggerReportCardsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public Builder reportCardsModule(ReportCardsModule reportCardsModule) {
            this.reportCardsModule = (ReportCardsModule) Preconditions.checkNotNull(reportCardsModule);
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

    private DaggerReportCardsComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.reportCardsInteractorProvider = DoubleCheck.provider(InteractorModule_ReportCardsInteractorFactory.create(builder.interactorModule));
        this.reportCardsPresenterProvider = DoubleCheck.provider(ReportCardsModule_ReportCardsPresenterFactory.create(builder.reportCardsModule, this.reportCardsInteractorProvider));
        this.reportCardsActivityMembersInjector = ReportCardsActivity_MembersInjector.create(this.reportCardsPresenterProvider);
    }

    public void inject(ReportCardsActivity reportCardsActivity) {
        this.reportCardsActivityMembersInjector.injectMembers(reportCardsActivity);
    }
}
