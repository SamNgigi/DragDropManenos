package com.hai.jedi.dragdrop;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Collections;

import android.graphics.Color;


public class RecyclerViewAdapter
        extends RecyclerView.Adapter<MyViewHolder>
        implements ItemTouchHelperContract {

    private ArrayList<String> data;
    // We add an override constructor that will allow us to work  with
    // ArrayLists
    public RecyclerViewAdapter(ArrayList<String> data){
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                                      .inflate(R.layout.cardview_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.bindText(data, position);
    }

    @Override
    public int getItemCount(){
        return data.size();
    }

    @Override
    public void onRowMoved(int fromPosition, int toPosition){
        if(fromPosition < toPosition){
            for(int i = fromPosition; i < toPosition; i++){
                Collections.swap(data, i, i+1);
            }
        }
        else {
            for(int i = fromPosition; i>toPosition; i--){
                Collections.swap(data, i, i-1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onRowSelected(MyViewHolder myViewHolder){
        myViewHolder.rowView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void onRowClear(MyViewHolder myViewHolder){
        myViewHolder.rowView.setBackgroundColor(Color.WHITE);
    }

}
