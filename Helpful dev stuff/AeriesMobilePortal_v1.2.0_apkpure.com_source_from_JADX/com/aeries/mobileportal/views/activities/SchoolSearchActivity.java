package com.aeries.mobileportal.views.activities;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.SchoolSearchActivityComponent;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.school.select.SchoolSearchPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.SchoolDetailsFragment;
import com.aeries.mobileportal.views.fragments.SchoolDetailsFragment.OnSchoolDetailsInteractionListener;
import com.aeries.mobileportal.views.fragments.SchoolSearchFragment;
import com.aeries.mobileportal.views.fragments.SchoolSearchFragment.SchoolSearchFragmentListener;
import com.aeries.mobileportal.views.fragments.SchoolSelectMessageFragment;
import com.aeries.mobileportal.views.fragments.SchoolSelectMessageFragment.OnSchoolMessageInteractionListener;
import com.aeries.mobileportal.views.viewmodels.school_select.SchoolSearchViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000f\u0010(\u001a\u0004\u0018\u00010)H\u0014¢\u0006\u0002\u0010*J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+H\u0014J\n\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020'H\u0016J\b\u0010/\u001a\u00020'H\u0016J\b\u00100\u001a\u00020'H\u0016J\b\u00101\u001a\u00020'H\u0016J\b\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020'H\u0016J\b\u00104\u001a\u00020'H\u0016J\b\u00105\u001a\u00020'H\u0002J\u0010\u00106\u001a\u00020'2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006:"}, d2 = {"Lcom/aeries/mobileportal/views/activities/SchoolSearchActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/school_select/SchoolSearchViewModel;", "Lcom/aeries/mobileportal/views/fragments/SchoolSelectMessageFragment$OnSchoolMessageInteractionListener;", "Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment$SchoolSearchFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/SchoolDetailsFragment$OnSchoolDetailsInteractionListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/SchoolSearchActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/SchoolSearchActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "messageFragment", "Lcom/aeries/mobileportal/views/fragments/SchoolSelectMessageFragment;", "getMessageFragment", "()Lcom/aeries/mobileportal/views/fragments/SchoolSelectMessageFragment;", "presenter", "Lcom/aeries/mobileportal/presenters/school/select/SchoolSearchPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/school/select/SchoolSearchPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/school/select/SchoolSearchPresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "progressDialog$delegate", "school", "Lcom/aeries/mobileportal/models/School;", "getSchool", "()Lcom/aeries/mobileportal/models/School;", "setSchool", "(Lcom/aeries/mobileportal/models/School;)V", "searchFragment", "Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment;", "getSearchFragment", "()Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment;", "checkSchoolAppStatus", "", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "goToLogin", "inject", "onCreate", "onGetStartedPressed", "onSchoolNoUrl", "requestPermissions", "selectSchool", "setUpProgressDialog", "showError", "message", "", "showSchoolDetails", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchActivity.kt */
public final class SchoolSearchActivity extends BaseActivity<SchoolSearchViewModel> implements SchoolSearchViewModel, OnSchoolMessageInteractionListener, SchoolSearchFragmentListener, OnSchoolDetailsInteractionListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SchoolSearchActivity.class), "progressDialog", "getProgressDialog()Landroid/app/ProgressDialog;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SchoolSearchActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/SchoolSearchActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new SchoolSearchActivity$component$2(this));
    @NotNull
    private final SchoolSelectMessageFragment messageFragment = SchoolSelectMessageFragment.Companion.newInstance();
    @Inject
    @NotNull
    public SchoolSearchPresenter presenter;
    @NotNull
    private final Lazy progressDialog$delegate = LazyKt.lazy(new SchoolSearchActivity$progressDialog$2(this));
    @NotNull
    public School school;
    @NotNull
    private final SchoolSearchFragment searchFragment = SchoolSearchFragment.Companion.newInstance(false);

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
    public final SchoolSearchActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (SchoolSearchActivityComponent) lazy.getValue();
    }

    @NotNull
    public final ProgressDialog getProgressDialog() {
        Lazy lazy = this.progressDialog$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ProgressDialog) lazy.getValue();
    }

    @NotNull
    public final SchoolSearchPresenter m107getPresenter() {
        SchoolSearchPresenter schoolSearchPresenter = this.presenter;
        if (schoolSearchPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return schoolSearchPresenter;
    }

    public final void setPresenter(@NotNull SchoolSearchPresenter schoolSearchPresenter) {
        Intrinsics.checkParameterIsNotNull(schoolSearchPresenter, "<set-?>");
        this.presenter = schoolSearchPresenter;
    }

    @NotNull
    public final School getSchool() {
        School school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException("school");
        }
        return school;
    }

    public final void setSchool(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "<set-?>");
        this.school = school;
    }

    @NotNull
    public final SchoolSelectMessageFragment getMessageFragment() {
        return this.messageFragment;
    }

    @NotNull
    public final SchoolSearchFragment getSearchFragment() {
        return this.searchFragment;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_school_search);
    }

    @Nullable
    protected BasePresenter<SchoolSearchViewModel> getPresenter() {
        SchoolSearchPresenter schoolSearchPresenter = this.presenter;
        if (schoolSearchPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return schoolSearchPresenter;
    }

    public void inject() {
        getComponent().inject(this);
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void onGetStartedPressed() {
        getProgressDialog().dismiss();
        getSupportFragmentManager().beginTransaction().setCustomAnimations(17432578, 17432579).replace(C0316R.id.fragment_container, this.searchFragment).addToBackStack(null).commit();
    }

    public void showSchoolDetails(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_left, C0316R.anim.fade_out, C0316R.anim.slide_in_right, C0316R.anim.fade_out).replace(C0316R.id.fragment_container, SchoolDetailsFragment.Companion.newInstance(school)).addToBackStack(null).commit();
    }

    public void onSchoolNoUrl() {
        DialogUtils.Companion.getErrorDialogBuilder(this, getString(C0316R.string.district_no_aeriesmp_config)).setButton((int) C0316R.string.got_it, null).show();
    }

    public void checkSchoolAppStatus(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        new Builder(this).setMessage(C0316R.string.select_school_confirmation_message).setTitle(school.getSchoolName()).setPositiveButton(C0316R.string.yes, new SchoolSearchActivity$checkSchoolAppStatus$1(this, school)).setNegativeButton(C0316R.string.cancel, null).create().show();
    }

    private final void setUpProgressDialog() {
        getProgressDialog().setMessage(getString(C0316R.string.searching));
        getProgressDialog().setCancelable(false);
    }

    public void onCreate() {
        setUpProgressDialog();
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, this.messageFragment).commit();
    }

    public void requestPermissions() {
        SchoolSearchPresenter schoolSearchPresenter = this.presenter;
        if (schoolSearchPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        School school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException("school");
        }
        schoolSearchPresenter.requestPermissions(school);
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        getProgressDialog().dismiss();
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, null).show();
    }

    public void selectSchool() {
        SchoolSearchPresenter schoolSearchPresenter = this.presenter;
        if (schoolSearchPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        School school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException("school");
        }
        schoolSearchPresenter.selectSchool(school);
    }

    public void goToLogin() {
        getProgressDialog().dismiss();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(67141632);
        startActivity(intent);
        finish();
    }
}
