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
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.ViewPermission;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001e\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailHolder;", "listener", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "(Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;)V", "details", "", "Lcom/aeries/mobileportal/models/ViewPermission;", "getDetails", "()Ljava/util/List;", "getListener", "()Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "DetailHolder", "DetailListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentDetailsAdapter.kt */
public final class StudentDetailsAdapter extends Adapter<DetailHolder> {
    @NotNull
    private final List<ViewPermission> details = ((List) new ArrayList());
    @NotNull
    private final DetailListener listener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "", "getReportCardsEnabled", "", "onDetailSelected", "", "viewPermission", "Lcom/aeries/mobileportal/models/ViewPermission;", "positionX", "", "positionY", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: StudentDetailsAdapter.kt */
    public interface DetailListener {
        boolean getReportCardsEnabled();

        void onDetailSelected(@NotNull ViewPermission viewPermission, int i, int i2);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;Landroid/view/View;)V", "detailIcon", "Landroid/widget/ImageView;", "getDetailIcon", "()Landroid/widget/ImageView;", "setDetailIcon", "(Landroid/widget/ImageView;)V", "detailNameTV", "Landroid/widget/TextView;", "getDetailNameTV", "()Landroid/widget/TextView;", "setDetailNameTV", "(Landroid/widget/TextView;)V", "bindData", "", "viewPermission", "Lcom/aeries/mobileportal/models/ViewPermission;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: StudentDetailsAdapter.kt */
    public final class DetailHolder extends ViewHolder {
        @NotNull
        @BindView(2131361924)
        public ImageView detailIcon;
        @NotNull
        @BindView(2131361925)
        public TextView detailNameTV;
        final /* synthetic */ StudentDetailsAdapter this$0;

        public DetailHolder(@NotNull StudentDetailsAdapter studentDetailsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = studentDetailsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final ImageView getDetailIcon() {
            ImageView imageView = this.detailIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
            }
            return imageView;
        }

        public final void setDetailIcon(@NotNull ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.detailIcon = imageView;
        }

        @NotNull
        public final TextView getDetailNameTV() {
            TextView textView = this.detailNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailNameTV");
            }
            return textView;
        }

        public final void setDetailNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.detailNameTV = textView;
        }

        public final void bindData(@NotNull ViewPermission viewPermission) {
            Intrinsics.checkParameterIsNotNull(viewPermission, "viewPermission");
            try {
                String viewCode = viewPermission.getViewCode();
                if (viewCode == null) {
                    Intrinsics.throwNpe();
                }
                Permissions valueOf = Permissions.valueOf(viewCode);
                ImageView imageView = this.detailIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
                }
                imageView.setImageResource(valueOf.getImageID());
                TextView textView = this.detailNameTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailNameTV");
                }
                textView.setText(valueOf.getPermissionName());
                this.itemView.setOnClickListener(new StudentDetailsAdapter$DetailHolder$bindData$1(this, viewPermission));
            } catch (ViewPermission viewPermission2) {
                viewPermission2.printStackTrace();
                viewPermission2 = this.itemView;
                Intrinsics.checkExpressionValueIsNotNull(viewPermission2, "itemView");
                viewPermission2.setVisibility(8);
            }
        }
    }

    public final class DetailHolder_ViewBinding implements Unbinder {
        private DetailHolder target;

        @UiThread
        public DetailHolder_ViewBinding(DetailHolder detailHolder, View view) {
            this.target = detailHolder;
            detailHolder.detailIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.detail_icon, "field 'detailIcon'", ImageView.class);
            detailHolder.detailNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.detail_name, "field 'detailNameTV'", TextView.class);
        }

        public void unbind() {
            DetailHolder detailHolder = this.target;
            if (detailHolder != null) {
                this.target = null;
                detailHolder.detailIcon = null;
                detailHolder.detailNameTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public StudentDetailsAdapter(@NotNull DetailListener detailListener) {
        Intrinsics.checkParameterIsNotNull(detailListener, CastExtraArgs.LISTENER);
        this.listener = detailListener;
    }

    @NotNull
    public final DetailListener getListener() {
        return this.listener;
    }

    @NotNull
    public final List<ViewPermission> getDetails() {
        return this.details;
    }

    public int getItemCount() {
        return this.details.size();
    }

    public void onBindViewHolder(@Nullable DetailHolder detailHolder, int i) {
        if (detailHolder != null) {
            detailHolder.bindData((ViewPermission) this.details.get(i));
        }
    }

    @NotNull
    public DetailHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        i = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0);
        Intrinsics.checkExpressionValueIsNotNull(i, "LayoutInflater.from(parent?.context)");
        viewGroup = i.inflate(C0316R.layout.holder_student_detail, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "inflater.inflate(R.layou…nt_detail, parent, false)");
        return new DetailHolder(this, viewGroup);
    }

    public final void update(@org.jetbrains.annotations.NotNull java.util.List<com.aeries.mobileportal.models.ViewPermission> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = "details";
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0);
        r6 = (java.lang.Iterable) r6;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.Collection) r0;
        r6 = r6.iterator();
    L_0x0012:
        r1 = r6.hasNext();
        r2 = 1;
        if (r1 == 0) goto L_0x0034;
    L_0x0019:
        r1 = r6.next();
        r3 = r1;
        r3 = (com.aeries.mobileportal.models.ViewPermission) r3;
        r3 = r3.getViewCode();	 Catch:{ Exception -> 0x002d }
        if (r3 != 0) goto L_0x0029;	 Catch:{ Exception -> 0x002d }
    L_0x0026:
        kotlin.jvm.internal.Intrinsics.throwNpe();	 Catch:{ Exception -> 0x002d }
    L_0x0029:
        com.aeries.mobileportal.enums.Permissions.valueOf(r3);	 Catch:{ Exception -> 0x002d }
        goto L_0x002e;
    L_0x002d:
        r2 = 0;
    L_0x002e:
        if (r2 == 0) goto L_0x0012;
    L_0x0030:
        r0.add(r1);
        goto L_0x0012;
    L_0x0034:
        r0 = (java.util.List) r0;
        r6 = r5.listener;
        r6 = r6.getReportCardsEnabled();
        if (r6 != 0) goto L_0x0071;
    L_0x003e:
        r0 = (java.lang.Iterable) r0;
        r6 = new java.util.ArrayList;
        r6.<init>();
        r6 = (java.util.Collection) r6;
        r0 = r0.iterator();
    L_0x004b:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x006e;
    L_0x0051:
        r1 = r0.next();
        r3 = r1;
        r3 = (com.aeries.mobileportal.models.ViewPermission) r3;
        r3 = r3.getViewCode();
        if (r3 != 0) goto L_0x0061;
    L_0x005e:
        kotlin.jvm.internal.Intrinsics.throwNpe();
    L_0x0061:
        r4 = "RCH";
        r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4);
        r3 = r3 ^ r2;
        if (r3 == 0) goto L_0x004b;
    L_0x006a:
        r6.add(r1);
        goto L_0x004b;
    L_0x006e:
        r0 = r6;
        r0 = (java.util.List) r0;
    L_0x0071:
        r6 = r5.details;
        r6.clear();
        r6 = r5.details;
        r0 = (java.lang.Iterable) r0;
        r1 = new com.aeries.mobileportal.adapters.StudentDetailsAdapter$update$$inlined$sortedBy$1;
        r1.<init>();
        r1 = (java.util.Comparator) r1;
        r0 = kotlin.collections.CollectionsKt.sortedWith(r0, r1);
        r0 = (java.util.Collection) r0;
        r6.addAll(r0);
        r5.notifyDataSetChanged();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aeries.mobileportal.adapters.StudentDetailsAdapter.update(java.util.List):void");
    }
}
