package com.aeries.mobileportal.adapters;

import android.content.Context;
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
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.enums.DemographicsDetails;
import com.aeries.mobileportal.models.Demographics;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004!\"#$B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u001e\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u001e\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\tH\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/aeries/mobileportal/adapters/DemographicsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsHolder;", "listener", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsListener;", "demographics", "Lcom/aeries/mobileportal/models/Demographics;", "(Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsListener;Lcom/aeries/mobileportal/models/Demographics;)V", "DETAIL", "", "getDETAIL", "()I", "HEADER", "getHEADER", "getDemographics", "()Lcom/aeries/mobileportal/models/Demographics;", "details", "", "", "getDetails", "()Ljava/util/List;", "getListener", "()Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsListener;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DemographicDetailHolder", "DemographicHeaderHolder", "DemographicsHolder", "DemographicsListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DemographicsAdapter.kt */
public final class DemographicsAdapter extends Adapter<DemographicsHolder> {
    private final int DETAIL;
    private final int HEADER = 1;
    @NotNull
    private final Demographics demographics;
    @NotNull
    private final List<String> details = AppConstants.Companion.getDEMOGRAPHICS_DETAILS();
    @NotNull
    private final DemographicsListener listener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsListener;", "", "onAddressSelected", "", "address", "", "onEmailSelected", "email", "onPhoneSelected", "phone", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DemographicsAdapter.kt */
    public interface DemographicsListener {
        void onAddressSelected(@Nullable String str);

        void onEmailSelected(@Nullable String str);

        void onPhoneSelected(@Nullable String str);
    }

    public final class DemographicDetailHolder_ViewBinding implements Unbinder {
        private DemographicDetailHolder target;

        @UiThread
        public DemographicDetailHolder_ViewBinding(DemographicDetailHolder demographicDetailHolder, View view) {
            this.target = demographicDetailHolder;
            demographicDetailHolder.titleTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.title_tv, "field 'titleTV'", TextView.class);
            demographicDetailHolder.detailTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.detail_tv, "field 'detailTV'", TextView.class);
            demographicDetailHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.icon, "field 'icon'", ImageView.class);
        }

        public void unbind() {
            DemographicDetailHolder demographicDetailHolder = this.target;
            if (demographicDetailHolder != null) {
                this.target = null;
                demographicDetailHolder.titleTV = null;
                demographicDetailHolder.detailTV = null;
                demographicDetailHolder.icon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final class DemographicHeaderHolder_ViewBinding implements Unbinder {
        private DemographicHeaderHolder target;

        @UiThread
        public DemographicHeaderHolder_ViewBinding(DemographicHeaderHolder demographicHeaderHolder, View view) {
            this.target = demographicHeaderHolder;
            demographicHeaderHolder.sectionHeader = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.section_header, "field 'sectionHeader'", TextView.class);
        }

        public void unbind() {
            DemographicHeaderHolder demographicHeaderHolder = this.target;
            if (demographicHeaderHolder != null) {
                this.target = null;
                demographicHeaderHolder.sectionHeader = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/DemographicsAdapter;Landroid/view/View;)V", "bindData", "", "detailName", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DemographicsAdapter.kt */
    public abstract class DemographicsHolder extends ViewHolder {
        final /* synthetic */ DemographicsAdapter this$0;

        public abstract void bindData(@NotNull String str);

        public DemographicsHolder(@NotNull DemographicsAdapter demographicsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = demographicsAdapter;
            super(view);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicDetailHolder;", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsHolder;", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/DemographicsAdapter;Landroid/view/View;)V", "detailTV", "Landroid/widget/TextView;", "getDetailTV", "()Landroid/widget/TextView;", "setDetailTV", "(Landroid/widget/TextView;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "titleTV", "getTitleTV", "setTitleTV", "bindData", "", "detailName", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DemographicsAdapter.kt */
    public final class DemographicDetailHolder extends DemographicsHolder {
        @NotNull
        @BindView(2131361928)
        public TextView detailTV;
        @NotNull
        @BindView(2131361990)
        public ImageView icon;
        final /* synthetic */ DemographicsAdapter this$0;
        @NotNull
        @BindView(2131362260)
        public TextView titleTV;

        public DemographicDetailHolder(@NotNull DemographicsAdapter demographicsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = demographicsAdapter;
            super(demographicsAdapter, view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getTitleTV() {
            TextView textView = this.titleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTV");
            }
            return textView;
        }

        public final void setTitleTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.titleTV = textView;
        }

        @NotNull
        public final TextView getDetailTV() {
            TextView textView = this.detailTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTV");
            }
            return textView;
        }

        public final void setDetailTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.detailTV = textView;
        }

        @NotNull
        public final ImageView getIcon() {
            ImageView imageView = this.icon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.APP_ICON_KEY);
            }
            return imageView;
        }

        public final void setIcon(@NotNull ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.icon = imageView;
        }

        public void bindData(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "detailName");
            str = DemographicsDetails.valueOf(str);
            TextView textView = this.titleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTV");
            }
            Demographics demographics = this.this$0.getDemographics();
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            Context context = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
            textView.setText(str.getTitle(demographics, context));
            textView = this.detailTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTV");
            }
            textView.setText(str.getDetail(this.this$0.getDemographics()));
            ImageView imageView = this.icon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.APP_ICON_KEY);
            }
            imageView.setImageResource(str.getIcon());
            this.itemView.setOnClickListener(new DemographicsAdapter$DemographicDetailHolder$bindData$1(this, str));
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicHeaderHolder;", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsHolder;", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/DemographicsAdapter;Landroid/view/View;)V", "sectionHeader", "Landroid/widget/TextView;", "getSectionHeader", "()Landroid/widget/TextView;", "setSectionHeader", "(Landroid/widget/TextView;)V", "bindData", "", "detailName", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DemographicsAdapter.kt */
    public final class DemographicHeaderHolder extends DemographicsHolder {
        @NotNull
        @BindView(2131362142)
        public TextView sectionHeader;
        final /* synthetic */ DemographicsAdapter this$0;

        public DemographicHeaderHolder(@NotNull DemographicsAdapter demographicsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = demographicsAdapter;
            super(demographicsAdapter, view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getSectionHeader() {
            TextView textView = this.sectionHeader;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionHeader");
            }
            return textView;
        }

        public final void setSectionHeader(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.sectionHeader = textView;
        }

        public void bindData(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "detailName");
            TextView textView = this.sectionHeader;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionHeader");
            }
            str = StringsKt.removePrefix(str, "<header>");
            if (str != null) {
                str = str.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase()");
                str = DemographicsDetails.valueOf(str);
                Demographics demographics = new Demographics();
                View view = this.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
                Context context = view.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
                textView.setText(str.getTitle(demographics, context));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public DemographicsAdapter(@NotNull DemographicsListener demographicsListener, @NotNull Demographics demographics) {
        Intrinsics.checkParameterIsNotNull(demographicsListener, CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(demographics, "demographics");
        this.listener = demographicsListener;
        this.demographics = demographics;
    }

    @NotNull
    public final Demographics getDemographics() {
        return this.demographics;
    }

    @NotNull
    public final DemographicsListener getListener() {
        return this.listener;
    }

    @NotNull
    public final List<String> getDetails() {
        return this.details;
    }

    public final int getDETAIL() {
        return this.DETAIL;
    }

    public final int getHEADER() {
        return this.HEADER;
    }

    public void onBindViewHolder(@Nullable DemographicsHolder demographicsHolder, int i) {
        if (demographicsHolder != null) {
            demographicsHolder.bindData((String) this.details.get(i));
        }
    }

    public int getItemCount() {
        return this.details.size();
    }

    @NotNull
    public DemographicsHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null);
        if (i == this.DETAIL) {
            viewGroup = from.inflate(C0316R.layout.holder_demographic_detail, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
            return (DemographicsHolder) new DemographicDetailHolder(this, viewGroup);
        }
        viewGroup = from.inflate(C0316R.layout.holder_demographic_section, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return (DemographicsHolder) new DemographicHeaderHolder(this, viewGroup);
    }

    public int getItemViewType(int i) {
        return new Regex("<header>").containsMatchIn((CharSequence) this.details.get(i)) != 0 ? this.HEADER : this.DETAIL;
    }
}
