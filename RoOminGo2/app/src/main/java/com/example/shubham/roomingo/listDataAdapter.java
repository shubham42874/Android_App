package com.example.shubham.roomingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham on 11-04-2017.
 */
public class listDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public listDataAdapter(Context context, int resource) {
        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView RoomName,id;
    }
    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {

        return list.size();
    }


    @Override
    public Object getItem(int pos) {
        return  list.get(pos);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.smak_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.RoomName=(TextView)row.findViewById(R.id.textView22);
            layoutHandler.id=(TextView)row.findViewById(R.id.textView21);


            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();
        }
        dataprovider dataprovider = (dataprovider) this.getItem(pos);
        layoutHandler.RoomName.setText(dataprovider.getRoomName());
        layoutHandler.id.setText(dataprovider.getID());
        return row;
    }
}
