package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.LoginActivityComponent;
import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.User;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.login.LoginPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.PSPAccountAuthenticatorActivity;
import com.aeries.mobileportal.views.viewmodels.login.LoginViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001hB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010@\u001a\u00020AH\u0002J\u0018\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0016J\u0012\u0010F\u001a\u00020A2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u000f\u0010I\u001a\u0004\u0018\u00010JH\u0014¢\u0006\u0002\u0010KJ\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010LH\u0014J\n\u0010M\u001a\u0004\u0018\u00010NH\u0014J\b\u0010O\u001a\u00020AH\u0016J\u0010\u0010P\u001a\u00020D2\u0006\u0010\u0013\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020D2\u0006\u0010%\u001a\u00020QH\u0002J\b\u0010S\u001a\u00020AH\u0016J+\u0010T\u001a\u00020A2\u0006\u0010U\u001a\u00020J2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020Q0W2\u0006\u0010X\u001a\u00020YH\u0016¢\u0006\u0002\u0010ZJ \u0010[\u001a\u00020A2\u0016\u0010\\\u001a\u0012\u0012\u0004\u0012\u0002050]j\b\u0012\u0004\u0012\u000205`^H\u0016J\u0012\u0010_\u001a\u00020A2\b\u0010`\u001a\u0004\u0018\u00010QH\u0016J\b\u0010a\u001a\u00020AH\u0002J\u0010\u0010b\u001a\u00020A2\u0006\u0010c\u001a\u00020QH\u0016J\b\u0010d\u001a\u00020AH\u0016J\u0010\u0010e\u001a\u00020A2\u0006\u0010f\u001a\u00020DH\u0002J\f\u0010g\u001a\u00020J*\u00020JH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\r\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006i"}, d2 = {"Lcom/aeries/mobileportal/views/activities/AuthenticationActivity;", "Lcom/aeries/mobileportal/views/PSPAccountAuthenticatorActivity;", "Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;", "()V", "aeriesBG", "Landroid/widget/ImageView;", "getAeriesBG", "()Landroid/widget/ImageView;", "setAeriesBG", "(Landroid/widget/ImageView;)V", "aeriesLogo", "getAeriesLogo", "setAeriesLogo", "component", "Lcom/aeries/mobileportal/dagger/components/LoginActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/LoginActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "email", "Landroid/widget/EditText;", "getEmail", "()Landroid/widget/EditText;", "setEmail", "(Landroid/widget/EditText;)V", "loginForm", "Landroid/view/View;", "getLoginForm", "()Landroid/view/View;", "setLoginForm", "(Landroid/view/View;)V", "loginProgress", "Landroid/widget/ProgressBar;", "getLoginProgress", "()Landroid/widget/ProgressBar;", "setLoginProgress", "(Landroid/widget/ProgressBar;)V", "password", "getPassword", "setPassword", "presenter", "Lcom/aeries/mobileportal/presenters/login/LoginPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/login/LoginPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/login/LoginPresenter;)V", "schoolSpinner", "Landroid/widget/Spinner;", "getSchoolSpinner", "()Landroid/widget/Spinner;", "setSchoolSpinner", "(Landroid/widget/Spinner;)V", "selectedSchool", "Lcom/aeries/mobileportal/models/School;", "getSelectedSchool", "()Lcom/aeries/mobileportal/models/School;", "setSelectedSchool", "(Lcom/aeries/mobileportal/models/School;)V", "signInButton", "Landroid/widget/Button;", "getSignInButton", "()Landroid/widget/Button;", "setSignInButton", "(Landroid/widget/Button;)V", "attemptLogin", "", "disableAccountViews", "createAccountDisabled", "", "changePasswordDisabled", "finishLoginProcess", "authenticationData", "Lcom/aeries/mobileportal/models/AuthenticationData;", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "isEmailValid", "", "isPasswordValid", "onCreate", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "populateSchoolsSpinner", "schools", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "populateUserNameField", "lastUserName", "setupViews", "showError", "message", "showLinkStudent", "showProgress", "show", "dipToPx", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AuthenticationActivity.kt */
public final class AuthenticationActivity extends PSPAccountAuthenticatorActivity<LoginViewModel> implements LoginViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AuthenticationActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/LoginActivityComponent;"))};
    @NotNull
    private static final String ACCOUNT_TYPE = "com.aeries";
    @NotNull
    private static final String ADDING_NEW_ACC = "ADDING_NEW_ACCOUNT";
    @NotNull
    private static final String AUTH_TYPE = "ACC_TYPE";
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String DISTRICT_URL = "DISTRICT_URL";
    @NotNull
    private static final String PARAM_USER_PASS = "PARAM_USER_PASS";
    @NotNull
    private static final String REFRESH_TOKEN = "REFRESH_TOKEN";
    @NotNull
    private static final String SCHOOL_CDS = "SCHOOL_CDS";
    @NotNull
    private static final String SCHOOL_NAME = "SCHOOL_NAME";
    @NotNull
    private static final String USERNAME = "USERNAME";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361829)
    public ImageView aeriesBG;
    @NotNull
    @BindView(2131361830)
    public ImageView aeriesLogo;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AuthenticationActivity$component$2(this));
    @NotNull
    @BindView(2131361945)
    public EditText email;
    @NotNull
    @BindView(2131362028)
    public View loginForm;
    @NotNull
    @BindView(2131362031)
    public ProgressBar loginProgress;
    @NotNull
    @BindView(2131362087)
    public EditText password;
    @Inject
    @NotNull
    public LoginPresenter presenter;
    @NotNull
    @BindView(2131362123)
    public Spinner schoolSpinner;
    @Nullable
    private School selectedSchool;
    @NotNull
    @BindView(2131361946)
    public Button signInButton;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/aeries/mobileportal/views/activities/AuthenticationActivity$Companion;", "", "()V", "ACCOUNT_TYPE", "", "getACCOUNT_TYPE", "()Ljava/lang/String;", "ADDING_NEW_ACC", "getADDING_NEW_ACC", "AUTH_TYPE", "getAUTH_TYPE", "DISTRICT_URL", "getDISTRICT_URL", "PARAM_USER_PASS", "getPARAM_USER_PASS", "REFRESH_TOKEN", "getREFRESH_TOKEN", "SCHOOL_CDS", "getSCHOOL_CDS", "SCHOOL_NAME", "getSCHOOL_NAME", "USERNAME", "getUSERNAME", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AuthenticationActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getACCOUNT_TYPE() {
            return AuthenticationActivity.ACCOUNT_TYPE;
        }

        @NotNull
        public final String getAUTH_TYPE() {
            return AuthenticationActivity.AUTH_TYPE;
        }

        @NotNull
        public final String getADDING_NEW_ACC() {
            return AuthenticationActivity.ADDING_NEW_ACC;
        }

        @NotNull
        public final String getPARAM_USER_PASS() {
            return AuthenticationActivity.PARAM_USER_PASS;
        }

        @NotNull
        public final String getDISTRICT_URL() {
            return AuthenticationActivity.DISTRICT_URL;
        }

        @NotNull
        public final String getSCHOOL_NAME() {
            return AuthenticationActivity.SCHOOL_NAME;
        }

        @NotNull
        public final String getSCHOOL_CDS() {
            return AuthenticationActivity.SCHOOL_CDS;
        }

        @NotNull
        public final String getUSERNAME() {
            return AuthenticationActivity.USERNAME;
        }

        @NotNull
        public final String getREFRESH_TOKEN() {
            return AuthenticationActivity.REFRESH_TOKEN;
        }
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
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public void disableAccountViews(boolean z, boolean z2) {
    }

    @NotNull
    public final LoginActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (LoginActivityComponent) lazy.getValue();
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
    }

    public void populateUserNameField(@Nullable String str) {
    }

    public void showLinkStudent() {
    }

    @NotNull
    public final View getLoginForm() {
        View view = this.loginForm;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginForm");
        }
        return view;
    }

    public final void setLoginForm(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.loginForm = view;
    }

    @NotNull
    public final Button getSignInButton() {
        Button button = this.signInButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInButton");
        }
        return button;
    }

    public final void setSignInButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.signInButton = button;
    }

    @NotNull
    public final EditText getEmail() {
        EditText editText = this.email;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
        }
        return editText;
    }

    public final void setEmail(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.email = editText;
    }

    @NotNull
    public final EditText getPassword() {
        EditText editText = this.password;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("password");
        }
        return editText;
    }

    public final void setPassword(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.password = editText;
    }

    @NotNull
    public final ProgressBar getLoginProgress() {
        ProgressBar progressBar = this.loginProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginProgress");
        }
        return progressBar;
    }

    public final void setLoginProgress(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.loginProgress = progressBar;
    }

    @NotNull
    public final Spinner getSchoolSpinner() {
        Spinner spinner = this.schoolSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolSpinner");
        }
        return spinner;
    }

    public final void setSchoolSpinner(@NotNull Spinner spinner) {
        Intrinsics.checkParameterIsNotNull(spinner, "<set-?>");
        this.schoolSpinner = spinner;
    }

    @NotNull
    public final ImageView getAeriesLogo() {
        ImageView imageView = this.aeriesLogo;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aeriesLogo");
        }
        return imageView;
    }

    public final void setAeriesLogo(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.aeriesLogo = imageView;
    }

    @NotNull
    public final ImageView getAeriesBG() {
        ImageView imageView = this.aeriesBG;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aeriesBG");
        }
        return imageView;
    }

    public final void setAeriesBG(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.aeriesBG = imageView;
    }

    @NotNull
    public final LoginPresenter m90getPresenter() {
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return loginPresenter;
    }

    public final void setPresenter(@NotNull LoginPresenter loginPresenter) {
        Intrinsics.checkParameterIsNotNull(loginPresenter, "<set-?>");
        this.presenter = loginPresenter;
    }

    @Nullable
    public final School getSelectedSchool() {
        return this.selectedSchool;
    }

    public final void setSelectedSchool(@Nullable School school) {
        this.selectedSchool = school;
    }

    private final void attemptLogin() {
        boolean z;
        boolean z2 = true;
        showProgress(true);
        EditText editText = this.email;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
        }
        CharSequence charSequence = (CharSequence) null;
        editText.setError(charSequence);
        editText = r0.password;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("password");
        }
        editText.setError(charSequence);
        editText = r0.email;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
        }
        String obj = editText.getText().toString();
        editText = r0.password;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("password");
        }
        String obj2 = editText.getText().toString();
        View view = (View) null;
        if (TextUtils.isEmpty(obj2) || isPasswordValid(obj2)) {
            z = false;
        } else {
            editText = r0.password;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("password");
            }
            editText.setError(getString(C0316R.string.error_invalid_password));
            editText = r0.password;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("password");
            }
            view = editText;
            z = true;
        }
        if (TextUtils.isEmpty(obj)) {
            editText = r0.email;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("email");
            }
            editText.setError(getString(C0316R.string.error_field_required));
            editText = r0.email;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("email");
            }
            view = editText;
        } else if (isEmailValid(obj)) {
            Spinner spinner = r0.schoolSpinner;
            if (spinner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolSpinner");
            }
            if (Intrinsics.areEqual(spinner.getSelectedItem(), Integer.valueOf(0))) {
                Toast.makeText(r0, C0316R.string.select_school_error, 1).show();
                editText = r0.email;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("email");
                }
                view = editText;
            } else {
                z2 = z;
            }
        } else {
            editText = r0.email;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("email");
            }
            editText.setError(getString(C0316R.string.error_invalid_email));
            editText = r0.email;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("email");
            }
            view = editText;
        }
        if (z2) {
            showProgress(false);
            if (view != null) {
                view.requestFocus();
                return;
            }
            return;
        }
        LoginPresenter loginPresenter = r0.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        User user = new User(obj, obj2, null, null, null, null, null, null, null, null, false, 2044, null);
        School school = r0.selectedSchool;
        if (school == null) {
            school = new School();
        }
        user.setSchool(school);
        loginPresenter.getAuthToken(user);
    }

    private final boolean isEmailValid(String str) {
        return StringsKt.contains$default(str, "@", false, 2, null);
    }

    private final boolean isPasswordValid(String str) {
        return str.length() >= 4 ? true : null;
    }

    private final void showProgress(boolean z) {
        long integer = (long) getResources().getInteger(17694720);
        View view = this.loginForm;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginForm");
        }
        int i = 0;
        view.setVisibility(z ? 8 : 0);
        view = this.loginForm;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginForm");
        }
        view.animate().setDuration(integer).alpha((float) (z ^ 1)).setListener(new AuthenticationActivity$showProgress$1(this, z));
        ProgressBar progressBar = this.loginProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginProgress");
        }
        if (!z) {
            i = 8;
        }
        progressBar.setVisibility(i);
        progressBar = this.loginProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginProgress");
        }
        progressBar.animate().setDuration(integer).alpha((float) z).setListener(new AuthenticationActivity$showProgress$2(this, z));
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_authentication);
    }

    @Nullable
    protected BasePresenter<LoginViewModel> getPresenter() {
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return loginPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void setupViews() {
        EditText editText = this.password;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("password");
        }
        editText.setOnEditorActionListener(new AuthenticationActivity$setupViews$1(this));
        Button button = this.signInButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInButton");
        }
        button.setOnClickListener(new AuthenticationActivity$setupViews$2(this));
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginPresenter.getSchoolsForSpinner();
    }

    public void finishLoginProcess(@Nullable AuthenticationData authenticationData) {
        String str = null;
        authenticationData = authenticationData != null ? authenticationData.getAccessToken() : null;
        Intent intent = new Intent();
        String str2 = "authAccount";
        StringBuilder stringBuilder = new StringBuilder();
        EditText editText = this.email;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
        }
        stringBuilder.append((String) CollectionsKt.first(StringsKt.split$default(editText.getText().toString(), new String[]{"@"}, false, 0, 6, null)));
        stringBuilder.append(" | ");
        School school = this.selectedSchool;
        if (school != null) {
            str = school.getSchoolName();
        }
        stringBuilder.append(str);
        intent.putExtra(str2, stringBuilder.toString());
        intent.putExtra("accountType", getString(C0316R.string.account_type));
        intent.putExtra("authtoken", authenticationData);
        authenticationData = PARAM_USER_PASS;
        EditText editText2 = this.password;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("password");
        }
        intent.putExtra(authenticationData, editText2.getText().toString());
        setAccountAuthenticatorResult(intent.getExtras());
        setResult(-1, intent);
        finish();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        showProgress(false);
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, null).show();
    }

    public void populateSchoolsSpinner(@NotNull ArrayList<School> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "schools");
        School school = new School();
        school.setSchoolName(getString(C0316R.string.select_district));
        arrayList.add(0, school);
        school = new School();
        school.setSchoolName(getString(C0316R.string.add_new_district));
        arrayList.add(school);
        Context context = this;
        Iterable<School> iterable = arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (School schoolName : iterable) {
            arrayList2.add(schoolName.getSchoolName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367049, (List) arrayList2);
        Spinner spinner = this.schoolSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolSpinner");
        }
        spinner.setAdapter(arrayAdapter);
        Spinner spinner2 = this.schoolSpinner;
        if (spinner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolSpinner");
        }
        spinner2.setOnItemSelectedListener(new AuthenticationActivity$populateSchoolsSpinner$3(this, arrayList));
    }

    private final int dipToPx(int i) {
        i = (float) i;
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }
}
