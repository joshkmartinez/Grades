package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/models/Version;", "", "major", "", "minor", "build", "revision", "(IIII)V", "getBuild", "()I", "getMajor", "getMinor", "getRevision", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Version.kt */
public final class Version {
    @SerializedName("Build")
    @Expose
    private final int build;
    @SerializedName("Major")
    @Expose
    private final int major;
    @SerializedName("Minor")
    @Expose
    private final int minor;
    @SerializedName("Revision")
    @Expose
    private final int revision;

    @NotNull
    public static /* bridge */ /* synthetic */ Version copy$default(Version version, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = version.major;
        }
        if ((i5 & 2) != 0) {
            i2 = version.minor;
        }
        if ((i5 & 4) != 0) {
            i3 = version.build;
        }
        if ((i5 & 8) != 0) {
            i4 = version.revision;
        }
        return version.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.major;
    }

    public final int component2() {
        return this.minor;
    }

    public final int component3() {
        return this.build;
    }

    public final int component4() {
        return this.revision;
    }

    @NotNull
    public final Version copy(int i, int i2, int i3, int i4) {
        return new Version(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Version) {
                Version version = (Version) obj;
                if (this.major == version.major) {
                    if (this.minor == version.minor) {
                        if (this.build == version.build) {
                            if (this.revision == version.revision) {
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.major * 31) + this.minor) * 31) + this.build) * 31) + this.revision;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Version(major=");
        stringBuilder.append(this.major);
        stringBuilder.append(", minor=");
        stringBuilder.append(this.minor);
        stringBuilder.append(", build=");
        stringBuilder.append(this.build);
        stringBuilder.append(", revision=");
        stringBuilder.append(this.revision);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Version(int i, int i2, int i3, int i4) {
        this.major = i;
        this.minor = i2;
        this.build = i3;
        this.revision = i4;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getBuild() {
        return this.build;
    }

    public final int getRevision() {
        return this.revision;
    }
}
