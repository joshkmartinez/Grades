package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.AssignmentsAdapter;
import com.aeries.mobileportal.presenters.AssignmentsPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AssignmentsFragment_MembersInjector implements MembersInjector<AssignmentsFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AssignmentsAdapter> adapterProvider;
    private final Provider<AssignmentsPresenter> presenterProvider;

    public AssignmentsFragment_MembersInjector(Provider<AssignmentsAdapter> provider, Provider<AssignmentsPresenter> provider2) {
        this.adapterProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<AssignmentsFragment> create(Provider<AssignmentsAdapter> provider, Provider<AssignmentsPresenter> provider2) {
        return new AssignmentsFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(AssignmentsFragment assignmentsFragment) {
        if (assignmentsFragment != null) {
            assignmentsFragment.adapter = (AssignmentsAdapter) this.adapterProvider.get();
            assignmentsFragment.presenter = (AssignmentsPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
