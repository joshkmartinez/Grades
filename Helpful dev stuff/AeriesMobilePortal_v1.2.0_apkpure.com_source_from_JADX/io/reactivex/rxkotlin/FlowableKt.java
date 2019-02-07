package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
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

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001aD\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00020\u00050\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001ab\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\b0\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003\"\b\b\u0002\u0010\t*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\u001a^\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\f2)\b\u0004\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u000eH\b\u001aD\u0010\u0013\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001\u001aI\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\u001a\b\u0004\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u000eH\b\u001a(\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u00010\f\u001aD\u0010\u0019\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001\u001a(\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u00010\f\u001a#\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001aD\u0010\u001c\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001\u001a&\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001\u001a%\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u001f¢\u0006\u0002\u0010 \u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020!0\u0001*\u00020\"\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020#0\u0001*\u00020$\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020%0\u0001*\u00020&\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020(\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u00020,\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020.\u001a \u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\f\u001a \u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060/\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u000200\u001a \u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u0017\u001a\"\u00101\u001a\b\u0012\u0004\u0012\u0002H\u00060\f\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060/H\u0002\u001a^\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\f2)\b\u0004\u00103\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u000eH\b¨\u00064"}, d2 = {"cast", "Lio/reactivex/Flowable;", "R", "", "combineLatest", "Lkotlin/Pair;", "T", "flowable", "Lkotlin/Triple;", "U", "flowable1", "flowable2", "", "combineFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "args", "concatAll", "kotlin.jvm.PlatformType", "flatMapSequence", "body", "Lkotlin/sequences/Sequence;", "merge", "mergeAll", "mergeDelayError", "ofType", "switchLatest", "switchOnNext", "toFlowable", "", "([Ljava/lang/Object;)Lio/reactivex/Flowable;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Lkotlin/ranges/IntProgression;", "toIterable", "zip", "zipFunction", "rxkotlin_main"}, k = 2, mv = {1, 1, 6})
/* compiled from: flowable.kt */
public final class FlowableKt {
    @NotNull
    public static final Flowable<Boolean> toFlowable(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(zArr));
    }

    @NotNull
    public static final Flowable<Byte> toFlowable(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(bArr));
    }

    @NotNull
    public static final Flowable<Short> toFlowable(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(sArr));
    }

    @NotNull
    public static final Flowable<Integer> toFlowable(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(iArr));
    }

    @NotNull
    public static final Flowable<Long> toFlowable(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(jArr));
    }

    @NotNull
    public static final Flowable<Float> toFlowable(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(fArr));
    }

    @NotNull
    public static final Flowable<Double> toFlowable(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(dArr));
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        tArr = Flowable.fromArray(Arrays.copyOf(tArr, tArr.length));
        Intrinsics.checkExpressionValueIsNotNull(tArr, "Flowable.fromArray(*this)");
        return tArr;
    }

    @NotNull
    public static final Flowable<Integer> toFlowable(@NotNull IntProgression intProgression) {
        Intrinsics.checkParameterIsNotNull(intProgression, "$receiver");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            intProgression = Flowable.fromIterable(intProgression);
            Intrinsics.checkExpressionValueIsNotNull(intProgression, "Flowable.fromIterable(this)");
            return intProgression;
        }
        intProgression = Flowable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(intProgression, "Flowable.range(first, Ma…max(0, last - first + 1))");
        return intProgression;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "$receiver");
        return toFlowable(toIterable(it));
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        iterable = Flowable.fromIterable(iterable);
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Flowable.fromIterable(this)");
        return iterable;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        return toFlowable(SequencesKt___SequencesKt.asIterable(sequence));
    }

    @NotNull
    public static final <T> Flowable<T> merge(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        iterable = Flowable.merge(toFlowable((Iterable) iterable));
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Flowable.merge(this.toFlowable())");
        return iterable;
    }

    @NotNull
    public static final <T> Flowable<T> mergeDelayError(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        iterable = Flowable.mergeDelayError(toFlowable((Iterable) iterable));
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Flowable.mergeDelayError(this.toFlowable())");
        return iterable;
    }

    @NotNull
    public static final <T, R> Flowable<R> flatMapSequence(@NotNull Flowable<T> flowable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "body");
        flowable = flowable.flatMap(new FlowableKt$flatMapSequence$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "flatMap { body(it).toFlowable() }");
        return flowable;
    }

    @NotNull
    public static final <T, R> Flowable<R> combineLatest(@NotNull Iterable<? extends Flowable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "combineFunction");
        iterable = Flowable.combineLatest(iterable, new FlowableKt$combineLatest$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Flowable.combineLatest(t…List().map { it as T }) }");
        return iterable;
    }

    @NotNull
    public static final <T, R> Flowable<R> zip(@NotNull Iterable<? extends Flowable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "zipFunction");
        iterable = Flowable.zip(iterable, new FlowableKt$zip$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(iterable, "Flowable.zip(this) { zip…List().map { it as T }) }");
        return iterable;
    }

    private static final <R> Flowable<R> cast(@NotNull Flowable<?> flowable) {
        Intrinsics.reifiedOperationMarker(4, "R");
        flowable = flowable.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(flowable, "cast(R::class.java)");
        return flowable;
    }

    private static final <R> Flowable<R> ofType(@NotNull Flowable<?> flowable) {
        Intrinsics.reifiedOperationMarker(4, "R");
        flowable = flowable.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(flowable, "ofType(R::class.java)");
        return flowable;
    }

    private static final <T> Iterable<T> toIterable(@NotNull Iterator<? extends T> it) {
        return new FlowableKt$toIterable$1(it);
    }

    @NotNull
    public static final <T, R> Flowable<Pair<T, R>> combineLatest(@NotNull Flowable<T> flowable, @NotNull Flowable<R> flowable2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(flowable2, "flowable");
        Function2 function2 = FlowableKt$combineLatest$2.INSTANCE;
        flowable = Flowable.combineLatest(flowable, flowable2, function2 == null ? null : new FlowableKt$sam$BiFunction$89d2d6b2(function2));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "Flowable.combineLatest(t…able, BiFunction(::Pair))");
        return flowable;
    }

    @NotNull
    public static final <T, R, U> Flowable<Triple<T, R, U>> combineLatest(@NotNull Flowable<T> flowable, @NotNull Flowable<R> flowable2, @NotNull Flowable<U> flowable3) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(flowable2, "flowable1");
        Intrinsics.checkParameterIsNotNull(flowable3, "flowable2");
        Function3 function3 = FlowableKt$combineLatest$3.INSTANCE;
        flowable = Flowable.combineLatest(flowable, flowable2, flowable3, function3 == null ? null : new FlowableKt$sam$Function3$7083077a(function3));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "Flowable.combineLatest(t…le2, Function3(::Triple))");
        return flowable;
    }

    public static final <T> Flowable<T> mergeAll(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return flowable.flatMap(FlowableKt$mergeAll$1.INSTANCE);
    }

    public static final <T> Flowable<T> concatAll(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return flowable.concatMap(FlowableKt$concatAll$1.INSTANCE);
    }

    public static final <T> Flowable<T> switchLatest(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return flowable.switchMap(FlowableKt$switchLatest$1.INSTANCE);
    }

    @NotNull
    public static final <T> Flowable<T> switchOnNext(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        flowable = Flowable.switchOnNext(flowable);
        Intrinsics.checkExpressionValueIsNotNull(flowable, "Flowable.switchOnNext(this)");
        return flowable;
    }
}
