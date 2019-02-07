package com.aeries.mobileportal.enums;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.views.activities.AddDistrictActivity;
import com.aeries.mobileportal.views.activities.ChangeDistrictActivity;
import com.aeries.mobileportal.views.activities.ChangePasswordActivity;
import com.aeries.mobileportal.views.activities.LinkStudentActivity;
import com.aeries.mobileportal.views.activities.LoginActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/enums/Settings;", "", "(Ljava/lang/String;I)V", "getDrawable", "", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getName", "ChangePassword", "LinkStudent", "Logout", "SwitchDistrict", "AddDistrict", "AppVersion", "PortalVersion", "Token", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Settings.kt */
public enum Settings {
    ;

    public final int getName() {
        switch (this) {
            case ChangePassword:
                return C0316R.string.change_password;
            case LinkStudent:
                return C0316R.string.link_student;
            case Logout:
                return C0316R.string.logout;
            case SwitchDistrict:
                return C0316R.string.switch_district;
            case AddDistrict:
                return C0316R.string.add_district;
            case AppVersion:
                return C0316R.string.app_version;
            case PortalVersion:
                return C0316R.string.portal_version;
            case Token:
                return C0316R.string.invalidate_token;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public final Intent getIntent(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent;
        switch (this) {
            case ChangePassword:
                return new Intent(context, ChangePasswordActivity.class);
            case LinkStudent:
                intent = new Intent(context, LinkStudentActivity.class);
                intent.putExtra("ANOTHER_STUDENT", true);
                return intent;
            case Logout:
                intent = new Intent(context, LoginActivity.class);
                intent.setFlags(872448000);
                return intent;
            case SwitchDistrict:
                return new Intent(context, ChangeDistrictActivity.class);
            case AddDistrict:
                return new Intent(context, AddDistrictActivity.class);
            case AppVersion:
                return new Intent("android.intent.action.VIEW").setData(Uri.parse("http://apps.aeries.com/mobile-portal/"));
            case PortalVersion:
            case Token:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getDrawable() {
        switch (this) {
            case ChangePassword:
                return C0316R.drawable.change_password;
            case LinkStudent:
                return C0316R.drawable.link_student;
            case Logout:
                return C0316R.drawable.log_out;
            case SwitchDistrict:
                return C0316R.drawable.switch_district;
            case AddDistrict:
                return C0316R.drawable.link_district;
            case AppVersion:
                return C0316R.mipmap.ic_launcher;
            case PortalVersion:
            case Token:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
