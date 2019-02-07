package io.realm;

import com.aeries.mobileportal.models.MockGradebook;

public interface CalculateScoreRequestRealmProxyInterface {
    MockGradebook realmGet$gradebook();

    String realmGet$schoolNumber();

    String realmGet$studentId();

    void realmSet$gradebook(MockGradebook mockGradebook);

    void realmSet$schoolNumber(String str);

    void realmSet$studentId(String str);
}
