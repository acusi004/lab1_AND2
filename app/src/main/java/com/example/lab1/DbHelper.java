package com.example.lab1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    Context context;
    public DbHelper(Context context){
        super(context, "TodoDatabase.db", null, 1);
        this.context = context;
    }

    String toDo = "CREATE TABLE TODO (title TEXT PRIMARY KEY, content TEXT, date DOUBLE)";

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(toDo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {


        if (i != ii){
            // xoa bang neu ton tai
            DB.execSQL("DROP TABLE IF EXISTS TODO");
            // GOI lai ham onCreate
            onCreate(DB);
        }
    }
}
