package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J(\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0007J\b\u0010&\u001a\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006)"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/LinkStudentInfoFragment;", "Landroid/support/v4/app/Fragment;", "()V", "mListener", "Lcom/aeries/mobileportal/views/fragments/LinkStudentInfoFragment$LinkStudentInfoFragmentListener;", "nextButton", "Landroid/widget/Button;", "getNextButton", "()Landroid/widget/Button;", "setNextButton", "(Landroid/widget/Button;)V", "studentId", "Landroid/support/design/widget/TextInputEditText;", "getStudentId", "()Landroid/support/design/widget/TextInputEditText;", "setStudentId", "(Landroid/support/design/widget/TextInputEditText;)V", "studentPhone", "getStudentPhone", "setStudentPhone", "verificationCode", "getVerificationCode", "setVerificationCode", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onNextPressed", "setupViews", "Companion", "LinkStudentInfoFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkStudentInfoFragment.kt */
public final class LinkStudentInfoFragment extends Fragment {
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    private LinkStudentInfoFragmentListener mListener;
    @NotNull
    @BindView(2131362058)
    public Button nextButton;
    @NotNull
    @BindView(2131362172)
    public TextInputEditText studentId;
    @NotNull
    @BindView(2131362174)
    public TextInputEditText studentPhone;
    @NotNull
    @BindView(2131362275)
    public TextInputEditText verificationCode;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/LinkStudentInfoFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/LinkStudentInfoFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LinkStudentInfoFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final LinkStudentInfoFragment newInstance() {
            LinkStudentInfoFragment linkStudentInfoFragment = new LinkStudentInfoFragment();
            linkStudentInfoFragment.setArguments(new Bundle());
            return linkStudentInfoFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/LinkStudentInfoFragment$LinkStudentInfoFragmentListener;", "", "onLinkStudentInfoSubmitted", "", "studentId", "", "studentPhone", "verificationCode", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LinkStudentInfoFragment.kt */
    public interface LinkStudentInfoFragmentListener {
        void onLinkStudentInfoSubmitted(@NotNull String str, @NotNull String str2, @NotNull String str3);
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
    public final TextInputEditText getStudentId() {
        TextInputEditText textInputEditText = this.studentId;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentId");
        }
        return textInputEditText;
    }

    public final void setStudentId(@NotNull TextInputEditText textInputEditText) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "<set-?>");
        this.studentId = textInputEditText;
    }

    @NotNull
    public final TextInputEditText getStudentPhone() {
        TextInputEditText textInputEditText = this.studentPhone;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentPhone");
        }
        return textInputEditText;
    }

    public final void setStudentPhone(@NotNull TextInputEditText textInputEditText) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "<set-?>");
        this.studentPhone = textInputEditText;
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
        bundle = getArguments();
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_link_student_info, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    @OnClick({2131362058})
    public final void onNextPressed() {
        if (this.mListener != null) {
            LinkStudentInfoFragmentListener linkStudentInfoFragmentListener = this.mListener;
            if (linkStudentInfoFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            TextInputEditText textInputEditText = this.studentId;
            if (textInputEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studentId");
            }
            String obj = textInputEditText.getText().toString();
            TextInputEditText textInputEditText2 = this.studentPhone;
            if (textInputEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studentPhone");
            }
            String obj2 = textInputEditText2.getText().toString();
            TextInputEditText textInputEditText3 = this.verificationCode;
            if (textInputEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verificationCode");
            }
            linkStudentInfoFragmentListener.onLinkStudentInfoSubmitted(obj, obj2, textInputEditText3.getText().toString());
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof LinkStudentInfoFragmentListener) {
            this.mListener = (LinkStudentInfoFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement LinkStudentInfoFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (LinkStudentInfoFragmentListener) null;
    }
}
