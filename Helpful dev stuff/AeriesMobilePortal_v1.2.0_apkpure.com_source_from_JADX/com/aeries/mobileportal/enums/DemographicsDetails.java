package com.aeries.mobileportal.enums;

import android.content.Context;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.utils.DateUtils;
import com.aeries.mobileportal.utils.StringUtils;
import com.aeries.mobileportal.utils.StringUtils.Companion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0005j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/enums/DemographicsDetails;", "", "(Ljava/lang/String;I)V", "getDetail", "", "demographics", "Lcom/aeries/mobileportal/models/Demographics;", "getIcon", "", "getOnClickInfo", "getTitle", "context", "Landroid/content/Context;", "fullName", "primaryPhone", "schoolName", "permId", "sex", "grade", "birthDate", "teacher", "teacherEmail", "residenceAddress", "mailingAddress", "profile", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DemographicsDetails.kt */
public enum DemographicsDetails {
    ;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;

        static {
            $EnumSwitchMapping$0 = new int[DemographicsDetails.values().length];
            $EnumSwitchMapping$0[DemographicsDetails.fullName.ordinal()] = 1;
            $EnumSwitchMapping$0[DemographicsDetails.primaryPhone.ordinal()] = 2;
            $EnumSwitchMapping$0[DemographicsDetails.schoolName.ordinal()] = 3;
            $EnumSwitchMapping$0[DemographicsDetails.permId.ordinal()] = 4;
            $EnumSwitchMapping$0[DemographicsDetails.sex.ordinal()] = 5;
            $EnumSwitchMapping$0[DemographicsDetails.grade.ordinal()] = 6;
            $EnumSwitchMapping$0[DemographicsDetails.birthDate.ordinal()] = 7;
            $EnumSwitchMapping$0[DemographicsDetails.teacher.ordinal()] = 8;
            $EnumSwitchMapping$0[DemographicsDetails.teacherEmail.ordinal()] = 9;
            $EnumSwitchMapping$0[DemographicsDetails.residenceAddress.ordinal()] = 10;
            $EnumSwitchMapping$0[DemographicsDetails.mailingAddress.ordinal()] = 11;
            $EnumSwitchMapping$0[DemographicsDetails.demographics.ordinal()] = 12;
            $EnumSwitchMapping$0[DemographicsDetails.profile.ordinal()] = 13;
            $EnumSwitchMapping$1 = new int[DemographicsDetails.values().length];
            $EnumSwitchMapping$1[DemographicsDetails.fullName.ordinal()] = 1;
            $EnumSwitchMapping$1[DemographicsDetails.primaryPhone.ordinal()] = 2;
            $EnumSwitchMapping$1[DemographicsDetails.schoolName.ordinal()] = 3;
            $EnumSwitchMapping$1[DemographicsDetails.permId.ordinal()] = 4;
            $EnumSwitchMapping$1[DemographicsDetails.sex.ordinal()] = 5;
            $EnumSwitchMapping$1[DemographicsDetails.grade.ordinal()] = 6;
            $EnumSwitchMapping$1[DemographicsDetails.birthDate.ordinal()] = 7;
            $EnumSwitchMapping$1[DemographicsDetails.teacher.ordinal()] = 8;
            $EnumSwitchMapping$1[DemographicsDetails.teacherEmail.ordinal()] = 9;
            $EnumSwitchMapping$1[DemographicsDetails.residenceAddress.ordinal()] = 10;
            $EnumSwitchMapping$1[DemographicsDetails.mailingAddress.ordinal()] = 11;
            $EnumSwitchMapping$1[DemographicsDetails.demographics.ordinal()] = 12;
            $EnumSwitchMapping$1[DemographicsDetails.profile.ordinal()] = 13;
            $EnumSwitchMapping$2 = new int[DemographicsDetails.values().length];
            $EnumSwitchMapping$2[DemographicsDetails.fullName.ordinal()] = 1;
            $EnumSwitchMapping$2[DemographicsDetails.primaryPhone.ordinal()] = 2;
            $EnumSwitchMapping$2[DemographicsDetails.schoolName.ordinal()] = 3;
            $EnumSwitchMapping$2[DemographicsDetails.permId.ordinal()] = 4;
            $EnumSwitchMapping$2[DemographicsDetails.sex.ordinal()] = 5;
            $EnumSwitchMapping$2[DemographicsDetails.grade.ordinal()] = 6;
            $EnumSwitchMapping$2[DemographicsDetails.birthDate.ordinal()] = 7;
            $EnumSwitchMapping$2[DemographicsDetails.teacher.ordinal()] = 8;
            $EnumSwitchMapping$2[DemographicsDetails.teacherEmail.ordinal()] = 9;
            $EnumSwitchMapping$2[DemographicsDetails.residenceAddress.ordinal()] = 10;
            $EnumSwitchMapping$2[DemographicsDetails.mailingAddress.ordinal()] = 11;
            $EnumSwitchMapping$2[DemographicsDetails.demographics.ordinal()] = 12;
            $EnumSwitchMapping$2[DemographicsDetails.profile.ordinal()] = 13;
            $EnumSwitchMapping$3 = new int[DemographicsDetails.values().length];
            $EnumSwitchMapping$3[DemographicsDetails.fullName.ordinal()] = 1;
            $EnumSwitchMapping$3[DemographicsDetails.primaryPhone.ordinal()] = 2;
            $EnumSwitchMapping$3[DemographicsDetails.schoolName.ordinal()] = 3;
            $EnumSwitchMapping$3[DemographicsDetails.permId.ordinal()] = 4;
            $EnumSwitchMapping$3[DemographicsDetails.sex.ordinal()] = 5;
            $EnumSwitchMapping$3[DemographicsDetails.grade.ordinal()] = 6;
            $EnumSwitchMapping$3[DemographicsDetails.birthDate.ordinal()] = 7;
            $EnumSwitchMapping$3[DemographicsDetails.teacher.ordinal()] = 8;
            $EnumSwitchMapping$3[DemographicsDetails.teacherEmail.ordinal()] = 9;
            $EnumSwitchMapping$3[DemographicsDetails.residenceAddress.ordinal()] = 10;
            $EnumSwitchMapping$3[DemographicsDetails.mailingAddress.ordinal()] = 11;
            $EnumSwitchMapping$3[DemographicsDetails.demographics.ordinal()] = 12;
            $EnumSwitchMapping$3[DemographicsDetails.profile.ordinal()] = 13;
        }
    }

    @NotNull
    public final String getTitle(@NotNull Demographics demographics, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(demographics, "demographics");
        Intrinsics.checkParameterIsNotNull(context, "context");
        switch (this) {
            case fullName:
                demographics = context.getString(C0316R.string.full_name);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.full_name)");
                return demographics;
            case primaryPhone:
                demographics = context.getString(C0316R.string.primary_phone);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.primary_phone)");
                return demographics;
            case schoolName:
                demographics = context.getString(C0316R.string.school_name);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.school_name)");
                return demographics;
            case permId:
                demographics = context.getString(C0316R.string.perm_id);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.perm_id)");
                return demographics;
            case sex:
                demographics = context.getString(C0316R.string.sex);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.sex)");
                return demographics;
            case grade:
                demographics = context.getString(C0316R.string.grade);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.grade)");
                return demographics;
            case birthDate:
                demographics = context.getString(C0316R.string.birth_date);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.birth_date)");
                return demographics;
            case teacher:
                demographics = demographics.getDisplayText();
                if (demographics != null) {
                    return demographics;
                }
                return "";
            case teacherEmail:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(demographics.getDisplayText());
                stringBuilder.append(" ");
                stringBuilder.append(context.getString(C0316R.string.email));
                return stringBuilder.toString();
            case residenceAddress:
                demographics = context.getString(C0316R.string.residence_address);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.residence_address)");
                return demographics;
            case mailingAddress:
                demographics = context.getString(C0316R.string.mailing_address);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.mailing_address)");
                return demographics;
            case demographics:
                demographics = context.getString(C0316R.string.demographics);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.demographics)");
                return demographics;
            case profile:
                demographics = context.getString(C0316R.string.profile);
                Intrinsics.checkExpressionValueIsNotNull(demographics, "context.getString(R.string.profile)");
                return demographics;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final String getDetail(@NotNull Demographics demographics) {
        Intrinsics.checkParameterIsNotNull(demographics, "demographics");
        switch (this) {
            case fullName:
                demographics = StringUtils.Companion.getFullName(demographics);
                return demographics != null ? demographics : "";
            case primaryPhone:
                Companion companion = StringUtils.Companion;
                demographics = demographics.getPrimaryPhoneNumber();
                if (demographics == null) {
                    demographics = "";
                }
                return companion.getFormattedPhone(demographics);
            case schoolName:
                return demographics.getSchoolName();
            case permId:
                return String.valueOf(demographics.getStudentId());
            case sex:
                demographics = demographics.getGender();
                if (demographics != null) {
                    return demographics;
                }
                return "";
            case grade:
                demographics = demographics.getGrade();
                if (demographics != null) {
                    return demographics;
                }
                return "";
            case birthDate:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(DateUtils.Companion.parseDotNetDate(demographics.getBirthDate()));
                stringBuilder.append(" (age ");
                stringBuilder.append(demographics.getAge());
                stringBuilder.append(')');
                return stringBuilder.toString();
            case teacher:
                demographics = demographics.getCounselorName();
                if (demographics != null) {
                    return demographics;
                }
                return "";
            case teacherEmail:
                demographics = demographics.getCounselorEmailAddress();
                if (demographics != null) {
                    return demographics;
                }
                return "";
            case residenceAddress:
                return StringUtils.Companion.getFormattedAddress(demographics.getResidenceAddress());
            case mailingAddress:
                return StringUtils.Companion.getFormattedAddress(demographics.getMailingAddress());
            case demographics:
                return "";
            case profile:
                return "";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public final String getOnClickInfo(@NotNull Demographics demographics) {
        Intrinsics.checkParameterIsNotNull(demographics, "demographics");
        switch (this) {
            case fullName:
            case schoolName:
            case permId:
            case sex:
            case grade:
            case birthDate:
            case teacher:
            case demographics:
            case profile:
                return null;
            case primaryPhone:
                return demographics.getPrimaryPhoneNumber();
            case teacherEmail:
                return demographics.getCounselorEmailAddress();
            case residenceAddress:
                return StringUtils.Companion.getMapsFormattedAddress(demographics.getResidenceAddress());
            case mailingAddress:
                return StringUtils.Companion.getMapsFormattedAddress(demographics.getMailingAddress());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getIcon() {
        int i = WhenMappings.$EnumSwitchMapping$3[ordinal()];
        int i2 = C0316R.drawable.placeholder;
        switch (i) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
            case 13:
                return 0;
            case 2:
                i2 = C0316R.drawable.phone_receiver;
                break;
            case 9:
                i2 = C0316R.drawable.envelope;
                break;
            case 10:
            case 11:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return i2;
    }
}
