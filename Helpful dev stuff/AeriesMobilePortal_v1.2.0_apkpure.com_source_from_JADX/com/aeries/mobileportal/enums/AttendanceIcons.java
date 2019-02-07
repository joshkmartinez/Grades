package com.aeries.mobileportal.enums;

import com.aeries.mobileportal.C0316R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/enums/AttendanceIcons;", "", "(Ljava/lang/String;I)V", "getIcon", "", "Info", "Alert", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceIcons.kt */
public enum AttendanceIcons {
    ;

    public final int getIcon() {
        switch (this) {
            case Info:
                return C0316R.drawable.info_icon;
            case Alert:
                return C0316R.drawable.warning_icon;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
