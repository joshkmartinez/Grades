package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.link_student.LinkStudentInteractor;
import com.aeries.mobileportal.presenters.link_student.LinkStudentPresenter;
import com.aeries.mobileportal.views.viewmodels.link_student.LinkStudentViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LinkStudentPresenterModule_LinkStudentPresenterFactory implements Factory<LinkStudentPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<LinkStudentInteractor> linkStudentInteractorProvider;
    private final Provider<LinkStudentViewModel> linkStudentViewModelProvider;
    private final LinkStudentPresenterModule module;

    public LinkStudentPresenterModule_LinkStudentPresenterFactory(LinkStudentPresenterModule linkStudentPresenterModule, Provider<LinkStudentViewModel> provider, Provider<LinkStudentInteractor> provider2) {
        this.module = linkStudentPresenterModule;
        this.linkStudentViewModelProvider = provider;
        this.linkStudentInteractorProvider = provider2;
    }

    public LinkStudentPresenter get() {
        return (LinkStudentPresenter) Preconditions.checkNotNull(this.module.linkStudentPresenter((LinkStudentViewModel) this.linkStudentViewModelProvider.get(), (LinkStudentInteractor) this.linkStudentInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LinkStudentPresenter> create(LinkStudentPresenterModule linkStudentPresenterModule, Provider<LinkStudentViewModel> provider, Provider<LinkStudentInteractor> provider2) {
        return new LinkStudentPresenterModule_LinkStudentPresenterFactory(linkStudentPresenterModule, provider, provider2);
    }
}
