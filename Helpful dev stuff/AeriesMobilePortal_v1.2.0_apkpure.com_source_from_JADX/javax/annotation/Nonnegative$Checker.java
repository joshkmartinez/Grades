package javax.annotation;

import javax.annotation.meta.TypeQualifierValidator;

public class Nonnegative$Checker implements TypeQualifierValidator<Nonnegative> {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.annotation.meta.When forConstantValue(javax.annotation.Nonnegative r6, java.lang.Object r7) {
        /*
        r5 = this;
        r6 = r7 instanceof java.lang.Number;
        if (r6 != 0) goto L_0x0007;
    L_0x0004:
        r6 = javax.annotation.meta.When.NEVER;
        return r6;
    L_0x0007:
        r7 = (java.lang.Number) r7;
        r6 = r7 instanceof java.lang.Long;
        r0 = 0;
        r1 = 1;
        if (r6 == 0) goto L_0x001b;
    L_0x000f:
        r6 = r7.longValue();
        r2 = 0;
        r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r4 >= 0) goto L_0x003f;
    L_0x0019:
        r0 = r1;
        goto L_0x003f;
    L_0x001b:
        r6 = r7 instanceof java.lang.Double;
        if (r6 == 0) goto L_0x002a;
    L_0x001f:
        r6 = r7.doubleValue();
        r2 = 0;
        r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r4 >= 0) goto L_0x003f;
    L_0x0029:
        goto L_0x0019;
    L_0x002a:
        r6 = r7 instanceof java.lang.Float;
        if (r6 == 0) goto L_0x0038;
    L_0x002e:
        r6 = r7.floatValue();
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 >= 0) goto L_0x003f;
    L_0x0037:
        goto L_0x0019;
    L_0x0038:
        r6 = r7.intValue();
        if (r6 >= 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0019;
    L_0x003f:
        if (r0 == 0) goto L_0x0044;
    L_0x0041:
        r6 = javax.annotation.meta.When.NEVER;
        return r6;
    L_0x0044:
        r6 = javax.annotation.meta.When.ALWAYS;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.annotation.Nonnegative$Checker.forConstantValue(javax.annotation.Nonnegative, java.lang.Object):javax.annotation.meta.When");
    }
}
