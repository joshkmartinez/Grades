package com.aeries.mobileportal;

import io.realm.DynamicRealmObject;
import io.realm.RealmObjectSchema.Function;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lio/realm/DynamicRealmObject;", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 10})
/* compiled from: Migration.kt */
final class Migration$migrate$4 implements Function {
    public static final Migration$migrate$4 INSTANCE = new Migration$migrate$4();

    Migration$migrate$4() {
    }

    public final void apply(DynamicRealmObject dynamicRealmObject) {
        dynamicRealmObject.setDouble("assign_tmp", (double) dynamicRealmObject.getInt("numberCorrect"));
    }
}
