package io.realm;

public interface MockAssignmentRealmProxyInterface {
    String realmGet$assignmentNumber();

    String realmGet$category();

    String realmGet$mark();

    String realmGet$maxScore();

    String realmGet$score();

    void realmSet$assignmentNumber(String str);

    void realmSet$category(String str);

    void realmSet$mark(String str);

    void realmSet$maxScore(String str);

    void realmSet$score(String str);
}
