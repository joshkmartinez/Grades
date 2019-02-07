package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.AssignmentsAdapter;
import com.aeries.mobileportal.adapters.AssignmentsAdapter.AssignmentListener;
import com.aeries.mobileportal.dagger.modules.AssignmentsFragmentModule;
import com.aeries.mobileportal.dagger.modules.AssignmentsFragmentModule_AssignmentAdapterFactory;
import com.aeries.mobileportal.dagger.modules.AssignmentsFragmentModule_AssignmentListenerFactory;
import com.aeries.mobileportal.dagger.modules.AssignmentsPresenterModule;
import com.aeries.mobileportal.dagger.modules.AssignmentsPresenterModule_AssignmentPresenterFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_AssignmentsInteractorFactory;
import com.aeries.mobileportal.interactors.grades.AssignmentsInteractor;
import com.aeries.mobileportal.presenters.AssignmentsPresenter;
import com.aeries.mobileportal.views.fragments.AssignmentsFragment;
import com.aeries.mobileportal.views.fragments.AssignmentsFragment_MembersInjector;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAssignmentsFragmentComponent implements AssignmentsFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AssignmentsAdapter> assignmentAdapterProvider;
    private Provider<AssignmentListener> assignmentListenerProvider;
    private Provider<AssignmentsPresenter> assignmentPresenterProvider;
    private MembersInjector<AssignmentsFragment> assignmentsFragmentMembersInjector;
    private Provider<AssignmentsInteractor> assignmentsInteractorProvider;
    private Provider<GradesService> gradesServiceProvider;
    private Provider<TokenProvider> tokenProvider;

    public static final class Builder {
        private AssignmentsFragmentModule assignmentsFragmentModule;
        private AssignmentsPresenterModule assignmentsPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;

        private Builder() {
        }

        public AssignmentsFragmentComponent build() {
            StringBuilder stringBuilder;
            if (this.assignmentsFragmentModule != null) {
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.assignmentsPresenterModule == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(AssignmentsPresenterModule.class.getCanonicalName());
                    stringBuilder.append(" must be set");
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (this.pSPComponent != null) {
                    return new DaggerAssignmentsFragmentComponent();
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(PSPComponent.class.getCanonicalName());
                    stringBuilder.append(" must be set");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(AssignmentsFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder assignmentsFragmentModule(AssignmentsFragmentModule assignmentsFragmentModule) {
            this.assignmentsFragmentModule = (AssignmentsFragmentModule) Preconditions.checkNotNull(assignmentsFragmentModule);
            return this;
        }

        public Builder assignmentsPresenterModule(AssignmentsPresenterModule assignmentsPresenterModule) {
            this.assignmentsPresenterModule = (AssignmentsPresenterModule) Preconditions.checkNotNull(assignmentsPresenterModule);
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

    private static class C0627x5a7da2d7 implements Provider<GradesService> {
        private final PSPComponent pSPComponent;

        C0627x5a7da2d7(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GradesService get() {
            return (GradesService) Preconditions.checkNotNull(this.pSPComponent.gradesService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0628xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0628xa10b3e48(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public TokenProvider get() {
            return (TokenProvider) Preconditions.checkNotNull(this.pSPComponent.tokenProvider(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerAssignmentsFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.assignmentListenerProvider = DoubleCheck.provider(AssignmentsFragmentModule_AssignmentListenerFactory.create(builder.assignmentsFragmentModule));
        this.assignmentAdapterProvider = DoubleCheck.provider(AssignmentsFragmentModule_AssignmentAdapterFactory.create(builder.assignmentsFragmentModule, this.assignmentListenerProvider));
        this.gradesServiceProvider = new C0627x5a7da2d7(builder.pSPComponent);
        this.tokenProvider = new C0628xa10b3e48(builder.pSPComponent);
        this.assignmentsInteractorProvider = DoubleCheck.provider(InteractorModule_AssignmentsInteractorFactory.create(builder.interactorModule, this.gradesServiceProvider, this.tokenProvider));
        this.assignmentPresenterProvider = DoubleCheck.provider(AssignmentsPresenterModule_AssignmentPresenterFactory.create(builder.assignmentsPresenterModule, this.assignmentsInteractorProvider));
        this.assignmentsFragmentMembersInjector = AssignmentsFragment_MembersInjector.create(this.assignmentAdapterProvider, this.assignmentPresenterProvider);
    }

    public void inject(AssignmentsFragment assignmentsFragment) {
        this.assignmentsFragmentMembersInjector.injectMembers(assignmentsFragment);
    }
}
