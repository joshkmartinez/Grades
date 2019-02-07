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
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0007J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J(\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020\u001dH\u0007J\b\u0010,\u001a\u00020\u001dH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006/"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CheckInFragment;", "Landroid/support/v4/app/Fragment;", "()V", "checkInButton", "Landroid/widget/Button;", "getCheckInButton", "()Landroid/widget/Button;", "setCheckInButton", "(Landroid/widget/Button;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "mListener", "Lcom/aeries/mobileportal/views/fragments/CheckInFragment$CheckInFragmentListener;", "mStatus", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "messageTV", "Landroid/widget/TextView;", "getMessageTV", "()Landroid/widget/TextView;", "setMessageTV", "(Landroid/widget/TextView;)V", "scanButton", "getScanButton", "setScanButton", "onAttach", "", "context", "Landroid/content/Context;", "onCheckInPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onScanPressed", "setupViews", "CheckInFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CheckInFragment.kt */
public final class CheckInFragment extends Fragment {
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String STATUS = "Message";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361870)
    public Button checkInButton;
    @NotNull
    @BindView(2131361990)
    public ImageView iconIV;
    private CheckInFragmentListener mListener;
    private SupplementalAttendanceStatus mStatus;
    @NotNull
    @BindView(2131362037)
    public TextView messageTV;
    @NotNull
    @BindView(2131362118)
    public Button scanButton;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CheckInFragment$CheckInFragmentListener;", "", "onCheckInPressed", "", "onScanPressed", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CheckInFragment.kt */
    public interface CheckInFragmentListener {
        void onCheckInPressed();

        void onScanPressed();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CheckInFragment$Companion;", "", "()V", "STATUS", "", "getSTATUS", "()Ljava/lang/String;", "newInstance", "Lcom/aeries/mobileportal/views/fragments/CheckInFragment;", "status", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CheckInFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getSTATUS() {
            return CheckInFragment.STATUS;
        }

        @NotNull
        public final CheckInFragment newInstance(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
            Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "status");
            CheckInFragment checkInFragment = new CheckInFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(getSTATUS(), supplementalAttendanceStatus);
            checkInFragment.setArguments(bundle);
            return checkInFragment;
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
    public final ImageView getIconIV() {
        ImageView imageView = this.iconIV;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconIV");
        }
        return imageView;
    }

    public final void setIconIV(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.iconIV = imageView;
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
    public final Button getScanButton() {
        Button button = this.scanButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanButton");
        }
        return button;
    }

    public final void setScanButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.scanButton = button;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mStatus = (SupplementalAttendanceStatus) getArguments().getParcelable(STATUS);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_check_in, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        int i;
        TextView textView = this.messageTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageTV");
        }
        SupplementalAttendanceStatus supplementalAttendanceStatus = this.mStatus;
        String str = null;
        textView.setText(supplementalAttendanceStatus != null ? supplementalAttendanceStatus.getMessage() : null);
        ImageView imageView = this.iconIV;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconIV");
        }
        supplementalAttendanceStatus = this.mStatus;
        if (Intrinsics.areEqual(supplementalAttendanceStatus != null ? supplementalAttendanceStatus.getMessage() : null, (Object) "")) {
            i = 0;
        } else {
            supplementalAttendanceStatus = this.mStatus;
            if (supplementalAttendanceStatus != null) {
                str = supplementalAttendanceStatus.getMessageType();
            }
            if (str == null) {
                Intrinsics.throwNpe();
            }
            i = AttendanceIcons.valueOf(str).getIcon();
        }
        imageView.setImageResource(i);
    }

    @OnClick({2131361870})
    public final void onCheckInPressed() {
        CheckInFragmentListener checkInFragmentListener = this.mListener;
        if (checkInFragmentListener != null) {
            checkInFragmentListener.onCheckInPressed();
        }
    }

    @OnClick({2131362118})
    public final void onScanPressed() {
        CheckInFragmentListener checkInFragmentListener = this.mListener;
        if (checkInFragmentListener != null) {
            checkInFragmentListener.onScanPressed();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof CheckInFragmentListener) {
            this.mListener = (CheckInFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement CheckInFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (CheckInFragmentListener) null;
    }
}
