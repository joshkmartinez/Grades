package com.aeries.mobileportal.views.viewmodels;

import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/StudentSelectViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showStudents", "", "students", "", "Lcom/aeries/mobileportal/models/Student;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentSelectViewModel.kt */
public interface StudentSelectViewModel extends BaseViewModel {
    void showStudents(@NotNull List<? extends Student> list);
}
