package com.aeries.mobileportal.views.activities;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerLoginActivityComponent;
import com.aeries.mobileportal.dagger.components.LoginActivityComponent;
import com.aeries.mobileportal.dagger.modules.LoginPresenterModule;
import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.login.LoginPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.FingerprintDialog;
import com.aeries.mobileportal.views.fragments.FingerprintDialog.FingerprintDialogListener;
import com.aeries.mobileportal.views.viewmodels.login.LoginViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010f\u001a\u00020g2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010h\u001a\u00020\u0014H\u0016J\u0012\u0010i\u001a\u00020g2\b\u0010j\u001a\u0004\u0018\u00010kH\u0016J\u000f\u0010l\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0002\u0010mJ\u0010\u0010n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010oH\u0014J\n\u0010p\u001a\u0004\u0018\u00010qH\u0014J\u0018\u0010r\u001a\u00020g2\u000e\u0010s\u001a\n\u0012\u0004\u0012\u00020u\u0018\u00010tH\u0002J\b\u0010v\u001a\u00020gH\u0016J\"\u0010w\u001a\u00020g2\u0006\u0010x\u001a\u00020\u00062\u0006\u0010y\u001a\u00020\u00062\b\u0010z\u001a\u0004\u0018\u00010{H\u0014J\b\u0010|\u001a\u00020gH\u0016J\b\u0010}\u001a\u00020gH\u0007J\b\u0010~\u001a\u00020gH\u0007J\b\u0010\u001a\u00020gH\u0016J\t\u0010\u0001\u001a\u00020gH\u0007J\t\u0010\u0001\u001a\u00020gH\u0007J\t\u0010\u0001\u001a\u00020gH\u0007J\t\u0010\u0001\u001a\u00020gH\u0014J!\u0010\u0001\u001a\u00020g2\u0016\u0010T\u001a\u0012\u0012\u0004\u0012\u00020V0Uj\b\u0012\u0004\u0012\u00020V`WH\u0016J\u0015\u0010\u0001\u001a\u00020g2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020g2\u0007\u0010\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0001\u001a\u00020gH\u0002J\u0012\u0010\u0001\u001a\u00020g2\u0007\u0010?\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020gH\u0016J\t\u0010\u0001\u001a\u00020gH\u0002J\t\u0010\u0001\u001a\u00020gH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0002078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001e\u0010?\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR\u001e\u0010B\u001a\u00020C8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010N\u001a\u00020O8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR!\u0010T\u001a\u0012\u0012\u0004\u0012\u00020V0Uj\b\u0012\u0004\u0012\u00020V`W¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u001e\u0010Z\u001a\u00020[8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001e\u0010`\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010'\"\u0004\bb\u0010)R\u001e\u0010c\u001a\u00020C8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010E\"\u0004\be\u0010G¨\u0006\u0001"}, d2 = {"Lcom/aeries/mobileportal/views/activities/LoginActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;", "Lcom/aeries/mobileportal/views/fragments/FingerprintDialog$FingerprintDialogListener;", "()V", "RC_SIGN_IN", "", "accountManager", "Landroid/accounts/AccountManager;", "getAccountManager", "()Landroid/accounts/AccountManager;", "accountManager$delegate", "Lkotlin/Lazy;", "componentLogin", "Lcom/aeries/mobileportal/dagger/components/LoginActivityComponent;", "getComponentLogin", "()Lcom/aeries/mobileportal/dagger/components/LoginActivityComponent;", "setComponentLogin", "(Lcom/aeries/mobileportal/dagger/components/LoginActivityComponent;)V", "createAccountDisabled", "", "createAccountText", "Landroid/widget/TextView;", "getCreateAccountText", "()Landroid/widget/TextView;", "setCreateAccountText", "(Landroid/widget/TextView;)V", "forgotPasswordTV", "getForgotPasswordTV", "setForgotPasswordTV", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "setGoogleSignInClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "setImage", "(Landroid/widget/ImageView;)V", "keepSessionSwitch", "Landroid/widget/Switch;", "getKeepSessionSwitch", "()Landroid/widget/Switch;", "setKeepSessionSwitch", "(Landroid/widget/Switch;)V", "loginButton", "Landroid/widget/Button;", "getLoginButton", "()Landroid/widget/Button;", "setLoginButton", "(Landroid/widget/Button;)V", "loginPresenter", "Lcom/aeries/mobileportal/presenters/login/LoginPresenter;", "getLoginPresenter", "()Lcom/aeries/mobileportal/presenters/login/LoginPresenter;", "setLoginPresenter", "(Lcom/aeries/mobileportal/presenters/login/LoginPresenter;)V", "logo", "getLogo", "setLogo", "message", "getMessage", "setMessage", "passwordTV", "Landroid/widget/EditText;", "getPasswordTV", "()Landroid/widget/EditText;", "setPasswordTV", "(Landroid/widget/EditText;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "rootView", "Landroid/support/constraint/ConstraintLayout;", "getRootView", "()Landroid/support/constraint/ConstraintLayout;", "setRootView", "(Landroid/support/constraint/ConstraintLayout;)V", "schools", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/School;", "Lkotlin/collections/ArrayList;", "getSchools", "()Ljava/util/ArrayList;", "schoolsSpinner", "Landroid/widget/Spinner;", "getSchoolsSpinner", "()Landroid/widget/Spinner;", "setSchoolsSpinner", "(Landroid/widget/Spinner;)V", "touchAuthButton", "getTouchAuthButton", "setTouchAuthButton", "usernameTV", "getUsernameTV", "setUsernameTV", "disableAccountViews", "", "changePasswordDisabled", "finishLoginProcess", "authenticationData", "Lcom/aeries/mobileportal/models/AuthenticationData;", "getLayout", "()Ljava/lang/Integer;", "getPresenter", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "handleSignInResult", "task", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "inject", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "onCreateAccountButtonClicked", "onFingerprintAuthSelected", "onFingerprintVerified", "onForgotPasswordClicked", "onGoogleLoginButtonClicked", "onLoginButtonClicked", "onResume", "populateSchoolsSpinner", "populateUserNameField", "lastUserName", "", "setUpperViewsGone", "b", "setupViews", "showError", "showLinkStudent", "showLoadingProgressDialog", "showLoginProgressDialog", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LoginActivity.kt */
public final class LoginActivity extends BaseActivity<LoginViewModel> implements LoginViewModel, FingerprintDialogListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LoginActivity.class), "accountManager", "getAccountManager()Landroid/accounts/AccountManager;"))};
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String FROM_LOGIN = "FROM_LOGIN";
    private final int RC_SIGN_IN = 42;
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy accountManager$delegate = LazyKt.lazy(new LoginActivity$accountManager$2(this));
    @NotNull
    public LoginActivityComponent componentLogin;
    private boolean createAccountDisabled;
    @NotNull
    @BindView(2131361903)
    public TextView createAccountText;
    @NotNull
    @BindView(2131361966)
    public TextView forgotPasswordTV;
    @Inject
    @NotNull
    public GoogleSignInClient googleSignInClient;
    @NotNull
    @BindView(2131362029)
    public ImageView image;
    @NotNull
    @BindView(2131362012)
    public Switch keepSessionSwitch;
    @NotNull
    @BindView(2131362027)
    public Button loginButton;
    @Inject
    @NotNull
    public LoginPresenter loginPresenter;
    @NotNull
    @BindView(2131362032)
    public ImageView logo;
    @NotNull
    @BindView(2131362037)
    public TextView message;
    @NotNull
    @BindView(2131362087)
    public EditText passwordTV;
    @Nullable
    private ProgressDialog progressDialog;
    @NotNull
    @BindView(2131362114)
    public ConstraintLayout rootView;
    @NotNull
    private final ArrayList<School> schools = new ArrayList();
    @NotNull
    @BindView(2131362125)
    public Spinner schoolsSpinner;
    @NotNull
    @BindView(2131361963)
    public ImageView touchAuthButton;
    @NotNull
    @BindView(2131362274)
    public EditText usernameTV;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/views/activities/LoginActivity$Companion;", "", "()V", "FROM_LOGIN", "", "getFROM_LOGIN", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LoginActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getFROM_LOGIN() {
            return LoginActivity.FROM_LOGIN;
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

    @NotNull
    public final AccountManager getAccountManager() {
        Lazy lazy = this.accountManager$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AccountManager) lazy.getValue();
    }

    @NotNull
    public final EditText getUsernameTV() {
        EditText editText = this.usernameTV;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameTV");
        }
        return editText;
    }

    public final void setUsernameTV(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.usernameTV = editText;
    }

    @NotNull
    public final EditText getPasswordTV() {
        EditText editText = this.passwordTV;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordTV");
        }
        return editText;
    }

    public final void setPasswordTV(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.passwordTV = editText;
    }

    @NotNull
    public final Button getLoginButton() {
        Button button = this.loginButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginButton");
        }
        return button;
    }

    public final void setLoginButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.loginButton = button;
    }

    @NotNull
    public final Switch getKeepSessionSwitch() {
        Switch switchR = this.keepSessionSwitch;
        if (switchR == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keepSessionSwitch");
        }
        return switchR;
    }

    public final void setKeepSessionSwitch(@NotNull Switch switchR) {
        Intrinsics.checkParameterIsNotNull(switchR, "<set-?>");
        this.keepSessionSwitch = switchR;
    }

    @NotNull
    public final TextView getCreateAccountText() {
        TextView textView = this.createAccountText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createAccountText");
        }
        return textView;
    }

    public final void setCreateAccountText(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.createAccountText = textView;
    }

    @NotNull
    public final TextView getForgotPasswordTV() {
        TextView textView = this.forgotPasswordTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forgotPasswordTV");
        }
        return textView;
    }

    public final void setForgotPasswordTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.forgotPasswordTV = textView;
    }

    @NotNull
    public final Spinner getSchoolsSpinner() {
        Spinner spinner = this.schoolsSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsSpinner");
        }
        return spinner;
    }

    public final void setSchoolsSpinner(@NotNull Spinner spinner) {
        Intrinsics.checkParameterIsNotNull(spinner, "<set-?>");
        this.schoolsSpinner = spinner;
    }

    @NotNull
    public final ConstraintLayout getRootView() {
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        return constraintLayout;
    }

    public final void setRootView(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.rootView = constraintLayout;
    }

    @NotNull
    public final ImageView getImage() {
        ImageView imageView = this.image;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
        }
        return imageView;
    }

    public final void setImage(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.image = imageView;
    }

    @NotNull
    public final TextView getMessage() {
        TextView textView = this.message;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        }
        return textView;
    }

    public final void setMessage(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.message = textView;
    }

    @NotNull
    public final ImageView getLogo() {
        ImageView imageView = this.logo;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logo");
        }
        return imageView;
    }

    public final void setLogo(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.logo = imageView;
    }

    @NotNull
    public final ImageView getTouchAuthButton() {
        ImageView imageView = this.touchAuthButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("touchAuthButton");
        }
        return imageView;
    }

    public final void setTouchAuthButton(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.touchAuthButton = imageView;
    }

    @NotNull
    public final LoginPresenter getLoginPresenter() {
        LoginPresenter loginPresenter = this.loginPresenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
        }
        return loginPresenter;
    }

    public final void setLoginPresenter(@NotNull LoginPresenter loginPresenter) {
        Intrinsics.checkParameterIsNotNull(loginPresenter, "<set-?>");
        this.loginPresenter = loginPresenter;
    }

    @NotNull
    public final GoogleSignInClient getGoogleSignInClient() {
        GoogleSignInClient googleSignInClient = this.googleSignInClient;
        if (googleSignInClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleSignInClient");
        }
        return googleSignInClient;
    }

    public final void setGoogleSignInClient(@NotNull GoogleSignInClient googleSignInClient) {
        Intrinsics.checkParameterIsNotNull(googleSignInClient, "<set-?>");
        this.googleSignInClient = googleSignInClient;
    }

    @Nullable
    public final ProgressDialog getProgressDialog() {
        return this.progressDialog;
    }

    public final void setProgressDialog(@Nullable ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_login);
    }

    @Nullable
    protected BasePresenter<LoginViewModel> getPresenter() {
        LoginPresenter loginPresenter = this.loginPresenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
        }
        return loginPresenter;
    }

    public void inject() {
        LoginActivityComponent build = DaggerLoginActivityComponent.builder().pSPComponent(PSPApplication.Companion.get((Activity) this)).loginPresenterModule(new LoginPresenterModule(this)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "DaggerLoginActivityCompo…\n                .build()");
        this.componentLogin = build;
        build = this.componentLogin;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentLogin");
        }
        build.inject(this);
    }

    @NotNull
    public final LoginActivityComponent getComponentLogin() {
        LoginActivityComponent loginActivityComponent = this.componentLogin;
        if (loginActivityComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentLogin");
        }
        return loginActivityComponent;
    }

    public final void setComponentLogin(@NotNull LoginActivityComponent loginActivityComponent) {
        Intrinsics.checkParameterIsNotNull(loginActivityComponent, "<set-?>");
        this.componentLogin = loginActivityComponent;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    @OnClick({2131362027})
    public final void onLoginButtonClicked() {
        showLoginProgressDialog();
        LoginPresenter loginPresenter = this.loginPresenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
        }
        EditText editText = this.usernameTV;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameTV");
        }
        String obj = editText.getText().toString();
        EditText editText2 = this.passwordTV;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordTV");
        }
        String obj2 = editText2.getText().toString();
        ArrayList arrayList = this.schools;
        Spinner spinner = this.schoolsSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsSpinner");
        }
        Object obj3 = arrayList.get(spinner.getSelectedItemPosition());
        Intrinsics.checkExpressionValueIsNotNull(obj3, "schools[schoolsSpinner.selectedItemPosition]");
        School school = (School) obj3;
        Switch switchR = this.keepSessionSwitch;
        if (switchR == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keepSessionSwitch");
        }
        loginPresenter.login(obj, obj2, school, switchR.isChecked());
    }

    @OnClick({2131361973})
    public final void onGoogleLoginButtonClicked() {
        GoogleSignInClient googleSignInClient = this.googleSignInClient;
        if (googleSignInClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleSignInClient");
        }
        startActivityForResult(googleSignInClient.getSignInIntent(), this.RC_SIGN_IN);
    }

    @OnClick({2131361903})
    public final void onCreateAccountButtonClicked() {
        if (this.createAccountDisabled) {
            DialogUtils.Companion.getErrorDialogBuilder(this, getString(C0316R.string.school_disabled_option)).setButton((int) C0316R.string.got_it, null).show();
        } else {
            startActivity(new Intent(this, CreateAccountActivity.class));
        }
    }

    @OnClick({2131361966})
    public final void onForgotPasswordClicked() {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }

    @OnClick({2131361963})
    public final void onFingerprintAuthSelected() {
        if (FingerprintManagerCompat.from(this).hasEnrolledFingerprints()) {
            FingerprintDialog.Companion.newInstance().show(getSupportFragmentManager(), null);
            return;
        }
        ImageView imageView = this.touchAuthButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("touchAuthButton");
        }
        Snackbar.make((View) imageView, (int) C0316R.string.go_to_fingerprint_settings, 0).setAction((int) C0316R.string.go, (OnClickListener) new LoginActivity$onFingerprintAuthSelected$1(this)).show();
    }

    protected void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.RC_SIGN_IN) {
            handleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(intent));
        }
    }

    private final void handleSignInResult(Task<GoogleSignInAccount> task) {
        String idToken;
        LoginPresenter loginPresenter;
        ArrayList arrayList;
        Spinner spinner;
        Object obj;
        School school;
        Switch switchR;
        if (task != null) {
            try {
                task = (GoogleSignInAccount) task.getResult(ApiException.class);
            } catch (Task<GoogleSignInAccount> task2) {
                Toast.makeText(this, C0316R.string.update_google_services, 1).show();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("signInResult: failed code=");
                stringBuilder.append(task2.getStatusCode());
                Log.w("Google SignIn", stringBuilder.toString());
                return;
            }
        }
        task2 = null;
        String str = "Google Token";
        if (task2 != null) {
            idToken = task2.getIdToken();
            if (idToken != null) {
                Log.d(str, idToken);
                loginPresenter = this.loginPresenter;
                if (loginPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
                }
                arrayList = this.schools;
                spinner = this.schoolsSpinner;
                if (spinner == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("schoolsSpinner");
                }
                obj = arrayList.get(spinner.getSelectedItemPosition());
                Intrinsics.checkExpressionValueIsNotNull(obj, "schools[schoolsSpinner.selectedItemPosition]");
                school = (School) obj;
                switchR = this.keepSessionSwitch;
                if (switchR == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("keepSessionSwitch");
                }
                loginPresenter.googleSignIn(task2, school, switchR.isChecked());
            }
        }
        idToken = "";
        Log.d(str, idToken);
        loginPresenter = this.loginPresenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
        }
        arrayList = this.schools;
        spinner = this.schoolsSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsSpinner");
        }
        obj = arrayList.get(spinner.getSelectedItemPosition());
        Intrinsics.checkExpressionValueIsNotNull(obj, "schools[schoolsSpinner.selectedItemPosition]");
        school = (School) obj;
        switchR = this.keepSessionSwitch;
        if (switchR == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keepSessionSwitch");
        }
        loginPresenter.googleSignIn(task2, school, switchR.isChecked());
    }

    public void disableAccountViews(boolean z, boolean z2) {
        int i = 0;
        z = z ? true : false;
        if (z2) {
            i = 8;
        }
        z2 = this.createAccountText;
        if (!z2) {
            Intrinsics.throwUninitializedPropertyAccessException("createAccountText");
        }
        z2.setVisibility(z);
        z = this.forgotPasswordTV;
        if (!z) {
            Intrinsics.throwUninitializedPropertyAccessException("forgotPasswordTV");
        }
        z.setVisibility(i);
        z = PSPApplication.Companion.get((Activity) this);
        z2 = getApplication();
        if (z2) {
            z.inject((PSPApplication) z2);
            inject();
            z = this.progressDialog;
            if (z) {
                z.dismiss();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.PSPApplication");
    }

    private final void showLoginProgressDialog() {
        this.progressDialog = new ProgressDialog(this);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setCancelable(false);
        }
        progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setMessage(getString(C0316R.string.logging_in));
        }
        progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    private final void showLoadingProgressDialog() {
        this.progressDialog = new ProgressDialog(this);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setCancelable(false);
        }
        progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setMessage(getString(C0316R.string.loading));
        }
        progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    public void finishLoginProcess(@Nullable AuthenticationData authenticationData) {
        authenticationData = this.loginPresenter;
        if (authenticationData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
        }
        EditText editText = this.usernameTV;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameTV");
        }
        authenticationData.setLastUserName(editText.getText().toString());
        authenticationData = this.progressDialog;
        if (authenticationData != null) {
            authenticationData.dismiss();
        }
        getResources().getBoolean(C0316R.bool.isTablet);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void showLinkStudent() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Intent intent = new Intent(this, LinkStudentActivity.class);
        intent.putExtra(FROM_LOGIN, true);
        startActivity(intent);
        finish();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        CharSequence charSequence = str;
        if (StringsKt.contains$default(charSequence, "HTTP 403", false, 2, null)) {
            str = StringsKt.removePrefix(str, "HTTP 403 ");
        } else if (StringsKt.contains$default(charSequence, "404", false, 2, null)) {
            str = getString(C0316R.string.district_not_on_minimum_error_msg);
        }
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, null).show();
        Log.e("Error", str);
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    protected void onResume() {
        super.onResume();
        LoginPresenter loginPresenter = this.loginPresenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
        }
        loginPresenter.getSchoolsForSpinner();
    }

    private final void setupViews() {
        boolean z;
        EditText editText = this.passwordTV;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordTV");
        }
        editText.setOnEditorActionListener(new LoginActivity$setupViews$1(this));
        LoginPresenter loginPresenter = this.loginPresenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
        }
        loginPresenter.getSchoolsForSpinner();
        loginPresenter = this.loginPresenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPresenter");
        }
        loginPresenter.getLastUserName();
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        constraintLayout.getViewTreeObserver().addOnGlobalLayoutListener(new LoginActivity$setupViews$2(this));
        editText = this.passwordTV;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordTV");
        }
        editText.addTextChangedListener(new LoginActivity$setupViews$3(this));
        editText = this.usernameTV;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameTV");
        }
        editText.addTextChangedListener(new LoginActivity$setupViews$4(this));
        Button button = this.loginButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginButton");
        }
        EditText editText2 = this.passwordTV;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordTV");
        }
        CharSequence text = editText2.getText();
        boolean z2 = false;
        if (text != null) {
            if (text.length() != 0) {
                z = false;
                if (!z) {
                    editText2 = this.usernameTV;
                    if (editText2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("usernameTV");
                    }
                    text = editText2.getText();
                    if (text != null) {
                        if (text.length() == 0) {
                            z = false;
                            if (!z) {
                                z2 = true;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        z2 = true;
                    }
                }
                button.setEnabled(z2);
            }
        }
        z = true;
        if (z) {
            editText2 = this.usernameTV;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("usernameTV");
            }
            text = editText2.getText();
            if (text != null) {
                if (text.length() == 0) {
                    z = false;
                    if (z) {
                        z2 = true;
                    }
                }
            }
            z = true;
            if (z) {
                z2 = true;
            }
        }
        button.setEnabled(z2);
    }

    private final void setUpperViewsGone(boolean z) {
        z = z ? true : false;
        ImageView imageView = this.image;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
        }
        imageView.setVisibility(z);
    }

    public void populateUserNameField(@Nullable String str) {
        EditText editText = this.usernameTV;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameTV");
        }
        editText.setText(str, BufferType.EDITABLE);
    }

    @NotNull
    public final ArrayList<School> getSchools() {
        return this.schools;
    }

    public void populateSchoolsSpinner(@NotNull ArrayList<School> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "schools");
        this.schools.clear();
        this.schools.addAll(arrayList);
        Context context = this;
        Iterable<School> iterable = arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (School schoolName : iterable) {
            arrayList2.add(schoolName.getSchoolName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, CollectionsKt.plus((List) arrayList2, getString(C0316R.string.add_new_district)));
        arrayAdapter.setDropDownViewResource(17367049);
        int i = 0;
        for (School selected : arrayList) {
            if (selected.getSelected()) {
                break;
            }
            i++;
        }
        i = -1;
        Spinner spinner = this.schoolsSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsSpinner");
        }
        spinner.setAdapter(arrayAdapter);
        Spinner spinner2 = this.schoolsSpinner;
        if (spinner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsSpinner");
        }
        spinner2.setOnItemSelectedListener(new LoginActivity$populateSchoolsSpinner$1(this, arrayList));
        if (i > 0) {
            arrayList = this.schoolsSpinner;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolsSpinner");
            }
            arrayList.setSelection(i);
        }
    }

    public void onFingerprintVerified() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An operation is not implemented: ");
        stringBuilder.append("not implemented");
        throw new NotImplementedError(stringBuilder.toString());
    }
}
