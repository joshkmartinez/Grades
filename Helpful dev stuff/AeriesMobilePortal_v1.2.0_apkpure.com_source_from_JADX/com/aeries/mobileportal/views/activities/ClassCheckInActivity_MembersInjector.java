package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.supplemental_attendance.ClassCheckInPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ClassCheckInActivity_MembersInjector implements MembersInjector<ClassCheckInActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ClassCheckInPresenter> presenterProvider;

    public ClassCheckInActivity_MembersInjector(Provider<ClassCheckInPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<ClassCheckInActivity> create(Provider<ClassCheckInPresenter> provider) {
        return new ClassCheckInActivity_MembersInjector(provider);
    }

    public void injectMembers(ClassCheckInActivity classCheckInActivity) {
        if (classCheckInActivity != null) {
            classCheckInActivity.presenter = (ClassCheckInPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
