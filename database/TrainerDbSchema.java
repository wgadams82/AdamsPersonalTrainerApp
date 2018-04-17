package com.example.wil.adamspersonaltrainerapp.database;

public class TrainerDbSchema {
    public static final class CustomerTable{
        public static final String NAME = "customers";

        public static final class Cols {
            public static final String UUID = "id";
            public static final String ADDRESS = "address";
            public static final String PAYMENT = "payment";
        }
    }
}
