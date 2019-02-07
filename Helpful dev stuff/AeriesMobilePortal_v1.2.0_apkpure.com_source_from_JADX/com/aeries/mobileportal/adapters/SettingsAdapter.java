package com.aeries.mobileportal.adapters;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.BuildConfig;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.enums.Settings;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004 !\"#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u001e\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u001e\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0006\u0010\u001e\u001a\u00020\u0018J\u001e\u0010\u001f\u001a\u00020\u00182\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/aeries/mobileportal/adapters/SettingsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/SettingsAdapter$GenericSettingHolder;", "listener", "Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingsListener;", "(Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingsListener;)V", "headerCount", "", "getHeaderCount", "()I", "setHeaderCount", "(I)V", "getListener", "()Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingsListener;", "settings", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSettings", "()Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "restartHeaders", "update", "GenericSettingHolder", "SettingHolder", "SettingSection", "SettingsListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SettingsAdapter.kt */
public final class SettingsAdapter extends Adapter<GenericSettingHolder> {
    private int headerCount;
    @NotNull
    private final SettingsListener listener;
    @NotNull
    private final ArrayList<String> settings = new ArrayList();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingsListener;", "", "getPortalVersion", "", "invalidateToken", "", "onSettingSelected", "setting", "Lcom/aeries/mobileportal/enums/Settings;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SettingsAdapter.kt */
    public interface SettingsListener {
        @Nullable
        String getPortalVersion();

        void invalidateToken();

        void onSettingSelected(@NotNull Settings settings);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/adapters/SettingsAdapter$GenericSettingHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/SettingsAdapter;Landroid/view/View;)V", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SettingsAdapter.kt */
    public abstract class GenericSettingHolder extends ViewHolder {
        final /* synthetic */ SettingsAdapter this$0;

        public GenericSettingHolder(@NotNull SettingsAdapter settingsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = settingsAdapter;
            super(view);
        }
    }

    public final class SettingHolder_ViewBinding implements Unbinder {
        private SettingHolder target;

        @UiThread
        public SettingHolder_ViewBinding(SettingHolder settingHolder, View view) {
            this.target = settingHolder;
            settingHolder.picture = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.picture, "field 'picture'", ImageView.class);
            settingHolder.settingName = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.text, "field 'settingName'", TextView.class);
        }

        public void unbind() {
            SettingHolder settingHolder = this.target;
            if (settingHolder != null) {
                this.target = null;
                settingHolder.picture = null;
                settingHolder.settingName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final class SettingSection_ViewBinding implements Unbinder {
        private SettingSection target;

        @UiThread
        public SettingSection_ViewBinding(SettingSection settingSection, View view) {
            this.target = settingSection;
            settingSection.sectionNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.section_name, "field 'sectionNameTV'", TextView.class);
        }

        public void unbind() {
            SettingSection settingSection = this.target;
            if (settingSection != null) {
                this.target = null;
                settingSection.sectionNameTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingHolder;", "Lcom/aeries/mobileportal/adapters/SettingsAdapter$GenericSettingHolder;", "Lcom/aeries/mobileportal/adapters/SettingsAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/SettingsAdapter;Landroid/view/View;)V", "picture", "Landroid/widget/ImageView;", "getPicture", "()Landroid/widget/ImageView;", "setPicture", "(Landroid/widget/ImageView;)V", "settingName", "Landroid/widget/TextView;", "getSettingName", "()Landroid/widget/TextView;", "setSettingName", "(Landroid/widget/TextView;)V", "bindData", "", "setting", "Lcom/aeries/mobileportal/enums/Settings;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SettingsAdapter.kt */
    public final class SettingHolder extends GenericSettingHolder {
        @NotNull
        @BindView(2131362096)
        public ImageView picture;
        @NotNull
        @BindView(2131362189)
        public TextView settingName;
        final /* synthetic */ SettingsAdapter this$0;

        public SettingHolder(@NotNull SettingsAdapter settingsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = settingsAdapter;
            super(settingsAdapter, view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final ImageView getPicture() {
            ImageView imageView = this.picture;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picture");
            }
            return imageView;
        }

        public final void setPicture(@NotNull ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.picture = imageView;
        }

        @NotNull
        public final TextView getSettingName() {
            TextView textView = this.settingName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingName");
            }
            return textView;
        }

        public final void setSettingName(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.settingName = textView;
        }

        public final void bindData(@NotNull Settings settings) {
            Intrinsics.checkParameterIsNotNull(settings, "setting");
            if (settings.getName() != C0316R.string.invalidate_token) {
                this.itemView.setOnClickListener(new SettingsAdapter$SettingHolder$bindData$1(this, settings));
            } else {
                this.itemView.setOnClickListener(new SettingsAdapter$SettingHolder$bindData$2(this));
            }
            ImageView imageView = this.picture;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picture");
            }
            imageView.setImageResource(settings.getDrawable());
            StringCompanionObject stringCompanionObject;
            View view;
            String string;
            Object[] objArr;
            if (settings.getName() == C0316R.string.app_version) {
                settings = this.settingName;
                if (settings == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingName");
                }
                stringCompanionObject = StringCompanionObject.INSTANCE;
                view = this.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
                string = view.getContext().getString(C0316R.string.app_version);
                Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getString(R.string.app_version)");
                objArr = new Object[]{BuildConfig.VERSION_NAME};
                string = String.format(string, Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
                settings.setText(string);
            } else if (settings.getName() == C0316R.string.portal_version) {
                settings = this.settingName;
                if (settings == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingName");
                }
                stringCompanionObject = StringCompanionObject.INSTANCE;
                view = this.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
                string = view.getContext().getString(C0316R.string.portal_version);
                Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getStri…(R.string.portal_version)");
                objArr = new Object[1];
                String portalVersion = this.this$0.getListener().getPortalVersion();
                if (portalVersion != null) {
                    List split$default = StringsKt.split$default(portalVersion, new String[]{"."}, false, 0, 6, null);
                    if (split$default != null) {
                        portalVersion = CollectionsKt.joinToString$default(split$default, ".", null, null, 0, null, SettingsAdapter$SettingHolder$bindData$3.INSTANCE, 30, null);
                        objArr[0] = portalVersion;
                        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
                        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
                        settings.setText(string);
                    }
                }
                portalVersion = null;
                objArr[0] = portalVersion;
                string = String.format(string, Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
                settings.setText(string);
            } else {
                TextView textView = this.settingName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingName");
                }
                textView.setText(settings.getName());
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingSection;", "Lcom/aeries/mobileportal/adapters/SettingsAdapter$GenericSettingHolder;", "Lcom/aeries/mobileportal/adapters/SettingsAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/SettingsAdapter;Landroid/view/View;)V", "sectionNameTV", "Landroid/widget/TextView;", "getSectionNameTV", "()Landroid/widget/TextView;", "setSectionNameTV", "(Landroid/widget/TextView;)V", "bindData", "", "sectionName", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SettingsAdapter.kt */
    public final class SettingSection extends GenericSettingHolder {
        @NotNull
        @BindView(2131362143)
        public TextView sectionNameTV;
        final /* synthetic */ SettingsAdapter this$0;

        public SettingSection(@NotNull SettingsAdapter settingsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = settingsAdapter;
            super(settingsAdapter, view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getSectionNameTV() {
            TextView textView = this.sectionNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionNameTV");
            }
            return textView;
        }

        public final void setSectionNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.sectionNameTV = textView;
        }

        public final void bindData(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "sectionName");
            TextView textView = this.sectionNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionNameTV");
            }
            textView.setText(str);
        }
    }

    public SettingsAdapter(@NotNull SettingsListener settingsListener) {
        Intrinsics.checkParameterIsNotNull(settingsListener, CastExtraArgs.LISTENER);
        this.listener = settingsListener;
    }

    @NotNull
    public final SettingsListener getListener() {
        return this.listener;
    }

    @NotNull
    public final ArrayList<String> getSettings() {
        return this.settings;
    }

    public final int getHeaderCount() {
        return this.headerCount;
    }

    public final void setHeaderCount(int i) {
        this.headerCount = i;
    }

    public void onBindViewHolder(@Nullable GenericSettingHolder genericSettingHolder, int i) {
        if (genericSettingHolder instanceof SettingHolder) {
            SettingHolder settingHolder = (SettingHolder) genericSettingHolder;
            i = this.settings.get(i);
            Intrinsics.checkExpressionValueIsNotNull(i, "settings[position]");
            settingHolder.bindData(Settings.valueOf((String) i));
        } else if ((genericSettingHolder instanceof SettingSection) != 0) {
            switch (this.headerCount) {
                case 0:
                    i = genericSettingHolder.itemView;
                    Intrinsics.checkExpressionValueIsNotNull(i, "holder.itemView");
                    i = i.getContext().getString(C0316R.string.account);
                    break;
                case 1:
                    i = genericSettingHolder.itemView;
                    Intrinsics.checkExpressionValueIsNotNull(i, "holder.itemView");
                    i = i.getContext().getString(C0316R.string.district);
                    break;
                case 2:
                    i = genericSettingHolder.itemView;
                    Intrinsics.checkExpressionValueIsNotNull(i, "holder.itemView");
                    i = i.getContext().getString(C0316R.string.about);
                    break;
                default:
                    i = "";
                    break;
            }
            this.headerCount++;
            SettingSection settingSection = (SettingSection) genericSettingHolder;
            Intrinsics.checkExpressionValueIsNotNull(i, "name");
            settingSection.bindData(i);
        }
    }

    @NotNull
    public GenericSettingHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null);
        if (i == 1) {
            viewGroup = from.inflate(C0316R.layout.holder_setting_section, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
            return (GenericSettingHolder) new SettingSection(this, viewGroup);
        }
        viewGroup = from.inflate(C0316R.layout.holder_setting, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return (GenericSettingHolder) new SettingHolder(this, viewGroup);
    }

    public final void restartHeaders() {
        this.headerCount = 0;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.settings.size();
    }

    public int getItemViewType(int i) {
        return (Intrinsics.areEqual((String) this.settings.get(i), (Object) "") ^ 1) != 0 ? 0 : 1;
    }

    public final void update(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "settings");
        this.settings.clear();
        this.settings.addAll(arrayList);
        notifyDataSetChanged();
    }
}
