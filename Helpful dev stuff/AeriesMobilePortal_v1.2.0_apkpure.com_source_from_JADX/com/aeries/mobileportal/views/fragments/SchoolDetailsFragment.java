package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
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
import com.aeries.mobileportal.models.School;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020#H\u0007J\u0012\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J(\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00101\u001a\u00020#H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u00064"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SchoolDetailsFragment;", "Landroid/support/v4/app/Fragment;", "()V", "cityTV", "Landroid/widget/TextView;", "getCityTV", "()Landroid/widget/TextView;", "setCityTV", "(Landroid/widget/TextView;)V", "countyTV", "getCountyTV", "setCountyTV", "mListener", "Lcom/aeries/mobileportal/views/fragments/SchoolDetailsFragment$OnSchoolDetailsInteractionListener;", "school", "Lcom/aeries/mobileportal/models/School;", "schoolNameTV", "getSchoolNameTV", "setSchoolNameTV", "selectSchoolButton", "Landroid/widget/Button;", "getSelectSchoolButton", "()Landroid/widget/Button;", "setSelectSchoolButton", "(Landroid/widget/Button;)V", "stateTV", "getStateTV", "setStateTV", "streetTV", "getStreetTV", "setStreetTV", "zipCodeTV", "getZipCodeTV", "setZipCodeTV", "initializeViews", "", "onAttach", "context", "Landroid/content/Context;", "onButtonPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "Companion", "OnSchoolDetailsInteractionListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolDetailsFragment.kt */
public final class SchoolDetailsFragment extends Fragment {
    public static final Companion Companion = new Companion();
    private static final String SCHOOL = "school";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361879)
    public TextView cityTV;
    @NotNull
    @BindView(2131361894)
    public TextView countyTV;
    private OnSchoolDetailsInteractionListener mListener;
    private School school;
    @NotNull
    @BindView(2131362119)
    public TextView schoolNameTV;
    @NotNull
    @BindView(2131362145)
    public Button selectSchoolButton;
    @NotNull
    @BindView(2131362168)
    public TextView stateTV;
    @NotNull
    @BindView(2131362170)
    public TextView streetTV;
    @NotNull
    @BindView(2131362292)
    public TextView zipCodeTV;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SchoolDetailsFragment$Companion;", "", "()V", "SCHOOL", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/SchoolDetailsFragment;", "school", "Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SchoolDetailsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SchoolDetailsFragment newInstance(@NotNull School school) {
            Intrinsics.checkParameterIsNotNull(school, SchoolDetailsFragment.SCHOOL);
            SchoolDetailsFragment schoolDetailsFragment = new SchoolDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SchoolDetailsFragment.SCHOOL, school);
            schoolDetailsFragment.setArguments(bundle);
            return schoolDetailsFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SchoolDetailsFragment$OnSchoolDetailsInteractionListener;", "", "checkSchoolAppStatus", "", "school", "Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SchoolDetailsFragment.kt */
    public interface OnSchoolDetailsInteractionListener {
        void checkSchoolAppStatus(@NotNull School school);
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
    public final TextView getSchoolNameTV() {
        TextView textView = this.schoolNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
        }
        return textView;
    }

    public final void setSchoolNameTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.schoolNameTV = textView;
    }

    @NotNull
    public final TextView getCountyTV() {
        TextView textView = this.countyTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countyTV");
        }
        return textView;
    }

    public final void setCountyTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.countyTV = textView;
    }

    @NotNull
    public final TextView getStreetTV() {
        TextView textView = this.streetTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("streetTV");
        }
        return textView;
    }

    public final void setStreetTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.streetTV = textView;
    }

    @NotNull
    public final TextView getCityTV() {
        TextView textView = this.cityTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cityTV");
        }
        return textView;
    }

    public final void setCityTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.cityTV = textView;
    }

    @NotNull
    public final TextView getZipCodeTV() {
        TextView textView = this.zipCodeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zipCodeTV");
        }
        return textView;
    }

    public final void setZipCodeTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.zipCodeTV = textView;
    }

    @NotNull
    public final TextView getStateTV() {
        TextView textView = this.stateTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateTV");
        }
        return textView;
    }

    public final void setStateTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.stateTV = textView;
    }

    @NotNull
    public final Button getSelectSchoolButton() {
        Button button = this.selectSchoolButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectSchoolButton");
        }
        return button;
    }

    public final void setSelectSchoolButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.selectSchoolButton = button;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            bundle = getArguments().getParcelable(SCHOOL);
            Intrinsics.checkExpressionValueIsNotNull(bundle, "arguments.getParcelable(SCHOOL)");
            this.school = (School) bundle;
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_school_details, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        initializeViews();
        return inflate;
    }

    private final void initializeViews() {
        TextView textView = this.schoolNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
        }
        School school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SCHOOL);
        }
        textView.setText(school.getSchoolName());
        textView = this.countyTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countyTV");
        }
        school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SCHOOL);
        }
        textView.setText(school.getCounty());
        textView = this.streetTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("streetTV");
        }
        school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SCHOOL);
        }
        textView.setText(school.getStreetAddress());
        textView = this.cityTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cityTV");
        }
        school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SCHOOL);
        }
        textView.setText(school.getCity());
        textView = this.zipCodeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zipCodeTV");
        }
        school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SCHOOL);
        }
        textView.setText(school.getZipCode());
        textView = this.stateTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateTV");
        }
        school = this.school;
        if (school == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SCHOOL);
        }
        textView.setText(school.getState());
    }

    @OnClick({2131362145})
    public final void onButtonPressed() {
        if (this.mListener != null) {
            OnSchoolDetailsInteractionListener onSchoolDetailsInteractionListener = this.mListener;
            if (onSchoolDetailsInteractionListener == null) {
                Intrinsics.throwNpe();
            }
            School school = this.school;
            if (school == null) {
                Intrinsics.throwUninitializedPropertyAccessException(SCHOOL);
            }
            onSchoolDetailsInteractionListener.checkSchoolAppStatus(school);
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof OnSchoolDetailsInteractionListener) {
            this.mListener = (OnSchoolDetailsInteractionListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnSchoolDetailsInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (OnSchoolDetailsInteractionListener) null;
    }
}
