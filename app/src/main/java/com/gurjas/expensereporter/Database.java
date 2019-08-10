package com.gurjas.expensereporter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "expenses.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        
        sqLiteDatabase.execSQL("create table expense(id int NOT NULL PRIMARY KEY, name text, money int, day text, dayy text, month text, year text, time text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop if table exists expense");
        onCreate(sqLiteDatabase);
    }
}
