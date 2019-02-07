package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.models.MockGrade;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/interactors/grades/GradesCallback;", "", "onClassSummariesError", "", "e", "", "onMockGradeReceived", "mockGrade", "Lcom/aeries/mobileportal/models/MockGrade;", "gradebookNumber", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GradesCallback.kt */
public interface GradesCallback {
    void onClassSummariesError(@NotNull Throwable th);

    void onMockGradeReceived(@NotNull MockGrade mockGrade, @NotNull String str);
}
