package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {
    final FlowableOperator<? extends R, ? super T> operator;

    public FlowableLift(Flowable<T> flowable, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(flowable);
        this.operator = flowableOperator;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber apply = this.operator.apply(subscriber);
            if (apply != null) {
                this.source.subscribe(apply);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Operator ");
            stringBuilder.append(this.operator);
            stringBuilder.append(" returned a null Subscriber");
            throw new NullPointerException(stringBuilder.toString());
        } catch (Subscriber<? super R> subscriber2) {
            throw subscriber2;
        } catch (Subscriber<? super R> subscriber22) {
            Exceptions.throwIfFatal(subscriber22);
            RxJavaPlugins.onError(subscriber22);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(subscriber22);
        }
    }
}
