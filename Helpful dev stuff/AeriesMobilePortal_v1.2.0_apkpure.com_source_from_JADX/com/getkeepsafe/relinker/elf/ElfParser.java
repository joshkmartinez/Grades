package com.getkeepsafe.relinker.elf;

import com.getkeepsafe.relinker.elf.Elf.DynamicStructure;
import com.getkeepsafe.relinker.elf.Elf.Header;
import com.getkeepsafe.relinker.elf.Elf.ProgramHeader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElfParser implements Closeable, Elf {
    private final int MAGIC = 1179403647;
    private final FileChannel channel;

    public ElfParser(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.channel = new FileInputStream(file).getChannel();
    }

    public Header parseHeader() throws IOException {
        this.channel.position(0);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (readWord(allocate, 0) == 1179403647) {
            short readByte = readByte(allocate, 4);
            boolean z = readByte(allocate, 5) == (short) 2;
            if (readByte == (short) 1) {
                return new Elf32Header(z, this);
            }
            if (readByte == (short) 2) {
                return new Elf64Header(z, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> parseNeededDependencies() throws IOException {
        long j;
        this.channel.position(0);
        List<String> arrayList = new ArrayList();
        Header parseHeader = parseHeader();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(parseHeader.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) parseHeader.phnum;
        int i = 0;
        if (j2 == 65535) {
            j2 = parseHeader.getSectionHeader(0).info;
        }
        for (j = 0; j < j2; j++) {
            ProgramHeader programHeader = parseHeader.getProgramHeader(j);
            if (programHeader.type == 2) {
                j = programHeader.offset;
                break;
            }
        }
        j = 0;
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        List<Long> arrayList2 = new ArrayList();
        long j3 = 0;
        while (true) {
            DynamicStructure dynamicStructure = parseHeader.getDynamicStructure(j, i);
            if (dynamicStructure.tag == 1) {
                arrayList2.add(Long.valueOf(dynamicStructure.val));
            } else if (dynamicStructure.tag == 5) {
                j3 = dynamicStructure.val;
            }
            i++;
            if (dynamicStructure.tag == 0) {
                break;
            }
            long j4 = 0;
        }
        if (j3 != 0) {
            long offsetFromVma = offsetFromVma(parseHeader, j2, j3);
            for (Long longValue : arrayList2) {
                arrayList.add(readString(allocate, offsetFromVma + longValue.longValue()));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    private long offsetFromVma(Header header, long j, long j2) throws IOException {
        for (long j3 = 0; j3 < j; j3++) {
            ProgramHeader programHeader = header.getProgramHeader(j3);
            if (programHeader.type == 1 && programHeader.vaddr <= j2 && j2 <= programHeader.vaddr + programHeader.memsz) {
                return (j2 - programHeader.vaddr) + programHeader.offset;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public void close() throws IOException {
        this.channel.close();
    }

    protected String readString(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            long j2 = j + 1;
            j = readByte(byteBuffer, j);
            if (j == null) {
                return stringBuilder.toString();
            }
            stringBuilder.append((char) j);
            j = j2;
        }
    }

    protected long readLong(ByteBuffer byteBuffer, long j) throws IOException {
        read(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    protected long readWord(ByteBuffer byteBuffer, long j) throws IOException {
        read(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    protected int readHalf(ByteBuffer byteBuffer, long j) throws IOException {
        read(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    protected short readByte(ByteBuffer byteBuffer, long j) throws IOException {
        read(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    protected void read(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.channel.read(byteBuffer, j + j2);
            if (read != -1) {
                j2 += (long) read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }
}
