package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.CheckResult;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.UiThread;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife {
    @VisibleForTesting
    static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    public interface Action<T extends View> {
        @UiThread
        void apply(@NonNull T t, int i);
    }

    public interface Setter<T extends View, V> {
        @UiThread
        void set(@NonNull T t, V v, int i);
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Activity activity) {
        return createBinding(activity, activity.getWindow().getDecorView());
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull View view) {
        return createBinding(view, view);
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Dialog dialog) {
        return createBinding(dialog, dialog.getWindow().getDecorView());
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Object obj, @NonNull Activity activity) {
        return createBinding(obj, activity.getWindow().getDecorView());
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Object obj, @NonNull View view) {
        return createBinding(obj, view);
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Object obj, @NonNull Dialog dialog) {
        return createBinding(obj, dialog.getWindow().getDecorView());
    }

    private static Unbinder createBinding(@NonNull Object obj, @NonNull View view) {
        StringBuilder stringBuilder;
        Class cls = obj.getClass();
        if (debug) {
            String str = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Looking up binding for ");
            stringBuilder2.append(cls.getName());
            Log.d(str, stringBuilder2.toString());
        }
        Constructor findBindingConstructorForClass = findBindingConstructorForClass(cls);
        if (findBindingConstructorForClass == null) {
            return Unbinder.EMPTY;
        }
        try {
            return (Unbinder) findBindingConstructorForClass.newInstance(new Object[]{obj, view});
        } catch (Object obj2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to invoke ");
            stringBuilder.append(findBindingConstructorForClass);
            throw new RuntimeException(stringBuilder.toString(), obj2);
        } catch (Object obj22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to invoke ");
            stringBuilder.append(findBindingConstructorForClass);
            throw new RuntimeException(stringBuilder.toString(), obj22);
        } catch (Object obj222) {
            obj222 = obj222.getCause();
            if ((obj222 instanceof RuntimeException) != null) {
                throw ((RuntimeException) obj222);
            } else if ((obj222 instanceof Error) != null) {
                throw ((Error) obj222);
            } else {
                throw new RuntimeException("Unable to create binding instance.", obj222);
            }
        }
    }

    @android.support.annotation.UiThread
    @android.support.annotation.CheckResult
    @android.support.annotation.Nullable
    private static java.lang.reflect.Constructor<? extends butterknife.Unbinder> findBindingConstructorForClass(java.lang.Class<?> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = BINDINGS;
        r0 = r0.get(r5);
        r0 = (java.lang.reflect.Constructor) r0;
        if (r0 == 0) goto L_0x0016;
    L_0x000a:
        r5 = debug;
        if (r5 == 0) goto L_0x0015;
    L_0x000e:
        r5 = "ButterKnife";
        r1 = "HIT: Cached in binding map.";
        android.util.Log.d(r5, r1);
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = r5.getName();
        r1 = "android.";
        r1 = r0.startsWith(r1);
        if (r1 != 0) goto L_0x00a8;
    L_0x0022:
        r1 = "java.";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x002c;
    L_0x002a:
        goto L_0x00a8;
    L_0x002c:
        r1 = r5.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r3 = "_ViewBinding";	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r1 = r1.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2 = 2;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2[r3] = r5;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r4 = android.view.View.class;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2[r3] = r4;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r1 = r1.getConstructor(r2);	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r2 = debug;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        if (r2 == 0) goto L_0x00a2;	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
    L_0x0058:
        r2 = "ButterKnife";	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        r3 = "HIT: Loaded binding class and constructor.";	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        android.util.Log.d(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0078, NoSuchMethodException -> 0x0060 }
        goto L_0x00a2;
    L_0x0060:
        r5 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to find binding constructor for ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r1.<init>(r0, r5);
        throw r1;
    L_0x0078:
        r0 = debug;
        if (r0 == 0) goto L_0x009a;
    L_0x007c:
        r0 = "ButterKnife";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Not found. Trying superclass ";
        r1.append(r2);
        r2 = r5.getSuperclass();
        r2 = r2.getName();
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r0, r1);
    L_0x009a:
        r0 = r5.getSuperclass();
        r1 = findBindingConstructorForClass(r0);
    L_0x00a2:
        r0 = BINDINGS;
        r0.put(r5, r1);
        return r1;
    L_0x00a8:
        r5 = debug;
        if (r5 == 0) goto L_0x00b3;
    L_0x00ac:
        r5 = "ButterKnife";
        r0 = "MISS: Reached framework class. Abandoning search.";
        android.util.Log.d(r5, r0);
    L_0x00b3:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: butterknife.ButterKnife.findBindingConstructorForClass(java.lang.Class):java.lang.reflect.Constructor<? extends butterknife.Unbinder>");
    }

    @UiThread
    @SafeVarargs
    public static <T extends View> void apply(@NonNull List<T> list, @NonNull Action<? super T>... actionArr) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (Action apply : actionArr) {
                apply.apply((View) list.get(i), i);
            }
        }
    }

    @UiThread
    @SafeVarargs
    public static <T extends View> void apply(@NonNull T[] tArr, @NonNull Action<? super T>... actionArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            for (Action apply : actionArr) {
                apply.apply(tArr[i], i);
            }
        }
    }

    @UiThread
    public static <T extends View> void apply(@NonNull List<T> list, @NonNull Action<? super T> action) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            action.apply((View) list.get(i), i);
        }
    }

    @UiThread
    public static <T extends View> void apply(@NonNull T[] tArr, @NonNull Action<? super T> action) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            action.apply(tArr[i], i);
        }
    }

    @UiThread
    @SafeVarargs
    public static <T extends View> void apply(@NonNull T t, @NonNull Action<? super T>... actionArr) {
        for (Action apply : actionArr) {
            apply.apply(t, 0);
        }
    }

    @UiThread
    public static <T extends View> void apply(@NonNull T t, @NonNull Action<? super T> action) {
        action.apply(t, 0);
    }

    @UiThread
    public static <T extends View, V> void apply(@NonNull List<T> list, @NonNull Setter<? super T, V> setter, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            setter.set((View) list.get(i), v, i);
        }
    }

    @UiThread
    public static <T extends View, V> void apply(@NonNull T[] tArr, @NonNull Setter<? super T, V> setter, V v) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            setter.set(tArr[i], v, i);
        }
    }

    @UiThread
    public static <T extends View, V> void apply(@NonNull T t, @NonNull Setter<? super T, V> setter, V v) {
        setter.set(t, v, 0);
    }

    @UiThread
    @RequiresApi(14)
    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull List<T> list, @NonNull Property<? super T, V> property, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            property.set(list.get(i), v);
        }
    }

    @UiThread
    @RequiresApi(14)
    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull T[] tArr, @NonNull Property<? super T, V> property, V v) {
        for (Object obj : tArr) {
            property.set(obj, v);
        }
    }

    @UiThread
    @RequiresApi(14)
    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull T t, @NonNull Property<? super T, V> property, V v) {
        property.set(t, v);
    }

    @Deprecated
    @CheckResult
    public static <T extends View> T findById(@NonNull View view, @IdRes int i) {
        return view.findViewById(i);
    }

    @Deprecated
    @CheckResult
    public static <T extends View> T findById(@NonNull Activity activity, @IdRes int i) {
        return activity.findViewById(i);
    }

    @Deprecated
    @CheckResult
    public static <T extends View> T findById(@NonNull Dialog dialog, @IdRes int i) {
        return dialog.findViewById(i);
    }
}
