package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import com.aeries.mobileportal.presenters.MainFragmentPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainFragment_MembersInjector implements MembersInjector<MainFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<StudentDetailsAdapter> adapterProvider;
    private final Provider<MainFragmentPresenter> presenterProvider;

    public MainFragment_MembersInjector(Provider<StudentDetailsAdapter> provider, Provider<MainFragmentPresenter> provider2) {
        this.adapterProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<MainFragment> create(Provider<StudentDetailsAdapter> provider, Provider<MainFragmentPresenter> provider2) {
        return new MainFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(MainFragment mainFragment) {
        if (mainFragment != null) {
            mainFragment.adapter = (StudentDetailsAdapter) this.adapterProvider.get();
            mainFragment.presenter = (MainFragmentPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
