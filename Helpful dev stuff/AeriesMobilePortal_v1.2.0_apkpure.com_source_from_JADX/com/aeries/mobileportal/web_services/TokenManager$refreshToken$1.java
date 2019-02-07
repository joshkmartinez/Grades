package com.aeries.mobileportal.web_services;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: TokenManager.kt */
final class TokenManager$refreshToken$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ObjectRef $newAuth;

    TokenManager$refreshToken$1(ObjectRef objectRef) {
        this.$newAuth = objectRef;
        super(1);
    }

    public final void invoke(@Nullable String str) {
        this.$newAuth.element = str;
    }
}
