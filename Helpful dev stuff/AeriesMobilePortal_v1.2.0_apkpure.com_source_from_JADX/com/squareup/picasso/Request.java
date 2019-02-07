package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import com.squareup.picasso.Picasso.Priority;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class Request {
    private static final long TOO_LONG_LOG = TimeUnit.SECONDS.toNanos(5);
    public final boolean centerCrop;
    public final int centerCropGravity;
    public final boolean centerInside;
    public final Config config;
    public final boolean hasRotationPivot;
    int id;
    int networkPolicy;
    public final boolean onlyScaleDown;
    public final Priority priority;
    public final boolean purgeable;
    public final int resourceId;
    public final float rotationDegrees;
    public final float rotationPivotX;
    public final float rotationPivotY;
    public final String stableKey;
    long started;
    public final int targetHeight;
    public final int targetWidth;
    public final List<Transformation> transformations;
    public final Uri uri;

    public static final class Builder {
        private boolean centerCrop;
        private int centerCropGravity;
        private boolean centerInside;
        private Config config;
        private boolean hasRotationPivot;
        private boolean onlyScaleDown;
        private Priority priority;
        private boolean purgeable;
        private int resourceId;
        private float rotationDegrees;
        private float rotationPivotX;
        private float rotationPivotY;
        private String stableKey;
        private int targetHeight;
        private int targetWidth;
        private List<Transformation> transformations;
        private Uri uri;

        public Builder(@NonNull Uri uri) {
            setUri(uri);
        }

        public Builder(@DrawableRes int i) {
            setResourceId(i);
        }

        Builder(Uri uri, int i, Config config) {
            this.uri = uri;
            this.resourceId = i;
            this.config = config;
        }

        private Builder(Request request) {
            this.uri = request.uri;
            this.resourceId = request.resourceId;
            this.stableKey = request.stableKey;
            this.targetWidth = request.targetWidth;
            this.targetHeight = request.targetHeight;
            this.centerCrop = request.centerCrop;
            this.centerInside = request.centerInside;
            this.centerCropGravity = request.centerCropGravity;
            this.rotationDegrees = request.rotationDegrees;
            this.rotationPivotX = request.rotationPivotX;
            this.rotationPivotY = request.rotationPivotY;
            this.hasRotationPivot = request.hasRotationPivot;
            this.purgeable = request.purgeable;
            this.onlyScaleDown = request.onlyScaleDown;
            if (request.transformations != null) {
                this.transformations = new ArrayList(request.transformations);
            }
            this.config = request.config;
            this.priority = request.priority;
        }

        boolean hasImage() {
            if (this.uri == null) {
                if (this.resourceId == 0) {
                    return false;
                }
            }
            return true;
        }

        boolean hasSize() {
            if (this.targetWidth == 0) {
                if (this.targetHeight == 0) {
                    return false;
                }
            }
            return true;
        }

        boolean hasPriority() {
            return this.priority != null;
        }

        public Builder setUri(@NonNull Uri uri) {
            if (uri != null) {
                this.uri = uri;
                this.resourceId = null;
                return this;
            }
            throw new IllegalArgumentException("Image URI may not be null.");
        }

        public Builder setResourceId(@DrawableRes int i) {
            if (i != 0) {
                this.resourceId = i;
                this.uri = 0;
                return this;
            }
            throw new IllegalArgumentException("Image resource ID may not be 0.");
        }

        public Builder stableKey(@Nullable String str) {
            this.stableKey = str;
            return this;
        }

        public Builder resize(@Px int i, @Px int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 >= 0) {
                if (i2 == 0) {
                    if (i == 0) {
                        throw new IllegalArgumentException("At least one dimension has to be positive number.");
                    }
                }
                this.targetWidth = i;
                this.targetHeight = i2;
                return this;
            } else {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
        }

        public Builder clearResize() {
            this.targetWidth = 0;
            this.targetHeight = 0;
            this.centerCrop = false;
            this.centerInside = false;
            return this;
        }

        public Builder centerCrop() {
            return centerCrop(17);
        }

        public Builder centerCrop(int i) {
            if (this.centerInside) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.centerCrop = true;
            this.centerCropGravity = i;
            return this;
        }

        public Builder clearCenterCrop() {
            this.centerCrop = false;
            this.centerCropGravity = 17;
            return this;
        }

        public Builder centerInside() {
            if (this.centerCrop) {
                throw new IllegalStateException("Center inside can not be used after calling centerCrop");
            }
            this.centerInside = true;
            return this;
        }

        public Builder clearCenterInside() {
            this.centerInside = false;
            return this;
        }

        public Builder onlyScaleDown() {
            if (this.targetHeight == 0) {
                if (this.targetWidth == 0) {
                    throw new IllegalStateException("onlyScaleDown can not be applied without resize");
                }
            }
            this.onlyScaleDown = true;
            return this;
        }

        public Builder clearOnlyScaleDown() {
            this.onlyScaleDown = false;
            return this;
        }

        public Builder rotate(float f) {
            this.rotationDegrees = f;
            return this;
        }

        public Builder rotate(float f, float f2, float f3) {
            this.rotationDegrees = f;
            this.rotationPivotX = f2;
            this.rotationPivotY = f3;
            this.hasRotationPivot = true;
            return this;
        }

        public Builder clearRotation() {
            this.rotationDegrees = 0.0f;
            this.rotationPivotX = 0.0f;
            this.rotationPivotY = 0.0f;
            this.hasRotationPivot = false;
            return this;
        }

        public Builder purgeable() {
            this.purgeable = true;
            return this;
        }

        public Builder config(@NonNull Config config) {
            if (config != null) {
                this.config = config;
                return this;
            }
            throw new IllegalArgumentException("config == null");
        }

        public Builder priority(@NonNull Priority priority) {
            if (priority == null) {
                throw new IllegalArgumentException("Priority invalid.");
            } else if (this.priority == null) {
                this.priority = priority;
                return this;
            } else {
                throw new IllegalStateException("Priority already set.");
            }
        }

        public Builder transform(@NonNull Transformation transformation) {
            if (transformation == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (transformation.key() != null) {
                if (this.transformations == null) {
                    this.transformations = new ArrayList(2);
                }
                this.transformations.add(transformation);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }

        public Builder transform(@NonNull List<? extends Transformation> list) {
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    transform((Transformation) list.get(i));
                }
                return this;
            }
            throw new IllegalArgumentException("Transformation list must not be null.");
        }

        public Request build() {
            if (this.centerInside) {
                if (r0.centerCrop) {
                    throw new IllegalStateException("Center crop and center inside can not be used together.");
                }
            }
            if (r0.centerCrop && r0.targetWidth == 0) {
                if (r0.targetHeight == 0) {
                    throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
                }
            }
            if (r0.centerInside && r0.targetWidth == 0) {
                if (r0.targetHeight == 0) {
                    throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
                }
            }
            if (r0.priority == null) {
                r0.priority = Priority.NORMAL;
            }
            Uri uri = r0.uri;
            int i = r0.resourceId;
            String str = r0.stableKey;
            List list = r0.transformations;
            int i2 = r0.targetWidth;
            int i3 = r0.targetHeight;
            boolean z = r0.centerCrop;
            boolean z2 = r0.centerInside;
            int i4 = r0.centerCropGravity;
            boolean z3 = r0.onlyScaleDown;
            float f = r0.rotationDegrees;
            float f2 = r0.rotationPivotX;
            float f3 = r0.rotationPivotY;
            float f4 = f3;
            return new Request(uri, i, str, list, i2, i3, z, z2, i4, z3, f, f2, f4, r0.hasRotationPivot, r0.purgeable, r0.config, r0.priority);
        }
    }

    private Request(Uri uri, int i, String str, List<Transformation> list, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, float f, float f2, float f3, boolean z4, boolean z5, Config config, Priority priority) {
        this.uri = uri;
        this.resourceId = i;
        this.stableKey = str;
        if (list == null) {
            r0.transformations = null;
        } else {
            r0.transformations = Collections.unmodifiableList(list);
        }
        r0.targetWidth = i2;
        r0.targetHeight = i3;
        r0.centerCrop = z;
        r0.centerInside = z2;
        r0.centerCropGravity = i4;
        r0.onlyScaleDown = z3;
        r0.rotationDegrees = f;
        r0.rotationPivotX = f2;
        r0.rotationPivotY = f3;
        r0.hasRotationPivot = z4;
        r0.purgeable = z5;
        r0.config = config;
        r0.priority = priority;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.resourceId > 0) {
            stringBuilder.append(this.resourceId);
        } else {
            stringBuilder.append(this.uri);
        }
        if (!(this.transformations == null || this.transformations.isEmpty())) {
            for (Transformation transformation : this.transformations) {
                stringBuilder.append(' ');
                stringBuilder.append(transformation.key());
            }
        }
        if (this.stableKey != null) {
            stringBuilder.append(" stableKey(");
            stringBuilder.append(this.stableKey);
            stringBuilder.append(')');
        }
        if (this.targetWidth > 0) {
            stringBuilder.append(" resize(");
            stringBuilder.append(this.targetWidth);
            stringBuilder.append(',');
            stringBuilder.append(this.targetHeight);
            stringBuilder.append(')');
        }
        if (this.centerCrop) {
            stringBuilder.append(" centerCrop");
        }
        if (this.centerInside) {
            stringBuilder.append(" centerInside");
        }
        if (this.rotationDegrees != 0.0f) {
            stringBuilder.append(" rotation(");
            stringBuilder.append(this.rotationDegrees);
            if (this.hasRotationPivot) {
                stringBuilder.append(" @ ");
                stringBuilder.append(this.rotationPivotX);
                stringBuilder.append(',');
                stringBuilder.append(this.rotationPivotY);
            }
            stringBuilder.append(')');
        }
        if (this.purgeable) {
            stringBuilder.append(" purgeable");
        }
        if (this.config != null) {
            stringBuilder.append(' ');
            stringBuilder.append(this.config);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    String logId() {
        long nanoTime = System.nanoTime() - this.started;
        if (nanoTime > TOO_LONG_LOG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(plainId());
            stringBuilder.append('+');
            stringBuilder.append(TimeUnit.NANOSECONDS.toSeconds(nanoTime));
            stringBuilder.append('s');
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(plainId());
        stringBuilder.append('+');
        stringBuilder.append(TimeUnit.NANOSECONDS.toMillis(nanoTime));
        stringBuilder.append("ms");
        return stringBuilder.toString();
    }

    String plainId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[R");
        stringBuilder.append(this.id);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    String getName() {
        if (this.uri != null) {
            return String.valueOf(this.uri.getPath());
        }
        return Integer.toHexString(this.resourceId);
    }

    public boolean hasSize() {
        if (this.targetWidth == 0) {
            if (this.targetHeight == 0) {
                return false;
            }
        }
        return true;
    }

    boolean needsTransformation() {
        if (!needsMatrixTransform()) {
            if (!hasCustomTransformations()) {
                return false;
            }
        }
        return true;
    }

    boolean needsMatrixTransform() {
        if (!hasSize()) {
            if (this.rotationDegrees == 0.0f) {
                return false;
            }
        }
        return true;
    }

    boolean hasCustomTransformations() {
        return this.transformations != null;
    }

    public Builder buildUpon() {
        return new Builder();
    }
}
