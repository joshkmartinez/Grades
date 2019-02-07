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

public final class SessionSelectFragment_ViewBinding implements Unbinder {
    private SessionSelectFragment target;
    private View view2131361855;
    private View view2131361870;

    @UiThread
    public SessionSelectFragment_ViewBinding(final SessionSelectFragment sessionSelectFragment, View view) {
        this.target = sessionSelectFragment;
        sessionSelectFragment.messageTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.session_message, "field 'messageTV'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.check_in_button, "field 'checkInButton' and method 'onCheckInPressed'");
        sessionSelectFragment.checkInButton = (Button) Utils.castView(findRequiredView, C0316R.id.check_in_button, "field 'checkInButton'", Button.class);
        this.view2131361870 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                sessionSelectFragment.onCheckInPressed();
            }
        });
        sessionSelectFragment.sessionsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.sessions_rv, "field 'sessionsRV'", RecyclerView.class);
        findRequiredView = Utils.findRequiredView(view, C0316R.id.cancel, "field 'cancelButton' and method 'onCancelPressed'");
        sessionSelectFragment.cancelButton = (Button) Utils.castView(findRequiredView, C0316R.id.cancel, "field 'cancelButton'", Button.class);
        this.view2131361855 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                sessionSelectFragment.onCancelPressed();
            }
        });
        sessionSelectFragment.noSessionsTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.no_sessions_tv, "field 'noSessionsTV'", TextView.class);
    }

    public void unbind() {
        SessionSelectFragment sessionSelectFragment = this.target;
        if (sessionSelectFragment != null) {
            this.target = null;
            sessionSelectFragment.messageTV = null;
            sessionSelectFragment.checkInButton = null;
            sessionSelectFragment.sessionsRV = null;
            sessionSelectFragment.cancelButton = null;
            sessionSelectFragment.noSessionsTV = null;
            this.view2131361870.setOnClickListener(null);
            this.view2131361870 = null;
            this.view2131361855.setOnClickListener(null);
            this.view2131361855 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
