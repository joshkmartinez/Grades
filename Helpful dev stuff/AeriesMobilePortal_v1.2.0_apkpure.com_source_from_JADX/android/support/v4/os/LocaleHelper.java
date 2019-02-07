package android.support.v4.os;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.Locale;
import org.apache.commons.cli.HelpFormatter;

@RestrictTo({Scope.LIBRARY_GROUP})
final class LocaleHelper {
    LocaleHelper() {
    }

    static Locale forLanguageTag(String str) {
        String[] split;
        if (str.contains(HelpFormatter.DEFAULT_OPT_PREFIX)) {
            split = str.split(HelpFormatter.DEFAULT_OPT_PREFIX);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR)) {
            return new Locale(str);
        } else {
            split = str.split(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can not parse language tag: [");
        stringBuilder.append(str);
        stringBuilder.append("]");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static String toLanguageTag(Locale locale) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!(country == null || country.isEmpty())) {
            stringBuilder.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            stringBuilder.append(locale.getCountry());
        }
        return stringBuilder.toString();
    }
}
