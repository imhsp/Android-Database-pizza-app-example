/*
This program was created by Damandeep Singh Gill, H00017929
 */


package com.damandeep.mompopspizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class OrderDatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "OrderDatabaseHelper"; //This is database helper

    public static final String TABLE_NAME = "order_table"; //defining table name

    public static final String COL0 = "order_ID"; // column for ID
    public static final String COL1 = "user_ID"; // cloumn for  Student Name

    public static final String COL2 = "pizza_order"; //Column for Student ID
    public static final String COL3 = "pizza_topping1"; //Column for Student ID
    public static final String COL4 = "pizza_topping2"; //Column for Student ID
    public static final String COL5 = "pizza_topping3"; //Column for Student ID
    public static final String COL6 = "pizza_size"; //Column for Student ID
    public static final String COL7 = "pizza_qty"; //Column for Student ID
    public static final String COL8 = "pizza_price"; //Column for Student ID

    public static final String COL9 = "calzones_order"; //Column for Student ID
    public static final String COL10 = "calzones_topping1"; //Column for Student ID
    public static final String COL11 = "calzones_topping2"; //Column for Student ID
    public static final String COL12 = "calzones_topping3"; //Column for Student ID
    public static final String COL13 = "calzones_size"; //Column for Student ID
    public static final String COL14 = "calzones_qty"; //Column for Student ID
    public static final String COL15 = "calzones_price"; //Column for Student ID

    public static final String COL16 = "pasta_order"; //Column for Student ID
    public static final String COL17 = "pasta_topping1"; //Column for Student ID
    public static final String COL18 = "pasta_topping2"; //Column for Student ID
    public static final String COL19 = "pasta_topping3"; //Column for Student ID
    public static final String COL20 = "pasta_qty"; //Column for Student ID
    public static final String COL21 = "pasta_price"; //Column for Student ID

    public static final String COL22 = "wings_order"; //Column for Student ID
    public static final String COL23 = "wings_sauces1"; //Column for Student ID
    public static final String COL24 = "wings_sauces2"; //Column for Student ID
    public static final String COL25 = "wings_sauces3"; //Column for Student ID
    public static final String COL26 = "wings_qty"; //Column for Student ID
    public static final String COL27 = "wings_price"; //Column for Student ID

    public static final String COL28 = "fries_order"; //Column for Student ID
    public static final String COL29 = "fries_size"; //Column for Student ID
    public static final String COL30 = "fries_qty"; //Column for Student ID
    public static final String COL31 = "fries_price"; //Column for Student ID

    public static final String COL32 = "soda_order"; //Column for Student ID
    public static final String COL33 = "soda_typ"; //Column for Student ID
    public static final String COL34 = "soda_qty"; //Column for Student ID
    public static final String COL35 = "soda_price"; //Column for Student ID

    public static final String COL36 = "total_price"; //Column for Student ID


    public OrderDatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    //table creation
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL1 + " INTEGER, " + COL2 + " INTEGER DEFAULT 0 ," + COL3 + " TEXT," + COL4 + " TEXT, " + COL5 + " TEXT, " + COL6 + " TEXT, " + COL7 + " TEXT," + COL8 + " TEXT," +
                COL9 + " INTEGER DEFAULT 0 ," + COL10 + " TEXT," + COL11 + " TEXT, " + COL12 + " TEXT, " + COL13 + " TEXT, " + COL14 + " TEXT," + COL15 + " TEXT," +
                COL16 + " INTEGER DEFAULT 0 ," + COL17 + " TEXT," + COL18 + " TEXT, " + COL19 + " TEXT, " + COL20 + " TEXT, " + COL21 + " TEXT," +
                COL22 + " INTEGER DEFAULT 0 ," + COL23 + " TEXT," + COL24 + " TEXT, " + COL25 + " TEXT, " + COL26 + " TEXT, " + COL27 + " TEXT," +
                COL28 + " INTEGER DEFAULT 0 ," + COL29 + " TEXT," + COL30 + " TEXT, " + COL31 + " TEXT," +
                COL32 + " INTEGER DEFAULT 0 ," + COL33 + " TEXT," + COL34 + " TEXT, " + COL35 + " TEXT," +
                COL36 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //this method sed to add name to database
    public boolean addOrder(int userID,
                            int pizzaOrder, String pizzaTopping1, String pizzaTopping2, String pizzaTopping3,
                            String pizzaSize, String pizzaQty, String pizzaPrice,
                            int calzonesOrder, String calzonesTopping1, String calzonesTopping2, String calzonesTopping3,
                            String calzonesSize, String calzonesQty, String calzonesPrice,
                            int pastaOrder, String pastaTopping1, String pastaTopping2, String pastaTopping3,
                            String pastaQty, String pastaPrice,
                            int wingsOrder, String wingsTopping1, String wingsTopping2, String wingsTopping3,
                            String wingsQty, String wingsPrice,
                            int friesOrder, String friesSize, String friesQty, String friesPrice,
                            int sodaOrder, String sodaTyp, String sodaQty, String sodaPrice,
                            String orderTotal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, userID);

        contentValues.put(COL2, pizzaOrder);

        if(pizzaOrder != 0){
            contentValues.put(COL3, pizzaTopping1);
            contentValues.put(COL4, pizzaTopping2);
            contentValues.put(COL5, pizzaTopping3);
            contentValues.put(COL6, pizzaSize);
            contentValues.put(COL7, pizzaQty);
            contentValues.put(COL8, pizzaPrice);
        }

        contentValues.put(COL9, calzonesOrder);

        if(calzonesOrder != 0){
            contentValues.put(COL10, calzonesTopping1);
            contentValues.put(COL11, calzonesTopping2);
            contentValues.put(COL12, calzonesTopping3);
            contentValues.put(COL13, calzonesSize);
            contentValues.put(COL14, calzonesQty);
            contentValues.put(COL15, calzonesPrice);
        }

        contentValues.put(COL16, pastaOrder);

        if(pastaOrder != 0){
            contentValues.put(COL17, pastaTopping1);
            contentValues.put(COL18, pastaTopping2);
            contentValues.put(COL19, pastaTopping3);
            contentValues.put(COL20, pastaQty);
            contentValues.put(COL21, pastaPrice);
        }

        contentValues.put(COL22, wingsOrder);

        if(wingsOrder != 0){
            contentValues.put(COL23, wingsTopping1);
            contentValues.put(COL24, wingsTopping2);
            contentValues.put(COL25, wingsTopping3);
            contentValues.put(COL26, wingsQty);
            contentValues.put(COL27, wingsPrice);
        }

        contentValues.put(COL28, friesOrder);

        if(friesOrder != 0){
            contentValues.put(COL29, friesSize);
            contentValues.put(COL30, friesQty);
            contentValues.put(COL31, friesPrice);
        }

        contentValues.put(COL32, sodaOrder);

        if(sodaOrder != 0){
            contentValues.put(COL33, sodaTyp);
            contentValues.put(COL34, sodaQty);
            contentValues.put(COL35, sodaPrice);
        }

        contentValues.put(COL36, orderTotal);

        //Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data was inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //this method is used to select data from the table
    public Cursor getData(int UserID) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME +" WHERE " + COL1 + " = '" + UserID +"'";
        Cursor data = db.rawQuery(query, null);


        return data;
    }


}


