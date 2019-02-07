package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.SchoolListAdapter;
import com.aeries.mobileportal.presenters.SchoolSearchFragmentPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SchoolSearchFragment_MembersInjector implements MembersInjector<SchoolSearchFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SchoolSearchFragmentPresenter> presenterProvider;
    private final Provider<SchoolListAdapter> schoolsAdapterProvider;

    public SchoolSearchFragment_MembersInjector(Provider<SchoolListAdapter> provider, Provider<SchoolSearchFragmentPresenter> provider2) {
        this.schoolsAdapterProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<SchoolSearchFragment> create(Provider<SchoolListAdapter> provider, Provider<SchoolSearchFragmentPresenter> provider2) {
        return new SchoolSearchFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(SchoolSearchFragment schoolSearchFragment) {
        if (schoolSearchFragment != null) {
            schoolSearchFragment.schoolsAdapter = (SchoolListAdapter) this.schoolsAdapterProvider.get();
            schoolSearchFragment.presenter = (SchoolSearchFragmentPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
