package android.support.transition;

import android.annotation.SuppressLint;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static final String TAG = "ViewUtilsApi22";
    private static Method sSetLeftTopRightBottomMethod;
    private static boolean sSetLeftTopRightBottomMethodFetched;

    ViewUtilsApi22() {
    }

    public void setLeftTopRightBottom(android.view.View r4, int r5, int r6, int r7, int r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.fetchSetLeftTopRightBottomMethod();
        r0 = sSetLeftTopRightBottomMethod;
        if (r0 == 0) goto L_0x0037;
    L_0x0007:
        r0 = sSetLeftTopRightBottomMethod;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1 = 4;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r2] = r5;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 1;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 2;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 3;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r8);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        goto L_0x0037;
    L_0x002c:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r4 = r4.getCause();
        r5.<init>(r4);
        throw r5;
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi22.setLeftTopRightBottom(android.view.View, int, int, int, int):void");
    }

    @SuppressLint({"PrivateApi"})
    private void fetchSetLeftTopRightBottomMethod() {
        if (!sSetLeftTopRightBottomMethodFetched) {
            try {
                sSetLeftTopRightBottomMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                sSetLeftTopRightBottomMethod.setAccessible(true);
            } catch (Throwable e) {
                Log.i(TAG, "Failed to retrieve setLeftTopRightBottom method", e);
            }
            sSetLeftTopRightBottomMethodFetched = true;
        }
    }
}
