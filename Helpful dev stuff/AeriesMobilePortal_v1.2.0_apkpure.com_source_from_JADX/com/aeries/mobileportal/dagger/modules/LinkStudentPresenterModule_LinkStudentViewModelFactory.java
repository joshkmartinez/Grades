package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.link_student.LinkStudentViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class LinkStudentPresenterModule_LinkStudentViewModelFactory implements Factory<LinkStudentViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final LinkStudentPresenterModule module;

    public LinkStudentPresenterModule_LinkStudentViewModelFactory(LinkStudentPresenterModule linkStudentPresenterModule) {
        this.module = linkStudentPresenterModule;
    }

    public LinkStudentViewModel get() {
        return (LinkStudentViewModel) Preconditions.checkNotNull(this.module.linkStudentViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LinkStudentViewModel> create(LinkStudentPresenterModule linkStudentPresenterModule) {
        return new LinkStudentPresenterModule_LinkStudentViewModelFactory(linkStudentPresenterModule);
    }
}
