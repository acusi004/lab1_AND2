package com.example.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class toDo_Adapter extends BaseAdapter {

    Context context;
    ArrayList<ToDo> list;

    public toDo_Adapter(Context context, ArrayList<ToDo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_lv_to_do_list, parent, false);
        TextView tv_title = convertView.findViewById(R.id.tv_title);
        TextView tv_content = convertView.findViewById(R.id.tv_content);
        TextView tv_date = convertView.findViewById(R.id.tv_date);

        tv_title.setText(list.get(position).getTitle());
        tv_content.setText(list.get(position).getContent());
        tv_date.setText(list.get(position).getDate()+ "");

        return convertView;
    }
}
