package com.example.mynavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StandardActivity extends AppCompatActivity {

    TextView result,hint;
    EditText number1, number2;
    Button add, subtract, multiply, divide;

    double result_num;
    double num1, num2;

    DatabaseReference std;
    standatabase standatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        result = (TextView) findViewById(R.id.result);
        hint = (TextView) findViewById(R.id.hint);


        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        std=FirebaseDatabase.getInstance().getReference().child("standatabase");
        standatabase=new standatabase();




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(StandardActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(number2.length()==0){
                    Toast.makeText(StandardActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                num2 = Float.parseFloat(number2.getText().toString());
                hint.setText(num1+"+"+num2+"=");
                result_num = num1+num2;
                result.setText(String.valueOf(result_num));

                standatabase.setValue(num1+"+"+num2+"="+result_num);
                std.push().setValue(standatabase);

            }


        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(StandardActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(number2.length()==0){
                    Toast.makeText(StandardActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                num2 = Float.parseFloat(number2.getText().toString());
                hint.setText(num1+"-"+num2+"=");
                result_num = num1-num2;
                result.setText(String.valueOf(result_num));

                standatabase.setValue(num1+"-"+num2+"="+result_num);
                std.push().setValue(standatabase);

            }


        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(StandardActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(number2.length()==0){
                    Toast.makeText(StandardActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                num2 = Float.parseFloat(number2.getText().toString());
                hint.setText(num1+"*"+num2+"=");
                result_num = num1*num2;
                result.setText(String.valueOf(result_num));

                standatabase.setValue(num1+"*"+num2+"="+result_num);
                std.push().setValue(standatabase);

            }


        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(StandardActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(number2.length()==0){
                    Toast.makeText(StandardActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                num2 = Float.parseFloat(number2.getText().toString());
                hint.setText(num1+"/"+num2+"=");
                result_num = num1/num2;
                result.setText(String.valueOf(result_num));

                standatabase.setValue(num1+"/"+num2+"="+result_num);
                std.push().setValue(standatabase);

            }


        });
    }

}


