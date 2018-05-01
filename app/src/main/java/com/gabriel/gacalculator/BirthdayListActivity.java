package com.gabriel.gacalculator;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BirthdayListActivity extends AppCompatActivity {

    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_list);


        ListView bdayListView = findViewById(R.id.bdayListView);

        ArrayList<String> bdayDates = new ArrayList<String>();

        bdayDates.add("e4124214");
        bdayDates.add("4234234124");
        bdayDates.add("f2f2f");
        bdayDates.add("f321f21");
        bdayDates.add("1243rff");
        bdayDates.add("e412g423bv24v24214");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, bdayDates);
        bdayListView.setAdapter(arrayAdapter);


        fab = findViewById(R.id.bdayFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BirthdayListActivity.this, CreateUserActivity.class));
            }
        });

    }




}
