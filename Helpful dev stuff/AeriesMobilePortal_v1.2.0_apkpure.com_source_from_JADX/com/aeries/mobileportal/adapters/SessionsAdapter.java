package com.aeries.mobileportal.adapters;

import android.content.Context;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Session;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001e\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0014\u0010\u001a\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/aeries/mobileportal/adapters/SessionsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/SessionsAdapter$SessionHolder;", "listener", "Lcom/aeries/mobileportal/adapters/SessionsAdapter$SessionsAdapterListener;", "(Lcom/aeries/mobileportal/adapters/SessionsAdapter$SessionsAdapterListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/SessionsAdapter$SessionsAdapterListener;", "selectedItems", "Landroid/util/SparseBooleanArray;", "getSelectedItems", "()Landroid/util/SparseBooleanArray;", "sessions", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/Session;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "", "SessionHolder", "SessionsAdapterListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SessionsAdapter.kt */
public final class SessionsAdapter extends Adapter<SessionHolder> {
    @NotNull
    private final SessionsAdapterListener listener;
    @NotNull
    private final SparseBooleanArray selectedItems = new SparseBooleanArray();
    private final ArrayList<Session> sessions = new ArrayList();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/adapters/SessionsAdapter$SessionsAdapterListener;", "", "onSessionSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SessionsAdapter.kt */
    public interface SessionsAdapterListener {
        void onSessionSelected(int i);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/adapters/SessionsAdapter$SessionHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/SessionsAdapter;Landroid/view/View;)V", "background", "Landroid/widget/LinearLayout;", "getBackground", "()Landroid/widget/LinearLayout;", "setBackground", "(Landroid/widget/LinearLayout;)V", "roomName", "Landroid/widget/TextView;", "getRoomName", "()Landroid/widget/TextView;", "setRoomName", "(Landroid/widget/TextView;)V", "sessionName", "getSessionName", "setSessionName", "bindData", "", "session", "Lcom/aeries/mobileportal/models/Session;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SessionsAdapter.kt */
    public final class SessionHolder extends ViewHolder {
        @NotNull
        @BindView(2131362016)
        public LinearLayout background;
        @NotNull
        @BindView(2131362113)
        public TextView roomName;
        @NotNull
        @BindView(2131362147)
        public TextView sessionName;
        final /* synthetic */ SessionsAdapter this$0;

        public SessionHolder(@NotNull SessionsAdapter sessionsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = sessionsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getSessionName() {
            TextView textView = this.sessionName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionName");
            }
            return textView;
        }

        public final void setSessionName(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.sessionName = textView;
        }

        @NotNull
        public final TextView getRoomName() {
            TextView textView = this.roomName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomName");
            }
            return textView;
        }

        public final void setRoomName(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.roomName = textView;
        }

        @NotNull
        public final LinearLayout getBackground() {
            LinearLayout linearLayout = this.background;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
            }
            return linearLayout;
        }

        public final void setBackground(@NotNull LinearLayout linearLayout) {
            Intrinsics.checkParameterIsNotNull(linearLayout, "<set-?>");
            this.background = linearLayout;
        }

        public final void bindData(@NotNull Session session) {
            Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
            boolean z = this.this$0.getSelectedItems().get(getAdapterPosition(), false);
            LinearLayout linearLayout = this.background;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
            }
            linearLayout.setSelected(z);
            TextView textView = this.sessionName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionName");
            }
            textView.setText(session.getSessionName());
            textView = this.roomName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomName");
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[]{session.getRoom()};
            session = String.format("Room %s", Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(session, "java.lang.String.format(format, *args)");
            textView.setText((CharSequence) session);
            session = this.sessionName;
            if (session == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionName");
            }
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            int i = 17170443;
            session.setTextColor(ContextCompat.getColor(view.getContext(), z ? 17170443 : C0316R.color.AeriesBlue));
            session = this.roomName;
            if (session == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomName");
            }
            view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            Context context = view.getContext();
            if (!z) {
                i = 17170441;
            }
            session.setTextColor(ContextCompat.getColor(context, i));
            this.itemView.setOnClickListener(new SessionsAdapter$SessionHolder$bindData$1(this));
        }
    }

    public final class SessionHolder_ViewBinding implements Unbinder {
        private SessionHolder target;

        @UiThread
        public SessionHolder_ViewBinding(SessionHolder sessionHolder, View view) {
            this.target = sessionHolder;
            sessionHolder.sessionName = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.session_name, "field 'sessionName'", TextView.class);
            sessionHolder.roomName = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.room, "field 'roomName'", TextView.class);
            sessionHolder.background = (LinearLayout) Utils.findRequiredViewAsType(view, C0316R.id.layout_session, "field 'background'", LinearLayout.class);
        }

        public void unbind() {
            SessionHolder sessionHolder = this.target;
            if (sessionHolder != null) {
                this.target = null;
                sessionHolder.sessionName = null;
                sessionHolder.roomName = null;
                sessionHolder.background = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SessionsAdapter(@NotNull SessionsAdapterListener sessionsAdapterListener) {
        Intrinsics.checkParameterIsNotNull(sessionsAdapterListener, CastExtraArgs.LISTENER);
        this.listener = sessionsAdapterListener;
    }

    @NotNull
    public final SessionsAdapterListener getListener() {
        return this.listener;
    }

    @NotNull
    public final SparseBooleanArray getSelectedItems() {
        return this.selectedItems;
    }

    public int getItemCount() {
        return this.sessions.size();
    }

    public void onBindViewHolder(@Nullable SessionHolder sessionHolder, int i) {
        if (sessionHolder != null) {
            LinearLayout background = sessionHolder.getBackground();
            if (background != null) {
                background.setSelected(this.selectedItems.get(i, false));
            }
        }
        if (sessionHolder != null) {
            i = this.sessions.get(i);
            Intrinsics.checkExpressionValueIsNotNull(i, "sessions[position]");
            sessionHolder.bindData((Session) i);
        }
    }

    @NotNull
    public SessionHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_session, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return new SessionHolder(this, viewGroup);
    }

    public final void update(@NotNull List<Session> list) {
        Intrinsics.checkParameterIsNotNull(list, "sessions");
        this.sessions.clear();
        this.sessions.addAll(list);
        notifyDataSetChanged();
    }
}
