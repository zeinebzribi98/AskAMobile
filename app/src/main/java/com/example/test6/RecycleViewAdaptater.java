package com.example.test6;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdaptater extends RecyclerView.Adapter<RecycleViewAdaptater.myViewHolder> {


    public RecycleViewAdaptater(int[] arr) {
        this.arr = arr;
    }

    int []arr;

    List<String> list=new ArrayList<String>();
    //Adding elements in the List

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
        myViewHolder myViewHolder=new myViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        list.add("Pubs");
        list.add("Beauty and Spa");
        list.add("Restaurants");
        list.add("Explore");
        list.add("Community");
        list.add("Home service");
        list.add("Tours and activities");
        list.add("Professional Services");
        list.add("Coffee and Tea");
        holder.imageView.setImageResource(arr[position]);
        holder.textView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);

        }
    }
}
