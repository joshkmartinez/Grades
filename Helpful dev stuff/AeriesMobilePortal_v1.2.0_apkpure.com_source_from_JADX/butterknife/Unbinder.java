package butterknife;

import android.support.annotation.UiThread;

public interface Unbinder {
    public static final Unbinder EMPTY = new C06141();

    static class C06141 implements Unbinder {
        public void unbind() {
        }

        C06141() {
        }
    }

    @UiThread
    void unbind();
}
