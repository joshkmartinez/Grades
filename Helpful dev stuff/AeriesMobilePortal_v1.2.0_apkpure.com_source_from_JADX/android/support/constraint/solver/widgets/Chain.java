package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ConstraintWidget[] constraintWidgetArr;
        int i3;
        int i4 = 0;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            constraintWidgetArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = i2;
            i2 = 0;
        } else {
            i2 = 2;
            int i5 = constraintWidgetContainer.mVerticalChainsSize;
            i3 = i5;
            constraintWidgetArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        while (i4 < i3) {
            ConstraintWidget constraintWidget = constraintWidgetArr[i4];
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, constraintWidget);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i2, constraintWidget)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, constraintWidget);
            }
            i4++;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r39, android.support.constraint.solver.LinearSystem r40, int r41, int r42, android.support.constraint.solver.widgets.ConstraintWidget r43) {
        /*
        r0 = r39;
        r9 = r40;
        r11 = r43;
        r1 = r0.mListDimensionBehaviors;
        r1 = r1[r41];
        r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r4 = 1;
        if (r1 != r2) goto L_0x0011;
    L_0x000f:
        r1 = r4;
        goto L_0x0012;
    L_0x0011:
        r1 = 0;
    L_0x0012:
        r12 = 0;
        if (r41 != 0) goto L_0x0044;
    L_0x0015:
        r2 = r39.isRtl();
        if (r2 == 0) goto L_0x0044;
    L_0x001b:
        r5 = r11;
        r2 = 0;
    L_0x001d:
        if (r2 != 0) goto L_0x0045;
    L_0x001f:
        r6 = r5.mListAnchors;
        r7 = r42 + 1;
        r6 = r6[r7];
        r6 = r6.mTarget;
        if (r6 == 0) goto L_0x003d;
    L_0x0029:
        r6 = r6.mOwner;
        r7 = r6.mListAnchors;
        r7 = r7[r42];
        r7 = r7.mTarget;
        if (r7 == 0) goto L_0x003d;
    L_0x0033:
        r7 = r6.mListAnchors;
        r7 = r7[r42];
        r7 = r7.mTarget;
        r7 = r7.mOwner;
        if (r7 == r5) goto L_0x003e;
    L_0x003d:
        r6 = r12;
    L_0x003e:
        if (r6 == 0) goto L_0x0042;
    L_0x0040:
        r5 = r6;
        goto L_0x001d;
    L_0x0042:
        r2 = r4;
        goto L_0x001d;
    L_0x0044:
        r5 = r11;
    L_0x0045:
        r2 = 2;
        r6 = 0;
        if (r41 != 0) goto L_0x006d;
    L_0x0049:
        r7 = r5.mHorizontalChainStyle;
        if (r7 != 0) goto L_0x004f;
    L_0x004d:
        r7 = r4;
        goto L_0x0050;
    L_0x004f:
        r7 = 0;
    L_0x0050:
        r8 = r5.mHorizontalChainStyle;
        if (r8 != r4) goto L_0x0056;
    L_0x0054:
        r8 = r4;
        goto L_0x0057;
    L_0x0056:
        r8 = 0;
    L_0x0057:
        r13 = r5.mHorizontalChainStyle;
        if (r13 != r2) goto L_0x005d;
    L_0x005b:
        r2 = r4;
        goto L_0x005e;
    L_0x005d:
        r2 = 0;
    L_0x005e:
        r15 = r2;
        r26 = r6;
        r16 = r7;
        r17 = r8;
        r13 = r11;
        r4 = r12;
        r7 = r4;
        r8 = r7;
        r14 = r8;
        r2 = 0;
        r6 = 0;
        goto L_0x0080;
    L_0x006d:
        r7 = r5.mVerticalChainStyle;
        if (r7 != 0) goto L_0x0073;
    L_0x0071:
        r7 = r4;
        goto L_0x0074;
    L_0x0073:
        r7 = 0;
    L_0x0074:
        r8 = r5.mVerticalChainStyle;
        if (r8 != r4) goto L_0x007a;
    L_0x0078:
        r8 = r4;
        goto L_0x007b;
    L_0x007a:
        r8 = 0;
    L_0x007b:
        r13 = r5.mVerticalChainStyle;
        if (r13 != r2) goto L_0x005d;
    L_0x007f:
        goto L_0x005b;
    L_0x0080:
        if (r2 != 0) goto L_0x0170;
    L_0x0082:
        r3 = r13.mListNextVisibleWidget;
        r3[r41] = r12;
        r3 = r13.getVisibility();
        r12 = 8;
        if (r3 == r12) goto L_0x0098;
    L_0x008e:
        if (r14 == 0) goto L_0x0094;
    L_0x0090:
        r3 = r14.mListNextVisibleWidget;
        r3[r41] = r13;
    L_0x0094:
        if (r8 != 0) goto L_0x0097;
    L_0x0096:
        r8 = r13;
    L_0x0097:
        r14 = r13;
    L_0x0098:
        r3 = r13.mListAnchors;
        r3 = r3[r42];
        r18 = r3.getMargin();
        r12 = r3.mTarget;
        if (r12 == 0) goto L_0x00b9;
    L_0x00a4:
        if (r13 == r11) goto L_0x00b9;
    L_0x00a6:
        r12 = r13.getVisibility();
        r27 = r2;
        r2 = 8;
        if (r12 == r2) goto L_0x00bb;
    L_0x00b0:
        r2 = r3.mTarget;
        r2 = r2.getMargin();
        r18 = r18 + r2;
        goto L_0x00bb;
    L_0x00b9:
        r27 = r2;
    L_0x00bb:
        r2 = r18;
        if (r15 == 0) goto L_0x00c5;
    L_0x00bf:
        if (r13 == r11) goto L_0x00c5;
    L_0x00c1:
        if (r13 == r8) goto L_0x00c5;
    L_0x00c3:
        r12 = 6;
        goto L_0x00c6;
    L_0x00c5:
        r12 = 1;
    L_0x00c6:
        if (r13 != r8) goto L_0x00d9;
    L_0x00c8:
        r28 = r8;
        r8 = r3.mSolverVariable;
        r29 = r14;
        r14 = r3.mTarget;
        r14 = r14.mSolverVariable;
        r30 = r5;
        r5 = 5;
        r9.addGreaterThan(r8, r14, r2, r5);
        goto L_0x00e9;
    L_0x00d9:
        r30 = r5;
        r28 = r8;
        r29 = r14;
        r5 = r3.mSolverVariable;
        r8 = r3.mTarget;
        r8 = r8.mSolverVariable;
        r14 = 6;
        r9.addGreaterThan(r5, r8, r2, r14);
    L_0x00e9:
        r5 = r3.mSolverVariable;
        r3 = r3.mTarget;
        r3 = r3.mSolverVariable;
        r9.addEquality(r5, r3, r2, r12);
        r2 = r13.mListNextMatchConstraintsWidget;
        r12 = 0;
        r2[r41] = r12;
        r2 = r13.getVisibility();
        r3 = 8;
        if (r2 == r3) goto L_0x012d;
    L_0x00ff:
        r2 = r13.mListDimensionBehaviors;
        r2 = r2[r41];
        r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r2 != r3) goto L_0x012d;
    L_0x0107:
        r6 = r6 + 1;
        r2 = r13.mWeight;
        r2 = r2[r41];
        r26 = r26 + r2;
        if (r7 != 0) goto L_0x0113;
    L_0x0111:
        r7 = r13;
        goto L_0x0117;
    L_0x0113:
        r2 = r4.mListNextMatchConstraintsWidget;
        r2[r41] = r13;
    L_0x0117:
        if (r1 == 0) goto L_0x012c;
    L_0x0119:
        r2 = r13.mListAnchors;
        r3 = r42 + 1;
        r2 = r2[r3];
        r2 = r2.mSolverVariable;
        r3 = r13.mListAnchors;
        r3 = r3[r42];
        r3 = r3.mSolverVariable;
        r4 = 0;
        r5 = 6;
        r9.addGreaterThan(r2, r3, r4, r5);
    L_0x012c:
        r4 = r13;
    L_0x012d:
        if (r1 == 0) goto L_0x0141;
    L_0x012f:
        r2 = r13.mListAnchors;
        r2 = r2[r42];
        r2 = r2.mSolverVariable;
        r3 = r0.mListAnchors;
        r3 = r3[r42];
        r3 = r3.mSolverVariable;
        r5 = 0;
        r8 = 6;
        r9.addGreaterThan(r2, r3, r5, r8);
        goto L_0x0142;
    L_0x0141:
        r5 = 0;
    L_0x0142:
        r2 = r13.mListAnchors;
        r3 = r42 + 1;
        r2 = r2[r3];
        r2 = r2.mTarget;
        if (r2 == 0) goto L_0x0160;
    L_0x014c:
        r2 = r2.mOwner;
        r3 = r2.mListAnchors;
        r3 = r3[r42];
        r3 = r3.mTarget;
        if (r3 == 0) goto L_0x0160;
    L_0x0156:
        r3 = r2.mListAnchors;
        r3 = r3[r42];
        r3 = r3.mTarget;
        r3 = r3.mOwner;
        if (r3 == r13) goto L_0x0161;
    L_0x0160:
        r2 = r12;
    L_0x0161:
        if (r2 == 0) goto L_0x0167;
    L_0x0163:
        r13 = r2;
        r2 = r27;
        goto L_0x0168;
    L_0x0167:
        r2 = 1;
    L_0x0168:
        r8 = r28;
        r14 = r29;
        r5 = r30;
        goto L_0x0080;
    L_0x0170:
        r30 = r5;
        r5 = 0;
        if (r14 == 0) goto L_0x0197;
    L_0x0175:
        r2 = r13.mListAnchors;
        r3 = r42 + 1;
        r2 = r2[r3];
        r2 = r2.mTarget;
        if (r2 == 0) goto L_0x0197;
    L_0x017f:
        r2 = r14.mListAnchors;
        r2 = r2[r3];
        r4 = r2.mSolverVariable;
        r5 = r13.mListAnchors;
        r3 = r5[r3];
        r3 = r3.mTarget;
        r3 = r3.mSolverVariable;
        r2 = r2.getMargin();
        r2 = -r2;
        r5 = 5;
        r9.addLowerThan(r4, r3, r2, r5);
        goto L_0x0198;
    L_0x0197:
        r5 = 5;
    L_0x0198:
        if (r1 == 0) goto L_0x01b4;
    L_0x019a:
        r0 = r0.mListAnchors;
        r1 = r42 + 1;
        r0 = r0[r1];
        r0 = r0.mSolverVariable;
        r2 = r13.mListAnchors;
        r2 = r2[r1];
        r2 = r2.mSolverVariable;
        r3 = r13.mListAnchors;
        r1 = r3[r1];
        r1 = r1.getMargin();
        r3 = 6;
        r9.addGreaterThan(r0, r2, r1, r3);
    L_0x01b4:
        if (r6 <= 0) goto L_0x0213;
    L_0x01b6:
        if (r7 == 0) goto L_0x0213;
    L_0x01b8:
        r0 = r7.mListNextMatchConstraintsWidget;
        r0 = r0[r41];
        if (r0 == 0) goto L_0x0210;
    L_0x01be:
        r1 = r7.mWeight;
        r19 = r1[r41];
        r1 = r0.mWeight;
        r21 = r1[r41];
        r1 = r7.mListAnchors;
        r1 = r1[r42];
        r1 = r1.mSolverVariable;
        r2 = r7.mListAnchors;
        r3 = r42 + 1;
        r2 = r2[r3];
        r2 = r2.mSolverVariable;
        r4 = r0.mListAnchors;
        r4 = r4[r42];
        r4 = r4.mSolverVariable;
        r6 = r0.mListAnchors;
        r3 = r6[r3];
        r3 = r3.mSolverVariable;
        if (r41 != 0) goto L_0x01e7;
    L_0x01e2:
        r6 = r7.mMatchConstraintDefaultWidth;
        r7 = r0.mMatchConstraintDefaultWidth;
        goto L_0x01eb;
    L_0x01e7:
        r6 = r7.mMatchConstraintDefaultHeight;
        r7 = r0.mMatchConstraintDefaultHeight;
    L_0x01eb:
        r5 = 3;
        if (r6 == 0) goto L_0x01f0;
    L_0x01ee:
        if (r6 != r5) goto L_0x01f5;
    L_0x01f0:
        if (r7 == 0) goto L_0x01f7;
    L_0x01f2:
        if (r7 != r5) goto L_0x01f5;
    L_0x01f4:
        goto L_0x01f7;
    L_0x01f5:
        r5 = 0;
        goto L_0x01f8;
    L_0x01f7:
        r5 = 1;
    L_0x01f8:
        if (r5 == 0) goto L_0x0210;
    L_0x01fa:
        r5 = r40.createRow();
        r18 = r5;
        r20 = r26;
        r22 = r1;
        r23 = r2;
        r24 = r4;
        r25 = r3;
        r18.createRowEqualMatchDimensions(r19, r20, r21, r22, r23, r24, r25);
        r9.addConstraint(r5);
    L_0x0210:
        r7 = r0;
        r5 = 5;
        goto L_0x01b6;
    L_0x0213:
        if (r8 == 0) goto L_0x0287;
    L_0x0215:
        if (r8 == r14) goto L_0x0219;
    L_0x0217:
        if (r15 == 0) goto L_0x0287;
    L_0x0219:
        r0 = r11.mListAnchors;
        r0 = r0[r42];
        r1 = r13.mListAnchors;
        r2 = r42 + 1;
        r1 = r1[r2];
        r3 = r11.mListAnchors;
        r3 = r3[r42];
        r3 = r3.mTarget;
        if (r3 == 0) goto L_0x0234;
    L_0x022b:
        r3 = r11.mListAnchors;
        r3 = r3[r42];
        r3 = r3.mTarget;
        r3 = r3.mSolverVariable;
        goto L_0x0235;
    L_0x0234:
        r3 = r12;
    L_0x0235:
        r4 = r13.mListAnchors;
        r4 = r4[r2];
        r4 = r4.mTarget;
        if (r4 == 0) goto L_0x0247;
    L_0x023d:
        r4 = r13.mListAnchors;
        r4 = r4[r2];
        r4 = r4.mTarget;
        r4 = r4.mSolverVariable;
        r5 = r4;
        goto L_0x0248;
    L_0x0247:
        r5 = r12;
    L_0x0248:
        if (r8 != r14) goto L_0x0252;
    L_0x024a:
        r0 = r8.mListAnchors;
        r0 = r0[r42];
        r1 = r8.mListAnchors;
        r1 = r1[r2];
    L_0x0252:
        if (r3 == 0) goto L_0x0281;
    L_0x0254:
        if (r5 == 0) goto L_0x0281;
    L_0x0256:
        if (r41 != 0) goto L_0x025d;
    L_0x0258:
        r11 = r30;
        r4 = r11.mHorizontalBiasPercent;
        goto L_0x0261;
    L_0x025d:
        r11 = r30;
        r4 = r11.mVerticalBiasPercent;
    L_0x0261:
        r6 = r0.getMargin();
        if (r14 != 0) goto L_0x0268;
    L_0x0267:
        r14 = r13;
    L_0x0268:
        r7 = r14.mListAnchors;
        r2 = r7[r2];
        r7 = r2.getMargin();
        r2 = r0.mSolverVariable;
        r10 = r1.mSolverVariable;
        r11 = 5;
        r0 = r40;
        r1 = r2;
        r2 = r3;
        r3 = r6;
        r6 = r10;
        r10 = r8;
        r8 = r11;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x0282;
    L_0x0281:
        r10 = r8;
    L_0x0282:
        r12 = r10;
    L_0x0283:
        r38 = r13;
        goto L_0x047e;
    L_0x0287:
        if (r16 == 0) goto L_0x036b;
    L_0x0289:
        if (r8 == 0) goto L_0x036b;
    L_0x028b:
        r0 = r8;
        r7 = r0;
    L_0x028d:
        if (r7 == 0) goto L_0x0368;
    L_0x028f:
        r1 = r7.mListNextVisibleWidget;
        r6 = r1[r41];
        if (r6 != 0) goto L_0x029f;
    L_0x0295:
        if (r7 != r14) goto L_0x0298;
    L_0x0297:
        goto L_0x029f;
    L_0x0298:
        r34 = r6;
        r19 = r7;
        r12 = r8;
        goto L_0x0360;
    L_0x029f:
        r1 = r7.mListAnchors;
        r1 = r1[r42];
        r2 = r1.mSolverVariable;
        r3 = r1.mTarget;
        if (r3 == 0) goto L_0x02ae;
    L_0x02a9:
        r3 = r1.mTarget;
        r3 = r3.mSolverVariable;
        goto L_0x02af;
    L_0x02ae:
        r3 = r12;
    L_0x02af:
        if (r0 == r7) goto L_0x02ba;
    L_0x02b1:
        r3 = r0.mListAnchors;
        r4 = r42 + 1;
        r3 = r3[r4];
        r3 = r3.mSolverVariable;
        goto L_0x02d0;
    L_0x02ba:
        if (r7 != r8) goto L_0x02d0;
    L_0x02bc:
        if (r0 != r7) goto L_0x02d0;
    L_0x02be:
        r3 = r11.mListAnchors;
        r3 = r3[r42];
        r3 = r3.mTarget;
        if (r3 == 0) goto L_0x02cf;
    L_0x02c6:
        r3 = r11.mListAnchors;
        r3 = r3[r42];
        r3 = r3.mTarget;
        r3 = r3.mSolverVariable;
        goto L_0x02d0;
    L_0x02cf:
        r3 = r12;
    L_0x02d0:
        r1 = r1.getMargin();
        r4 = r7.mListAnchors;
        r5 = r42 + 1;
        r4 = r4[r5];
        r4 = r4.getMargin();
        if (r6 == 0) goto L_0x02f5;
    L_0x02e0:
        r12 = r6.mListAnchors;
        r12 = r12[r42];
        r31 = r6;
        r6 = r12.mSolverVariable;
        r32 = r6;
        r6 = r12.mTarget;
        if (r6 == 0) goto L_0x02f3;
    L_0x02ee:
        r6 = r12.mTarget;
        r6 = r6.mSolverVariable;
        goto L_0x030e;
    L_0x02f3:
        r6 = 0;
        goto L_0x030e;
    L_0x02f5:
        r31 = r6;
        r6 = r13.mListAnchors;
        r6 = r6[r5];
        r12 = r6.mTarget;
        if (r12 == 0) goto L_0x0304;
    L_0x02ff:
        r6 = r12.mSolverVariable;
        r33 = r6;
        goto L_0x0306;
    L_0x0304:
        r33 = 0;
    L_0x0306:
        r6 = r7.mListAnchors;
        r6 = r6[r5];
        r6 = r6.mSolverVariable;
        r32 = r33;
    L_0x030e:
        if (r12 == 0) goto L_0x0315;
    L_0x0310:
        r12 = r12.getMargin();
        r4 = r4 + r12;
    L_0x0315:
        if (r0 == 0) goto L_0x0320;
    L_0x0317:
        r0 = r0.mListAnchors;
        r0 = r0[r5];
        r0 = r0.getMargin();
        r1 = r1 + r0;
    L_0x0320:
        if (r2 == 0) goto L_0x035b;
    L_0x0322:
        if (r3 == 0) goto L_0x035b;
    L_0x0324:
        if (r32 == 0) goto L_0x035b;
    L_0x0326:
        if (r6 == 0) goto L_0x035b;
    L_0x0328:
        if (r7 != r8) goto L_0x0334;
    L_0x032a:
        r0 = r8.mListAnchors;
        r0 = r0[r42];
        r0 = r0.getMargin();
        r12 = r0;
        goto L_0x0335;
    L_0x0334:
        r12 = r1;
    L_0x0335:
        if (r7 != r14) goto L_0x0341;
    L_0x0337:
        r0 = r14.mListAnchors;
        r0 = r0[r5];
        r0 = r0.getMargin();
        r15 = r0;
        goto L_0x0342;
    L_0x0341:
        r15 = r4;
    L_0x0342:
        r4 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r18 = 4;
        r0 = r40;
        r1 = r2;
        r2 = r3;
        r3 = r12;
        r5 = r32;
        r12 = r31;
        r19 = r7;
        r7 = r15;
        r34 = r12;
        r12 = r8;
        r8 = r18;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x0360;
    L_0x035b:
        r19 = r7;
        r12 = r8;
        r34 = r31;
    L_0x0360:
        r8 = r12;
        r0 = r19;
        r7 = r34;
        r12 = 0;
        goto L_0x028d;
    L_0x0368:
        r12 = r8;
        goto L_0x0283;
    L_0x036b:
        r12 = r8;
        if (r17 == 0) goto L_0x0283;
    L_0x036e:
        if (r12 == 0) goto L_0x0283;
    L_0x0370:
        r0 = r12;
        r8 = r0;
    L_0x0372:
        if (r8 == 0) goto L_0x0418;
    L_0x0374:
        r1 = r8.mListNextVisibleWidget;
        r1 = r1[r41];
        if (r8 == r12) goto L_0x0413;
    L_0x037a:
        if (r8 == r14) goto L_0x0413;
    L_0x037c:
        if (r1 == 0) goto L_0x0413;
    L_0x037e:
        if (r1 != r14) goto L_0x0382;
    L_0x0380:
        r7 = 0;
        goto L_0x0383;
    L_0x0382:
        r7 = r1;
    L_0x0383:
        r1 = r8.mListAnchors;
        r1 = r1[r42];
        r2 = r1.mSolverVariable;
        r3 = r1.mTarget;
        if (r3 == 0) goto L_0x0391;
    L_0x038d:
        r3 = r1.mTarget;
        r3 = r3.mSolverVariable;
    L_0x0391:
        r3 = r0.mListAnchors;
        r4 = r42 + 1;
        r3 = r3[r4];
        r3 = r3.mSolverVariable;
        r1 = r1.getMargin();
        r5 = r8.mListAnchors;
        r5 = r5[r4];
        r5 = r5.getMargin();
        if (r7 == 0) goto L_0x03bc;
    L_0x03a7:
        r6 = r7.mListAnchors;
        r6 = r6[r42];
        r35 = r7;
        r7 = r6.mSolverVariable;
        r36 = r7;
        r7 = r6.mTarget;
        if (r7 == 0) goto L_0x03ba;
    L_0x03b5:
        r7 = r6.mTarget;
        r7 = r7.mSolverVariable;
        goto L_0x03d9;
    L_0x03ba:
        r7 = 0;
        goto L_0x03d9;
    L_0x03bc:
        r35 = r7;
        r6 = r8.mListAnchors;
        r6 = r6[r4];
        r6 = r6.mTarget;
        if (r6 == 0) goto L_0x03cb;
    L_0x03c6:
        r7 = r6.mSolverVariable;
        r37 = r6;
        goto L_0x03ce;
    L_0x03cb:
        r37 = r6;
        r7 = 0;
    L_0x03ce:
        r6 = r8.mListAnchors;
        r6 = r6[r4];
        r6 = r6.mSolverVariable;
        r36 = r7;
        r7 = r6;
        r6 = r37;
    L_0x03d9:
        if (r6 == 0) goto L_0x03e0;
    L_0x03db:
        r6 = r6.getMargin();
        r5 = r5 + r6;
    L_0x03e0:
        r15 = r5;
        if (r0 == 0) goto L_0x03ec;
    L_0x03e3:
        r0 = r0.mListAnchors;
        r0 = r0[r4];
        r0 = r0.getMargin();
        r1 = r1 + r0;
    L_0x03ec:
        r4 = r1;
        if (r2 == 0) goto L_0x040d;
    L_0x03ef:
        if (r3 == 0) goto L_0x040d;
    L_0x03f1:
        if (r36 == 0) goto L_0x040d;
    L_0x03f3:
        if (r7 == 0) goto L_0x040d;
    L_0x03f5:
        r5 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r18 = 4;
        r0 = r40;
        r1 = r2;
        r2 = r3;
        r6 = 5;
        r3 = r4;
        r4 = r5;
        r5 = r36;
        r6 = r7;
        r19 = r35;
        r7 = r15;
        r15 = r8;
        r8 = r18;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x0410;
    L_0x040d:
        r15 = r8;
        r19 = r35;
    L_0x0410:
        r8 = r19;
        goto L_0x0415;
    L_0x0413:
        r15 = r8;
        r8 = r1;
    L_0x0415:
        r0 = r15;
        goto L_0x0372;
    L_0x0418:
        r0 = r12.mListAnchors;
        r0 = r0[r42];
        r1 = r11.mListAnchors;
        r1 = r1[r42];
        r1 = r1.mTarget;
        r2 = r14.mListAnchors;
        r3 = r42 + 1;
        r10 = r2[r3];
        r2 = r13.mListAnchors;
        r2 = r2[r3];
        r11 = r2.mTarget;
        if (r1 == 0) goto L_0x046b;
    L_0x0430:
        if (r12 == r14) goto L_0x0442;
    L_0x0432:
        r2 = r0.mSolverVariable;
        r1 = r1.mSolverVariable;
        r0 = r0.getMargin();
        r8 = 5;
        r9.addEquality(r2, r1, r0, r8);
    L_0x043e:
        r38 = r13;
        r13 = r8;
        goto L_0x046e;
    L_0x0442:
        r8 = 5;
        if (r11 == 0) goto L_0x043e;
    L_0x0445:
        r2 = r0.mSolverVariable;
        r3 = r1.mSolverVariable;
        r4 = r0.getMargin();
        r5 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r6 = r10.mSolverVariable;
        r7 = r11.mSolverVariable;
        r15 = r10.getMargin();
        r18 = 5;
        r0 = r40;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r15;
        r38 = r13;
        r13 = r8;
        r8 = r18;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x046e;
    L_0x046b:
        r38 = r13;
        r13 = 5;
    L_0x046e:
        if (r11 == 0) goto L_0x047e;
    L_0x0470:
        if (r12 == r14) goto L_0x047e;
    L_0x0472:
        r0 = r10.mSolverVariable;
        r1 = r11.mSolverVariable;
        r2 = r10.getMargin();
        r2 = -r2;
        r9.addEquality(r0, r1, r2, r13);
    L_0x047e:
        r13 = r14;
        if (r16 != 0) goto L_0x0483;
    L_0x0481:
        if (r17 == 0) goto L_0x04d3;
    L_0x0483:
        if (r12 == 0) goto L_0x04d3;
    L_0x0485:
        r0 = r12.mListAnchors;
        r0 = r0[r42];
        r1 = r13.mListAnchors;
        r2 = r42 + 1;
        r1 = r1[r2];
        r3 = r0.mTarget;
        if (r3 == 0) goto L_0x0498;
    L_0x0493:
        r3 = r0.mTarget;
        r3 = r3.mSolverVariable;
        goto L_0x0499;
    L_0x0498:
        r3 = 0;
    L_0x0499:
        r4 = r1.mTarget;
        if (r4 == 0) goto L_0x04a3;
    L_0x049d:
        r4 = r1.mTarget;
        r4 = r4.mSolverVariable;
        r5 = r4;
        goto L_0x04a4;
    L_0x04a3:
        r5 = 0;
    L_0x04a4:
        if (r12 != r13) goto L_0x04ae;
    L_0x04a6:
        r0 = r12.mListAnchors;
        r0 = r0[r42];
        r1 = r12.mListAnchors;
        r1 = r1[r2];
    L_0x04ae:
        if (r3 == 0) goto L_0x04d3;
    L_0x04b0:
        if (r5 == 0) goto L_0x04d3;
    L_0x04b2:
        r4 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r6 = r0.getMargin();
        if (r13 != 0) goto L_0x04bc;
    L_0x04ba:
        r13 = r38;
    L_0x04bc:
        r7 = r13.mListAnchors;
        r2 = r7[r2];
        r7 = r2.getMargin();
        r2 = r0.mSolverVariable;
        r8 = r1.mSolverVariable;
        r10 = 5;
        r0 = r40;
        r1 = r2;
        r2 = r3;
        r3 = r6;
        r6 = r8;
        r8 = r10;
        r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x04d3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ConstraintWidget):void");
    }
}
