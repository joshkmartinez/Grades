package com.aeries.mobileportal.interactors.school.select;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: SchoolSearchInteractor.kt */
final class SchoolSearchInteractor$checkSchoolAvailability$2<T> implements Consumer<Throwable> {
    final /* synthetic */ SchoolSearchCallback $callback;

    SchoolSearchInteractor$checkSchoolAvailability$2(SchoolSearchCallback schoolSearchCallback) {
        this.$callback = schoolSearchCallback;
    }

    public final void accept(Throwable th) {
        SchoolSearchCallback schoolSearchCallback = this.$callback;
        String message = th.getMessage();
        if (message == null || StringsKt.contains$default(message, "CertPathValidatorException", false, 2, null)) {
            th = new Throwable("There is a problem with your school's setting. Please contact your school regarding \"SSL Certificate Error on android\".");
        }
        Intrinsics.checkExpressionValueIsNotNull(th, "if (it.message?.contains…ate Error on android\\\".\")");
        schoolSearchCallback.onAppAvailableError(th);
    }
}
