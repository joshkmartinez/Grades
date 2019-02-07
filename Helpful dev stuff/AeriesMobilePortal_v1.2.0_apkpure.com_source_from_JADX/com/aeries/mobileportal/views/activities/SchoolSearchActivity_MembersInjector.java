package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.school.select.SchoolSearchPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SchoolSearchActivity_MembersInjector implements MembersInjector<SchoolSearchActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SchoolSearchPresenter> presenterProvider;

    public SchoolSearchActivity_MembersInjector(Provider<SchoolSearchPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<SchoolSearchActivity> create(Provider<SchoolSearchPresenter> provider) {
        return new SchoolSearchActivity_MembersInjector(provider);
    }

    public void injectMembers(SchoolSearchActivity schoolSearchActivity) {
        if (schoolSearchActivity != null) {
            schoolSearchActivity.presenter = (SchoolSearchPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
