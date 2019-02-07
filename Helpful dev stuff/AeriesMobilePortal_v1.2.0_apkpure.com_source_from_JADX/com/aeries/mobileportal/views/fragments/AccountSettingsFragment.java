package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.SettingsAdapter;
import com.aeries.mobileportal.adapters.SettingsAdapter.SettingsListener;
import com.aeries.mobileportal.dagger.components.AccountSettingsFragmentComponent;
import com.aeries.mobileportal.enums.Settings;
import com.aeries.mobileportal.presenters.AccountSettingsPresenter;
import com.aeries.mobileportal.views.viewmodels.AccountSettingsViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002FGB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u00020&H\u0007J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020&H\u0016J\u0012\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020&H\u0016J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000201H\u0016J(\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u00020&H\u0016J\b\u0010>\u001a\u00020&H\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020&H\u0002J\u0016\u0010C\u001a\u00020&2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020(0EH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006H"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AccountSettingsFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/SettingsAdapter$SettingsListener;", "Lcom/aeries/mobileportal/views/viewmodels/AccountSettingsViewModel;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/SettingsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/SettingsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/SettingsAdapter;)V", "closeIcon", "Landroid/widget/ImageView;", "getCloseIcon", "()Landroid/widget/ImageView;", "setCloseIcon", "(Landroid/widget/ImageView;)V", "component", "Lcom/aeries/mobileportal/dagger/components/AccountSettingsFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AccountSettingsFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "mListener", "Lcom/aeries/mobileportal/views/fragments/AccountSettingsFragment$AccountSettingsFragmentListener;", "presenter", "Lcom/aeries/mobileportal/presenters/AccountSettingsPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/AccountSettingsPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/AccountSettingsPresenter;)V", "settingsRV", "Landroid/support/v7/widget/RecyclerView;", "getSettingsRV", "()Landroid/support/v7/widget/RecyclerView;", "setSettingsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "close", "", "getPortalVersion", "", "invalidateToken", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onResume", "onSettingSelected", "setting", "Lcom/aeries/mobileportal/enums/Settings;", "setupViews", "showSettings", "settings", "", "AccountSettingsFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AccountSettingsFragment.kt */
public final class AccountSettingsFragment extends Fragment implements SettingsListener, AccountSettingsViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AccountSettingsFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AccountSettingsFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public SettingsAdapter adapter;
    @NotNull
    @BindView(2131361882)
    public ImageView closeIcon;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AccountSettingsFragment$component$2(this));
    private AccountSettingsFragmentListener mListener;
    @Inject
    @NotNull
    public AccountSettingsPresenter presenter;
    @NotNull
    @BindView(2131362149)
    public RecyclerView settingsRV;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AccountSettingsFragment$AccountSettingsFragmentListener;", "", "close", "", "getPortalVersion", "", "invalidateToken", "onSettingSelected", "setting", "Lcom/aeries/mobileportal/enums/Settings;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AccountSettingsFragment.kt */
    public interface AccountSettingsFragmentListener {
        void close();

        @Nullable
        String getPortalVersion();

        void invalidateToken();

        void onSettingSelected(@NotNull Settings settings);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AccountSettingsFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/AccountSettingsFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AccountSettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AccountSettingsFragment newInstance() {
            AccountSettingsFragment accountSettingsFragment = new AccountSettingsFragment();
            accountSettingsFragment.setArguments(new Bundle());
            return accountSettingsFragment;
        }
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
    public final AccountSettingsFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AccountSettingsFragmentComponent) lazy.getValue();
    }

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getSettingsRV() {
        RecyclerView recyclerView = this.settingsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsRV");
        }
        return recyclerView;
    }

    public final void setSettingsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.settingsRV = recyclerView;
    }

    @NotNull
    public final ImageView getCloseIcon() {
        ImageView imageView = this.closeIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIcon");
        }
        return imageView;
    }

    public final void setCloseIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.closeIcon = imageView;
    }

    @NotNull
    public final SettingsAdapter getAdapter() {
        SettingsAdapter settingsAdapter = this.adapter;
        if (settingsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return settingsAdapter;
    }

    public final void setAdapter(@NotNull SettingsAdapter settingsAdapter) {
        Intrinsics.checkParameterIsNotNull(settingsAdapter, "<set-?>");
        this.adapter = settingsAdapter;
    }

    @NotNull
    public final AccountSettingsPresenter getPresenter() {
        AccountSettingsPresenter accountSettingsPresenter = this.presenter;
        if (accountSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return accountSettingsPresenter;
    }

    public final void setPresenter(@NotNull AccountSettingsPresenter accountSettingsPresenter) {
        Intrinsics.checkParameterIsNotNull(accountSettingsPresenter, "<set-?>");
        this.presenter = accountSettingsPresenter;
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_account_settings, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        SettingsAdapter settingsAdapter = this.adapter;
        if (settingsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        settingsAdapter.restartHeaders();
    }

    @OnClick({2131361882})
    public final void close() {
        if (this.mListener != null) {
            AccountSettingsFragmentListener accountSettingsFragmentListener = this.mListener;
            if (accountSettingsFragmentListener != null) {
                accountSettingsFragmentListener.close();
            }
        }
    }

    private final void setupViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.settingsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.settingsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        recyclerView2 = this.settingsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsRV");
        }
        SettingsAdapter settingsAdapter = this.adapter;
        if (settingsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(settingsAdapter);
        AccountSettingsPresenter accountSettingsPresenter = this.presenter;
        if (accountSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        accountSettingsPresenter.getSettings();
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof AccountSettingsFragmentListener) {
            this.mListener = (AccountSettingsFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AccountSettingsFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (AccountSettingsFragmentListener) null;
    }

    @NotNull
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        i = new AlphaAnimation(1.0f, 1.0f);
        z = getContext();
        Intrinsics.checkExpressionValueIsNotNull(z, "context");
        i.setDuration((long) z.getResources().getInteger(17694722));
        return (Animation) i;
    }

    public void showSettings(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "settings");
        SettingsAdapter settingsAdapter = this.adapter;
        if (settingsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        settingsAdapter.update(new ArrayList(list));
    }

    public void onSettingSelected(@NotNull Settings settings) {
        Intrinsics.checkParameterIsNotNull(settings, "setting");
        AccountSettingsFragmentListener accountSettingsFragmentListener = this.mListener;
        if (accountSettingsFragmentListener != null) {
            accountSettingsFragmentListener.onSettingSelected(settings);
        }
    }

    public void invalidateToken() {
        AccountSettingsFragmentListener accountSettingsFragmentListener = this.mListener;
        if (accountSettingsFragmentListener != null) {
            accountSettingsFragmentListener.invalidateToken();
        }
    }

    @Nullable
    public String getPortalVersion() {
        AccountSettingsFragmentListener accountSettingsFragmentListener = this.mListener;
        return accountSettingsFragmentListener != null ? accountSettingsFragmentListener.getPortalVersion() : null;
    }
}
