package com.aeries.mobileportal.views.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.NotificationsAdapter;
import com.aeries.mobileportal.adapters.NotificationsAdapter.NotificationListener;
import com.aeries.mobileportal.dagger.components.NotificationsFragmentComponent;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.presenters.NotificationsPresenter;
import com.aeries.mobileportal.views.custom.AeriesDialog;
import com.aeries.mobileportal.views.custom.AeriesDialog.NotificationDialogListener;
import com.aeries.mobileportal.views.viewmodels.NotificationsViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Collection;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002deB\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020<H\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0012\u0010D\u001a\u00020A2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020AH\u0007J\b\u0010H\u001a\u00020AH\u0016J \u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020LH\u0016J(\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020AH\u0016J\u0010\u0010X\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010Y\u001a\u00020AH\u0002J\b\u0010Z\u001a\u00020AH\u0002J\u0010\u0010[\u001a\u00020A2\u0006\u0010\\\u001a\u00020]H\u0016J\u0016\u0010^\u001a\u00020A2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020C0`H\u0016J\u0010\u0010a\u001a\u00020A2\u0006\u0010b\u001a\u00020<H\u0016J\u0010\u0010c\u001a\u00020A2\u0006\u0010b\u001a\u00020<H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006f"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/NotificationsFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationListener;", "Lcom/aeries/mobileportal/views/viewmodels/NotificationsViewModel;", "Lcom/aeries/mobileportal/views/custom/AeriesDialog$NotificationDialogListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/NotificationsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/NotificationsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/NotificationsAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/NotificationsFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/NotificationsFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "mListener", "Lcom/aeries/mobileportal/views/fragments/NotificationsFragment$NotificationsFragmentListener;", "noNotifications", "Landroid/widget/TextView;", "getNoNotifications", "()Landroid/widget/TextView;", "setNoNotifications", "(Landroid/widget/TextView;)V", "notificationsError", "getNotificationsError", "setNotificationsError", "notificationsRV", "Landroid/support/v7/widget/RecyclerView;", "getNotificationsRV", "()Landroid/support/v7/widget/RecyclerView;", "setNotificationsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "presenter", "Lcom/aeries/mobileportal/presenters/NotificationsPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/NotificationsPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/NotificationsPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "swipeRefresh", "Landroid/support/v4/widget/SwipeRefreshLayout;", "getSwipeRefresh", "()Landroid/support/v4/widget/SwipeRefreshLayout;", "setSwipeRefresh", "(Landroid/support/v4/widget/SwipeRefreshLayout;)V", "attemptStartActivity", "", "intent", "Landroid/content/Intent;", "isChangePasswordDisabled", "onActionButtonClick", "", "notification", "Lcom/aeries/mobileportal/models/Notification;", "onAttach", "context", "Landroid/content/Context;", "onCloseIconClicked", "onCreate", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onNotificationClick", "sendNotificationChangeBroadcast", "setupViews", "showError", "message", "", "showNotifications", "notifications", "", "showProgressBar", "b", "showRedirectingDialog", "Companion", "NotificationsFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationsFragment.kt */
public final class NotificationsFragment extends Fragment implements NotificationListener, NotificationsViewModel, NotificationDialogListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NotificationsFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/NotificationsFragmentComponent;"))};
    @NotNull
    private static final String ACTION_NOTIFICATION_CHANGE = "ACTION_NOTIFICATION_CHANGE";
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String NEW_NOTIFICATION_NUMBER = "NOTIFICATION_NUMBER";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public NotificationsAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new NotificationsFragment$component$2(this));
    private NotificationsFragmentListener mListener;
    @NotNull
    @BindView(2131362065)
    public TextView noNotifications;
    @NotNull
    @BindView(2131362076)
    public TextView notificationsError;
    @NotNull
    @BindView(2131362075)
    public RecyclerView notificationsRV;
    @Inject
    @NotNull
    public NotificationsPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    @NotNull
    public ProgressDialog progressDialog;
    @NotNull
    @BindView(2131362179)
    public SwipeRefreshLayout swipeRefresh;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/NotificationsFragment$Companion;", "", "()V", "ACTION_NOTIFICATION_CHANGE", "", "getACTION_NOTIFICATION_CHANGE", "()Ljava/lang/String;", "NEW_NOTIFICATION_NUMBER", "getNEW_NOTIFICATION_NUMBER", "newInstance", "Lcom/aeries/mobileportal/views/fragments/NotificationsFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: NotificationsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getACTION_NOTIFICATION_CHANGE() {
            return NotificationsFragment.ACTION_NOTIFICATION_CHANGE;
        }

        @NotNull
        public final String getNEW_NOTIFICATION_NUMBER() {
            return NotificationsFragment.NEW_NOTIFICATION_NUMBER;
        }

        @NotNull
        public final NotificationsFragment newInstance() {
            NotificationsFragment notificationsFragment = new NotificationsFragment();
            notificationsFragment.setArguments(new Bundle());
            return notificationsFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/NotificationsFragment$NotificationsFragmentListener;", "", "close", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: NotificationsFragment.kt */
    public interface NotificationsFragmentListener {
        void close();
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
    public final NotificationsFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (NotificationsFragmentComponent) lazy.getValue();
    }

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getNotificationsRV() {
        RecyclerView recyclerView = this.notificationsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsRV");
        }
        return recyclerView;
    }

    public final void setNotificationsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.notificationsRV = recyclerView;
    }

    @NotNull
    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return progressBar;
    }

    public final void setProgressBar(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    @NotNull
    public final SwipeRefreshLayout getSwipeRefresh() {
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefresh;
        if (swipeRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeRefresh");
        }
        return swipeRefreshLayout;
    }

    public final void setSwipeRefresh(@NotNull SwipeRefreshLayout swipeRefreshLayout) {
        Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "<set-?>");
        this.swipeRefresh = swipeRefreshLayout;
    }

    @NotNull
    public final TextView getNoNotifications() {
        TextView textView = this.noNotifications;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noNotifications");
        }
        return textView;
    }

    public final void setNoNotifications(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.noNotifications = textView;
    }

    @NotNull
    public final TextView getNotificationsError() {
        TextView textView = this.notificationsError;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsError");
        }
        return textView;
    }

    public final void setNotificationsError(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.notificationsError = textView;
    }

    @NotNull
    public final ProgressDialog getProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        return progressDialog;
    }

    public final void setProgressDialog(@NotNull ProgressDialog progressDialog) {
        Intrinsics.checkParameterIsNotNull(progressDialog, "<set-?>");
        this.progressDialog = progressDialog;
    }

    @NotNull
    public final NotificationsAdapter getAdapter() {
        NotificationsAdapter notificationsAdapter = this.adapter;
        if (notificationsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return notificationsAdapter;
    }

    public final void setAdapter(@NotNull NotificationsAdapter notificationsAdapter) {
        Intrinsics.checkParameterIsNotNull(notificationsAdapter, "<set-?>");
        this.adapter = notificationsAdapter;
    }

    @NotNull
    public final NotificationsPresenter getPresenter() {
        NotificationsPresenter notificationsPresenter = this.presenter;
        if (notificationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationsPresenter;
    }

    public final void setPresenter(@NotNull NotificationsPresenter notificationsPresenter) {
        Intrinsics.checkParameterIsNotNull(notificationsPresenter, "<set-?>");
        this.presenter = notificationsPresenter;
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_notifications, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        this.progressDialog = new ProgressDialog(getContext());
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        progressDialog.setMessage(context.getResources().getString(C0316R.string.redirecting));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = this.notificationsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView = this.notificationsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsRV");
        }
        NotificationsAdapter notificationsAdapter = this.adapter;
        if (notificationsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(notificationsAdapter);
        recyclerView = this.notificationsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsRV");
        }
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation()));
        recyclerView = this.notificationsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsRV");
        }
        recyclerView.addOnScrollListener(new NotificationsFragment$setupViews$1(this, linearLayoutManager));
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefresh;
        if (swipeRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeRefresh");
        }
        swipeRefreshLayout.setOnRefreshListener(new NotificationsFragment$setupViews$2(this));
        NotificationsPresenter notificationsPresenter = this.presenter;
        if (notificationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationsPresenter.getNotifications();
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof NotificationsFragmentListener) {
            this.mListener = (NotificationsFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement NotificationsFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    @OnClick({2131361882})
    public final void onCloseIconClicked() {
        if (this.mListener != null) {
            NotificationsFragmentListener notificationsFragmentListener = this.mListener;
            if (notificationsFragmentListener != null) {
                notificationsFragmentListener.close();
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (NotificationsFragmentListener) null;
    }

    public void showProgressBar(boolean z) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(z ? 0 : 8);
        if (!z) {
            z = this.swipeRefresh;
            if (!z) {
                Intrinsics.throwUninitializedPropertyAccessException("swipeRefresh");
            }
            z.setRefreshing(false);
        }
    }

    public void onNotificationClick(@NotNull Notification notification) {
        Intrinsics.checkParameterIsNotNull(notification, "notification");
        AeriesDialog.Companion.newInstance(notification).show(getChildFragmentManager(), null);
        NotificationsPresenter notificationsPresenter = this.presenter;
        if (notificationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationsPresenter.updateNotification(notification);
        NotificationsAdapter notificationsAdapter = this.adapter;
        if (notificationsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        notificationsAdapter.markNotificationAsSeen(notification);
        sendNotificationChangeBroadcast();
    }

    @NotNull
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        i = new AlphaAnimation(1.0f, 1.0f);
        z = getContext();
        Intrinsics.checkExpressionValueIsNotNull(z, "context");
        i.setDuration((long) z.getResources().getInteger(17694722));
        return (Animation) i;
    }

    private final void sendNotificationChangeBroadcast() {
        Intent intent = new Intent(ACTION_NOTIFICATION_CHANGE);
        String str = NEW_NOTIFICATION_NUMBER;
        NotificationsAdapter notificationsAdapter = this.adapter;
        if (notificationsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        Collection arrayList = new ArrayList();
        for (Object next : notificationsAdapter.getNotifications()) {
            if ((Intrinsics.areEqual(((Notification) next).getStatus(), (Object) "Read") ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        intent.putExtra(str, ((List) arrayList).size());
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }

    public void showNotifications(@NotNull List<? extends Notification> list) {
        Intrinsics.checkParameterIsNotNull(list, "notifications");
        if (list.isEmpty()) {
            TextView textView = this.noNotifications;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noNotifications");
            }
            textView.setVisibility(0);
        }
        NotificationsAdapter notificationsAdapter = this.adapter;
        if (notificationsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        notificationsAdapter.update(list);
    }

    public void showRedirectingDialog(boolean z) {
        if (z) {
            z = this.progressDialog;
            if (!z) {
                Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            }
            z.show();
            return;
        }
        z = this.progressDialog;
        if (!z) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        z.dismiss();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        str = this.adapter;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        if (str.getItemCount() == null) {
            str = this.notificationsError;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationsError");
            }
            str.setVisibility(0);
        }
    }

    public boolean attemptStartActivity(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        FragmentActivity activity = getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        if (intent.resolveActivity(activity.getPackageManager()) == null) {
            return null;
        }
        startActivity(intent);
        return true;
    }

    public void onActionButtonClick(@NotNull Notification notification) {
        Intrinsics.checkParameterIsNotNull(notification, "notification");
        NotificationsPresenter notificationsPresenter = this.presenter;
        if (notificationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationsPresenter.onActionButtonClick(notification);
    }

    public boolean isChangePasswordDisabled() {
        NotificationsPresenter notificationsPresenter = this.presenter;
        if (notificationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationsPresenter.isChangePasswordDisabled();
    }
}
