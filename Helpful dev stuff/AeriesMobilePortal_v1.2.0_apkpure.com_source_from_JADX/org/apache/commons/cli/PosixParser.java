package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PosixParser extends Parser {
    private Option currentOption;
    private boolean eatTheRest;
    private Options options;
    private List tokens = new ArrayList();

    private void init() {
        this.eatTheRest = false;
        this.tokens.clear();
    }

    protected String[] flatten(Options options, String[] strArr, boolean z) {
        init();
        this.options = options;
        strArr = Arrays.asList(strArr).iterator();
        while (strArr.hasNext()) {
            String str = (String) strArr.next();
            if (str.startsWith(HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
                String str2;
                int indexOf = str.indexOf(61);
                if (indexOf == -1) {
                    str2 = str;
                } else {
                    str2 = str.substring(0, indexOf);
                }
                if (options.hasOption(str2)) {
                    this.currentOption = options.getOption(str2);
                    this.tokens.add(str2);
                    if (indexOf != -1) {
                        this.tokens.add(str.substring(indexOf + 1));
                    }
                } else {
                    processNonOptionToken(str, z);
                }
            } else if (HelpFormatter.DEFAULT_OPT_PREFIX.equals(str)) {
                this.tokens.add(str);
            } else if (str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                if (str.length() != 2) {
                    if (!options.hasOption(str)) {
                        burstToken(str, z);
                    }
                }
                processOptionToken(str, z);
            } else {
                processNonOptionToken(str, z);
            }
            gobble(strArr);
        }
        return (String[]) this.tokens.toArray(new String[this.tokens.size()]);
    }

    private void gobble(Iterator it) {
        if (this.eatTheRest) {
            while (it.hasNext()) {
                this.tokens.add(it.next());
            }
        }
    }

    private void processNonOptionToken(String str, boolean z) {
        if (z && !(this.currentOption && this.currentOption.hasArg())) {
            this.eatTheRest = true;
            this.tokens.add(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        }
        this.tokens.add(str);
    }

    private void processOptionToken(String str, boolean z) {
        if (z && !this.options.hasOption(str)) {
            this.eatTheRest = true;
        }
        if (this.options.hasOption(str)) {
            this.currentOption = this.options.getOption(str);
        }
        this.tokens.add(str);
    }

    protected void burstToken(String str, boolean z) {
        int i = 1;
        while (i < str.length()) {
            String valueOf = String.valueOf(str.charAt(i));
            if (this.options.hasOption(valueOf)) {
                List list = this.tokens;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                stringBuffer.append(valueOf);
                list.add(stringBuffer.toString());
                this.currentOption = this.options.getOption(valueOf);
                if (this.currentOption.hasArg()) {
                    int i2 = i + 1;
                    if (str.length() != i2) {
                        this.tokens.add(str.substring(i2));
                        return;
                    }
                }
                i++;
            } else if (z) {
                processNonOptionToken(str.substring(i), true);
                return;
            } else {
                this.tokens.add(str);
                return;
            }
        }
    }
}
