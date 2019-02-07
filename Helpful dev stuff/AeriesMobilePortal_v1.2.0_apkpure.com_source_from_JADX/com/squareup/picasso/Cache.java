package com.squareup.picasso;

import android.graphics.Bitmap;

public interface Cache {
    public static final Cache NONE = new C09211();

    static class C09211 implements Cache {
        public void clear() {
        }

        public void clearKeyUri(String str) {
        }

        public Bitmap get(String str) {
            return null;
        }

        public int maxSize() {
            return 0;
        }

        public void set(String str, Bitmap bitmap) {
        }

        public int size() {
            return 0;
        }

        C09211() {
        }
    }

    void clear();

    void clearKeyUri(String str);

    Bitmap get(String str);

    int maxSize();

    void set(String str, Bitmap bitmap);

    int size();
}
