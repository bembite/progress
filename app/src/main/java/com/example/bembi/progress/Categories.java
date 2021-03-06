package com.example.bembi.progress;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class Categories extends Activity {
    private ArrayList<String> results = new ArrayList<String>();
    private String tableName = DBHelper.tableName;
    private SQLiteDatabase newDB;

    //for test
    ListView lv;
    Context context;
    public static int [] prgmImages={R.drawable.bembi,R.drawable.bembi,R.drawable.bembi,R.drawable.bembi,R.drawable.bembi,R.drawable.bembi,R.drawable.bembi,R.drawable.bembi,R.drawable.bembi};
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};
    public static String [] prgRateList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        openAndQueryDatabase();

        //displayResultList();
        context=this;

        lv=(ListView) findViewById(R.id.list);
        lv.setAdapter(new CategoriesAdapter(this, prgmNameList,prgmImages, prgRateList));
    }
    /*private void displayResultList() {
        TextView tView = new TextView(this);
        tView.setText("This data is retrieved from the database and only 4 " +
                "of the results are displayed");

        getListView().addHeaderView(tView);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, results));
        getListView().setTextFilterEnabled(true);
        //change font color!!!!!
        Log.d("debug","displaying finished");
    }
    */
    private void openAndQueryDatabase() {
        try {
            DBHelper dbHelper = new DBHelper(this.getApplicationContext());
            newDB = dbHelper.getWritableDatabase();
            File dbFile = this.getDatabasePath(DBHelper.DBName);
            Log.d("file", String.valueOf(dbFile.exists()));

            String myPath = dbFile.getPath();
            //newDB=
            //checkDB = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READONLY);

            //SELECT name, rate FROM categories
            Cursor c = newDB.rawQuery("SELECT name, rate FROM " +
                    tableName+";", null);

            if (c != null ) {
                if (c.moveToFirst()) {
                    do {
                        String name = c.getString(c.getColumnIndex("name"));
                        Log.d(" name",name);
                        int rate = c.getInt(c.getColumnIndex("rate"));
                        Log.d("Rate", String.valueOf(rate));
                        results.add("name: " + name + ",rate: " + rate);


                    }while (c.moveToNext());
                }
            }
            else
            {
                Log.d("debug","db is empty");
            }
        } catch (SQLiteException se ) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        } finally {
           // if (newDB != null)
            //    newDB.execSQL("DELETE FROM " + tableName);
            newDB.close();

        }

    }


}
