package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@KeepName
@Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder zznt = new zza(new String[0], null);
    private boolean mClosed;
    @VersionField(id = 1000)
    private final int zzal;
    @Field(getter = "getStatusCode", id = 3)
    private final int zzam;
    @Field(getter = "getColumns", id = 1)
    private final String[] zznm;
    private Bundle zznn;
    @Field(getter = "getWindows", id = 2)
    private final CursorWindow[] zzno;
    @Field(getter = "getMetadata", id = 4)
    private final Bundle zznp;
    private int[] zznq;
    private int zznr;
    private boolean zzns;

    public static class Builder {
        private final String[] zznm;
        private final ArrayList<HashMap<String, Object>> zznu;
        private final String zznv;
        private final HashMap<Object, Integer> zznw;
        private boolean zznx;
        private String zzny;

        private Builder(String[] strArr, String str) {
            this.zznm = (String[]) Preconditions.checkNotNull(strArr);
            this.zznu = new ArrayList();
            this.zznv = str;
            this.zznw = new HashMap();
            this.zznx = false;
            this.zzny = null;
        }

        private final boolean zzg(String str) {
            Asserts.checkNotNull(str);
            return this.zznx && str.equals(this.zzny);
        }

        public DataHolder build(int i) {
            return new DataHolder(this, i);
        }

        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle, -1);
        }

        public DataHolder build(int i, Bundle bundle, int i2) {
            return new DataHolder(this, i, bundle, i2);
        }

        public boolean containsRowWithValue(String str, Object obj) {
            int size = this.zznu.size();
            for (int i = 0; i < size; i++) {
                if (Objects.equal(((HashMap) this.zznu.get(i)).get(str), obj)) {
                    return true;
                }
            }
            return false;
        }

        public Builder descendingSort(String str) {
            if (zzg(str)) {
                return this;
            }
            sort(str);
            Collections.reverse(this.zznu);
            return this;
        }

        public int getCount() {
            return this.zznu.size();
        }

        public void modifyUniqueRowValue(Object obj, String str, Object obj2) {
            if (this.zznv != null) {
                Integer num = (Integer) this.zznw.get(obj);
                if (num != null) {
                    ((HashMap) this.zznu.get(num.intValue())).put(str, obj2);
                }
            }
        }

        public Builder removeRowsWithValue(String str, Object obj) {
            for (int size = this.zznu.size() - 1; size >= 0; size--) {
                if (Objects.equal(((HashMap) this.zznu.get(size)).get(str), obj)) {
                    this.zznu.remove(size);
                }
            }
            return this;
        }

        public Builder sort(String str) {
            if (zzg(str)) {
                return this;
            }
            Collections.sort(this.zznu, new zza(str));
            if (this.zznv != null) {
                this.zznw.clear();
                int size = this.zznu.size();
                for (int i = 0; i < size; i++) {
                    Object obj = ((HashMap) this.zznu.get(i)).get(this.zznv);
                    if (obj != null) {
                        this.zznw.put(obj, Integer.valueOf(i));
                    }
                }
            }
            this.zznx = true;
            this.zzny = str;
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Entry entry : contentValues.valueSet()) {
                hashMap.put((String) entry.getKey(), entry.getValue());
            }
            return withRow(hashMap);
        }

        public Builder withRow(HashMap<String, Object> hashMap) {
            int intValue;
            Asserts.checkNotNull(hashMap);
            if (this.zznv != null) {
                Object obj = hashMap.get(this.zznv);
                if (obj != null) {
                    Integer num = (Integer) this.zznw.get(obj);
                    if (num == null) {
                        this.zznw.put(obj, Integer.valueOf(this.zznu.size()));
                    } else {
                        intValue = num.intValue();
                        if (intValue != -1) {
                            this.zznu.add(hashMap);
                        } else {
                            this.zznu.remove(intValue);
                            this.zznu.add(intValue, hashMap);
                        }
                        this.zznx = false;
                        return this;
                    }
                }
            }
            intValue = -1;
            if (intValue != -1) {
                this.zznu.remove(intValue);
                this.zznu.add(intValue, hashMap);
            } else {
                this.zznu.add(hashMap);
            }
            this.zznx = false;
            return this;
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    private static final class zza implements Comparator<HashMap<String, Object>> {
        private final String zznz;

        zza(String str) {
            this.zznz = (String) Preconditions.checkNotNull(str);
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            HashMap hashMap = (HashMap) obj2;
            obj = Preconditions.checkNotNull(((HashMap) obj).get(this.zznz));
            obj2 = Preconditions.checkNotNull(hashMap.get(this.zznz));
            if (obj.equals(obj2)) {
                return 0;
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).compareTo((Boolean) obj2);
            }
            if (obj instanceof Long) {
                return ((Long) obj).compareTo((Long) obj2);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).compareTo((Integer) obj2);
            }
            if (obj instanceof String) {
                return ((String) obj).compareTo((String) obj2);
            }
            if (obj instanceof Double) {
                return ((Double) obj).compareTo((Double) obj2);
            }
            if (obj instanceof Float) {
                return ((Float) obj).compareTo((Float) obj2);
            }
            String valueOf = String.valueOf(obj);
            StringBuilder stringBuilder = new StringBuilder(24 + String.valueOf(valueOf).length());
            stringBuilder.append("Unknown type for lValue ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    @Constructor
    DataHolder(@Param(id = 1000) int i, @Param(id = 1) String[] strArr, @Param(id = 2) CursorWindow[] cursorWindowArr, @Param(id = 3) int i2, @Param(id = 4) Bundle bundle) {
        this.mClosed = false;
        this.zzns = true;
        this.zzal = i;
        this.zznm = strArr;
        this.zzno = cursorWindowArr;
        this.zzam = i2;
        this.zznp = bundle;
    }

    public DataHolder(Cursor cursor, int i, Bundle bundle) {
        this(new CursorWrapper(cursor), i, bundle);
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.zznm, zza(builder, -1), i, bundle);
    }

    private DataHolder(Builder builder, int i, Bundle bundle, int i2) {
        this(builder.zznm, zza(builder, i2), i, bundle);
    }

    public DataHolder(CursorWrapper cursorWrapper, int i, Bundle bundle) {
        this(cursorWrapper.getColumnNames(), zza(cursorWrapper), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzns = true;
        this.zzal = 1;
        this.zznm = (String[]) Preconditions.checkNotNull(strArr);
        this.zzno = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zzam = i;
        this.zznp = bundle;
        validateContents();
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, null);
    }

    public static Builder builder(String[] strArr, String str) {
        Preconditions.checkNotNull(str);
        return new Builder(strArr, str);
    }

    public static DataHolder empty(int i) {
        return empty(i, null);
    }

    public static DataHolder empty(int i, Bundle bundle) {
        return new DataHolder(zznt, i, bundle);
    }

    private final void zza(String str, int i) {
        if (this.zznn != null) {
            if (this.zznn.containsKey(str)) {
                if (isClosed()) {
                    throw new IllegalArgumentException("Buffer is closed.");
                } else if (i < 0 || i >= this.zznr) {
                    throw new CursorIndexOutOfBoundsException(i, this.zznr);
                } else {
                    return;
                }
            }
        }
        String str2 = "No such column: ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    private static CursorWindow[] zza(Builder builder, int i) {
        ArrayList arrayList;
        int i2 = 0;
        if (builder.zznm.length == 0) {
            return new CursorWindow[0];
        }
        List subList;
        int size;
        CursorWindow cursorWindow;
        int i3;
        CursorWindow cursorWindow2;
        int i4;
        Map map;
        boolean z;
        int i5;
        String str;
        Object obj;
        long longValue;
        if (i >= 0) {
            if (i < builder.zznu.size()) {
                subList = builder.zznu.subList(0, i);
                size = subList.size();
                cursorWindow = new CursorWindow(false);
                arrayList = new ArrayList();
                arrayList.add(cursorWindow);
                cursorWindow.setNumColumns(builder.zznm.length);
                i3 = 0;
                cursorWindow2 = cursorWindow;
                i4 = i3;
                while (i4 < size) {
                    try {
                        if (!cursorWindow2.allocRow()) {
                            StringBuilder stringBuilder = new StringBuilder(72);
                            stringBuilder.append("Allocating additional cursor window for large data set (row ");
                            stringBuilder.append(i4);
                            stringBuilder.append(")");
                            Log.d("DataHolder", stringBuilder.toString());
                            cursorWindow2 = new CursorWindow(false);
                            cursorWindow2.setStartPosition(i4);
                            cursorWindow2.setNumColumns(builder.zznm.length);
                            arrayList.add(cursorWindow2);
                            if (!cursorWindow2.allocRow()) {
                                Log.e("DataHolder", "Unable to allocate row to hold data.");
                                arrayList.remove(cursorWindow2);
                                return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                            }
                        }
                        map = (Map) subList.get(i4);
                        z = true;
                        for (i5 = 0; i5 < builder.zznm.length && z; i5++) {
                            str = builder.zznm[i5];
                            obj = map.get(str);
                            if (obj == null) {
                                z = cursorWindow2.putNull(i4, i5);
                            } else if (obj instanceof String) {
                                if (obj instanceof Long) {
                                    longValue = ((Long) obj).longValue();
                                } else if (obj instanceof Integer) {
                                    z = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i4, i5);
                                } else if (obj instanceof Boolean) {
                                    longValue = ((Boolean) obj).booleanValue() ? 1 : 0;
                                } else if (obj instanceof byte[]) {
                                    z = cursorWindow2.putBlob((byte[]) obj, i4, i5);
                                } else if (obj instanceof Double) {
                                    z = cursorWindow2.putDouble(((Double) obj).doubleValue(), i4, i5);
                                } else if (obj instanceof Float) {
                                    String valueOf = String.valueOf(obj);
                                    StringBuilder stringBuilder2 = new StringBuilder((32 + String.valueOf(str).length()) + String.valueOf(valueOf).length());
                                    stringBuilder2.append("Unsupported object for column ");
                                    stringBuilder2.append(str);
                                    stringBuilder2.append(": ");
                                    stringBuilder2.append(valueOf);
                                    throw new IllegalArgumentException(stringBuilder2.toString());
                                } else {
                                    z = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i4, i5);
                                }
                                z = cursorWindow2.putLong(longValue, i4, i5);
                            } else {
                                z = cursorWindow2.putString((String) obj, i4, i5);
                            }
                        }
                        if (!z) {
                            i3 = 0;
                        } else if (i3 != 0) {
                            StringBuilder stringBuilder3 = new StringBuilder(74);
                            stringBuilder3.append("Couldn't populate window data for row ");
                            stringBuilder3.append(i4);
                            stringBuilder3.append(" - allocating new window.");
                            Log.d("DataHolder", stringBuilder3.toString());
                            cursorWindow2.freeLastRow();
                            cursorWindow2 = new CursorWindow(false);
                            cursorWindow2.setStartPosition(i4);
                            cursorWindow2.setNumColumns(builder.zznm.length);
                            arrayList.add(cursorWindow2);
                            i4--;
                            i3 = 1;
                        } else {
                            throw new DataHolderException("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                        }
                        i4++;
                    } catch (RuntimeException e) {
                        i = arrayList.size();
                        while (i2 < i) {
                            ((CursorWindow) arrayList.get(i2)).close();
                            i2++;
                        }
                        throw e;
                    }
                }
                return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
            }
        }
        subList = builder.zznu;
        size = subList.size();
        cursorWindow = new CursorWindow(false);
        arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.zznm.length);
        i3 = 0;
        cursorWindow2 = cursorWindow;
        i4 = i3;
        while (i4 < size) {
            if (cursorWindow2.allocRow()) {
                StringBuilder stringBuilder4 = new StringBuilder(72);
                stringBuilder4.append("Allocating additional cursor window for large data set (row ");
                stringBuilder4.append(i4);
                stringBuilder4.append(")");
                Log.d("DataHolder", stringBuilder4.toString());
                cursorWindow2 = new CursorWindow(false);
                cursorWindow2.setStartPosition(i4);
                cursorWindow2.setNumColumns(builder.zznm.length);
                arrayList.add(cursorWindow2);
                if (cursorWindow2.allocRow()) {
                    Log.e("DataHolder", "Unable to allocate row to hold data.");
                    arrayList.remove(cursorWindow2);
                    return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                }
            }
            map = (Map) subList.get(i4);
            z = true;
            for (i5 = 0; i5 < builder.zznm.length; i5++) {
                str = builder.zznm[i5];
                obj = map.get(str);
                if (obj == null) {
                    z = cursorWindow2.putNull(i4, i5);
                } else if (obj instanceof String) {
                    if (obj instanceof Long) {
                        longValue = ((Long) obj).longValue();
                    } else if (obj instanceof Integer) {
                        z = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i4, i5);
                    } else if (obj instanceof Boolean) {
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow2.putBlob((byte[]) obj, i4, i5);
                    } else if (obj instanceof Double) {
                        z = cursorWindow2.putDouble(((Double) obj).doubleValue(), i4, i5);
                    } else if (obj instanceof Float) {
                        String valueOf2 = String.valueOf(obj);
                        StringBuilder stringBuilder22 = new StringBuilder((32 + String.valueOf(str).length()) + String.valueOf(valueOf2).length());
                        stringBuilder22.append("Unsupported object for column ");
                        stringBuilder22.append(str);
                        stringBuilder22.append(": ");
                        stringBuilder22.append(valueOf2);
                        throw new IllegalArgumentException(stringBuilder22.toString());
                    } else {
                        z = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i4, i5);
                    }
                    z = cursorWindow2.putLong(longValue, i4, i5);
                } else {
                    z = cursorWindow2.putString((String) obj, i4, i5);
                }
            }
            if (!z) {
                i3 = 0;
            } else if (i3 != 0) {
                throw new DataHolderException("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            } else {
                StringBuilder stringBuilder32 = new StringBuilder(74);
                stringBuilder32.append("Couldn't populate window data for row ");
                stringBuilder32.append(i4);
                stringBuilder32.append(" - allocating new window.");
                Log.d("DataHolder", stringBuilder32.toString());
                cursorWindow2.freeLastRow();
                cursorWindow2 = new CursorWindow(false);
                cursorWindow2.setStartPosition(i4);
                cursorWindow2.setNumColumns(builder.zznm.length);
                arrayList.add(cursorWindow2);
                i4--;
                i3 = 1;
            }
            i4++;
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    private static CursorWindow[] zza(CursorWrapper cursorWrapper) {
        ArrayList arrayList = new ArrayList();
        try {
            int i;
            int count = cursorWrapper.getCount();
            CursorWindow window = cursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                cursorWrapper.setWindow(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            while (i < count && cursorWrapper.moveToPosition(i)) {
                CursorWindow window2 = cursorWrapper.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    cursorWrapper.setWindow(null);
                } else {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(i);
                    cursorWrapper.fillWindow(i, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                i = window2.getStartPosition() + window2.getNumRows();
            }
            cursorWrapper.close();
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            cursorWrapper.close();
        }
    }

    public final void clearColumn(String str, int i, int i2) {
        zza(str, i);
        this.zzno[i2].putNull(i, this.zznn.getInt(str));
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzno) {
                    close.close();
                }
            }
        }
    }

    public final void copyToBuffer(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zza(str, i);
        this.zzno[i2].copyStringToBuffer(i, this.zznn.getInt(str), charArrayBuffer);
    }

    public final void disableLeakDetection() {
        this.zzns = false;
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.zzns && this.zzno.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder stringBuilder = new StringBuilder(178 + String.valueOf(obj).length());
                stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                stringBuilder.append(obj);
                stringBuilder.append(")");
                Log.e("DataBuffer", stringBuilder.toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final boolean getBoolean(String str, int i, int i2) {
        zza(str, i);
        return Long.valueOf(this.zzno[i2].getLong(i, this.zznn.getInt(str))).longValue() == 1;
    }

    public final byte[] getByteArray(String str, int i, int i2) {
        zza(str, i);
        return this.zzno[i2].getBlob(i, this.zznn.getInt(str));
    }

    public final int getCount() {
        return this.zznr;
    }

    public final double getDouble(String str, int i, int i2) {
        zza(str, i);
        return this.zzno[i2].getDouble(i, this.zznn.getInt(str));
    }

    public final float getFloat(String str, int i, int i2) {
        zza(str, i);
        return this.zzno[i2].getFloat(i, this.zznn.getInt(str));
    }

    public final int getInteger(String str, int i, int i2) {
        zza(str, i);
        return this.zzno[i2].getInt(i, this.zznn.getInt(str));
    }

    public final long getLong(String str, int i, int i2) {
        zza(str, i);
        return this.zzno[i2].getLong(i, this.zznn.getInt(str));
    }

    public final Bundle getMetadata() {
        return this.zznp;
    }

    public final int getStatusCode() {
        return this.zzam;
    }

    public final String getString(String str, int i, int i2) {
        zza(str, i);
        return this.zzno[i2].getString(i, this.zznn.getInt(str));
    }

    public final int getWindowIndex(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.zznr;
        Preconditions.checkState(z);
        while (i2 < this.zznq.length) {
            if (i < this.zznq[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zznq.length ? i2 - 1 : i2;
    }

    public final boolean hasColumn(String str) {
        return this.zznn.containsKey(str);
    }

    public final boolean hasNull(String str, int i, int i2) {
        zza(str, i);
        return this.zzno[i2].isNull(i, this.zznn.getInt(str));
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void logCursorMetadataForDebugging() {
        Log.d("DataHolder", "*******************************************");
        int length = this.zzno.length;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("num cursor windows : ");
        stringBuilder.append(length);
        Log.d("DataHolder", stringBuilder.toString());
        length = this.zznr;
        StringBuilder stringBuilder2 = new StringBuilder(46);
        stringBuilder2.append("total number of objects in holder: ");
        stringBuilder2.append(length);
        Log.d("DataHolder", stringBuilder2.toString());
        length = this.zznq.length;
        stringBuilder2 = new StringBuilder(42);
        stringBuilder2.append("total mumber of windowOffsets: ");
        stringBuilder2.append(length);
        Log.d("DataHolder", stringBuilder2.toString());
        for (int i = 0; i < this.zznq.length; i++) {
            length = this.zznq[i];
            StringBuilder stringBuilder3 = new StringBuilder(43);
            stringBuilder3.append("offset for window ");
            stringBuilder3.append(i);
            stringBuilder3.append(" : ");
            stringBuilder3.append(length);
            Log.d("DataHolder", stringBuilder3.toString());
            length = this.zzno[i].getNumRows();
            stringBuilder3 = new StringBuilder(45);
            stringBuilder3.append("num rows for window ");
            stringBuilder3.append(i);
            stringBuilder3.append(" : ");
            stringBuilder3.append(length);
            Log.d("DataHolder", stringBuilder3.toString());
            length = this.zzno[i].getStartPosition();
            stringBuilder2 = new StringBuilder(46);
            stringBuilder2.append("start pos for window ");
            stringBuilder2.append(i);
            stringBuilder2.append(" : ");
            stringBuilder2.append(length);
            Log.d("DataHolder", stringBuilder2.toString());
        }
        Log.d("DataHolder", "*******************************************");
    }

    public final Uri parseUri(String str, int i, int i2) {
        str = getString(str, i, i2);
        return str == null ? null : Uri.parse(str);
    }

    public final void replaceValue(String str, int i, int i2, double d) {
        zza(str, i);
        this.zzno[i2].putDouble(d, i, this.zznn.getInt(str));
    }

    public final void replaceValue(String str, int i, int i2, long j) {
        zza(str, i);
        this.zzno[i2].putLong(j, i, this.zznn.getInt(str));
    }

    public final void replaceValue(String str, int i, int i2, String str2) {
        zza(str, i);
        this.zzno[i2].putString(str2, i, this.zznn.getInt(str));
    }

    public final void replaceValue(String str, int i, int i2, byte[] bArr) {
        zza(str, i);
        this.zzno[i2].putBlob(bArr, i, this.zznn.getInt(str));
    }

    public final void validateContents() {
        int i;
        this.zznn = new Bundle();
        int i2 = 0;
        for (i = 0; i < this.zznm.length; i++) {
            this.zznn.putInt(this.zznm[i], i);
        }
        this.zznq = new int[this.zzno.length];
        i = 0;
        while (i2 < this.zzno.length) {
            this.zznq[i2] = i;
            i += this.zzno[i2].getNumRows() - (i - this.zzno[i2].getStartPosition());
            i2++;
        }
        this.zznr = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zznm, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzno, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }
}
