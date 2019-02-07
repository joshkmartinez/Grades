package org.apache.commons.cli;

import java.io.File;
import java.util.Date;

public class TypeHandler {
    public static Object createValue(String str, Object obj) throws ParseException {
        return createValue(str, (Class) obj);
    }

    public static Object createValue(String str, Class cls) throws ParseException {
        if (PatternOptionBuilder.STRING_VALUE == cls) {
            return str;
        }
        if (PatternOptionBuilder.OBJECT_VALUE == cls) {
            return createObject(str);
        }
        if (PatternOptionBuilder.NUMBER_VALUE == cls) {
            return createNumber(str);
        }
        if (PatternOptionBuilder.DATE_VALUE == cls) {
            return createDate(str);
        }
        if (PatternOptionBuilder.CLASS_VALUE == cls) {
            return createClass(str);
        }
        if (PatternOptionBuilder.FILE_VALUE == cls) {
            return createFile(str);
        }
        if (PatternOptionBuilder.EXISTING_FILE_VALUE == cls) {
            return createFile(str);
        }
        if (PatternOptionBuilder.FILES_VALUE == cls) {
            return createFiles(str);
        }
        return PatternOptionBuilder.URL_VALUE == cls ? createURL(str) : null;
    }

    public static java.lang.Object createObject(java.lang.String r3) throws org.apache.commons.cli.ParseException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x002c }
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = move-exception;
        r1 = new org.apache.commons.cli.ParseException;
        r2 = new java.lang.StringBuffer;
        r2.<init>();
        r0 = r0.getClass();
        r0 = r0.getName();
        r2.append(r0);
        r0 = "; Unable to create an instance of: ";
        r2.append(r0);
        r2.append(r3);
        r3 = r2.toString();
        r1.<init>(r3);
        throw r1;
    L_0x002c:
        r0 = new org.apache.commons.cli.ParseException;
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r2 = "Unable to find the class: ";
        r1.append(r2);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.TypeHandler.createObject(java.lang.String):java.lang.Object");
    }

    public static Number createNumber(String str) throws ParseException {
        try {
            if (str.indexOf(46) != -1) {
                return Double.valueOf(str);
            }
            return Long.valueOf(str);
        } catch (String str2) {
            throw new ParseException(str2.getMessage());
        }
    }

    public static java.lang.Class createClass(java.lang.String r3) throws org.apache.commons.cli.ParseException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = new org.apache.commons.cli.ParseException;
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r2 = "Unable to find the class: ";
        r1.append(r2);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.TypeHandler.createClass(java.lang.String):java.lang.Class");
    }

    public static Date createDate(String str) throws ParseException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static java.net.URL createURL(java.lang.String r3) throws org.apache.commons.cli.ParseException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0006 }
        r0.<init>(r3);	 Catch:{ MalformedURLException -> 0x0006 }
        return r0;
    L_0x0006:
        r0 = new org.apache.commons.cli.ParseException;
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r2 = "Unable to parse the URL: ";
        r1.append(r2);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.TypeHandler.createURL(java.lang.String):java.net.URL");
    }

    public static File createFile(String str) throws ParseException {
        return new File(str);
    }

    public static File[] createFiles(String str) throws ParseException {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
