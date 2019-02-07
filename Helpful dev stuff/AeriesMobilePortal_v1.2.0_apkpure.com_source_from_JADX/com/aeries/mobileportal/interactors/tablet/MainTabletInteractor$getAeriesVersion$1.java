package com.aeries.mobileportal.interactors.tablet;

import com.aeries.mobileportal.models.ServerInfo;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/ServerInfo;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: MainTabletInteractor.kt */
final class MainTabletInteractor$getAeriesVersion$1<T> implements Consumer<ServerInfo> {
    final /* synthetic */ MainTabletCallback $callback;

    MainTabletInteractor$getAeriesVersion$1(MainTabletCallback mainTabletCallback) {
        this.$callback = mainTabletCallback;
    }

    public final void accept(ServerInfo serverInfo) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        r1 = new Object[4];
        boolean z = false;
        r1[0] = Integer.valueOf(serverInfo.getVersion().getMajor());
        r1[1] = Integer.valueOf(serverInfo.getVersion().getMinor());
        r1[2] = Integer.valueOf(serverInfo.getVersion().getBuild());
        r1[3] = Integer.valueOf(serverInfo.getVersion().getRevision());
        serverInfo = String.format("%d%02d%02d%02d", Arrays.copyOf(r1, r1.length));
        Intrinsics.checkExpressionValueIsNotNull(serverInfo, "java.lang.String.format(format, *args)");
        MainTabletCallback mainTabletCallback = this.$callback;
        boolean z2 = serverInfo.compareTo("8171208") >= 0;
        if (serverInfo.compareTo("8171201") >= null) {
            z = true;
        }
        mainTabletCallback.setGradesViewsVisibility(z2, z);
    }
}
