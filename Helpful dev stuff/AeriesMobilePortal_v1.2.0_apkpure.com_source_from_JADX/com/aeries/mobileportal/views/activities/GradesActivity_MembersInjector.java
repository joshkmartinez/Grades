package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.grades.GradesPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class GradesActivity_MembersInjector implements MembersInjector<GradesActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<GradesPresenter> presenterProvider;

    public GradesActivity_MembersInjector(Provider<GradesPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<GradesActivity> create(Provider<GradesPresenter> provider) {
        return new GradesActivity_MembersInjector(provider);
    }

    public void injectMembers(GradesActivity gradesActivity) {
        if (gradesActivity != null) {
            gradesActivity.presenter = (GradesPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
