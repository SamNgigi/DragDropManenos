package com.hai.jedi.dragdrop;

import java.util.ArrayList;
import java.util.Collection;

public class RecyclerViewAdapter {

    private ArrayList<String> data;
    // We add an override constructor that will allow us to work  with
    // ArrayLists
    public RecyclerViewAdapter(ArrayList<String> data){
        this.data = data;
    }

}
