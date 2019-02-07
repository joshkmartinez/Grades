package com.aeries.mobileportal.enums;

import com.aeries.mobileportal.C0316R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/enums/Months;", "", "(Ljava/lang/String;I)V", "getName", "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Months.kt */
public enum Months {
    ;

    public final int getName() {
        switch (this) {
            case Jan:
                return C0316R.string.january;
            case Feb:
                return C0316R.string.february;
            case Mar:
                return C0316R.string.march;
            case Apr:
                return C0316R.string.april;
            case May:
                return C0316R.string.may;
            case Jun:
                return C0316R.string.june;
            case Jul:
                return C0316R.string.july;
            case Aug:
                return C0316R.string.august;
            case Sep:
                return C0316R.string.september;
            case Oct:
                return C0316R.string.october;
            case Nov:
                return C0316R.string.november;
            case Dec:
                return C0316R.string.december;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
