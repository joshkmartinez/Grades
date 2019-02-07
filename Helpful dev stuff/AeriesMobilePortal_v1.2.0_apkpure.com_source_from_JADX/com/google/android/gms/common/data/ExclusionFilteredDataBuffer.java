package com.google.android.gms.common.data;

import android.text.TextUtils;
import com.google.android.gms.common.data.DataBufferObserver.Observable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@VisibleForTesting
public final class ExclusionFilteredDataBuffer<T> extends FilteredDataBuffer<T> implements Observable, ExclusionFilterable {
    private AbstractDataBuffer<T> zzoc;
    private final String zzod;
    private final HashSet<Integer> zzoe = new HashSet();
    private DataBufferObserverSet zzof;

    public ExclusionFilteredDataBuffer(AbstractDataBuffer<T> abstractDataBuffer, String str) {
        super(abstractDataBuffer);
        this.zzoc = abstractDataBuffer;
        this.zzod = str;
        this.zzof = new DataBufferObserverSet();
    }

    private final ArrayList<Integer> zza(String str, ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2 = new ArrayList();
        if (arrayList != null) {
            arrayList.clear();
        }
        DataHolder dataHolder = this.zzoc.mDataHolder;
        String str2 = this.zzod;
        boolean z = this.zzoc instanceof EntityBuffer;
        int count = this.zzoc.getCount();
        int i = 0;
        int i2 = 0;
        while (i < count) {
            int i3;
            int zzi = z ? ((EntityBuffer) this.zzoc).zzi(i) : i;
            Object string = dataHolder.getString(str2, zzi, dataHolder.getWindowIndex(zzi));
            if (arrayList == null) {
                i3 = i2;
            } else if (this.zzoe.contains(Integer.valueOf(i))) {
                i3 = i2;
                i2 = (-i2) - 1;
            } else {
                i3 = i2 + 1;
            }
            if (!TextUtils.isEmpty(string) && string.equals(str)) {
                arrayList2.add(Integer.valueOf(i));
                if (arrayList != null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            i++;
            i2 = i3;
        }
        return arrayList2;
    }

    public final void addObserver(DataBufferObserver dataBufferObserver) {
        this.zzof.addObserver(dataBufferObserver);
    }

    public final void clearFilters() {
        if (this.zzof.hasObservers()) {
            int size = this.zzoe.size();
            Integer[] numArr = (Integer[]) this.zzoe.toArray(new Integer[size]);
            Arrays.sort(numArr);
            int i = 0;
            int i2 = 0;
            int i3 = i2;
            while (i < size) {
                int intValue = numArr[i].intValue();
                this.zzoe.remove(Integer.valueOf(intValue));
                if (i2 != 0) {
                    if (intValue == i3 + i2) {
                        i2++;
                        i++;
                    } else {
                        this.zzof.onDataRangeRemoved(i3, i2);
                    }
                }
                i3 = intValue;
                i2 = 1;
                i++;
            }
            if (i2 > 0) {
                this.zzof.onDataRangeRemoved(i3, i2);
            }
            return;
        }
        this.zzoe.clear();
    }

    public final int computeRealPosition(int i) {
        if (this.zzoe.isEmpty()) {
            return i;
        }
        if (i < 0 || i >= getCount()) {
            StringBuilder stringBuilder = new StringBuilder(53);
            stringBuilder.append("Position ");
            stringBuilder.append(i);
            stringBuilder.append(" is out of bounds for this buffer");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int count = this.mDataBuffer.getCount();
        int i2 = 0;
        int i3 = 0;
        while (i2 < count) {
            if (!this.zzoe.contains(Integer.valueOf(i2))) {
                if (i3 == i) {
                    return i2;
                }
                i3++;
            }
            i2++;
        }
        return -1;
    }

    public final void filterOut(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = null;
            if (this.zzof.hasObservers()) {
                arrayList = new ArrayList();
            }
            Collection zza = zza(str, arrayList);
            if (this.zzof.hasObservers()) {
                int i = 0;
                int i2 = i;
                for (int size = zza.size() - 1; size >= 0; size--) {
                    int intValue = ((Integer) arrayList.get(size)).intValue();
                    if ((intValue < 0 ? 1 : 0) == 0) {
                        this.zzoe.add(Integer.valueOf(((Integer) zza.get(size)).intValue()));
                        if (i != 0) {
                            if (intValue == i2 - 1) {
                                i2--;
                                i++;
                            } else {
                                this.zzof.onDataRangeRemoved(i2, i);
                            }
                        }
                        i = 1;
                        i2 = intValue;
                    }
                }
                if (i > 0) {
                    this.zzof.onDataRangeRemoved(i2, i);
                }
                return;
            }
            this.zzoe.addAll(zza);
        }
    }

    public final int getCount() {
        return this.mDataBuffer.getCount() - this.zzoe.size();
    }

    public final void release() {
        super.release();
        this.zzof.clear();
    }

    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zzof.removeObserver(dataBufferObserver);
    }

    public final void unfilter(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = null;
            if (this.zzof.hasObservers()) {
                arrayList = new ArrayList();
            }
            Collection zza = zza(str, arrayList);
            if (this.zzof.hasObservers()) {
                int i = 0;
                int i2 = i;
                for (int size = zza.size() - 1; size >= 0; size--) {
                    int intValue = ((Integer) arrayList.get(size)).intValue();
                    if ((intValue < 0 ? 1 : 0) != 0) {
                        this.zzoe.remove(Integer.valueOf(((Integer) zza.get(size)).intValue()));
                        intValue = (-intValue) - 1;
                        if (i != 0) {
                            if (intValue == i2) {
                                i++;
                            } else {
                                this.zzof.onDataRangeInserted(i2, i);
                            }
                        }
                        i = 1;
                        i2 = intValue;
                    }
                }
                if (i > 0) {
                    this.zzof.onDataRangeInserted(i2, i);
                }
                return;
            }
            this.zzoe.removeAll(zza);
        }
    }
}
