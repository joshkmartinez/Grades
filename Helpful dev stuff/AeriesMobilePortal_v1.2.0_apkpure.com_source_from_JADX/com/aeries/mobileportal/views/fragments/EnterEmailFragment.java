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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.StepsListener;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.utils.AccountCreationUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J(\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\u001aH\u0007J\b\u0010(\u001a\u00020\u001aH\u0016J\b\u0010)\u001a\u00020\u001aH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment;", "Landroid/support/v4/app/Fragment;", "()V", "email", "Landroid/support/design/widget/TextInputEditText;", "getEmail", "()Landroid/support/design/widget/TextInputEditText;", "setEmail", "(Landroid/support/design/widget/TextInputEditText;)V", "enterEmailText", "Landroid/widget/TextView;", "getEnterEmailText", "()Landroid/widget/TextView;", "setEnterEmailText", "(Landroid/widget/TextView;)V", "mListener", "Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment$EnterEmailFragmentListener;", "mUserType", "", "nextButton", "Landroid/widget/Button;", "getNextButton", "()Landroid/widget/Button;", "setNextButton", "(Landroid/widget/Button;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onNextPressed", "onResume", "setupViews", "Companion", "EnterEmailFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: EnterEmailFragment.kt */
public final class EnterEmailFragment extends Fragment {
    public static final Companion Companion = new Companion();
    private static final String USER_TYPE = "USER_TYPE";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361945)
    public TextInputEditText email;
    @NotNull
    @BindView(2131361952)
    public TextView enterEmailText;
    private EnterEmailFragmentListener mListener;
    private String mUserType;
    @NotNull
    @BindView(2131362058)
    public Button nextButton;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment$Companion;", "", "()V", "USER_TYPE", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment;", "userType", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: EnterEmailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EnterEmailFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "userType");
            EnterEmailFragment enterEmailFragment = new EnterEmailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(EnterEmailFragment.USER_TYPE, str);
            enterEmailFragment.setArguments(bundle);
            return enterEmailFragment;
        }

        @NotNull
        public final EnterEmailFragment newInstance() {
            EnterEmailFragment enterEmailFragment = new EnterEmailFragment();
            enterEmailFragment.setArguments(new Bundle());
            return enterEmailFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment$EnterEmailFragmentListener;", "", "onDataSubmitted", "", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: EnterEmailFragment.kt */
    public interface EnterEmailFragmentListener {
        void onDataSubmitted(@NotNull AccountTakenRequest accountTakenRequest);
    }

    private final void setupViews() {
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
    public final TextInputEditText getEmail() {
        TextInputEditText textInputEditText = this.email;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
        }
        return textInputEditText;
    }

    public final void setEmail(@NotNull TextInputEditText textInputEditText) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "<set-?>");
        this.email = textInputEditText;
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
    public final TextView getEnterEmailText() {
        TextView textView = this.enterEmailText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterEmailText");
        }
        return textView;
    }

    public final void setEnterEmailText(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.enterEmailText = textView;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mUserType = getArguments().getString(USER_TYPE);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_enter_email, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    @OnClick({2131362058})
    public final void onNextPressed() {
        TextInputEditText textInputEditText = this.email;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
        }
        String obj = textInputEditText.getText().toString();
        TextView textView;
        if ((((CharSequence) obj).length() == 0 ? 1 : 0) != 0) {
            textView = this.enterEmailText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("enterEmailText");
            }
            textView.setText(getText(C0316R.string.enter_email_to_continue));
            textView = this.enterEmailText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("enterEmailText");
            }
            textView.setVisibility(0);
        } else if (AccountCreationUtils.Companion.checkValidEmail(obj)) {
            textView = this.enterEmailText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("enterEmailText");
            }
            textView.setVisibility(8);
            if (this.mListener != null) {
                TextInputEditText textInputEditText2 = this.email;
                if (textInputEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("email");
                }
                AccountTakenRequest accountTakenRequest = new AccountTakenRequest(textInputEditText2.getText().toString(), "");
                if (this.mUserType != null) {
                    String str = this.mUserType;
                    if (str == null) {
                        Intrinsics.throwNpe();
                    }
                    accountTakenRequest.setAccountType(str);
                }
                EnterEmailFragmentListener enterEmailFragmentListener = this.mListener;
                if (enterEmailFragmentListener == null) {
                    Intrinsics.throwNpe();
                }
                enterEmailFragmentListener.onDataSubmitted(accountTakenRequest);
            }
        } else {
            textView = this.enterEmailText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("enterEmailText");
            }
            textView.setText(getText(C0316R.string.not_valid_email));
            textView = this.enterEmailText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("enterEmailText");
            }
            textView.setVisibility(0);
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof EnterEmailFragmentListener) {
            this.mListener = (EnterEmailFragmentListener) context;
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
        this.mListener = (EnterEmailFragmentListener) null;
    }

    public void onResume() {
        super.onResume();
        if (getContext() instanceof StepsListener) {
            Context context = getContext();
            if (context != null) {
                ((StepsListener) context).onStepChanged(2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.StepsListener");
        }
    }
}
