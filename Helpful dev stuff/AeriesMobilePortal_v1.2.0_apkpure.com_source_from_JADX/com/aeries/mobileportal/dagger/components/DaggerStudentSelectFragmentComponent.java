package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.StudentSelectAdapter;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_StudentSelectInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.dagger.modules.StudentSelectFragmentModule;
import com.aeries.mobileportal.dagger.modules.StudentSelectFragmentModule_StudentSelectAdapterFactory;
import com.aeries.mobileportal.dagger.modules.StudentSelectFragmentModule_StudentSelectPresenterFactory;
import com.aeries.mobileportal.interactors.StudentSelectInteractor;
import com.aeries.mobileportal.presenters.StudentSelectPresenter;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.views.fragments.StudentSelectFragment;
import com.aeries.mobileportal.views.fragments.StudentSelectFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerStudentSelectFragmentComponent implements StudentSelectFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<StudentSelectAdapter> studentSelectAdapterProvider;
    private MembersInjector<StudentSelectFragment> studentSelectFragmentMembersInjector;
    private Provider<StudentSelectInteractor> studentSelectInteractorProvider;
    private Provider<StudentSelectPresenter> studentSelectPresenterProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private RepoModule repoModule;
        private StudentSelectFragmentModule studentSelectFragmentModule;

        private Builder() {
        }

        public StudentSelectFragmentComponent build() {
            if (this.studentSelectFragmentModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                return new DaggerStudentSelectFragmentComponent();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(StudentSelectFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder studentSelectFragmentModule(StudentSelectFragmentModule studentSelectFragmentModule) {
            this.studentSelectFragmentModule = (StudentSelectFragmentModule) Preconditions.checkNotNull(studentSelectFragmentModule);
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
    }

    private DaggerStudentSelectFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.studentSelectAdapterProvider = DoubleCheck.provider(StudentSelectFragmentModule_StudentSelectAdapterFactory.create(builder.studentSelectFragmentModule));
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.studentSelectInteractorProvider = DoubleCheck.provider(InteractorModule_StudentSelectInteractorFactory.create(builder.interactorModule, this.studentRepoProvider));
        this.studentSelectPresenterProvider = DoubleCheck.provider(StudentSelectFragmentModule_StudentSelectPresenterFactory.create(builder.studentSelectFragmentModule, this.studentSelectInteractorProvider));
        this.studentSelectFragmentMembersInjector = StudentSelectFragment_MembersInjector.create(this.studentSelectAdapterProvider, this.studentSelectPresenterProvider);
    }

    public void inject(StudentSelectFragment studentSelectFragment) {
        this.studentSelectFragmentMembersInjector.injectMembers(studentSelectFragment);
    }
}
