package javax.annotation;

import javax.annotation.meta.TypeQualifierValidator;

public class RegEx$Checker implements TypeQualifierValidator<RegEx> {
    public javax.annotation.meta.When forConstantValue(javax.annotation.RegEx r1, java.lang.Object r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = r2 instanceof java.lang.String;
        if (r1 != 0) goto L_0x0007;
    L_0x0004:
        r1 = javax.annotation.meta.When.NEVER;
        return r1;
    L_0x0007:
        r2 = (java.lang.String) r2;	 Catch:{ PatternSyntaxException -> 0x000f }
        java.util.regex.Pattern.compile(r2);	 Catch:{ PatternSyntaxException -> 0x000f }
        r1 = javax.annotation.meta.When.ALWAYS;
        return r1;
    L_0x000f:
        r1 = javax.annotation.meta.When.NEVER;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.annotation.RegEx$Checker.forConstantValue(javax.annotation.RegEx, java.lang.Object):javax.annotation.meta.When");
    }
}
