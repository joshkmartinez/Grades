package io.realm;

public interface GenericAddressRealmProxyInterface {
    String realmGet$address();

    String realmGet$city();

    String realmGet$state();

    String realmGet$typeCode();

    String realmGet$typeDescription();

    String realmGet$zipCode();

    String realmGet$zipExt();

    void realmSet$address(String str);

    void realmSet$city(String str);

    void realmSet$state(String str);

    void realmSet$typeCode(String str);

    void realmSet$typeDescription(String str);

    void realmSet$zipCode(String str);

    void realmSet$zipExt(String str);
}
