package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.SessionsAdapter;
import com.aeries.mobileportal.adapters.SessionsAdapter.SessionsAdapterListener;
import com.aeries.mobileportal.dagger.components.SessionSelectFragmentComponent;
import com.aeries.mobileportal.models.Session;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0002GHB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u0002012\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000201H\u0007J\b\u00108\u001a\u000201H\u0007J\u0012\u00109\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J(\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010@\u001a\u000201H\u0016J\b\u0010A\u001a\u000201H\u0016J\u0010\u0010B\u001a\u0002012\u0006\u0010C\u001a\u00020\u001cH\u0016J\b\u0010D\u001a\u000201H\u0002J\u0014\u0010E\u001a\u0002012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020 0\u001fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006I"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/SessionsAdapter$SessionsAdapterListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/SessionsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/SessionsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/SessionsAdapter;)V", "cancelButton", "Landroid/widget/Button;", "getCancelButton", "()Landroid/widget/Button;", "setCancelButton", "(Landroid/widget/Button;)V", "checkInButton", "getCheckInButton", "setCheckInButton", "component", "Lcom/aeries/mobileportal/dagger/components/SessionSelectFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/SessionSelectFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "mListener", "Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment$SessionSelectFragmentListener;", "mSelectedSession", "", "Ljava/lang/Integer;", "mSessions", "", "Lcom/aeries/mobileportal/models/Session;", "messageTV", "Landroid/widget/TextView;", "getMessageTV", "()Landroid/widget/TextView;", "setMessageTV", "(Landroid/widget/TextView;)V", "noSessionsTV", "getNoSessionsTV", "setNoSessionsTV", "sessionsRV", "Landroid/support/v7/widget/RecyclerView;", "getSessionsRV", "()Landroid/support/v7/widget/RecyclerView;", "setSessionsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCancelPressed", "onCheckInPressed", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onResume", "onSessionSelected", "position", "setupViews", "update", "sessions", "Companion", "SessionSelectFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SessionSelectFragment.kt */
public final class SessionSelectFragment extends Fragment implements SessionsAdapterListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SessionSelectFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/SessionSelectFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    private static final String SUPPLEMENTAL_ATTENDANCE = "param1";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public SessionsAdapter adapter;
    @NotNull
    @BindView(2131361855)
    public Button cancelButton;
    @NotNull
    @BindView(2131361870)
    public Button checkInButton;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new SessionSelectFragment$component$2(this));
    private SessionSelectFragmentListener mListener;
    private Integer mSelectedSession;
    private List<Session> mSessions;
    @NotNull
    @BindView(2131362146)
    public TextView messageTV;
    @NotNull
    @BindView(2131362067)
    public TextView noSessionsTV;
    @NotNull
    @BindView(2131362148)
    public RecyclerView sessionsRV;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment$Companion;", "", "()V", "SUPPLEMENTAL_ATTENDANCE", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment;", "sessions", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/Session;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SessionSelectFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SessionSelectFragment newInstance(@NotNull ArrayList<Session> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "sessions");
            SessionSelectFragment sessionSelectFragment = new SessionSelectFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(SessionSelectFragment.SUPPLEMENTAL_ATTENDANCE, arrayList);
            sessionSelectFragment.setArguments(bundle);
            return sessionSelectFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment$SessionSelectFragmentListener;", "", "onCancelSelected", "", "onCourseSelected", "session", "Lcom/aeries/mobileportal/models/Session;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SessionSelectFragment.kt */
    public interface SessionSelectFragmentListener {
        void onCancelSelected();

        void onCourseSelected(@NotNull Session session);
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
    public final SessionSelectFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (SessionSelectFragmentComponent) lazy.getValue();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final TextView getMessageTV() {
        TextView textView = this.messageTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageTV");
        }
        return textView;
    }

    public final void setMessageTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.messageTV = textView;
    }

    @NotNull
    public final Button getCheckInButton() {
        Button button = this.checkInButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInButton");
        }
        return button;
    }

    public final void setCheckInButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.checkInButton = button;
    }

    @NotNull
    public final RecyclerView getSessionsRV() {
        RecyclerView recyclerView = this.sessionsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionsRV");
        }
        return recyclerView;
    }

    public final void setSessionsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.sessionsRV = recyclerView;
    }

    @NotNull
    public final Button getCancelButton() {
        Button button = this.cancelButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
        }
        return button;
    }

    public final void setCancelButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.cancelButton = button;
    }

    @NotNull
    public final TextView getNoSessionsTV() {
        TextView textView = this.noSessionsTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noSessionsTV");
        }
        return textView;
    }

    public final void setNoSessionsTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.noSessionsTV = textView;
    }

    @NotNull
    public final SessionsAdapter getAdapter() {
        SessionsAdapter sessionsAdapter = this.adapter;
        if (sessionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return sessionsAdapter;
    }

    public final void setAdapter(@NotNull SessionsAdapter sessionsAdapter) {
        Intrinsics.checkParameterIsNotNull(sessionsAdapter, "<set-?>");
        this.adapter = sessionsAdapter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mSessions = getArguments().getParcelableArrayList(SUPPLEMENTAL_ATTENDANCE);
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_session_select, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.sessionsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionsRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.sessionsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionsRV");
        }
        SessionsAdapter sessionsAdapter = this.adapter;
        if (sessionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(sessionsAdapter);
        recyclerView2 = this.sessionsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionsRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        SessionsAdapter sessionsAdapter2 = this.adapter;
        if (sessionsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        List list = this.mSessions;
        if (list == null) {
            list = new ArrayList();
        }
        sessionsAdapter2.update(list);
    }

    public final void update(@NotNull List<Session> list) {
        Intrinsics.checkParameterIsNotNull(list, "sessions");
        if (list.isEmpty()) {
            list = this.sessionsRV;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionsRV");
            }
            list.setVisibility(8);
            list = this.noSessionsTV;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noSessionsTV");
            }
            list.setVisibility(0);
            return;
        }
        RecyclerView recyclerView = this.sessionsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionsRV");
        }
        recyclerView.setVisibility(0);
        TextView textView = this.noSessionsTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noSessionsTV");
        }
        textView.setVisibility(8);
        this.mSessions = list;
        SessionsAdapter sessionsAdapter = this.adapter;
        if (sessionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        sessionsAdapter.update(list);
    }

    public void onResume() {
        super.onResume();
    }

    @OnClick({2131361870})
    public final void onCheckInPressed() {
        if (this.mListener != null) {
            Session session;
            SessionSelectFragmentListener sessionSelectFragmentListener = this.mListener;
            if (sessionSelectFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            List list = this.mSessions;
            if (list != null) {
                Integer num = this.mSelectedSession;
                if (num == null) {
                    Intrinsics.throwNpe();
                }
                session = (Session) list.get(num.intValue());
            } else {
                session = null;
            }
            if (session == null) {
                Intrinsics.throwNpe();
            }
            sessionSelectFragmentListener.onCourseSelected(session);
        }
    }

    @OnClick({2131361855})
    public final void onCancelPressed() {
        if (this.mListener != null) {
            SessionSelectFragmentListener sessionSelectFragmentListener = this.mListener;
            if (sessionSelectFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            sessionSelectFragmentListener.onCancelSelected();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof SessionSelectFragmentListener) {
            this.mListener = (SessionSelectFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement SessionSelectFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (SessionSelectFragmentListener) null;
    }

    public void onSessionSelected(int i) {
        Button button = this.checkInButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInButton");
        }
        button.setEnabled(true);
        button = this.checkInButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInButton");
        }
        button.setTextColor(ContextCompat.getColor(getContext(), 17170443));
        this.mSelectedSession = Integer.valueOf(i);
    }
}
