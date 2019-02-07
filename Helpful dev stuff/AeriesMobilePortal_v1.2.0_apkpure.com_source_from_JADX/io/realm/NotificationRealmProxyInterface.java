package io.realm;

public interface NotificationRealmProxyInterface {
    String realmGet$dateCreated();

    String realmGet$dateRead();

    String realmGet$name();

    String realmGet$notificationID();

    String realmGet$notificationMessage();

    int realmGet$schoolCode();

    String realmGet$schoolName();

    String realmGet$ssoUrl();

    String realmGet$status();

    int realmGet$userID();

    String realmGet$userType();

    void realmSet$dateCreated(String str);

    void realmSet$dateRead(String str);

    void realmSet$name(String str);

    void realmSet$notificationID(String str);

    void realmSet$notificationMessage(String str);

    void realmSet$schoolCode(int i);

    void realmSet$schoolName(String str);

    void realmSet$ssoUrl(String str);

    void realmSet$status(String str);

    void realmSet$userID(int i);

    void realmSet$userType(String str);
}
