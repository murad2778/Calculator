package com.example.mynavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Converter extends AppCompatActivity {

    TextView result,hint,hint2;
    EditText number1;
    Button cmtoinch,fahtocel,doltotk;


    double result_num;
    double num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        result = (TextView) findViewById(R.id.result);
        hint= (TextView) findViewById(R.id.hint);
        hint2 =(TextView) findViewById(R.id.hint2);

        number1 = (EditText) findViewById(R.id.number1);

        cmtoinch = (Button) findViewById(R.id.cmtoinch);
        fahtocel = (Button) findViewById(R.id.fahtocel);
        doltotk = (Button) findViewById(R.id.doltotk);

        cmtoinch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(Converter.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText(num1+" cm =");
                hint2.setText("inch");

                result_num = 0.394*num1;
                result.setText(String.valueOf(result_num));

            }


        });

        fahtocel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(Converter.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText(num1+" Fahrenheit =");
                hint2.setText("Celsius");

                result_num = (num1-32)*5/9;
                result.setText(String.valueOf(result_num));

            }


        });
        doltotk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(Converter.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText(num1+" US dollar =");
                hint2.setText("taka");

                result_num =num1*84.50;
                result.setText(String.valueOf(result_num));

            }


        });
    }
}
