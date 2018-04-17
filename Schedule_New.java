package com.example.wil.adamspersonaltrainerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Schedule_New extends AppCompatActivity {
    private Button payment;
    private Button add_new;
    private Button schedule_new;
    private Button sessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule__new);


        Button back_schedule = (Button) findViewById(R.id.back_schedule);

       back_schedule.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v){
               startActivity(new Intent(Schedule_New.this, Sessions.class));
           }
        });
    }
}
