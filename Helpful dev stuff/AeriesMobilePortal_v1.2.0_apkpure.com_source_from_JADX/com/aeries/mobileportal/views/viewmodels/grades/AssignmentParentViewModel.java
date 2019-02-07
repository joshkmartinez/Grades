package com.aeries.mobileportal.views.viewmodels.grades;

import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentParentViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "getShowCategories", "", "showAssignments", "", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "showCategories", "showError", "e", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentParentViewModel.kt */
public interface AssignmentParentViewModel extends BaseViewModel {
    boolean getShowCategories();

    void showAssignments(@NotNull Gradebook gradebook);

    void showCategories(@NotNull Gradebook gradebook);

    void showError(@NotNull Throwable th);
}
