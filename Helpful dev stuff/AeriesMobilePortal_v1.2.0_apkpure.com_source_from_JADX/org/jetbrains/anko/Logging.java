package org.jetbrains.anko;

import android.support.media.ExifInterface;
import android.util.Log;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001ag\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u00122\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0014H\b\u001a\u001d\u0010\u0015\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u0015\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u001d\u0010\u0017\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u0017\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u000eH\b\u001a\u001d\u0010\u0019\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u0019\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u001d\u0010\u001a\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u001a\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u001d\u0010\u001b\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u001b\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a \u0010\u001c\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u001d"}, d2 = {"AnkoLogger", "Lorg/jetbrains/anko/AnkoLogger;", "T", "", "clazz", "Ljava/lang/Class;", "tag", "", "getTag", "log", "", "logger", "message", "thr", "", "level", "", "f", "Lkotlin/Function2;", "fThrowable", "Lkotlin/Function3;", "debug", "Lkotlin/Function0;", "error", "getStackTraceString", "info", "verbose", "warn", "wtf", "commons_release"}, k = 2, mv = {1, 1, 5})
@JvmName(name = "Logging")
/* compiled from: Logging.kt */
public final class Logging {
    @NotNull
    public static final AnkoLogger AnkoLogger(@NotNull Class<?> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        return new Logging$AnkoLogger$1(cls);
    }

    @NotNull
    public static final AnkoLogger AnkoLogger(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        return new Logging$AnkoLogger$2(str);
    }

    private static final <T> AnkoLogger AnkoLogger() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoLogger(Object.class);
    }

    public static /* bridge */ /* synthetic */ void verbose$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        verbose(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void debug$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        debug(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void info$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        info(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void warn$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        warn(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void error$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        error(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void wtf$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        wtf(ankoLogger, obj, th);
    }

    public static final void wtf(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        if (th != null) {
            ankoLogger = ankoLogger.getLoggerTag();
            if (obj != null) {
                obj = obj.toString();
                if (obj != null) {
                    Log.wtf(ankoLogger, obj, th);
                    return;
                }
            }
            obj = "null";
            Log.wtf(ankoLogger, obj, th);
            return;
        }
        ankoLogger = ankoLogger.getLoggerTag();
        if (obj != null) {
            obj = obj.toString();
            if (obj != null) {
                Log.wtf(ankoLogger, obj);
            }
        }
        obj = "null";
        Log.wtf(ankoLogger, obj);
    }

    public static final void verbose(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        ankoLogger = ankoLogger.getLoggerTag();
        if (Log.isLoggable(ankoLogger, 2)) {
            function0 = function0.invoke();
            if (function0 != null) {
                function0 = function0.toString();
                if (function0 != null) {
                    Log.v(ankoLogger, function0);
                }
            }
            function0 = "null";
            Log.v(ankoLogger, function0);
        }
    }

    public static final void debug(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        ankoLogger = ankoLogger.getLoggerTag();
        if (Log.isLoggable(ankoLogger, 3)) {
            function0 = function0.invoke();
            if (function0 != null) {
                function0 = function0.toString();
                if (function0 != null) {
                    Log.d(ankoLogger, function0);
                }
            }
            function0 = "null";
            Log.d(ankoLogger, function0);
        }
    }

    public static final void info(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        ankoLogger = ankoLogger.getLoggerTag();
        if (Log.isLoggable(ankoLogger, 4)) {
            function0 = function0.invoke();
            if (function0 != null) {
                function0 = function0.toString();
                if (function0 != null) {
                    Log.i(ankoLogger, function0);
                }
            }
            function0 = "null";
            Log.i(ankoLogger, function0);
        }
    }

    public static final void warn(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        ankoLogger = ankoLogger.getLoggerTag();
        if (Log.isLoggable(ankoLogger, 5)) {
            function0 = function0.invoke();
            if (function0 != null) {
                function0 = function0.toString();
                if (function0 != null) {
                    Log.w(ankoLogger, function0);
                }
            }
            function0 = "null";
            Log.w(ankoLogger, function0);
        }
    }

    public static final void error(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        ankoLogger = ankoLogger.getLoggerTag();
        if (Log.isLoggable(ankoLogger, 6)) {
            function0 = function0.invoke();
            if (function0 != null) {
                function0 = function0.toString();
                if (function0 != null) {
                    Log.e(ankoLogger, function0);
                }
            }
            function0 = "null";
            Log.e(ankoLogger, function0);
        }
    }

    @NotNull
    public static final String getStackTraceString(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "$receiver");
        th = Log.getStackTraceString(th);
        Intrinsics.checkExpressionValueIsNotNull(th, "Log.getStackTraceString(this)");
        return th;
    }

    private static final void log(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Function2<? super String, ? super String, Unit> function2, Function3<? super String, ? super String, ? super Throwable, Unit> function3) {
        ankoLogger = ankoLogger.getLoggerTag();
        if (Log.isLoggable(ankoLogger, i) == 0) {
            return;
        }
        if (th != null) {
            if (obj != null) {
                obj = obj.toString();
                if (obj != null) {
                    function3.invoke(ankoLogger, obj, th);
                    return;
                }
            }
            obj = "null";
            function3.invoke(ankoLogger, obj, th);
            return;
        }
        if (obj != null) {
            obj = obj.toString();
            if (obj != null) {
                function2.invoke(ankoLogger, obj);
            }
        }
        obj = "null";
        function2.invoke(ankoLogger, obj);
    }

    private static final String getTag(Class<?> cls) {
        cls = cls.getSimpleName();
        if (cls.length() <= 23) {
            Intrinsics.checkExpressionValueIsNotNull(cls, "tag");
            return cls;
        } else if (cls != null) {
            cls = ((String) cls).substring(0, 23);
            Intrinsics.checkExpressionValueIsNotNull(cls, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return cls;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final void verbose(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        ankoLogger = ankoLogger.getLoggerTag();
        if (!Log.isLoggable(ankoLogger, 2)) {
            return;
        }
        if (th != null) {
            String str;
            if (obj != null) {
                obj = obj.toString();
                if (obj != null) {
                    str = (String) ankoLogger;
                    Log.v(str, (String) obj, th);
                    return;
                }
            }
            obj = "null";
            str = (String) ankoLogger;
            Log.v(str, (String) obj, th);
            return;
        }
        if (obj != null) {
            obj = obj.toString();
            if (obj != null) {
                Log.v((String) ankoLogger, (String) obj);
            }
        }
        obj = "null";
        Log.v((String) ankoLogger, (String) obj);
    }

    public static final void debug(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        ankoLogger = ankoLogger.getLoggerTag();
        if (!Log.isLoggable(ankoLogger, 3)) {
            return;
        }
        if (th != null) {
            String str;
            if (obj != null) {
                obj = obj.toString();
                if (obj != null) {
                    str = (String) ankoLogger;
                    Log.d(str, (String) obj, th);
                    return;
                }
            }
            obj = "null";
            str = (String) ankoLogger;
            Log.d(str, (String) obj, th);
            return;
        }
        if (obj != null) {
            obj = obj.toString();
            if (obj != null) {
                Log.d((String) ankoLogger, (String) obj);
            }
        }
        obj = "null";
        Log.d((String) ankoLogger, (String) obj);
    }

    public static final void info(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        ankoLogger = ankoLogger.getLoggerTag();
        if (!Log.isLoggable(ankoLogger, 4)) {
            return;
        }
        if (th != null) {
            String str;
            if (obj != null) {
                obj = obj.toString();
                if (obj != null) {
                    str = (String) ankoLogger;
                    Log.i(str, (String) obj, th);
                    return;
                }
            }
            obj = "null";
            str = (String) ankoLogger;
            Log.i(str, (String) obj, th);
            return;
        }
        if (obj != null) {
            obj = obj.toString();
            if (obj != null) {
                Log.i((String) ankoLogger, (String) obj);
            }
        }
        obj = "null";
        Log.i((String) ankoLogger, (String) obj);
    }

    public static final void warn(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        ankoLogger = ankoLogger.getLoggerTag();
        if (!Log.isLoggable(ankoLogger, 5)) {
            return;
        }
        if (th != null) {
            String str;
            if (obj != null) {
                obj = obj.toString();
                if (obj != null) {
                    str = (String) ankoLogger;
                    Log.w(str, (String) obj, th);
                    return;
                }
            }
            obj = "null";
            str = (String) ankoLogger;
            Log.w(str, (String) obj, th);
            return;
        }
        if (obj != null) {
            obj = obj.toString();
            if (obj != null) {
                Log.w((String) ankoLogger, (String) obj);
            }
        }
        obj = "null";
        Log.w((String) ankoLogger, (String) obj);
    }

    public static final void error(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        ankoLogger = ankoLogger.getLoggerTag();
        if (!Log.isLoggable(ankoLogger, 6)) {
            return;
        }
        if (th != null) {
            String str;
            if (obj != null) {
                obj = obj.toString();
                if (obj != null) {
                    str = (String) ankoLogger;
                    Log.e(str, (String) obj, th);
                    return;
                }
            }
            obj = "null";
            str = (String) ankoLogger;
            Log.e(str, (String) obj, th);
            return;
        }
        if (obj != null) {
            obj = obj.toString();
            if (obj != null) {
                Log.e((String) ankoLogger, (String) obj);
            }
        }
        obj = "null";
        Log.e((String) ankoLogger, (String) obj);
    }
}
