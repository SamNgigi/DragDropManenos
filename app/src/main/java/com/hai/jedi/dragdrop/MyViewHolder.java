package com.hai.jedi.dragdrop;

import android.support.v7.widget.RecyclerView;

import android.widget.TextView;

import android.view.View

public class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView mTitle;
    View rowView;

    public MyViewHolder(View itemView) {
        super(itemView);

        rowView = itemView;
        mTitle = itemView.findViewById(R.id.txtTitle);
    }
}
