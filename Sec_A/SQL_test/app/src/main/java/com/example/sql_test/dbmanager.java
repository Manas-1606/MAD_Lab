package com.example.sql_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbmanager extends SQLiteOpenHelper{
    private static final String dbname="dbseca1";

    public dbmanager(@Nullable Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String qry="create table tbl_contact ( id integer primary key autoincrement, name text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        String qry="DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public  String addrecord(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("name",name);
        //cv.put("contact",contact);
        //cv.put("email",email);
        float res=db.insert("tbl_contact",null,cv);

        if(res==-1)
            return "Failed";
        else
            return  "Successfully inserted";

    }

    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from tbl_contact order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }

    public String delete_entry(int ids)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        int myt = db.delete("tbl_contact", "id = '"+ ids + "'", null);

        return "Deleted!";
    }
}
