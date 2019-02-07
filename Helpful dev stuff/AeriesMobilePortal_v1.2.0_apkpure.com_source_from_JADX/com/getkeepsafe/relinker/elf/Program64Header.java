package com.getkeepsafe.relinker.elf;

import com.getkeepsafe.relinker.elf.Elf.Header;
import com.getkeepsafe.relinker.elf.Elf.ProgramHeader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Program64Header extends ProgramHeader {
    public Program64Header(ElfParser elfParser, Header header, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = header.phoff + (j * ((long) header.phentsize));
        this.type = elfParser.readWord(allocate, j2);
        this.offset = elfParser.readLong(allocate, j2 + 8);
        this.vaddr = elfParser.readLong(allocate, j2 + 16);
        this.memsz = elfParser.readLong(allocate, j2 + 40);
    }
}
