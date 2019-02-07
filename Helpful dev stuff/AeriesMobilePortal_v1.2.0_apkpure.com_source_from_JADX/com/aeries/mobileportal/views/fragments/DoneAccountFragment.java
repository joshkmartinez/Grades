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
import com.aeries.mobileportal.StepsListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J(\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0007J\b\u0010\u001a\u001a\u00020\fH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment;", "Landroid/support/v4/app/Fragment;", "()V", "loginButton", "Landroid/widget/Button;", "getLoginButton", "()Landroid/widget/Button;", "setLoginButton", "(Landroid/widget/Button;)V", "mListener", "Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment$DoneAccountFragmentListener;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onGoToLoginPressed", "onResume", "Companion", "DoneAccountFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DoneAccountFragment.kt */
public final class DoneAccountFragment extends Fragment {
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131362027)
    public Button loginButton;
    private DoneAccountFragmentListener mListener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DoneAccountFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DoneAccountFragment newInstance() {
            DoneAccountFragment doneAccountFragment = new DoneAccountFragment();
            doneAccountFragment.setArguments(new Bundle());
            return doneAccountFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DoneAccountFragment$DoneAccountFragmentListener;", "", "onGoToLoginPressed", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DoneAccountFragment.kt */
    public interface DoneAccountFragmentListener {
        void onGoToLoginPressed();
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

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_done_account, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    @OnClick({2131362027})
    public final void onGoToLoginPressed() {
        if (this.mListener != null) {
            DoneAccountFragmentListener doneAccountFragmentListener = this.mListener;
            if (doneAccountFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            doneAccountFragmentListener.onGoToLoginPressed();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof DoneAccountFragmentListener) {
            this.mListener = (DoneAccountFragmentListener) context;
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
        this.mListener = (DoneAccountFragmentListener) null;
    }

    public void onResume() {
        super.onResume();
        if (getContext() instanceof StepsListener) {
            Context context = getContext();
            if (context != null) {
                ((StepsListener) context).onStepChanged(5);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.StepsListener");
        }
    }
}
