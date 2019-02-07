package com.aeries.mobileportal.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0007J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0007J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006'"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/WhatIfModeFragment;", "Landroid/support/v4/app/DialogFragment;", "()V", "expectedScore", "Landroid/widget/TextView;", "getExpectedScore", "()Landroid/widget/TextView;", "setExpectedScore", "(Landroid/widget/TextView;)V", "gradeSlider", "Landroid/widget/SeekBar;", "getGradeSlider", "()Landroid/widget/SeekBar;", "setGradeSlider", "(Landroid/widget/SeekBar;)V", "listener", "Lcom/aeries/mobileportal/views/fragments/WhatIfModeFragment$WhatIfModeFragmentListener;", "resetScore", "getResetScore", "setResetScore", "onAttach", "", "context", "Landroid/content/Context;", "onButtonPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onResetScore", "onResume", "setupViews", "Companion", "WhatIfModeFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: WhatIfModeFragment.kt */
public final class WhatIfModeFragment extends DialogFragment {
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361957)
    public TextView expectedScore;
    @NotNull
    @BindView(2131361978)
    public SeekBar gradeSlider;
    private WhatIfModeFragmentListener listener;
    @NotNull
    @BindView(2131362109)
    public TextView resetScore;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/WhatIfModeFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/WhatIfModeFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: WhatIfModeFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final WhatIfModeFragment newInstance() {
            WhatIfModeFragment whatIfModeFragment = new WhatIfModeFragment();
            whatIfModeFragment.setArguments(new Bundle());
            return whatIfModeFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/WhatIfModeFragment$WhatIfModeFragmentListener;", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: WhatIfModeFragment.kt */
    public interface WhatIfModeFragmentListener {
    }

    @JvmStatic
    @NotNull
    public static final WhatIfModeFragment newInstance() {
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
    public final SeekBar getGradeSlider() {
        SeekBar seekBar = this.gradeSlider;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSlider");
        }
        return seekBar;
    }

    public final void setGradeSlider(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "<set-?>");
        this.gradeSlider = seekBar;
    }

    @NotNull
    public final TextView getExpectedScore() {
        TextView textView = this.expectedScore;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expectedScore");
        }
        return textView;
    }

    public final void setExpectedScore(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.expectedScore = textView;
    }

    @NotNull
    public final TextView getResetScore() {
        TextView textView = this.resetScore;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetScore");
        }
        return textView;
    }

    public final void setResetScore(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.resetScore = textView;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_what_if_mode, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog");
        dialog.getWindow().setLayout(-1, -2);
        dialog = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog");
        dialog.getWindow().setGravity(17);
    }

    private final void setupViews() {
        TextView textView = this.expectedScore;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expectedScore");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getContext().getString(C0316R.string.grade_score_placeholder);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.stri….grade_score_placeholder)");
        Object[] objArr = new Object[2];
        SeekBar seekBar = this.gradeSlider;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSlider");
        }
        objArr[0] = Integer.valueOf(seekBar.getProgress());
        seekBar = this.gradeSlider;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSlider");
        }
        objArr[1] = Integer.valueOf(seekBar.getMax());
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        textView.setText(string);
        SeekBar seekBar2 = this.gradeSlider;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSlider");
        }
        seekBar2.setOnSeekBarChangeListener(new WhatIfModeFragment$setupViews$1(this));
    }

    @OnClick({2131362109})
    public final void onResetScore() {
        SeekBar seekBar = this.gradeSlider;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSlider");
        }
        seekBar.setProgress(3);
    }

    @OnClick({2131361892})
    public final void onButtonPressed() {
        dismiss();
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof WhatIfModeFragmentListener) {
            this.listener = (WhatIfModeFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement WhatIfModeFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.listener = (WhatIfModeFragmentListener) null;
    }
}
