package io.realm;

import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.AssignmentCategory;

public interface GradebookRealmProxyInterface {
    RealmList<Assignment> realmGet$assignments();

    RealmList<AssignmentCategory> realmGet$categories();

    String realmGet$endDate();

    String realmGet$gradebookName();

    Integer realmGet$gradebookNumber();

    Integer realmGet$period();

    boolean realmGet$showWhatIf();

    String realmGet$startDate();

    String realmGet$status();

    String realmGet$termCode();

    String realmGet$termDescription();

    void realmSet$assignments(RealmList<Assignment> realmList);

    void realmSet$categories(RealmList<AssignmentCategory> realmList);

    void realmSet$endDate(String str);

    void realmSet$gradebookName(String str);

    void realmSet$gradebookNumber(Integer num);

    void realmSet$period(Integer num);

    void realmSet$showWhatIf(boolean z);

    void realmSet$startDate(String str);

    void realmSet$status(String str);

    void realmSet$termCode(String str);

    void realmSet$termDescription(String str);
}
