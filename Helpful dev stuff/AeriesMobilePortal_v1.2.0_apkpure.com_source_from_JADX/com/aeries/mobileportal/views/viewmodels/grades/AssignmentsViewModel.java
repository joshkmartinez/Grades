package com.aeries.mobileportal.views.viewmodels.grades;

import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentsViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showAssignments", "", "assignments", "", "Lcom/aeries/mobileportal/models/Assignment;", "showError", "e", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentsViewModel.kt */
public interface AssignmentsViewModel extends BaseViewModel {
    void showAssignments(@Nullable List<? extends Assignment> list);

    void showError(@NotNull Throwable th);
}
