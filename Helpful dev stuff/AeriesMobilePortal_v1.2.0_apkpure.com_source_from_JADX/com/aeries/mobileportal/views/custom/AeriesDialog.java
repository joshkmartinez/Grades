package com.aeries.mobileportal.views.custom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Notification;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010)\u001a\u00020\u001bH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014¨\u0006,"}, d2 = {"Lcom/aeries/mobileportal/views/custom/AeriesDialog;", "Landroid/support/v4/app/DialogFragment;", "()V", "actionButton", "Landroid/widget/Button;", "getActionButton", "()Landroid/widget/Button;", "setActionButton", "(Landroid/widget/Button;)V", "mListener", "Lcom/aeries/mobileportal/views/custom/AeriesDialog$NotificationDialogListener;", "getMListener", "()Lcom/aeries/mobileportal/views/custom/AeriesDialog$NotificationDialogListener;", "setMListener", "(Lcom/aeries/mobileportal/views/custom/AeriesDialog$NotificationDialogListener;)V", "message", "Landroid/widget/TextView;", "getMessage", "()Landroid/widget/TextView;", "setMessage", "(Landroid/widget/TextView;)V", "notification", "Lcom/aeries/mobileportal/models/Notification;", "schoolName", "getSchoolName", "setSchoolName", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupViews", "Companion", "NotificationDialogListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AeriesDialog.kt */
public final class AeriesDialog extends DialogFragment {
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String NOTIFICATION = "NOTIFICATION";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361808)
    public Button actionButton;
    @Nullable
    private NotificationDialogListener mListener;
    @NotNull
    @BindView(2131362037)
    public TextView message;
    private Notification notification;
    @NotNull
    @BindView(2131362257)
    public TextView schoolName;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/custom/AeriesDialog$Companion;", "", "()V", "NOTIFICATION", "", "getNOTIFICATION", "()Ljava/lang/String;", "newInstance", "Lcom/aeries/mobileportal/views/custom/AeriesDialog;", "notification", "Lcom/aeries/mobileportal/models/Notification;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AeriesDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getNOTIFICATION() {
            return AeriesDialog.NOTIFICATION;
        }

        @NotNull
        public final AeriesDialog newInstance(@NotNull Notification notification) {
            Intrinsics.checkParameterIsNotNull(notification, "notification");
            AeriesDialog aeriesDialog = new AeriesDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(getNOTIFICATION(), notification);
            aeriesDialog.setArguments(bundle);
            return aeriesDialog;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/views/custom/AeriesDialog$NotificationDialogListener;", "", "isChangePasswordDisabled", "", "onActionButtonClick", "", "notification", "Lcom/aeries/mobileportal/models/Notification;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AeriesDialog.kt */
    public interface NotificationDialogListener {
        boolean isChangePasswordDisabled();

        void onActionButtonClick(@NotNull Notification notification);
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

    @NotNull
    public final Button getActionButton() {
        Button button = this.actionButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
        }
        return button;
    }

    public final void setActionButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.actionButton = button;
    }

    @NotNull
    public final TextView getSchoolName() {
        TextView textView = this.schoolName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolName");
        }
        return textView;
    }

    public final void setSchoolName(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.schoolName = textView;
    }

    @Nullable
    public final NotificationDialogListener getMListener() {
        return this.mListener;
    }

    public final void setMListener(@Nullable NotificationDialogListener notificationDialogListener) {
        this.mListener = notificationDialogListener;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.notification = (Notification) getArguments().getParcelable(NOTIFICATION);
        }
    }

    @NotNull
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.dialog_notification, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return inflate;
    }

    private final void setupViews() {
        int i;
        NotificationDialogListener notificationDialogListener;
        TextView textView = this.message;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        }
        Notification notification = this.notification;
        String str = null;
        textView.setText(notification != null ? notification.getNotificationMessage() : null);
        Button button = this.actionButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
        }
        notification = this.notification;
        int i2 = 0;
        if ((Intrinsics.areEqual(notification != null ? notification.getSsoUrl() : null, (Object) "0") ^ 1) != 0) {
            notification = this.notification;
            CharSequence ssoUrl = notification != null ? notification.getSsoUrl() : null;
            if (ssoUrl != null) {
                if (ssoUrl.length() != 0) {
                    i = 0;
                    if (i == 0) {
                        i = C0316R.string.go;
                        button.setText(i);
                        button = this.actionButton;
                        if (button == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
                        }
                        notificationDialogListener = this.mListener;
                        if (notificationDialogListener != null && notificationDialogListener.isChangePasswordDisabled()) {
                            notification = this.notification;
                            if (Intrinsics.areEqual(notification != null ? notification.getSsoUrl() : null, (Object) "changepassword.aspx")) {
                                i2 = 8;
                            }
                        }
                        button.setVisibility(i2);
                        button = this.actionButton;
                        if (button == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
                        }
                        button.setOnClickListener(new AeriesDialog$setupViews$1(this));
                        textView = this.schoolName;
                        if (textView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("schoolName");
                        }
                        notification = this.notification;
                        if (notification != null) {
                            str = notification.getSchoolName();
                        }
                        textView.setText(str);
                    }
                }
            }
            i = 1;
            if (i == 0) {
                i = C0316R.string.go;
                button.setText(i);
                button = this.actionButton;
                if (button == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionButton");
                }
                notificationDialogListener = this.mListener;
                notification = this.notification;
                if (notification != null) {
                }
                if (Intrinsics.areEqual(notification != null ? notification.getSsoUrl() : null, (Object) "changepassword.aspx")) {
                    i2 = 8;
                }
                button.setVisibility(i2);
                button = this.actionButton;
                if (button == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionButton");
                }
                button.setOnClickListener(new AeriesDialog$setupViews$1(this));
                textView = this.schoolName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("schoolName");
                }
                notification = this.notification;
                if (notification != null) {
                    str = notification.getSchoolName();
                }
                textView.setText(str);
            }
        }
        i = C0316R.string.got_it;
        button.setText(i);
        button = this.actionButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
        }
        notificationDialogListener = this.mListener;
        notification = this.notification;
        if (notification != null) {
        }
        if (Intrinsics.areEqual(notification != null ? notification.getSsoUrl() : null, (Object) "changepassword.aspx")) {
            i2 = 8;
        }
        button.setVisibility(i2);
        button = this.actionButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
        }
        button.setOnClickListener(new AeriesDialog$setupViews$1(this));
        textView = this.schoolName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolName");
        }
        notification = this.notification;
        if (notification != null) {
            str = notification.getSchoolName();
        }
        textView.setText(str);
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        bundle = super.onCreateDialog(bundle);
        bundle.requestWindowFeature(1);
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        return bundle;
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof NotificationDialogListener) {
            context = getParentFragment();
            if (context != null) {
                this.mListener = (NotificationDialogListener) context;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.views.custom.AeriesDialog.NotificationDialogListener");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append("must implement NotificationDialogListener");
        throw new RuntimeException(stringBuilder.toString());
    }
}
