package org.apache.commons.cli;

import kotlin.text.Typography;

public class PatternOptionBuilder {
    public static final Class CLASS_VALUE;
    public static final Class DATE_VALUE;
    public static final Class EXISTING_FILE_VALUE;
    public static final Class FILES_VALUE;
    public static final Class FILE_VALUE;
    public static final Class NUMBER_VALUE;
    public static final Class OBJECT_VALUE;
    public static final Class STRING_VALUE;
    public static final Class URL_VALUE;
    static /* synthetic */ Class array$Ljava$io$File;
    static /* synthetic */ Class class$java$io$File;
    static /* synthetic */ Class class$java$io$FileInputStream;
    static /* synthetic */ Class class$java$lang$Class;
    static /* synthetic */ Class class$java$lang$Number;
    static /* synthetic */ Class class$java$lang$Object;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$net$URL;
    static /* synthetic */ Class class$java$util$Date;

    public static boolean isValueCode(char c) {
        if (!(c == '@' || c == ':' || c == '%' || c == '+' || c == '#' || c == Typography.less || c == Typography.greater || c == '*' || c == '/')) {
            if (c != '!') {
                return false;
            }
        }
        return true;
    }

    static {
        Class class$;
        if (class$java$lang$String == null) {
            class$ = class$("java.lang.String");
            class$java$lang$String = class$;
        } else {
            class$ = class$java$lang$String;
        }
        STRING_VALUE = class$;
        if (class$java$lang$Object == null) {
            class$ = class$("java.lang.Object");
            class$java$lang$Object = class$;
        } else {
            class$ = class$java$lang$Object;
        }
        OBJECT_VALUE = class$;
        if (class$java$lang$Number == null) {
            class$ = class$("java.lang.Number");
            class$java$lang$Number = class$;
        } else {
            class$ = class$java$lang$Number;
        }
        NUMBER_VALUE = class$;
        if (class$java$util$Date == null) {
            class$ = class$("java.util.Date");
            class$java$util$Date = class$;
        } else {
            class$ = class$java$util$Date;
        }
        DATE_VALUE = class$;
        if (class$java$lang$Class == null) {
            class$ = class$("java.lang.Class");
            class$java$lang$Class = class$;
        } else {
            class$ = class$java$lang$Class;
        }
        CLASS_VALUE = class$;
        if (class$java$io$FileInputStream == null) {
            class$ = class$("java.io.FileInputStream");
            class$java$io$FileInputStream = class$;
        } else {
            class$ = class$java$io$FileInputStream;
        }
        EXISTING_FILE_VALUE = class$;
        if (class$java$io$File == null) {
            class$ = class$("java.io.File");
            class$java$io$File = class$;
        } else {
            class$ = class$java$io$File;
        }
        FILE_VALUE = class$;
        if (array$Ljava$io$File == null) {
            class$ = class$("[Ljava.io.File;");
            array$Ljava$io$File = class$;
        } else {
            class$ = array$Ljava$io$File;
        }
        FILES_VALUE = class$;
        if (class$java$net$URL == null) {
            class$ = class$("java.net.URL");
            class$java$net$URL = class$;
        } else {
            class$ = class$java$net$URL;
        }
        URL_VALUE = class$;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (String str2) {
            throw new NoClassDefFoundError().initCause(str2);
        }
    }

    public static Object getValueClass(char c) {
        if (c == '#') {
            return DATE_VALUE;
        }
        if (c == '%') {
            return NUMBER_VALUE;
        }
        if (c == '/') {
            return URL_VALUE;
        }
        if (c == ':') {
            return STRING_VALUE;
        }
        if (c == Typography.less) {
            return EXISTING_FILE_VALUE;
        }
        if (c == Typography.greater) {
            return FILE_VALUE;
        }
        if (c == '@') {
            return OBJECT_VALUE;
        }
        switch (c) {
            case '*':
                return FILES_VALUE;
            case '+':
                return CLASS_VALUE;
            default:
                return '\u0000';
        }
    }

    public static Options parsePattern(String str) {
        Options options = new Options();
        boolean z = false;
        Object obj = null;
        char c = ' ';
        int i = 0;
        boolean z2 = i;
        while (true) {
            boolean z3 = true;
            if (i >= str.length()) {
                break;
            }
            char charAt = str.charAt(i);
            if (!isValueCode(charAt)) {
                if (c != ' ') {
                    if (obj == null) {
                        z3 = false;
                    }
                    OptionBuilder.hasArg(z3);
                    OptionBuilder.isRequired(z2);
                    OptionBuilder.withType(obj);
                    options.addOption(OptionBuilder.create(c));
                    obj = null;
                    z2 = false;
                }
                c = charAt;
            } else if (charAt == '!') {
                z2 = true;
            } else {
                obj = getValueClass(charAt);
            }
            i++;
        }
        if (c != ' ') {
            if (obj != null) {
                z = true;
            }
            OptionBuilder.hasArg(z);
            OptionBuilder.isRequired(z2);
            OptionBuilder.withType(obj);
            options.addOption(OptionBuilder.create(c));
        }
        return options;
    }
}
