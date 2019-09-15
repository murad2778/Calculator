package com.example.mynavigation;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScientificActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    TextView result,hint;
    EditText number1;
    Button sin,cos,tan, sqr;

    double result_num;
    double num1;
    DatabaseReference ref;
    Scidatabase scidatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);

        result = (TextView) findViewById(R.id.result);
        hint= (TextView) findViewById(R.id.hint);

        number1 = (EditText) findViewById(R.id.number1);

        sin= (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        sqr = (Button) findViewById(R.id.sqr);
        ref= FirebaseDatabase.getInstance().getReference().child("Scidatabase");
        scidatabase=new Scidatabase();

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(ScientificActivity.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText("sin"+num1);

                num1=Math.toRadians(num1);
                result_num = Math.sin(num1);
                result.setText(String.valueOf(result_num));
                scidatabase.setDb("sin "+Math.toRadians(num1)+"="+result_num);
                ref.push().setValue(scidatabase);

            }


        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(ScientificActivity.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText("cos"+num1);
                num1=Math.toRadians(num1);
                result_num =Math.cos(num1);

                result.setText(String.valueOf(result_num));
                scidatabase.setDb("cos "+Math.toRadians(num1)+"="+result_num);
                ref.push().setValue(scidatabase);

            }


        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(ScientificActivity.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText("tan"+num1);
                num1=Math.toRadians(num1);
                result_num =Math.tan(num1);
                result.setText(String.valueOf(result_num));
                scidatabase.setDb("tan "+Math.toRadians(num1)+"="+result_num);
                ref.push().setValue(scidatabase);


            }


        });

        sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(ScientificActivity.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText("log "+num1);
                result_num = Math.log(num1);
                result.setText(String.valueOf(result_num));
                scidatabase.setDb("log"+num1+"="+result_num);
                ref.push().setValue(scidatabase);

            }


        });
    }


}




