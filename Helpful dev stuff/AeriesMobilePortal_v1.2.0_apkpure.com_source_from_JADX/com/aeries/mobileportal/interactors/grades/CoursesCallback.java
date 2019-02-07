package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.models.SchoolClassSummary;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/interactors/grades/CoursesCallback;", "", "onClassSummariesError", "", "e", "", "onClassSummariesReceived", "classSummaries", "", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "showError", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CoursesCallback.kt */
public interface CoursesCallback {
    void onClassSummariesError(@NotNull Throwable th);

    void onClassSummariesReceived(@NotNull List<SchoolClassSummary> list);

    void showError(@NotNull Throwable th);
}
