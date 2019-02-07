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
import com.aeries.mobileportal.models.School;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001e\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/adapters/DistrictsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictHolder;", "listener", "Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictsListener;", "(Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictsListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictsListener;", "schools", "", "Lcom/aeries/mobileportal/models/School;", "getSchools", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "", "DistrictHolder", "DistrictsListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DistrictsAdapter.kt */
public final class DistrictsAdapter extends Adapter<DistrictHolder> {
    @NotNull
    private final DistrictsListener listener;
    @NotNull
    private final List<School> schools = ((List) new ArrayList());

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictsListener;", "", "onDistrictSelected", "", "school", "Lcom/aeries/mobileportal/models/School;", "onDistrictURLEmpty", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DistrictsAdapter.kt */
    public interface DistrictsListener {
        void onDistrictSelected(@NotNull School school);

        void onDistrictURLEmpty();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/DistrictsAdapter;Landroid/view/View;)V", "districtNameTV", "Landroid/widget/TextView;", "getDistrictNameTV", "()Landroid/widget/TextView;", "setDistrictNameTV", "(Landroid/widget/TextView;)V", "schoolNameTV", "getSchoolNameTV", "setSchoolNameTV", "bindData", "", "school", "Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DistrictsAdapter.kt */
    public final class DistrictHolder extends ViewHolder {
        @NotNull
        @BindView(2131361935)
        public TextView districtNameTV;
        @NotNull
        @BindView(2131362119)
        public TextView schoolNameTV;
        final /* synthetic */ DistrictsAdapter this$0;

        public DistrictHolder(@NotNull DistrictsAdapter districtsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = districtsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getSchoolNameTV() {
            TextView textView = this.schoolNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
            }
            return textView;
        }

        public final void setSchoolNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.schoolNameTV = textView;
        }

        @NotNull
        public final TextView getDistrictNameTV() {
            TextView textView = this.districtNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("districtNameTV");
            }
            return textView;
        }

        public final void setDistrictNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.districtNameTV = textView;
        }

        public final void bindData(@NotNull School school) {
            Intrinsics.checkParameterIsNotNull(school, "school");
            TextView textView = this.schoolNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
            }
            textView.setText(school.getSchoolName());
            textView = this.districtNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("districtNameTV");
            }
            textView.setText(school.getDistrictName());
            this.itemView.setOnClickListener(new DistrictsAdapter$DistrictHolder$bindData$1(this, school));
        }
    }

    public final class DistrictHolder_ViewBinding implements Unbinder {
        private DistrictHolder target;

        @UiThread
        public DistrictHolder_ViewBinding(DistrictHolder districtHolder, View view) {
            this.target = districtHolder;
            districtHolder.schoolNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.school_name, "field 'schoolNameTV'", TextView.class);
            districtHolder.districtNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.district_name, "field 'districtNameTV'", TextView.class);
        }

        public void unbind() {
            DistrictHolder districtHolder = this.target;
            if (districtHolder != null) {
                this.target = null;
                districtHolder.schoolNameTV = null;
                districtHolder.districtNameTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DistrictsAdapter(@NotNull DistrictsListener districtsListener) {
        Intrinsics.checkParameterIsNotNull(districtsListener, CastExtraArgs.LISTENER);
        this.listener = districtsListener;
    }

    @NotNull
    public final DistrictsListener getListener() {
        return this.listener;
    }

    @NotNull
    public final List<School> getSchools() {
        return this.schools;
    }

    public void onBindViewHolder(@Nullable DistrictHolder districtHolder, int i) {
        if (districtHolder != null) {
            districtHolder.bindData((School) this.schools.get(i));
        }
    }

    public int getItemCount() {
        return this.schools.size();
    }

    @NotNull
    public DistrictHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_school, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return new DistrictHolder(this, viewGroup);
    }

    public final void update(@NotNull List<? extends School> list) {
        Intrinsics.checkParameterIsNotNull(list, "schools");
        this.schools.clear();
        this.schools.addAll(list);
        notifyDataSetChanged();
    }
}
