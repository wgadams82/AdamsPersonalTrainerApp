package com.example.wil.adamspersonaltrainerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sessions extends AppCompatActivity {
    private Button payment;
    private Button add_new;
    private Button schedule_new;
    private Button sessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);


        Button new_session = (Button) findViewById(R.id.new_session);

        new_session.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Sessions.this, Schedule_New.class));
            }
        });
    }
}
