package com.gurjas.expensereporter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Database dbHelper = new Database(this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //db.execSQL("drop table expense");
      //dbHelper.onCreate(db);
//

//        ContentValues vals = new ContentValues();
//        vals.put("id", "2");
//        vals.put("name", "Amazon");
//        vals.put("money", "120");
//        vals.put("date", "nohello");
//
//        long row = db.insert("expense", null, vals);
//
//        System.out.println("hello :" + row);


//
//
//


//        String projections[] = {"id", "name", "money", "date"};
//
//        SQLiteDatabase dbnew = dbHelper.getReadableDatabase();
//        Cursor c = dbnew.query("expense", projections, null, null, null, null, null);
//
//        int x = c.getCount();
//        System.out.println("printing size is " + x);
//        c.moveToFirst();
//        for(int i = 0; i < x; i++)
//        {
//            System.out.println("printing string is " + c.getString(0));
//            System.out.println("printing string is " + c.getString(1));
//            System.out.println("printing string is " + c.getString(2));
//            System.out.println("printing string is " + c.getString(3));
//            c.moveToNext();
//        }

        Button add = findViewById(R.id.button);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity();
            }
        });

        Button show = findViewById(R.id.button2);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(openactivitycheck()== 0)
                {
                    Snackbar.make(view, "Please add expenses before proceeding ", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                }
                else
                {
                    openactivityb();
                }
            }
        });


        Button graph = findViewById(R.id.button3);


        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(openactivitycheck()== 0)
                {
                    Snackbar.make(view, "Please add expenses before proceeding ", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else
                {
                    openactivityc();
                }
            }
        });




    }

    public void openactivity()
    {
        Intent open2 =  new Intent(this, Main2Activity.class);
        startActivity(open2);
    }
    public void openactivityb()
    {
        Intent open1 =  new Intent(this, ShowData.class);
        startActivity(open1);
    }

    public int openactivitycheck()
    {
        Database dbHelper = new Database(this);

        String[] projections = {"id", "name", "money", "day", "dayy", "month", "year", "time"};
        //                                               3      4        5      6         7
        SQLiteDatabase dbnew = dbHelper.getReadableDatabase();
        Cursor c = dbnew.query("expense", projections, null, null, null, null, null);
        int x = c.getCount();
        c.close();
        return x;
    }

    public void openactivityc()
    {
        Intent open1 =  new Intent(this, Graph.class);
        startActivity(open1);
    }
}
