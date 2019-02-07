package com.aeries.mobileportal.views.fragments;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.SearchView.OnQueryTextListener;
import com.aeries.mobileportal.utils.KeyboardUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/aeries/mobileportal/views/fragments/SchoolSearchFragment$setupViews$2", "Landroid/widget/SearchView$OnQueryTextListener;", "(Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment;)V", "onQueryTextChange", "", "newText", "", "onQueryTextSubmit", "query", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragment.kt */
public final class SchoolSearchFragment$setupViews$2 implements OnQueryTextListener {
    final /* synthetic */ SchoolSearchFragment this$0;

    public boolean onQueryTextChange(@Nullable String str) {
        return false;
    }

    SchoolSearchFragment$setupViews$2(SchoolSearchFragment schoolSearchFragment) {
        this.this$0 = schoolSearchFragment;
    }

    public boolean onQueryTextSubmit(@Nullable String str) {
        this.this$0.getPresenter().searchSchool(str);
        str = KeyboardUtils.Companion;
        FragmentActivity activity = this.this$0.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        View currentFocus = activity.getCurrentFocus();
        Intrinsics.checkExpressionValueIsNotNull(currentFocus, "activity.currentFocus");
        str.hideKeyboard(currentFocus);
        return null;
    }
}
