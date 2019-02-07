package io.realm;

import com.aeries.mobileportal.models.MockAssignment;

public interface MockGradebookRealmProxyInterface {
    RealmList<MockAssignment> realmGet$assignments();

    String realmGet$gradebookNumber();

    String realmGet$termCode();

    void realmSet$assignments(RealmList<MockAssignment> realmList);

    void realmSet$gradebookNumber(String str);

    void realmSet$termCode(String str);
}
