package com.gabriel.gacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gabriel.gacalculator.BirthdayAssignmnet.BirthdayListActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainListAdapter.ItemClickListener {

    MainListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activty_main);

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Assignment 1: Calculator");
        animalNames.add("Assignment 2: Birthday list");
        animalNames.add("Assignment 3: Low level graphics");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.mainRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainListAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }


    public void onItemClick(View view, int position) {
//        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();


        Intent i = null;

        switch (position) {
            case 0:
                i = new Intent(this, Lesson2Activity.class);
                break;
            case 1:
                i = new Intent(this, BirthdayListActivity.class);
                break;
            case 2:
                i = new Intent(this, Lesson3Acitvity.class);
                break;
        }

        startActivity(i);
    }


}
