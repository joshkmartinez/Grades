package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.AssignmentCategoriesAdapter;
import com.aeries.mobileportal.presenters.grades.AssignmentCategoryPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AssignmentCategoryFragment_MembersInjector implements MembersInjector<AssignmentCategoryFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AssignmentCategoriesAdapter> adapterProvider;
    private final Provider<AssignmentCategoryPresenter> presenterProvider;

    public AssignmentCategoryFragment_MembersInjector(Provider<AssignmentCategoryPresenter> provider, Provider<AssignmentCategoriesAdapter> provider2) {
        this.presenterProvider = provider;
        this.adapterProvider = provider2;
    }

    public static MembersInjector<AssignmentCategoryFragment> create(Provider<AssignmentCategoryPresenter> provider, Provider<AssignmentCategoriesAdapter> provider2) {
        return new AssignmentCategoryFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(AssignmentCategoryFragment assignmentCategoryFragment) {
        if (assignmentCategoryFragment != null) {
            assignmentCategoryFragment.presenter = (AssignmentCategoryPresenter) this.presenterProvider.get();
            assignmentCategoryFragment.adapter = (AssignmentCategoriesAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
