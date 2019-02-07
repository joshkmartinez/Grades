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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J(\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0007R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ThankYouFragment;", "Landroid/support/v4/app/Fragment;", "()V", "home", "Landroid/widget/Button;", "getHome", "()Landroid/widget/Button;", "setHome", "(Landroid/widget/Button;)V", "mListener", "Lcom/aeries/mobileportal/views/fragments/ThankYouFragment$ThankYouFragmentListener;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onHomePressed", "Companion", "ThankYouFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ThankYouFragment.kt */
public final class ThankYouFragment extends Fragment {
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361987)
    public Button home;
    private ThankYouFragmentListener mListener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ThankYouFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/ThankYouFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ThankYouFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ThankYouFragment newInstance() {
            ThankYouFragment thankYouFragment = new ThankYouFragment();
            thankYouFragment.setArguments(new Bundle());
            return thankYouFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ThankYouFragment$ThankYouFragmentListener;", "", "onHomePressed", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ThankYouFragment.kt */
    public interface ThankYouFragmentListener {
        void onHomePressed();
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
    public final Button getHome() {
        Button button = this.home;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("home");
        }
        return button;
    }

    public final void setHome(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.home = button;
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
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_thank_you, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    @OnClick({2131361987})
    public final void onHomePressed() {
        if (this.mListener != null) {
            ThankYouFragmentListener thankYouFragmentListener = this.mListener;
            if (thankYouFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            thankYouFragmentListener.onHomePressed();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof ThankYouFragmentListener) {
            this.mListener = (ThankYouFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement ThankYouFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (ThankYouFragmentListener) null;
    }
}
