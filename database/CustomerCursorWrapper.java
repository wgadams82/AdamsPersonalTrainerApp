package com.example.wil.adamspersonaltrainerapp.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.wil.adamspersonaltrainerapp.Customer;
import com.example.wil.adamspersonaltrainerapp.database.TrainerDbSchema.CustomerTable;

import java.util.UUID;

public class CustomerCursorWrapper extends CursorWrapper{
    public CustomerCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Customer getCustomer(){
        String uuidString = getString(getColumnIndex(CustomerTable.Cols.UUID));
        String address = getString(getColumnIndex(CustomerTable.Cols.ADDRESS));
        String payment = getString(getColumnIndex(CustomerTable.Cols.PAYMENT));

        Customer customer = new Customer(UUID.fromString(uuidString));
        customer.setAddress(address);
        customer.setPayment(payment);

        return customer;




    }

}
