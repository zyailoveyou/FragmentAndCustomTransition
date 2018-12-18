package com.cop.zqc.fragmentmywork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter<T> extends BaseAdapter {

    ArrayList<T> DataStore;
    Context mContext;
    private TextView mTextView;

    public MyAdapter(ArrayList<T> dataStore,Context context) {
        DataStore = dataStore;
        mContext = context;
    }

    @Override
    public int getCount() {
        return DataStore.size();
    }

    @Override
    public Object getItem(int position) {
        return DataStore.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)

        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_fill,null);


        }

        mTextView = convertView.findViewById(R.id.TextString);
        mTextView.setText((String)(DataStore.get(position)));

        return convertView;

    }
}
