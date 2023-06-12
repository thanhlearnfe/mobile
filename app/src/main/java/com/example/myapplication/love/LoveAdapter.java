package com.example.myapplication.love;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class LoveAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Love> arrayList;
    private TextView serialNum, name, contactNum;
    public LoveAdapter(Context context, ArrayList<Love> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.t_love_item, parent, false);
        serialNum = convertView.findViewById(R.id.serailNumber);
        serialNum.setText(" " + arrayList.get(position).getName());

        return convertView;
    }
}
