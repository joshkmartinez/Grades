package com.aeries.mobileportal.models;

import com.aeries.mobileportal.utils.XmlRSAKeyParseHelper;
import java.io.ByteArrayInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, d2 = {"Lcom/aeries/mobileportal/models/PrivateRSAKey;", "", "modulus", "", "exponent", "p", "q", "dp", "dq", "inverseQ", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getD", "()Ljava/lang/String;", "getDp", "getDq", "getExponent", "getInverseQ", "getModulus", "getP", "getQ", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: PrivateRSAKey.kt */
public final class PrivateRSAKey {
    public static final Companion Companion = new Companion();
    private static final XmlRSAKeyParseHelper xmlParser = new XmlRSAKeyParseHelper();
    @NotNull
    private final String f11d;
    @NotNull
    private final String dp;
    @NotNull
    private final String dq;
    @NotNull
    private final String exponent;
    @NotNull
    private final String inverseQ;
    @NotNull
    private final String modulus;
    @NotNull
    private final String f12p;
    @NotNull
    private final String f13q;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/models/PrivateRSAKey$Companion;", "", "()V", "xmlParser", "Lcom/aeries/mobileportal/utils/XmlRSAKeyParseHelper;", "getKeyFromXml", "Lcom/aeries/mobileportal/models/PrivateRSAKey;", "xml", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: PrivateRSAKey.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PrivateRSAKey getKeyFromXml(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "xml");
            XmlRSAKeyParseHelper access$getXmlParser$cp = PrivateRSAKey.xmlParser;
            str = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).getBytes(charset)");
            return access$getXmlParser$cp.parse(new ByteArrayInputStream(str));
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ PrivateRSAKey copy$default(PrivateRSAKey privateRSAKey, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        PrivateRSAKey privateRSAKey2 = privateRSAKey;
        int i2 = i;
        return privateRSAKey.copy((i2 & 1) != 0 ? privateRSAKey2.modulus : str, (i2 & 2) != 0 ? privateRSAKey2.exponent : str2, (i2 & 4) != 0 ? privateRSAKey2.f12p : str3, (i2 & 8) != 0 ? privateRSAKey2.f13q : str4, (i2 & 16) != 0 ? privateRSAKey2.dp : str5, (i2 & 32) != 0 ? privateRSAKey2.dq : str6, (i2 & 64) != 0 ? privateRSAKey2.inverseQ : str7, (i2 & 128) != 0 ? privateRSAKey2.f11d : str8);
    }

    @NotNull
    public final String component1() {
        return this.modulus;
    }

    @NotNull
    public final String component2() {
        return this.exponent;
    }

    @NotNull
    public final String component3() {
        return this.f12p;
    }

    @NotNull
    public final String component4() {
        return this.f13q;
    }

    @NotNull
    public final String component5() {
        return this.dp;
    }

    @NotNull
    public final String component6() {
        return this.dq;
    }

    @NotNull
    public final String component7() {
        return this.inverseQ;
    }

    @NotNull
    public final String component8() {
        return this.f11d;
    }

    @NotNull
    public final PrivateRSAKey copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        String str9 = str;
        Intrinsics.checkParameterIsNotNull(str9, "modulus");
        String str10 = str2;
        Intrinsics.checkParameterIsNotNull(str10, "exponent");
        String str11 = str3;
        Intrinsics.checkParameterIsNotNull(str11, "p");
        String str12 = str4;
        Intrinsics.checkParameterIsNotNull(str12, "q");
        String str13 = str5;
        Intrinsics.checkParameterIsNotNull(str13, "dp");
        String str14 = str6;
        Intrinsics.checkParameterIsNotNull(str14, "dq");
        String str15 = str7;
        Intrinsics.checkParameterIsNotNull(str15, "inverseQ");
        String str16 = str8;
        Intrinsics.checkParameterIsNotNull(str16, "d");
        return new PrivateRSAKey(str9, str10, str11, str12, str13, str14, str15, str16);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PrivateRSAKey) {
                PrivateRSAKey privateRSAKey = (PrivateRSAKey) obj;
                if (Intrinsics.areEqual(this.modulus, privateRSAKey.modulus) && Intrinsics.areEqual(this.exponent, privateRSAKey.exponent) && Intrinsics.areEqual(this.f12p, privateRSAKey.f12p) && Intrinsics.areEqual(this.f13q, privateRSAKey.f13q) && Intrinsics.areEqual(this.dp, privateRSAKey.dp) && Intrinsics.areEqual(this.dq, privateRSAKey.dq) && Intrinsics.areEqual(this.inverseQ, privateRSAKey.inverseQ) && Intrinsics.areEqual(this.f11d, privateRSAKey.f11d)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.modulus;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.exponent;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f12p;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f13q;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.dp;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.dq;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.inverseQ;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f11d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PrivateRSAKey(modulus=");
        stringBuilder.append(this.modulus);
        stringBuilder.append(", exponent=");
        stringBuilder.append(this.exponent);
        stringBuilder.append(", p=");
        stringBuilder.append(this.f12p);
        stringBuilder.append(", q=");
        stringBuilder.append(this.f13q);
        stringBuilder.append(", dp=");
        stringBuilder.append(this.dp);
        stringBuilder.append(", dq=");
        stringBuilder.append(this.dq);
        stringBuilder.append(", inverseQ=");
        stringBuilder.append(this.inverseQ);
        stringBuilder.append(", d=");
        stringBuilder.append(this.f11d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public PrivateRSAKey(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkParameterIsNotNull(str, "modulus");
        Intrinsics.checkParameterIsNotNull(str2, "exponent");
        Intrinsics.checkParameterIsNotNull(str3, "p");
        Intrinsics.checkParameterIsNotNull(str4, "q");
        Intrinsics.checkParameterIsNotNull(str5, "dp");
        Intrinsics.checkParameterIsNotNull(str6, "dq");
        Intrinsics.checkParameterIsNotNull(str7, "inverseQ");
        Intrinsics.checkParameterIsNotNull(str8, "d");
        this.modulus = str;
        this.exponent = str2;
        this.f12p = str3;
        this.f13q = str4;
        this.dp = str5;
        this.dq = str6;
        this.inverseQ = str7;
        this.f11d = str8;
    }

    @NotNull
    public final String getModulus() {
        return this.modulus;
    }

    @NotNull
    public final String getExponent() {
        return this.exponent;
    }

    @NotNull
    public final String getP() {
        return this.f12p;
    }

    @NotNull
    public final String getQ() {
        return this.f13q;
    }

    @NotNull
    public final String getDp() {
        return this.dp;
    }

    @NotNull
    public final String getDq() {
        return this.dq;
    }

    @NotNull
    public final String getInverseQ() {
        return this.inverseQ;
    }

    @NotNull
    public final String getD() {
        return this.f11d;
    }
}
