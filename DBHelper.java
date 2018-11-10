package com.example.sois.befit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by SOIS on 11/4/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String dbname = "healthacare.db";
    public static final String tname = "login";
    public static final String tname1 = "details";
    public static final String cname = "Name";
    public static final String cid = "email";
    public static final String cpwd = "password";
    public static final String Cname = "name";
    public static final String cgender = "gender";
    public static final String cheight = "height";
    public static final String cweight = "weight";
    public static final String cage = "age";
    public static final String cbloodgroup = "bloodgroup";

    SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, dbname, null, 1);
        db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table login (Name text ,email text primary key, password text)");
        db.execSQL("create table details (name text,gender text ,height integer, weight integer ,age integer, bloodgroup text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table IF EXISTS login");
        db.execSQL("Drop table IF EXISTS details");
        onCreate(db);
    }

    public boolean insertData(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(cname, name);
        val.put(cid, email);
        val.put(cpwd, password);
        db.insert(tname, null, val);
        db.close();
        return true;

    }

    public boolean insertData1(String name, String gender, String height, String weight, String age, String bloodgroup) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(Cname, name);
        val.put(cgender, gender);
        val.put(cheight, height);
        val.put(cweight, weight);
        val.put(cage, age);
        val.put(cbloodgroup, bloodgroup);
        db.insert(tname1, null, val);
        db.close();
        return true;

    }

    public boolean validate(String email, String password) {
        Log.v("validate", email);
        Log.v("validate", password);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from login where email=? and password=?", new String[]{email, password});
        if (cs.getCount() > 0)
            return true;
        else
            return false;

    }

    public String fetchByID(String name) {
        String sql = "SELECT " + cgender + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("gender"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }

    public String fetchByID1(String name) {
        String sql = "SELECT " + cheight + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Height = cursor.getString(cursor.getColumnIndex("height"));
            cursor.close();
            return Height;
        } else {
            cursor.close();
            return null;
        }

    }

    public String fetchByID2(String name) {
        String sql = "SELECT " + cweight + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Weight = cursor.getString(cursor.getColumnIndex("weight"));
            cursor.close();
            return Weight;
        } else {
            cursor.close();
            return null;
        }

    }

    public String fetchByID3(String name) {
        String sql = "SELECT " + cage + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Age = cursor.getString(cursor.getColumnIndex("age"));
            cursor.close();
            return Age;
        } else {
            cursor.close();
            return null;
        }

    }

    public String fetchByID4(String name) {
        String sql = "SELECT " + cbloodgroup + " FROM " + tname1 + " WHERE " + Cname + "='" + name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Bloodgroup = cursor.getString(cursor.getColumnIndex("bloodgroup"));
            cursor.close();
            return Bloodgroup;
        } else {
            cursor.close();
            return null;
        }

    }
}


