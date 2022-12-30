package com.example.test6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class listAdaptater extends ArrayAdapter<Favorites> {
    public listAdaptater(Context context, ArrayList<Favorites> favoritesArrayList) {
            super(context, R.layout.list_item, favoritesArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Favorites fav =getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        TextView  name = convertView.findViewById(R.id.name);
        TextView  message = convertView.findViewById(R.id.message);
        name.setText(fav.name);
        message.setText(fav.message);
        return convertView;
    }
}
