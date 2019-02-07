package com.aeries.mobileportal.enums;

import com.aeries.mobileportal.C0316R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/enums/DaysOfWeek;", "", "(Ljava/lang/String;I)V", "getName", "", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DaysOfWeek.kt */
public enum DaysOfWeek {
    ;

    public final int getName() {
        switch (this) {
            case Mon:
                return C0316R.string.monday;
            case Tue:
                return C0316R.string.tuesday;
            case Wed:
                return C0316R.string.wednesday;
            case Thu:
                return C0316R.string.thursday;
            case Fri:
                return C0316R.string.friday;
            case Sat:
                return C0316R.string.saturday;
            case Sun:
                return C0316R.string.sunday;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
