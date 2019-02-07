package com.aeries.mobileportal.adapters;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.AttendancePeriod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001e\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/aeries/mobileportal/adapters/PeriodsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/PeriodsAdapter$PeriodHolder;", "periods", "", "Lcom/aeries/mobileportal/models/AttendancePeriod;", "(Ljava/util/List;)V", "filteredPeriods", "getFilteredPeriods", "()Ljava/util/List;", "setFilteredPeriods", "getPeriods", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PeriodHolder", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: PeriodsAdapter.kt */
public final class PeriodsAdapter extends Adapter<PeriodHolder> {
    @NotNull
    private List<AttendancePeriod> filteredPeriods;
    @NotNull
    private final List<AttendancePeriod> periods;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/adapters/PeriodsAdapter$PeriodHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/PeriodsAdapter;Landroid/view/View;)V", "detailTitleTV", "Landroid/widget/TextView;", "getDetailTitleTV", "()Landroid/widget/TextView;", "setDetailTitleTV", "(Landroid/widget/TextView;)V", "detailValueTV", "getDetailValueTV", "setDetailValueTV", "bindData", "", "period", "Lcom/aeries/mobileportal/models/AttendancePeriod;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: PeriodsAdapter.kt */
    public final class PeriodHolder extends ViewHolder {
        @NotNull
        @BindView(2131361927)
        public TextView detailTitleTV;
        @NotNull
        @BindView(2131361929)
        public TextView detailValueTV;
        final /* synthetic */ PeriodsAdapter this$0;

        public PeriodHolder(@NotNull PeriodsAdapter periodsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = periodsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getDetailTitleTV() {
            TextView textView = this.detailTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitleTV");
            }
            return textView;
        }

        public final void setDetailTitleTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.detailTitleTV = textView;
        }

        @NotNull
        public final TextView getDetailValueTV() {
            TextView textView = this.detailValueTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailValueTV");
            }
            return textView;
        }

        public final void setDetailValueTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.detailValueTV = textView;
        }

        public final void bindData(@NotNull AttendancePeriod attendancePeriod) {
            Intrinsics.checkParameterIsNotNull(attendancePeriod, "period");
            TextView textView = this.detailTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitleTV");
            }
            textView.setText(String.valueOf(attendancePeriod.getPeriod()));
            textView = this.detailValueTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailValueTV");
            }
            textView.setText(attendancePeriod.getDescription());
        }
    }

    public final class PeriodHolder_ViewBinding implements Unbinder {
        private PeriodHolder target;

        @UiThread
        public PeriodHolder_ViewBinding(PeriodHolder periodHolder, View view) {
            this.target = periodHolder;
            periodHolder.detailTitleTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.detail_title, "field 'detailTitleTV'", TextView.class);
            periodHolder.detailValueTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.detail_value, "field 'detailValueTV'", TextView.class);
        }

        public void unbind() {
            PeriodHolder periodHolder = this.target;
            if (periodHolder != null) {
                this.target = null;
                periodHolder.detailTitleTV = null;
                periodHolder.detailValueTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PeriodsAdapter(@NotNull List<AttendancePeriod> list) {
        Intrinsics.checkParameterIsNotNull(list, "periods");
        this.periods = list;
        Collection arrayList = new ArrayList();
        for (Object next : this.periods) {
            if ((Intrinsics.areEqual(((AttendancePeriod) next).getCode(), (Object) "") ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        this.filteredPeriods = (List) arrayList;
    }

    @NotNull
    public final List<AttendancePeriod> getPeriods() {
        return this.periods;
    }

    @NotNull
    public final List<AttendancePeriod> getFilteredPeriods() {
        return this.filteredPeriods;
    }

    public final void setFilteredPeriods(@NotNull List<AttendancePeriod> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.filteredPeriods = list;
    }

    public int getItemCount() {
        return this.filteredPeriods.size();
    }

    public void onBindViewHolder(@Nullable PeriodHolder periodHolder, int i) {
        if (periodHolder != null) {
            periodHolder.bindData((AttendancePeriod) this.filteredPeriods.get(i));
        }
    }

    @NotNull
    public PeriodHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_two_texts_white_font_no_margin, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return new PeriodHolder(this, viewGroup);
    }
}
