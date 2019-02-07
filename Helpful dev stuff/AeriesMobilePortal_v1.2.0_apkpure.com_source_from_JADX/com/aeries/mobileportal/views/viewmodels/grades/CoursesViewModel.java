package com.aeries.mobileportal.views.viewmodels.grades;

import com.aeries.mobileportal.models.SchoolClassSummary;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/grades/CoursesViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showCourses", "", "summaries", "", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "showError", "e", "", "showErrorAndFinish", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CoursesViewModel.kt */
public interface CoursesViewModel extends BaseViewModel {
    void showCourses(@NotNull List<SchoolClassSummary> list);

    void showError(@Nullable String str);

    void showErrorAndFinish(@Nullable String str);
}
