package com.snhu.inventorymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;





//created the database
public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);

    }

    @Override  //create the table
    public void onCreate(SQLiteDatabase myDb) {
        myDb.execSQL("create Table users(username Text Primary key, password Text)");

    }

    @Override  //when upgrading application when new database is created
    public void onUpgrade(SQLiteDatabase myDb, int i, int i1) {
        myDb.execSQL("drop Table if exists users");
    }


    public Boolean insertData(String username, String password) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDb.insert("users", null, contentValues);
        return result != -1;
    }

    public Boolean checkUserName(String username) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else
            cursor.close();
            return false;


    }

    public Boolean checkUserNamePassWord(String username, String password) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("Select * from password where password = ?", new String[]{username, password});
        cursor.close();
        return cursor.getCount() > 0;

    }
}

