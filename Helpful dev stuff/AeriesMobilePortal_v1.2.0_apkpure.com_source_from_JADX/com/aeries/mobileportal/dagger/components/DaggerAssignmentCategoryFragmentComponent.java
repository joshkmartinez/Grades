package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.AssignmentCategoriesAdapter;
import com.aeries.mobileportal.dagger.modules.AssignmentCategoryFragmentModule;
import com.aeries.mobileportal.dagger.modules.AssignmentCategoryPresenterModule;
import com.aeries.mobileportal.dagger.modules.C0962xfa113e7c;
import com.aeries.mobileportal.dagger.modules.C0963x6e46ddc3;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_AssignmentCategoryInteractorFactory;
import com.aeries.mobileportal.interactors.grades.AssignmentCategoryInteractor;
import com.aeries.mobileportal.presenters.grades.AssignmentCategoryPresenter;
import com.aeries.mobileportal.views.fragments.AssignmentCategoryFragment;
import com.aeries.mobileportal.views.fragments.AssignmentCategoryFragment_MembersInjector;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAssignmentCategoryFragmentComponent implements AssignmentCategoryFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AssignmentCategoriesAdapter> assignmentCategoriesAdapterProvider;
    private MembersInjector<AssignmentCategoryFragment> assignmentCategoryFragmentMembersInjector;
    private Provider<AssignmentCategoryInteractor> assignmentCategoryInteractorProvider;
    private Provider<AssignmentCategoryPresenter> assignmentCategoryPresenterProvider;
    private Provider<GradesService> gradesServiceProvider;
    private Provider<TokenProvider> tokenProvider;

    public static final class Builder {
        private AssignmentCategoryFragmentModule assignmentCategoryFragmentModule;
        private AssignmentCategoryPresenterModule assignmentCategoryPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;

        private Builder() {
        }

        public AssignmentCategoryFragmentComponent build() {
            if (this.interactorModule == null) {
                this.interactorModule = new InteractorModule();
            }
            StringBuilder stringBuilder;
            if (this.assignmentCategoryPresenterModule == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AssignmentCategoryPresenterModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.assignmentCategoryFragmentModule == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AssignmentCategoryFragmentModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.pSPComponent != null) {
                return new DaggerAssignmentCategoryFragmentComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public Builder assignmentCategoryFragmentModule(AssignmentCategoryFragmentModule assignmentCategoryFragmentModule) {
            this.assignmentCategoryFragmentModule = (AssignmentCategoryFragmentModule) Preconditions.checkNotNull(assignmentCategoryFragmentModule);
            return this;
        }

        public Builder assignmentCategoryPresenterModule(AssignmentCategoryPresenterModule assignmentCategoryPresenterModule) {
            this.assignmentCategoryPresenterModule = (AssignmentCategoryPresenterModule) Preconditions.checkNotNull(assignmentCategoryPresenterModule);
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

    private static class C0621x5a7da2d7 implements Provider<GradesService> {
        private final PSPComponent pSPComponent;

        C0621x5a7da2d7(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GradesService get() {
            return (GradesService) Preconditions.checkNotNull(this.pSPComponent.gradesService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0622xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0622xa10b3e48(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public TokenProvider get() {
            return (TokenProvider) Preconditions.checkNotNull(this.pSPComponent.tokenProvider(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerAssignmentCategoryFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.gradesServiceProvider = new C0621x5a7da2d7(builder.pSPComponent);
        this.tokenProvider = new C0622xa10b3e48(builder.pSPComponent);
        this.assignmentCategoryInteractorProvider = DoubleCheck.provider(InteractorModule_AssignmentCategoryInteractorFactory.create(builder.interactorModule, this.gradesServiceProvider, this.tokenProvider));
        this.assignmentCategoryPresenterProvider = DoubleCheck.provider(C0963x6e46ddc3.create(builder.assignmentCategoryPresenterModule, this.assignmentCategoryInteractorProvider));
        this.assignmentCategoriesAdapterProvider = DoubleCheck.provider(C0962xfa113e7c.create(builder.assignmentCategoryFragmentModule));
        this.assignmentCategoryFragmentMembersInjector = AssignmentCategoryFragment_MembersInjector.create(this.assignmentCategoryPresenterProvider, this.assignmentCategoriesAdapterProvider);
    }

    public void inject(AssignmentCategoryFragment assignmentCategoryFragment) {
        this.assignmentCategoryFragmentMembersInjector.injectMembers(assignmentCategoryFragment);
    }
}
