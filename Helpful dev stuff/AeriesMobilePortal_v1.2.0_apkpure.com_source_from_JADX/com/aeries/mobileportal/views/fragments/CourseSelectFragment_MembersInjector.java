package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.CoursesAdapter;
import com.aeries.mobileportal.presenters.grades.CoursesPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CourseSelectFragment_MembersInjector implements MembersInjector<CourseSelectFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CoursesAdapter> adapterProvider;
    private final Provider<CoursesPresenter> presenterProvider;

    public CourseSelectFragment_MembersInjector(Provider<CoursesAdapter> provider, Provider<CoursesPresenter> provider2) {
        this.adapterProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<CourseSelectFragment> create(Provider<CoursesAdapter> provider, Provider<CoursesPresenter> provider2) {
        return new CourseSelectFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(CourseSelectFragment courseSelectFragment) {
        if (courseSelectFragment != null) {
            courseSelectFragment.adapter = (CoursesAdapter) this.adapterProvider.get();
            courseSelectFragment.presenter = (CoursesPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
