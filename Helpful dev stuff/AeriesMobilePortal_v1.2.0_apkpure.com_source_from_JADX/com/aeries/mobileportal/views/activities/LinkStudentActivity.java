package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.LinkStudentActivityComponent;
import com.aeries.mobileportal.models.AddStudentResponse;
import com.aeries.mobileportal.models.LinkContact;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.link_student.LinkStudentPresenter;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.LinkStudentDoneFragment;
import com.aeries.mobileportal.views.fragments.LinkStudentDoneFragment.LinkStudentDoneFragmentListener;
import com.aeries.mobileportal.views.fragments.LinkStudentInfoFragment;
import com.aeries.mobileportal.views.fragments.LinkStudentInfoFragment.LinkStudentInfoFragmentListener;
import com.aeries.mobileportal.views.fragments.UpdateContactFragment;
import com.aeries.mobileportal.views.fragments.UpdateContactFragment.Companion;
import com.aeries.mobileportal.views.fragments.UpdateContactFragment.UpdateContactFragmentListener;
import com.aeries.mobileportal.views.viewmodels.link_student.LinkStudentViewModel;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010%\u001a\u00020&H\u0002J\u000f\u0010'\u001a\u0004\u0018\u00010(H\u0014¢\u0006\u0002\u0010)J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010*H\u0014J\n\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020&H\u0016J\b\u0010.\u001a\u00020&H\u0007J\b\u0010/\u001a\u00020&H\u0016J\b\u00100\u001a\u00020&H\u0016J \u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020&H\u0016J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0016J\u0010\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020\bH\u0016J\u0006\u0010<\u001a\u00020&J\u0010\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020AH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006B"}, d2 = {"Lcom/aeries/mobileportal/views/activities/LinkStudentActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/link_student/LinkStudentViewModel;", "Lcom/aeries/mobileportal/views/fragments/LinkStudentInfoFragment$LinkStudentInfoFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/UpdateContactFragment$UpdateContactFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/LinkStudentDoneFragment$LinkStudentDoneFragmentListener;", "()V", "completeMessage", "", "getCompleteMessage", "()Ljava/lang/String;", "setCompleteMessage", "(Ljava/lang/String;)V", "component", "Lcom/aeries/mobileportal/dagger/components/LinkStudentActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/LinkStudentActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "linkStudentText", "Landroid/widget/TextView;", "getLinkStudentText", "()Landroid/widget/TextView;", "setLinkStudentText", "(Landroid/widget/TextView;)V", "presenter", "Lcom/aeries/mobileportal/presenters/link_student/LinkStudentPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/link_student/LinkStudentPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/link_student/LinkStudentPresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "dismissProgressDialog", "", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "onCancelClick", "onCreate", "onDonePressed", "onLinkStudentInfoSubmitted", "studentId", "studentPhone", "verificationCode", "onNextPressed", "linkContact", "Lcom/aeries/mobileportal/models/LinkContact;", "onNotMePressed", "setupViews", "showCompleteMessage", "message", "showCompletedScreen", "showError", "error", "showUpdateContactScreen", "addStudentResponse", "Lcom/aeries/mobileportal/models/AddStudentResponse;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkStudentActivity.kt */
public final class LinkStudentActivity extends BaseActivity<LinkStudentViewModel> implements LinkStudentViewModel, LinkStudentInfoFragmentListener, UpdateContactFragmentListener, LinkStudentDoneFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LinkStudentActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/LinkStudentActivityComponent;"))};
    private HashMap _$_findViewCache;
    @Nullable
    private String completeMessage;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new LinkStudentActivity$component$2(this));
    @NotNull
    @BindView(2131362024)
    public TextView linkStudentText;
    @Inject
    @NotNull
    public LinkStudentPresenter presenter;
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
    public final LinkStudentActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (LinkStudentActivityComponent) lazy.getValue();
    }

    @NotNull
    public final TextView getLinkStudentText() {
        TextView textView = this.linkStudentText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkStudentText");
        }
        return textView;
    }

    public final void setLinkStudentText(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.linkStudentText = textView;
    }

    @NotNull
    public final LinkStudentPresenter m103getPresenter() {
        LinkStudentPresenter linkStudentPresenter = this.presenter;
        if (linkStudentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return linkStudentPresenter;
    }

    public final void setPresenter(@NotNull LinkStudentPresenter linkStudentPresenter) {
        Intrinsics.checkParameterIsNotNull(linkStudentPresenter, "<set-?>");
        this.presenter = linkStudentPresenter;
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

    @Nullable
    public final String getCompleteMessage() {
        return this.completeMessage;
    }

    public final void setCompleteMessage(@Nullable String str) {
        this.completeMessage = str;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_link_student);
    }

    @Nullable
    protected BasePresenter<LinkStudentViewModel> getPresenter() {
        LinkStudentPresenter linkStudentPresenter = this.presenter;
        if (linkStudentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return linkStudentPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void onCreate() {
        if (getIntent().getBooleanExtra(LoginActivity.Companion.getFROM_LOGIN(), false)) {
            LinkStudentPresenter linkStudentPresenter = this.presenter;
            if (linkStudentPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            linkStudentPresenter.setLinkingStudent(true);
        }
        setupViews();
    }

    private final void setupViews() {
        ButterKnife.bind((Activity) this);
        if (getIntent().getBooleanExtra("ANOTHER_STUDENT", false)) {
            TextView textView = this.linkStudentText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkStudentText");
            }
            textView.setText(C0316R.string.link_another_student);
        }
        this.progressDialog = new ProgressDialog(this);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.setMessage(getString(C0316R.string.loading));
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, LinkStudentInfoFragment.Companion.newInstance()).commit();
    }

    @OnClick({2131361855})
    public final void onCancelClick() {
        if (getIntent().getBooleanExtra("ANOTHER_STUDENT", false)) {
            finish();
            return;
        }
        LinkStudentPresenter linkStudentPresenter = this.presenter;
        if (linkStudentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        linkStudentPresenter.logout();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(872448000);
        startActivity(intent);
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onLinkStudentInfoSubmitted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "studentId");
        Intrinsics.checkParameterIsNotNull(str2, "studentPhone");
        Intrinsics.checkParameterIsNotNull(str3, "verificationCode");
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.show();
        LinkStudentPresenter linkStudentPresenter = this.presenter;
        if (linkStudentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        linkStudentPresenter.addStudent(str, str2, str3);
    }

    public void showUpdateContactScreen(@NotNull AddStudentResponse addStudentResponse) {
        Intrinsics.checkParameterIsNotNull(addStudentResponse, "addStudentResponse");
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.dismiss();
        this.completeMessage = addStudentResponse.getError();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Companion companion = UpdateContactFragment.Companion;
        addStudentResponse = addStudentResponse.getContacts();
        if (addStudentResponse == null) {
            Intrinsics.throwNpe();
        }
        beginTransaction.replace(C0316R.id.fragment_container, companion.newInstance(addStudentResponse)).commit();
    }

    public void onNextPressed(@NotNull LinkContact linkContact) {
        Intrinsics.checkParameterIsNotNull(linkContact, "linkContact");
        new Builder(this).setTitle(C0316R.string.complete_exc).setMessage(getString(C0316R.string.replace_contact_message)).setPositiveButton(C0316R.string.yes, new LinkStudentActivity$onNextPressed$1(this, linkContact)).setNegativeButton(C0316R.string.no, new LinkStudentActivity$onNextPressed$2(this, linkContact)).create().show();
    }

    public void onNotMePressed() {
        showCompleteMessage();
    }

    public void showCompleteMessage() {
        dismissProgressDialog();
        Builder cancelable = new Builder(this).setTitle(C0316R.string.complete_exc).setCancelable(false);
        String str = this.completeMessage;
        if (str == null) {
            str = getString(C0316R.string.student_now_linked);
        }
        cancelable.setMessage(str).setPositiveButton(C0316R.string.got_it, new LinkStudentActivity$showCompleteMessage$1(this)).create().show();
    }

    private final void dismissProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        if (progressDialog.isShowing()) {
            progressDialog = this.progressDialog;
            if (progressDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            }
            progressDialog.dismiss();
        }
    }

    public void showCompleteMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        dismissProgressDialog();
        new Builder(this).setTitle(C0316R.string.complete_exc).setMessage(str).setPositiveButton(C0316R.string.got_it, new LinkStudentActivity$showCompleteMessage$2(this)).create().show();
    }

    public final void showCompletedScreen() {
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, LinkStudentDoneFragment.Companion.newInstance()).commit();
    }

    public void onDonePressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(872448000);
        startActivity(intent);
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        dismissProgressDialog();
        new Builder(this).setTitle(C0316R.string.error).setMessage(str).setPositiveButton(C0316R.string.got_it, null).create().show();
    }
}
