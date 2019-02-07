package com.aeries.mobileportal.utils;

import android.util.Xml;
import com.aeries.mobileportal.models.PrivateRSAKey;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0003¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/utils/XmlRSAKeyParseHelper;", "", "()V", "parse", "Lcom/aeries/mobileportal/models/PrivateRSAKey;", "inputStream", "Ljava/io/InputStream;", "readKey", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "readString", "", "tag", "skip", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: XmlRSAKeyParseHelper.kt */
public final class XmlRSAKeyParseHelper {
    @NotNull
    public final PrivateRSAKey parse(@NotNull InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        Closeable closeable = inputStream;
        Throwable th = (Throwable) null;
        try {
            InputStream inputStream2 = (InputStream) closeable;
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream2, null);
            newPullParser.nextTag();
            Intrinsics.checkExpressionValueIsNotNull(newPullParser, "parser");
            PrivateRSAKey readKey = readKey(newPullParser);
            CloseableKt.closeFinally(closeable, th);
            return readKey;
        } catch (Throwable th2) {
            CloseableKt.closeFinally(closeable, th);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.aeries.mobileportal.models.PrivateRSAKey readKey(org.xmlpull.v1.XmlPullParser r21) {
        /*
        r20 = this;
        r0 = r20;
        r1 = r21;
        r2 = "RSAKeyValue";
        r3 = 2;
        r4 = 0;
        r1.require(r3, r4, r2);
        r2 = "";
        r4 = "";
        r5 = "";
        r6 = "";
        r7 = "";
        r8 = "";
        r9 = "";
        r10 = "";
        r12 = r2;
        r13 = r4;
        r14 = r5;
        r15 = r6;
        r16 = r7;
        r17 = r8;
        r18 = r9;
        r19 = r10;
    L_0x0027:
        r2 = r21.next();
        r4 = 3;
        if (r2 == r4) goto L_0x00d2;
    L_0x002e:
        r2 = r21.getEventType();
        if (r2 == r3) goto L_0x0035;
    L_0x0034:
        goto L_0x0027;
    L_0x0035:
        r2 = r21.getName();
        if (r2 != 0) goto L_0x003d;
    L_0x003b:
        goto L_0x00cd;
    L_0x003d:
        r4 = r2.hashCode();
        switch(r4) {
            case -1861525809: goto L_0x00bc;
            case -1402879657: goto L_0x00ab;
            case 68: goto L_0x0099;
            case 80: goto L_0x0089;
            case 81: goto L_0x0079;
            case 2188: goto L_0x0068;
            case 2189: goto L_0x0057;
            case 692318017: goto L_0x0046;
            default: goto L_0x0044;
        };
    L_0x0044:
        goto L_0x00cd;
    L_0x0046:
        r4 = "InverseQ";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x00cd;
    L_0x004e:
        r2 = "InverseQ";
        r2 = r0.readString(r1, r2);
        r18 = r2;
        goto L_0x0027;
    L_0x0057:
        r4 = "DQ";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x00cd;
    L_0x005f:
        r2 = "DQ";
        r2 = r0.readString(r1, r2);
        r17 = r2;
        goto L_0x0027;
    L_0x0068:
        r4 = "DP";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x00cd;
    L_0x0070:
        r2 = "DP";
        r2 = r0.readString(r1, r2);
        r16 = r2;
        goto L_0x0027;
    L_0x0079:
        r4 = "Q";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x00cd;
    L_0x0081:
        r2 = "Q";
        r2 = r0.readString(r1, r2);
        r15 = r2;
        goto L_0x0027;
    L_0x0089:
        r4 = "P";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x00cd;
    L_0x0091:
        r2 = "P";
        r2 = r0.readString(r1, r2);
        r14 = r2;
        goto L_0x0027;
    L_0x0099:
        r4 = "D";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x00cd;
    L_0x00a1:
        r2 = "D";
        r2 = r0.readString(r1, r2);
        r19 = r2;
        goto L_0x0027;
    L_0x00ab:
        r4 = "Modulus";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x00cd;
    L_0x00b3:
        r2 = "Modulus";
        r2 = r0.readString(r1, r2);
        r12 = r2;
        goto L_0x0027;
    L_0x00bc:
        r4 = "Exponent";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x00cd;
    L_0x00c4:
        r2 = "Exponent";
        r2 = r0.readString(r1, r2);
        r13 = r2;
        goto L_0x0027;
    L_0x00cd:
        r20.skip(r21);
        goto L_0x0027;
    L_0x00d2:
        r1 = new com.aeries.mobileportal.models.PrivateRSAKey;
        r11 = r1;
        r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aeries.mobileportal.utils.XmlRSAKeyParseHelper.readKey(org.xmlpull.v1.XmlPullParser):com.aeries.mobileportal.models.PrivateRSAKey");
    }

    private final void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                switch (xmlPullParser.next()) {
                    case 2:
                        i++;
                        break;
                    case 3:
                        i--;
                        break;
                    default:
                        break;
                }
            }
            return;
        }
        throw ((Throwable) new IllegalStateException());
    }

    private final String readString(XmlPullParser xmlPullParser, String str) {
        String str2 = "";
        xmlPullParser.require(2, null, str);
        if (xmlPullParser.next() == 4) {
            str2 = xmlPullParser.getText();
            Intrinsics.checkExpressionValueIsNotNull(str2, "parser.text");
            xmlPullParser.nextTag();
        }
        xmlPullParser.require(3, null, str);
        return str2;
    }
}
