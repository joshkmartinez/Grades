package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Option implements Cloneable, Serializable {
    public static final int UNINITIALIZED = -1;
    public static final int UNLIMITED_VALUES = -2;
    private static final long serialVersionUID = 1;
    private String argName;
    private String description;
    private String longOpt;
    private int numberOfArgs;
    private String opt;
    private boolean optionalArg;
    private boolean required;
    private Object type;
    private List values;
    private char valuesep;

    public Option(String str, String str2) throws IllegalArgumentException {
        this(str, null, false, str2);
    }

    public Option(String str, boolean z, String str2) throws IllegalArgumentException {
        this(str, null, z, str2);
    }

    public Option(String str, String str2, boolean z, String str3) throws IllegalArgumentException {
        this.argName = HelpFormatter.DEFAULT_ARG_NAME;
        this.numberOfArgs = -1;
        this.values = new ArrayList();
        OptionValidator.validateOption(str);
        this.opt = str;
        this.longOpt = str2;
        if (z) {
            this.numberOfArgs = 1;
        }
        this.description = str3;
    }

    public int getId() {
        return getKey().charAt(0);
    }

    String getKey() {
        if (this.opt == null) {
            return this.longOpt;
        }
        return this.opt;
    }

    public String getOpt() {
        return this.opt;
    }

    public Object getType() {
        return this.type;
    }

    public void setType(Object obj) {
        this.type = obj;
    }

    public String getLongOpt() {
        return this.longOpt;
    }

    public void setLongOpt(String str) {
        this.longOpt = str;
    }

    public void setOptionalArg(boolean z) {
        this.optionalArg = z;
    }

    public boolean hasOptionalArg() {
        return this.optionalArg;
    }

    public boolean hasLongOpt() {
        return this.longOpt != null;
    }

    public boolean hasArg() {
        if (this.numberOfArgs <= 0) {
            if (this.numberOfArgs != -2) {
                return false;
            }
        }
        return true;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean z) {
        this.required = z;
    }

    public void setArgName(String str) {
        this.argName = str;
    }

    public String getArgName() {
        return this.argName;
    }

    public boolean hasArgName() {
        return this.argName != null && this.argName.length() > 0;
    }

    public boolean hasArgs() {
        if (this.numberOfArgs <= 1) {
            return this.numberOfArgs == -2;
        } else {
            return true;
        }
    }

    public void setArgs(int i) {
        this.numberOfArgs = i;
    }

    public void setValueSeparator(char c) {
        this.valuesep = c;
    }

    public char getValueSeparator() {
        return this.valuesep;
    }

    public boolean hasValueSeparator() {
        return this.valuesep > '\u0000';
    }

    public int getArgs() {
        return this.numberOfArgs;
    }

    void addValueForProcessing(String str) {
        if (this.numberOfArgs != -1) {
            processValue(str);
            return;
        }
        throw new RuntimeException("NO_ARGS_ALLOWED");
    }

    private void processValue(String str) {
        if (hasValueSeparator()) {
            char valueSeparator = getValueSeparator();
            int indexOf = str.indexOf(valueSeparator);
            while (indexOf != -1) {
                if (this.values.size() == this.numberOfArgs - 1) {
                    break;
                }
                add(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(valueSeparator);
            }
        }
        add(str);
    }

    private void add(String str) {
        if (this.numberOfArgs > 0) {
            if (this.values.size() > this.numberOfArgs - 1) {
                throw new RuntimeException("Cannot add value, list full.");
            }
        }
        this.values.add(str);
    }

    public String getValue() {
        return hasNoValues() ? null : (String) this.values.get(0);
    }

    public String getValue(int i) throws IndexOutOfBoundsException {
        return hasNoValues() ? 0 : (String) this.values.get(i);
    }

    public String getValue(String str) {
        String value = getValue();
        return value != null ? value : str;
    }

    public String[] getValues() {
        return hasNoValues() ? null : (String[]) this.values.toArray(new String[this.values.size()]);
    }

    public List getValuesList() {
        return this.values;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ option: ");
        stringBuffer.append(this.opt);
        if (this.longOpt != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.longOpt);
        }
        stringBuffer.append(" ");
        if (hasArgs()) {
            stringBuffer.append("[ARG...]");
        } else if (hasArg()) {
            stringBuffer.append(" [ARG]");
        }
        stringBuffer.append(" :: ");
        stringBuffer.append(this.description);
        if (this.type != null) {
            stringBuffer.append(" :: ");
            stringBuffer.append(this.type);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    private boolean hasNoValues() {
        return this.values.isEmpty();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x003d;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x003d;
    L_0x0012:
        r5 = (org.apache.commons.cli.Option) r5;
        r2 = r4.opt;
        if (r2 == 0) goto L_0x0023;
    L_0x0018:
        r2 = r4.opt;
        r3 = r5.opt;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0028;
    L_0x0022:
        goto L_0x0027;
    L_0x0023:
        r2 = r5.opt;
        if (r2 == 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r2 = r4.longOpt;
        if (r2 == 0) goto L_0x0037;
    L_0x002c:
        r2 = r4.longOpt;
        r5 = r5.longOpt;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x003c;
    L_0x0036:
        goto L_0x003b;
    L_0x0037:
        r5 = r5.longOpt;
        if (r5 == 0) goto L_0x003c;
    L_0x003b:
        return r1;
    L_0x003c:
        return r0;
    L_0x003d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.Option.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (this.opt != null ? this.opt.hashCode() : 0);
        if (this.longOpt != null) {
            i = this.longOpt.hashCode();
        }
        return hashCode + i;
    }

    public Object clone() {
        try {
            Option option = (Option) super.clone();
            option.values = new ArrayList(this.values);
            return option;
        } catch (CloneNotSupportedException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("A CloneNotSupportedException was thrown: ");
            stringBuffer.append(e.getMessage());
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    void clearValues() {
        this.values.clear();
    }

    public boolean addValue(String str) {
        throw new UnsupportedOperationException("The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
    }
}
