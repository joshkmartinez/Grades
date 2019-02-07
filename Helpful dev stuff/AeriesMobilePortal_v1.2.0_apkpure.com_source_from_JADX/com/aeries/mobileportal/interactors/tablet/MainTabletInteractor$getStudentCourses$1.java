package com.aeries.mobileportal.interactors.tablet;

import com.aeries.mobileportal.models.SchoolClassSummary;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: MainTabletInteractor.kt */
final class MainTabletInteractor$getStudentCourses$1<T> implements Consumer<List<SchoolClassSummary>> {
    final /* synthetic */ MainTabletCallback $callback;

    MainTabletInteractor$getStudentCourses$1(MainTabletCallback mainTabletCallback) {
        this.$callback = mainTabletCallback;
    }

    public final void accept(List<SchoolClassSummary> list) {
        MainTabletCallback mainTabletCallback = this.$callback;
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        mainTabletCallback.onCoursesRetrieved(list);
    }
}
