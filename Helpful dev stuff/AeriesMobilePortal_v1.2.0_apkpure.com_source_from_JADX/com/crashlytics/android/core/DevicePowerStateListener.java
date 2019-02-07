package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

class DevicePowerStateListener {
    private static final IntentFilter FILTER_BATTERY_CHANGED = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter FILTER_POWER_CONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter FILTER_POWER_DISCONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final Context context;
    private boolean isPowerConnected;
    private final BroadcastReceiver powerConnectedReceiver;
    private final BroadcastReceiver powerDisconnectedReceiver;
    private final AtomicBoolean receiversRegistered;

    class C04001 extends BroadcastReceiver {
        C04001() {
        }

        public void onReceive(Context context, Intent intent) {
            DevicePowerStateListener.this.isPowerConnected = true;
        }
    }

    class C04012 extends BroadcastReceiver {
        C04012() {
        }

        public void onReceive(Context context, Intent intent) {
            DevicePowerStateListener.this.isPowerConnected = null;
        }
    }

    public DevicePowerStateListener(Context context) {
        boolean z;
        this.context = context;
        Intent registerReceiver = context.registerReceiver(null, FILTER_BATTERY_CHANGED);
        int i = -1;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        if (i != 2) {
            if (i != 5) {
                z = false;
                this.isPowerConnected = z;
                this.powerConnectedReceiver = new C04001();
                this.powerDisconnectedReceiver = new C04012();
                context.registerReceiver(this.powerConnectedReceiver, FILTER_POWER_CONNECTED);
                context.registerReceiver(this.powerDisconnectedReceiver, FILTER_POWER_DISCONNECTED);
                this.receiversRegistered = new AtomicBoolean(true);
            }
        }
        z = true;
        this.isPowerConnected = z;
        this.powerConnectedReceiver = new C04001();
        this.powerDisconnectedReceiver = new C04012();
        context.registerReceiver(this.powerConnectedReceiver, FILTER_POWER_CONNECTED);
        context.registerReceiver(this.powerDisconnectedReceiver, FILTER_POWER_DISCONNECTED);
        this.receiversRegistered = new AtomicBoolean(true);
    }

    public boolean isPowerConnected() {
        return this.isPowerConnected;
    }

    public void dispose() {
        if (this.receiversRegistered.getAndSet(false)) {
            this.context.unregisterReceiver(this.powerConnectedReceiver);
            this.context.unregisterReceiver(this.powerDisconnectedReceiver);
        }
    }
}
