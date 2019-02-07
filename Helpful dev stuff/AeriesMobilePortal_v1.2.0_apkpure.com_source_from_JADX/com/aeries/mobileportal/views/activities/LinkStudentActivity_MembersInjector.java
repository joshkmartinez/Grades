package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.link_student.LinkStudentPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LinkStudentActivity_MembersInjector implements MembersInjector<LinkStudentActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<LinkStudentPresenter> presenterProvider;

    public LinkStudentActivity_MembersInjector(Provider<LinkStudentPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<LinkStudentActivity> create(Provider<LinkStudentPresenter> provider) {
        return new LinkStudentActivity_MembersInjector(provider);
    }

    public void injectMembers(LinkStudentActivity linkStudentActivity) {
        if (linkStudentActivity != null) {
            linkStudentActivity.presenter = (LinkStudentPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
