package com.getkeepsafe.relinker.elf;

import com.getkeepsafe.relinker.elf.Elf.DynamicStructure;
import com.getkeepsafe.relinker.elf.Elf.Header;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic64Structure extends DynamicStructure {
    public Dynamic64Structure(ElfParser elfParser, Header header, long j, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(header.bigEndian != null ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 16));
        this.tag = elfParser.readLong(allocate, j2);
        this.val = elfParser.readLong(allocate, j2 + 8);
    }
}
