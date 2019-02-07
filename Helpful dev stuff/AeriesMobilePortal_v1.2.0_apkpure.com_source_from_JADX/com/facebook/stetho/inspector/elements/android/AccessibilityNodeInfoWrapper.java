package com.facebook.stetho.inspector.elements.android;

import android.support.annotation.Nullable;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.facebook.stetho.common.android.AccessibilityUtil;

public final class AccessibilityNodeInfoWrapper {
    public static AccessibilityNodeInfoCompat createNodeInfoFromView(View view) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        ViewCompat.onInitializeAccessibilityNodeInfo(view, obtain);
        return obtain;
    }

    public static boolean getIsAccessibilityFocused(View view) {
        view = createNodeInfoFromView(view);
        boolean isAccessibilityFocused = view.isAccessibilityFocused();
        view.recycle();
        return isAccessibilityFocused;
    }

    public static boolean getIgnored(View view) {
        int importantForAccessibility = ViewCompat.getImportantForAccessibility(view);
        if (importantForAccessibility != 2) {
            if (importantForAccessibility != 4) {
                for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                    if (ViewCompat.getImportantForAccessibility((View) parent) == 4) {
                        return true;
                    }
                }
                AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
                try {
                    if (!createNodeInfoFromView.isVisibleToUser()) {
                        return true;
                    }
                    if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view)) {
                        if (createNodeInfoFromView.getChildCount() <= 0) {
                            createNodeInfoFromView.recycle();
                            return false;
                        } else if (AccessibilityUtil.isSpeakingNode(createNodeInfoFromView, view) != null) {
                            createNodeInfoFromView.recycle();
                            return false;
                        } else {
                            createNodeInfoFromView.recycle();
                            return true;
                        }
                    } else if (AccessibilityUtil.hasFocusableAncestor(createNodeInfoFromView, view) != null || AccessibilityUtil.hasText(createNodeInfoFromView) == null) {
                        createNodeInfoFromView.recycle();
                        return true;
                    } else {
                        createNodeInfoFromView.recycle();
                        return false;
                    }
                } finally {
                    createNodeInfoFromView.recycle();
                }
            }
        }
        return true;
    }

    public static String getIgnoredReasons(View view) {
        int importantForAccessibility = ViewCompat.getImportantForAccessibility(view);
        if (importantForAccessibility == 2) {
            return "View has importantForAccessibility set to 'NO'.";
        }
        if (importantForAccessibility == 4) {
            return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (ViewCompat.getImportantForAccessibility((View) parent) == 4) {
                return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
            }
        }
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!createNodeInfoFromView.isVisibleToUser()) {
                view = "View is not visible.";
                return view;
            } else if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view) != null) {
                view = "View is actionable, but has no description.";
                createNodeInfoFromView.recycle();
                return view;
            } else if (AccessibilityUtil.hasText(createNodeInfoFromView) != null) {
                view = "View is not actionable, and an ancestor View has co-opted its description.";
                createNodeInfoFromView.recycle();
                return view;
            } else {
                view = "View is not actionable and has no description.";
                createNodeInfoFromView.recycle();
                return view;
            }
        } finally {
            createNodeInfoFromView.recycle();
        }
    }

    @Nullable
    public static String getFocusableReasons(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            boolean hasText = AccessibilityUtil.hasText(createNodeInfoFromView);
            boolean isCheckable = createNodeInfoFromView.isCheckable();
            boolean hasNonActionableSpeakingDescendants = AccessibilityUtil.hasNonActionableSpeakingDescendants(createNodeInfoFromView, view);
            if (AccessibilityUtil.isActionableForAccessibility(createNodeInfoFromView)) {
                if (createNodeInfoFromView.getChildCount() <= 0) {
                    view = "View is actionable and has no children.";
                    return view;
                } else if (hasText) {
                    view = "View is actionable and has a description.";
                    createNodeInfoFromView.recycle();
                    return view;
                } else if (isCheckable) {
                    view = "View is actionable and checkable.";
                    createNodeInfoFromView.recycle();
                    return view;
                } else if (hasNonActionableSpeakingDescendants) {
                    view = "View is actionable and has non-actionable descendants with descriptions.";
                    createNodeInfoFromView.recycle();
                    return view;
                }
            }
            if (AccessibilityUtil.isTopLevelScrollItem(createNodeInfoFromView, view) != null) {
                if (hasText) {
                    view = "View is a direct child of a scrollable container and has a description.";
                    createNodeInfoFromView.recycle();
                    return view;
                } else if (isCheckable) {
                    view = "View is a direct child of a scrollable container and is checkable.";
                    createNodeInfoFromView.recycle();
                    return view;
                } else if (hasNonActionableSpeakingDescendants) {
                    view = "View is a direct child of a scrollable container and has non-actionable descendants with descriptions.";
                    createNodeInfoFromView.recycle();
                    return view;
                }
            }
            if (hasText) {
                view = "View has a description and is not actionable, but has no actionable ancestor.";
                createNodeInfoFromView.recycle();
                return view;
            }
            createNodeInfoFromView.recycle();
            return null;
        } finally {
            createNodeInfoFromView.recycle();
        }
    }

    @Nullable
    public static String getActions(View view) {
        view = createNodeInfoFromView(view);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (AccessibilityActionCompat accessibilityActionCompat : view.getActionList()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                switch (accessibilityActionCompat.getId()) {
                    case 1:
                        stringBuilder.append("focus");
                        break;
                    case 2:
                        stringBuilder.append("clear-focus");
                        break;
                    case 4:
                        stringBuilder.append("select");
                        break;
                    case 8:
                        stringBuilder.append("clear-selection");
                        break;
                    case 16:
                        stringBuilder.append("click");
                        break;
                    case 32:
                        stringBuilder.append("long-click");
                        break;
                    case 64:
                        stringBuilder.append("accessibility-focus");
                        break;
                    case 128:
                        stringBuilder.append("clear-accessibility-focus");
                        break;
                    case 256:
                        stringBuilder.append("next-at-movement-granularity");
                        break;
                    case 512:
                        stringBuilder.append("previous-at-movement-granularity");
                        break;
                    case 1024:
                        stringBuilder.append("next-html-element");
                        break;
                    case 2048:
                        stringBuilder.append("previous-html-element");
                        break;
                    case 4096:
                        stringBuilder.append("scroll-forward");
                        break;
                    case 8192:
                        stringBuilder.append("scroll-backward");
                        break;
                    case 16384:
                        stringBuilder.append("copy");
                        break;
                    case 32768:
                        stringBuilder.append("paste");
                        break;
                    case 65536:
                        stringBuilder.append("cut");
                        break;
                    case 131072:
                        stringBuilder.append("set-selection");
                        break;
                    default:
                        CharSequence label = accessibilityActionCompat.getLabel();
                        if (label == null) {
                            stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
                            break;
                        }
                        stringBuilder.append(label);
                        break;
                }
            }
            String stringBuilder2 = stringBuilder.length() > 0 ? stringBuilder.toString() : null;
            view.recycle();
            return stringBuilder2;
        } catch (Throwable th) {
            view.recycle();
        }
    }

    @Nullable
    public static CharSequence getDescription(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            CharSequence contentDescription = createNodeInfoFromView.getContentDescription();
            CharSequence text = createNodeInfoFromView.getText();
            int isEmpty = TextUtils.isEmpty(text) ^ 1;
            boolean z = view instanceof EditText;
            if (!TextUtils.isEmpty(contentDescription) && (!z || isEmpty == 0)) {
                createNodeInfoFromView.recycle();
                return contentDescription;
            } else if (isEmpty != 0) {
                createNodeInfoFromView.recycle();
                return text;
            } else {
                text = null;
                if (view instanceof ViewGroup) {
                    StringBuilder stringBuilder = new StringBuilder();
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (isEmpty = 0; isEmpty < childCount; isEmpty++) {
                        View childAt = viewGroup.getChildAt(isEmpty);
                        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
                        ViewCompat.onInitializeAccessibilityNodeInfo(childAt, obtain);
                        CharSequence description = (!AccessibilityUtil.isSpeakingNode(obtain, childAt) || AccessibilityUtil.isAccessibilityFocusable(obtain, childAt)) ? null : getDescription(childAt);
                        if (!TextUtils.isEmpty(description)) {
                            if (stringBuilder.length() > 0) {
                                stringBuilder.append(", ");
                            }
                            stringBuilder.append(description);
                        }
                        obtain.recycle();
                    }
                    if (stringBuilder.length() > null) {
                        text = stringBuilder.toString();
                    }
                    createNodeInfoFromView.recycle();
                    return text;
                }
                createNodeInfoFromView.recycle();
                return null;
            }
        } catch (Throwable th) {
            createNodeInfoFromView.recycle();
        }
    }
}
