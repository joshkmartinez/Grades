package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {
    private final Callbacks callbacks = new C08371();
    private final ExecutorService executorService;

    class C08371 extends Callbacks {

        class C03741 implements Runnable {
            C03741() {
            }

            public void run() {
                ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
            }
        }

        C08371() {
        }

        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleCheckForUpdatesController.this.signalExternallyReady() != null) {
                ActivityLifecycleCheckForUpdatesController.this.executorService.submit(new C03741());
            }
        }
    }

    public boolean isActivityLifecycleTriggered() {
        return true;
    }

    public ActivityLifecycleCheckForUpdatesController(ActivityLifecycleManager activityLifecycleManager, ExecutorService executorService) {
        this.executorService = executorService;
        activityLifecycleManager.registerCallbacks(this.callbacks);
    }
}
