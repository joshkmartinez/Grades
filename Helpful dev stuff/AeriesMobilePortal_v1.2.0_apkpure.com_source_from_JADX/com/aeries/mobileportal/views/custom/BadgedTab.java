package com.aeries.mobileportal.views.custom;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006$"}, d2 = {"Lcom/aeries/mobileportal/views/custom/BadgedTab;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "badge", "Landroid/support/v7/widget/CardView;", "getBadge", "()Landroid/support/v7/widget/CardView;", "setBadge", "(Landroid/support/v7/widget/CardView;)V", "badgeNumber", "Landroid/widget/TextView;", "getBadgeNumber", "()Landroid/widget/TextView;", "setBadgeNumber", "(Landroid/widget/TextView;)V", "rootView", "getRootView", "()Landroid/widget/RelativeLayout;", "tabTitle", "getTabTitle", "setTabTitle", "", "number", "", "setSelected", "selected", "", "setTitle", "res", "text", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: BadgedTab.kt */
public final class BadgedTab extends RelativeLayout {
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361847)
    public CardView badge;
    @NotNull
    @BindView(2131361848)
    public TextView badgeNumber;
    @NotNull
    private final RelativeLayout rootView;
    @NotNull
    @BindView(2131362183)
    public TextView tabTitle;

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

    @NotNull
    public final TextView getTabTitle() {
        TextView textView = this.tabTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        }
        return textView;
    }

    public final void setTabTitle(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.tabTitle = textView;
    }

    @NotNull
    public final CardView getBadge() {
        CardView cardView = this.badge;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        return cardView;
    }

    public final void setBadge(@NotNull CardView cardView) {
        Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
        this.badge = cardView;
    }

    @NotNull
    public final TextView getBadgeNumber() {
        TextView textView = this.badgeNumber;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badgeNumber");
        }
        return textView;
    }

    public final void setBadgeNumber(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.badgeNumber = textView;
    }

    @NotNull
    public final RelativeLayout getRootView() {
        return this.rootView;
    }

    public BadgedTab(@Nullable Context context) {
        super(context);
        context = RelativeLayout.inflate(getContext(), C0316R.layout.holder_notification_tab, this);
        if (context != null) {
            this.rootView = (RelativeLayout) context;
            ButterKnife.bind((Object) this, (View) this.rootView);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public BadgedTab(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attributeSet");
        super(context, attributeSet);
        context = RelativeLayout.inflate(getContext(), C0316R.layout.holder_notification_tab, this);
        if (context != null) {
            this.rootView = (RelativeLayout) context;
            ButterKnife.bind((Object) this, (View) this.rootView);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        TextView textView = this.tabTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        }
        textView.setText(str);
        invalidate();
    }

    public final void setTitle(int i) {
        TextView textView = this.tabTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        }
        textView.setText(i);
        invalidate();
    }

    public final void setBadgeNumber(int i) {
        CardView cardView = this.badge;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        cardView.setVisibility(i > 0 ? 0 : 8);
        if (i > 0) {
            TextView textView = this.badgeNumber;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("badgeNumber");
            }
            textView.setText(String.valueOf(i));
        }
    }

    public void setSelected(boolean z) {
        TextView textView = this.tabTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        }
        textView.setTextColor(ContextCompat.getColor(getContext(), z ? 17170443 : C0316R.color.gray1));
        super.setSelected(z);
    }
}
