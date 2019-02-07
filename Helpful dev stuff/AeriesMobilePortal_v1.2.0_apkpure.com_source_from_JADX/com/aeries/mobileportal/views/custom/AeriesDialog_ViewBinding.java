package com.aeries.mobileportal.views.custom;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AeriesDialog_ViewBinding implements Unbinder {
    private AeriesDialog target;

    @UiThread
    public AeriesDialog_ViewBinding(AeriesDialog aeriesDialog, View view) {
        this.target = aeriesDialog;
        aeriesDialog.message = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.message, "field 'message'", TextView.class);
        aeriesDialog.actionButton = (Button) Utils.findRequiredViewAsType(view, C0316R.id.action_button, "field 'actionButton'", Button.class);
        aeriesDialog.schoolName = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.title, "field 'schoolName'", TextView.class);
    }

    public void unbind() {
        AeriesDialog aeriesDialog = this.target;
        if (aeriesDialog != null) {
            this.target = null;
            aeriesDialog.message = null;
            aeriesDialog.actionButton = null;
            aeriesDialog.schoolName = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
