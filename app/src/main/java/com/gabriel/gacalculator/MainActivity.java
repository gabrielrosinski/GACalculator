package com.gabriel.gacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private String operation = "";
    private String num1 = "";
    private String num2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void btnClicked(View view){

        TextView textView = (TextView) findViewById(R.id.textView);


        switch (view.getId()) {
            case R.id.btn0:
                addDigitToTextField("0");
                break;
            case R.id.btn1:
                addDigitToTextField("1");
                break;
            case R.id.btn2:
                addDigitToTextField("2");
                break;
            case R.id.btn3:
                addDigitToTextField("3");
                break;
            case R.id.btn4:
                addDigitToTextField("4");
                break;
            case R.id.btn5:
                addDigitToTextField("5");
                break;
            case R.id.btn6:
                addDigitToTextField("6");
                break;
            case R.id.btn7:
                addDigitToTextField("7");
                break;
            case R.id.btn8:
                addDigitToTextField("8");
                break;
            case R.id.btn9:
                addDigitToTextField("9");
                break;
            case R.id.btnPlus:
                operation = "+";
                break;
            case R.id.btnMinus:
                operation = "-";
                break;
            case R.id.btnMult:
                operation = "*";
                break;
            case R.id.btnDivide:
                operation = "/";
                break;
            case R.id.btnEqual:


                Double tempNum;

                if (num1 != null && num2 != null && operation != null ) {
                    if (operation == "+") {
                        tempNum = (Double.parseDouble(num1) + Double.parseDouble(num2));
                        textView.setText(tempNum.toString());

                    } else if (operation == "-") {
                        tempNum = (Double.parseDouble(num1) - Double.parseDouble(num2));
                        textView.setText(tempNum.toString());

                    } else if(operation == "*") {
                        tempNum = (Double.parseDouble(num1) * Double.parseDouble(num2));
                        textView.setText(tempNum.toString());

                    }else if(operation == "/"){
                        tempNum = (Double.parseDouble(num1) / Double.parseDouble(num2));
                        textView.setText(tempNum.toString());
                    }
                }

                break;

            case R.id.btnClear:

                textView.setText("");

                num1 = "";
                num2 = "";
                operation = "";

                break;
        }

    }


//    public void textViewClicked(View view){
////        Toast.makeText(getApplicationContext(), "Some massage", Toast.LENGTH_LONG).show();
//
//        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        textView.setText("");
//    }

    private void addDigitToTextField(String digit)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        String text = textView.getText().toString();

        if (operation == ""){
            if (num1 == "" && digit == "0"){}
            else{
                text += digit;
                num1 += digit;
                textView.setText(num1);
            }
        }else{
            if (num2 == "" && digit == "0"){}
            else{
                text += digit;
                num2 += digit;
                textView.setText(num2);
            }
        }
    }
}
