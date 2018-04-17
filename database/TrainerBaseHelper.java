package com.example.wil.adamspersonaltrainerapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wil.adamspersonaltrainerapp.database.TrainerDbSchema.CustomerTable;

public class TrainerBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "customerBase.db";

    public TrainerBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CustomerTable.NAME + "(" + " _id integer primary key autoincrement, "
                + CustomerTable.Cols.UUID + ", " +
                CustomerTable.Cols.ADDRESS + ", " +
                CustomerTable.Cols.PAYMENT + ")"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
