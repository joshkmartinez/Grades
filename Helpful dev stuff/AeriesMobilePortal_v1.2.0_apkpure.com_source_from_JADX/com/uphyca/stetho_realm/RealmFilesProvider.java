package com.uphyca.stetho_realm;

import com.facebook.stetho.inspector.database.DatabaseFilesProvider;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RealmFilesProvider implements DatabaseFilesProvider {
    private final Pattern databaseNamePattern;
    private final File folder;

    class C04931 implements FilenameFilter {
        C04931() {
        }

        public boolean accept(File file, String str) {
            return RealmFilesProvider.this.databaseNamePattern.matcher(str).matches();
        }
    }

    public RealmFilesProvider(File file, Pattern pattern) {
        this.folder = file;
        this.databaseNamePattern = pattern;
    }

    public List<File> getDatabaseFiles() {
        File file = this.folder;
        String[] list = file.list(new C04931());
        List<File> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (String file2 : list) {
            File file3 = new File(file, file2);
            if (file3.isFile() && file3.canRead()) {
                arrayList.add(file3);
            }
        }
        return arrayList;
    }
}
