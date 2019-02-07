package com.aeries.mobileportal.views.custom;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public class AeriesDialogI_ViewBinding implements Unbinder {
    private AeriesDialogI target;

    @UiThread
    public AeriesDialogI_ViewBinding(AeriesDialogI aeriesDialogI, View view) {
        this.target = aeriesDialogI;
        aeriesDialogI.title = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.title, "field 'title'", TextView.class);
        aeriesDialogI.message = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.message, "field 'message'", TextView.class);
        aeriesDialogI.actionButton = (Button) Utils.findRequiredViewAsType(view, C0316R.id.action_button, "field 'actionButton'", Button.class);
    }

    @CallSuper
    public void unbind() {
        AeriesDialogI aeriesDialogI = this.target;
        if (aeriesDialogI != null) {
            this.target = null;
            aeriesDialogI.title = null;
            aeriesDialogI.message = null;
            aeriesDialogI.actionButton = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
