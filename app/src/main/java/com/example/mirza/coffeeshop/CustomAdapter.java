package com.example.mirza.coffeeshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mirza on 4/25/2018.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;

    int[] coffee;
    String[] names;

    LayoutInflater layout = null;

    public CustomAdapter(Context applicationContext, int[] coffee, String[] names) {
        this.context = applicationContext;
        this.coffee = coffee;
        this.names = names;
        layout = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        View coffeeitem = layout.inflate(R.layout.coffeenames, null);
        ImageView img = (ImageView) coffeeitem.findViewById(R.id.coffeimg);
        TextView txt = (TextView) coffeeitem.findViewById(R.id.coffetv);

        txt.setText(names[i]);
        img.setImageResource(coffee[i]);


        return coffeeitem;
    }
}
