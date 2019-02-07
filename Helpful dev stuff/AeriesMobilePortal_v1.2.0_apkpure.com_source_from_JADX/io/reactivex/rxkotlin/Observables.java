package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Ja\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00050\fH\bJ{\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00050\u000fH\bJ\u0001\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00050\u0012H\bJ¯\u0001\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00050\u0015H\bJÉ\u0001\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u000422\b\u0004\u0010\u000b\u001a,\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00050\u0018H\bJã\u0001\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u000428\b\u0004\u0010\u000b\u001a2\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00050\u001bH\bJý\u0001\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\u001c\"\u0004\b\b\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00042>\b\u0004\u0010\u000b\u001a8\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u00050\u001eH\bJ\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\u001c\"\u0004\b\b\u0010\u001f\"\u0004\b\t\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\u00042D\b\u0004\u0010\u000b\u001a>\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00050!H\bJa\u0010\"\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00050\fH\bJ{\u0010\"\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00050\u000fH\bJ\u0001\u0010\"\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00050\u0012H\bJ¯\u0001\u0010\"\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00050\u0015H\bJÉ\u0001\u0010\"\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u000422\b\u0004\u0010\u000b\u001a,\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00050\u0018H\bJã\u0001\u0010\"\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u000428\b\u0004\u0010\u000b\u001a2\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00050\u001bH\bJý\u0001\u0010\"\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\u001c\"\u0004\b\b\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00042>\b\u0004\u0010\u000b\u001a8\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u00050\u001eH\bJ\u0002\u0010\"\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0005H\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\u001c\"\u0004\b\b\u0010\u001f\"\u0004\b\t\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\u00042D\b\u0004\u0010\u000b\u001a>\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00050!H\b¨\u0006#"}, d2 = {"Lio/reactivex/rxkotlin/Observables;", "", "()V", "combineLatest", "Lio/reactivex/Observable;", "R", "kotlin.jvm.PlatformType", "T1", "T2", "source1", "source2", "combineFunction", "Lkotlin/Function2;", "T3", "source3", "Lkotlin/Function3;", "T4", "source4", "Lkotlin/Function4;", "T5", "source5", "Lkotlin/Function5;", "T6", "source6", "Lkotlin/Function6;", "T7", "source7", "Lkotlin/Function7;", "T8", "source8", "Lkotlin/Function8;", "T9", "source9", "Lkotlin/Function9;", "zip", "rxkotlin_main"}, k = 1, mv = {1, 1, 6})
/* compiled from: Observables.kt */
public final class Observables {
    public static final Observables INSTANCE = null;

    static {
        Observables observables = new Observables();
    }

    private Observables() {
        INSTANCE = this;
    }

    @NotNull
    public final <T1, T2, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        observable = Observable.combineLatest(observable, observable2, new Observables$combineLatest$1(function2));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        observable = Observable.combineLatest(observable, observable2, observable3, new Observables$combineLatest$2(function3));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        observable = Observable.combineLatest(observable, observable2, observable3, observable4, new Observables$combineLatest$3(function4));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        observable = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, new Observables$combineLatest$4(function5));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        observable = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, new Observables$combineLatest$5(function6));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(function7, "combineFunction");
        observable = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, new Observables$combineLatest$6(function7));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(function8, "combineFunction");
        observable = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, new Observables$combineLatest$7(function8));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Observable<T9> observable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(observable9, "source9");
        Intrinsics.checkParameterIsNotNull(function9, "combineFunction");
        observable = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, new Observables$combineLatest$8(function9));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        observable = Observable.zip(observable, observable2, new Observables$zip$1(function2));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        observable = Observable.zip(observable, observable2, observable3, new Observables$zip$2(function3));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        observable = Observable.zip(observable, observable2, observable3, observable4, new Observables$zip$3(function4));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        observable = Observable.zip(observable, observable2, observable3, observable4, observable5, new Observables$zip$4(function5));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        observable = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, new Observables$zip$5(function6));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(function7, "combineFunction");
        observable = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, new Observables$zip$6(function7));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(function8, "combineFunction");
        observable = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, new Observables$zip$7(function8));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }

    @NotNull
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Observable<T9> observable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(observable9, "source9");
        Intrinsics.checkParameterIsNotNull(function9, "combineFunction");
        observable = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, new Observables$zip$8(function9));
        if (observable == null) {
            Intrinsics.throwNpe();
        }
        return observable;
    }
}
