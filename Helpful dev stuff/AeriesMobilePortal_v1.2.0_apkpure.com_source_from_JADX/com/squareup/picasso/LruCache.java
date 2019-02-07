package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class LruCache implements Cache {
    final android.util.LruCache<String, BitmapAndSize> cache;

    static final class BitmapAndSize {
        final Bitmap bitmap;
        final int byteCount;

        BitmapAndSize(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.byteCount = i;
        }
    }

    public LruCache(@NonNull Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }

    public LruCache(int i) {
        this.cache = new android.util.LruCache<String, BitmapAndSize>(i) {
            protected int sizeOf(String str, BitmapAndSize bitmapAndSize) {
                return bitmapAndSize.byteCount;
            }
        };
    }

    @Nullable
    public Bitmap get(@NonNull String str) {
        BitmapAndSize bitmapAndSize = (BitmapAndSize) this.cache.get(str);
        return bitmapAndSize != null ? bitmapAndSize.bitmap : null;
    }

    public void set(@NonNull String str, @NonNull Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int bitmapBytes = Utils.getBitmapBytes(bitmap);
        if (bitmapBytes > maxSize()) {
            this.cache.remove(str);
        } else {
            this.cache.put(str, new BitmapAndSize(bitmap, bitmapBytes));
        }
    }

    public int size() {
        return this.cache.size();
    }

    public int maxSize() {
        return this.cache.maxSize();
    }

    public void clear() {
        this.cache.evictAll();
    }

    public void clearKeyUri(String str) {
        for (String str2 : this.cache.snapshot().keySet()) {
            if (str2.startsWith(str) && str2.length() > str.length() && str2.charAt(str.length()) == '\n') {
                this.cache.remove(str2);
            }
        }
    }

    public int hitCount() {
        return this.cache.hitCount();
    }

    public int missCount() {
        return this.cache.missCount();
    }

    public int putCount() {
        return this.cache.putCount();
    }

    public int evictionCount() {
        return this.cache.evictionCount();
    }
}
