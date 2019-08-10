package com.gurjas.expensereporter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       final EditText name = (EditText) findViewById(R.id.editText);
       final EditText money = (EditText) findViewById(R.id.editText3);
       //final EditText date = (EditText) findViewById(R.id.editText4);

        Button adddata = (Button) findViewById(R.id.button2);
        Button clear = (Button) findViewById(R.id.button4);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clearing Data");
                deldata();
                Snackbar.make(view, "Cleared ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a =  name.getText().toString();

                String b =  money.getText().toString();

                name.setText("");
                money.setText("");

                //String c =  date.getText().toString();



                aaaa(a, b);

                Snackbar.make(view, "Added", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void aaaa(String aa, String bb)
    {
        Database dbHelper = new Database(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SQLiteDatabase dbr = dbHelper.getReadableDatabase();

        String projections[] = {"id", "name", "money", "day", "dayy", "month", "year", "time"};
        //                                               3      4        5      6         7
        SQLiteDatabase dbnew = dbHelper.getReadableDatabase();
        Cursor c = dbnew.query("expense", projections, null, null, null, null, null);

        String r;
        if(c.getCount()==0)
        {
            r = "0";
        }
        else
        {
            c.moveToLast();

            int a = Integer.valueOf(c.getString(0));
            a++;
            r = String.valueOf(a);
        }


        long l = (System.currentTimeMillis()/1000);
        Date d = new Date(l);
        String cc = d.toString();

        String[] Date;
        Date = cc.split(" ");
        int size = Date.length;

        for(int i = 0; i < size; i++)
        {
            System.out.println("xprinting " + Date[i]);
        }

        //System.out.println("prin X "+ d);
        System.out.println("name is " + aa + "Money is " + bb + "date is " +cc);

       // money int, day text, dayy text, month text, year text, time text

        ContentValues vals = new ContentValues();
        vals.put("id", r);
        vals.put("name", aa);
        vals.put("money", bb);
        vals.put("day", Date[0]);
        vals.put("dayy", Date[2]);
        vals.put("month", Date[1]);
        vals.put("year", Date[5]);
        vals.put("time", Date[3]);

        long row = db.insert("expense", null, vals);

        System.out.println("hello :" + row);
    }

    public void deldata()
    {
        Database dbHelper = new Database(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL("drop table expense");

        dbHelper = new Database(this);
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);
    }
}
