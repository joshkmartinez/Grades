package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.StudentSelectAdapter;
import com.aeries.mobileportal.adapters.StudentSelectAdapter.StudentSelectListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.StudentSelectInteractor;
import com.aeries.mobileportal.presenters.StudentSelectPresenter;
import com.aeries.mobileportal.views.viewmodels.StudentSelectViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/StudentSelectFragmentModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentSelectListener;", "vm", "Lcom/aeries/mobileportal/views/viewmodels/StudentSelectViewModel;", "(Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentSelectListener;Lcom/aeries/mobileportal/views/viewmodels/StudentSelectViewModel;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentSelectListener;", "getVm", "()Lcom/aeries/mobileportal/views/viewmodels/StudentSelectViewModel;", "studentSelectAdapter", "Lcom/aeries/mobileportal/adapters/StudentSelectAdapter;", "studentSelectPresenter", "Lcom/aeries/mobileportal/presenters/StudentSelectPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/StudentSelectInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: StudentSelectFragmentModule.kt */
public final class StudentSelectFragmentModule {
    @NotNull
    private final StudentSelectListener listener;
    @NotNull
    private final StudentSelectViewModel vm;

    public StudentSelectFragmentModule(@NotNull StudentSelectListener studentSelectListener, @NotNull StudentSelectViewModel studentSelectViewModel) {
        Intrinsics.checkParameterIsNotNull(studentSelectListener, CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(studentSelectViewModel, "vm");
        this.listener = studentSelectListener;
        this.vm = studentSelectViewModel;
    }

    @NotNull
    public final StudentSelectListener getListener() {
        return this.listener;
    }

    @NotNull
    public final StudentSelectViewModel getVm() {
        return this.vm;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final StudentSelectAdapter studentSelectAdapter() {
        return new StudentSelectAdapter(this.listener);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final StudentSelectPresenter studentSelectPresenter(@NotNull StudentSelectInteractor studentSelectInteractor) {
        Intrinsics.checkParameterIsNotNull(studentSelectInteractor, "interactor");
        return new StudentSelectPresenter(this.vm, studentSelectInteractor);
    }
}
