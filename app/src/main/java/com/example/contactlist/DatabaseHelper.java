package com.example.contactlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private Context context ;
    public static final String DATABASE_NAME = "mydb.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "my_contacts";
    public static final String Col_id = "_id" ;
    public static final String Col_name = "name" ;
    public static final String Col_num = "num" ;






    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context ;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +
                " ( " + Col_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Col_name + " TEXT,  "+
                Col_num + " INTEGER ); " ;
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME );
        onCreate(db);
    }


    void addContact(String name , int num){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Col_name, name);
        cv.put(Col_num, num);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteContact(int num){

        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(TABLE_NAME,  Col_id +" = " + num, null);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "deleted Successfully!", Toast.LENGTH_SHORT).show();
        }

    }




    void updateData(String position, String name, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Col_name, name);
        cv.put(Col_num, phone);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{position});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }


    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }





}
