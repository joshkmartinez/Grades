package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.Typography;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        Calendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder stringBuilder = new StringBuilder(("yyyy-MM-ddThh:mm:ss".length() + (z ? ".sss".length() : 0)) + (timeZone.getRawOffset() == 0 ? "Z" : "+hh:mm").length());
        padInt(stringBuilder, gregorianCalendar.get(1), "yyyy".length());
        char c = '-';
        stringBuilder.append('-');
        padInt(stringBuilder, gregorianCalendar.get(2) + 1, "MM".length());
        stringBuilder.append('-');
        padInt(stringBuilder, gregorianCalendar.get(5), "dd".length());
        stringBuilder.append('T');
        padInt(stringBuilder, gregorianCalendar.get(11), "hh".length());
        stringBuilder.append(':');
        padInt(stringBuilder, gregorianCalendar.get(12), "mm".length());
        stringBuilder.append(':');
        padInt(stringBuilder, gregorianCalendar.get(13), "ss".length());
        if (z) {
            stringBuilder.append(true);
            padInt(stringBuilder, gregorianCalendar.get(true), "sss".length());
        }
        z = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (z) {
            timeZone = z / 60000;
            int abs = Math.abs(timeZone / 60);
            timeZone = Math.abs(timeZone % 60);
            if (z < false) {
                c = '+';
            }
            stringBuilder.append(c);
            padInt(stringBuilder, abs, "hh".length());
            stringBuilder.append(':');
            padInt(stringBuilder, timeZone, "mm".length());
        } else {
            stringBuilder.append('Z');
        }
        return stringBuilder.toString();
    }

    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        Throwable e;
        String message;
        StringBuilder stringBuilder;
        ParseException parseException;
        String str2 = str;
        ParsePosition parsePosition2 = parsePosition;
        StringBuilder stringBuilder2;
        try {
            int index = parsePosition.getIndex();
            int i = index + 4;
            index = parseInt(str2, index, i);
            if (checkOffset(str2, i, '-')) {
                i++;
            }
            int i2 = i + 2;
            i = parseInt(str2, i, i2);
            if (checkOffset(str2, i2, '-')) {
                i2++;
            }
            int i3 = i2 + 2;
            i2 = parseInt(str2, i2, i3);
            boolean checkOffset = checkOffset(str2, i3, 'T');
            if (checkOffset || str.length() > i3) {
                int i4;
                int i5;
                int i6;
                int indexOfNonDigit;
                char charAt;
                TimeZone timeZone;
                String substring;
                StringBuilder stringBuilder3;
                TimeZone timeZone2;
                String id;
                Calendar gregorianCalendar;
                if (checkOffset) {
                    i3++;
                    i4 = i3 + 2;
                    i3 = parseInt(str2, i3, i4);
                    if (checkOffset(str2, i4, ':')) {
                        i4++;
                    }
                    i5 = i4 + 2;
                    i4 = parseInt(str2, i4, i5);
                    if (checkOffset(str2, i5, ':')) {
                        i5++;
                    }
                    if (str.length() > i5) {
                        char charAt2 = str2.charAt(i5);
                        if (!(charAt2 == 'Z' || charAt2 == '+' || charAt2 == '-')) {
                            i6 = i5 + 2;
                            i5 = parseInt(str2, i5, i6);
                            if (i5 > 59 && i5 < 63) {
                                i5 = 59;
                            }
                            if (checkOffset(str2, i6, '.')) {
                                i6++;
                                indexOfNonDigit = indexOfNonDigit(str2, i6 + 1);
                                int min = Math.min(indexOfNonDigit, i6 + 3);
                                int parseInt = parseInt(str2, i6, min);
                                switch (min - i6) {
                                    case 1:
                                        parseInt *= 100;
                                        break;
                                    case 2:
                                        parseInt *= 10;
                                        break;
                                    default:
                                        break;
                                }
                                i6 = indexOfNonDigit;
                                indexOfNonDigit = parseInt;
                                if (str.length() > i6) {
                                    charAt = str2.charAt(i6);
                                    if (charAt == 'Z') {
                                        timeZone = TIMEZONE_UTC;
                                        i6++;
                                    } else {
                                        if (charAt != '+') {
                                            if (charAt == '-') {
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("Invalid time zone indicator '");
                                                stringBuilder2.append(charAt);
                                                stringBuilder2.append("'");
                                                throw new IndexOutOfBoundsException(stringBuilder2.toString());
                                            }
                                        }
                                        substring = str2.substring(i6);
                                        if (substring.length() >= 5) {
                                            stringBuilder3 = new StringBuilder();
                                            stringBuilder3.append(substring);
                                            stringBuilder3.append("00");
                                            substring = stringBuilder3.toString();
                                        }
                                        i6 += substring.length();
                                        if (!"+0000".equals(substring)) {
                                            if ("+00:00".equals(substring)) {
                                                stringBuilder3 = new StringBuilder();
                                                stringBuilder3.append("GMT");
                                                stringBuilder3.append(substring);
                                                substring = stringBuilder3.toString();
                                                timeZone2 = TimeZone.getTimeZone(substring);
                                                id = timeZone2.getID();
                                                if (!id.equals(substring)) {
                                                    if (id.replace(":", "").equals(substring)) {
                                                        stringBuilder2 = new StringBuilder();
                                                        stringBuilder2.append("Mismatching time zone indicator: ");
                                                        stringBuilder2.append(substring);
                                                        stringBuilder2.append(" given, resolves to ");
                                                        stringBuilder2.append(timeZone2.getID());
                                                        throw new IndexOutOfBoundsException(stringBuilder2.toString());
                                                    }
                                                }
                                                timeZone = timeZone2;
                                            }
                                        }
                                        timeZone = TIMEZONE_UTC;
                                    }
                                    gregorianCalendar = new GregorianCalendar(timeZone);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, index);
                                    gregorianCalendar.set(2, i - 1);
                                    gregorianCalendar.set(5, i2);
                                    gregorianCalendar.set(11, i3);
                                    gregorianCalendar.set(12, i4);
                                    gregorianCalendar.set(13, i5);
                                    gregorianCalendar.set(14, indexOfNonDigit);
                                    parsePosition2.setIndex(i6);
                                    return gregorianCalendar.getTime();
                                }
                                throw new IllegalArgumentException("No time zone indicator");
                            }
                            indexOfNonDigit = 0;
                            if (str.length() > i6) {
                                throw new IllegalArgumentException("No time zone indicator");
                            }
                            charAt = str2.charAt(i6);
                            if (charAt == 'Z') {
                                if (charAt != '+') {
                                    if (charAt == '-') {
                                        stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append("Invalid time zone indicator '");
                                        stringBuilder2.append(charAt);
                                        stringBuilder2.append("'");
                                        throw new IndexOutOfBoundsException(stringBuilder2.toString());
                                    }
                                }
                                substring = str2.substring(i6);
                                if (substring.length() >= 5) {
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append(substring);
                                    stringBuilder3.append("00");
                                    substring = stringBuilder3.toString();
                                }
                                i6 += substring.length();
                                if ("+0000".equals(substring)) {
                                    if ("+00:00".equals(substring)) {
                                        stringBuilder3 = new StringBuilder();
                                        stringBuilder3.append("GMT");
                                        stringBuilder3.append(substring);
                                        substring = stringBuilder3.toString();
                                        timeZone2 = TimeZone.getTimeZone(substring);
                                        id = timeZone2.getID();
                                        if (id.equals(substring)) {
                                            if (id.replace(":", "").equals(substring)) {
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("Mismatching time zone indicator: ");
                                                stringBuilder2.append(substring);
                                                stringBuilder2.append(" given, resolves to ");
                                                stringBuilder2.append(timeZone2.getID());
                                                throw new IndexOutOfBoundsException(stringBuilder2.toString());
                                            }
                                        }
                                        timeZone = timeZone2;
                                    }
                                }
                                timeZone = TIMEZONE_UTC;
                            } else {
                                timeZone = TIMEZONE_UTC;
                                i6++;
                            }
                            gregorianCalendar = new GregorianCalendar(timeZone);
                            gregorianCalendar.setLenient(false);
                            gregorianCalendar.set(1, index);
                            gregorianCalendar.set(2, i - 1);
                            gregorianCalendar.set(5, i2);
                            gregorianCalendar.set(11, i3);
                            gregorianCalendar.set(12, i4);
                            gregorianCalendar.set(13, i5);
                            gregorianCalendar.set(14, indexOfNonDigit);
                            parsePosition2.setIndex(i6);
                            return gregorianCalendar.getTime();
                        }
                    }
                    i6 = i5;
                } else {
                    i6 = i3;
                    i3 = 0;
                    i4 = 0;
                }
                i5 = 0;
                indexOfNonDigit = 0;
                if (str.length() > i6) {
                    charAt = str2.charAt(i6);
                    if (charAt == 'Z') {
                        timeZone = TIMEZONE_UTC;
                        i6++;
                    } else {
                        if (charAt != '+') {
                            if (charAt == '-') {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("Invalid time zone indicator '");
                                stringBuilder2.append(charAt);
                                stringBuilder2.append("'");
                                throw new IndexOutOfBoundsException(stringBuilder2.toString());
                            }
                        }
                        substring = str2.substring(i6);
                        if (substring.length() >= 5) {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(substring);
                            stringBuilder3.append("00");
                            substring = stringBuilder3.toString();
                        }
                        i6 += substring.length();
                        if ("+0000".equals(substring)) {
                            if ("+00:00".equals(substring)) {
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append("GMT");
                                stringBuilder3.append(substring);
                                substring = stringBuilder3.toString();
                                timeZone2 = TimeZone.getTimeZone(substring);
                                id = timeZone2.getID();
                                if (id.equals(substring)) {
                                    if (id.replace(":", "").equals(substring)) {
                                        stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append("Mismatching time zone indicator: ");
                                        stringBuilder2.append(substring);
                                        stringBuilder2.append(" given, resolves to ");
                                        stringBuilder2.append(timeZone2.getID());
                                        throw new IndexOutOfBoundsException(stringBuilder2.toString());
                                    }
                                }
                                timeZone = timeZone2;
                            }
                        }
                        timeZone = TIMEZONE_UTC;
                    }
                    gregorianCalendar = new GregorianCalendar(timeZone);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, index);
                    gregorianCalendar.set(2, i - 1);
                    gregorianCalendar.set(5, i2);
                    gregorianCalendar.set(11, i3);
                    gregorianCalendar.set(12, i4);
                    gregorianCalendar.set(13, i5);
                    gregorianCalendar.set(14, indexOfNonDigit);
                    parsePosition2.setIndex(i6);
                    return gregorianCalendar.getTime();
                }
                throw new IllegalArgumentException("No time zone indicator");
            }
            Calendar gregorianCalendar2 = new GregorianCalendar(index, i - 1, i2);
            parsePosition2.setIndex(i3);
            return gregorianCalendar2.getTime();
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            if (str2 == null) {
                str2 = null;
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(Typography.quote);
                stringBuilder2.append(str2);
                stringBuilder2.append("'");
                str2 = stringBuilder2.toString();
            }
            message = e.getMessage();
            if (message == null || message.isEmpty()) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("(");
                stringBuilder2.append(e.getClass().getName());
                stringBuilder2.append(")");
                message = stringBuilder2.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to parse date [");
            stringBuilder.append(str2);
            stringBuilder.append("]: ");
            stringBuilder.append(message);
            parseException = new ParseException(stringBuilder.toString(), parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (NumberFormatException e3) {
            e = e3;
            if (str2 == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(Typography.quote);
                stringBuilder2.append(str2);
                stringBuilder2.append("'");
                str2 = stringBuilder2.toString();
            } else {
                str2 = null;
            }
            message = e.getMessage();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("(");
            stringBuilder2.append(e.getClass().getName());
            stringBuilder2.append(")");
            message = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to parse date [");
            stringBuilder.append(str2);
            stringBuilder.append("]: ");
            stringBuilder.append(message);
            parseException = new ParseException(stringBuilder.toString(), parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (IllegalArgumentException e4) {
            e = e4;
            if (str2 == null) {
                str2 = null;
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(Typography.quote);
                stringBuilder2.append(str2);
                stringBuilder2.append("'");
                str2 = stringBuilder2.toString();
            }
            message = e.getMessage();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("(");
            stringBuilder2.append(e.getClass().getName());
            stringBuilder2.append(")");
            message = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to parse date [");
            stringBuilder.append(str2);
            stringBuilder.append("]: ");
            stringBuilder.append(message);
            parseException = new ParseException(stringBuilder.toString(), parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return (i >= str.length() || str.charAt(i) != c) ? null : true;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int digit;
        if (i < i2) {
            int i3 = i + 1;
            digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                digit = -digit;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid number: ");
                stringBuilder.append(str.substring(i, i2));
                throw new NumberFormatException(stringBuilder.toString());
            }
        }
        digit = 0;
        i3 = i;
        while (i3 < i2) {
            int i4 = i3 + 1;
            i3 = Character.digit(str.charAt(i3), 10);
            if (i3 >= 0) {
                digit = (digit * 10) - i3;
                i3 = i4;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid number: ");
                stringBuilder.append(str.substring(i, i2));
                throw new NumberFormatException(stringBuilder.toString());
            }
        }
        return -digit;
    }

    private static void padInt(StringBuilder stringBuilder, int i, int i2) {
        i = Integer.toString(i);
        for (i2 -= i.length(); i2 > 0; i2--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(i);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt >= '0') {
                if (charAt <= '9') {
                    i++;
                }
            }
            return i;
        }
        return str.length();
    }
}
