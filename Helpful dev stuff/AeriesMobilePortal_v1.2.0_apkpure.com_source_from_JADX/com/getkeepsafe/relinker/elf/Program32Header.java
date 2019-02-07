package com.getkeepsafe.relinker.elf;

import com.getkeepsafe.relinker.elf.Elf.Header;
import com.getkeepsafe.relinker.elf.Elf.ProgramHeader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Program32Header extends ProgramHeader {
    public Program32Header(ElfParser elfParser, Header header, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = header.phoff + (j * ((long) header.phentsize));
        this.type = elfParser.readWord(allocate, j2);
        this.offset = elfParser.readWord(allocate, j2 + 4);
        this.vaddr = elfParser.readWord(allocate, j2 + 8);
        this.memsz = elfParser.readWord(allocate, j2 + 20);
    }
}
