package com.aeries.mobileportal.interactors.login;

import com.aeries.mobileportal.BuildConfig;
import com.aeries.mobileportal.models.ServerInfo;
import com.aeries.mobileportal.models.User;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/ServerInfo;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: LoginInteractor.kt */
final class LoginInteractor$getServerInfo$1<T> implements Consumer<ServerInfo> {
    final /* synthetic */ LoginCallback $callback;
    final /* synthetic */ User $user;
    final /* synthetic */ LoginInteractor this$0;

    LoginInteractor$getServerInfo$1(LoginInteractor loginInteractor, User user, LoginCallback loginCallback) {
        this.this$0 = loginInteractor;
        this.$user = user;
        this.$callback = loginCallback;
    }

    public final void accept(ServerInfo serverInfo) {
        ConfigurationRepository configurationRepository = this.this$0.getConfigurationRepository();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[]{Integer.valueOf(serverInfo.getVersion().getMajor()), Integer.valueOf(serverInfo.getVersion().getMinor()), Integer.valueOf(serverInfo.getVersion().getBuild()), Integer.valueOf(serverInfo.getVersion().getRevision())};
        String format = String.format("%02d.%02d.%02d.%02d", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        configurationRepository.setPortalVersion(format);
        if (serverInfo.getAppEnabled()) {
            serverInfo = this.this$0.getConfigurationRepository().getNonFormattedPortalVersion();
            if (serverInfo == null) {
                Intrinsics.throwNpe();
            }
            if (serverInfo.compareTo(BuildConfig.ENCRYPTION) < null) {
                this.$user.useOldKeys();
            }
            this.$callback.onAppEnabled(this.$user);
            return;
        }
        this.$callback.onAppDisabled(serverInfo.getMessage());
    }
}
