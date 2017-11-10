package com.example.bembi.progress;

import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;

/**
 * Created by bembi on 11/4/17.
 */


public class DBHelper extends SQLiteOpenHelper {
    public SQLiteDatabase DB;
    public String DBPath;
    public static String DBName = "progress";
    public static final int version = '1';
    public static Context currentContext;
    public static String tableName = "categories";
    public DBHelper(Context context) {
        super(context, DBName, null, version);
        currentContext = context;
        //DBPath = "/data/data/" + context.getPackageName() + "/databases";
        DBPath=context.getFilesDir().getPath()+"/databases/";
        createDatabase();

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private void createDatabase() {
        boolean dbExists = checkDbExists();
        Log.d("debug", String.valueOf(dbExists));

        if (dbExists) {
            // do nothing
        } else {
            DB = currentContext.openOrCreateDatabase(DBName, 0, null);
            //CREATE TABLE IF NOT EXISTS second (ID Integer PRIMARY KEY AUTOINCREMENT, name varchar(255) NOT NULL, rate int NOT NULL);

            DB.execSQL("CREATE TABLE IF NOT EXISTS " +
                    tableName +
                    " (ID Integer PRIMARY KEY AUTOINCREMENT, name varchar(255) NOT NULL, rate int NOT NULL);" );
            //INSERT INTO categories (name,rate) VALUES ('rwerwer',1);
            DB.execSQL("INSERT INTO " +
                    tableName +
                    " VALUES (null,'Reading',-1);");

            DB.execSQL("INSERT INTO " +
                    tableName +
                    " VALUES (null,'Working',6);");
            DB.execSQL("INSERT INTO " +
                    tableName +
                    " VALUES (null,'Studing',12);");

            Log.d("debug","inserted");
            DB.close();

        }

    }
    private boolean checkDbExists() {
        SQLiteDatabase checkDB = null;
        Log.d("sql","checking if exist");
        try {
            File dbFile = currentContext.getDatabasePath(DBName);
            Log.d("file", String.valueOf(dbFile.exists()));

            String myPath = dbFile.getPath();
            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY);
            Log.d("debug_sql","opened");


        } catch (SQLiteCantOpenDatabaseException e) {
            Log.d("debug_sql","can`t open");
            // database does't exist yet.

        }

        if (checkDB != null) {

            checkDB.close();

        }
        Log.d("debug", String.valueOf(checkDB));

        return checkDB != null ? true : false;
    }

}
