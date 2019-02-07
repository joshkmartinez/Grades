package io.realm.internal.android;

import android.os.Looper;
import io.realm.internal.Capabilities;

public class AndroidCapabilities implements Capabilities {
    private final boolean isIntentServiceThread = isIntentServiceThread();
    private final Looper looper = Looper.myLooper();

    public boolean canDeliverNotification() {
        return hasLooper() && !this.isIntentServiceThread;
    }

    public void checkCanDeliverNotification(String str) {
        StringBuilder stringBuilder;
        if (!hasLooper()) {
            if (str == null) {
                str = "";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" ");
                stringBuilder.append("Realm cannot be automatically updated on a thread without a looper.");
                str = stringBuilder.toString();
            }
            throw new IllegalStateException(str);
        } else if (this.isIntentServiceThread) {
            if (str == null) {
                str = "";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" ");
                stringBuilder.append("Realm cannot be automatically updated on an IntentService thread.");
                str = stringBuilder.toString();
            }
            throw new IllegalStateException(str);
        }
    }

    public boolean isMainThread() {
        return this.looper != null && this.looper == Looper.getMainLooper();
    }

    private boolean hasLooper() {
        return this.looper != null;
    }

    private static boolean isIntentServiceThread() {
        String name = Thread.currentThread().getName();
        return name != null && name.startsWith("IntentService[");
    }
}
