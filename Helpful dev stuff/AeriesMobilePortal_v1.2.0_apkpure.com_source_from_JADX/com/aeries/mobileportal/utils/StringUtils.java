package com.aeries.mobileportal.utils;

import com.aeries.mobileportal.models.CheckInOutRequest;
import com.aeries.mobileportal.models.Contact;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.GenericAddress;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.apache.commons.cli.HelpFormatter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/StringUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StringUtils.kt */
public final class StringUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001e¨\u0006\""}, d2 = {"Lcom/aeries/mobileportal/utils/StringUtils$Companion;", "", "()V", "checkForNA", "", "string", "checkIfNumber", "", "s", "extractAttendanceURLValues", "Lcom/aeries/mobileportal/models/CheckInOutRequest;", "url", "formatDecimals", "d", "", "getAccountName", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "getFormattedAddress", "contact", "Lcom/aeries/mobileportal/models/Contact;", "address", "Lcom/aeries/mobileportal/models/GenericAddress;", "getFormattedPhone", "phone", "getFormattedWorkPhone", "getFullName", "demographics", "Lcom/aeries/mobileportal/models/Demographics;", "student", "Lcom/aeries/mobileportal/models/Student;", "getMapsFormattedAddress", "add", "getNameNoMiddle", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: StringUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getAccountName(@NotNull UserRepository userRepository) {
            Object obj;
            String str;
            Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
            StringBuilder stringBuilder = new StringBuilder();
            CharSequence googleAccount = userRepository.getGoogleAccount();
            if (googleAccount != null) {
                if (googleAccount.length() != 0) {
                    obj = null;
                    if (obj == null) {
                        str = (String) CollectionsKt.first(StringsKt.split$default(userRepository.getUserName(), new String[]{"@"}, false, 0, 6, null));
                    } else {
                        str = userRepository.getGoogleAccount();
                    }
                    stringBuilder.append(str);
                    stringBuilder.append(" | ");
                    stringBuilder.append(userRepository.getSchoolName());
                    return stringBuilder.toString();
                }
            }
            obj = 1;
            if (obj == null) {
                str = userRepository.getGoogleAccount();
            } else {
                str = (String) CollectionsKt.first(StringsKt.split$default(userRepository.getUserName(), new String[]{"@"}, false, 0, 6, null));
            }
            stringBuilder.append(str);
            stringBuilder.append(" | ");
            stringBuilder.append(userRepository.getSchoolName());
            return stringBuilder.toString();
        }

        @Nullable
        public final String getFullName(@NotNull Student student) {
            Intrinsics.checkParameterIsNotNull(student, "student");
            student = student.getDemographics();
            if (student.getMiddleName() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(student.getFirstName());
                stringBuilder.append(" ");
                stringBuilder.append(student.getMiddleName());
                stringBuilder.append(" ");
                stringBuilder.append(student.getLastName());
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(student.getFirstName());
            stringBuilder.append(" ");
            stringBuilder.append(student.getLastName());
            return stringBuilder.toString();
        }

        @Nullable
        public final String getNameNoMiddle(@NotNull Student student) {
            Intrinsics.checkParameterIsNotNull(student, "student");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(student.getDemographics().getFirstName());
            stringBuilder.append(" ");
            stringBuilder.append(student.getDemographics().getLastName());
            return stringBuilder.toString();
        }

        @Nullable
        public final String getFullName(@Nullable Demographics demographics) {
            String str = null;
            if ((demographics != null ? demographics.getMiddleName() : null) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(demographics.getFirstName());
                stringBuilder.append(" ");
                stringBuilder.append(demographics.getMiddleName());
                stringBuilder.append(" ");
                stringBuilder.append(demographics.getLastName());
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(demographics != null ? demographics.getFirstName() : null);
            stringBuilder2.append(" ");
            if (demographics != null) {
                str = demographics.getLastName();
            }
            stringBuilder2.append(str);
            return stringBuilder2.toString();
        }

        @Nullable
        public final String getFullName(@NotNull Contact contact) {
            Intrinsics.checkParameterIsNotNull(contact, "contact");
            if (contact.getMiddleName() == null || (Intrinsics.areEqual(contact.getMiddleName(), (Object) "") ^ 1) == 0) {
                if ((Intrinsics.areEqual(contact.getMiddleName(), (Object) "") || contact.getMiddleName() == null) && (Intrinsics.areEqual(contact.getFirstName(), (Object) "") || contact.getFirstName() == null)) {
                    if (!Intrinsics.areEqual(contact.getLastName(), (Object) "")) {
                        if (contact.getLastName() == null) {
                        }
                    }
                    return contact.getMailingName();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(contact.getFirstName());
                stringBuilder.append(" ");
                stringBuilder.append(contact.getLastName());
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(contact.getFirstName());
            stringBuilder.append(" ");
            stringBuilder.append(contact.getMiddleName());
            stringBuilder.append(" ");
            stringBuilder.append(contact.getLastName());
            return stringBuilder.toString();
        }

        @NotNull
        public final String getFormattedPhone(@Nullable String str) {
            if (!(Intrinsics.areEqual((Object) str, (Object) "") || str == null)) {
                if (str.length() == 10) {
                    String substring = str.substring(0, 3);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String substring2 = str.substring(3, 6);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    str = str.substring(6);
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append('(');
                    stringBuilder.append(substring);
                    stringBuilder.append(") ");
                    stringBuilder.append(substring2);
                    stringBuilder.append('-');
                    stringBuilder.append(str);
                    return stringBuilder.toString();
                }
            }
            return "";
        }

        @NotNull
        public final String getFormattedWorkPhone(@NotNull Contact contact) {
            Intrinsics.checkParameterIsNotNull(contact, "contact");
            Object formattedPhone = getFormattedPhone(contact.getWorkPhone());
            if (Intrinsics.areEqual(formattedPhone, (Object) "")) {
                return "";
            }
            Object workPhoneExt = contact.getWorkPhoneExt();
            if (workPhoneExt != null) {
                if (!Intrinsics.areEqual(workPhoneExt, (Object) "")) {
                    contact = new StringBuilder();
                    contact.append("");
                    contact.append(formattedPhone);
                    contact.append(" Ext. ");
                    contact.append(workPhoneExt);
                    contact = contact.toString();
                    return contact;
                }
            }
            contact = contact.getWorkPhone();
            if (contact == null) {
                contact = "";
            }
            return contact;
        }

        @NotNull
        public final String getFormattedAddress(@NotNull Contact contact) {
            Intrinsics.checkParameterIsNotNull(contact, "contact");
            StringBuilder stringBuilder = new StringBuilder();
            contact = contact.getAddress();
            String str = null;
            if (!((contact != null ? contact.getAddress() : null) == null || (Intrinsics.areEqual(contact.getAddress(), (Object) "") ^ 1) == 0)) {
                stringBuilder.append(Intrinsics.stringPlus(contact.getAddress(), "\n"));
            }
            if (!((contact != null ? contact.getCity() : null) == null || (Intrinsics.areEqual(contact.getCity(), (Object) "") ^ 1) == 0)) {
                stringBuilder.append(Intrinsics.stringPlus(contact.getCity(), ", "));
            }
            if (!((contact != null ? contact.getState() : null) == null || (Intrinsics.areEqual(contact.getState(), (Object) "") ^ 1) == 0)) {
                stringBuilder.append(Intrinsics.stringPlus(contact.getState(), " "));
            }
            if (!((contact != null ? contact.getZipCode() : null) == null || (Intrinsics.areEqual(contact.getZipCode(), (Object) "") ^ 1) == 0)) {
                stringBuilder.append(contact.getZipCode());
            }
            if (contact != null) {
                str = contact.getZipExt();
            }
            if (!(str == null || (Intrinsics.areEqual(contact.getZipExt(), (Object) "") ^ 1) == 0)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                stringBuilder2.append(contact.getZipExt());
                stringBuilder.append(stringBuilder2.toString());
            }
            contact = stringBuilder.toString();
            Intrinsics.checkExpressionValueIsNotNull(contact, "builder.toString()");
            return contact;
        }

        @NotNull
        public final String getFormattedAddress(@Nullable GenericAddress genericAddress) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = null;
            if (!((genericAddress != null ? genericAddress.getAddress() : null) == null || (Intrinsics.areEqual(genericAddress.getAddress(), (Object) "") ^ 1) == 0)) {
                stringBuilder.append(Intrinsics.stringPlus(genericAddress.getAddress(), "\n"));
            }
            if (!((genericAddress != null ? genericAddress.getCity() : null) == null || (Intrinsics.areEqual(genericAddress.getCity(), (Object) "") ^ 1) == 0)) {
                stringBuilder.append(Intrinsics.stringPlus(genericAddress.getCity(), ", "));
            }
            if (!((genericAddress != null ? genericAddress.getState() : null) == null || (Intrinsics.areEqual(genericAddress.getState(), (Object) "") ^ 1) == 0)) {
                stringBuilder.append(Intrinsics.stringPlus(genericAddress.getState(), " "));
            }
            if (!((genericAddress != null ? genericAddress.getZipCode() : null) == null || (Intrinsics.areEqual(genericAddress.getZipCode(), (Object) "") ^ 1) == 0)) {
                stringBuilder.append(genericAddress.getZipCode());
            }
            if (genericAddress != null) {
                str = genericAddress.getZipExt();
            }
            if (!(str == null || (Intrinsics.areEqual(genericAddress.getZipExt(), (Object) "") ^ 1) == 0)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                stringBuilder2.append(genericAddress.getZipExt());
                stringBuilder.append(stringBuilder2.toString());
            }
            genericAddress = stringBuilder.toString();
            Intrinsics.checkExpressionValueIsNotNull(genericAddress, "builder.toString()");
            return genericAddress;
        }

        @NotNull
        public final String checkForNA(@Nullable String str) {
            return (Intrinsics.areEqual((Object) str, (Object) "") || str == null) ? "N/A" : str;
        }

        @NotNull
        public final CheckInOutRequest extractAttendanceURLValues(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            Regex regex = new Regex("(Room=[a-zA-Z0-9]*)\\w+", RegexOption.IGNORE_CASE);
            Regex regex2 = new Regex("(SchoolCode=[a-zA-Z0-9]*)\\w+", RegexOption.IGNORE_CASE);
            CharSequence charSequence = str;
            MatchResult find$default = Regex.find$default(regex, charSequence, 0, 2, null);
            String value = find$default != null ? find$default.getValue() : null;
            str = Regex.find$default(regex2, charSequence, 0, 2, null);
            str = str != null ? str.getValue() : null;
            if (value == null) {
                value = null;
            } else if (value != null) {
                value = value.substring(5);
                Intrinsics.checkExpressionValueIsNotNull(value, "(this as java.lang.String).substring(startIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            if (str != null) {
                if (str != null) {
                    str = str.substring(11);
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
                    if (str != null) {
                        str = Integer.valueOf(Integer.parseInt(str));
                        return new CheckInOutRequest(null, str, value, null);
                    }
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = null;
            return new CheckInOutRequest(null, str, value, null);
        }

        public final boolean checkIfNumber(@org.jetbrains.annotations.Nullable java.lang.String r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 0;
            if (r2 != 0) goto L_0x0004;
        L_0x0003:
            return r0;
        L_0x0004:
            java.lang.Double.parseDouble(r2);	 Catch:{ Exception -> 0x0008 }
            r0 = 1;
        L_0x0008:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aeries.mobileportal.utils.StringUtils.Companion.checkIfNumber(java.lang.String):boolean");
        }

        @NotNull
        public final String formatDecimals(double d) {
            d = new DecimalFormat("#.##").format(d);
            Intrinsics.checkExpressionValueIsNotNull(d, "DecimalFormat(\"#.##\").format(d)");
            return d;
        }

        @NotNull
        public final String getMapsFormattedAddress(@Nullable GenericAddress genericAddress) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = null;
            stringBuilder.append(genericAddress != null ? genericAddress.getAddress() : null);
            stringBuilder.append(", ");
            stringBuilder.append(genericAddress != null ? genericAddress.getCity() : null);
            stringBuilder.append(", ");
            if (genericAddress != null) {
                str = genericAddress.getState();
            }
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }
}
