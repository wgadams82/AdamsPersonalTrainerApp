package com.example.wil.adamspersonaltrainerapp;
import java.util.UUID;

public class Customer {
   private UUID mId;
   private String mAddress;
   private String mPayment;

   public Customer(){
       mId = UUID.randomUUID();
   }
   public UUID getId(){
       return mId;
   }

   public String getAddress(){
       return mAddress;
   }
   public String getPayment() {
       return mPayment;
   }
        }

