package com.aeries.mobileportal.interactors.tablet;

import com.aeries.mobileportal.models.SchoolClassSummary;
import com.aeries.mobileportal.models.Student;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J \u0010\u000b\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H&¨\u0006\u0016"}, d2 = {"Lcom/aeries/mobileportal/interactors/tablet/MainTabletCallback;", "", "displaySettingsParent", "", "settings", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "students", "", "Lcom/aeries/mobileportal/models/Student;", "displaySettingsStudent", "onCoursesError", "e", "", "onCoursesRetrieved", "courses", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "setGradesViewsVisibility", "dropdown", "", "lastUpdated", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainTabletCallback.kt */
public interface MainTabletCallback {
    void displaySettingsParent(@NotNull ArrayList<String> arrayList, @NotNull List<Student> list);

    void displaySettingsStudent(@NotNull ArrayList<String> arrayList);

    void onCoursesError(@NotNull Throwable th);

    void onCoursesRetrieved(@NotNull List<SchoolClassSummary> list);

    void setGradesViewsVisibility(boolean z, boolean z2);
}
