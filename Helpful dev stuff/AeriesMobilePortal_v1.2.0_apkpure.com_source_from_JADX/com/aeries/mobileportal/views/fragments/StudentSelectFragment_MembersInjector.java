package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.StudentSelectAdapter;
import com.aeries.mobileportal.presenters.StudentSelectPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class StudentSelectFragment_MembersInjector implements MembersInjector<StudentSelectFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<StudentSelectAdapter> adapterProvider;
    private final Provider<StudentSelectPresenter> presenterProvider;

    public StudentSelectFragment_MembersInjector(Provider<StudentSelectAdapter> provider, Provider<StudentSelectPresenter> provider2) {
        this.adapterProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<StudentSelectFragment> create(Provider<StudentSelectAdapter> provider, Provider<StudentSelectPresenter> provider2) {
        return new StudentSelectFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(StudentSelectFragment studentSelectFragment) {
        if (studentSelectFragment != null) {
            studentSelectFragment.adapter = (StudentSelectAdapter) this.adapterProvider.get();
            studentSelectFragment.presenter = (StudentSelectPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
