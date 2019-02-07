package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.CoursesAdapter;
import com.aeries.mobileportal.adapters.CoursesAdapter.CourseListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CourseSelectFragmentModule_CoursesAdapterFactory implements Factory<CoursesAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CourseListener> listenerProvider;
    private final CourseSelectFragmentModule module;

    public CourseSelectFragmentModule_CoursesAdapterFactory(CourseSelectFragmentModule courseSelectFragmentModule, Provider<CourseListener> provider) {
        this.module = courseSelectFragmentModule;
        this.listenerProvider = provider;
    }

    public CoursesAdapter get() {
        return (CoursesAdapter) Preconditions.checkNotNull(this.module.coursesAdapter((CourseListener) this.listenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CoursesAdapter> create(CourseSelectFragmentModule courseSelectFragmentModule, Provider<CourseListener> provider) {
        return new CourseSelectFragmentModule_CoursesAdapterFactory(courseSelectFragmentModule, provider);
    }
}
