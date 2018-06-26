package com.example.kranthi.algotest;

/**
 * Created by kranthi on 20-09-2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


/**
 * Created by kranthi on 04-09-2016.
 */




public final class DbCreate {

    public DbCreate() {
    }

    public static abstract class DbEntry implements BaseColumns {
        public static final String TABLE_NAME = "permissionList";
        public static final String TABLE_NAME_2 = "history";
        //public static final String COLUMN_PERMISSION_ID = "permissionID";
        public static final String COLUMN_NAME_PERMISSION = "permission";
        public static final String COLUMN_NAME_PACKAGE = "package";
        public static final String COLUMN_NAME_RESULT = "result";
        public static final String COLUMN_NAME_IDE = "ide";
        public static final String COLUMN_NAME_LMT = "lmt";
    }


    public static class DbDbBHelper extends SQLiteOpenHelper {

        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Permissions.db";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";

        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DbCreate.DbEntry.TABLE_NAME + " (" +
                        DbCreate.DbEntry._ID + " INTEGER PRIMARY KEY," + // Heredado de BaseColumns
                        DbCreate.DbEntry.COLUMN_NAME_PERMISSION + TEXT_TYPE +
                        " )";
        private static final String SQL_CREATE_ENTRIES_2 =
                "CREATE TABLE " + DbCreate.DbEntry.TABLE_NAME_2 + " (" +
                        DbCreate.DbEntry._ID + " INTEGER PRIMARY KEY," + // Heredado de BaseColumns
                        DbEntry.COLUMN_NAME_PACKAGE + TEXT_TYPE +COMMA_SEP +
                        DbEntry.COLUMN_NAME_RESULT + TEXT_TYPE + COMMA_SEP +
                        DbEntry.COLUMN_NAME_IDE + TEXT_TYPE +
                        DbEntry.COLUMN_NAME_LMT + TEXT_TYPE +
                        " )";

        //DbCreate.DbEntry.COLUMN_PERMISSION_ID + TEXT_TYPE + COMMA_SEP +
        //DbCreate.DbEntry.COLUMN_NAME_PACKAGE_1 + TEXT_TYPE + COMMA_SEP +
        //DbCreate.DbEntry.COLUMN_NAME_PACKAGE_2 + TEXT_TYPE + COMMA_SEP +
        //DbCreate.DbEntry.COLUMN_NAME_PACKAGE_3 + TEXT_TYPE + COMMA_SEP +

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DbCreate.DbEntry.TABLE_NAME;
        private static final String SQL_DELETE_ENTRIES_2 =
                "DROP TABLE IF EXISTS " + DbCreate.DbEntry.TABLE_NAME_2;


        public DbDbBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
            db.execSQL(SQL_CREATE_ENTRIES_2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
            db.execSQL(SQL_DELETE_ENTRIES_2);
            onCreate(db);
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }


    }

}