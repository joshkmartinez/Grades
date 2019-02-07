package com.aeries.mobileportal.adapters;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.MockAssignment;
import com.aeries.mobileportal.views.custom.AssignmentRowView;
import com.aeries.mobileportal.views.custom.AssignmentRowView.AssignmentRowListener;
import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u000212B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001e\u0010\u001b\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001e\u0010!\u001a\u00060\u0002R\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0010H\u0016J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0017\u0010*\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\u000e\u0010.\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010/\u001a\u00020\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t00R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$ViewHolder;", "Lcom/aeries/mobileportal/views/custom/AssignmentRowView$AssignmentRowListener;", "listener", "Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$AssignmentListener;", "(Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$AssignmentListener;)V", "assignments", "", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "isEditModeEnabled", "", "getListener", "()Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$AssignmentListener;", "modifiedIndexes", "", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getAssignmentIndex", "assignmentNumber", "(Ljava/lang/Integer;)I", "getItemCount", "isInEditMode", "onAssignmentNotEditable", "", "onAttachedToRecyclerView", "onBindViewHolder", "holder", "position", "onClick", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDelete", "mockAssignment", "Lcom/aeries/mobileportal/models/MockAssignment;", "isMocked", "onModify", "onViewModified", "(Ljava/lang/Integer;)V", "removeMockAssignments", "restoreModifiedItems", "setEditModeEnabled", "update", "", "AssignmentListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentsAdapter.kt */
public final class AssignmentsAdapter extends Adapter<ViewHolder> implements AssignmentRowListener {
    private final List<AssignmentRowViewModel> assignments = ((List) new ArrayList());
    private boolean isEditModeEnabled;
    @NotNull
    private final AssignmentListener listener;
    private Set<Integer> modifiedIndexes = ((Set) new LinkedHashSet());
    private RecyclerView recyclerView;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$AssignmentListener;", "", "isEditModeEnabled", "", "onAssignmentMocked", "", "mockAssignment", "Lcom/aeries/mobileportal/models/MockAssignment;", "onAssignmentSelected", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "onRemoveMockAssignment", "isMocked", "showAssignmentDisabledMessage", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentsAdapter.kt */
    public interface AssignmentListener {
        boolean isEditModeEnabled();

        void onAssignmentMocked(@NotNull MockAssignment mockAssignment);

        void onAssignmentSelected(@NotNull Assignment assignment);

        void onRemoveMockAssignment(@NotNull MockAssignment mockAssignment, boolean z);

        void showAssignmentDisabledMessage();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AssignmentsAdapter;Landroid/view/View;)V", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentsAdapter.kt */
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        final /* synthetic */ AssignmentsAdapter this$0;

        public ViewHolder(@NotNull AssignmentsAdapter assignmentsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = assignmentsAdapter;
            super(view);
        }
    }

    @NotNull
    public final AssignmentListener getListener() {
        return this.listener;
    }

    public AssignmentsAdapter(@NotNull AssignmentListener assignmentListener) {
        Intrinsics.checkParameterIsNotNull(assignmentListener, CastExtraArgs.LISTENER);
        this.listener = assignmentListener;
    }

    public int getItemCount() {
        return this.assignments.size();
    }

    public void onBindViewHolder(@Nullable ViewHolder viewHolder, int i) {
        Context context = null;
        View view = viewHolder != null ? viewHolder.itemView : null;
        if (view != null) {
            AssignmentRowView assignmentRowView = (AssignmentRowView) view;
            AssignmentRowViewModel assignmentRowViewModel = (AssignmentRowViewModel) this.assignments.get(i);
            assignmentRowView.setListener(this);
            assignmentRowView.setData(assignmentRowViewModel);
            if (assignmentRowViewModel.isAnimated()) {
                view = viewHolder.itemView;
                if (view != null) {
                    context = view.getContext();
                }
                viewHolder.itemView.startAnimation(AnimationUtils.loadAnimation(context, 17432578));
                assignmentRowViewModel.setAnimated(assignmentRowViewModel.isAnimated() ^ 1);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.views.custom.AssignmentRowView");
    }

    public void onAttachedToRecyclerView(@Nullable RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        return new ViewHolder(this, new AssignmentRowView(viewGroup != null ? viewGroup.getContext() : null));
    }

    public final void update(@NotNull List<AssignmentRowViewModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "assignments");
        DiffResult calculateDiff = DiffUtil.calculateDiff(new AssignmentDiffCallback(this.assignments, list));
        this.assignments.clear();
        this.assignments.addAll(list);
        calculateDiff.dispatchUpdatesTo((Adapter) this);
    }

    private final void removeMockAssignments() {
        int i = 0;
        for (AssignmentRowViewModel isMocked : this.assignments) {
            if (isMocked.isMocked()) {
                i++;
            }
        }
        CollectionsKt.removeAll(this.assignments, AssignmentsAdapter$removeMockAssignments$2.INSTANCE);
        notifyItemRangeRemoved(0, i);
    }

    public final void setEditModeEnabled(boolean z) {
        this.isEditModeEnabled = z;
        restoreModifiedItems();
        removeMockAssignments();
    }

    private final void restoreModifiedItems() {
        for (Number intValue : this.modifiedIndexes) {
            notifyItemChanged(intValue.intValue());
        }
        int i = 0;
        for (AssignmentRowViewModel isEditDisabled : this.assignments) {
            if (isEditDisabled.isEditDisabled()) {
                notifyItemChanged(i);
            }
            i++;
        }
        this.modifiedIndexes.clear();
    }

    public void onClick(@NotNull Assignment assignment) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        this.listener.onAssignmentSelected(assignment);
    }

    public void onDelete(@NotNull MockAssignment mockAssignment, boolean z) {
        Intrinsics.checkParameterIsNotNull(mockAssignment, "mockAssignment");
        ((AssignmentRowViewModel) this.assignments.get(getAssignmentIndex(Integer.valueOf(Integer.parseInt(mockAssignment.getAssignmentNumber()))))).setEditShowing(true);
        this.listener.onRemoveMockAssignment(mockAssignment, z);
    }

    public void onModify(@NotNull MockAssignment mockAssignment) {
        Intrinsics.checkParameterIsNotNull(mockAssignment, "mockAssignment");
        this.modifiedIndexes.add(Integer.valueOf(getAssignmentIndex(Integer.valueOf(Integer.parseInt(mockAssignment.getAssignmentNumber())))));
        ((AssignmentRowViewModel) this.assignments.get(getAssignmentIndex(Integer.valueOf(Integer.parseInt(mockAssignment.getAssignmentNumber()))))).setEditShowing(true);
        this.listener.onAssignmentMocked(mockAssignment);
    }

    private final int getAssignmentIndex(Integer num) {
        int i = 0;
        for (AssignmentRowViewModel assignment : this.assignments) {
            if (Intrinsics.areEqual(assignment.getAssignment().getAssignmentNumber(), (Object) num)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void onAssignmentNotEditable() {
        this.listener.showAssignmentDisabledMessage();
    }

    public void onViewModified(@Nullable Integer num) {
        this.modifiedIndexes.add(Integer.valueOf(getAssignmentIndex(num)));
    }

    public boolean isInEditMode() {
        return this.listener.isEditModeEnabled();
    }
}
