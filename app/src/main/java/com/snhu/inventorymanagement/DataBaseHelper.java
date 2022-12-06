package com.snhu.inventorymanagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DataBaseHelper extends SQLiteOpenHelper {


    // to make my use of the table easier
    public static final String INVENTORY_TABLE = "INVENTORY_TABLE";
    public static final String INVENTORY_ITEM = "INVENTORY_ITEM";
    public static final String INVENTORY_QTY = "INVENTORY_QTY";
    public static final String COLUMN_ID = "COLUMN_ID";

    // constructor for new class
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
    db.execSQL("drop TABLE if exists INVENTORY_TABLE");
    }

    public boolean addOne(ItemAttributes itemAtttributes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(INVENTORY_ITEM, itemAtttributes.getName());
        cv.put(INVENTORY_QTY, itemAtttributes.getQuantity());

        long insert = db.insert(INVENTORY_TABLE, null, cv);
        return insert != -1;

         }

         // pull everything out of my DB
         public List<ItemAttributes> getEverything() {

        List<ItemAttributes> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + INVENTORY_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

             Cursor cursor = db.rawQuery(queryString, null);

             if (cursor.moveToFirst()) {
                 // loop through the cursor
                 do {
                     int inventoryID = cursor.getInt(0);
                     String itemName = cursor.getString(1);
                     int itemQuantity = cursor.getInt(2);

                     ItemAttributes newInventory = new ItemAttributes(inventoryID,itemName,itemQuantity);
                     returnList.add(newInventory);
                 }
                     while (cursor.moveToNext());

             }
             else {
                 //failure do not add anyhitng
             }

             cursor.close();
             db.close();

             return returnList;
         }
         public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from INVENTORY_TABLE", null);
        return cursor;
         }
}
