package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.presenters.grades.AssignmentParentPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AssignmentParentFragment_MembersInjector implements MembersInjector<AssignmentParentFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AssignmentParentPresenter> presenterProvider;

    public AssignmentParentFragment_MembersInjector(Provider<AssignmentParentPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<AssignmentParentFragment> create(Provider<AssignmentParentPresenter> provider) {
        return new AssignmentParentFragment_MembersInjector(provider);
    }

    public void injectMembers(AssignmentParentFragment assignmentParentFragment) {
        if (assignmentParentFragment != null) {
            assignmentParentFragment.presenter = (AssignmentParentPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
