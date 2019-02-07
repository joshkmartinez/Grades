package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class DefaultDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private final DateFormat enUsFormat;
    private final DateFormat localFormat;

    DefaultDateTypeAdapter() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    DefaultDateTypeAdapter(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    DefaultDateTypeAdapter(int i) {
        this(DateFormat.getDateInstance(i, Locale.US), DateFormat.getDateInstance(i));
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    DefaultDateTypeAdapter(DateFormat dateFormat, DateFormat dateFormat2) {
        this.enUsFormat = dateFormat;
        this.localFormat = dateFormat2;
    }

    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        synchronized (this.localFormat) {
            jsonSerializationContext = new JsonPrimitive(this.enUsFormat.format(date));
        }
        return jsonSerializationContext;
    }

    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if ((jsonElement instanceof JsonPrimitive) != null) {
            jsonElement = deserializeToDate(jsonElement);
            if (type == Date.class) {
                return jsonElement;
            }
            if (type == Timestamp.class) {
                return new Timestamp(jsonElement.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(jsonElement.getTime());
            }
            jsonDeserializationContext = new StringBuilder();
            jsonDeserializationContext.append(getClass());
            jsonDeserializationContext.append(" cannot deserialize to ");
            jsonDeserializationContext.append(type);
            throw new IllegalArgumentException(jsonDeserializationContext.toString());
        }
        throw new JsonParseException("The date should be a string value");
    }

    private java.util.Date deserializeToDate(com.google.gson.JsonElement r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.localFormat;
        monitor-enter(r0);
        r1 = r4.localFormat;	 Catch:{ ParseException -> 0x0011 }
        r2 = r5.getAsString();	 Catch:{ ParseException -> 0x0011 }
        r1 = r1.parse(r2);	 Catch:{ ParseException -> 0x0011 }
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        return r1;
    L_0x000f:
        r5 = move-exception;
        goto L_0x0038;
    L_0x0011:
        r1 = r4.enUsFormat;	 Catch:{ ParseException -> 0x001d }
        r2 = r5.getAsString();	 Catch:{ ParseException -> 0x001d }
        r1 = r1.parse(r2);	 Catch:{ ParseException -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        return r1;
    L_0x001d:
        r1 = r5.getAsString();	 Catch:{ ParseException -> 0x002d }
        r2 = new java.text.ParsePosition;	 Catch:{ ParseException -> 0x002d }
        r3 = 0;	 Catch:{ ParseException -> 0x002d }
        r2.<init>(r3);	 Catch:{ ParseException -> 0x002d }
        r1 = com.google.gson.internal.bind.util.ISO8601Utils.parse(r1, r2);	 Catch:{ ParseException -> 0x002d }
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        return r1;	 Catch:{ all -> 0x000f }
    L_0x002d:
        r1 = move-exception;	 Catch:{ all -> 0x000f }
        r2 = new com.google.gson.JsonSyntaxException;	 Catch:{ all -> 0x000f }
        r5 = r5.getAsString();	 Catch:{ all -> 0x000f }
        r2.<init>(r5, r1);	 Catch:{ all -> 0x000f }
        throw r2;	 Catch:{ all -> 0x000f }
    L_0x0038:
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.DefaultDateTypeAdapter.deserializeToDate(com.google.gson.JsonElement):java.util.Date");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DefaultDateTypeAdapter.class.getSimpleName());
        stringBuilder.append('(');
        stringBuilder.append(this.localFormat.getClass().getSimpleName());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
