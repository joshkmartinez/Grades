package io.realm;

public interface AssignmentRealmProxyInterface {
    String realmGet$assignmentDescription();

    Integer realmGet$assignmentNumber();

    String realmGet$category();

    String realmGet$comment();

    String realmGet$dateAssigned();

    String realmGet$dateCompleted();

    String realmGet$dateDue();

    String realmGet$description();

    String realmGet$gradebookName();

    boolean realmGet$isExtraCredit();

    boolean realmGet$isGraded();

    Boolean realmGet$isScoreValueACheckMark();

    Boolean realmGet$isScoreVisibleToParents();

    String realmGet$mark();

    Double realmGet$maxScore();

    Double realmGet$numberCorrect();

    Double realmGet$numberPossible();

    Double realmGet$percent();

    boolean realmGet$rubricAssignMent();

    Double realmGet$score();

    String realmGet$type();

    void realmSet$assignmentDescription(String str);

    void realmSet$assignmentNumber(Integer num);

    void realmSet$category(String str);

    void realmSet$comment(String str);

    void realmSet$dateAssigned(String str);

    void realmSet$dateCompleted(String str);

    void realmSet$dateDue(String str);

    void realmSet$description(String str);

    void realmSet$gradebookName(String str);

    void realmSet$isExtraCredit(boolean z);

    void realmSet$isGraded(boolean z);

    void realmSet$isScoreValueACheckMark(Boolean bool);

    void realmSet$isScoreVisibleToParents(Boolean bool);

    void realmSet$mark(String str);

    void realmSet$maxScore(Double d);

    void realmSet$numberCorrect(Double d);

    void realmSet$numberPossible(Double d);

    void realmSet$percent(Double d);

    void realmSet$rubricAssignMent(boolean z);

    void realmSet$score(Double d);

    void realmSet$type(String str);
}
