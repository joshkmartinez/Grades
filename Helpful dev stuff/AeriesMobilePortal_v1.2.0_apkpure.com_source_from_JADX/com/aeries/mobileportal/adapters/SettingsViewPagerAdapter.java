package com.aeries.mobileportal.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.views.fragments.AccountSettingsFragment;
import com.aeries.mobileportal.views.fragments.NotificationsFragment;
import com.aeries.mobileportal.views.fragments.StudentSelectFragment;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ$\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010 \u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/adapters/SettingsViewPagerAdapter;", "Landroid/support/v4/app/FragmentPagerAdapter;", "context", "Landroid/content/Context;", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "notificationsEnabled", "", "isStudent", "(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;ZZ)V", "getContext", "()Landroid/content/Context;", "()Z", "getNotificationsEnabled", "registeredFragments", "Landroid/util/SparseArray;", "Landroid/support/v4/app/Fragment;", "getRegisteredFragments", "()Landroid/util/SparseArray;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getItem", "getPageTitle", "", "getRegisteredFragment", "instantiateItem", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SettingsViewPagerAdapter.kt */
public final class SettingsViewPagerAdapter extends FragmentPagerAdapter {
    @NotNull
    private final Context context;
    private final boolean isStudent;
    private final boolean notificationsEnabled;
    @NotNull
    private final SparseArray<Fragment> registeredFragments = new SparseArray();

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final boolean getNotificationsEnabled() {
        return this.notificationsEnabled;
    }

    public SettingsViewPagerAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
        super(fragmentManager);
        this.context = context;
        this.notificationsEnabled = z;
        this.isStudent = z2;
    }

    public final boolean isStudent() {
        return this.isStudent;
    }

    @NotNull
    public final SparseArray<Fragment> getRegisteredFragments() {
        return this.registeredFragments;
    }

    @NotNull
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                if (this.isStudent == 0) {
                    return StudentSelectFragment.Companion.newInstance();
                }
                return AccountSettingsFragment.Companion.newInstance();
            case 1:
                if (this.isStudent == 0) {
                    return AccountSettingsFragment.Companion.newInstance();
                }
                return NotificationsFragment.Companion.newInstance();
            case 2:
                return NotificationsFragment.Companion.newInstance();
            default:
                return StudentSelectFragment.Companion.newInstance();
        }
    }

    @NotNull
    public CharSequence getPageTitle(int i) {
        int i2 = C0316R.string.account_settings;
        switch (i) {
            case 0:
                if (this.isStudent == 0) {
                    i = this.context;
                    i2 = C0316R.string.change_student;
                } else {
                    i = this.context;
                }
                i = i.getString(i2);
                Intrinsics.checkExpressionValueIsNotNull(i, "if (!isStudent) context.….string.account_settings)");
                return (CharSequence) i;
            case 1:
                i = this.isStudent == 0 ? this.context.getString(C0316R.string.account_settings) : this.context.getString(C0316R.string.notifications);
                Intrinsics.checkExpressionValueIsNotNull(i, "if (!isStudent) context.…g(R.string.notifications)");
                return (CharSequence) i;
            case 2:
                i = this.context.getString(C0316R.string.notifications);
                Intrinsics.checkExpressionValueIsNotNull(i, "context.getString(R.string.notifications)");
                return (CharSequence) i;
            default:
                i = this.context.getString(C0316R.string.settings);
                Intrinsics.checkExpressionValueIsNotNull(i, "context.getString(R.string.settings)");
                return (CharSequence) i;
        }
    }

    public int getCount() {
        if (!(this.isStudent && this.notificationsEnabled)) {
            if (this.isStudent && !this.notificationsEnabled) {
                return 1;
            }
            if (!this.isStudent && this.notificationsEnabled) {
                return 3;
            }
            if (this.isStudent || this.notificationsEnabled) {
                return 1;
            }
        }
        return 2;
    }

    @NotNull
    public Object instantiateItem(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = super.instantiateItem(viewGroup, i);
        if (viewGroup != null) {
            Fragment fragment = (Fragment) viewGroup;
            this.registeredFragments.put(i, fragment);
            return fragment;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.Fragment");
    }

    public void destroyItem(@Nullable ViewGroup viewGroup, int i, @Nullable Object obj) {
        this.registeredFragments.remove(i);
        super.destroyItem(viewGroup, i, obj);
    }

    @NotNull
    public final Fragment getRegisteredFragment(int i) {
        i = this.registeredFragments.get(i);
        Intrinsics.checkExpressionValueIsNotNull(i, "registeredFragments[position]");
        return (Fragment) i;
    }
}
