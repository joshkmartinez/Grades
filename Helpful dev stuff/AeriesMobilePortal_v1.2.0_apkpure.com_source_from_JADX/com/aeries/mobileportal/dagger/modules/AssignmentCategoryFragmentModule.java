package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AssignmentCategoriesAdapter;
import com.aeries.mobileportal.adapters.AssignmentCategoriesAdapter.AssignmentCategoriesAdapterListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AssignmentCategoryFragmentModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$AssignmentCategoriesAdapterListener;", "(Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$AssignmentCategoriesAdapterListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$AssignmentCategoriesAdapterListener;", "assignmentCategoriesAdapter", "Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AssignmentCategoryFragmentModule.kt */
public final class AssignmentCategoryFragmentModule {
    @NotNull
    private final AssignmentCategoriesAdapterListener listener;

    public AssignmentCategoryFragmentModule(@NotNull AssignmentCategoriesAdapterListener assignmentCategoriesAdapterListener) {
        Intrinsics.checkParameterIsNotNull(assignmentCategoriesAdapterListener, CastExtraArgs.LISTENER);
        this.listener = assignmentCategoriesAdapterListener;
    }

    @NotNull
    public final AssignmentCategoriesAdapterListener getListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentCategoriesAdapter assignmentCategoriesAdapter() {
        return new AssignmentCategoriesAdapter(this.listener);
    }
}
