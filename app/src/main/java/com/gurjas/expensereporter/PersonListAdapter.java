package com.gurjas.expensereporter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


public class PersonListAdapter extends ArrayAdapter<Person> {

private static final String TAG = "PersonListAdapter";

private Context mContext;
private int mResource;
private int lastPosition = -1;

/**
 * Holds variables in a View
 */
private static class ViewHolder {
    TextView name;
    TextView birthday;
    TextView sex;
}

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public PersonListAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getName();
        String birthday = getItem(position).getBirthday();
        String sex = getItem(position).getSex();

        //Create the person object with the information
        Person person = new Person(name,birthday,sex);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvName = convertView.findViewById(R.id.textView1);
        TextView tvSex = convertView.findViewById(R.id.textView3);
        TextView tvBirthday = convertView.findViewById(R.id.textView2);

        tvName.setText(name);
        tvSex.setText(sex);
        tvBirthday.setText(birthday);

        return convertView;
    }
}