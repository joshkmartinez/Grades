package com.aeries.mobileportal.views.custom;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/views/custom/AeriesDialogI;", "", "builder", "Lcom/aeries/mobileportal/views/custom/AeriesDialogI$Builder;", "(Lcom/aeries/mobileportal/views/custom/AeriesDialogI$Builder;)V", "actionButton", "Landroid/widget/Button;", "getActionButton", "()Landroid/widget/Button;", "setActionButton", "(Landroid/widget/Button;)V", "getBuilder", "()Lcom/aeries/mobileportal/views/custom/AeriesDialogI$Builder;", "message", "Landroid/widget/TextView;", "getMessage", "()Landroid/widget/TextView;", "setMessage", "(Landroid/widget/TextView;)V", "title", "getTitle", "setTitle", "create", "Landroid/app/Dialog;", "Builder", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AeriesDialogI.kt */
public class AeriesDialogI {
    @NotNull
    @BindView(2131361808)
    public Button actionButton;
    @NotNull
    private final Builder builder;
    @NotNull
    @BindView(2131362037)
    public TextView message;
    @NotNull
    @BindView(2131362257)
    public TextView title;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u001e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00062\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020$J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0016\u0010'\u001a\u00020\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020$J\u0010\u0010!\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\u0006\u0010(\u001a\u00020\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\n¨\u0006)"}, d2 = {"Lcom/aeries/mobileportal/views/custom/AeriesDialogI$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buttonMessage", "", "getButtonMessage", "()Ljava/lang/String;", "setButtonMessage", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "isCancelable", "", "()Z", "setCancelable", "(Z)V", "message", "getMessage", "setMessage", "onCancel", "Lkotlin/Function0;", "", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "setOnCancel", "(Lkotlin/jvm/functions/Function0;)V", "onClickListener", "getOnClickListener", "setOnClickListener", "title", "getTitle", "setTitle", "setButton", "text", "", "onClick", "cancellable", "setOnCancelListener", "show", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AeriesDialogI.kt */
    public static final class Builder {
        @Nullable
        private String buttonMessage;
        @NotNull
        private final Context context;
        private boolean isCancelable = true;
        @Nullable
        private String message;
        @Nullable
        private Function0<Unit> onCancel;
        @Nullable
        private Function0<Unit> onClickListener;
        @Nullable
        private String title;

        public Builder(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.context = context;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public final void m93setTitle(@Nullable String str) {
            this.title = str;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public final void m92setMessage(@Nullable String str) {
            this.message = str;
        }

        @Nullable
        public final String getButtonMessage() {
            return this.buttonMessage;
        }

        public final void setButtonMessage(@Nullable String str) {
            this.buttonMessage = str;
        }

        @Nullable
        public final Function0<Unit> getOnClickListener() {
            return this.onClickListener;
        }

        public final void setOnClickListener(@Nullable Function0<Unit> function0) {
            this.onClickListener = function0;
        }

        @Nullable
        public final Function0<Unit> getOnCancel() {
            return this.onCancel;
        }

        public final void setOnCancel(@Nullable Function0<Unit> function0) {
            this.onCancel = function0;
        }

        public final boolean isCancelable() {
            return this.isCancelable;
        }

        public final void m91setCancelable(boolean z) {
            this.isCancelable = z;
        }

        @NotNull
        public final Builder setTitle(@Nullable String str) {
            Builder builder = this;
            builder.title = str;
            return builder;
        }

        @NotNull
        public final Builder setTitle(int i) {
            Builder builder = this;
            builder.title = builder.context.getString(i);
            return builder;
        }

        @NotNull
        public final Builder setMessage(@Nullable String str) {
            Builder builder = this;
            builder.message = str;
            return builder;
        }

        @NotNull
        public final Builder setMessage(int i) {
            Builder builder = this;
            builder.message = builder.context.getString(i);
            return builder;
        }

        @NotNull
        public final Builder setButton(@NotNull String str, @Nullable Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(str, "text");
            Builder builder = this;
            builder.buttonMessage = str;
            builder.onClickListener = function0;
            return builder;
        }

        @NotNull
        public final Builder setButton(int i, @Nullable Function0<Unit> function0) {
            Builder builder = this;
            builder.buttonMessage = builder.context.getString(i);
            builder.onClickListener = function0;
            return builder;
        }

        @NotNull
        public final Builder setOnCancelListener(@Nullable Function0<Unit> function0) {
            Builder builder = this;
            builder.onCancel = function0;
            return builder;
        }

        @NotNull
        public final Builder setCancelable(boolean z) {
            Builder builder = this;
            builder.isCancelable = z;
            return builder;
        }

        public final void show() {
            new AeriesDialogI(this).create().show();
        }
    }

    public AeriesDialogI(@NotNull Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.builder = builder;
    }

    @NotNull
    public final Builder getBuilder() {
        return this.builder;
    }

    @NotNull
    public final TextView getTitle() {
        TextView textView = this.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_TITLE_KEY);
        }
        return textView;
    }

    public final void setTitle(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.title = textView;
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
    protected final Dialog create() {
        Dialog dialog = new Dialog(this.builder.getContext());
        dialog.setContentView(C0316R.layout.dialog_notification);
        ButterKnife.bind((Object) this, dialog);
        TextView textView = this.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_TITLE_KEY);
        }
        textView.setText(this.builder.getTitle());
        int i = 8;
        textView.setVisibility(this.builder.getTitle() != null ? 0 : 8);
        textView = this.message;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        }
        textView.setText(this.builder.getMessage());
        Button button = this.actionButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
        }
        if (this.builder.getButtonMessage() != null) {
            i = 0;
        }
        button.setVisibility(i);
        button.setText(this.builder.getButtonMessage());
        button.setOnClickListener(new AeriesDialogI$create$$inlined$apply$lambda$1(this, dialog));
        dialog.setCancelable(this.builder.isCancelable());
        dialog.setOnCancelListener(new AeriesDialogI$create$3(this));
        return dialog;
    }
}
