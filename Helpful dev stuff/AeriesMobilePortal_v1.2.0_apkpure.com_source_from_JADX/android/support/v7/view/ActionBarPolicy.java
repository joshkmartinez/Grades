package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.appcompat.C0242R;
import android.view.ViewConfiguration;
import com.facebook.stetho.server.http.HttpStatus;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import org.jetbrains.anko.DimensionsKt;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ActionBarPolicy {
    private Context mContext;

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public int getMaxActionButtons() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT && i <= SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT && (i <= 960 || i2 <= 720)) {
            if (i <= 720 || i2 <= 960) {
                if (i < HttpStatus.HTTP_INTERNAL_SERVER_ERROR && (i <= DimensionsKt.XXXHDPI || i2 <= DimensionsKt.XXHDPI)) {
                    if (i <= DimensionsKt.XXHDPI || i2 <= DimensionsKt.XXXHDPI) {
                        return i >= 360 ? 3 : 2;
                    }
                }
                return 4;
            }
        }
        return 5;
    }

    public boolean showsOverflowMenuButton() {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return ViewConfiguration.get(this.mContext).hasPermanentMenuKey() ^ true;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(C0242R.bool.abc_action_bar_embed_tabs);
    }

    public int getTabContainerHeight() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, C0242R.styleable.ActionBar, C0242R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0242R.styleable.ActionBar_height, 0);
        Resources resources = this.mContext.getResources();
        if (!hasEmbeddedTabs()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0242R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean enableHomeButtonByDefault() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(C0242R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
