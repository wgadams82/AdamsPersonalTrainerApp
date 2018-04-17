package com.example.wil.adamspersonaltrainerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class log_in extends AppCompatActivity {

    private Button mLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mLogIn = (Button) findViewById(R.id.log_in);
        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(log_in.this, R.string.login_good_toast, Toast.LENGTH_SHORT).show();

            }
        });

        Button mLogIn = (Button) findViewById(R.id.log_in);

        mLogIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(log_in.this, FirstPage.class));
            }
        });

    }}
