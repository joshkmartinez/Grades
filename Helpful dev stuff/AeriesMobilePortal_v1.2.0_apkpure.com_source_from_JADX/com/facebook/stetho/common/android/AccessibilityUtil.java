package com.facebook.stetho.common.android;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;

public final class AccessibilityUtil {
    private AccessibilityUtil() {
    }

    public static boolean hasText(@Nullable AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z = false;
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        if (!TextUtils.isEmpty(accessibilityNodeInfoCompat.getText()) || TextUtils.isEmpty(accessibilityNodeInfoCompat.getContentDescription()) == null) {
            z = true;
        }
        return z;
    }

    public static boolean isSpeakingNode(@Nullable AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @Nullable View view) {
        boolean z = false;
        if (accessibilityNodeInfoCompat != null) {
            if (view != null) {
                if (!accessibilityNodeInfoCompat.isVisibleToUser()) {
                    return false;
                }
                int importantForAccessibility = ViewCompat.getImportantForAccessibility(view);
                if (importantForAccessibility != 4) {
                    if (importantForAccessibility != 2 || accessibilityNodeInfoCompat.getChildCount() > 0) {
                        if (accessibilityNodeInfoCompat.isCheckable() || hasText(accessibilityNodeInfoCompat) || hasNonActionableSpeakingDescendants(accessibilityNodeInfoCompat, view) != null) {
                            z = true;
                        }
                        return z;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean hasNonActionableSpeakingDescendants(@Nullable AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @Nullable View view) {
        if (!(accessibilityNodeInfoCompat == null || view == null)) {
            if ((view instanceof ViewGroup) != null) {
                ViewGroup viewGroup = (ViewGroup) view;
                accessibilityNodeInfoCompat = viewGroup.getChildCount();
                for (int i = 0; i < accessibilityNodeInfoCompat; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
                        ViewCompat.onInitializeAccessibilityNodeInfo(childAt, obtain);
                        if (!isAccessibilityFocusable(obtain, childAt)) {
                            try {
                                if (isSpeakingNode(obtain, childAt)) {
                                    obtain.recycle();
                                    return true;
                                }
                            } catch (Throwable th) {
                                obtain.recycle();
                            }
                        }
                        obtain.recycle();
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isAccessibilityFocusable(@Nullable AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @Nullable View view) {
        boolean z = false;
        if (accessibilityNodeInfoCompat != null) {
            if (view != null) {
                if (!accessibilityNodeInfoCompat.isVisibleToUser()) {
                    return false;
                }
                if (isActionableForAccessibility(accessibilityNodeInfoCompat)) {
                    return true;
                }
                if (isTopLevelScrollItem(accessibilityNodeInfoCompat, view) && isSpeakingNode(accessibilityNodeInfoCompat, view) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public static boolean isTopLevelScrollItem(@Nullable AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @Nullable View view) {
        boolean z = false;
        if (accessibilityNodeInfoCompat != null) {
            if (view != null) {
                view = (View) ViewCompat.getParentForAccessibility(view);
                if (view == null) {
                    return false;
                }
                if (accessibilityNodeInfoCompat.isScrollable()) {
                    return true;
                }
                accessibilityNodeInfoCompat = accessibilityNodeInfoCompat.getActionList();
                if (!accessibilityNodeInfoCompat.contains(Integer.valueOf(4096))) {
                    if (accessibilityNodeInfoCompat.contains(Integer.valueOf(8192)) == null) {
                        if ((view instanceof Spinner) != null) {
                            return false;
                        }
                        if (!((view instanceof AdapterView) == null && (view instanceof ScrollView) == null && (view instanceof HorizontalScrollView) == null)) {
                            z = true;
                        }
                        return z;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isActionableForAccessibility(@Nullable AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z = false;
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        if (!(accessibilityNodeInfoCompat.isClickable() || accessibilityNodeInfoCompat.isLongClickable())) {
            if (!accessibilityNodeInfoCompat.isFocusable()) {
                accessibilityNodeInfoCompat = accessibilityNodeInfoCompat.getActionList();
                if (accessibilityNodeInfoCompat.contains(Integer.valueOf(16)) || accessibilityNodeInfoCompat.contains(Integer.valueOf(32)) || accessibilityNodeInfoCompat.contains(Integer.valueOf(1)) != null) {
                    z = true;
                }
                return z;
            }
        }
        return true;
    }

    public static boolean hasFocusableAncestor(@Nullable AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @Nullable View view) {
        if (accessibilityNodeInfoCompat != null) {
            if (view != null) {
                accessibilityNodeInfoCompat = ViewCompat.getParentForAccessibility(view);
                if ((accessibilityNodeInfoCompat instanceof View) == null) {
                    return false;
                }
                view = AccessibilityNodeInfoCompat.obtain();
                try {
                    ViewCompat.onInitializeAccessibilityNodeInfo((View) accessibilityNodeInfoCompat, view);
                    if (view == null) {
                        return false;
                    }
                    if (isAccessibilityFocusable(view, (View) accessibilityNodeInfoCompat)) {
                        view.recycle();
                        return true;
                    } else if (hasFocusableAncestor(view, (View) accessibilityNodeInfoCompat) != null) {
                        view.recycle();
                        return true;
                    } else {
                        view.recycle();
                        return false;
                    }
                } finally {
                    view.recycle();
                }
            }
        }
        return false;
    }
}
