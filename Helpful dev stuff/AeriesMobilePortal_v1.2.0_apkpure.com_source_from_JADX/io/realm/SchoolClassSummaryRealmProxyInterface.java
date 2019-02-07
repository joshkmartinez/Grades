package io.realm;

import com.aeries.mobileportal.models.ClassSummary;

public interface SchoolClassSummaryRealmProxyInterface {
    RealmList<ClassSummary> realmGet$classSummaries();

    boolean realmGet$hideScores();

    Integer realmGet$schoolCode();

    String realmGet$schoolName();

    boolean realmGet$showPeriod();

    Integer realmGet$studentID();

    void realmSet$classSummaries(RealmList<ClassSummary> realmList);

    void realmSet$hideScores(boolean z);

    void realmSet$schoolCode(Integer num);

    void realmSet$schoolName(String str);

    void realmSet$showPeriod(boolean z);

    void realmSet$studentID(Integer num);
}
