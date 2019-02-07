package com.aeries.mobileportal.interactors.main;

import com.aeries.mobileportal.models.ServerInfo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: MainInteractor.kt */
final class MainInteractor$getPortalVersion$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ MainInteractor this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
    /* compiled from: MainInteractor.kt */
    static final class C07562<T> implements Consumer<Throwable> {
        public static final C07562 INSTANCE = new C07562();

        C07562() {
        }

        public final void accept(Throwable th) {
            th.printStackTrace();
        }
    }

    MainInteractor$getPortalVersion$1(MainInteractor mainInteractor) {
        this.this$0 = mainInteractor;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        this.this$0.getApplicationService().getServerInfo(str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ServerInfo>() {
            public final void accept(ServerInfo serverInfo) {
                ConfigurationRepository configurationRepository = this.this$0.getConfigurationRepository();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] objArr = new Object[]{Integer.valueOf(serverInfo.getVersion().getMajor()), Integer.valueOf(serverInfo.getVersion().getMinor()), Integer.valueOf(serverInfo.getVersion().getBuild()), Integer.valueOf(serverInfo.getVersion().getRevision())};
                serverInfo = String.format("%02d.%02d.%02d.%02d", Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(serverInfo, "java.lang.String.format(format, *args)");
                configurationRepository.setPortalVersion(serverInfo);
            }
        }, C07562.INSTANCE);
    }
}
