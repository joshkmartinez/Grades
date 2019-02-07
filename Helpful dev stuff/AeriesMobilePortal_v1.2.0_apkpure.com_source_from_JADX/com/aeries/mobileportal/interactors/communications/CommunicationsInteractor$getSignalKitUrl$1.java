package com.aeries.mobileportal.interactors.communications;

import com.aeries.mobileportal.models.SignalKit;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: CommunicationsInteractor.kt */
final class CommunicationsInteractor$getSignalKitUrl$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ CommunicationsCallback $callback;
    final /* synthetic */ CommunicationsInteractor this$0;

    CommunicationsInteractor$getSignalKitUrl$1(CommunicationsInteractor communicationsInteractor, CommunicationsCallback communicationsCallback) {
        this.this$0 = communicationsInteractor;
        this.$callback = communicationsCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        CommunicationsInteractor communicationsInteractor = this.this$0;
        str = this.this$0.getSignalKitService().getSignalKitURL(str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<SignalKit>() {
            public final void accept(SignalKit signalKit) {
                if (Intrinsics.areEqual(signalKit.getStatus(), Param.SUCCESS)) {
                    this.$callback.onURLReceived(signalKit.getSignalKitUrl());
                } else {
                    this.$callback.onErrorReceived(signalKit.getErrorMessage());
                }
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                CommunicationsCallback communicationsCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                communicationsCallback.onNetworkError(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "signalKitService.getSign…  }\n                    )");
        communicationsInteractor.addToCompositeDisposable(str);
    }
}
