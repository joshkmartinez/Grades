package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.CoursesAdapter;
import com.aeries.mobileportal.adapters.CoursesAdapter.CourseListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/CourseSelectFragmentModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/CoursesAdapter$CourseListener;", "(Lcom/aeries/mobileportal/adapters/CoursesAdapter$CourseListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/CoursesAdapter$CourseListener;", "courseListener", "coursesAdapter", "Lcom/aeries/mobileportal/adapters/CoursesAdapter;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: CourseSelectFragmentModule.kt */
public final class CourseSelectFragmentModule {
    @NotNull
    private final CourseListener listener;

    public CourseSelectFragmentModule(@NotNull CourseListener courseListener) {
        Intrinsics.checkParameterIsNotNull(courseListener, CastExtraArgs.LISTENER);
        this.listener = courseListener;
    }

    @NotNull
    public final CourseListener getListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final CourseListener courseListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final CoursesAdapter coursesAdapter(@NotNull CourseListener courseListener) {
        Intrinsics.checkParameterIsNotNull(courseListener, CastExtraArgs.LISTENER);
        return new CoursesAdapter(courseListener);
    }
}
