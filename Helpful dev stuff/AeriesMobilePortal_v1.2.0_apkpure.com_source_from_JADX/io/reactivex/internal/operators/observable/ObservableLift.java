package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {
    final ObservableOperator<? extends R, ? super T> operator;

    public ObservableLift(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.operator = observableOperator;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            observer = this.operator.apply(observer);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Operator ");
            stringBuilder.append(this.operator);
            stringBuilder.append(" returned a null Observer");
            this.source.subscribe((Observer) ObjectHelper.requireNonNull(observer, stringBuilder.toString()));
        } catch (Observer<? super R> observer2) {
            throw observer2;
        } catch (Observer<? super R> observer22) {
            Exceptions.throwIfFatal(observer22);
            RxJavaPlugins.onError(observer22);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(observer22);
        }
    }
}
