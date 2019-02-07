package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J(\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment;", "Landroid/support/v4/app/Fragment;", "()V", "comesFromLogin", "", "getComesFromLogin", "()Z", "setComesFromLogin", "(Z)V", "mListener", "Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment$ForgotPasswordDoneFragmentListener;", "returnToLoginButton", "Landroid/widget/Button;", "getReturnToLoginButton", "()Landroid/widget/Button;", "setReturnToLoginButton", "(Landroid/widget/Button;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onReturnToLoginPressed", "Companion", "ForgotPasswordDoneFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ForgotPasswordDoneFragment.kt */
public final class ForgotPasswordDoneFragment extends Fragment {
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String LOGIN = "LOGIN";
    private HashMap _$_findViewCache;
    private boolean comesFromLogin;
    private ForgotPasswordDoneFragmentListener mListener;
    @NotNull
    @BindView(2131362027)
    public Button returnToLoginButton;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment$Companion;", "", "()V", "LOGIN", "", "getLOGIN", "()Ljava/lang/String;", "newInstance", "Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment;", "comesFromLogin", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ForgotPasswordDoneFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getLOGIN() {
            return ForgotPasswordDoneFragment.LOGIN;
        }

        @NotNull
        public final ForgotPasswordDoneFragment newInstance(boolean z) {
            ForgotPasswordDoneFragment forgotPasswordDoneFragment = new ForgotPasswordDoneFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(getLOGIN(), z);
            forgotPasswordDoneFragment.setArguments(bundle);
            return forgotPasswordDoneFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment$ForgotPasswordDoneFragmentListener;", "", "onReturnToLoginPressed", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ForgotPasswordDoneFragment.kt */
    public interface ForgotPasswordDoneFragmentListener {
        void onReturnToLoginPressed();
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
    public final Button getReturnToLoginButton() {
        Button button = this.returnToLoginButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("returnToLoginButton");
        }
        return button;
    }

    public final void setReturnToLoginButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.returnToLoginButton = button;
    }

    public final boolean getComesFromLogin() {
        return this.comesFromLogin;
    }

    public final void setComesFromLogin(boolean z) {
        this.comesFromLogin = z;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.comesFromLogin = getArguments().getBoolean(LOGIN, false);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_forgot_password_done, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        viewGroup = this.returnToLoginButton;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("returnToLoginButton");
        }
        if (this.comesFromLogin != null) {
            bundle = C0316R.string.return_to_login;
        } else {
            int i = C0316R.string.go_home;
        }
        viewGroup.setText(getString(bundle));
        return inflate;
    }

    @OnClick({2131362027})
    public final void onReturnToLoginPressed() {
        if (this.mListener != null) {
            ForgotPasswordDoneFragmentListener forgotPasswordDoneFragmentListener = this.mListener;
            if (forgotPasswordDoneFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            forgotPasswordDoneFragmentListener.onReturnToLoginPressed();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof ForgotPasswordDoneFragmentListener) {
            this.mListener = (ForgotPasswordDoneFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement ForgotPasswordDoneFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (ForgotPasswordDoneFragmentListener) null;
    }
}
