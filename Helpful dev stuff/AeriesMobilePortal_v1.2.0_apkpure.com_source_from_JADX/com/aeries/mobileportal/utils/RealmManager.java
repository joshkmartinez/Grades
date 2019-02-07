package com.aeries.mobileportal.utils;

import android.content.Context;
import com.aeries.mobileportal.Migration;
import io.realm.Realm;
import io.realm.RealmConfiguration.Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/utils/RealmManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "close", "", "realm", "Lio/realm/Realm;", "getRealmInstance", "initRealm", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: RealmManager.kt */
public final class RealmManager {
    @NotNull
    private final Context context;

    public RealmManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void initRealm() {
        Realm.init(this.context);
        Realm.setDefaultConfiguration(new Builder().migration(new Migration()).schemaVersion(13).name("aeries.realm").build());
    }

    @NotNull
    public final Realm getRealmInstance() {
        Realm defaultInstance = Realm.getDefaultInstance();
        Intrinsics.checkExpressionValueIsNotNull(defaultInstance, "Realm.getDefaultInstance()");
        return defaultInstance;
    }

    public final void close(@NotNull Realm realm) {
        Intrinsics.checkParameterIsNotNull(realm, "realm");
        realm.close();
    }
}
