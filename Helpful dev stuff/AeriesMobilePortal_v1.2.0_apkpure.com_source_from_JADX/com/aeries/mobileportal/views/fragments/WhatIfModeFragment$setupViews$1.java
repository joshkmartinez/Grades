package com.aeries.mobileportal.views.fragments;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.aeries.mobileportal.C0316R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"com/aeries/mobileportal/views/fragments/WhatIfModeFragment$setupViews$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "(Lcom/aeries/mobileportal/views/fragments/WhatIfModeFragment;)V", "onProgressChanged", "", "p0", "Landroid/widget/SeekBar;", "p1", "", "p2", "", "onStartTrackingTouch", "onStopTrackingTouch", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: WhatIfModeFragment.kt */
public final class WhatIfModeFragment$setupViews$1 implements OnSeekBarChangeListener {
    final /* synthetic */ WhatIfModeFragment this$0;

    public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
    }

    public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
    }

    WhatIfModeFragment$setupViews$1(WhatIfModeFragment whatIfModeFragment) {
        this.this$0 = whatIfModeFragment;
    }

    public void onProgressChanged(@Nullable SeekBar seekBar, int i, boolean z) {
        i = this.this$0.getExpectedScore();
        z = StringCompanionObject.INSTANCE;
        z = this.this$0.getContext().getString(C0316R.string.grade_score_placeholder);
        Intrinsics.checkExpressionValueIsNotNull(z, "context.getString(R.stri….grade_score_placeholder)");
        Object[] objArr = new Object[2];
        objArr[0] = seekBar != null ? Integer.valueOf(seekBar.getProgress()) : null;
        objArr[1] = Integer.valueOf(this.this$0.getGradeSlider().getMax());
        seekBar = String.format(z, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(seekBar, "java.lang.String.format(format, *args)");
        i.setText((CharSequence) seekBar);
    }
}
