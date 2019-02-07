package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class WebViewFragment_ViewBinding implements Unbinder {
    private WebViewFragment target;

    @UiThread
    public WebViewFragment_ViewBinding(WebViewFragment webViewFragment, View view) {
        this.target = webViewFragment;
        webViewFragment.webView = (WebView) Utils.findRequiredViewAsType(view, C0316R.id.web_view, "field 'webView'", WebView.class);
        webViewFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
        webViewFragment.swipeLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, C0316R.id.swipe_layout, "field 'swipeLayout'", SwipeRefreshLayout.class);
    }

    public void unbind() {
        WebViewFragment webViewFragment = this.target;
        if (webViewFragment != null) {
            this.target = null;
            webViewFragment.webView = null;
            webViewFragment.progressBar = null;
            webViewFragment.swipeLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
