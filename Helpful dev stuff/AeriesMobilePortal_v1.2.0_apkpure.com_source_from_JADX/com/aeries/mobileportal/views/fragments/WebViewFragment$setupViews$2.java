package com.aeries.mobileportal.views.fragments;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onScrollChanged"}, k = 3, mv = {1, 1, 10})
/* compiled from: WebViewFragment.kt */
final class WebViewFragment$setupViews$2 implements OnScrollChangedListener {
    final /* synthetic */ WebViewFragment this$0;

    WebViewFragment$setupViews$2(WebViewFragment webViewFragment) {
        this.this$0 = webViewFragment;
    }

    public final void onScrollChanged() {
        this.this$0.getSwipeLayout().setEnabled(this.this$0.getWebView().getScrollY() == 0);
    }
}
