
package com.gurjas.expensereporter;

        import androidx.appcompat.app.AppCompatActivity;

        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.widget.ListView;

        import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        ListView vListView = findViewById(R.id.Listview);

        // money int, day text, dayy text, month text, year text, time text
        String[] projections = {"id", "name", "money", "day", "dayy", "month", "year", "time"};

        Database dbHelper = new Database(this);
        SQLiteDatabase dbnew = dbHelper.getReadableDatabase();
        Cursor c = dbnew.query("expense", projections, null, null, null, null, null);

        int x = c.getCount();

        c.moveToFirst();
        Person john;
        ArrayList<Person> peopleList = new ArrayList<>();
        for(int i = 0; i < x; i++)
        {
            john = new Person(c.getString(1),"$"+c.getString(2),c.getString(4)+"/"+c.getString(5)+"/"+c.getString(6));
            peopleList.add(john);
            //System.out.println("ID: " + c.getString(0) +" Name: " + c.getString(1)+ " Money: "+ c.getString(2)+ " Day: " + c.getString(3) + " Dayy: " + c.getString(4)+ " month: " + c.getString(5) + " year: " + c.getString(6) +  " time: " + c.getString(7));
            PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view, peopleList);
            vListView.setAdapter(adapter);

            c.moveToNext();
        }

        c.close();







        //Create the Person objects







    }

}

