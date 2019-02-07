package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001aD\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00020\u00050\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001ab\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\b0\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003\"\b\b\u0002\u0010\t*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\u001a^\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\f2)\b\u0004\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u000eH\b\u001aD\u0010\u0013\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001\u001aI\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\u001a\b\u0004\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u000eH\b\u001a(\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u00010\f\u001aD\u0010\u0019\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001\u001a(\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u00010\f\u001a#\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001aD\u0010\u001c\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001\u001a&\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001\u001a\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\f\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u001fH\u0002\u001a%\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060!¢\u0006\u0002\u0010\"\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020#0\u0001*\u00020$\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020%0\u0001*\u00020&\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020(\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u00020,\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020.\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020/0\u0001*\u000200\u001a \u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\f\u001a \u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u001f\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u000201\u001a \u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u0017\u001a^\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\f2)\b\u0004\u00103\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u000eH\b¨\u00064"}, d2 = {"cast", "Lio/reactivex/Observable;", "R", "", "combineLatest", "Lkotlin/Pair;", "T", "observable", "Lkotlin/Triple;", "U", "observable1", "observable2", "", "combineFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "args", "concatAll", "kotlin.jvm.PlatformType", "flatMapSequence", "body", "Lkotlin/sequences/Sequence;", "merge", "mergeAll", "mergeDelayError", "ofType", "switchLatest", "switchOnNext", "toIterable", "", "toObservable", "", "([Ljava/lang/Object;)Lio/reactivex/Observable;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Lkotlin/ranges/IntProgression;", "zip", "zipFunction", "rxkotlin_main"}, k = 2, mv = {1, 1, 6})
/* compiled from: observable.kt */
public final class ObservableKt {
    @NotNull
    public static final Observable<Boolean> toObservable(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$receiver");
        return toObservable(ArraysKt___ArraysKt.asIterable(zArr));
    }

    @NotNull
    public static final Observable<Byte> toObservable(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$receiver");
        return toObservable(ArraysKt___ArraysKt.asIterable(bArr));
    }

    @NotNull
    public static final Observable<Short> toObservable(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$receiver");
        return toObservable(ArraysKt___ArraysKt.asIterable(sArr));
    }

    @NotNull
    public static final Observable<Integer> toObservable(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$receiver");
        return toObservable(ArraysKt___ArraysKt.asIterable(iArr));
    }

    @NotNull
    public static final Observable<Long> toObservable(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$receiver");
        return toObservable(ArraysKt___ArraysKt.asIterable(jArr));
    }

    @NotNull
    public static final Observable<Float> toObservable(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$receiver");
        return toObservable(ArraysKt___ArraysKt.asIterable(fArr));
    }

    @NotNull
    public static final Observable<Double> toObservable(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$receiver");
        return toObservable(ArraysKt___ArraysKt.asIterable(dArr));
    }

    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        tArr = Observable.fromArray(Arrays.copyOf(tArr, tArr.length));
        Intrinsics.checkExpressionValueIsNotNull(tArr, "Observable.fromArray(*this)");
        return tArr;
    }

    @NotNull
    public static final Observable<Integer> toObservable(@NotNull IntProgression intProgression) {
        Intrinsics.checkParameterIsNotNull(intProgression, "$receiver");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            intProgression = Observable.fromIterable(intProgression);
            Intrinsics.checkExpressionValueIsNotNull(intProgression, "Observable.fromIterable(this)");
            return intProgression;
        }
        intProgression = Observable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(intProgression, "Observable.range(first, …max(0, last - first + 1))");
        return intProgression;
    }

    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "$receiver");
        return toObservable(toIterable(it));
    }

    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        iterable = Observable.fromIterable(iterable);
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Observable.fromIterable(this)");
        return iterable;
    }

    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        return toObservable(SequencesKt___SequencesKt.asIterable(sequence));
    }

    @NotNull
    public static final <T> Observable<T> merge(@NotNull Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        iterable = Observable.merge(toObservable((Iterable) iterable));
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Observable.merge(this.toObservable())");
        return iterable;
    }

    @NotNull
    public static final <T> Observable<T> mergeDelayError(@NotNull Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        iterable = Observable.mergeDelayError(toObservable((Iterable) iterable));
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Observable.mergeDelayError(this.toObservable())");
        return iterable;
    }

    @NotNull
    public static final <T, R> Observable<R> flatMapSequence(@NotNull Observable<T> observable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "body");
        observable = observable.flatMap(new ObservableKt$flatMapSequence$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(observable, "flatMap { body(it).toObservable() }");
        return observable;
    }

    @NotNull
    public static final <T, R> Observable<R> combineLatest(@NotNull Iterable<? extends Observable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "combineFunction");
        iterable = Observable.combineLatest(iterable, new ObservableKt$combineLatest$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Observable.combineLatest…List().map { it as T }) }");
        return iterable;
    }

    @NotNull
    public static final <T, R> Observable<R> zip(@NotNull Iterable<? extends Observable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "zipFunction");
        iterable = Observable.zip(iterable, new ObservableKt$zip$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Observable.zip(this) { z…List().map { it as T }) }");
        return iterable;
    }

    private static final <R> Observable<R> cast(@NotNull Observable<?> observable) {
        Intrinsics.reifiedOperationMarker(4, "R");
        observable = observable.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(observable, "cast(R::class.java)");
        return observable;
    }

    private static final <R> Observable<R> ofType(@NotNull Observable<?> observable) {
        Intrinsics.reifiedOperationMarker(4, "R");
        observable = observable.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(observable, "ofType(R::class.java)");
        return observable;
    }

    private static final <T> Iterable<T> toIterable(@NotNull Iterator<? extends T> it) {
        return new ObservableKt$toIterable$1(it);
    }

    @NotNull
    public static final <T, R> Observable<Pair<T, R>> combineLatest(@NotNull Observable<T> observable, @NotNull Observable<R> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observable2, "observable");
        Function2 function2 = ObservableKt$combineLatest$2.INSTANCE;
        observable = Observable.combineLatest(observable, observable2, function2 == null ? null : new ObservableKt$sam$BiFunction$76a140ed(function2));
        Intrinsics.checkExpressionValueIsNotNull(observable, "Observable.combineLatest…able, BiFunction(::Pair))");
        return observable;
    }

    @NotNull
    public static final <T, R, U> Observable<Triple<T, R, U>> combineLatest(@NotNull Observable<T> observable, @NotNull Observable<R> observable2, @NotNull Observable<U> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observable2, "observable1");
        Intrinsics.checkParameterIsNotNull(observable3, "observable2");
        Function3 function3 = ObservableKt$combineLatest$3.INSTANCE;
        observable = Observable.combineLatest(observable, observable2, observable3, function3 == null ? null : new ObservableKt$sam$Function3$5d5171b5(function3));
        Intrinsics.checkExpressionValueIsNotNull(observable, "Observable.combineLatest…le2, Function3(::Triple))");
        return observable;
    }

    public static final <T> Observable<T> mergeAll(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        return observable.flatMap(ObservableKt$mergeAll$1.INSTANCE);
    }

    public static final <T> Observable<T> concatAll(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        return observable.concatMap(ObservableKt$concatAll$1.INSTANCE);
    }

    public static final <T> Observable<T> switchLatest(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        return observable.switchMap(ObservableKt$switchLatest$1.INSTANCE);
    }

    @NotNull
    public static final <T> Observable<T> switchOnNext(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        observable = Observable.switchOnNext(observable);
        Intrinsics.checkExpressionValueIsNotNull(observable, "Observable.switchOnNext(this)");
        return observable;
    }
}
