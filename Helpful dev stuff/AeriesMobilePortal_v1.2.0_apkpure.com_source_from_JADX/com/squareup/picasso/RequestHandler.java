package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.io.IOException;
import okio.Source;

public abstract class RequestHandler {

    public static final class Result {
        private final Bitmap bitmap;
        private final int exifOrientation;
        private final LoadedFrom loadedFrom;
        private final Source source;

        public Result(@NonNull Bitmap bitmap, @NonNull LoadedFrom loadedFrom) {
            this((Bitmap) Utils.checkNotNull(bitmap, "bitmap == null"), null, loadedFrom, 0);
        }

        public Result(@NonNull Source source, @NonNull LoadedFrom loadedFrom) {
            this(null, (Source) Utils.checkNotNull(source, "source == null"), loadedFrom, 0);
        }

        Result(@Nullable Bitmap bitmap, @Nullable Source source, @NonNull LoadedFrom loadedFrom, int i) {
            Object obj = null;
            Object obj2 = bitmap != null ? 1 : null;
            if (source != null) {
                obj = 1;
            }
            if (obj2 != obj) {
                this.bitmap = bitmap;
                this.source = source;
                this.loadedFrom = (LoadedFrom) Utils.checkNotNull(loadedFrom, "loadedFrom == null");
                this.exifOrientation = i;
                return;
            }
            throw new AssertionError();
        }

        @Nullable
        public Bitmap getBitmap() {
            return this.bitmap;
        }

        @Nullable
        public Source getSource() {
            return this.source;
        }

        @NonNull
        public LoadedFrom getLoadedFrom() {
            return this.loadedFrom;
        }

        int getExifOrientation() {
            return this.exifOrientation;
        }
    }

    public abstract boolean canHandleRequest(Request request);

    int getRetryCount() {
        return 0;
    }

    @Nullable
    public abstract Result load(Request request, int i) throws IOException;

    boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean supportsReplay() {
        return false;
    }

    static Options createBitmapOptions(Request request) {
        boolean hasSize = request.hasSize();
        Object obj = request.config != null ? 1 : null;
        Options options = null;
        if (hasSize || obj != null || request.purgeable) {
            options = new Options();
            options.inJustDecodeBounds = hasSize;
            options.inInputShareable = request.purgeable;
            options.inPurgeable = request.purgeable;
            if (obj != null) {
                options.inPreferredConfig = request.config;
            }
        }
        return options;
    }

    static boolean requiresInSampleSize(Options options) {
        return (options == null || options.inJustDecodeBounds == null) ? null : true;
    }

    static void calculateInSampleSize(int i, int i2, Options options, Request request) {
        calculateInSampleSize(i, i2, options.outWidth, options.outHeight, options, request);
    }

    static void calculateInSampleSize(int i, int i2, int i3, int i4, Options options, Request request) {
        if (i4 <= i2) {
            if (i3 <= i) {
                i = 1;
                options.inSampleSize = i;
                options.inJustDecodeBounds = false;
            }
        }
        if (i2 == 0) {
            i = (int) Math.floor((double) (((float) i3) / ((float) i)));
        } else if (i == 0) {
            i = (int) Math.floor((double) (((float) i4) / ((float) i2)));
        } else {
            i2 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            i = (int) Math.floor((double) (((float) i3) / ((float) i)));
            i = request.centerInside != 0 ? Math.max(i2, i) : Math.min(i2, i);
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
    }
}
