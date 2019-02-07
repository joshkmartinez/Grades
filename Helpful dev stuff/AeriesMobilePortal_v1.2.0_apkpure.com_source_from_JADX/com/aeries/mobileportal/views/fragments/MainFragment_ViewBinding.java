package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import de.hdodenhof.circleimageview.CircleImageView;

public final class MainFragment_ViewBinding implements Unbinder {
    private MainFragment target;
    private View view2131361847;
    private View view2131361985;

    @UiThread
    public MainFragment_ViewBinding(final MainFragment mainFragment, View view) {
        this.target = mainFragment;
        mainFragment.studentHeader = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.student_header, "field 'studentHeader'", ImageView.class);
        mainFragment.studentPicture = (CircleImageView) Utils.findRequiredViewAsType(view, C0316R.id.picture, "field 'studentPicture'", CircleImageView.class);
        mainFragment.studentNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.text, "field 'studentNameTV'", TextView.class);
        mainFragment.detailsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.details_recyclerview, "field 'detailsRV'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.badge, "field 'badge' and method 'onBadgeClick'");
        mainFragment.badge = (CardView) Utils.castView(findRequiredView, C0316R.id.badge, "field 'badge'", CardView.class);
        this.view2131361847 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                mainFragment.onBadgeClick();
            }
        });
        mainFragment.badgeNumber = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.badge_number, "field 'badgeNumber'", TextView.class);
        view = Utils.findRequiredView(view, C0316R.id.header_click, "method 'onStudentSelectClick'");
        this.view2131361985 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                mainFragment.onStudentSelectClick();
            }
        });
    }

    public void unbind() {
        MainFragment mainFragment = this.target;
        if (mainFragment != null) {
            this.target = null;
            mainFragment.studentHeader = null;
            mainFragment.studentPicture = null;
            mainFragment.studentNameTV = null;
            mainFragment.detailsRV = null;
            mainFragment.badge = null;
            mainFragment.badgeNumber = null;
            this.view2131361847.setOnClickListener(null);
            this.view2131361847 = null;
            this.view2131361985.setOnClickListener(null);
            this.view2131361985 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
