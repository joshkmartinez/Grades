package com.aeries.mobileportal.views.activities;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/aeries/mobileportal/views/activities/LoginActivity$setupViews$4", "Landroid/text/TextWatcher;", "(Lcom/aeries/mobileportal/views/activities/LoginActivity;)V", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LoginActivity.kt */
public final class LoginActivity$setupViews$4 implements TextWatcher {
    final /* synthetic */ LoginActivity this$0;

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    LoginActivity$setupViews$4(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        i = this.this$0.getLoginButton();
        CharSequence text = this.this$0.getPasswordTV().getText();
        i3 = 0;
        if (text != null) {
            if (text.length() != 0) {
                i2 = 0;
                if (i2 == 0) {
                    if (charSequence != null) {
                        if (charSequence.length() == null) {
                            charSequence = null;
                            if (charSequence == null) {
                                i3 = 1;
                            }
                        }
                    }
                    charSequence = 1;
                    if (charSequence == null) {
                        i3 = 1;
                    }
                }
                i.setEnabled(i3);
            }
        }
        i2 = 1;
        if (i2 == 0) {
            if (charSequence != null) {
                if (charSequence.length() == null) {
                    charSequence = null;
                    if (charSequence == null) {
                        i3 = 1;
                    }
                }
            }
            charSequence = 1;
            if (charSequence == null) {
                i3 = 1;
            }
        }
        i.setEnabled(i3);
    }
}
