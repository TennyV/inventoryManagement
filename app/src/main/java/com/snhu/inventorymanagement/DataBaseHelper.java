package com.snhu.inventorymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DataBaseHelper extends SQLiteOpenHelper {


    // to make my use of the table easier
    public static final String INVENTORY_TABLE = "INVENTORY_TABLE";
    public static final String INVENTORY_ITEM = "INVENTORY_ITEM";
    public static final String INVENTORY_QTY = "INVENTORY_QTY";
    public static final String COLUMN_ID = "COLUMN_ID";

    public DataBaseHelper(Context context) {
        super(context, "data.db", null, 1);
    }

    //called the first time a DB is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + INVENTORY_TABLE + " " +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INVENTORY_ITEM + " TEXT, " + INVENTORY_QTY + " INT )";

        db.execSQL(createTableStatement);

    }

    // called for backwards compatibility
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(ItemAttributes itemAtttributes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(INVENTORY_ITEM, itemAtttributes.getName());
        cv.put(INVENTORY_QTY, itemAtttributes.getQuantity());

        long insert = db.insert(INVENTORY_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }

         }
}
