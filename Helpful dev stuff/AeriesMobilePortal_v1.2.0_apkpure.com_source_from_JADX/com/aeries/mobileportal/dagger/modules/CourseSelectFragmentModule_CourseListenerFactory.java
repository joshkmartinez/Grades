package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.CoursesAdapter.CourseListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class CourseSelectFragmentModule_CourseListenerFactory implements Factory<CourseListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final CourseSelectFragmentModule module;

    public CourseSelectFragmentModule_CourseListenerFactory(CourseSelectFragmentModule courseSelectFragmentModule) {
        this.module = courseSelectFragmentModule;
    }

    public CourseListener get() {
        return (CourseListener) Preconditions.checkNotNull(this.module.courseListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CourseListener> create(CourseSelectFragmentModule courseSelectFragmentModule) {
        return new CourseSelectFragmentModule_CourseListenerFactory(courseSelectFragmentModule);
    }
}
