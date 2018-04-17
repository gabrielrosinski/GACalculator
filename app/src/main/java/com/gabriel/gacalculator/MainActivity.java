package com.gabriel.gacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EditText editText = (EditText) findViewById(R.id.calcEditText);
//        editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if ( (actionId == EditorInfo.IME_ACTION_DONE) || ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_DOWN ))) {
//
//                    // Do stuff when user presses enter
//
//                    return true;
//
//                }
//
//                return false;
//            }
//        });

    }


    public void btnClicked(View view){

    }


    public void textFiledClicked(View view){
        Toast.makeText(getApplicationContext(), "Some massage", Toast.LENGTH_LONG).show();

        EditText editText = (EditText) findViewById(R.id.calcEditText);
        editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        editText.setText("");
    }
}
