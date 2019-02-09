package com.hai.jedi.dragdrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;
    ArrayList<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // From the activity_main.xml
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void populateRecyclerView(){
        Collections.addAll(stringList,
                 "Item 1", "Item 2", "Item 3", "Item 4",
                           "Item 5", "Item 6", "Item 7", "Item 8"
                        );
        mAdapter = new RecyclerViewAdapter(stringList);

        ItemTouchHelper.Callback call = new ItemMoveCallBack(mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(mAdapter);
    }

}
