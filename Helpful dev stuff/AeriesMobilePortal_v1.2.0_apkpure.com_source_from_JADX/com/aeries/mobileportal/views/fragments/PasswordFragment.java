package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.StepsListener;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.CreateAccountRequest;
import com.aeries.mobileportal.utils.AccountCreationUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J(\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0007J\b\u0010%\u001a\u00020\u0017H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/aeries/mobileportal/views/fragments/PasswordFragment;", "Landroid/support/v4/app/Fragment;", "()V", "choosePassword", "Landroid/support/design/widget/TextInputEditText;", "getChoosePassword", "()Landroid/support/design/widget/TextInputEditText;", "setChoosePassword", "(Landroid/support/design/widget/TextInputEditText;)V", "confirmPassword", "getConfirmPassword", "setConfirmPassword", "mAccountTakenReq", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "mListener", "Lcom/aeries/mobileportal/views/fragments/PasswordFragment$PasswordFragmentListener;", "nextButton", "Landroid/widget/Button;", "getNextButton", "()Landroid/widget/Button;", "setNextButton", "(Landroid/widget/Button;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onNextPressed", "onResume", "Companion", "PasswordFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: PasswordFragment.kt */
public final class PasswordFragment extends Fragment {
    private static final String ACCOUNT_TAKEN_REQ = "Account_Taken_Req";
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361877)
    public TextInputEditText choosePassword;
    @NotNull
    @BindView(2131361885)
    public TextInputEditText confirmPassword;
    private AccountTakenRequest mAccountTakenReq;
    private PasswordFragmentListener mListener;
    @NotNull
    @BindView(2131362058)
    public Button nextButton;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/PasswordFragment$Companion;", "", "()V", "ACCOUNT_TAKEN_REQ", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/PasswordFragment;", "param1", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: PasswordFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PasswordFragment newInstance(@NotNull AccountTakenRequest accountTakenRequest) {
            Intrinsics.checkParameterIsNotNull(accountTakenRequest, "param1");
            PasswordFragment passwordFragment = new PasswordFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(PasswordFragment.ACCOUNT_TAKEN_REQ, accountTakenRequest);
            passwordFragment.setArguments(bundle);
            return passwordFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/PasswordFragment$PasswordFragmentListener;", "", "onConfirmPassword", "", "createAccountRequest", "Lcom/aeries/mobileportal/models/CreateAccountRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: PasswordFragment.kt */
    public interface PasswordFragmentListener {
        void onConfirmPassword(@NotNull CreateAccountRequest createAccountRequest);
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
    public final TextInputEditText getChoosePassword() {
        TextInputEditText textInputEditText = this.choosePassword;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choosePassword");
        }
        return textInputEditText;
    }

    public final void setChoosePassword(@NotNull TextInputEditText textInputEditText) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "<set-?>");
        this.choosePassword = textInputEditText;
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
            this.mAccountTakenReq = (AccountTakenRequest) getArguments().getParcelable(ACCOUNT_TAKEN_REQ);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_password, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    @OnClick({2131362058})
    public final void onNextPressed() {
        com.aeries.mobileportal.utils.AccountCreationUtils.Companion companion = AccountCreationUtils.Companion;
        TextInputEditText textInputEditText = this.choosePassword;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choosePassword");
        }
        Editable text = textInputEditText.getText();
        TextInputEditText textInputEditText2 = this.confirmPassword;
        if (textInputEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmPassword");
        }
        if (companion.checkValidConfirmation(text, textInputEditText2.getText())) {
            String emailaddress;
            String str;
            CreateAccountRequest createAccountRequest;
            PasswordFragmentListener passwordFragmentListener;
            TextInputEditText textInputEditText3 = this.choosePassword;
            if (textInputEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("choosePassword");
            }
            String obj = textInputEditText3.getText().toString();
            textInputEditText3 = this.confirmPassword;
            if (textInputEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmPassword");
            }
            String obj2 = textInputEditText3.getText().toString();
            AccountTakenRequest accountTakenRequest = this.mAccountTakenReq;
            if (accountTakenRequest != null) {
                emailaddress = accountTakenRequest.getEmailaddress();
                if (emailaddress != null) {
                    str = emailaddress;
                    accountTakenRequest = this.mAccountTakenReq;
                    if (accountTakenRequest != null) {
                        emailaddress = accountTakenRequest.getAccountType();
                        if (emailaddress != null) {
                            createAccountRequest = new CreateAccountRequest(str, emailaddress, obj, obj2, "", "");
                            if (this.mListener == null) {
                                passwordFragmentListener = this.mListener;
                                if (passwordFragmentListener == null) {
                                    Intrinsics.throwNpe();
                                }
                                passwordFragmentListener.onConfirmPassword(createAccountRequest);
                                return;
                            }
                            return;
                        }
                    }
                    emailaddress = "";
                    createAccountRequest = new CreateAccountRequest(str, emailaddress, obj, obj2, "", "");
                    if (this.mListener == null) {
                        passwordFragmentListener = this.mListener;
                        if (passwordFragmentListener == null) {
                            Intrinsics.throwNpe();
                        }
                        passwordFragmentListener.onConfirmPassword(createAccountRequest);
                        return;
                    }
                    return;
                }
            }
            emailaddress = "";
            str = emailaddress;
            accountTakenRequest = this.mAccountTakenReq;
            if (accountTakenRequest != null) {
                emailaddress = accountTakenRequest.getAccountType();
                if (emailaddress != null) {
                    createAccountRequest = new CreateAccountRequest(str, emailaddress, obj, obj2, "", "");
                    if (this.mListener == null) {
                        passwordFragmentListener = this.mListener;
                        if (passwordFragmentListener == null) {
                            Intrinsics.throwNpe();
                        }
                        passwordFragmentListener.onConfirmPassword(createAccountRequest);
                        return;
                    }
                    return;
                }
            }
            emailaddress = "";
            createAccountRequest = new CreateAccountRequest(str, emailaddress, obj, obj2, "", "");
            if (this.mListener == null) {
                passwordFragmentListener = this.mListener;
                if (passwordFragmentListener == null) {
                    Intrinsics.throwNpe();
                }
                passwordFragmentListener.onConfirmPassword(createAccountRequest);
                return;
            }
            return;
        }
        Toast.makeText(getContext(), getText(C0316R.string.password_dont_match), 0).show();
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof PasswordFragmentListener) {
            this.mListener = (PasswordFragmentListener) context;
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
        this.mListener = (PasswordFragmentListener) null;
    }

    public void onResume() {
        super.onResume();
        if (getContext() instanceof StepsListener) {
            Context context = getContext();
            if (context != null) {
                ((StepsListener) context).onStepChanged(3);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.StepsListener");
        }
    }
}
