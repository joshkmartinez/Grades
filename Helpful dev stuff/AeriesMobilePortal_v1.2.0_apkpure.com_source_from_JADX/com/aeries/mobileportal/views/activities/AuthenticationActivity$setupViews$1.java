package com.aeries.mobileportal.views.activities;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.aeries.mobileportal.C0316R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "id", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 1, 10})
/* compiled from: AuthenticationActivity.kt */
final class AuthenticationActivity$setupViews$1 implements OnEditorActionListener {
    final /* synthetic */ AuthenticationActivity this$0;

    AuthenticationActivity$setupViews$1(AuthenticationActivity authenticationActivity) {
        this.this$0 = authenticationActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            if (i != 0) {
                return null;
            }
        }
        if (this.this$0.getSchoolSpinner().getSelectedItemPosition() > null) {
            this.this$0.attemptLogin();
        } else {
            Toast.makeText((Context) this.this$0, C0316R.string.select_school_error, 1).show();
        }
        return true;
    }
}
