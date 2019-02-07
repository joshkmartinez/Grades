package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.database.SQLiteDatabaseCompat.SQLiteOpenOptions;
import java.io.File;

public class DefaultDatabaseConnectionProvider implements DatabaseConnectionProvider {
    public SQLiteDatabase openDatabase(File file) throws SQLiteException {
        return performOpen(file, determineOpenOptions(file));
    }

    @SQLiteOpenOptions
    protected int determineOpenOptions(File file) {
        String parent = file.getParent();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getName());
        stringBuilder.append("-wal");
        return new File(parent, stringBuilder.toString()).exists() != null ? 1 : null;
    }

    protected SQLiteDatabase performOpen(File file, @SQLiteOpenOptions int i) {
        SQLiteDatabaseCompat instance = SQLiteDatabaseCompat.getInstance();
        file = SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, instance.provideOpenFlags(i) | 0);
        instance.enableFeatures(i, file);
        return file;
    }
}
