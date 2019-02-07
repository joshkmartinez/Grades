package com.aeries.mobileportal.presenters;

import com.aeries.mobileportal.interactors.StudentSelectCallback;
import com.aeries.mobileportal.interactors.StudentSelectInteractor;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.views.viewmodels.StudentSelectViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/aeries/mobileportal/presenters/StudentSelectPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/StudentSelectViewModel;", "Lcom/aeries/mobileportal/interactors/StudentSelectCallback;", "vm", "interactor", "Lcom/aeries/mobileportal/interactors/StudentSelectInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/StudentSelectViewModel;Lcom/aeries/mobileportal/interactors/StudentSelectInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/StudentSelectInteractor;", "getVm", "()Lcom/aeries/mobileportal/views/viewmodels/StudentSelectViewModel;", "getStudents", "", "onCreate", "onStudentsRetreived", "students", "", "Lcom/aeries/mobileportal/models/Student;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentSelectPresenter.kt */
public final class StudentSelectPresenter extends BasePresenter<StudentSelectViewModel> implements StudentSelectCallback {
    @NotNull
    private final StudentSelectInteractor interactor;
    @NotNull
    private final StudentSelectViewModel vm;

    public void onCreate() {
    }

    @NotNull
    public final StudentSelectInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final StudentSelectViewModel getVm() {
        return this.vm;
    }

    public StudentSelectPresenter(@NotNull StudentSelectViewModel studentSelectViewModel, @NotNull StudentSelectInteractor studentSelectInteractor) {
        Intrinsics.checkParameterIsNotNull(studentSelectViewModel, "vm");
        Intrinsics.checkParameterIsNotNull(studentSelectInteractor, "interactor");
        super(studentSelectViewModel, studentSelectInteractor);
        this.vm = studentSelectViewModel;
        this.interactor = studentSelectInteractor;
    }

    public final void getStudents() {
        this.interactor.getStudents(this);
    }

    public void onStudentsRetreived(@NotNull List<? extends Student> list) {
        Intrinsics.checkParameterIsNotNull(list, "students");
        this.vm.showStudents(list);
    }
}
