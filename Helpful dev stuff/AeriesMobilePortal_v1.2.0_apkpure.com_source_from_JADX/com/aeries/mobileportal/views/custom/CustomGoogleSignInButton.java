package com.aeries.mobileportal.views.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import com.aeries.mobileportal.C0316R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\n¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/views/custom/CustomGoogleSignInButton;", "Landroid/support/v7/widget/AppCompatButton;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/Integer;)V", "parseAttributes", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CustomGoogleSignInButton.kt */
public final class CustomGoogleSignInButton extends AppCompatButton {
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

    public CustomGoogleSignInButton(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, null);
    }

    public CustomGoogleSignInButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, attributeSet, Integer.valueOf(0));
    }

    public CustomGoogleSignInButton(@NotNull Context context, @Nullable AttributeSet attributeSet, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, num != null ? num.intValue() : 0);
        parseAttributes(context, attributeSet, num);
    }

    private final void parseAttributes(Context context, AttributeSet attributeSet, Integer num) {
        if (num != null) {
            context.getTheme().obtainStyledAttributes(attributeSet, C0316R.styleable.SignInButton, num.intValue(), 0);
        }
    }
}
