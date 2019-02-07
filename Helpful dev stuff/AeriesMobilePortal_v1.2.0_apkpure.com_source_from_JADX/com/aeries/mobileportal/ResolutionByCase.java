package com.aeries.mobileportal;

import com.facebook.stetho.server.http.HttpStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/ResolutionByCase;", "Lcom/aeries/mobileportal/Resolution;", "()V", "onForbidden", "", "onHttpException", "httpException", "Lretrofit2/HttpException;", "onInternalServerError", "onNotFound", "onNotImplemented", "onServiceUnavailable", "onUnauthorized", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ResolutionByCase.kt */
public abstract class ResolutionByCase implements Resolution {
    public abstract void onForbidden();

    public abstract void onInternalServerError();

    public abstract void onNotFound();

    public abstract void onNotImplemented();

    public abstract void onServiceUnavailable();

    public abstract void onUnauthorized();

    public void onHttpException(@NotNull HttpException httpException) {
        Intrinsics.checkParameterIsNotNull(httpException, "httpException");
        switch (httpException.code()) {
            case 401:
                onUnauthorized();
                return;
            case 403:
                onForbidden();
                return;
            case HttpStatus.HTTP_NOT_FOUND /*404*/:
                onNotFound();
                return;
            case HttpStatus.HTTP_INTERNAL_SERVER_ERROR /*500*/:
                onInternalServerError();
                return;
            case HttpStatus.HTTP_NOT_IMPLEMENTED /*501*/:
                onNotImplemented();
                return;
            case 503:
                onServiceUnavailable();
                return;
            default:
                onInternalServerError();
                return;
        }
    }
}
