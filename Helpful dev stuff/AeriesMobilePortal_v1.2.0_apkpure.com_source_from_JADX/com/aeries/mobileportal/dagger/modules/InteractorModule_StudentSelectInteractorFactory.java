package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.StudentSelectInteractor;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_StudentSelectInteractorFactory implements Factory<StudentSelectInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InteractorModule module;
    private final Provider<StudentRepo> studentRepoProvider;

    public InteractorModule_StudentSelectInteractorFactory(InteractorModule interactorModule, Provider<StudentRepo> provider) {
        this.module = interactorModule;
        this.studentRepoProvider = provider;
    }

    public StudentSelectInteractor get() {
        return (StudentSelectInteractor) Preconditions.checkNotNull(this.module.studentSelectInteractor((StudentRepo) this.studentRepoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<StudentSelectInteractor> create(InteractorModule interactorModule, Provider<StudentRepo> provider) {
        return new InteractorModule_StudentSelectInteractorFactory(interactorModule, provider);
    }
}
