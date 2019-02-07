package com.google.android.gms.internal.clearcut;

final class zzee {
    private final String info;
    private int position = 0;

    zzee(String str) {
        this.info = str;
    }

    final boolean hasNext() {
        return this.position < this.info.length();
    }

    final int next() {
        String str = this.info;
        int i = this.position;
        this.position = i + 1;
        char charAt = str.charAt(i);
        if (charAt < '?') {
            return charAt;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        while (true) {
            String str2 = this.info;
            int i4 = this.position;
            this.position = i4 + 1;
            char charAt2 = str2.charAt(i4);
            if (charAt2 < '?') {
                return i2 | (charAt2 << i3);
            }
            i2 |= (charAt2 & 8191) << i3;
            i3 += 13;
        }
    }
}