package com.aeries.mobileportal.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.aeries.mobileportal.presenters.BasePresenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H$¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH$J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H$J\b\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0014¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/views/BaseActivity;", "T", "Lcom/aeries/mobileportal/views/BaseViewModel;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "getLayout", "", "()Ljava/lang/Integer;", "getPresenter", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "inject", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {
    private HashMap _$_findViewCache;

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
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    @Nullable
    protected abstract Integer getLayout();

    @Nullable
    protected abstract BasePresenter<T> getPresenter();

    @Nullable
    protected abstract BaseViewModel getViewModel();

    public abstract void inject();

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getLayout() != null) {
            bundle = getLayout();
            if (bundle == null) {
                Intrinsics.throwNpe();
            }
            setContentView((int) bundle.intValue());
        }
        inject();
        bundle = getViewModel();
        if (bundle != null) {
            bundle.onCreate();
        }
        bundle = getPresenter();
        if (bundle != null) {
            bundle.onCreate();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.onDestroy();
        }
    }
}
