package com.aeries.mobileportal.adapters;

import android.support.v7.util.DiffUtil.Callback;
import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentDiffCallback;", "Landroid/support/v7/util/DiffUtil$Callback;", "oldAssignments", "", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "newAssignments", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentDiffCallback.kt */
public final class AssignmentDiffCallback extends Callback {
    private final List<AssignmentRowViewModel> newAssignments;
    private final List<AssignmentRowViewModel> oldAssignments;

    public AssignmentDiffCallback(@NotNull List<AssignmentRowViewModel> list, @NotNull List<AssignmentRowViewModel> list2) {
        Intrinsics.checkParameterIsNotNull(list, "oldAssignments");
        Intrinsics.checkParameterIsNotNull(list2, "newAssignments");
        this.oldAssignments = list;
        this.newAssignments = list2;
    }

    public int getOldListSize() {
        return this.oldAssignments.size();
    }

    public int getNewListSize() {
        return this.newAssignments.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        return Intrinsics.areEqual((AssignmentRowViewModel) this.oldAssignments.get(i), (AssignmentRowViewModel) this.newAssignments.get(i2));
    }

    public boolean areContentsTheSame(int i, int i2) {
        return ((AssignmentRowViewModel) this.oldAssignments.get(i)).isMocked() == ((AssignmentRowViewModel) this.newAssignments.get(i2)).isMocked() && ((AssignmentRowViewModel) this.oldAssignments.get(i)).isModified() == ((AssignmentRowViewModel) this.newAssignments.get(i2)).isModified() && ((AssignmentRowViewModel) this.oldAssignments.get(i)).isModifying() == ((AssignmentRowViewModel) this.newAssignments.get(i2)).isModifying() && ((AssignmentRowViewModel) this.oldAssignments.get(i)).isDeleted() == ((AssignmentRowViewModel) this.newAssignments.get(i2)).isDeleted() && ((AssignmentRowViewModel) this.oldAssignments.get(i)).isEditShowing() == ((AssignmentRowViewModel) this.newAssignments.get(i2)).isEditShowing() && ((AssignmentRowViewModel) this.oldAssignments.get(i)).isAnimated() == ((AssignmentRowViewModel) this.newAssignments.get(i2)).isAnimated();
    }

    @Nullable
    public Object getChangePayload(int i, int i2) {
        return super.getChangePayload(i, i2);
    }
}
