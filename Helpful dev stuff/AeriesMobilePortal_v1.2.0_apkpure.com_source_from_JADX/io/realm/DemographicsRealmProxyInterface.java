package io.realm;

import com.aeries.mobileportal.models.GenericAddress;

public interface DemographicsRealmProxyInterface {
    Integer realmGet$age();

    String realmGet$birthDate();

    String realmGet$contact1PhoneNumber();

    String realmGet$contact1Title();

    String realmGet$contact2PhoneNumber();

    String realmGet$contact2Title();

    String realmGet$correspondenceLanguageCode();

    String realmGet$correspondenceLanguageDescription();

    String realmGet$counselorEmailAddress();

    String realmGet$counselorName();

    Integer realmGet$counselorNumber();

    String realmGet$displayText();

    String realmGet$emailAddress();

    String realmGet$ethnicityCode();

    String realmGet$ethnicityDescription();

    String realmGet$firstName();

    String realmGet$gender();

    String realmGet$grade();

    String realmGet$languageFluencyCode();

    String realmGet$languageFluencyDescription();

    String realmGet$lastName();

    GenericAddress realmGet$mailingAddress();

    String realmGet$middleName();

    String realmGet$mobilePhone();

    String realmGet$parentGuardianEmailAddress();

    String realmGet$parentGuardianName();

    String realmGet$primaryPhoneNumber();

    String realmGet$raceCode();

    String realmGet$raceDescription();

    GenericAddress realmGet$residenceAddress();

    int realmGet$schoolCode();

    String realmGet$schoolName();

    int realmGet$studentId();

    void realmSet$age(Integer num);

    void realmSet$birthDate(String str);

    void realmSet$contact1PhoneNumber(String str);

    void realmSet$contact1Title(String str);

    void realmSet$contact2PhoneNumber(String str);

    void realmSet$contact2Title(String str);

    void realmSet$correspondenceLanguageCode(String str);

    void realmSet$correspondenceLanguageDescription(String str);

    void realmSet$counselorEmailAddress(String str);

    void realmSet$counselorName(String str);

    void realmSet$counselorNumber(Integer num);

    void realmSet$displayText(String str);

    void realmSet$emailAddress(String str);

    void realmSet$ethnicityCode(String str);

    void realmSet$ethnicityDescription(String str);

    void realmSet$firstName(String str);

    void realmSet$gender(String str);

    void realmSet$grade(String str);

    void realmSet$languageFluencyCode(String str);

    void realmSet$languageFluencyDescription(String str);

    void realmSet$lastName(String str);

    void realmSet$mailingAddress(GenericAddress genericAddress);

    void realmSet$middleName(String str);

    void realmSet$mobilePhone(String str);

    void realmSet$parentGuardianEmailAddress(String str);

    void realmSet$parentGuardianName(String str);

    void realmSet$primaryPhoneNumber(String str);

    void realmSet$raceCode(String str);

    void realmSet$raceDescription(String str);

    void realmSet$residenceAddress(GenericAddress genericAddress);

    void realmSet$schoolCode(int i);

    void realmSet$schoolName(String str);

    void realmSet$studentId(int i);
}
