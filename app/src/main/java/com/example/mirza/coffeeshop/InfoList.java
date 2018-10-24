package com.example.mirza.coffeeshop;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mirza on 4/25/2018.
 */

public class InfoList extends ArrayAdapter<ForInfo1>


{

private Activity context;
    private List<ForInfo1>infolist;


    public InfoList(Activity context, List<ForInfo1>infolist){


        super(context, R.layout.list_layout, infolist);
this.context=context;
        this.infolist=infolist;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layout= context.getLayoutInflater();

        View listitem= layout.inflate(R.layout.list_layout,null, true);

        TextView name= (TextView) listitem.findViewById(R.id.infotv);
        TextView tblno= (TextView) listitem.findViewById(R.id.infotv2);

        ForInfo1 info1= infolist.get(position);
        name.setText(info1.getName());
        tblno.setText(info1.getTblno());

        return listitem;


    }
}
