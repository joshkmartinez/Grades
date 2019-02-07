package org.apache.commons.cli;

class OptionValidator {
    OptionValidator() {
    }

    static void validateOption(String str) throws IllegalArgumentException {
        if (str != null) {
            int i = 0;
            if (str.length() == 1) {
                str = str.charAt(0);
                if (!isValidOpt(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("illegal option value '");
                    stringBuffer.append(str);
                    stringBuffer.append("'");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            } else {
                str = str.toCharArray();
                while (i < str.length) {
                    if (isValidChar(str[i])) {
                        i++;
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("opt contains illegal character value '");
                        stringBuffer2.append(str[i]);
                        stringBuffer2.append("'");
                        throw new IllegalArgumentException(stringBuffer2.toString());
                    }
                }
            }
        }
    }

    private static boolean isValidOpt(char c) {
        if (!(isValidChar(c) || c == ' ' || c == '?')) {
            if (c != '@') {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidChar(char c) {
        return Character.isJavaIdentifierPart(c);
    }
}
