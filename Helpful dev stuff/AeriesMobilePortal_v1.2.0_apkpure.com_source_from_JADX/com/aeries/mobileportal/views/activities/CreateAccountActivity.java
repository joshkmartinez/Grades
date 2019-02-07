package com.aeries.mobileportal.views.activities;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.StepsListener;
import com.aeries.mobileportal.dagger.components.CreateAccountComponent;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.ConfirmAccountRequest;
import com.aeries.mobileportal.models.CreateAccountRequest;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.create_account.CreateAccountPresenter;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.DoneAccountFragment;
import com.aeries.mobileportal.views.fragments.DoneAccountFragment.DoneAccountFragmentListener;
import com.aeries.mobileportal.views.fragments.EnterEmailFragment;
import com.aeries.mobileportal.views.fragments.EnterEmailFragment.EnterEmailFragmentListener;
import com.aeries.mobileportal.views.fragments.PasswordFragment;
import com.aeries.mobileportal.views.fragments.PasswordFragment.Companion;
import com.aeries.mobileportal.views.fragments.PasswordFragment.PasswordFragmentListener;
import com.aeries.mobileportal.views.fragments.UserTypeSelectFragment;
import com.aeries.mobileportal.views.fragments.UserTypeSelectFragment.UserTypeFragmentListener;
import com.aeries.mobileportal.views.fragments.VerifyEmailFragment;
import com.aeries.mobileportal.views.fragments.VerifyEmailFragment.VerifyEmailFragmentListener;
import com.aeries.mobileportal.views.viewmodels.create_account.CreateAccountViewModel;
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
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0005¢\u0006\u0002\u0010\tJ\u0018\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020UH\u0002J\u000f\u0010V\u001a\u0004\u0018\u00010UH\u0014¢\u0006\u0002\u0010WJ\u0010\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010XH\u0014J\n\u0010Y\u001a\u0004\u0018\u00010ZH\u0014J\b\u0010[\u001a\u00020RH\u0016J\b\u0010\\\u001a\u00020RH\u0016J\u0010\u0010]\u001a\u00020R2\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020RH\u0016J\u0010\u0010a\u001a\u00020R2\u0006\u0010b\u001a\u00020)H\u0016J\b\u0010c\u001a\u00020RH\u0016J\u0010\u0010d\u001a\u00020R2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010e\u001a\u00020R2\u0006\u0010f\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020R2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020R2\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010l\u001a\u00020RH\u0002J\b\u0010m\u001a\u00020RH\u0016J\u0010\u0010n\u001a\u00020R2\u0006\u0010o\u001a\u00020gH\u0016J\u0010\u0010p\u001a\u00020R2\u0006\u0010o\u001a\u00020gH\u0016J\b\u0010q\u001a\u00020RH\u0016J\u0010\u0010r\u001a\u00020R2\u0006\u0010s\u001a\u00020gH\u0016R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010@\u001a\u00020A8FX\u0002¢\u0006\f\n\u0004\bD\u0010\u0015\u001a\u0004\bB\u0010CR\u001a\u0010E\u001a\u00020FX.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006t"}, d2 = {"Lcom/aeries/mobileportal/views/activities/CreateAccountActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/create_account/CreateAccountViewModel;", "Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment$UserTypeFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment$EnterEmailFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/PasswordFragment$PasswordFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment$VerifyEmailFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment$DoneAccountFragmentListener;", "Lcom/aeries/mobileportal/StepsListener;", "()V", "accountProgress", "Landroid/widget/ProgressBar;", "getAccountProgress", "()Landroid/widget/ProgressBar;", "setAccountProgress", "(Landroid/widget/ProgressBar;)V", "component", "Lcom/aeries/mobileportal/dagger/components/CreateAccountComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/CreateAccountComponent;", "component$delegate", "Lkotlin/Lazy;", "doneAccountFragment", "Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment;", "getDoneAccountFragment", "()Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment;", "setDoneAccountFragment", "(Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment;)V", "enterEmailFragment", "Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment;", "getEnterEmailFragment", "()Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment;", "setEnterEmailFragment", "(Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment;)V", "fragmentContainer", "Landroid/widget/RelativeLayout;", "getFragmentContainer", "()Landroid/widget/RelativeLayout;", "setFragmentContainer", "(Landroid/widget/RelativeLayout;)V", "mAccountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "getMAccountTakenRequest", "()Lcom/aeries/mobileportal/models/AccountTakenRequest;", "setMAccountTakenRequest", "(Lcom/aeries/mobileportal/models/AccountTakenRequest;)V", "passwordFragment", "Lcom/aeries/mobileportal/views/fragments/PasswordFragment;", "getPasswordFragment", "()Lcom/aeries/mobileportal/views/fragments/PasswordFragment;", "setPasswordFragment", "(Lcom/aeries/mobileportal/views/fragments/PasswordFragment;)V", "percentageCompleteTV", "Landroid/widget/TextView;", "getPercentageCompleteTV", "()Landroid/widget/TextView;", "setPercentageCompleteTV", "(Landroid/widget/TextView;)V", "presenter", "Lcom/aeries/mobileportal/presenters/create_account/CreateAccountPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/create_account/CreateAccountPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/create_account/CreateAccountPresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "progressDialog$delegate", "userTypeSelectFragment", "Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment;", "getUserTypeSelectFragment", "()Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment;", "setUserTypeSelectFragment", "(Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment;)V", "verifyEmailFragment", "Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment;", "getVerifyEmailFragment", "()Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment;", "setVerifyEmailFragment", "(Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment;)V", "animateProgressBar", "", "progressBar", "step", "", "getLayout", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "onBackPressed", "onConfirmPassword", "createAccountRequest", "Lcom/aeries/mobileportal/models/CreateAccountRequest;", "onCreate", "onDataSubmitted", "accountTakenRequest", "onGoToLoginPressed", "onStepChanged", "onUserTypeSelected", "userType", "", "onVerifyEmail", "confirmAccountRequest", "Lcom/aeries/mobileportal/models/ConfirmAccountRequest;", "setStep", "setupViews", "showDoneScreen", "showError", "error", "showErrorAndFinish", "showPasswordScreen", "showVerificationScreen", "senderEmail", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CreateAccountActivity.kt */
public final class CreateAccountActivity extends BaseActivity<CreateAccountViewModel> implements CreateAccountViewModel, UserTypeFragmentListener, EnterEmailFragmentListener, PasswordFragmentListener, VerifyEmailFragmentListener, DoneAccountFragmentListener, StepsListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CreateAccountActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/CreateAccountComponent;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CreateAccountActivity.class), "progressDialog", "getProgressDialog()Landroid/app/ProgressDialog;"))};
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361798)
    public ProgressBar accountProgress;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new CreateAccountActivity$component$2(this));
    @NotNull
    private DoneAccountFragment doneAccountFragment = DoneAccountFragment.Companion.newInstance();
    @NotNull
    public EnterEmailFragment enterEmailFragment;
    @NotNull
    @BindView(2131361968)
    public RelativeLayout fragmentContainer;
    @NotNull
    public AccountTakenRequest mAccountTakenRequest;
    @NotNull
    public PasswordFragment passwordFragment;
    @NotNull
    @BindView(2131362089)
    public TextView percentageCompleteTV;
    @Inject
    @NotNull
    public CreateAccountPresenter presenter;
    @NotNull
    private final Lazy progressDialog$delegate = LazyKt.lazy(new CreateAccountActivity$progressDialog$2(this));
    @NotNull
    public UserTypeSelectFragment userTypeSelectFragment;
    @NotNull
    private VerifyEmailFragment verifyEmailFragment = new VerifyEmailFragment();

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
    public final CreateAccountComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (CreateAccountComponent) lazy.getValue();
    }

    @NotNull
    public final ProgressDialog getProgressDialog() {
        Lazy lazy = this.progressDialog$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (ProgressDialog) lazy.getValue();
    }

    @NotNull
    public final RelativeLayout getFragmentContainer() {
        RelativeLayout relativeLayout = this.fragmentContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        return relativeLayout;
    }

    public final void setFragmentContainer(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkParameterIsNotNull(relativeLayout, "<set-?>");
        this.fragmentContainer = relativeLayout;
    }

    @NotNull
    public final ProgressBar getAccountProgress() {
        ProgressBar progressBar = this.accountProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountProgress");
        }
        return progressBar;
    }

    public final void setAccountProgress(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.accountProgress = progressBar;
    }

    @NotNull
    public final TextView getPercentageCompleteTV() {
        TextView textView = this.percentageCompleteTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("percentageCompleteTV");
        }
        return textView;
    }

    public final void setPercentageCompleteTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.percentageCompleteTV = textView;
    }

    @NotNull
    public final CreateAccountPresenter m102getPresenter() {
        CreateAccountPresenter createAccountPresenter = this.presenter;
        if (createAccountPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return createAccountPresenter;
    }

    public final void setPresenter(@NotNull CreateAccountPresenter createAccountPresenter) {
        Intrinsics.checkParameterIsNotNull(createAccountPresenter, "<set-?>");
        this.presenter = createAccountPresenter;
    }

    @NotNull
    public final UserTypeSelectFragment getUserTypeSelectFragment() {
        UserTypeSelectFragment userTypeSelectFragment = this.userTypeSelectFragment;
        if (userTypeSelectFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userTypeSelectFragment");
        }
        return userTypeSelectFragment;
    }

    public final void setUserTypeSelectFragment(@NotNull UserTypeSelectFragment userTypeSelectFragment) {
        Intrinsics.checkParameterIsNotNull(userTypeSelectFragment, "<set-?>");
        this.userTypeSelectFragment = userTypeSelectFragment;
    }

    @NotNull
    public final EnterEmailFragment getEnterEmailFragment() {
        EnterEmailFragment enterEmailFragment = this.enterEmailFragment;
        if (enterEmailFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterEmailFragment");
        }
        return enterEmailFragment;
    }

    public final void setEnterEmailFragment(@NotNull EnterEmailFragment enterEmailFragment) {
        Intrinsics.checkParameterIsNotNull(enterEmailFragment, "<set-?>");
        this.enterEmailFragment = enterEmailFragment;
    }

    @NotNull
    public final AccountTakenRequest getMAccountTakenRequest() {
        AccountTakenRequest accountTakenRequest = this.mAccountTakenRequest;
        if (accountTakenRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAccountTakenRequest");
        }
        return accountTakenRequest;
    }

    public final void setMAccountTakenRequest(@NotNull AccountTakenRequest accountTakenRequest) {
        Intrinsics.checkParameterIsNotNull(accountTakenRequest, "<set-?>");
        this.mAccountTakenRequest = accountTakenRequest;
    }

    @NotNull
    public final PasswordFragment getPasswordFragment() {
        PasswordFragment passwordFragment = this.passwordFragment;
        if (passwordFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordFragment");
        }
        return passwordFragment;
    }

    public final void setPasswordFragment(@NotNull PasswordFragment passwordFragment) {
        Intrinsics.checkParameterIsNotNull(passwordFragment, "<set-?>");
        this.passwordFragment = passwordFragment;
    }

    @NotNull
    public final VerifyEmailFragment getVerifyEmailFragment() {
        return this.verifyEmailFragment;
    }

    public final void setVerifyEmailFragment(@NotNull VerifyEmailFragment verifyEmailFragment) {
        Intrinsics.checkParameterIsNotNull(verifyEmailFragment, "<set-?>");
        this.verifyEmailFragment = verifyEmailFragment;
    }

    @NotNull
    public final DoneAccountFragment getDoneAccountFragment() {
        return this.doneAccountFragment;
    }

    public final void setDoneAccountFragment(@NotNull DoneAccountFragment doneAccountFragment) {
        Intrinsics.checkParameterIsNotNull(doneAccountFragment, "<set-?>");
        this.doneAccountFragment = doneAccountFragment;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_create_account);
    }

    @Nullable
    protected BasePresenter<CreateAccountViewModel> getPresenter() {
        CreateAccountPresenter createAccountPresenter = this.presenter;
        if (createAccountPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return createAccountPresenter;
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
        getProgressDialog().setMessage(getString(C0316R.string.loading));
        this.userTypeSelectFragment = UserTypeSelectFragment.Companion.newInstance();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        UserTypeSelectFragment userTypeSelectFragment = this.userTypeSelectFragment;
        if (userTypeSelectFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userTypeSelectFragment");
        }
        beginTransaction.replace(C0316R.id.fragment_container, userTypeSelectFragment).commit();
    }

    public void onUserTypeSelected(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "userType");
        this.enterEmailFragment = EnterEmailFragment.Companion.newInstance(str);
        str = getSupportFragmentManager().beginTransaction();
        EnterEmailFragment enterEmailFragment = this.enterEmailFragment;
        if (enterEmailFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterEmailFragment");
        }
        str.replace(C0316R.id.fragment_container, enterEmailFragment).addToBackStack(null).commit();
    }

    private final void setStep(int i) {
        TextView textView = this.percentageCompleteTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("percentageCompleteTV");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(C0316R.string.steps_completed);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.steps_completed)");
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        textView.setText(string);
        ProgressBar progressBar = this.accountProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountProgress");
        }
        animateProgressBar(progressBar, i);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private final void animateProgressBar(ProgressBar progressBar, int i) {
        progressBar = ObjectAnimator.ofInt(progressBar, NotificationCompat.CATEGORY_PROGRESS, new int[]{i * 20});
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "animation");
        progressBar.setDuration(500);
        progressBar.setInterpolator((TimeInterpolator) new DecelerateInterpolator());
        progressBar.start();
    }

    public void onDataSubmitted(@NotNull AccountTakenRequest accountTakenRequest) {
        Intrinsics.checkParameterIsNotNull(accountTakenRequest, "accountTakenRequest");
        this.mAccountTakenRequest = accountTakenRequest;
        CreateAccountPresenter createAccountPresenter = this.presenter;
        if (createAccountPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        createAccountPresenter.checkIfAccountTaken(accountTakenRequest);
        getProgressDialog().show();
    }

    public void showPasswordScreen() {
        getProgressDialog().dismiss();
        Companion companion = PasswordFragment.Companion;
        AccountTakenRequest accountTakenRequest = this.mAccountTakenRequest;
        if (accountTakenRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAccountTakenRequest");
        }
        this.passwordFragment = companion.newInstance(accountTakenRequest);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        PasswordFragment passwordFragment = this.passwordFragment;
        if (passwordFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordFragment");
        }
        beginTransaction.replace(C0316R.id.fragment_container, passwordFragment).addToBackStack(null).commit();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        getProgressDialog().dismiss();
        Builder builder = new Builder(this);
        String string = getString(C0316R.string.error);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.error)");
        builder.setTitle(StringsKt.capitalize(string)).setMessage(str).setPositiveButton(getString(C0316R.string.got_it), null).create().show();
    }

    public void showErrorAndFinish(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        getProgressDialog().dismiss();
        Builder builder = new Builder(this);
        String string = getString(C0316R.string.error);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.error)");
        builder.setTitle(StringsKt.capitalize(string)).setMessage(str).setPositiveButton(getString(C0316R.string.got_it), new CreateAccountActivity$showErrorAndFinish$1(this)).create().show();
    }

    public void onStepChanged(int i) {
        setStep(i);
    }

    public void showVerificationScreen(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "senderEmail");
        getProgressDialog().dismiss();
        VerifyEmailFragment.Companion companion = VerifyEmailFragment.Companion;
        AccountTakenRequest accountTakenRequest = this.mAccountTakenRequest;
        if (accountTakenRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAccountTakenRequest");
        }
        this.verifyEmailFragment = companion.newInstance(accountTakenRequest, str);
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, this.verifyEmailFragment).addToBackStack(null).commit();
    }

    public void showDoneScreen() {
        getProgressDialog().dismiss();
        CreateAccountPresenter createAccountPresenter = this.presenter;
        if (createAccountPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        AccountTakenRequest accountTakenRequest = this.mAccountTakenRequest;
        if (accountTakenRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAccountTakenRequest");
        }
        createAccountPresenter.setNewDefaultEmail(accountTakenRequest.getEmailaddress());
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, this.doneAccountFragment).addToBackStack(null).commit();
    }

    public void onConfirmPassword(@NotNull CreateAccountRequest createAccountRequest) {
        Intrinsics.checkParameterIsNotNull(createAccountRequest, "createAccountRequest");
        getProgressDialog().show();
        CreateAccountPresenter createAccountPresenter = this.presenter;
        if (createAccountPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        createAccountPresenter.createAccount(createAccountRequest);
    }

    public void onVerifyEmail(@NotNull ConfirmAccountRequest confirmAccountRequest) {
        Intrinsics.checkParameterIsNotNull(confirmAccountRequest, "confirmAccountRequest");
        getProgressDialog().show();
        CreateAccountPresenter createAccountPresenter = this.presenter;
        if (createAccountPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        createAccountPresenter.confirmAccount(confirmAccountRequest);
    }

    public void onGoToLoginPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(67141632);
        startActivity(intent);
    }
}
