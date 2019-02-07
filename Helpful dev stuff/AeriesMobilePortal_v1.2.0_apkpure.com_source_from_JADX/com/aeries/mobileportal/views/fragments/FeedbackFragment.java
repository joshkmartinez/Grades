package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Feedback;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0007J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J(\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/FeedbackFragment;", "Landroid/support/v4/app/Fragment;", "()V", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "comment", "Landroid/widget/EditText;", "getComment", "()Landroid/widget/EditText;", "setComment", "(Landroid/widget/EditText;)V", "emailET", "getEmailET", "setEmailET", "mEmail", "", "mListener", "Lcom/aeries/mobileportal/views/fragments/FeedbackFragment$FeedbackFragmentListener;", "unbinder", "Lbutterknife/Unbinder;", "getUnbinder", "()Lbutterknife/Unbinder;", "setUnbinder", "(Lbutterknife/Unbinder;)V", "autofillEmail", "", "defaultEmail", "onAttach", "context", "Landroid/content/Context;", "onButtonPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "setupViews", "Companion", "FeedbackFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FeedbackFragment.kt */
public final class FeedbackFragment extends Fragment {
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String EMAIL = "EMAIL";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131362057)
    public Button button;
    @NotNull
    @BindView(2131361884)
    public EditText comment;
    @NotNull
    @BindView(2131361959)
    public EditText emailET;
    private String mEmail;
    private FeedbackFragmentListener mListener;
    @NotNull
    public Unbinder unbinder;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/FeedbackFragment$Companion;", "", "()V", "EMAIL", "", "getEMAIL", "()Ljava/lang/String;", "newInstance", "Lcom/aeries/mobileportal/views/fragments/FeedbackFragment;", "email", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: FeedbackFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getEMAIL() {
            return FeedbackFragment.EMAIL;
        }

        @NotNull
        public final FeedbackFragment newInstance(@Nullable String str) {
            FeedbackFragment feedbackFragment = new FeedbackFragment();
            Bundle bundle = new Bundle();
            bundle.putString(getEMAIL(), str);
            feedbackFragment.setArguments(bundle);
            return feedbackFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/FeedbackFragment$FeedbackFragmentListener;", "", "onFragmentViewsInitialized", "", "onNextPressed", "feedback", "Lcom/aeries/mobileportal/models/Feedback;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: FeedbackFragment.kt */
    public interface FeedbackFragmentListener {
        void onFragmentViewsInitialized();

        void onNextPressed(@NotNull Feedback feedback);
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

    @NotNull
    public final Button getButton() {
        Button button = this.button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
        }
        return button;
    }

    public final void setButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.button = button;
    }

    @NotNull
    public final EditText getEmailET() {
        EditText editText = this.emailET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailET");
        }
        return editText;
    }

    public final void setEmailET(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.emailET = editText;
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
    public final Unbinder getUnbinder() {
        Unbinder unbinder = this.unbinder;
        if (unbinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unbinder");
        }
        return unbinder;
    }

    public final void setUnbinder(@NotNull Unbinder unbinder) {
        Intrinsics.checkParameterIsNotNull(unbinder, "<set-?>");
        this.unbinder = unbinder;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getArguments() != null) {
            this.mEmail = getArguments().getString(EMAIL);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_feedback, viewGroup, false);
        ButterKnife.setDebug(true);
        viewGroup = ButterKnife.bind((Object) this, inflate);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "ButterKnife.bind(this, view)");
        this.unbinder = viewGroup;
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        EditText editText = this.emailET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailET");
        }
        editText.setText(this.mEmail);
        if (this.mEmail == null) {
            FeedbackFragmentListener feedbackFragmentListener = this.mListener;
            if (feedbackFragmentListener != null) {
                feedbackFragmentListener.onFragmentViewsInitialized();
            }
        }
    }

    public void onDestroyView() {
        Unbinder unbinder = this.unbinder;
        if (unbinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unbinder");
        }
        unbinder.unbind();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @OnClick({2131362057})
    public final void onButtonPressed() {
        EditText editText = this.emailET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailET");
        }
        String obj = editText.getText().toString();
        EditText editText2 = this.comment;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comment");
        }
        Feedback feedback = new Feedback(obj, editText2.getText().toString());
        if (this.mListener != null) {
            FeedbackFragmentListener feedbackFragmentListener = this.mListener;
            if (feedbackFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            feedbackFragmentListener.onNextPressed(feedback);
        }
    }

    public final void autofillEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "defaultEmail");
        EditText editText = this.emailET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailET");
        }
        editText.setText(str);
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof FeedbackFragmentListener) {
            this.mListener = (FeedbackFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement FeedbackFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (FeedbackFragmentListener) null;
    }
}
