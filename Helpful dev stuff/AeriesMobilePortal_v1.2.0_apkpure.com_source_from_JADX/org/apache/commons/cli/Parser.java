package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

public abstract class Parser implements CommandLineParser {
    protected CommandLine cmd;
    private Options options;
    private List requiredOptions;

    protected abstract String[] flatten(Options options, String[] strArr, boolean z);

    protected void setOptions(Options options) {
        this.options = options;
        this.requiredOptions = new ArrayList(options.getRequiredOptions());
    }

    protected Options getOptions() {
        return this.options;
    }

    protected List getRequiredOptions() {
        return this.requiredOptions;
    }

    public CommandLine parse(Options options, String[] strArr) throws ParseException {
        return parse(options, strArr, null, false);
    }

    public CommandLine parse(Options options, String[] strArr, Properties properties) throws ParseException {
        return parse(options, strArr, properties, false);
    }

    public CommandLine parse(Options options, String[] strArr, boolean z) throws ParseException {
        return parse(options, strArr, null, z);
    }

    public CommandLine parse(Options options, String[] strArr, Properties properties, boolean z) throws ParseException {
        for (Option clearValues : options.helpOptions()) {
            clearValues.clearValues();
        }
        setOptions(options);
        this.cmd = new CommandLine();
        options = null;
        if (strArr == null) {
            strArr = new String[0];
        }
        strArr = Arrays.asList(flatten(getOptions(), strArr, z)).listIterator();
        while (strArr.hasNext()) {
            String str = (String) strArr.next();
            if (!HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(str)) {
                if (HelpFormatter.DEFAULT_OPT_PREFIX.equals(str)) {
                    if (!z) {
                        this.cmd.addArg(str);
                        if (options == null) {
                            while (strArr.hasNext()) {
                                str = (String) strArr.next();
                                if (HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(str)) {
                                    this.cmd.addArg(str);
                                }
                            }
                        }
                    }
                } else if (!str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                    this.cmd.addArg(str);
                    if (z) {
                    }
                    if (options == null) {
                        while (strArr.hasNext()) {
                            str = (String) strArr.next();
                            if (HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(str)) {
                                this.cmd.addArg(str);
                            }
                        }
                    }
                } else if (!z || getOptions().hasOption(str)) {
                    processOption(str, strArr);
                    if (options == null) {
                        while (strArr.hasNext()) {
                            str = (String) strArr.next();
                            if (HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(str)) {
                                this.cmd.addArg(str);
                            }
                        }
                    }
                } else {
                    this.cmd.addArg(str);
                }
            }
            options = 1;
            if (options == null) {
                while (strArr.hasNext()) {
                    str = (String) strArr.next();
                    if (HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(str)) {
                        this.cmd.addArg(str);
                    }
                }
            }
        }
        processProperties(properties);
        checkRequiredOptions();
        return this.cmd;
    }

    protected void processProperties(java.util.Properties r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        if (r5 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r5.propertyNames();
    L_0x0007:
        r1 = r0.hasMoreElements();
        if (r1 == 0) goto L_0x005f;
    L_0x000d:
        r1 = r0.nextElement();
        r1 = r1.toString();
        r2 = r4.cmd;
        r2 = r2.hasOption(r1);
        if (r2 != 0) goto L_0x0007;
    L_0x001d:
        r2 = r4.getOptions();
        r2 = r2.getOption(r1);
        r1 = r5.getProperty(r1);
        r3 = r2.hasArg();
        if (r3 == 0) goto L_0x0040;
    L_0x002f:
        r3 = r2.getValues();
        if (r3 == 0) goto L_0x003c;
    L_0x0035:
        r3 = r2.getValues();
        r3 = r3.length;
        if (r3 != 0) goto L_0x0059;
    L_0x003c:
        r2.addValueForProcessing(r1);	 Catch:{ RuntimeException -> 0x0059 }
        goto L_0x0059;
    L_0x0040:
        r3 = "yes";
        r3 = r3.equalsIgnoreCase(r1);
        if (r3 != 0) goto L_0x0059;
    L_0x0048:
        r3 = "true";
        r3 = r3.equalsIgnoreCase(r1);
        if (r3 != 0) goto L_0x0059;
    L_0x0050:
        r3 = "1";
        r1 = r3.equalsIgnoreCase(r1);
        if (r1 != 0) goto L_0x0059;
    L_0x0058:
        goto L_0x005f;
    L_0x0059:
        r1 = r4.cmd;
        r1.addOption(r2);
        goto L_0x0007;
    L_0x005f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.Parser.processProperties(java.util.Properties):void");
    }

    protected void checkRequiredOptions() throws MissingOptionException {
        if (!getRequiredOptions().isEmpty()) {
            throw new MissingOptionException(getRequiredOptions());
        }
    }

    public void processArgs(org.apache.commons.cli.Option r3, java.util.ListIterator r4) throws org.apache.commons.cli.ParseException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
    L_0x0000:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x002d;
    L_0x0006:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r1 = r2.getOptions();
        r1 = r1.hasOption(r0);
        if (r1 == 0) goto L_0x0022;
    L_0x0016:
        r1 = "-";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0022;
    L_0x001e:
        r4.previous();
        goto L_0x002d;
    L_0x0022:
        r0 = org.apache.commons.cli.Util.stripLeadingAndTrailingQuotes(r0);	 Catch:{ RuntimeException -> 0x002a }
        r3.addValueForProcessing(r0);	 Catch:{ RuntimeException -> 0x002a }
        goto L_0x0000;
    L_0x002a:
        r4.previous();
    L_0x002d:
        r4 = r3.getValues();
        if (r4 != 0) goto L_0x0040;
    L_0x0033:
        r4 = r3.hasOptionalArg();
        if (r4 == 0) goto L_0x003a;
    L_0x0039:
        goto L_0x0040;
    L_0x003a:
        r4 = new org.apache.commons.cli.MissingArgumentException;
        r4.<init>(r3);
        throw r4;
    L_0x0040:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.Parser.processArgs(org.apache.commons.cli.Option, java.util.ListIterator):void");
    }

    protected void processOption(String str, ListIterator listIterator) throws ParseException {
        if (getOptions().hasOption(str)) {
            Option option = (Option) getOptions().getOption(str).clone();
            if (option.isRequired()) {
                getRequiredOptions().remove(option.getKey());
            }
            if (getOptions().getOptionGroup(option) != null) {
                OptionGroup optionGroup = getOptions().getOptionGroup(option);
                if (optionGroup.isRequired()) {
                    getRequiredOptions().remove(optionGroup);
                }
                optionGroup.setSelected(option);
            }
            if (option.hasArg()) {
                processArgs(option, listIterator);
            }
            this.cmd.addOption(option);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unrecognized option: ");
        stringBuffer.append(str);
        throw new UnrecognizedOptionException(stringBuffer.toString(), str);
    }
}
