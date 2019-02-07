package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.view.View;
import android.view.View.OnLongClickListener;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class MainActivity_ViewBinding implements Unbinder {
    private MainActivity target;
    private View view2131361985;
    private View view2131362096;
    private View view2131362189;

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    @UiThread
    public MainActivity_ViewBinding(final MainActivity mainActivity, View view) {
        this.target = mainActivity;
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.header_click, "method 'onStudentSelectClick'");
        this.view2131361985 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                mainActivity.onStudentSelectClick();
            }
        });
        findRequiredView = Utils.findRequiredView(view, C0316R.id.picture, "method 'onStudentPictureLongClick'");
        this.view2131362096 = findRequiredView;
        findRequiredView.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                return mainActivity.onStudentPictureLongClick();
            }
        });
        view = Utils.findRequiredView(view, C0316R.id.text, "method 'onStudentNameLongClick'");
        this.view2131362189 = view;
        view.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                return mainActivity.onStudentNameLongClick();
            }
        });
    }

    public void unbind() {
        if (this.target != null) {
            this.target = null;
            this.view2131361985.setOnClickListener(null);
            this.view2131361985 = null;
            this.view2131362096.setOnLongClickListener(null);
            this.view2131362096 = null;
            this.view2131362189.setOnLongClickListener(null);
            this.view2131362189 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
