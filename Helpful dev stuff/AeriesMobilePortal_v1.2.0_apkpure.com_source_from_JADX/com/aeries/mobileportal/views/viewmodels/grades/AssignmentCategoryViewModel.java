package com.aeries.mobileportal.views.viewmodels.grades;

import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentCategoryViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showCategories", "", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "showError", "e", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentCategoryViewModel.kt */
public interface AssignmentCategoryViewModel extends BaseViewModel {
    void showCategories(@NotNull Gradebook gradebook);

    void showError(@NotNull Throwable th);
}
