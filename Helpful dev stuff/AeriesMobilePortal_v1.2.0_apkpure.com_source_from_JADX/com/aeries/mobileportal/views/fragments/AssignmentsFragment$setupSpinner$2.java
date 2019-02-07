package com.aeries.mobileportal.views.fragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"com/aeries/mobileportal/views/fragments/AssignmentsFragment$setupSpinner$2", "Landroid/widget/AdapterView$OnItemSelectedListener;", "(Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment;)V", "onItemSelected", "", "p0", "Landroid/widget/AdapterView;", "p1", "Landroid/view/View;", "p2", "", "p3", "", "onNothingSelected", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentsFragment.kt */
public final class AssignmentsFragment$setupSpinner$2 implements OnItemSelectedListener {
    final /* synthetic */ AssignmentsFragment this$0;

    public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
    }

    AssignmentsFragment$setupSpinner$2(AssignmentsFragment assignmentsFragment) {
        this.this$0 = assignmentsFragment;
    }

    public void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        this.this$0.updateAssignmentList(this.this$0.getAssignments());
    }
}
