package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.AssignmentDetailsAdapter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AssignmentDetailsFragment_MembersInjector implements MembersInjector<AssignmentDetailsFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AssignmentDetailsAdapter> adapterProvider;

    public AssignmentDetailsFragment_MembersInjector(Provider<AssignmentDetailsAdapter> provider) {
        this.adapterProvider = provider;
    }

    public static MembersInjector<AssignmentDetailsFragment> create(Provider<AssignmentDetailsAdapter> provider) {
        return new AssignmentDetailsFragment_MembersInjector(provider);
    }

    public void injectMembers(AssignmentDetailsFragment assignmentDetailsFragment) {
        if (assignmentDetailsFragment != null) {
            assignmentDetailsFragment.adapter = (AssignmentDetailsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
