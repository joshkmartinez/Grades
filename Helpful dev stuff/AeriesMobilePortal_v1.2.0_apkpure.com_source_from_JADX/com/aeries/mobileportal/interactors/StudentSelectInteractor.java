package com.aeries.mobileportal.interactors;

import com.aeries.mobileportal.repos.adapters.StudentRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/interactors/StudentSelectInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "(Lcom/aeries/mobileportal/repos/adapters/StudentRepo;)V", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getStudents", "", "callback", "Lcom/aeries/mobileportal/interactors/StudentSelectCallback;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentSelectInteractor.kt */
public final class StudentSelectInteractor extends BaseInteractor {
    @NotNull
    private final StudentRepo studentRepo;

    public StudentSelectInteractor(@NotNull StudentRepo studentRepo) {
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        this.studentRepo = studentRepo;
    }

    @NotNull
    public final StudentRepo getStudentRepo() {
        return this.studentRepo;
    }

    public final void getStudents(@NotNull StudentSelectCallback studentSelectCallback) {
        Intrinsics.checkParameterIsNotNull(studentSelectCallback, "callback");
        studentSelectCallback.onStudentsRetreived(this.studentRepo.getStudents());
    }
}
