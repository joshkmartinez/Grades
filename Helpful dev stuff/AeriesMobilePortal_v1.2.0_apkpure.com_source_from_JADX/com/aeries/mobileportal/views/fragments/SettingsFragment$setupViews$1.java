package com.aeries.mobileportal.views.fragments;

import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/aeries/mobileportal/views/fragments/SettingsFragment$setupViews$1", "Landroid/support/design/widget/TabLayout$OnTabSelectedListener;", "(Lcom/aeries/mobileportal/views/fragments/SettingsFragment;)V", "onTabReselected", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SettingsFragment.kt */
public final class SettingsFragment$setupViews$1 implements OnTabSelectedListener {
    final /* synthetic */ SettingsFragment this$0;

    public void onTabReselected(@Nullable Tab tab) {
    }

    public void onTabUnselected(@Nullable Tab tab) {
    }

    SettingsFragment$setupViews$1(SettingsFragment settingsFragment) {
        this.this$0 = settingsFragment;
    }

    public void onTabSelected(@Nullable Tab tab) {
        Object toLowerCase;
        Object obj = null;
        if (tab != null) {
            CharSequence text = tab.getText();
            if (text != null) {
                String obj2 = text.toString();
                if (obj2 != null) {
                    if (obj2 != null) {
                        toLowerCase = obj2.toLowerCase();
                        Intrinsics.checkExpressionValueIsNotNull(toLowerCase, "(this as java.lang.String).toLowerCase()");
                        if (Intrinsics.areEqual(toLowerCase, (Object) "student")) {
                            if (tab != null) {
                                tab = tab.getText();
                                if (tab != null) {
                                    tab = tab.toString();
                                    if (tab != null) {
                                        if (tab == null) {
                                            obj = tab.toLowerCase();
                                            Intrinsics.checkExpressionValueIsNotNull(obj, "(this as java.lang.String).toLowerCase()");
                                        } else {
                                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                        }
                                    }
                                }
                            }
                            if (Intrinsics.areEqual(obj, (Object) "settings") != null) {
                                tab = this.this$0.mListener;
                                if (tab != null) {
                                    tab.onAccountSettingsOnScreen();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        tab = this.this$0.mListener;
                        if (tab != null) {
                            tab.onStudentSelectOnScreen();
                        }
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }
        toLowerCase = null;
        if (Intrinsics.areEqual(toLowerCase, (Object) "student")) {
            if (tab != null) {
                tab = tab.getText();
                if (tab != null) {
                    tab = tab.toString();
                    if (tab != null) {
                        if (tab == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        obj = tab.toLowerCase();
                        Intrinsics.checkExpressionValueIsNotNull(obj, "(this as java.lang.String).toLowerCase()");
                    }
                }
            }
            if (Intrinsics.areEqual(obj, (Object) "settings") != null) {
                tab = this.this$0.mListener;
                if (tab != null) {
                    tab.onAccountSettingsOnScreen();
                    return;
                }
                return;
            }
            return;
        }
        tab = this.this$0.mListener;
        if (tab != null) {
            tab.onStudentSelectOnScreen();
        }
    }
}
