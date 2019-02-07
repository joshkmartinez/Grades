package com.aeries.mobileportal.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.SupplementalAttendance;
import com.aeries.mobileportal.models.SupplementalAttendanceDetail;
import com.aeries.mobileportal.models.SupplementalAttendanceSession;
import com.aeries.mobileportal.utils.DateUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J(\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0011H\u0007J\b\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\u0011H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment;", "Landroid/support/v4/app/DialogFragment;", "()V", "confirmedMessageTV", "Landroid/widget/TextView;", "getConfirmedMessageTV", "()Landroid/widget/TextView;", "setConfirmedMessageTV", "(Landroid/widget/TextView;)V", "homeButton", "getHomeButton", "setHomeButton", "mListener", "Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment$DoneCheckInFragmentListener;", "mSupplementalAttendance", "Lcom/aeries/mobileportal/models/SupplementalAttendance;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onHomePressed", "onResume", "setupViews", "Companion", "DoneCheckInFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DoneCheckInFragment.kt */
public final class DoneCheckInFragment extends DialogFragment {
    public static final Companion Companion = new Companion();
    private static final String SUPPLEMENTAL_ATTENDANCE = "param1";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361875)
    public TextView confirmedMessageTV;
    @NotNull
    @BindView(2131361989)
    public TextView homeButton;
    private DoneCheckInFragmentListener mListener;
    private SupplementalAttendance mSupplementalAttendance;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment$Companion;", "", "()V", "SUPPLEMENTAL_ATTENDANCE", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment;", "supplementalAttendance", "Lcom/aeries/mobileportal/models/SupplementalAttendance;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DoneCheckInFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DoneCheckInFragment newInstance(@NotNull SupplementalAttendance supplementalAttendance) {
            Intrinsics.checkParameterIsNotNull(supplementalAttendance, "supplementalAttendance");
            DoneCheckInFragment doneCheckInFragment = new DoneCheckInFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DoneCheckInFragment.SUPPLEMENTAL_ATTENDANCE, supplementalAttendance);
            doneCheckInFragment.setArguments(bundle);
            return doneCheckInFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment$DoneCheckInFragmentListener;", "", "onHomePressed", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DoneCheckInFragment.kt */
    public interface DoneCheckInFragmentListener {
        void onHomePressed();
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
    public final TextView getConfirmedMessageTV() {
        TextView textView = this.confirmedMessageTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmedMessageTV");
        }
        return textView;
    }

    public final void setConfirmedMessageTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.confirmedMessageTV = textView;
    }

    @NotNull
    public final TextView getHomeButton() {
        TextView textView = this.homeButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeButton");
        }
        return textView;
    }

    public final void setHomeButton(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.homeButton = textView;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mSupplementalAttendance = (SupplementalAttendance) getArguments().getParcelable(SUPPLEMENTAL_ATTENDANCE);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_done_check_in, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        bundle = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        bundle = bundle.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog.window");
        bundle.getAttributes().windowAnimations = C0316R.style.DialogFragmentAnimations;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog");
        dialog.getWindow().setLayout(-1, -1);
        dialog = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog");
        dialog.getWindow().setGravity(17);
    }

    private final void setupViews() {
        SupplementalAttendanceSession supplementalAttendanceSession;
        String hourMinute;
        String sessionName;
        String room;
        TextView textView;
        StringCompanionObject stringCompanionObject;
        String string;
        Object[] objArr;
        SupplementalAttendance supplementalAttendance = this.mSupplementalAttendance;
        if (supplementalAttendance != null) {
            List sessions = supplementalAttendance.getSessions();
            if (sessions != null) {
                supplementalAttendanceSession = (SupplementalAttendanceSession) CollectionsKt.first(sessions);
                if (supplementalAttendanceSession == null) {
                    Intrinsics.throwNpe();
                }
                hourMinute = DateUtils.Companion.getHourMinute(((SupplementalAttendanceDetail) CollectionsKt.first(supplementalAttendanceSession.getDetails())).getAttendanceDate());
                sessionName = supplementalAttendanceSession.getSessionName();
                room = supplementalAttendanceSession.getRoom();
                textView = this.confirmedMessageTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmedMessageTV");
                }
                stringCompanionObject = StringCompanionObject.INSTANCE;
                string = getString(C0316R.string.check_in_confirmed_message);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.check_in_confirmed_message)");
                objArr = new Object[]{hourMinute, sessionName, room};
                room = String.format(string, Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(room, "java.lang.String.format(format, *args)");
                textView.setText(room);
            }
        }
        supplementalAttendanceSession = null;
        if (supplementalAttendanceSession == null) {
            Intrinsics.throwNpe();
        }
        hourMinute = DateUtils.Companion.getHourMinute(((SupplementalAttendanceDetail) CollectionsKt.first(supplementalAttendanceSession.getDetails())).getAttendanceDate());
        sessionName = supplementalAttendanceSession.getSessionName();
        room = supplementalAttendanceSession.getRoom();
        textView = this.confirmedMessageTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmedMessageTV");
        }
        stringCompanionObject = StringCompanionObject.INSTANCE;
        string = getString(C0316R.string.check_in_confirmed_message);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.check_in_confirmed_message)");
        objArr = new Object[]{hourMinute, sessionName, room};
        room = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(room, "java.lang.String.format(format, *args)");
        textView.setText(room);
    }

    @OnClick({2131361989})
    public final void onHomePressed() {
        if (this.mListener != null) {
            DoneCheckInFragmentListener doneCheckInFragmentListener = this.mListener;
            if (doneCheckInFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            doneCheckInFragmentListener.onHomePressed();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof DoneCheckInFragmentListener) {
            this.mListener = (DoneCheckInFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement DoneCheckInFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (DoneCheckInFragmentListener) null;
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        bundle = super.onCreateDialog(bundle);
        bundle.setCancelable(false);
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        return bundle;
    }
}
