package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.ChangePasswordRequest;
import com.aeries.mobileportal.views.activities.ForgotPasswordActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J(\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\u001aH\u0007R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006*"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ForgotPasswordFragment;", "Landroid/support/v4/app/Fragment;", "()V", "confirmPassword", "Landroid/support/design/widget/TextInputEditText;", "getConfirmPassword", "()Landroid/support/design/widget/TextInputEditText;", "setConfirmPassword", "(Landroid/support/design/widget/TextInputEditText;)V", "mEmail", "", "mListener", "Lcom/aeries/mobileportal/views/fragments/ForgotPasswordFragment$ChangePasswordFragmentListener;", "newPassword", "getNewPassword", "setNewPassword", "nextButton", "Landroid/widget/Button;", "getNextButton", "()Landroid/widget/Button;", "setNextButton", "(Landroid/widget/Button;)V", "verificationCode", "getVerificationCode", "setVerificationCode", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onNextPressed", "ChangePasswordFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ForgotPasswordFragment.kt */
public final class ForgotPasswordFragment extends Fragment {
    public static final Companion Companion = new Companion();
    private static final String EMAIL = "email";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361885)
    public TextInputEditText confirmPassword;
    private String mEmail;
    private ChangePasswordFragmentListener mListener;
    @NotNull
    @BindView(2131362056)
    public TextInputEditText newPassword;
    @NotNull
    @BindView(2131362058)
    public Button nextButton;
    @NotNull
    @BindView(2131362275)
    public TextInputEditText verificationCode;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ForgotPasswordFragment$ChangePasswordFragmentListener;", "", "onNextPressed", "", "changePasswordRequest", "Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ForgotPasswordFragment.kt */
    public interface ChangePasswordFragmentListener {
        void onNextPressed(@NotNull ChangePasswordRequest changePasswordRequest);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ForgotPasswordFragment$Companion;", "", "()V", "EMAIL", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/ForgotPasswordFragment;", "email", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ForgotPasswordFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ForgotPasswordFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "email");
            ForgotPasswordFragment forgotPasswordFragment = new ForgotPasswordFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ForgotPasswordFragment.EMAIL, str);
            forgotPasswordFragment.setArguments(bundle);
            return forgotPasswordFragment;
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
    public final TextInputEditText getNewPassword() {
        TextInputEditText textInputEditText = this.newPassword;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newPassword");
        }
        return textInputEditText;
    }

    public final void setNewPassword(@NotNull TextInputEditText textInputEditText) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "<set-?>");
        this.newPassword = textInputEditText;
    }

    @NotNull
    public final TextInputEditText getConfirmPassword() {
        TextInputEditText textInputEditText = this.confirmPassword;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmPassword");
        }
        return textInputEditText;
    }

    public final void setConfirmPassword(@NotNull TextInputEditText textInputEditText) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "<set-?>");
        this.confirmPassword = textInputEditText;
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

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mEmail = getArguments().getString(EMAIL);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_forgot_password, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    @OnClick({2131362058})
    public final void onNextPressed() {
        TextInputEditText textInputEditText = this.newPassword;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newPassword");
        }
        if ((Intrinsics.areEqual(textInputEditText.getText().toString(), (Object) "") ^ 1) != 0) {
            textInputEditText = this.confirmPassword;
            if (textInputEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmPassword");
            }
            if ((Intrinsics.areEqual(textInputEditText.getText().toString(), (Object) "") ^ 1) != 0) {
                textInputEditText = this.verificationCode;
                if (textInputEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("verificationCode");
                }
                if ((Intrinsics.areEqual(textInputEditText.getText().toString(), (Object) "") ^ 1) != 0) {
                    if (this.mListener != null) {
                        boolean z = getContext() instanceof ForgotPasswordActivity;
                        String str = this.mEmail;
                        if (str == null) {
                            Intrinsics.throwNpe();
                        }
                        TextInputEditText textInputEditText2 = this.verificationCode;
                        if (textInputEditText2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("verificationCode");
                        }
                        String obj = textInputEditText2.getText().toString();
                        String str2 = "";
                        textInputEditText2 = this.newPassword;
                        if (textInputEditText2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("newPassword");
                        }
                        String obj2 = textInputEditText2.getText().toString();
                        textInputEditText2 = this.confirmPassword;
                        if (textInputEditText2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("confirmPassword");
                        }
                        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(str, obj, str2, obj2, textInputEditText2.getText().toString(), z);
                        ChangePasswordFragmentListener changePasswordFragmentListener = this.mListener;
                        if (changePasswordFragmentListener == null) {
                            Intrinsics.throwNpe();
                        }
                        changePasswordFragmentListener.onNextPressed(changePasswordRequest);
                        return;
                    }
                    return;
                }
            }
        }
        Toast.makeText(getContext(), getText(C0316R.string.please_fill_in_the_blanks), 0).show();
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof ChangePasswordFragmentListener) {
            this.mListener = (ChangePasswordFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement ChangePasswordFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (ChangePasswordFragmentListener) null;
    }
}
