package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002@AB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\"\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000104H\u0016J(\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010;\u001a\u00020(H\u0016J\b\u0010<\u001a\u00020(H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u0006\u0010>\u001a\u00020(J\b\u0010?\u001a\u00020(H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006B"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/WebViewFragment;", "Landroid/support/v4/app/Fragment;", "Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;", "()V", "INPUT_FILE_REQUEST_CODE", "", "getINPUT_FILE_REQUEST_CODE", "()I", "cameraPhotoPath", "", "mFilePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "mListener", "Lcom/aeries/mobileportal/views/fragments/WebViewFragment$WebViewFragmentListener;", "mUrl", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "swipeLayout", "Landroid/support/v4/widget/SwipeRefreshLayout;", "getSwipeLayout", "()Landroid/support/v4/widget/SwipeRefreshLayout;", "setSwipeLayout", "(Landroid/support/v4/widget/SwipeRefreshLayout;)V", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "canGoBack", "", "createImageFile", "Ljava/io/File;", "goBack", "", "goForward", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "onRefresh", "refresh", "setupViews", "Companion", "WebViewFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: WebViewFragment.kt */
public final class WebViewFragment extends Fragment implements OnRefreshListener {
    public static final Companion Companion = new Companion();
    private static final String URL = "param1";
    private final int INPUT_FILE_REQUEST_CODE = 2;
    private HashMap _$_findViewCache;
    private String cameraPhotoPath;
    private ValueCallback<Uri[]> mFilePathCallback;
    private WebViewFragmentListener mListener;
    private String mUrl;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    @NotNull
    @BindView(2131362178)
    public SwipeRefreshLayout swipeLayout;
    @NotNull
    @BindView(2131362280)
    public WebView webView;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/WebViewFragment$Companion;", "", "()V", "URL", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/WebViewFragment;", "url", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: WebViewFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final WebViewFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            WebViewFragment webViewFragment = new WebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString(WebViewFragment.URL, str);
            webViewFragment.setArguments(bundle);
            return webViewFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/WebViewFragment$WebViewFragmentListener;", "", "canGoBack", "", "b", "", "canGoForward", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: WebViewFragment.kt */
    public interface WebViewFragmentListener {
        void canGoBack(boolean z);

        void canGoForward(boolean z);
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    @NotNull
    public final WebView getWebView() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        return webView;
    }

    public final void setWebView(@NotNull WebView webView) {
        Intrinsics.checkParameterIsNotNull(webView, "<set-?>");
        this.webView = webView;
    }

    @NotNull
    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return progressBar;
    }

    public final void setProgressBar(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    @NotNull
    public final SwipeRefreshLayout getSwipeLayout() {
        SwipeRefreshLayout swipeRefreshLayout = this.swipeLayout;
        if (swipeRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeLayout");
        }
        return swipeRefreshLayout;
    }

    public final void setSwipeLayout(@NotNull SwipeRefreshLayout swipeRefreshLayout) {
        Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "<set-?>");
        this.swipeLayout = swipeRefreshLayout;
    }

    public final int getINPUT_FILE_REQUEST_CODE() {
        return this.INPUT_FILE_REQUEST_CODE;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mUrl = getArguments().getString(URL);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_web_view, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        SwipeRefreshLayout swipeRefreshLayout = this.swipeLayout;
        if (swipeRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeLayout");
        }
        swipeRefreshLayout.setOnRefreshListener(this);
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setMax(100);
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.setWebViewClient(new WebViewClient());
        webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.setWebChromeClient(new WebViewFragment$setupViews$1(this));
        webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.getViewTreeObserver().addOnScrollChangedListener(new WebViewFragment$setupViews$2(this));
        webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.getViewTreeObserver().addOnGlobalLayoutListener(new WebViewFragment$setupViews$3(this));
        webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.setDownloadListener(new WebViewFragment$setupViews$4(this));
        webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "webView.settings");
        settings.setJavaScriptEnabled(true);
        webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.loadUrl(this.mUrl);
    }

    @NotNull
    public final File createImageFile() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JPEG_");
        stringBuilder.append(format);
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        File createTempFile = File.createTempFile(stringBuilder.toString(), ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        Intrinsics.checkExpressionValueIsNotNull(createTempFile, "File.createTempFile(\n   …     storageDir\n        )");
        return createTempFile;
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == this.INPUT_FILE_REQUEST_CODE) {
            if (this.mFilePathCallback != null) {
                Object obj = (Uri[]) 0;
                if (i2 == -1) {
                    if (intent != null) {
                        intent = intent.getDataString();
                        if (intent != null) {
                            obj = new Uri[1];
                            intent = Uri.parse(intent);
                            Intrinsics.checkExpressionValueIsNotNull(intent, "Uri.parse(dataString)");
                            obj[0] = intent;
                        }
                    } else if (this.cameraPhotoPath != null) {
                        obj = new Uri[1];
                        intent = Uri.parse(this.cameraPhotoPath);
                        Intrinsics.checkExpressionValueIsNotNull(intent, "Uri.parse(cameraPhotoPath)");
                        obj[0] = intent;
                    }
                }
                i2 = this.mFilePathCallback;
                if (i2 != 0) {
                    i2.onReceiveValue(obj);
                }
                this.mFilePathCallback = (ValueCallback) null;
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void goBack() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        if (webView.canGoBack()) {
            webView = this.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.goBack();
        }
    }

    public final void goForward() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        if (webView.canGoForward()) {
            webView = this.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.goForward();
        }
    }

    public final boolean canGoBack() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        return webView.canGoBack();
    }

    public final void refresh() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.reload();
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof WebViewFragmentListener) {
            this.mListener = (WebViewFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement WebViewFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDestroyView() {
        super.onDestroyView();
        SwipeRefreshLayout swipeRefreshLayout = this.swipeLayout;
        if (swipeRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeLayout");
        }
        swipeRefreshLayout.getViewTreeObserver().removeOnScrollChangedListener(WebViewFragment$onDestroyView$1.INSTANCE);
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (WebViewFragmentListener) null;
    }

    public void onRefresh() {
        refresh();
    }
}
