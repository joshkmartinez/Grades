package com.aeries.mobileportal.views.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.aeries.mobileportal.views.activities.GradesActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/aeries/mobileportal/views/fragments/AssignmentParentFragment$onCreateView$whatIfBR$1", "Landroid/content/BroadcastReceiver;", "(Lcom/aeries/mobileportal/views/fragments/AssignmentParentFragment;)V", "onReceive", "", "p0", "Landroid/content/Context;", "p1", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentParentFragment.kt */
public final class AssignmentParentFragment$onCreateView$whatIfBR$1 extends BroadcastReceiver {
    final /* synthetic */ AssignmentParentFragment this$0;

    AssignmentParentFragment$onCreateView$whatIfBR$1(AssignmentParentFragment assignmentParentFragment) {
        this.this$0 = assignmentParentFragment;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        context = null;
        if (intent != null) {
            context = intent.getBooleanExtra(GradesActivity.Companion.getWHAT_IF_ENABLED(), false);
        }
        this.this$0.resetAssignments();
        if (this.this$0.getContext() != null) {
            this.this$0.getHeader().setEditMode(context);
        }
        intent = new Intent(AssignmentParentFragment.Companion.getASSIGNMENT_LIST_MODIFIED());
        intent.putExtra(GradesActivity.Companion.getWHAT_IF_ENABLED(), context);
        LocalBroadcastManager.getInstance(this.this$0.getContext()).sendBroadcast(intent);
    }
}
