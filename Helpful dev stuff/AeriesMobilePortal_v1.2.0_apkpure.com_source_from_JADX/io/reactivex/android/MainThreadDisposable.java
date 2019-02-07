package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable implements Disposable {
    private final AtomicBoolean unsubscribed = new AtomicBoolean();

    class C05191 implements Runnable {
        C05191() {
        }

        public void run() {
            MainThreadDisposable.this.onDispose();
        }
    }

    protected abstract void onDispose();

    public static void verifyMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected to be called on the main thread but was ");
            stringBuilder.append(Thread.currentThread().getName());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final boolean isDisposed() {
        return this.unsubscribed.get();
    }

    public final void dispose() {
        if (!this.unsubscribed.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onDispose();
        } else {
            AndroidSchedulers.mainThread().scheduleDirect(new C05191());
        }
    }
}
