package com.example.wil.adamspersonaltrainerapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.MenuInflater;

import com.example.wil.adamspersonaltrainerapp.database.CustomerCursorWrapper;
import com.example.wil.adamspersonaltrainerapp.database.TrainerBaseHelper;
import com.example.wil.adamspersonaltrainerapp.database.TrainerDbSchema;
import com.example.wil.adamspersonaltrainerapp.database.TrainerDbSchema.CustomerTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FirstPage extends AppCompatActivity {
    private Button payment;
    private Button add_new;
    private Button schedule_new;
    private Button sessions;

    private static FirstPage sFirstPage;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static FirstPage get(Context context) {
        if (sFirstPage == null) {
            sFirstPage = new FirstPage(context);
        }

        return sFirstPage;

    }

    private FirstPage(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new TrainerBaseHelper(mContext).getWritableDatabase();
    }

    public void addCustomer(FirstPage c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CustomerTable.NAME, null, values);
    }

    public List<FirstPage> getCustomer() {
        List<FirstPage> customers = new ArrayList<>();
        CustomerCursorWrapper cursor = queryCustomer(null, null);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                customers.add(cursor.getCustomer());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return customers;
    }
    public FirstPage getCustomer(UUID id){


        CustomerCursorWrapper cursor = queryCustomer(
                CustomerTable.Cols.UUID + " + ?",
                new String[]{id.toString()}
                );
        try{
            if(cursor.getCount()==0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCustomer();
        } finally{
            cursor.close();
        }
    }
    public void updateCustomer(FirstPage customer){
        String uuidString = customer.getId().toString();
        ContentValues values = getContentValues(customer);
        mDatabase.update(CustomerTable.NAME, values, CustomerTable.Cols.UUID + " = ?", new String[] {uuidString});
    }

    private CustomerCursorWrapper queryCustomer(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                CustomerTable.NAME,
                null, whereClause, whereArgs, null, null, null);

        return new CustomerCursorWrapper(cursor);
    }
    private static ContentValues getContentValues(FirstPage customer){
        ContentValues values = new ContentValues();
        values.put(CustomerTable.Cols.UUID, customer.getId().toString() );
        values.put(CustomerTable.Cols.ADDRESS, customer.getAddress());
        values.put(CustomerTable.Cols.PAYMENT, customer.getPayment());
        return values;
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);



        Button button2 = (Button) findViewById(R.id.log_in);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FirstPage.this, add_new.class));
            }
        });

        Button schedule = (Button) findViewById(R.id.log_in);

        schedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FirstPage.this, Sessions.class));
            }
        });
    }



}
