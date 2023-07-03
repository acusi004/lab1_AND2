package com.example.lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoDao {
    DbHelper dbHelper;

    Context context;

    public ToDoDao(DbHelper dbHelper, Context context) {
        this.dbHelper = dbHelper;
        this.context = context;
    }
    public void themCV(ToDo td){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // ghep gtri vao cot tuong ung
        cv.put("title", td.getTitle());
        cv.put("content", td.getContent());
        cv.put("date", td.getDate());
        long check = sqLiteDatabase.insert("TODO", null, cv);
        if(check > 0){
            Toast.makeText(context, "them thanh cong", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "thai bai !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean xoaCV(double date){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        long check = sqLiteDatabase.delete("TODO", "date=?", new String[]{String.valueOf(date)});

        return check != -1;
    }

    public ArrayList<ToDo> getAll(){
        ArrayList<ToDo> list = new ArrayList<>();

        String getAll = "SELECT * FROM toDo";

        Cursor cursor = dbHelper.getWritableDatabase().rawQuery(getAll, null);

        if( cursor !=  null && cursor.getCount() > 0 ){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String title = cursor.getString(0);
                String content = cursor.getString(1);
                double date = cursor.getFloat(2);

                ToDo toDo = new ToDo(title, content, date);
                list.add(toDo);
                cursor.moveToNext();
            }
            cursor.close();
        }else{
            Toast.makeText(context, "ko co gia tri nao !", Toast.LENGTH_SHORT).show();
        }

        return list;
    }


}
