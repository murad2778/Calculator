package com.example.mynavigation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    private Button button1,button2,button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerid);
        NavigationView navigationView = findViewById(R.id.navid);
        navigationView.setNavigationItemSelectedListener(this);


        toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3=  (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StandardActivity.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ScientificActivity.class);
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Converter.class);
                startActivity(intent);

            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        if(menuItem.getItemId()== R.id.standardid){
            Intent intent = new Intent(MainActivity.this,StandardActivity.class);
            startActivity(intent);
        }
        else if(menuItem.getItemId()== R.id.scientificid){
            Intent intent = new Intent(MainActivity.this,ScientificActivity.class);
            startActivity(intent);
        }
        else if(menuItem.getItemId()== R.id.homeid){
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else if(menuItem.getItemId()== R.id.converterid){
            Intent intent = new Intent(MainActivity.this,Converter.class);
            startActivity(intent);
        }


        return false;
    }






}
