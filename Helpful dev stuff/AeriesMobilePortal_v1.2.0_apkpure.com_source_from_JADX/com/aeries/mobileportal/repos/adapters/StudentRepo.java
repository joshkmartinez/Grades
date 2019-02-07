package com.aeries.mobileportal.repos.adapters;

import com.aeries.mobileportal.models.Student;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH&J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "", "addFeedbackPermission", "", "studentID", "", "addSignalKitPermission", "deleteStudents", "getStudent", "Lcom/aeries/mobileportal/models/Student;", "getStudents", "", "replaceStudents", "students", "", "updateStudents", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentRepo.kt */
public interface StudentRepo {
    void addFeedbackPermission(int i);

    void addSignalKitPermission(int i);

    void deleteStudents();

    @Nullable
    Student getStudent(int i);

    @NotNull
    List<Student> getStudents();

    void replaceStudents(@NotNull List<? extends Student> list);

    void updateStudents(@NotNull List<? extends Student> list);
}
