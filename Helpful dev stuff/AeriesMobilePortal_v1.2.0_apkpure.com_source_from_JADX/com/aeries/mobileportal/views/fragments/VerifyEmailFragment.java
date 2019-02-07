package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.StepsListener;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.ConfirmAccountRequest;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J(\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020\u001cH\u0007J\b\u0010*\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment;", "Landroid/support/v4/app/Fragment;", "()V", "mAccountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "mListener", "Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment$VerifyEmailFragmentListener;", "mSenderEmail", "", "nextButton", "Landroid/widget/Button;", "getNextButton", "()Landroid/widget/Button;", "setNextButton", "(Landroid/widget/Button;)V", "verificationCode", "Landroid/support/design/widget/TextInputEditText;", "getVerificationCode", "()Landroid/support/design/widget/TextInputEditText;", "setVerificationCode", "(Landroid/support/design/widget/TextInputEditText;)V", "verifyEmailMessage", "Landroid/widget/TextView;", "getVerifyEmailMessage", "()Landroid/widget/TextView;", "setVerifyEmailMessage", "(Landroid/widget/TextView;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onNextPressed", "onResume", "setupViews", "Companion", "VerifyEmailFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: VerifyEmailFragment.kt */
public final class VerifyEmailFragment extends Fragment {
    @NotNull
    private static final String ACCOUNT_TAKEN_REQUEST = "ACCOUNT_TAKEN_REQUEST";
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String SENDER_EMAIL = "SENDER_EMAIL";
    private HashMap _$_findViewCache;
    private AccountTakenRequest mAccountTakenRequest;
    private VerifyEmailFragmentListener mListener;
    private String mSenderEmail;
    @NotNull
    @BindView(2131362058)
    public Button nextButton;
    @NotNull
    @BindView(2131362275)
    public TextInputEditText verificationCode;
    @NotNull
    @BindView(2131362276)
    public TextView verifyEmailMessage;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment$Companion;", "", "()V", "ACCOUNT_TAKEN_REQUEST", "", "getACCOUNT_TAKEN_REQUEST", "()Ljava/lang/String;", "SENDER_EMAIL", "getSENDER_EMAIL", "newInstance", "Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment;", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "senderEmail", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: VerifyEmailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getACCOUNT_TAKEN_REQUEST() {
            return VerifyEmailFragment.ACCOUNT_TAKEN_REQUEST;
        }

        @NotNull
        public final String getSENDER_EMAIL() {
            return VerifyEmailFragment.SENDER_EMAIL;
        }

        @NotNull
        public final VerifyEmailFragment newInstance(@NotNull AccountTakenRequest accountTakenRequest, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(accountTakenRequest, "accountTakenRequest");
            Intrinsics.checkParameterIsNotNull(str, "senderEmail");
            VerifyEmailFragment verifyEmailFragment = new VerifyEmailFragment();
            Bundle bundle = new Bundle();
            Companion companion = this;
            bundle.putParcelable(getACCOUNT_TAKEN_REQUEST(), accountTakenRequest);
            bundle.putString(getSENDER_EMAIL(), str);
            verifyEmailFragment.setArguments(bundle);
            return verifyEmailFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/VerifyEmailFragment$VerifyEmailFragmentListener;", "", "onVerifyEmail", "", "confirmAccountRequest", "Lcom/aeries/mobileportal/models/ConfirmAccountRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: VerifyEmailFragment.kt */
    public interface VerifyEmailFragmentListener {
        void onVerifyEmail(@NotNull ConfirmAccountRequest confirmAccountRequest);
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

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
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
    public final TextInputEditText getVerificationCode() {
        TextInputEditText textInputEditText = this.verificationCode;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verificationCode");
        }
        return textInputEditText;
    }

    public final void setVerificationCode(@NotNull TextInputEditText textInputEditText) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "<set-?>");
        this.verificationCode = textInputEditText;
    }

    @NotNull
    public final TextView getVerifyEmailMessage() {
        TextView textView = this.verifyEmailMessage;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyEmailMessage");
        }
        return textView;
    }

    public final void setVerifyEmailMessage(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.verifyEmailMessage = textView;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mAccountTakenRequest = (AccountTakenRequest) getArguments().getParcelable(ACCOUNT_TAKEN_REQUEST);
            this.mSenderEmail = getArguments().getString(SENDER_EMAIL);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_verify_email, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(C0316R.string.verify_email_message);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.verify_email_message)");
        Object[] objArr = new Object[2];
        AccountTakenRequest accountTakenRequest = this.mAccountTakenRequest;
        objArr[0] = accountTakenRequest != null ? accountTakenRequest.getEmailaddress() : null;
        objArr[1] = this.mSenderEmail;
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        TextView textView = this.verifyEmailMessage;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyEmailMessage");
        }
        textView.setText(string);
        TextInputEditText textInputEditText = this.verificationCode;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verificationCode");
        }
        textInputEditText.clearFocus();
    }

    @OnClick({2131362058})
    public final void onNextPressed() {
        TextInputEditText textInputEditText = this.verificationCode;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verificationCode");
        }
        if ((Intrinsics.areEqual(textInputEditText.getText().toString(), (Object) "") ^ 1) != 0) {
            AccountTakenRequest accountTakenRequest = this.mAccountTakenRequest;
            if (accountTakenRequest == null) {
                Intrinsics.throwNpe();
            }
            String emailaddress = accountTakenRequest.getEmailaddress();
            TextInputEditText textInputEditText2 = this.verificationCode;
            if (textInputEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verificationCode");
            }
            ConfirmAccountRequest confirmAccountRequest = new ConfirmAccountRequest(emailaddress, textInputEditText2.getText().toString());
            if (this.mListener != null) {
                VerifyEmailFragmentListener verifyEmailFragmentListener = this.mListener;
                if (verifyEmailFragmentListener == null) {
                    Intrinsics.throwNpe();
                }
                verifyEmailFragmentListener.onVerifyEmail(confirmAccountRequest);
                return;
            }
            return;
        }
        Toast.makeText(getContext(), getString(C0316R.string.enter_verification), 0).show();
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof VerifyEmailFragmentListener) {
            this.mListener = (VerifyEmailFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement UserTypeFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (VerifyEmailFragmentListener) null;
    }

    public void onResume() {
        super.onResume();
        if (getContext() instanceof StepsListener) {
            Context context = getContext();
            if (context != null) {
                ((StepsListener) context).onStepChanged(4);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.StepsListener");
        }
    }
}
