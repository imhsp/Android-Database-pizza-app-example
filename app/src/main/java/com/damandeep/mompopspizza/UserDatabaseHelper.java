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


public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "UserDatabaseHelper"; //This is database helper

    public static final String TABLE_NAME = "user_table"; //defining table name
    public static final String COL0 = "ID"; // column for ID
    public static final String COL1 = "user_name"; // cloumn for  Student Name
    public static final String COL2 = "user_email"; //Column for Student ID
    public static final String COL3 = "user_password"; //Column for Student ID

    public UserDatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    //table creation
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL1 + " TEXT," + COL2 + " TEXT UNIQUE, " + COL3 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //this method sed to add name to database
    public boolean addData(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, name);
        contentValues.put(COL2, email);
        contentValues.put(COL3, password);

        Log.d(TAG, "addData: Adding " + name + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data was inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
   /* //here student id is added
    public boolean addData2(String item2 ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, item2);

        Log.d(TAG, "addData: Adding " + item2 + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data was inserted incorrectly it will return -1
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }*/

    //this method is used to select data from the table
    public int getUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL2 + " = '" + email + "' AND " + COL3 + " = '" + password +"'";
        Log.d(TAG, "Query:"+query);
        Cursor data = db.rawQuery(query, null);
        if (data.getCount() == 1) {
            data.moveToFirst();

            return data.getInt(data.getColumnIndex(COL0));
        } else {
            return -1;
        }

    }

   /* //Returns the ID that matches the name passed in
    public Cursor getItemID(String name ){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL0 + " FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
     //This method is used to update Student Name
    public void updateName(String newName, int id, String oldName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL1 + " = '" + newName + "' WHERE " + COL0 + " = '" + id + "'" + " AND " + COL1 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);

    }
     //This method is used to update student ID
    public void updateHansonId(String newHansonId, int id , String oldHansonId){
        SQLiteDatabase db = this.getWritableDatabase();
        String query2 = "UPDATE " + TABLE_NAME + " SET " + COL2 + " = '" + newHansonId + "' WHERE " + COL0 + " = '" + id + "'" + " AND " + COL2 + " = '" + oldHansonId + "'";
        Log.d(TAG, "updateHansonId: query2: " + query2);
        Log.d(TAG, "updateHansonId: Setting HansonId to " + newHansonId);
        db.execSQL(query2);

    }
  //Here student name is deleted from the database

    public void deleteName(int id, String name ) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL0 + " = '" + id + "'" + " AND " + COL1 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);

    }
    //Here student ID is deleted from the database

    public void deleteNumber(int id , String hansonid){
        SQLiteDatabase db = this.getWritableDatabase();

        String query2 = "DELETE FROM " + TABLE_NAME + " WHERE " + COL0 + " = '" + id + "'" + " AND " + COL2 + " = '" + hansonid + "'";
        Log.d(TAG, "deleteHansonId: query2: " + query2);
        Log.d(TAG, "deleteHansonId: Deleting " + hansonid + " from database.");
        db.execSQL(query2);
    }*/


}


