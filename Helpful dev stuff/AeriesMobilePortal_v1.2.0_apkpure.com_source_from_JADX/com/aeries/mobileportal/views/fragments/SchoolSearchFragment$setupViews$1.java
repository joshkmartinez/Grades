package com.aeries.mobileportal.views.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragment.kt */
final class SchoolSearchFragment$setupViews$1 implements OnClickListener {
    final /* synthetic */ SchoolSearchFragment this$0;

    SchoolSearchFragment$setupViews$1(SchoolSearchFragment schoolSearchFragment) {
        this.this$0 = schoolSearchFragment;
    }

    public final void onClick(View view) {
        this.this$0.openNotFoundURL();
    }
}