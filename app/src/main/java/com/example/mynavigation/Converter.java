package com.example.mynavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Converter extends AppCompatActivity {

    TextView result,hint,hint2;
    EditText number1;
    Button cmtoinch;

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

        cmtoinch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num1 = Integer.parseInt(number1.getText().toString());
                hint.setText(num1+"cm =");
                hint2.setText("inch");

                result_num = 0.394*num1;
                result.setText(String.valueOf(result_num));

            }


        });
    }
}
