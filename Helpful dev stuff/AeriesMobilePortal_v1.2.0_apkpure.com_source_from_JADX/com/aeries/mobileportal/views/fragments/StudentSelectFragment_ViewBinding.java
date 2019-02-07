package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class StudentSelectFragment_ViewBinding implements Unbinder {
    private StudentSelectFragment target;
    private View view2131361882;

    @UiThread
    public StudentSelectFragment_ViewBinding(final StudentSelectFragment studentSelectFragment, View view) {
        this.target = studentSelectFragment;
        studentSelectFragment.studentRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.recycler_view, "field 'studentRV'", RecyclerView.class);
        view = Utils.findRequiredView(view, C0316R.id.close_icon, "field 'closeIcon' and method 'close'");
        studentSelectFragment.closeIcon = (ImageView) Utils.castView(view, C0316R.id.close_icon, "field 'closeIcon'", ImageView.class);
        this.view2131361882 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                studentSelectFragment.close();
            }
        });
    }

    public void unbind() {
        StudentSelectFragment studentSelectFragment = this.target;
        if (studentSelectFragment != null) {
            this.target = null;
            studentSelectFragment.studentRV = null;
            studentSelectFragment.closeIcon = null;
            this.view2131361882.setOnClickListener(null);
            this.view2131361882 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
