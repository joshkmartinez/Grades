package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.models.Gradebook;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/interactors/grades/AssignmentParentCallback;", "", "onGradebookError", "", "e", "", "onGradebookReceived", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentParentCallback.kt */
public interface AssignmentParentCallback {
    void onGradebookError(@NotNull Throwable th);

    void onGradebookReceived(@NotNull Gradebook gradebook);
}