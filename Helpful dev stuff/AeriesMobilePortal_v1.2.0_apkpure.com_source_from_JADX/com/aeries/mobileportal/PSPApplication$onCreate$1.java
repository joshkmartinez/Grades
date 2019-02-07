package com.aeries.mobileportal;

import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Listener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/squareup/picasso/Picasso;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/net/Uri;", "e", "Ljava/lang/Exception;", "onImageLoadFailed"}, k = 3, mv = {1, 1, 10})
/* compiled from: PSPApplication.kt */
final class PSPApplication$onCreate$1 implements Listener {
    public static final PSPApplication$onCreate$1 INSTANCE = new PSPApplication$onCreate$1();

    PSPApplication$onCreate$1() {
    }

    public final void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
        exception.printStackTrace();
    }
}
