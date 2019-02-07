package io.realm.internal.android;

import android.util.Base64;
import io.realm.exceptions.RealmException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {
    private static Pattern jsonDate = Pattern.compile("/Date\\((\\d*)(?:[+-]\\d*)?\\)/");
    private static Pattern numericOnly = Pattern.compile("-?\\d+");
    private static ParsePosition parsePosition = new ParsePosition(0);

    public static Date stringToDate(String str) {
        if (str != null) {
            if (str.length() != 0) {
                Matcher matcher = jsonDate.matcher(str);
                if (matcher.find()) {
                    return new Date(Long.parseLong(matcher.group(1)));
                }
                if (numericOnly.matcher(str).matches()) {
                    try {
                        return new Date(Long.parseLong(str));
                    } catch (String str2) {
                        throw new RealmException(str2.getMessage(), str2);
                    }
                }
                try {
                    parsePosition.setIndex(0);
                    return ISO8601Utils.parse(str2, parsePosition);
                } catch (String str22) {
                    throw new RealmException(str22.getMessage(), str22);
                }
            }
        }
        return null;
    }

    public static byte[] stringToBytes(String str) {
        if (str != null) {
            if (str.length() != 0) {
                return Base64.decode(str, 0);
            }
        }
        return new byte[0];
    }
}
