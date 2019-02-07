package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 42\u00020\u0001:\u000245B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J(\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0007J\b\u0010-\u001a\u00020\u001fH\u0007J\b\u0010.\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0007J\u0006\u00100\u001a\u00020\u001fJ\u0006\u00101\u001a\u00020\u001fJ\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\u001d¨\u00066"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment;", "Landroid/support/v4/app/Fragment;", "()V", "USER_PARENT", "", "getUSER_PARENT", "()Ljava/lang/String;", "USER_STUDENT", "getUSER_STUDENT", "mListener", "Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment$UserTypeFragmentListener;", "nextButton", "Landroid/widget/Button;", "getNextButton", "()Landroid/widget/Button;", "setNextButton", "(Landroid/widget/Button;)V", "parentButton", "Landroid/widget/ImageView;", "getParentButton", "()Landroid/widget/ImageView;", "setParentButton", "(Landroid/widget/ImageView;)V", "studentButton", "getStudentButton", "setStudentButton", "valueSelected", "getValueSelected", "setValueSelected", "(Ljava/lang/String;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onNextPressed", "onParentPressed", "onResume", "onStudentPressed", "setParentGuardianChecked", "setParentGuardianUnchecked", "setStudentChecked", "setStudentUnchecked", "Companion", "UserTypeFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: UserTypeSelectFragment.kt */
public final class UserTypeSelectFragment extends Fragment {
    public static final Companion Companion = new Companion();
    @NotNull
    private final String USER_PARENT = "Parent";
    @NotNull
    private final String USER_STUDENT = "Student";
    private HashMap _$_findViewCache;
    private UserTypeFragmentListener mListener;
    @NotNull
    @BindView(2131362058)
    public Button nextButton;
    @NotNull
    @BindView(2131362085)
    public ImageView parentButton;
    @NotNull
    @BindView(2131362173)
    public ImageView studentButton;
    @NotNull
    public String valueSelected;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: UserTypeSelectFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final UserTypeSelectFragment newInstance() {
            UserTypeSelectFragment userTypeSelectFragment = new UserTypeSelectFragment();
            userTypeSelectFragment.setArguments(new Bundle());
            return userTypeSelectFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/UserTypeSelectFragment$UserTypeFragmentListener;", "", "onUserTypeSelected", "", "userType", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: UserTypeSelectFragment.kt */
    public interface UserTypeFragmentListener {
        void onUserTypeSelected(@NotNull String str);
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
    public final ImageView getStudentButton() {
        ImageView imageView = this.studentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentButton");
        }
        return imageView;
    }

    public final void setStudentButton(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.studentButton = imageView;
    }

    @NotNull
    public final ImageView getParentButton() {
        ImageView imageView = this.parentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentButton");
        }
        return imageView;
    }

    public final void setParentButton(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.parentButton = imageView;
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
    public final String getValueSelected() {
        String str = this.valueSelected;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueSelected");
        }
        return str;
    }

    public final void setValueSelected(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.valueSelected = str;
    }

    @NotNull
    public final String getUSER_STUDENT() {
        return this.USER_STUDENT;
    }

    @NotNull
    public final String getUSER_PARENT() {
        return this.USER_PARENT;
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
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_user_type_select, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    @OnClick({2131362173})
    public final void onStudentPressed() {
        setStudentChecked();
        setParentGuardianUnchecked();
        Button button = this.nextButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        button.setEnabled(true);
        this.valueSelected = this.USER_STUDENT;
    }

    @OnClick({2131362085})
    public final void onParentPressed() {
        setParentGuardianChecked();
        setStudentUnchecked();
        Button button = this.nextButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        button.setEnabled(true);
        this.valueSelected = this.USER_PARENT;
    }

    @OnClick({2131362058})
    public final void onNextPressed() {
        if (this.mListener != null) {
            UserTypeFragmentListener userTypeFragmentListener = this.mListener;
            if (userTypeFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            String str = this.valueSelected;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueSelected");
            }
            userTypeFragmentListener.onUserTypeSelected(str);
        }
    }

    public final void setStudentChecked() {
        ImageView imageView = this.studentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentButton");
        }
        imageView.setImageResource(C0316R.drawable.select_student_checked);
        imageView = this.studentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentButton");
        }
        imageView.setAlpha(1.0f);
    }

    public final void setStudentUnchecked() {
        ImageView imageView = this.studentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentButton");
        }
        imageView.setImageResource(C0316R.drawable.select_student_unchecked);
        imageView = this.studentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentButton");
        }
        imageView.setAlpha(0.6f);
    }

    public final void setParentGuardianChecked() {
        ImageView imageView = this.parentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentButton");
        }
        imageView.setImageResource(C0316R.drawable.select_parent_guardian_checked);
        imageView = this.parentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentButton");
        }
        imageView.setAlpha(1.0f);
    }

    public final void setParentGuardianUnchecked() {
        ImageView imageView = this.parentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentButton");
        }
        imageView.setImageResource(C0316R.drawable.select_parent_guardian_unchecked);
        imageView = this.parentButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentButton");
        }
        imageView.setAlpha(0.6f);
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof UserTypeFragmentListener) {
            this.mListener = (UserTypeFragmentListener) context;
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
        this.mListener = (UserTypeFragmentListener) null;
    }

    public void onResume() {
        super.onResume();
        if (getContext() instanceof StepsListener) {
            Context context = getContext();
            if (context != null) {
                ((StepsListener) context).onStepChanged(1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.StepsListener");
        }
    }
}
