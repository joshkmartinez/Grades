package com.aeries.mobileportal.dagger.modules;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import io.realm.RealmObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/aeries/mobileportal/dagger/modules/NetworkUtilsModule$gson$1", "Lcom/google/gson/ExclusionStrategy;", "()V", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "f", "Lcom/google/gson/FieldAttributes;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NetworkUtilsModule.kt */
public final class NetworkUtilsModule$gson$1 implements ExclusionStrategy {
    public boolean shouldSkipClass(@Nullable Class<?> cls) {
        return false;
    }

    NetworkUtilsModule$gson$1() {
    }

    public boolean shouldSkipField(@NotNull FieldAttributes fieldAttributes) {
        Intrinsics.checkParameterIsNotNull(fieldAttributes, "f");
        return Intrinsics.areEqual(fieldAttributes.getDeclaringClass(), (Object) RealmObject.class);
    }
}
