package com.crashlytics.android.answers;

import kotlin.text.Typography;

public class CustomEvent extends AnswersEvent<CustomEvent> {
    private final String eventName;

    public CustomEvent(String str) {
        if (str != null) {
            this.eventName = this.validator.limitStringLength(str);
            return;
        }
        throw new NullPointerException("eventName must not be null");
    }

    String getCustomType() {
        return this.eventName;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{eventName:\"");
        stringBuilder.append(this.eventName);
        stringBuilder.append(Typography.quote);
        stringBuilder.append(", customAttributes:");
        stringBuilder.append(this.customAttributes);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
