package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewDebug.FlagToString;
import android.view.ViewDebug.IntToString;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.ReflectionUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import com.facebook.stetho.inspector.helper.IntegerFormatter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ViewDescriptor extends AbstractChainedDescriptor<View> implements HighlightableDescriptor<View> {
    private static final String ACCESSIBILITY_STYLE_RULE_NAME = "Accessibility Properties";
    private static final String ID_NAME = "id";
    private static final String NONE_MAPPING = "<no mapping>";
    private static final String NONE_VALUE = "(none)";
    private static final String VIEW_STYLE_RULE_NAME = "<this_view>";
    private static final boolean sHasSupportNodeInfo = (ReflectionUtil.tryGetClassForName("android.support.v4.view.accessibility.AccessibilityNodeInfoCompat") != null);
    private final MethodInvoker mMethodInvoker;
    @GuardedBy("this")
    @Nullable
    private volatile List<ViewCSSProperty> mViewProperties;
    @Nullable
    private Pattern mWordBoundaryPattern;

    class C04211 implements Comparator<ViewCSSProperty> {
        C04211() {
        }

        public int compare(ViewCSSProperty viewCSSProperty, ViewCSSProperty viewCSSProperty2) {
            return viewCSSProperty.getCSSName().compareTo(viewCSSProperty2.getCSSName());
        }
    }

    private abstract class ViewCSSProperty {
        private final ExportedProperty mAnnotation;
        private final String mCSSName;

        public abstract Object getValue(View view) throws InvocationTargetException, IllegalAccessException;

        public ViewCSSProperty(String str, @Nullable ExportedProperty exportedProperty) {
            this.mCSSName = str;
            this.mAnnotation = exportedProperty;
        }

        public final String getCSSName() {
            return this.mCSSName;
        }

        @Nullable
        public final ExportedProperty getAnnotation() {
            return this.mAnnotation;
        }
    }

    private final class FieldBackedCSSProperty extends ViewCSSProperty {
        private final Field mField;

        public FieldBackedCSSProperty(Field field, String str, @Nullable ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mField = field;
            this.mField.setAccessible(true);
        }

        public Object getValue(View view) throws InvocationTargetException, IllegalAccessException {
            return this.mField.get(view);
        }
    }

    private final class MethodBackedCSSProperty extends ViewCSSProperty {
        private final Method mMethod;

        public MethodBackedCSSProperty(Method method, String str, @Nullable ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mMethod = method;
            this.mMethod.setAccessible(true);
        }

        public Object getValue(View view) throws InvocationTargetException, IllegalAccessException {
            return this.mMethod.invoke(view, new Object[0]);
        }
    }

    @Nullable
    public View getViewAndBoundsForHighlighting(View view, Rect rect) {
        return view;
    }

    private Pattern getWordBoundaryPattern() {
        if (this.mWordBoundaryPattern == null) {
            this.mWordBoundaryPattern = Pattern.compile("(?<=\\p{Lower})(?=\\p{Upper})");
        }
        return this.mWordBoundaryPattern;
    }

    private List<ViewCSSProperty> getViewProperties() {
        if (this.mViewProperties == null) {
            synchronized (this) {
                if (this.mViewProperties == null) {
                    List arrayList = new ArrayList();
                    int i = 0;
                    for (Method method : View.class.getDeclaredMethods()) {
                        ExportedProperty exportedProperty = (ExportedProperty) method.getAnnotation(ExportedProperty.class);
                        if (exportedProperty != null) {
                            arrayList.add(new MethodBackedCSSProperty(method, convertViewPropertyNameToCSSName(method.getName()), exportedProperty));
                        }
                    }
                    Field[] declaredFields = View.class.getDeclaredFields();
                    int length = declaredFields.length;
                    while (i < length) {
                        Field field = declaredFields[i];
                        ExportedProperty exportedProperty2 = (ExportedProperty) field.getAnnotation(ExportedProperty.class);
                        if (exportedProperty2 != null) {
                            arrayList.add(new FieldBackedCSSProperty(field, convertViewPropertyNameToCSSName(field.getName()), exportedProperty2));
                        }
                        i++;
                    }
                    Collections.sort(arrayList, new C04211());
                    this.mViewProperties = Collections.unmodifiableList(arrayList);
                }
            }
        }
        return this.mViewProperties;
    }

    public ViewDescriptor() {
        this(new MethodInvoker());
    }

    public ViewDescriptor(MethodInvoker methodInvoker) {
        this.mMethodInvoker = methodInvoker;
    }

    protected String onGetNodeName(View view) {
        view = view.getClass().getName();
        return StringUtil.removePrefix(view, "android.view.", StringUtil.removePrefix(view, "android.widget."));
    }

    protected void onGetAttributes(View view, AttributeAccumulator attributeAccumulator) {
        view = getIdAttribute(view);
        if (view != null) {
            attributeAccumulator.store(ID_NAME, view);
        }
    }

    protected void onSetAttributesAsText(View view, String str) {
        for (Entry entry : Descriptor.parseSetAttributesAsTextArg(str).entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("set");
            stringBuilder.append(capitalize((String) entry.getKey()));
            this.mMethodInvoker.invoke(view, stringBuilder.toString(), (String) entry.getValue());
        }
    }

    @Nullable
    private static String getIdAttribute(View view) {
        int id = view.getId();
        if (id == -1) {
            return null;
        }
        return ResourcesUtil.getIdStringQuietly(view, view.getResources(), id);
    }

    @Nullable
    public Object getElementToHighlightAtPosition(View view, int i, int i2, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        return view;
    }

    protected void onGetStyleRuleNames(View view, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        styleRuleNameAccumulator.store(VIEW_STYLE_RULE_NAME, false);
        if (sHasSupportNodeInfo != null) {
            styleRuleNameAccumulator.store(ACCESSIBILITY_STYLE_RULE_NAME, false);
        }
    }

    protected void onGetStyles(View view, String str, StyleAccumulator styleAccumulator) {
        if (VIEW_STYLE_RULE_NAME.equals(str)) {
            str = getViewProperties();
            int size = str.size();
            for (int i = 0; i < size; i++) {
                ViewCSSProperty viewCSSProperty = (ViewCSSProperty) str.get(i);
                try {
                    getStyleFromValue(view, viewCSSProperty.getCSSName(), viewCSSProperty.getValue(view), viewCSSProperty.getAnnotation(), styleAccumulator);
                } catch (Throwable e) {
                    if (!(e instanceof IllegalAccessException)) {
                        if (!(e instanceof InvocationTargetException)) {
                            throw ExceptionUtil.propagate(e);
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("failed to get style property ");
                    stringBuilder.append(viewCSSProperty.getCSSName());
                    stringBuilder.append(" of element= ");
                    stringBuilder.append(view.toString());
                    LogUtil.m19e(e, stringBuilder.toString());
                }
            }
        } else if (ACCESSIBILITY_STYLE_RULE_NAME.equals(str) != null && sHasSupportNodeInfo != null) {
            str = AccessibilityNodeInfoWrapper.getIgnored(view);
            getStyleFromValue(view, "ignored", Boolean.valueOf(str), null, styleAccumulator);
            if (str != null) {
                getStyleFromValue(view, "ignored-reasons", AccessibilityNodeInfoWrapper.getIgnoredReasons(view), null, styleAccumulator);
            }
            View view2 = view;
            getStyleFromValue(view2, "focusable", Boolean.valueOf(str ^ 1), null, styleAccumulator);
            if (str == null) {
                View view3 = view;
                StyleAccumulator styleAccumulator2 = styleAccumulator;
                getStyleFromValue(view3, "focusable-reasons", AccessibilityNodeInfoWrapper.getFocusableReasons(view), null, styleAccumulator2);
                view2 = view;
                getStyleFromValue(view2, "focused", Boolean.valueOf(AccessibilityNodeInfoWrapper.getIsAccessibilityFocused(view)), null, styleAccumulator);
                getStyleFromValue(view3, "description", AccessibilityNodeInfoWrapper.getDescription(view), null, styleAccumulator2);
                getStyleFromValue(view2, "actions", AccessibilityNodeInfoWrapper.getActions(view), null, styleAccumulator);
            }
        }
    }

    protected void onGetComputedStyles(View view, ComputedStyleAccumulator computedStyleAccumulator) {
        computedStyleAccumulator.store("left", Integer.toString(view.getLeft()));
        computedStyleAccumulator.store("top", Integer.toString(view.getTop()));
        computedStyleAccumulator.store("right", Integer.toString(view.getRight()));
        computedStyleAccumulator.store("bottom", Integer.toString(view.getBottom()));
    }

    private static boolean canIntBeMappedToString(@Nullable ExportedProperty exportedProperty) {
        return (exportedProperty == null || exportedProperty.mapping() == null || exportedProperty.mapping().length <= null) ? null : true;
    }

    private static String mapIntToStringUsingAnnotation(int i, @Nullable ExportedProperty exportedProperty) {
        if (canIntBeMappedToString(exportedProperty)) {
            for (IntToString intToString : exportedProperty.mapping()) {
                if (intToString.from() == i) {
                    return intToString.to();
                }
            }
            return NONE_MAPPING;
        }
        throw new IllegalStateException("Cannot map using this annotation");
    }

    private static boolean canFlagsBeMappedToString(@Nullable ExportedProperty exportedProperty) {
        return (exportedProperty == null || exportedProperty.flagMapping() == null || exportedProperty.flagMapping().length <= null) ? null : true;
    }

    private static String mapFlagsToStringUsingAnnotation(int i, @Nullable ExportedProperty exportedProperty) {
        if (canFlagsBeMappedToString(exportedProperty)) {
            exportedProperty = exportedProperty.flagMapping();
            int length = exportedProperty.length;
            StringBuilder stringBuilder = null;
            int i2 = 0;
            int i3 = i2;
            while (i2 < length) {
                FlagToString flagToString = exportedProperty[i2];
                if (flagToString.outputIf() == ((flagToString.mask() & i) == flagToString.equals())) {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    }
                    if (i3 != 0) {
                        stringBuilder.append(" | ");
                    }
                    stringBuilder.append(flagToString.name());
                    i3 = 1;
                }
                i2++;
            }
            if (i3 != 0) {
                return stringBuilder.toString();
            }
            return NONE_MAPPING;
        }
        throw new IllegalStateException("Cannot map using this annotation");
    }

    private String convertViewPropertyNameToCSSName(String str) {
        str = getWordBoundaryPattern().split(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("get")) {
                if (!str[i].equals("m")) {
                    stringBuilder.append(str[i].toLowerCase());
                    if (i < str.length - 1) {
                        stringBuilder.append('-');
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private void getStyleFromValue(View view, String str, Object obj, @Nullable ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        if (str.equals(ID_NAME)) {
            getIdStyle(view, styleAccumulator);
        } else if (obj instanceof Integer) {
            getStyleFromInteger(str, (Integer) obj, exportedProperty, styleAccumulator);
        } else {
            boolean z = true;
            if (obj instanceof Float) {
                view = String.valueOf(obj);
                if (((Float) obj).floatValue() != null) {
                    z = false;
                }
                styleAccumulator.store(str, view, z);
            } else if (obj instanceof Boolean) {
                styleAccumulator.store(str, String.valueOf(obj), false);
            } else if (obj instanceof Short) {
                view = String.valueOf(obj);
                if (((Short) obj).shortValue() != null) {
                    z = false;
                }
                styleAccumulator.store(str, view, z);
            } else if (obj instanceof Long) {
                view = String.valueOf(obj);
                if (((Long) obj).longValue() != 0) {
                    z = false;
                }
                styleAccumulator.store(str, view, z);
            } else if (obj instanceof Double) {
                view = String.valueOf(obj);
                if (((Double) obj).doubleValue() != 0.0d) {
                    z = false;
                }
                styleAccumulator.store(str, view, z);
            } else if (obj instanceof Byte) {
                view = String.valueOf(obj);
                if (((Byte) obj).byteValue() != null) {
                    z = false;
                }
                styleAccumulator.store(str, view, z);
            } else if (obj instanceof Character) {
                view = String.valueOf(obj);
                if (((Character) obj).charValue() != null) {
                    z = false;
                }
                styleAccumulator.store(str, view, z);
            } else if (obj instanceof CharSequence) {
                view = String.valueOf(obj);
                if (((CharSequence) obj).length() != null) {
                    z = false;
                }
                styleAccumulator.store(str, view, z);
            } else {
                getStylesFromObject(view, str, obj, exportedProperty, styleAccumulator);
            }
        }
    }

    private void getIdStyle(View view, StyleAccumulator styleAccumulator) {
        view = getIdAttribute(view);
        if (view == null) {
            styleAccumulator.store(ID_NAME, NONE_VALUE, false);
        } else {
            styleAccumulator.store(ID_NAME, view, false);
        }
    }

    private void getStyleFromInteger(String str, Integer num, @Nullable ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        String format = IntegerFormatter.getInstance().format(num, exportedProperty);
        StringBuilder stringBuilder;
        if (canIntBeMappedToString(exportedProperty)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(" (");
            stringBuilder.append(mapIntToStringUsingAnnotation(num.intValue(), exportedProperty));
            stringBuilder.append(")");
            styleAccumulator.store(str, stringBuilder.toString(), false);
        } else if (canFlagsBeMappedToString(exportedProperty)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(" (");
            stringBuilder.append(mapFlagsToStringUsingAnnotation(num.intValue(), exportedProperty));
            stringBuilder.append(")");
            styleAccumulator.store(str, stringBuilder.toString(), false);
        } else {
            Boolean valueOf = Boolean.valueOf(true);
            if (!(num.intValue() == null && canFlagsBeMappedToString(exportedProperty) == null && canIntBeMappedToString(exportedProperty) == null)) {
                valueOf = Boolean.valueOf(false);
            }
            styleAccumulator.store(str, format, valueOf.booleanValue());
        }
    }

    private void getStylesFromObject(View view, String str, Object obj, @Nullable ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        ViewDescriptor viewDescriptor;
        Object obj2 = obj;
        if (exportedProperty != null && exportedProperty.deepExport()) {
            if (obj2 != null) {
                for (Field field : obj.getClass().getFields()) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        viewDescriptor = this;
                    } else {
                        boolean z = true;
                        try {
                            String str2;
                            StringBuilder stringBuilder;
                            String convertViewPropertyNameToCSSName;
                            field.setAccessible(true);
                            Object obj3 = field.get(obj2);
                            String name = field.getName();
                            int hashCode = name.hashCode();
                            if (hashCode != -599904534) {
                                if (hashCode != -414179485) {
                                    if (hashCode != 1928835221) {
                                        if (hashCode == 2064613305) {
                                            if (name.equals("bottomMargin")) {
                                                z = false;
                                                switch (z) {
                                                    case false:
                                                        str2 = "margin-bottom";
                                                        break;
                                                    case true:
                                                        str2 = "margin-top";
                                                        break;
                                                    case true:
                                                        str2 = "margin-left";
                                                        break;
                                                    case true:
                                                        str2 = "margin-right";
                                                        break;
                                                    default:
                                                        str2 = exportedProperty.prefix();
                                                        if (str2 != null) {
                                                            stringBuilder = new StringBuilder();
                                                            stringBuilder.append(str2);
                                                            stringBuilder.append(name);
                                                            name = stringBuilder.toString();
                                                        }
                                                        convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                                        break;
                                                }
                                                convertViewPropertyNameToCSSName = str2;
                                                viewDescriptor = this;
                                                getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                                            }
                                        }
                                    } else if (name.equals("leftMargin")) {
                                        z = true;
                                        switch (z) {
                                            case false:
                                                str2 = "margin-bottom";
                                                break;
                                            case true:
                                                str2 = "margin-top";
                                                break;
                                            case true:
                                                str2 = "margin-left";
                                                break;
                                            case true:
                                                str2 = "margin-right";
                                                break;
                                            default:
                                                str2 = exportedProperty.prefix();
                                                if (str2 != null) {
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append(str2);
                                                    stringBuilder.append(name);
                                                    name = stringBuilder.toString();
                                                }
                                                convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                                break;
                                        }
                                        convertViewPropertyNameToCSSName = str2;
                                        viewDescriptor = this;
                                        getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                                    }
                                } else if (name.equals("topMargin")) {
                                    switch (z) {
                                        case false:
                                            str2 = "margin-bottom";
                                            break;
                                        case true:
                                            str2 = "margin-top";
                                            break;
                                        case true:
                                            str2 = "margin-left";
                                            break;
                                        case true:
                                            str2 = "margin-right";
                                            break;
                                        default:
                                            str2 = exportedProperty.prefix();
                                            if (str2 != null) {
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append(str2);
                                                stringBuilder.append(name);
                                                name = stringBuilder.toString();
                                            }
                                            convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                            break;
                                    }
                                    convertViewPropertyNameToCSSName = str2;
                                    viewDescriptor = this;
                                    getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                                }
                            } else if (name.equals("rightMargin")) {
                                z = true;
                                switch (z) {
                                    case false:
                                        str2 = "margin-bottom";
                                        break;
                                    case true:
                                        str2 = "margin-top";
                                        break;
                                    case true:
                                        str2 = "margin-left";
                                        break;
                                    case true:
                                        str2 = "margin-right";
                                        break;
                                    default:
                                        str2 = exportedProperty.prefix();
                                        if (str2 != null) {
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append(str2);
                                            stringBuilder.append(name);
                                            name = stringBuilder.toString();
                                        }
                                        convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                        break;
                                }
                                convertViewPropertyNameToCSSName = str2;
                                viewDescriptor = this;
                                getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                            }
                            z = true;
                            switch (z) {
                                case false:
                                    str2 = "margin-bottom";
                                    break;
                                case true:
                                    str2 = "margin-top";
                                    break;
                                case true:
                                    str2 = "margin-left";
                                    break;
                                case true:
                                    str2 = "margin-right";
                                    break;
                                default:
                                    str2 = exportedProperty.prefix();
                                    if (str2 != null) {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(str2);
                                        stringBuilder.append(name);
                                        name = stringBuilder.toString();
                                    }
                                    convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                    break;
                            }
                            convertViewPropertyNameToCSSName = str2;
                            viewDescriptor = this;
                            getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                        } catch (Throwable e) {
                            viewDescriptor = this;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("failed to get property of name: \"");
                            stringBuilder2.append(str);
                            stringBuilder2.append("\" of object: ");
                            stringBuilder2.append(String.valueOf(obj));
                            LogUtil.m19e(e, stringBuilder2.toString());
                            return;
                        }
                    }
                }
                viewDescriptor = this;
                return;
            }
        }
        viewDescriptor = this;
    }

    private static String capitalize(String str) {
        if (!(str == null || str.length() == 0)) {
            if (!Character.isTitleCase(str.charAt(0))) {
                StringBuilder stringBuilder = new StringBuilder(str);
                stringBuilder.setCharAt(0, Character.toTitleCase(stringBuilder.charAt(0)));
                return stringBuilder.toString();
            }
        }
        return str;
    }
}
