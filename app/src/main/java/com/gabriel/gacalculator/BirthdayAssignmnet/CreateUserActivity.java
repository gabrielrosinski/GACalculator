package com.gabriel.gacalculator.BirthdayAssignmnet;




import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.graphics.drawable.ColorDrawable;
import android.widget.DatePicker;
import android.widget.EditText;

import com.gabriel.gacalculator.BirthdayAssignmnet.Model.BirthdayUser;
import com.gabriel.gacalculator.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CreateUserActivity extends AppCompatActivity{

    private Button mDisplayDate;
    private Button saveUserButton;
    private long epochTime;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText nameEditText;
    private EditText commentEditText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);


        mDisplayDate = (Button) findViewById(R.id.dateSelectButton);
        saveUserButton = (Button) findViewById(R.id.saveBirthdayUser);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(CreateUserActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//                Log.d("Birth Date picker", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
                String date = day + "/" + (month + 1) + "/" + year;
                mDisplayDate.setText(date);

                Calendar cal = Calendar.getInstance();
                cal.set(year, month, day);
                epochTime = cal.getTimeInMillis();
                System.out.println("Altered year is: " + epochTimeToString(epochTime));
            }
        };


        saveUserButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                nameEditText = findViewById(R.id.nameEditText);
                commentEditText = findViewById(R.id.commentEditText);


                String name = nameEditText.getText().toString();
                String comment = commentEditText.getText().toString();

                if (!name.isEmpty() && !comment.isEmpty() && epochTime != 0) {

                    BirthdayDatabase db = Room.databaseBuilder(getApplicationContext(), BirthdayDatabase.class, "BirthdayDateDB")
                            .allowMainThreadQueries() //TODO: see if i can use the callback function here
                            .build();

                    db.userBirthdayDao().insertAll(new BirthdayUser(epochTime,name,comment));

                    startActivity(new Intent(CreateUserActivity.this, BirthdayListActivity.class));

                }
            }
        });
    }



    private String epochTimeToString(long epochTime){
        Date date = new Date(epochTime);
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }

}
