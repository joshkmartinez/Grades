package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.FeedbackActivityComponent;
import com.aeries.mobileportal.models.Feedback;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.feedback.FeedbackPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.ThankYouFragment;
import com.aeries.mobileportal.views.fragments.ThankYouFragment.ThankYouFragmentListener;
import com.aeries.mobileportal.views.viewmodels.feedback.FeedbackViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u000f\u0010*\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0002\u0010,J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010-H\u0014J\n\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020'H\u0016J\b\u00101\u001a\u00020'H\u0016J\b\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020'H\u0007J\b\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020'H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00068"}, d2 = {"Lcom/aeries/mobileportal/views/activities/FeedbackActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/feedback/FeedbackViewModel;", "Lcom/aeries/mobileportal/views/fragments/ThankYouFragment$ThankYouFragmentListener;", "()V", "comment", "Landroid/widget/EditText;", "getComment", "()Landroid/widget/EditText;", "setComment", "(Landroid/widget/EditText;)V", "component", "Lcom/aeries/mobileportal/dagger/components/FeedbackActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/FeedbackActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "feedbackEmail", "getFeedbackEmail", "setFeedbackEmail", "nextButton", "Landroid/widget/Button;", "getNextButton", "()Landroid/widget/Button;", "setNextButton", "(Landroid/widget/Button;)V", "presenter", "Lcom/aeries/mobileportal/presenters/feedback/FeedbackPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/feedback/FeedbackPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/feedback/FeedbackPresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "autoFillEmail", "", "email", "", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "onCreate", "onHomePressed", "onNextPressed", "setupViews", "showError", "message", "showThankYouScreen", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FeedbackActivity.kt */
public final class FeedbackActivity extends BaseActivity<FeedbackViewModel> implements FeedbackViewModel, ThankYouFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(FeedbackActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/FeedbackActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361884)
    public EditText comment;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new FeedbackActivity$component$2(this));
    @NotNull
    @BindView(2131361959)
    public EditText feedbackEmail;
    @NotNull
    @BindView(2131362057)
    public Button nextButton;
    @Inject
    @NotNull
    public FeedbackPresenter presenter;
    @Nullable
    private ProgressDialog progressDialog;

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
    public final FeedbackActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (FeedbackActivityComponent) lazy.getValue();
    }

    @NotNull
    public final EditText getFeedbackEmail() {
        EditText editText = this.feedbackEmail;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackEmail");
        }
        return editText;
    }

    public final void setFeedbackEmail(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.feedbackEmail = editText;
    }

    @NotNull
    public final EditText getComment() {
        EditText editText = this.comment;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comment");
        }
        return editText;
    }

    public final void setComment(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.comment = editText;
    }

    @NotNull
    public final Button getNextButton() {
        Button button = this.nextButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        return button;
    }

    public final void setNextButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.nextButton = button;
    }

    @NotNull
    public final FeedbackPresenter m110getPresenter() {
        FeedbackPresenter feedbackPresenter = this.presenter;
        if (feedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return feedbackPresenter;
    }

    public final void setPresenter(@NotNull FeedbackPresenter feedbackPresenter) {
        Intrinsics.checkParameterIsNotNull(feedbackPresenter, "<set-?>");
        this.presenter = feedbackPresenter;
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
        return Integer.valueOf(C0316R.layout.activity_feedback);
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    @Nullable
    protected BasePresenter<FeedbackViewModel> getPresenter() {
        FeedbackPresenter feedbackPresenter = this.presenter;
        if (feedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return feedbackPresenter;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void setupViews() {
        this.progressDialog = new ProgressDialog(this);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setCancelable(false);
        }
        progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setMessage("Loading...");
        }
        FeedbackPresenter feedbackPresenter = this.presenter;
        if (feedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedbackPresenter.getDefaultEmail();
    }

    public void autoFillEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        EditText editText = this.feedbackEmail;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackEmail");
        }
        editText.setText(str);
    }

    @OnClick({2131362057})
    public final void onNextPressed() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.show();
        }
        EditText editText = this.feedbackEmail;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackEmail");
        }
        String obj = editText.getText().toString();
        EditText editText2 = this.comment;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comment");
        }
        Feedback feedback = new Feedback(obj, editText2.getText().toString());
        FeedbackPresenter feedbackPresenter = this.presenter;
        if (feedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedbackPresenter.sendFeedback(feedback);
    }

    public void showThankYouScreen() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Button button = this.nextButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        button.setVisibility(8);
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, ThankYouFragment.Companion.newInstance()).commit();
    }

    public void onHomePressed() {
        finish();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, (Function0) new FeedbackActivity$showError$1(this)).show();
    }
}
