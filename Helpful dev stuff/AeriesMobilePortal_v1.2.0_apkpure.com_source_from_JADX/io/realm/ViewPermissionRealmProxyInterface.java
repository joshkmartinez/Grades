package io.realm;

public interface ViewPermissionRealmProxyInterface {
    boolean realmGet$canViewDetails();

    int realmGet$position();

    String realmGet$viewCode();

    String realmGet$viewDescription();

    void realmSet$canViewDetails(boolean z);

    void realmSet$position(int i);

    void realmSet$viewCode(String str);

    void realmSet$viewDescription(String str);
}
