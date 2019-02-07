package com.aeries.mobileportal.views.fragments;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.views.activities.AuthenticationActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u000b\u001a\u00020\u0015H\u0007J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/FingerprintDialog;", "Landroid/support/v4/app/DialogFragment;", "()V", "accountsSpinner", "Landroid/widget/Spinner;", "getAccountsSpinner", "()Landroid/widget/Spinner;", "setAccountsSpinner", "(Landroid/widget/Spinner;)V", "listener", "Lcom/aeries/mobileportal/views/fragments/FingerprintDialog$FingerprintDialogListener;", "loginWithPassword", "Landroid/widget/TextView;", "getLoginWithPassword", "()Landroid/widget/TextView;", "setLoginWithPassword", "(Landroid/widget/TextView;)V", "getAccounts", "", "", "getCredentials", "", "account", "Landroid/accounts/Account;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "setupViews", "Companion", "FingerprintDialogListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FingerprintDialog.kt */
public final class FingerprintDialog extends DialogFragment {
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361799)
    public Spinner accountsSpinner;
    private FingerprintDialogListener listener;
    @NotNull
    @BindView(2131362030)
    public TextView loginWithPassword;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/FingerprintDialog$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/FingerprintDialog;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: FingerprintDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final FingerprintDialog newInstance() {
            FingerprintDialog fingerprintDialog = new FingerprintDialog();
            fingerprintDialog.setArguments(new Bundle());
            return fingerprintDialog;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/FingerprintDialog$FingerprintDialogListener;", "", "onFingerprintVerified", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: FingerprintDialog.kt */
    public interface FingerprintDialogListener {
        void onFingerprintVerified();
    }

    @JvmStatic
    @NotNull
    public static final FingerprintDialog newInstance() {
        return Companion.newInstance();
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
    public final TextView getLoginWithPassword() {
        TextView textView = this.loginWithPassword;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginWithPassword");
        }
        return textView;
    }

    public final void setLoginWithPassword(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.loginWithPassword = textView;
    }

    @NotNull
    public final Spinner getAccountsSpinner() {
        Spinner spinner = this.accountsSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountsSpinner");
        }
        return spinner;
    }

    public final void setAccountsSpinner(@NotNull Spinner spinner) {
        Intrinsics.checkParameterIsNotNull(spinner, "<set-?>");
        this.accountsSpinner = spinner;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(C0316R.layout.dialog_fingerprint, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), 17367050, getAccounts());
        Spinner spinner = this.accountsSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountsSpinner");
        }
        spinner.setAdapter(arrayAdapter);
    }

    private final void getCredentials(Account account) {
        Object systemService = getContext().getSystemService("account");
        if (systemService != null) {
            AccountManager accountManager = (AccountManager) systemService;
            accountManager.getUserData(account, AuthenticationActivity.Companion.getUSERNAME());
            accountManager.getUserData(account, AuthenticationActivity.Companion.getDISTRICT_URL());
            accountManager.getPassword(account);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.accounts.AccountManager");
    }

    private final List<String> getAccounts() {
        Object systemService = getContext().getSystemService("account");
        if (systemService != null) {
            systemService = ((AccountManager) systemService).getAccountsByType(AuthenticationActivity.Companion.getACCOUNT_TYPE());
            Intrinsics.checkExpressionValueIsNotNull(systemService, "am.getAccountsByType(Aut…ionActivity.ACCOUNT_TYPE)");
            Collection arrayList = new ArrayList(systemService.length);
            for (Account account : systemService) {
                arrayList.add(account.name);
            }
            return (List) arrayList;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.accounts.AccountManager");
    }

    @OnClick({2131362030})
    public final void loginWithPassword() {
        dismiss();
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof FingerprintDialogListener) {
            this.listener = (FingerprintDialogListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement FingerprintDialogListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.listener = (FingerprintDialogListener) null;
    }
}
