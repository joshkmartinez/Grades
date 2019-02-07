package com.jakewharton.retrofit2.adapter.rxjava2;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class RxJava2CallAdapterFactory extends Factory {
    private final Scheduler scheduler;

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            return new RxJava2CallAdapterFactory(scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    private RxJava2CallAdapterFactory(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public CallAdapter<?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        annotationArr = getRawType(type);
        if (annotationArr == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, false, true, false, false, false, true);
        }
        boolean z = annotationArr == Flowable.class;
        boolean z2 = annotationArr == Single.class;
        boolean z3 = annotationArr == Maybe.class;
        if (annotationArr != Observable.class && !z && !z2 && !z3) {
            return null;
        }
        if ((type instanceof ParameterizedType) == null) {
            type = !z ? z2 ? "Single" : "Observable" : "Flowable";
            retrofit = new StringBuilder();
            retrofit.append(type);
            retrofit.append(" return type must be parameterized as ");
            retrofit.append(type);
            retrofit.append("<Foo> or ");
            retrofit.append(type);
            retrofit.append("<? extends Foo>");
            throw new IllegalStateException(retrofit.toString());
        }
        Type parameterUpperBound;
        boolean z4;
        boolean z5;
        type = getParameterUpperBound(0, (ParameterizedType) type);
        annotationArr = getRawType(type);
        if (annotationArr == Response.class) {
            if ((type instanceof ParameterizedType) != null) {
                parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
                z4 = false;
                z5 = z4;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (annotationArr != Result.class) {
            parameterUpperBound = type;
            z5 = true;
            z4 = false;
        } else if ((type instanceof ParameterizedType) != null) {
            parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
            z4 = true;
            z5 = false;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        return new RxJava2CallAdapter(parameterUpperBound, this.scheduler, z4, z5, z, z2, z3, false);
    }
}
