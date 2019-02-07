package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.GenericAddressRealmProxyInterface;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/models/GenericAddress;", "Lio/realm/RealmObject;", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "city", "getCity", "setCity", "state", "getState", "setState", "typeCode", "getTypeCode", "setTypeCode", "typeDescription", "getTypeDescription", "setTypeDescription", "zipCode", "getZipCode", "setZipCode", "zipExt", "getZipExt", "setZipExt", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GenericAddress.kt */
public class GenericAddress extends RealmObject implements GenericAddressRealmProxyInterface {
    @SerializedName("Address")
    @Nullable
    @Expose
    private String address;
    @SerializedName("City")
    @Nullable
    @Expose
    private String city;
    @SerializedName("State")
    @Nullable
    @Expose
    private String state;
    @SerializedName("TypeCode")
    @Nullable
    @Expose
    private String typeCode;
    @SerializedName("TypeDescription")
    @Nullable
    @Expose
    private String typeDescription;
    @SerializedName("ZipCode")
    @Nullable
    @Expose
    private String zipCode;
    @SerializedName("ZipExt")
    @Nullable
    @Expose
    private String zipExt;

    public String realmGet$address() {
        return this.address;
    }

    public String realmGet$city() {
        return this.city;
    }

    public String realmGet$state() {
        return this.state;
    }

    public String realmGet$typeCode() {
        return this.typeCode;
    }

    public String realmGet$typeDescription() {
        return this.typeDescription;
    }

    public String realmGet$zipCode() {
        return this.zipCode;
    }

    public String realmGet$zipExt() {
        return this.zipExt;
    }

    public void realmSet$address(String str) {
        this.address = str;
    }

    public void realmSet$city(String str) {
        this.city = str;
    }

    public void realmSet$state(String str) {
        this.state = str;
    }

    public void realmSet$typeCode(String str) {
        this.typeCode = str;
    }

    public void realmSet$typeDescription(String str) {
        this.typeDescription = str;
    }

    public void realmSet$zipCode(String str) {
        this.zipCode = str;
    }

    public void realmSet$zipExt(String str) {
        this.zipExt = str;
    }

    public GenericAddress() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$address("");
        realmSet$city("");
        realmSet$state("");
        realmSet$zipCode("");
        realmSet$zipExt("");
        realmSet$typeCode("");
        realmSet$typeDescription("");
    }

    @Nullable
    public String getAddress() {
        return realmGet$address();
    }

    public void setAddress(@Nullable String str) {
        realmSet$address(str);
    }

    @Nullable
    public String getCity() {
        return realmGet$city();
    }

    public void setCity(@Nullable String str) {
        realmSet$city(str);
    }

    @Nullable
    public String getState() {
        return realmGet$state();
    }

    public void setState(@Nullable String str) {
        realmSet$state(str);
    }

    @Nullable
    public String getZipCode() {
        return realmGet$zipCode();
    }

    public void setZipCode(@Nullable String str) {
        realmSet$zipCode(str);
    }

    @Nullable
    public String getZipExt() {
        return realmGet$zipExt();
    }

    public void setZipExt(@Nullable String str) {
        realmSet$zipExt(str);
    }

    @Nullable
    public String getTypeCode() {
        return realmGet$typeCode();
    }

    public void setTypeCode(@Nullable String str) {
        realmSet$typeCode(str);
    }

    @Nullable
    public String getTypeDescription() {
        return realmGet$typeDescription();
    }

    public void setTypeDescription(@Nullable String str) {
        realmSet$typeDescription(str);
    }
}
