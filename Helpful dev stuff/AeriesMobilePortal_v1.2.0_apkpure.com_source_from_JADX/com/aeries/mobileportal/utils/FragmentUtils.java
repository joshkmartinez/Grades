package com.aeries.mobileportal.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/FragmentUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FragmentUtils.kt */
public final class FragmentUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/utils/FragmentUtils$Companion;", "", "()V", "replaceFragment", "", "supportFragmentManager", "Landroid/support/v4/app/FragmentManager;", "id", "", "fragment", "Landroid/support/v4/app/Fragment;", "replaceFragmentBackstack", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: FragmentUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void replaceFragment(@NotNull FragmentManager fragmentManager, int i, @NotNull Fragment fragment) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "supportFragmentManager");
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            fragmentManager.beginTransaction().replace(i, fragment).commit();
        }

        public final void replaceFragmentBackstack(@NotNull FragmentManager fragmentManager, int i, @NotNull Fragment fragment) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "supportFragmentManager");
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            fragmentManager.beginTransaction().replace(i, fragment).addToBackStack(0).commit();
        }
    }
}
