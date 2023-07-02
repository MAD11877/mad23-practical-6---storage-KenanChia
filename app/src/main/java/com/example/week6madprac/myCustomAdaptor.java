package com.example.week6madprac;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myCustomAdaptor extends RecyclerView.Adapter<viewholder> {
    private ArrayList<User> list_objects;

    public myCustomAdaptor(ArrayList<User> list_objects){
        this.list_objects = list_objects;
    }

    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);

        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview2,parent,false);

        }
        return new viewholder(view, list_objects);
    }

    public void onBindViewHolder(viewholder holder, int position) {
        User list_items = list_objects.get(position);
        holder.txt.setText(list_items.getName());
        holder.txt2.setText(list_items.getDescription());


    }


    public int getItemCount() {
        return list_objects.size();
    }
    @Override
    public int getItemViewType(int position) {
        String name = list_objects.get(position).getName();
        // Get the last digit of the name
        int lastDigit = Integer.parseInt(name.substring(name.length() - 1));

        // Check if the last digit is 7
        if (lastDigit == 7) {
            return 1; // Unique view type for names ending in 7
        } else {
            return 0; // Default view type for other names
        }
    }
}
