package com.aeries.mobileportal.views.fragments;

import android.support.v4.app.Fragment;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.CourseSelectFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerCourseSelectFragmentComponent;
import com.aeries.mobileportal.dagger.modules.CourseSelectFragmentModule;
import com.aeries.mobileportal.dagger.modules.CoursesPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/CourseSelectFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: CourseSelectFragment.kt */
final class CourseSelectFragment$component$2 extends Lambda implements Function0<CourseSelectFragmentComponent> {
    final /* synthetic */ CourseSelectFragment this$0;

    CourseSelectFragment$component$2(CourseSelectFragment courseSelectFragment) {
        this.this$0 = courseSelectFragment;
        super(0);
    }

    public final CourseSelectFragmentComponent invoke() {
        return DaggerCourseSelectFragmentComponent.builder().courseSelectFragmentModule(new CourseSelectFragmentModule(this.this$0)).coursesPresenterModule(new CoursesPresenterModule(this.this$0)).pSPComponent(PSPApplication.Companion.get((Fragment) this.this$0)).build();
    }
}
