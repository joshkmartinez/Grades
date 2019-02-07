package com.aeries.mobileportal.interactors.login;

import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.ViewPermission;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/ViewPermission;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: LoginInteractor.kt */
final class LoginInteractor$storeStudents$1$1 extends Lambda implements Function1<ViewPermission, Boolean> {
    public static final LoginInteractor$storeStudents$1$1 INSTANCE = new LoginInteractor$storeStudents$1$1();

    LoginInteractor$storeStudents$1$1() {
        super(1);
    }

    public final boolean invoke(ViewPermission viewPermission) {
        return Intrinsics.areEqual(viewPermission.getViewCode(), Permissions.ATD.name());
    }
}
