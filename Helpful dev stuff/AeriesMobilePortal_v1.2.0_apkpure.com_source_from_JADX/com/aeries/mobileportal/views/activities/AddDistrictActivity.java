package com.aeries.mobileportal.views.activities;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.AddDistrictActivityComponent;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.add_district.AddDistrictPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.AddDistrictSuccessFragment;
import com.aeries.mobileportal.views.fragments.AddDistrictSuccessFragment.AddDistrictSuccessFragmentListener;
import com.aeries.mobileportal.views.fragments.SchoolSearchFragment;
import com.aeries.mobileportal.views.fragments.SchoolSearchFragment.SchoolSearchFragmentListener;
import com.aeries.mobileportal.views.viewmodels.add_district.AddDistrictViewModel;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u000f\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014¢\u0006\u0002\u0010!J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"H\u0014J\n\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020&H\u0002J\u0010\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020&H\u0016J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u001aH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/aeries/mobileportal/views/activities/AddDistrictActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/add_district/AddDistrictViewModel;", "Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment$SchoolSearchFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AddDistrictSuccessFragment$AddDistrictSuccessFragmentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/AddDistrictActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AddDistrictActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/aeries/mobileportal/presenters/add_district/AddDistrictPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/add_district/AddDistrictPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/add_district/AddDistrictPresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "progressDialog$delegate", "schoolSearchFragment", "Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment;", "selectedSchool", "Lcom/aeries/mobileportal/models/School;", "getSelectedSchool", "()Lcom/aeries/mobileportal/models/School;", "setSelectedSchool", "(Lcom/aeries/mobileportal/models/School;)V", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "goToLogin", "", "goToSuccessScreen", "inject", "onCreate", "onHomePressed", "onSchoolNoUrl", "setupViews", "showError", "errorMessage", "", "showLoginDialog", "showSchoolDetails", "school", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AddDistrictActivity.kt */
public final class AddDistrictActivity extends BaseActivity<AddDistrictViewModel> implements AddDistrictViewModel, SchoolSearchFragmentListener, AddDistrictSuccessFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AddDistrictActivity.class), "progressDialog", "getProgressDialog()Landroid/app/ProgressDialog;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AddDistrictActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AddDistrictActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AddDistrictActivity$component$2(this));
    @Inject
    @NotNull
    public AddDistrictPresenter presenter;
    @NotNull
    private final Lazy progressDialog$delegate = LazyKt.lazy(new AddDistrictActivity$progressDialog$2(this));
    private final SchoolSearchFragment schoolSearchFragment = SchoolSearchFragment.Companion.newInstance(true);
    @NotNull
    public School selectedSchool;

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
    public final AddDistrictActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (AddDistrictActivityComponent) lazy.getValue();
    }

    @NotNull
    public final ProgressDialog getProgressDialog() {
        Lazy lazy = this.progressDialog$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ProgressDialog) lazy.getValue();
    }

    @NotNull
    public final AddDistrictPresenter m94getPresenter() {
        AddDistrictPresenter addDistrictPresenter = this.presenter;
        if (addDistrictPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return addDistrictPresenter;
    }

    public final void setPresenter(@NotNull AddDistrictPresenter addDistrictPresenter) {
        Intrinsics.checkParameterIsNotNull(addDistrictPresenter, "<set-?>");
        this.presenter = addDistrictPresenter;
    }

    @NotNull
    public final School getSelectedSchool() {
        School school = this.selectedSchool;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedSchool");
        }
        return school;
    }

    public final void setSelectedSchool(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "<set-?>");
        this.selectedSchool = school;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_add_district);
    }

    @Nullable
    protected BasePresenter<AddDistrictViewModel> getPresenter() {
        AddDistrictPresenter addDistrictPresenter = this.presenter;
        if (addDistrictPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return addDistrictPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onCreate() {
        setupViews();
    }

    private final void setupViews() {
        getProgressDialog().setMessage(getString(C0316R.string.loading));
        getProgressDialog().setCancelable(false);
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, this.schoolSearchFragment).commit();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "errorMessage");
        getProgressDialog().dismiss();
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, null).show();
    }

    public void showSchoolDetails(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        if (school.getAeriesAppParentURL() != null) {
            this.selectedSchool = school;
            Builder title = new Builder(this).setTitle(C0316R.string.add_school);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(C0316R.string.add_district_confirmation_message);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.add_d…ict_confirmation_message)");
            Object[] objArr = new Object[]{school.getSchoolName()};
            string = String.format(string, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
            title.setMessage(string).setPositiveButton(C0316R.string.yes, new AddDistrictActivity$showSchoolDetails$1(this, school)).setNegativeButton(C0316R.string.no, null).setCancelable(false).create().show();
            return;
        }
        school = getString(C0316R.string.no_base_url);
        Intrinsics.checkExpressionValueIsNotNull(school, "getString(R.string.no_base_url)");
        showError(school);
    }

    public void onSchoolNoUrl() {
        DialogUtils.Companion.getErrorDialogBuilder(this, getString(C0316R.string.district_no_aeriesmp_config)).setButton((int) C0316R.string.got_it, null).show();
    }

    public void showLoginDialog() {
        if (getIntent().getBooleanExtra("LOGIN_ACTIVITY", false)) {
            new Builder(this).setTitle(getString(C0316R.string.school_added)).setMessage(getString(C0316R.string.school_added_message)).setPositiveButton(C0316R.string.got_it, new AddDistrictActivity$showLoginDialog$1(this)).setCancelable(false).create().show();
            return;
        }
        getProgressDialog().dismiss();
        new Builder(this).setTitle(C0316R.string.login).setMessage(getString(C0316R.string.district_added_login_message)).setPositiveButton(C0316R.string.yes, new AddDistrictActivity$showLoginDialog$2(this)).setNegativeButton(C0316R.string.no, new AddDistrictActivity$showLoginDialog$3(this)).setCancelable(false).create().show();
    }

    public void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(872448000);
        startActivity(intent);
    }

    private final void goToSuccessScreen() {
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, AddDistrictSuccessFragment.Companion.newInstance()).commit();
    }

    public void onHomePressed() {
        finish();
    }
}
