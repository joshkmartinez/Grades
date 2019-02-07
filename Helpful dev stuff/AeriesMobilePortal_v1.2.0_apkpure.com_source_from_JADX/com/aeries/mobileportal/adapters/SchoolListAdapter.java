package com.aeries.mobileportal.adapters;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView.Adapter;
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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004\u001d\u001e\u001f B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u001e\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u001e\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0014\u0010\u001b\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/adapters/SchoolListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter$ViewHolder;", "listener", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolListAdapterListener;", "(Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolListAdapterListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolListAdapterListener;", "schools", "", "Lcom/aeries/mobileportal/models/School;", "getSchools", "()Ljava/util/List;", "setSchools", "(Ljava/util/List;)V", "clearList", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "", "NotFoundVH", "SchoolListAdapterListener", "SchoolViewHolder", "ViewHolder", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolListAdapter.kt */
public final class SchoolListAdapter extends Adapter<ViewHolder> {
    @NotNull
    private final SchoolListAdapterListener listener;
    @NotNull
    private List<School> schools = ((List) new ArrayList());

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolListAdapterListener;", "", "onSchoolNoURL", "", "onSchoolNotFoundSelected", "onSchoolSelected", "school", "Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SchoolListAdapter.kt */
    public interface SchoolListAdapterListener {
        void onSchoolNoURL();

        void onSchoolNotFoundSelected();

        void onSchoolSelected(@NotNull School school);
    }

    public final class SchoolViewHolder_ViewBinding implements Unbinder {
        private SchoolViewHolder target;

        @UiThread
        public SchoolViewHolder_ViewBinding(SchoolViewHolder schoolViewHolder, View view) {
            this.target = schoolViewHolder;
            schoolViewHolder.schoolNameTv = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.school_name, "field 'schoolNameTv'", TextView.class);
            schoolViewHolder.districtNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.district_name, "field 'districtNameTV'", TextView.class);
            schoolViewHolder.appNotAvailable = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.app_not_available_tv, "field 'appNotAvailable'", TextView.class);
        }

        public void unbind() {
            SchoolViewHolder schoolViewHolder = this.target;
            if (schoolViewHolder != null) {
                this.target = null;
                schoolViewHolder.schoolNameTv = null;
                schoolViewHolder.districtNameTV = null;
                schoolViewHolder.appNotAvailable = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/adapters/SchoolListAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/SchoolListAdapter;Landroid/view/View;)V", "bind", "", "school", "Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SchoolListAdapter.kt */
    public abstract class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        final /* synthetic */ SchoolListAdapter this$0;

        public abstract void bind(@NotNull School school);

        public ViewHolder(@NotNull SchoolListAdapter schoolListAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = schoolListAdapter;
            super(view);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/adapters/SchoolListAdapter$NotFoundVH;", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter$ViewHolder;", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/SchoolListAdapter;Landroid/view/View;)V", "bind", "", "school", "Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SchoolListAdapter.kt */
    public final class NotFoundVH extends ViewHolder {
        final /* synthetic */ SchoolListAdapter this$0;

        public NotFoundVH(@NotNull SchoolListAdapter schoolListAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = schoolListAdapter;
            super(schoolListAdapter, view);
        }

        public void bind(@NotNull School school) {
            Intrinsics.checkParameterIsNotNull(school, "school");
            this.itemView.setOnClickListener(new SchoolListAdapter$NotFoundVH$bind$1(this));
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolViewHolder;", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter$ViewHolder;", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/SchoolListAdapter;Landroid/view/View;)V", "appNotAvailable", "Landroid/widget/TextView;", "getAppNotAvailable", "()Landroid/widget/TextView;", "setAppNotAvailable", "(Landroid/widget/TextView;)V", "districtNameTV", "getDistrictNameTV", "setDistrictNameTV", "schoolNameTv", "getSchoolNameTv", "setSchoolNameTv", "bind", "", "school", "Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SchoolListAdapter.kt */
    public final class SchoolViewHolder extends ViewHolder {
        @NotNull
        @BindView(2131361834)
        public TextView appNotAvailable;
        @NotNull
        @BindView(2131361935)
        public TextView districtNameTV;
        @NotNull
        @BindView(2131362119)
        public TextView schoolNameTv;
        final /* synthetic */ SchoolListAdapter this$0;

        public SchoolViewHolder(@NotNull SchoolListAdapter schoolListAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = schoolListAdapter;
            super(schoolListAdapter, view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getSchoolNameTv() {
            TextView textView = this.schoolNameTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolNameTv");
            }
            return textView;
        }

        public final void setSchoolNameTv(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.schoolNameTv = textView;
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

        @NotNull
        public final TextView getAppNotAvailable() {
            TextView textView = this.appNotAvailable;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appNotAvailable");
            }
            return textView;
        }

        public final void setAppNotAvailable(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.appNotAvailable = textView;
        }

        public void bind(@NotNull School school) {
            Intrinsics.checkParameterIsNotNull(school, "school");
            TextView textView = this.schoolNameTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolNameTv");
            }
            textView.setText(school.getSchoolName());
            textView = this.districtNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("districtNameTV");
            }
            textView.setText(school.getDistrictName());
            this.itemView.setOnClickListener(new SchoolListAdapter$SchoolViewHolder$bind$1(this, school));
            textView = this.appNotAvailable;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appNotAvailable");
            }
            textView.setVisibility(Intrinsics.areEqual(school.getAeriesAppParent(), Boolean.valueOf(true)) != null ? 8 : null);
        }
    }

    public SchoolListAdapter(@NotNull SchoolListAdapterListener schoolListAdapterListener) {
        Intrinsics.checkParameterIsNotNull(schoolListAdapterListener, CastExtraArgs.LISTENER);
        this.listener = schoolListAdapterListener;
    }

    @NotNull
    public final SchoolListAdapterListener getListener() {
        return this.listener;
    }

    @NotNull
    public final List<School> getSchools() {
        return this.schools;
    }

    public final void setSchools(@NotNull List<School> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.schools = list;
    }

    public int getItemCount() {
        return this.schools.size();
    }

    public void onBindViewHolder(@Nullable ViewHolder viewHolder, int i) {
        if (viewHolder != null) {
            viewHolder.bind((School) this.schools.get(i));
            viewHolder = Unit.INSTANCE;
        } else {
            viewHolder = null;
        }
        if (viewHolder == null) {
            Intrinsics.throwNpe();
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null);
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(parent?.context)");
        viewGroup = from.inflate(i == 0 ? C0316R.layout.holder_school : C0316R.layout.holder_school_not_found, viewGroup, false);
        if (i == 0) {
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "itemView");
            i = new SchoolViewHolder(this, viewGroup);
        } else {
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "itemView");
            i = new NotFoundVH(this, viewGroup);
        }
        return (ViewHolder) i;
    }

    public int getItemViewType(int i) {
        int i2;
        CharSequence districtName;
        CharSequence schoolName = ((School) this.schools.get(i)).getSchoolName();
        if (schoolName != null) {
            if (schoolName.length() != 0) {
                i2 = 0;
                if (i2 != 0) {
                    return 0;
                }
                districtName = ((School) this.schools.get(i)).getDistrictName();
                if (districtName != null) {
                    if (districtName.length() == 0) {
                        i = 0;
                        return i == 0 ? 1 : 0;
                    }
                }
                i = 1;
                if (i == 0) {
                }
            }
        }
        i2 = 1;
        if (i2 != 0) {
            return 0;
        }
        districtName = ((School) this.schools.get(i)).getDistrictName();
        if (districtName != null) {
            if (districtName.length() == 0) {
                i = 0;
                if (i == 0) {
                }
            }
        }
        i = 1;
        if (i == 0) {
        }
    }

    public final void updateList(@NotNull List<? extends School> list) {
        Intrinsics.checkParameterIsNotNull(list, "schools");
        this.schools.clear();
        this.schools.addAll(list);
        this.schools.add(new School());
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.schools.clear();
        notifyDataSetChanged();
    }
}
