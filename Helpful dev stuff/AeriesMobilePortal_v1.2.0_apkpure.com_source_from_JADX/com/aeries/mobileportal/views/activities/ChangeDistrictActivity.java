package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.DistrictsAdapter;
import com.aeries.mobileportal.adapters.DistrictsAdapter.DistrictsListener;
import com.aeries.mobileportal.dagger.components.ChangeDistrictActivityComponent;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.change_district.ChangeDistrictPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.viewmodels.change_district.ChangeDistrictViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000f\u0010,\u001a\u0004\u0018\u00010-H\u0014¢\u0006\u0002\u0010.J\u0010\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010/H\u0014J\n\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000203H\u0016J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000203H\u0016J\b\u0010:\u001a\u000203H\u0016J\u0010\u0010;\u001a\u0002032\u0006\u00107\u001a\u000208H\u0016J\b\u0010<\u001a\u000203H\u0016J\b\u0010=\u001a\u000203H\u0002J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020@H\u0016J\u0016\u0010A\u001a\u0002032\f\u0010B\u001a\b\u0012\u0004\u0012\u0002080CH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006D"}, d2 = {"Lcom/aeries/mobileportal/views/activities/ChangeDistrictActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/change_district/ChangeDistrictViewModel;", "Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictsListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/DistrictsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/DistrictsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/DistrictsAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/ChangeDistrictActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/ChangeDistrictActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "currentDistrict", "Landroid/widget/TextView;", "getCurrentDistrict", "()Landroid/widget/TextView;", "setCurrentDistrict", "(Landroid/widget/TextView;)V", "districtsRV", "Landroid/support/v7/widget/RecyclerView;", "getDistrictsRV", "()Landroid/support/v7/widget/RecyclerView;", "setDistrictsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "noDistrictsMessage", "getNoDistrictsMessage", "setNoDistrictsMessage", "presenter", "Lcom/aeries/mobileportal/presenters/change_district/ChangeDistrictPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/change_district/ChangeDistrictPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/change_district/ChangeDistrictPresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "goToLogin", "", "initSwipe", "inject", "notifyDistrictDeleted", "school", "Lcom/aeries/mobileportal/models/School;", "notifyDistrictDeletedError", "onCreate", "onDistrictSelected", "onDistrictURLEmpty", "setupViews", "showError", "message", "", "updateDistricts", "districts", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangeDistrictActivity.kt */
public final class ChangeDistrictActivity extends BaseActivity<ChangeDistrictViewModel> implements ChangeDistrictViewModel, DistrictsListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ChangeDistrictActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/ChangeDistrictActivityComponent;"))};
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public DistrictsAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new ChangeDistrictActivity$component$2(this));
    @NotNull
    @BindView(2131361904)
    public TextView currentDistrict;
    @NotNull
    @BindView(2131361936)
    public RecyclerView districtsRV;
    @NotNull
    @BindView(2131362064)
    public TextView noDistrictsMessage;
    @Inject
    @NotNull
    public ChangeDistrictPresenter presenter;
    @NotNull
    public ProgressDialog progressDialog;

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
    public final ChangeDistrictActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ChangeDistrictActivityComponent) lazy.getValue();
    }

    @NotNull
    public final RecyclerView getDistrictsRV() {
        RecyclerView recyclerView = this.districtsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtsRV");
        }
        return recyclerView;
    }

    public final void setDistrictsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.districtsRV = recyclerView;
    }

    @NotNull
    public final TextView getCurrentDistrict() {
        TextView textView = this.currentDistrict;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDistrict");
        }
        return textView;
    }

    public final void setCurrentDistrict(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.currentDistrict = textView;
    }

    @NotNull
    public final TextView getNoDistrictsMessage() {
        TextView textView = this.noDistrictsMessage;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noDistrictsMessage");
        }
        return textView;
    }

    public final void setNoDistrictsMessage(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.noDistrictsMessage = textView;
    }

    @NotNull
    public final ProgressDialog getProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        return progressDialog;
    }

    public final void setProgressDialog(@NotNull ProgressDialog progressDialog) {
        Intrinsics.checkParameterIsNotNull(progressDialog, "<set-?>");
        this.progressDialog = progressDialog;
    }

    @NotNull
    public final ChangeDistrictPresenter m97getPresenter() {
        ChangeDistrictPresenter changeDistrictPresenter = this.presenter;
        if (changeDistrictPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return changeDistrictPresenter;
    }

    public final void setPresenter(@NotNull ChangeDistrictPresenter changeDistrictPresenter) {
        Intrinsics.checkParameterIsNotNull(changeDistrictPresenter, "<set-?>");
        this.presenter = changeDistrictPresenter;
    }

    @NotNull
    public final DistrictsAdapter getAdapter() {
        DistrictsAdapter districtsAdapter = this.adapter;
        if (districtsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return districtsAdapter;
    }

    public final void setAdapter(@NotNull DistrictsAdapter districtsAdapter) {
        Intrinsics.checkParameterIsNotNull(districtsAdapter, "<set-?>");
        this.adapter = districtsAdapter;
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void setupViews() {
        Context context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.districtsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtsRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.districtsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtsRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        recyclerView2 = this.districtsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtsRV");
        }
        DistrictsAdapter districtsAdapter = this.adapter;
        if (districtsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(districtsAdapter);
        ChangeDistrictPresenter changeDistrictPresenter = this.presenter;
        if (changeDistrictPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        changeDistrictPresenter.getSchools();
        TextView textView = this.currentDistrict;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDistrict");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(C0316R.string.switch_district_current);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.switch_district_current)");
        Object[] objArr = new Object[1];
        ChangeDistrictPresenter changeDistrictPresenter2 = this.presenter;
        if (changeDistrictPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        objArr[0] = changeDistrictPresenter2.getCurrentDistrict();
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        textView.setText(Html.fromHtml(string));
        this.progressDialog = new ProgressDialog(context);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.setMessage(getString(C0316R.string.loading));
        progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.setCancelable(false);
        initSwipe();
    }

    private final void initSwipe() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ChangeDistrictActivity$initSwipe$itemTouchCallback$1(this, 0, 4));
        RecyclerView recyclerView = this.districtsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtsRV");
        }
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_change_district);
    }

    @Nullable
    protected BasePresenter<ChangeDistrictViewModel> getPresenter() {
        ChangeDistrictPresenter changeDistrictPresenter = this.presenter;
        if (changeDistrictPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return changeDistrictPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void updateDistricts(@NotNull List<? extends School> list) {
        Intrinsics.checkParameterIsNotNull(list, "districts");
        DistrictsAdapter districtsAdapter = this.adapter;
        if (districtsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        districtsAdapter.update(list);
    }

    public void onDistrictSelected(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Builder builder = new Builder(this);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(C0316R.string.switch_district_confirmation_message);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.switc…ict_confirmation_message)");
        Object[] objArr = new Object[]{school.getSchoolName()};
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        builder.setMessage(string).setTitle(C0316R.string.switch_district).setPositiveButton(C0316R.string.yes, new ChangeDistrictActivity$onDistrictSelected$1(this, school)).setNegativeButton(C0316R.string.no, null).create().show();
    }

    public void onDistrictURLEmpty() {
        DialogUtils.Companion.getErrorDialogBuilder(this, getString(C0316R.string.district_no_aeriesmp_config)).setButton((int) C0316R.string.got_it, null).show();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.dismiss();
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, (Function0) new ChangeDistrictActivity$showError$1(this)).show();
    }

    public void goToLogin() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.dismiss();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(872448000);
        startActivity(intent);
    }

    public void notifyDistrictDeleted(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        DistrictsAdapter districtsAdapter = this.adapter;
        if (districtsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        districtsAdapter.getSchools().remove(school);
        school = this.adapter;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        school.notifyDataSetChanged();
        school = this.adapter;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        if (school.getSchools().size() == null) {
            school = this.noDistrictsMessage;
            if (school == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noDistrictsMessage");
            }
            school.setVisibility(0);
        }
    }

    public void notifyDistrictDeletedError() {
        String string = getString(C0316R.string.could_not_delete_district);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.could_not_delete_district)");
        showError(string);
        DistrictsAdapter districtsAdapter = this.adapter;
        if (districtsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        districtsAdapter.notifyDataSetChanged();
    }
}
