package com.aeries.mobileportal.views.fragments;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J2\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"com/aeries/mobileportal/views/fragments/WebViewFragment$setupViews$1", "Landroid/webkit/WebChromeClient;", "(Lcom/aeries/mobileportal/views/fragments/WebViewFragment;)V", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "onShowFileChooser", "", "webView", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: WebViewFragment.kt */
public final class WebViewFragment$setupViews$1 extends WebChromeClient {
    final /* synthetic */ WebViewFragment this$0;

    WebViewFragment$setupViews$1(WebViewFragment webViewFragment) {
        this.this$0 = webViewFragment;
    }

    public void onProgressChanged(@Nullable WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (i == 0) {
            this.this$0.getProgressBar().setIndeterminate(true);
        } else {
            this.this$0.getProgressBar().setIndeterminate(false);
            this.this$0.getProgressBar().setProgress(i);
        }
        if (i > 75) {
            this.this$0.getSwipeLayout().setRefreshing(false);
        }
        if (i == 100) {
            this.this$0.getProgressBar().setVisibility(8);
            webView = this.this$0.mListener;
            if (webView != null) {
                webView.canGoForward(this.this$0.getWebView().canGoForward());
            }
            webView = this.this$0.mListener;
            if (webView != null) {
                webView.canGoBack(this.this$0.getWebView().canGoBack());
                return;
            }
            return;
        }
        this.this$0.getProgressBar().setVisibility(0);
    }

    public boolean onShowFileChooser(@org.jetbrains.annotations.Nullable android.webkit.WebView r4, @org.jetbrains.annotations.Nullable android.webkit.ValueCallback<android.net.Uri[]> r5, @org.jetbrains.annotations.Nullable android.webkit.WebChromeClient.FileChooserParams r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r4 = r3.this$0;
        r4 = r4.mFilePathCallback;
        r6 = 0;
        if (r4 == 0) goto L_0x0014;
    L_0x0009:
        r4 = r3.this$0;
        r4 = r4.mFilePathCallback;
        if (r4 == 0) goto L_0x0014;
    L_0x0011:
        r4.onReceiveValue(r6);
    L_0x0014:
        r4 = r3.this$0;
        r4.mFilePathCallback = r5;
        r4 = new android.content.Intent;
        r5 = "android.media.action.IMAGE_CAPTURE";
        r4.<init>(r5);
        r5 = r3.this$0;
        r5 = r5.getActivity();
        r0 = "activity";
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0);
        r5 = r5.getPackageManager();
        r5 = r4.resolveActivity(r5);
        if (r5 == 0) goto L_0x0076;
    L_0x0035:
        r5 = r6;
        r5 = (java.io.File) r5;
        r0 = r3.this$0;	 Catch:{ IOException -> 0x004a }
        r0 = r0.createImageFile();	 Catch:{ IOException -> 0x004a }
        r5 = "PhotoPath";	 Catch:{ IOException -> 0x004b }
        r1 = r3.this$0;	 Catch:{ IOException -> 0x004b }
        r1 = r1.cameraPhotoPath;	 Catch:{ IOException -> 0x004b }
        r4.putExtra(r5, r1);	 Catch:{ IOException -> 0x004b }
        goto L_0x004b;
    L_0x004a:
        r0 = r5;
    L_0x004b:
        if (r0 == 0) goto L_0x0073;
    L_0x004d:
        r5 = r3.this$0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r1 = "file:";
        r6.append(r1);
        r1 = r0.getAbsolutePath();
        r6.append(r1);
        r6 = r6.toString();
        r5.cameraPhotoPath = r6;
        r5 = "output";
        r6 = android.net.Uri.fromFile(r0);
        r6 = (android.os.Parcelable) r6;
        r4.putExtra(r5, r6);
        goto L_0x0076;
    L_0x0073:
        r4 = r6;
        r4 = (android.content.Intent) r4;
    L_0x0076:
        r5 = new android.content.Intent;
        r6 = "android.intent.action.GET_CONTENT";
        r5.<init>(r6);
        r6 = "android.intent.category.OPENABLE";
        r5.addCategory(r6);
        r6 = "*/*";
        r5.setType(r6);
        r6 = 0;
        r0 = 1;
        if (r4 == 0) goto L_0x0090;
    L_0x008b:
        r1 = new android.content.Intent[r0];
        r1[r6] = r4;
        goto L_0x0092;
    L_0x0090:
        r1 = new android.content.Intent[r6];
    L_0x0092:
        r4 = new android.content.Intent;
        r6 = "android.intent.action.CHOOSER";
        r4.<init>(r6);
        r6 = "android.intent.extra.INTENT";
        r5 = (android.os.Parcelable) r5;
        r4.putExtra(r6, r5);
        r5 = "android.intent.extra.TITLE";
        r6 = r3.this$0;
        r2 = 2131624016; // 0x7f0e0050 float:1.88752E38 double:1.053162196E-314;
        r6 = r6.getString(r2);
        r4.putExtra(r5, r6);
        r5 = "android.intent.extra.INITIAL_INTENTS";
        r1 = (android.os.Parcelable[]) r1;
        r4.putExtra(r5, r1);
        r5 = r3.this$0;
        r6 = r3.this$0;
        r6 = r6.getINPUT_FILE_REQUEST_CODE();
        r5.startActivityForResult(r4, r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aeries.mobileportal.views.fragments.WebViewFragment$setupViews$1.onShowFileChooser(android.webkit.WebView, android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):boolean");
    }
}
