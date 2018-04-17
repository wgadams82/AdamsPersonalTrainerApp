package com.example.wil.adamspersonaltrainerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class payment extends AppCompatActivity {
    private Button mPrint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        Button print = (Button) findViewById(R.id.print);

       print.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
               Toast.makeText(payment.this, R.string.print_toast, Toast.LENGTH_SHORT).show();

           }
       });

        Button email = (Button) findViewById(R.id.email);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(payment.this, R.string.email_toast, Toast.LENGTH_SHORT).show();

            }
        });
    }

}
