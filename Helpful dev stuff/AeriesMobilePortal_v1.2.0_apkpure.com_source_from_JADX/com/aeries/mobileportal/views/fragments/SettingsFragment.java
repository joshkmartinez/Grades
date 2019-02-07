package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.SettingsViewPagerAdapter;
import com.aeries.mobileportal.dagger.components.SettingsFragmentComponent;
import com.aeries.mobileportal.presenters.settings.SettingsPresenter;
import com.aeries.mobileportal.views.custom.BadgedTab;
import com.aeries.mobileportal.views.viewmodels.settings.SettingsViewModel;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002DEB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u000206H\u0016J\u0012\u00109\u001a\u0002062\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J(\u0010<\u001a\u0004\u0018\u00010\u00182\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010A\u001a\u000206H\u0016J\b\u0010B\u001a\u000206H\u0016J\b\u0010C\u001a\u000206H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006F"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SettingsFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/views/viewmodels/settings/SettingsViewModel;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/SettingsViewPagerAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/SettingsViewPagerAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/SettingsViewPagerAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/SettingsFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/SettingsFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "mListener", "Lcom/aeries/mobileportal/views/fragments/SettingsFragment$SettingsFragmentListener;", "mNotificationsEnabled", "", "mOpenNotifications", "mUserType", "", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "presenter", "Lcom/aeries/mobileportal/presenters/settings/SettingsPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/settings/SettingsPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/settings/SettingsPresenter;)V", "tabLayout", "Landroid/support/design/widget/TabLayout;", "getTabLayout", "()Landroid/support/design/widget/TabLayout;", "setTabLayout", "(Landroid/support/design/widget/TabLayout;)V", "unbinder", "Lbutterknife/Unbinder;", "getUnbinder", "()Lbutterknife/Unbinder;", "setUnbinder", "(Lbutterknife/Unbinder;)V", "viewPager", "Landroid/support/v4/view/ViewPager;", "getViewPager", "()Landroid/support/v4/view/ViewPager;", "setViewPager", "(Landroid/support/v4/view/ViewPager;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "setupViews", "Companion", "SettingsFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SettingsFragment.kt */
public final class SettingsFragment extends Fragment implements SettingsViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SettingsFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/SettingsFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String NOTIFICATIONS = "NOTIFICATIONS";
    @NotNull
    private static final String OPEN_NOTIFICATIONS = "OPEN_NOTIFICATIONS";
    @NotNull
    private static final String SETTINGS = "SETTINGS";
    @NotNull
    private static final String STUDENTS = "STUDENTS";
    @NotNull
    private static final String USER_TYPE = "USER_TYPE";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public SettingsViewPagerAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new SettingsFragment$component$2(this));
    private SettingsFragmentListener mListener;
    private boolean mNotificationsEnabled;
    private boolean mOpenNotifications;
    private String mUserType = "Parent";
    @Nullable
    private View mView;
    @Inject
    @NotNull
    public SettingsPresenter presenter;
    @NotNull
    @BindView(2131362182)
    public TabLayout tabLayout;
    @Nullable
    private Unbinder unbinder;
    @NotNull
    @BindView(2131362278)
    public ViewPager viewPager;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SettingsFragment$Companion;", "", "()V", "NOTIFICATIONS", "", "getNOTIFICATIONS", "()Ljava/lang/String;", "OPEN_NOTIFICATIONS", "getOPEN_NOTIFICATIONS", "SETTINGS", "getSETTINGS", "STUDENTS", "getSTUDENTS", "USER_TYPE", "getUSER_TYPE", "newInstance", "Lcom/aeries/mobileportal/views/fragments/SettingsFragment;", "userType", "notificationsEnabled", "", "openNotifications", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getUSER_TYPE() {
            return SettingsFragment.USER_TYPE;
        }

        @NotNull
        public final String getSETTINGS() {
            return SettingsFragment.SETTINGS;
        }

        @NotNull
        public final String getSTUDENTS() {
            return SettingsFragment.STUDENTS;
        }

        @NotNull
        public final String getNOTIFICATIONS() {
            return SettingsFragment.NOTIFICATIONS;
        }

        @NotNull
        public final String getOPEN_NOTIFICATIONS() {
            return SettingsFragment.OPEN_NOTIFICATIONS;
        }

        @NotNull
        public final SettingsFragment newInstance(@NotNull String str, boolean z, boolean z2) {
            Intrinsics.checkParameterIsNotNull(str, "userType");
            SettingsFragment settingsFragment = new SettingsFragment();
            Bundle bundle = new Bundle();
            Companion companion = this;
            bundle.putString(getUSER_TYPE(), str);
            bundle.putBoolean(getNOTIFICATIONS(), z);
            bundle.putBoolean(getOPEN_NOTIFICATIONS(), z2);
            settingsFragment.setArguments(bundle);
            return settingsFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SettingsFragment$SettingsFragmentListener;", "", "close", "", "onAccountSettingsOnScreen", "onStudentSelectOnScreen", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SettingsFragment.kt */
    public interface SettingsFragmentListener {
        void close();

        void onAccountSettingsOnScreen();

        void onStudentSelectOnScreen();
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
    public final SettingsFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (SettingsFragmentComponent) lazy.getValue();
    }

    public void onCreate() {
    }

    @NotNull
    public final TabLayout getTabLayout() {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return tabLayout;
    }

    public final void setTabLayout(@NotNull TabLayout tabLayout) {
        Intrinsics.checkParameterIsNotNull(tabLayout, "<set-?>");
        this.tabLayout = tabLayout;
    }

    @NotNull
    public final ViewPager getViewPager() {
        ViewPager viewPager = this.viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager;
    }

    public final void setViewPager(@NotNull ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "<set-?>");
        this.viewPager = viewPager;
    }

    @Nullable
    public final View getMView() {
        return this.mView;
    }

    public final void setMView(@Nullable View view) {
        this.mView = view;
    }

    @Nullable
    public final Unbinder getUnbinder() {
        return this.unbinder;
    }

    public final void setUnbinder(@Nullable Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @NotNull
    public final SettingsViewPagerAdapter getAdapter() {
        SettingsViewPagerAdapter settingsViewPagerAdapter = this.adapter;
        if (settingsViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return settingsViewPagerAdapter;
    }

    public final void setAdapter(@NotNull SettingsViewPagerAdapter settingsViewPagerAdapter) {
        Intrinsics.checkParameterIsNotNull(settingsViewPagerAdapter, "<set-?>");
        this.adapter = settingsViewPagerAdapter;
    }

    @NotNull
    public final SettingsPresenter getPresenter() {
        SettingsPresenter settingsPresenter = this.presenter;
        if (settingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return settingsPresenter;
    }

    public final void setPresenter(@NotNull SettingsPresenter settingsPresenter) {
        Intrinsics.checkParameterIsNotNull(settingsPresenter, "<set-?>");
        this.presenter = settingsPresenter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            bundle = getArguments().getString(USER_TYPE);
            Intrinsics.checkExpressionValueIsNotNull(bundle, "arguments.getString(USER_TYPE)");
            this.mUserType = bundle;
            this.mNotificationsEnabled = getArguments().getBoolean(NOTIFICATIONS, false);
            this.mOpenNotifications = getArguments().getBoolean(OPEN_NOTIFICATIONS, false);
        }
        getComponent().inject(this);
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        this.mView = layoutInflater.inflate(C0316R.layout.fragment_settings, viewGroup, false);
        View view = this.mView;
        if (view == null) {
            Intrinsics.throwNpe();
        }
        this.unbinder = ButterKnife.bind((Object) this, view);
        setupViews();
        layoutInflater = this.mView;
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        return layoutInflater;
    }

    private final void setupViews() {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout.addOnTabSelectedListener(new SettingsFragment$setupViews$1(this));
        ViewPager viewPager = this.viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        SettingsViewPagerAdapter settingsViewPagerAdapter = this.adapter;
        if (settingsViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        viewPager.setAdapter(settingsViewPagerAdapter);
        tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        tabLayout.setupWithViewPager(viewPager2);
        if (this.mNotificationsEnabled) {
            TabLayout tabLayout2;
            BadgedTab badgedTab = new BadgedTab(getContext());
            badgedTab.setTitle((int) C0316R.string.notifications);
            SettingsPresenter settingsPresenter = this.presenter;
            if (settingsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            badgedTab.setBadgeNumber(settingsPresenter.getNotificationsSize());
            tabLayout2 = this.tabLayout;
            if (tabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            TabLayout tabLayout3 = this.tabLayout;
            if (tabLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            tabLayout2.removeTabAt(tabLayout3.getTabCount() - 1);
            tabLayout2 = this.tabLayout;
            if (tabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            tabLayout3 = this.tabLayout;
            if (tabLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            Tab newTab = tabLayout3.newTab();
            newTab.setCustomView((View) badgedTab);
            tabLayout2.addTab(newTab);
            LocalBroadcastManager.getInstance(getContext()).registerReceiver(new SettingsFragment$setupViews$3(badgedTab), new IntentFilter(NotificationsFragment.Companion.getACTION_NOTIFICATION_CHANGE()));
        }
        if (this.mOpenNotifications && this.mNotificationsEnabled) {
            tabLayout = this.tabLayout;
            if (tabLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            tabLayout2 = this.tabLayout;
            if (tabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            Tab tabAt = tabLayout.getTabAt(tabLayout2.getTabCount() - 1);
            if (tabAt != null) {
                tabAt.select();
            }
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof SettingsFragmentListener) {
            this.mListener = (SettingsFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement SettingsFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mView = (View) null;
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (SettingsFragmentListener) null;
    }
}
