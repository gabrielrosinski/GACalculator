package com.gabriel.gacalculator.BirthdayAssignmnet;




 import android.arch.persistence.room.Room;
 import android.content.Intent;
 import android.support.design.widget.FloatingActionButton;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
 import android.util.Log;
 import android.view.View;
 import android.widget.ArrayAdapter;

 import com.gabriel.gacalculator.BirthdayAssignmnet.Model.BirthdayUser;
 import com.gabriel.gacalculator.R;

 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Collections;
 import java.util.Date;


public class BirthdayListActivity extends AppCompatActivity{

    FloatingActionButton fab;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<BirthdayUser> birthdayUsers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_list);



        //fetch all birthdates from db
        BirthdayDatabase db = Room.databaseBuilder(getApplicationContext(), BirthdayDatabase.class, "BirthdayDateDB")
                .allowMainThreadQueries() //TODO: see if i can use the callback function here
                .build();

        birthdayUsers = (ArrayList<BirthdayUser>) db.userBirthdayDao().getAllBirthdaysUsers();

        ArrayList<String> bdayDates = birthdayListFromBirthdayUsers(birthdayUsers);


//                ArrayList<String> bdayDates = new ArrayList<String>();
//
//                bdayDates.add("e4124214");
//                bdayDates.add("4234234124");
//                bdayDates.add("f2f2f");
//                bdayDates.add("f321f21");
//                bdayDates.add("1243rff");
//                bdayDates.add("e412g423bv24v24214");



        //should be sorted and in arrayList<String> format



        // set up the RecyclerView
        recyclerView = findViewById(R.id.birthdayRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BirthdayDateAdapter(bdayDates);
        recyclerView.setAdapter(adapter);



        fab = findViewById(R.id.bdayFab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(BirthdayListActivity.this, CreateUserActivity.class));
            }
        });
    }


    private String epochTimeToString(long epochTime){
        Date date = new Date(epochTime);
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }

    private ArrayList<String> birthdayListFromBirthdayUsers(ArrayList<BirthdayUser> birthdayUserList)
    {
        ArrayList<String> birthdayList = new ArrayList<String>();
        ArrayList<Long> epochTimeList = new ArrayList<Long>();
        long currentDate;
        long userBirthdayDate;

        Calendar cal = Calendar.getInstance();
        currentDate = cal.getTimeInMillis();
        int year = cal.get(Calendar.YEAR);

        for (BirthdayUser userBirthday:  birthdayUserList) {

            //set user birth date
            cal.setTime(new Date(userBirthday.epochtimeDate));

            //set users current year
            cal.set(Calendar.YEAR, year);

            //get users current epochtime
            userBirthdayDate = cal.getTimeInMillis();

            Log.e("fsdfe", "User current date: " + epochTimeToString(userBirthdayDate));
            Log.e("fsdfe", "Current date: " + epochTimeToString(currentDate));

            if (userBirthdayDate < currentDate){
                cal.set(Calendar.YEAR, year + 1);
            }

            Log.e("fsdfe", "User date after change" + epochTimeToString(cal.getTimeInMillis()));

            epochTimeList.add(cal.getTimeInMillis());
        }

        //sort for ascending
        Collections.sort(epochTimeList);

        //turn dates to Strings
        for (Long epochtime:epochTimeList) {
            birthdayList.add(epochTimeToString(epochtime));
        }

        return birthdayList;
    }
}
