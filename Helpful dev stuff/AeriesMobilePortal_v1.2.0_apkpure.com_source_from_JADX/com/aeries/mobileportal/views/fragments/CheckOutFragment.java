package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.enums.AttendanceIcons;
import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0007J\u0012\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J(\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010)\u001a\u00020\u001cH\u0016J\b\u0010*\u001a\u00020\u001cH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CheckOutFragment;", "Landroid/support/v4/app/Fragment;", "()V", "checkOutButton", "Landroid/widget/Button;", "getCheckOutButton", "()Landroid/widget/Button;", "setCheckOutButton", "(Landroid/widget/Button;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "mListener", "Lcom/aeries/mobileportal/views/fragments/CheckOutFragment$CheckOutFragmentListener;", "mSession", "Lcom/aeries/mobileportal/models/Session;", "mStatus", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "message", "Landroid/widget/TextView;", "getMessage", "()Landroid/widget/TextView;", "setMessage", "(Landroid/widget/TextView;)V", "onAttach", "", "context", "Landroid/content/Context;", "onButtonPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "setupViews", "CheckOutFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CheckOutFragment.kt */
public final class CheckOutFragment extends Fragment {
    public static final Companion Companion = new Companion();
    private static final String SESSION = "param2";
    private static final String STATUS = "param1";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361873)
    public Button checkOutButton;
    @NotNull
    @BindView(2131361990)
    public ImageView icon;
    private CheckOutFragmentListener mListener;
    private Session mSession;
    private SupplementalAttendanceStatus mStatus;
    @NotNull
    @BindView(2131362037)
    public TextView message;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CheckOutFragment$CheckOutFragmentListener;", "", "onCheckOutSelected", "", "session", "Lcom/aeries/mobileportal/models/Session;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CheckOutFragment.kt */
    public interface CheckOutFragmentListener {
        void onCheckOutSelected(@NotNull Session session);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CheckOutFragment$Companion;", "", "()V", "SESSION", "", "STATUS", "newInstance", "Lcom/aeries/mobileportal/views/fragments/CheckOutFragment;", "status", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "session", "Lcom/aeries/mobileportal/models/Session;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CheckOutFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CheckOutFragment newInstance(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus, @NotNull Session session) {
            Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "status");
            Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
            CheckOutFragment checkOutFragment = new CheckOutFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckOutFragment.STATUS, supplementalAttendanceStatus);
            bundle.putParcelable(CheckOutFragment.SESSION, session);
            checkOutFragment.setArguments(bundle);
            return checkOutFragment;
        }

        @NotNull
        public final CheckOutFragment newInstance(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
            Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "status");
            CheckOutFragment checkOutFragment = new CheckOutFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckOutFragment.STATUS, supplementalAttendanceStatus);
            checkOutFragment.setArguments(bundle);
            return checkOutFragment;
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

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final Button getCheckOutButton() {
        Button button = this.checkOutButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkOutButton");
        }
        return button;
    }

    public final void setCheckOutButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.checkOutButton = button;
    }

    @NotNull
    public final ImageView getIcon() {
        ImageView imageView = this.icon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.APP_ICON_KEY);
        }
        return imageView;
    }

    public final void setIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.icon = imageView;
    }

    @NotNull
    public final TextView getMessage() {
        TextView textView = this.message;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        }
        return textView;
    }

    public final void setMessage(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.message = textView;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mStatus = (SupplementalAttendanceStatus) getArguments().getParcelable(STATUS);
            this.mSession = (Session) getArguments().getParcelable(SESSION);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_check_out, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        TextView textView = this.message;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        }
        SupplementalAttendanceStatus supplementalAttendanceStatus = this.mStatus;
        String str = null;
        textView.setText(supplementalAttendanceStatus != null ? supplementalAttendanceStatus.getMessage() : null);
        ImageView imageView = this.icon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.APP_ICON_KEY);
        }
        supplementalAttendanceStatus = this.mStatus;
        if (supplementalAttendanceStatus != null) {
            str = supplementalAttendanceStatus.getMessageType();
        }
        if (str == null) {
            Intrinsics.throwNpe();
        }
        imageView.setImageResource(AttendanceIcons.valueOf(str).getIcon());
    }

    @OnClick({2131361873})
    public final void onButtonPressed() {
        if (this.mListener != null) {
            CheckOutFragmentListener checkOutFragmentListener = this.mListener;
            if (checkOutFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            Session session = this.mSession;
            if (session == null) {
                Intrinsics.throwNpe();
            }
            checkOutFragmentListener.onCheckOutSelected(session);
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof CheckOutFragmentListener) {
            this.mListener = (CheckOutFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement CheckOutFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (CheckOutFragmentListener) null;
    }
}
