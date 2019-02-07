package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aV\u0010\b\u001a\u00020\u0002\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001aV\u0010\b\u001a\u00020\u0002\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\u000e2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a0\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001aV\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001aV\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001aV\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\u000e2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001aF\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\u00142\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"onCompleteStub", "Lkotlin/Function0;", "", "onErrorStub", "Lkotlin/Function1;", "", "onNextStub", "", "blockingSubscribeBy", "T", "Lio/reactivex/Flowable;", "onNext", "onError", "onComplete", "Lio/reactivex/Observable;", "subscribeBy", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Completable;", "Lio/reactivex/Maybe;", "onSuccess", "Lio/reactivex/Single;", "rxkotlin_main"}, k = 2, mv = {1, 1, 6})
/* compiled from: subscribers.kt */
public final class SubscribersKt {
    private static final Function0<Unit> onCompleteStub = SubscribersKt$onCompleteStub$1.INSTANCE;
    private static final Function1<Throwable, Unit> onErrorStub = SubscribersKt$onErrorStub$1.INSTANCE;
    private static final Function1<Object, Unit> onNextStub = SubscribersKt$onNextStub$1.INSTANCE;

    @NotNull
    public static final <T> Disposable subscribeBy(@NotNull Observable<T> observable, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onNext");
        Intrinsics.checkParameterIsNotNull(function12, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        observable = observable.subscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(function1), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function12), (Action) new SubscribersKt$sam$Action$fd62537c(function0));
        Intrinsics.checkExpressionValueIsNotNull(observable, "subscribe(onNext, onError, onComplete)");
        return observable;
    }

    @NotNull
    public static final <T> Disposable subscribeBy(@NotNull Flowable<T> flowable, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onNext");
        Intrinsics.checkParameterIsNotNull(function12, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        flowable = flowable.subscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(function1), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function12), (Action) new SubscribersKt$sam$Action$fd62537c(function0));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "subscribe(onNext, onError, onComplete)");
        return flowable;
    }

    @NotNull
    public static final <T> Disposable subscribeBy(@NotNull Single<T> single, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(single, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onSuccess");
        Intrinsics.checkParameterIsNotNull(function12, "onError");
        single = single.subscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(function1), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function12));
        Intrinsics.checkExpressionValueIsNotNull(single, "subscribe(onSuccess, onError)");
        return single;
    }

    @NotNull
    public static final <T> Disposable subscribeBy(@NotNull Maybe<T> maybe, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(maybe, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onSuccess");
        Intrinsics.checkParameterIsNotNull(function12, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        maybe = maybe.subscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(function1), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function12), (Action) new SubscribersKt$sam$Action$fd62537c(function0));
        Intrinsics.checkExpressionValueIsNotNull(maybe, "subscribe(onSuccess, onError, onComplete)");
        return maybe;
    }

    @NotNull
    public static final Disposable subscribeBy(@NotNull Completable completable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(completable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        completable = completable.subscribe(new SubscribersKt$sam$Action$fd62537c(function0), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function1));
        Intrinsics.checkExpressionValueIsNotNull(completable, "subscribe(onComplete, onError)");
        return completable;
    }

    public static final <T> void blockingSubscribeBy(@NotNull Observable<T> observable, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onNext");
        Intrinsics.checkParameterIsNotNull(function12, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        observable.blockingSubscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(function1), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function12), (Action) new SubscribersKt$sam$Action$fd62537c(function0));
    }

    public static final <T> void blockingSubscribeBy(@NotNull Flowable<T> flowable, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onNext");
        Intrinsics.checkParameterIsNotNull(function12, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        flowable.blockingSubscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(function1), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function12), (Action) new SubscribersKt$sam$Action$fd62537c(function0));
    }
}
