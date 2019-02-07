package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.ReportCardsAdapter;
import com.aeries.mobileportal.adapters.ReportCardsAdapter.ReportCardsListener;
import com.aeries.mobileportal.dagger.components.ReportCardsFragmentComponent;
import com.aeries.mobileportal.models.ReportCard;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsFragmentPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.viewmodels.report_cards.ReportCardsFragmentViewModel;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002NOB\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u0012\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u000101H\u0016J(\u00102\u001a\u0004\u0018\u00010\u00142\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001062\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00107\u001a\u00020,H\u0016J\u0018\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J-\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020?2\u000e\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0A2\u0006\u0010C\u001a\u00020DH\u0016¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020,H\u0002J\b\u0010H\u001a\u00020,H\u0002J\u0012\u0010I\u001a\u00020,2\b\u0010J\u001a\u0004\u0018\u00010BH\u0016J\u0016\u0010K\u001a\u00020,2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020:0MH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006P"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ReportCardsFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardsListener;", "Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsFragmentViewModel;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/ReportCardsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/ReportCardsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/ReportCardsAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/ReportCardsFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/ReportCardsFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "mFragmentListener", "Lcom/aeries/mobileportal/views/fragments/ReportCardsFragment$ReportCardsFragmentListener;", "noReportsView", "Landroid/view/View;", "getNoReportsView", "()Landroid/view/View;", "setNoReportsView", "(Landroid/view/View;)V", "presenter", "Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsFragmentPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsFragmentPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsFragmentPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "reportCardsRV", "Landroid/support/v7/widget/RecyclerView;", "getReportCardsRV", "()Landroid/support/v7/widget/RecyclerView;", "setReportCardsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onReportCardSelected", "report", "Lcom/aeries/mobileportal/models/ReportCard;", "isEnglish", "", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestWriteExternalStoragePermission", "requestWritePermission", "setupViews", "showError", "message", "showReportCards", "reports", "", "Companion", "ReportCardsFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsFragment.kt */
public final class ReportCardsFragment extends Fragment implements ReportCardsListener, ReportCardsFragmentViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReportCardsFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/ReportCardsFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public ReportCardsAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new ReportCardsFragment$component$2(this));
    private ReportCardsFragmentListener mFragmentListener;
    @NotNull
    @BindView(2131362066)
    public View noReportsView;
    @Inject
    @NotNull
    public ReportCardsFragmentPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    @NotNull
    @BindView(2131362106)
    public RecyclerView reportCardsRV;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ReportCardsFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/ReportCardsFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ReportCardsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ReportCardsFragment newInstance() {
            ReportCardsFragment reportCardsFragment = new ReportCardsFragment();
            reportCardsFragment.setArguments(new Bundle());
            return reportCardsFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ReportCardsFragment$ReportCardsFragmentListener;", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ReportCardsFragment.kt */
    public interface ReportCardsFragmentListener {
    }

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
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    @NotNull
    public final ReportCardsFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ReportCardsFragmentComponent) lazy.getValue();
    }

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getReportCardsRV() {
        RecyclerView recyclerView = this.reportCardsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportCardsRV");
        }
        return recyclerView;
    }

    public final void setReportCardsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.reportCardsRV = recyclerView;
    }

    @NotNull
    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return progressBar;
    }

    public final void setProgressBar(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    @NotNull
    public final View getNoReportsView() {
        View view = this.noReportsView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noReportsView");
        }
        return view;
    }

    public final void setNoReportsView(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.noReportsView = view;
    }

    @NotNull
    public final ReportCardsFragmentPresenter getPresenter() {
        ReportCardsFragmentPresenter reportCardsFragmentPresenter = this.presenter;
        if (reportCardsFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return reportCardsFragmentPresenter;
    }

    public final void setPresenter(@NotNull ReportCardsFragmentPresenter reportCardsFragmentPresenter) {
        Intrinsics.checkParameterIsNotNull(reportCardsFragmentPresenter, "<set-?>");
        this.presenter = reportCardsFragmentPresenter;
    }

    @NotNull
    public final ReportCardsAdapter getAdapter() {
        ReportCardsAdapter reportCardsAdapter = this.adapter;
        if (reportCardsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return reportCardsAdapter;
    }

    public final void setAdapter(@NotNull ReportCardsAdapter reportCardsAdapter) {
        Intrinsics.checkParameterIsNotNull(reportCardsAdapter, "<set-?>");
        this.adapter = reportCardsAdapter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_report_cards, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != null) {
            requestWriteExternalStoragePermission();
        } else {
            viewGroup = this.presenter;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            viewGroup.getReportCards();
        }
        return inflate;
    }

    private final void requestWriteExternalStoragePermission() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            ReportCardsFragmentPresenter reportCardsFragmentPresenter = this.presenter;
            if (reportCardsFragmentPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            reportCardsFragmentPresenter.getReportCards();
        } else if (shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            new Builder(getContext()).setTitle((int) C0316R.string.permission_needed).setMessage((int) C0316R.string.write_files_permission_explanation).setPositiveButton((int) C0316R.string.got_it, (OnClickListener) new ReportCardsFragment$requestWriteExternalStoragePermission$1(this)).setOnCancelListener(new ReportCardsFragment$requestWriteExternalStoragePermission$2(this)).show();
        } else {
            requestWritePermission();
        }
    }

    private final void requestWritePermission() {
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 123);
    }

    private final void setupViews() {
        RecyclerView recyclerView = this.reportCardsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportCardsRV");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView = this.reportCardsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportCardsRV");
        }
        ReportCardsAdapter reportCardsAdapter = this.adapter;
        if (reportCardsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(reportCardsAdapter);
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i == 123) {
            if ((1 ^ (iArr.length == 0 ? 1 : 0)) == null || iArr[0] != 0) {
                i = DialogUtils.Companion;
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                i.getDialogBuilder(context, (int) 2131624186, (int) C0316R.string.need_permission_to_continue).setButton((int) 2131624112, (Function0) new ReportCardsFragment$onRequestPermissionsResult$1(this)).setOnCancelListener((Function0) new ReportCardsFragment$onRequestPermissionsResult$2(this)).show();
            } else {
                i = this.presenter;
                if (i == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                i.getReportCards();
            }
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof ReportCardsFragmentListener) {
            this.mFragmentListener = (ReportCardsFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement ReportCardsFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mFragmentListener = (ReportCardsFragmentListener) null;
    }

    public void onReportCardSelected(@NotNull ReportCard reportCard, boolean z) {
        Intrinsics.checkParameterIsNotNull(reportCard, "report");
        ReportCardsFragmentPresenter reportCardsFragmentPresenter = this.presenter;
        if (reportCardsFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reportCardsFragmentPresenter.downloadReport(reportCard, z);
        Toast.makeText(getContext(), true, 1).show();
    }

    public void showReportCards(@NotNull List<ReportCard> list) {
        Intrinsics.checkParameterIsNotNull(list, "reports");
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
        if (list.isEmpty()) {
            View view = this.noReportsView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noReportsView");
            }
            view.setVisibility(0);
        }
        ReportCardsAdapter reportCardsAdapter = this.adapter;
        if (reportCardsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        reportCardsAdapter.update(list);
    }

    public void showError(@Nullable String str) {
        com.aeries.mobileportal.utils.DialogUtils.Companion companion = DialogUtils.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        companion.getErrorDialogBuilder(context, str).setButton((int) C0316R.string.got_it, null).show();
    }
}
