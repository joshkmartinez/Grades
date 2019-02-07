package com.aeries.mobileportal.views.fragments;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.net.Uri;
import android.os.Environment;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "url", "", "<anonymous parameter 1>", "contentDisposition", "mimeType", "<anonymous parameter 4>", "", "onDownloadStart"}, k = 3, mv = {1, 1, 10})
/* compiled from: WebViewFragment.kt */
final class WebViewFragment$setupViews$4 implements DownloadListener {
    final /* synthetic */ WebViewFragment this$0;

    WebViewFragment$setupViews$4(WebViewFragment webViewFragment) {
        this.this$0 = webViewFragment;
    }

    public final void onDownloadStart(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "<anonymous parameter 1>");
        Intrinsics.checkParameterIsNotNull(str3, "contentDisposition");
        Intrinsics.checkParameterIsNotNull(str4, "mimeType");
        str2 = new Request(Uri.parse(str));
        str2.allowScanningByMediaScanner();
        str2.setNotificationVisibility(1);
        str2.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str3, str4));
        str = this.this$0.getContext().getSystemService("download");
        if (str != null) {
            ((DownloadManager) str).enqueue(str2);
            Toast.makeText(this.this$0.getContext(), "Downloading file.", 1).show();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
    }
}
