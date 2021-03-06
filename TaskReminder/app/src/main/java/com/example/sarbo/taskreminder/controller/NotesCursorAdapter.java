package com.example.sarbo.taskreminder.controller;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.sarbo.taskreminder.R;
import com.example.sarbo.taskreminder.database.DBOpenHelper;

public class NotesCursorAdapter extends CursorAdapter {
    public NotesCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(
                R.layout.task_list_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String noteText = cursor.getString(
                cursor.getColumnIndex(DBOpenHelper.TASK_TEXT));

        int pos = noteText.indexOf(10);// 10 is the ASCII value of line feed character

        if (pos !=-1){
            noteText = noteText.substring(0,pos) + " ...";
        }

        TextView tv = (TextView) view.findViewById(R.id.taskWork);
        tv.setText(noteText);
    }
}
