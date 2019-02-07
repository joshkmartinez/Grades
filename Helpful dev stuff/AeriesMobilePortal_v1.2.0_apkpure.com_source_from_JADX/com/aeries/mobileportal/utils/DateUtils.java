package com.aeries.mobileportal.utils;

import android.content.Context;
import com.aeries.mobileportal.enums.DaysOfWeek;
import com.aeries.mobileportal.enums.Months;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/DateUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DateUtils.kt */
public final class DateUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0016"}, d2 = {"Lcom/aeries/mobileportal/utils/DateUtils$Companion;", "", "()V", "getCalendar", "Ljava/util/Calendar;", "dotNetDate", "", "getDate", "Ljava/util/Date;", "getDayInMonth", "getHourMinute", "getMillis", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getMonth", "", "getWeekDay", "parseDotNetDate", "parseSimpleDotNetDate", "context", "Landroid/content/Context;", "parseSimpleDotNetDateForFiles", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DateUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String parseDotNetDate(@Nullable String str) {
            if (Intrinsics.areEqual((Object) str, (Object) "")) {
                return "";
            }
            str = getCalendar(str);
            str = SimpleDateFormat.getDateInstance().format(str != null ? str.getTime() : null);
            Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(calendar?.time)");
            return str;
        }

        @NotNull
        public final String parseSimpleDotNetDate(@Nullable String str, @NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            str = getCalendar(str);
            context = context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(context, "context.resources");
            str = new SimpleDateFormat("MM/dd/yyyy", context.getConfiguration().locale).format(str != null ? str.getTime() : null);
            Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(calendar?.time)");
            return str;
        }

        @NotNull
        public final String parseSimpleDotNetDateForFiles(@Nullable String str, @NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            str = getCalendar(str);
            context = context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(context, "context.resources");
            str = new SimpleDateFormat("yyyy_MM_dd", context.getConfiguration().locale).format(str != null ? str.getTime() : null);
            Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(calendar?.time)");
            return str;
        }

        private final Calendar getCalendar(String str) {
            Calendar instance;
            if (str != null) {
                str = StringsKt.removeSuffix(str, ")/");
                if (str != null) {
                    str = StringsKt.removePrefix(str, "/Date(");
                    instance = Calendar.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
                    instance.setTimeInMillis(str == null ? Long.parseLong(str) : 0);
                    return instance;
                }
            }
            str = null;
            instance = Calendar.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
            if (str == null) {
            }
            instance.setTimeInMillis(str == null ? Long.parseLong(str) : 0);
            return instance;
        }

        @Nullable
        public final Long getMillis(@Nullable String str) {
            if (str != null) {
                str = StringsKt.removeSuffix(str, ")/");
                if (str != null) {
                    str = StringsKt.removePrefix(str, "/Date(");
                    if (str == null) {
                        return Long.valueOf(Long.parseLong(str));
                    }
                    return null;
                }
            }
            str = null;
            if (str == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(str));
        }

        private final Date getDate(String str) {
            str = getCalendar(str);
            return new Date(str != null ? str.getTimeInMillis() : 0);
        }

        public final int getWeekDay(@Nullable String str) {
            str = new SimpleDateFormat("EEE", Locale.US).format(getDate(str));
            Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(getDate(dotNetDate))");
            return DaysOfWeek.valueOf(str).getName();
        }

        public final int getMonth(@Nullable String str) {
            str = new SimpleDateFormat("MMM", Locale.US).format(getDate(str));
            Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(getDate(dotNetDate))");
            return Months.valueOf(str).getName();
        }

        @NotNull
        public final String getDayInMonth(@Nullable String str) {
            str = new SimpleDateFormat("dd", Locale.US).format(getDate(str));
            Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(getDate(dotNetDate))");
            return str;
        }

        @NotNull
        public final String getHourMinute(@Nullable String str) {
            str = new SimpleDateFormat("hh:mm a", Locale.US).format(getDate(str));
            Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(getDate(dotNetDate))");
            return str;
        }
    }
}
