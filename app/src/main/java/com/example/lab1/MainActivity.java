package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ToDoDao mToDoDao;

    ArrayList<ToDo> arrTodoList = new ArrayList<>();

    DbHelper db;
    Button btnADd, btnRemove;

    toDo_Adapter mToDoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DbHelper(MainActivity.this);
        mToDoDao  = new ToDoDao(db, MainActivity.this);
        lv = findViewById(R.id.lv_toDoList);
        btnRemove = findViewById(R.id.btn_delete);
        arrTodoList = mToDoDao.getAll();
        mToDoAdapter = new toDo_Adapter(this, arrTodoList);
        lv.setAdapter(mToDoAdapter);

        findViewById(R.id.btn_add).setOnClickListener(view -> {
            ToDo td1 = new ToDo("java ", "hoc java co ban", 27/02/2023);
            ToDoDao toDoDao = new ToDoDao(db, MainActivity.this);
            toDoDao.themCV(td1);
            arrTodoList.add(td1);
            mToDoAdapter.notifyDataSetChanged();
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDo td1 = new ToDo("java ", "hoc java co ban", 27/02/2023);
            mToDoDao.xoaCV(27/02/2023);
                Toast.makeText(MainActivity.this, "xoa thanh cong", Toast.LENGTH_SHORT).show();
            }
        });

    }


}