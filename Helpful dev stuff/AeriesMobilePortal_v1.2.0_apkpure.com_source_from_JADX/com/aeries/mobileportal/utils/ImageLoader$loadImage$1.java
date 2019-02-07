package com.aeries.mobileportal.utils;

import android.widget.ImageView;
import com.aeries.mobileportal.C0316R;
import com.squareup.picasso.Callback;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/aeries/mobileportal/utils/ImageLoader$loadImage$1", "Lcom/squareup/picasso/Callback;", "(Lcom/aeries/mobileportal/utils/ImageLoader;Ljava/lang/String;Lde/hdodenhof/circleimageview/CircleImageView;)V", "onError", "", "e", "Ljava/lang/Exception;", "onSuccess", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ImageLoader.kt */
public final class ImageLoader$loadImage$1 implements Callback {
    final /* synthetic */ CircleImageView $circleImageView;
    final /* synthetic */ String $completeURL;
    final /* synthetic */ ImageLoader this$0;

    public void onSuccess() {
    }

    ImageLoader$loadImage$1(ImageLoader imageLoader, String str, CircleImageView circleImageView) {
        this.this$0 = imageLoader;
        this.$completeURL = str;
        this.$circleImageView = circleImageView;
    }

    public void onError(@Nullable Exception exception) {
        this.this$0.picasso.load(this.$completeURL).placeholder((int) C0316R.drawable.user).into((ImageView) this.$circleImageView);
    }
}
