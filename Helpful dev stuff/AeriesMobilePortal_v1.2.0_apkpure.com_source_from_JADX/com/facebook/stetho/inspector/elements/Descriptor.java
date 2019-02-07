package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.text.Typography;

public abstract class Descriptor<E> implements NodeDescriptor<E> {
    private Host mHost;

    public interface Host extends ThreadBound {
        @Nullable
        Descriptor<?> getDescriptor(@Nullable Object obj);

        void onAttributeModified(Object obj, String str, String str2);

        void onAttributeRemoved(Object obj, String str);
    }

    protected Descriptor() {
    }

    final void initialize(Host host) {
        Util.throwIfNull(host);
        Util.throwIfNotNull(this.mHost);
        this.mHost = host;
    }

    final boolean isInitialized() {
        return this.mHost != null;
    }

    protected final Host getHost() {
        return this.mHost;
    }

    public final boolean checkThreadAccess() {
        return getHost().checkThreadAccess();
    }

    public final void verifyThreadAccess() {
        getHost().verifyThreadAccess();
    }

    public final <V> V postAndWait(UncheckedCallable<V> uncheckedCallable) {
        return getHost().postAndWait((UncheckedCallable) uncheckedCallable);
    }

    public final void postAndWait(Runnable runnable) {
        getHost().postAndWait(runnable);
    }

    public final void postDelayed(Runnable runnable, long j) {
        getHost().postDelayed(runnable, j);
    }

    public final void removeCallbacks(Runnable runnable) {
        getHost().removeCallbacks(runnable);
    }

    protected static Map<String, String> parseSetAttributesAsTextArg(String str) {
        String str2 = "";
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> hashMap = new HashMap();
        int length = str.length();
        String str3 = "";
        int i = 0;
        int i2 = i;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '=') {
                str2 = stringBuilder.toString();
                stringBuilder.setLength(0);
            } else if (charAt == Typography.quote) {
                if (i2 != 0) {
                    str3 = stringBuilder.toString();
                    stringBuilder.setLength(0);
                }
                i2 ^= 1;
            } else if (charAt == ' ' && i2 == 0) {
                hashMap.put(str2, str3);
            } else {
                stringBuilder.append(charAt);
            }
            i++;
        }
        if (str2.isEmpty() == null && str3.isEmpty() == null) {
            hashMap.put(str2, str3);
        }
        return hashMap;
    }
}
