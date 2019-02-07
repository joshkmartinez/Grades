package com.aeries.mobileportal.web_services;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: TokenManager.kt */
final class TokenManager$getNewToken$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $oldToken;
    final /* synthetic */ ObjectRef $ret;
    final /* synthetic */ TokenManager this$0;

    TokenManager$getNewToken$1(TokenManager tokenManager, ObjectRef objectRef, String str) {
        this.this$0 = tokenManager;
        this.$ret = objectRef;
        this.$oldToken = str;
        super(1);
    }

    public final void invoke(@Nullable String str) {
        ObjectRef objectRef = this.$ret;
        if (Intrinsics.areEqual((Object) str, this.$oldToken)) {
            str = this.this$0.refreshToken(this.$oldToken);
        }
        objectRef.element = str;
    }
}
