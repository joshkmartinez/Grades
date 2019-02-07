package org.apache.commons.cli;

public class AlreadySelectedException extends ParseException {
    private OptionGroup group;
    private Option option;

    public AlreadySelectedException(String str) {
        super(str);
    }

    public AlreadySelectedException(OptionGroup optionGroup, Option option) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The option '");
        stringBuffer.append(option.getKey());
        stringBuffer.append("' was specified but an option from this group ");
        stringBuffer.append("has already been selected: '");
        stringBuffer.append(optionGroup.getSelected());
        stringBuffer.append("'");
        this(stringBuffer.toString());
        this.group = optionGroup;
        this.option = option;
    }

    public OptionGroup getOptionGroup() {
        return this.group;
    }

    public Option getOption() {
        return this.option;
    }
}
