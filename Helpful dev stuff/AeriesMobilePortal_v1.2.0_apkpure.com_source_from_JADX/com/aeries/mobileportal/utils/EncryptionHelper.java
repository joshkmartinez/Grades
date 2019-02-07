package com.aeries.mobileportal.utils;

import android.util.Base64;
import com.aeries.mobileportal.models.PrivateRSAKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/utils/EncryptionHelper;", "", "()V", "currentDateTime", "", "getCurrentDateTime", "()Ljava/lang/String;", "setCurrentDateTime", "(Ljava/lang/String;)V", "decrypt", "", "raw", "encrypted", "encrypt", "clear", "getCurrentDateTimeUTC", "getDataPlusDateTime", "secretKey", "getPrivateKey", "Ljava/security/spec/RSAPrivateCrtKeySpec;", "key", "Lcom/aeries/mobileportal/models/PrivateRSAKey;", "hashData", "rsaEncrypt", "rawData", "toBigInteger", "Ljava/math/BigInteger;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: EncryptionHelper.kt */
public final class EncryptionHelper {
    @NotNull
    private String currentDateTime = getCurrentDateTimeUTC();

    @NotNull
    public final String getCurrentDateTime() {
        return this.currentDateTime;
    }

    public final void setCurrentDateTime(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.currentDateTime = str;
    }

    @NotNull
    public final String rsaEncrypt(@NotNull String str, @NotNull PrivateRSAKey privateRSAKey) {
        Intrinsics.checkParameterIsNotNull(str, "rawData");
        Intrinsics.checkParameterIsNotNull(privateRSAKey, "key");
        privateRSAKey = KeyFactory.getInstance("RSA").generatePrivate(getPrivateKey(privateRSAKey));
        str = hashData(getDataPlusDateTime(str));
        Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
        instance.init(1, (Key) privateRSAKey);
        str = Base64.encodeToString(instance.doFinal(Base64.decode(str, 2)), 2);
        Intrinsics.checkExpressionValueIsNotNull(str, "Base64.encodeToString(cipherData, Base64.NO_WRAP)");
        return str;
    }

    private final String hashData(String str) {
        MessageDigest instance = MessageDigest.getInstance(CommonUtils.SHA256_INSTANCE);
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            str = str.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).getBytes(charset)");
            str = Base64.encodeToString(instance.digest(str), 2);
            Intrinsics.checkExpressionValueIsNotNull(str, "Base64.encodeToString(hashedBytes, Base64.NO_WRAP)");
            return str;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final String getCurrentDateTimeUTC() {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm aaa");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(time);
        Intrinsics.checkExpressionValueIsNotNull(format, "date.format(currentTime)");
        return format;
    }

    private final String getDataPlusDateTime(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.currentDateTime);
        return stringBuilder.toString();
    }

    @NotNull
    public final byte[] encrypt(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "raw");
        Intrinsics.checkParameterIsNotNull(bArr2, "clear");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "RSA");
        bArr = Cipher.getInstance("RSA");
        bArr.init(1, secretKeySpec);
        bArr = bArr.doFinal(bArr2);
        Intrinsics.checkExpressionValueIsNotNull(bArr, "cipher.doFinal(clear)");
        return bArr;
    }

    @NotNull
    public final byte[] decrypt(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "raw");
        Intrinsics.checkParameterIsNotNull(bArr2, "encrypted");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "RSA");
        bArr = Cipher.getInstance("RSA");
        bArr.init(2, secretKeySpec);
        bArr = bArr.doFinal(bArr2);
        Intrinsics.checkExpressionValueIsNotNull(bArr, "cipher.doFinal(encrypted)");
        return bArr;
    }

    private final RSAPrivateCrtKeySpec getPrivateKey(PrivateRSAKey privateRSAKey) {
        return new RSAPrivateCrtKeySpec(toBigInteger(privateRSAKey.getModulus()), toBigInteger(privateRSAKey.getExponent()), toBigInteger(privateRSAKey.getD()), toBigInteger(privateRSAKey.getP()), toBigInteger(privateRSAKey.getQ()), toBigInteger(privateRSAKey.getDp()), toBigInteger(privateRSAKey.getDq()), toBigInteger(privateRSAKey.getInverseQ()));
    }

    private final BigInteger toBigInteger(@NotNull String str) {
        return new BigInteger(1, Base64.decode(str, 0));
    }
}
