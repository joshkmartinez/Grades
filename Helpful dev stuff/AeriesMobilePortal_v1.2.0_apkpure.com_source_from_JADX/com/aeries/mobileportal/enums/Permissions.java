package com.aeries.mobileportal.enums;

import android.content.Context;
import android.content.Intent;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.views.activities.AttendanceActivity;
import com.aeries.mobileportal.views.activities.ClassCheckInActivity;
import com.aeries.mobileportal.views.activities.CommunicationsActivity;
import com.aeries.mobileportal.views.activities.ContactsActivity;
import com.aeries.mobileportal.views.activities.DemographicsActivity;
import com.aeries.mobileportal.views.activities.FeedbackActivity;
import com.aeries.mobileportal.views.activities.GradesActivity;
import com.aeries.mobileportal.views.activities.ReportCardsActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/aeries/mobileportal/enums/Permissions;", "", "(Ljava/lang/String;I)V", "getImageID", "", "getPermissionIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getPermissionName", "GRD", "GBS", "CON", "ATT", "STU", "SKT", "ATD", "Feedback", "RCH", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Permissions.kt */
public enum Permissions {
    ;

    public final int getImageID() {
        switch (this) {
            case GRD:
            case GBS:
                return C0316R.drawable.icon_grades;
            case CON:
                return C0316R.drawable.icon_contacts;
            case ATT:
                return C0316R.drawable.icon_attendance;
            case STU:
                return C0316R.drawable.icon_demographics;
            case SKT:
                return C0316R.drawable.icon_communications;
            case ATD:
                return C0316R.drawable.class_check_in;
            case Feedback:
                return C0316R.mipmap.ic_launcher;
            case RCH:
                return C0316R.drawable.icon_id_card;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getPermissionName() {
        switch (this) {
            case GRD:
                return C0316R.string.grades;
            case GBS:
                return C0316R.string.class_summary;
            case CON:
                return C0316R.string.contacts;
            case ATT:
                return C0316R.string.attendance;
            case STU:
                return C0316R.string.demographics;
            case SKT:
                return C0316R.string.communications;
            case ATD:
                return C0316R.string.class_check_in;
            case Feedback:
                return C0316R.string.feedback;
            case RCH:
                return C0316R.string.report_cards;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final Intent getPermissionIntent(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        switch (this) {
            case GRD:
                return new Intent(context, GradesActivity.class);
            case GBS:
                return new Intent(context, GradesActivity.class);
            case CON:
                return new Intent(context, ContactsActivity.class);
            case ATT:
                return new Intent(context, AttendanceActivity.class);
            case STU:
                return new Intent(context, DemographicsActivity.class);
            case SKT:
                return new Intent(context, CommunicationsActivity.class);
            case ATD:
                return new Intent(context, ClassCheckInActivity.class);
            case Feedback:
                return new Intent(context, FeedbackActivity.class);
            case RCH:
                return new Intent(context, ReportCardsActivity.class);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
