package io.realm;

import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.ViewPermission;

public interface StudentRealmProxyInterface {
    Demographics realmGet$demographics();

    int realmGet$studentID();

    RealmList<ViewPermission> realmGet$views();

    void realmSet$demographics(Demographics demographics);

    void realmSet$studentID(int i);

    void realmSet$views(RealmList<ViewPermission> realmList);
}
