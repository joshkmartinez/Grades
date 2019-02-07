package butterknife.internal;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class DebouncingOnClickListener implements OnClickListener {
    private static final Runnable ENABLE_AGAIN = new C03151();
    static boolean enabled = true;

    static class C03151 implements Runnable {
        C03151() {
        }

        public void run() {
            DebouncingOnClickListener.enabled = true;
        }
    }

    public abstract void doClick(View view);

    public final void onClick(View view) {
        if (enabled) {
            enabled = false;
            view.post(ENABLE_AGAIN);
            doClick(view);
        }
    }
}
