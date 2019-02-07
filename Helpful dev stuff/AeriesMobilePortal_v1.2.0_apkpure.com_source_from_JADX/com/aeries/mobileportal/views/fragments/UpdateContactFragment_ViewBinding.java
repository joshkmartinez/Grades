package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class UpdateContactFragment_ViewBinding implements Unbinder {
    private UpdateContactFragment target;
    private View view2131362058;
    private View view2131362071;

    @UiThread
    public UpdateContactFragment_ViewBinding(final UpdateContactFragment updateContactFragment, View view) {
        this.target = updateContactFragment;
        updateContactFragment.guardiansRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.guardians_rv, "field 'guardiansRV'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.next_button, "field 'nextButton' and method 'onNextPressed'");
        updateContactFragment.nextButton = (Button) Utils.castView(findRequiredView, C0316R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131362058 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                updateContactFragment.onNextPressed();
            }
        });
        view = Utils.findRequiredView(view, C0316R.id.not_me_tv, "field 'notMeTextView' and method 'onNotMePressed'");
        updateContactFragment.notMeTextView = (TextView) Utils.castView(view, C0316R.id.not_me_tv, "field 'notMeTextView'", TextView.class);
        this.view2131362071 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                updateContactFragment.onNotMePressed();
            }
        });
    }

    public void unbind() {
        UpdateContactFragment updateContactFragment = this.target;
        if (updateContactFragment != null) {
            this.target = null;
            updateContactFragment.guardiansRV = null;
            updateContactFragment.nextButton = null;
            updateContactFragment.notMeTextView = null;
            this.view2131362058.setOnClickListener(null);
            this.view2131362058 = null;
            this.view2131362071.setOnClickListener(null);
            this.view2131362071 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
