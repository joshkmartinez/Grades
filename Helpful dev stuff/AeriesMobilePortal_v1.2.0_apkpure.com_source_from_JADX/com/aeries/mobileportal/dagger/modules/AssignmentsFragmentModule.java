package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AssignmentsAdapter;
import com.aeries.mobileportal.adapters.AssignmentsAdapter.AssignmentListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AssignmentsFragmentModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$AssignmentListener;", "(Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$AssignmentListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$AssignmentListener;", "assignmentAdapter", "Lcom/aeries/mobileportal/adapters/AssignmentsAdapter;", "assignmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AssignmentsFragmentModule.kt */
public final class AssignmentsFragmentModule {
    @NotNull
    private final AssignmentListener listener;

    public AssignmentsFragmentModule(@NotNull AssignmentListener assignmentListener) {
        Intrinsics.checkParameterIsNotNull(assignmentListener, CastExtraArgs.LISTENER);
        this.listener = assignmentListener;
    }

    @NotNull
    public final AssignmentListener getListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentListener assignmentListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentsAdapter assignmentAdapter(@NotNull AssignmentListener assignmentListener) {
        Intrinsics.checkParameterIsNotNull(assignmentListener, CastExtraArgs.LISTENER);
        return new AssignmentsAdapter(assignmentListener);
    }
}
