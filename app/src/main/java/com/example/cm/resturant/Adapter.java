package com.example.cm.resturant;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cm on 07/08/2017.
 */

public class Adapter extends ArrayAdapter {
    Context context;
    int res;
    public Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<data> objects) {
        super(context, resource, objects);
        this.context=context;
        this.res=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(res,parent,false);
        TextView food = (TextView) convertView.findViewById(R.id.showfood);
        TextView price = (TextView) convertView.findViewById(R.id.showprice);
        TextView name = (TextView) convertView.findViewById(R.id.showname);
        TextView phone = (TextView) convertView.findViewById(R.id.showphone);
        TextView address = (TextView) convertView.findViewById(R.id.showaddress);

        data data = (data) getItem(position);

        food.setText(data.getFood());
        price.setText(data.getPrice());
        name.setText(data.getName());
        phone.setText(data.getPhone());
        address.setText(data.getAddress());

        return convertView;
    }
}
