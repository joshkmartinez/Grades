package com.aeries.mobileportal.utils;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 1, 10})
/* compiled from: Comparisons.kt */
public final class SettingsUtils$Companion$getSettings$$inlined$sortedBy$1<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        Comparable valueOf;
        String str;
        String str2 = (String) t;
        int hashCode = str2.hashCode();
        int i = 2;
        if (hashCode != -2013462102) {
            if (hashCode != -70562165) {
                if (hashCode == 2042692801) {
                    if (str2.equals("LinkStudent") != null) {
                        t = 2;
                        valueOf = Integer.valueOf(t);
                        str = (String) t2;
                        hashCode = str.hashCode();
                        if (hashCode == -2013462102) {
                            if (hashCode == -70562165) {
                                if (hashCode == 2042692801) {
                                    if (str.equals("LinkStudent") != null) {
                                        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                                    }
                                }
                            } else if (str.equals("ChangePassword") != null) {
                                i = 0;
                                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                            }
                        } else if (str.equals("Logout") != null) {
                            i = 1;
                            return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                        }
                        i = 10;
                        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                    }
                }
            } else if (str2.equals("ChangePassword") != null) {
                t = null;
                valueOf = Integer.valueOf(t);
                str = (String) t2;
                hashCode = str.hashCode();
                if (hashCode == -2013462102) {
                    if (str.equals("Logout") != null) {
                        i = 1;
                        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                    }
                } else if (hashCode == -70562165) {
                    if (str.equals("ChangePassword") != null) {
                        i = 0;
                        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                    }
                } else if (hashCode == 2042692801) {
                    if (str.equals("LinkStudent") != null) {
                        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                    }
                }
                i = 10;
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
            }
        } else if (str2.equals("Logout") != null) {
            t = 1;
            valueOf = Integer.valueOf(t);
            str = (String) t2;
            hashCode = str.hashCode();
            if (hashCode == -2013462102) {
                if (hashCode == -70562165) {
                    if (hashCode == 2042692801) {
                        if (str.equals("LinkStudent") != null) {
                            return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                        }
                    }
                } else if (str.equals("ChangePassword") != null) {
                    i = 0;
                    return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
                }
            } else if (str.equals("Logout") != null) {
                i = 1;
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
            }
            i = 10;
            return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
        }
        t = 10;
        valueOf = Integer.valueOf(t);
        str = (String) t2;
        hashCode = str.hashCode();
        if (hashCode == -2013462102) {
            if (str.equals("Logout") != null) {
                i = 1;
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
            }
        } else if (hashCode == -70562165) {
            if (str.equals("ChangePassword") != null) {
                i = 0;
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
            }
        } else if (hashCode == 2042692801) {
            if (str.equals("LinkStudent") != null) {
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
            }
        }
        i = 10;
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
    }
}
