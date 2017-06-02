package com.example.muneeb.mobomechanics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.id;

/**
 * Created by Muneeb on 3/21/2017.
 */

public class SymptomDbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "MoboMechanic.db";
    public static final String Mobo_TABLE_NAME = "Symptom";
    public static final String Symptom_COLUMN_NAME = "Name";

    private HashMap hp;

    public SymptomDbHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1="create table Symptom " +
                "(Name text primary key)";
        String sql2="create table Sound " +
                "(SymptomName text primary key)";
        String sql3="create table Smoke " +
                "(SmokeName text primary key)";
        String sql4="create table Smell " +
                "(SmellName text primary key)";
        String sql5="create table Behaviour " +
                "(BehaviourName text primary key)";

        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Symptom");
        onCreate(db);
    }

    public boolean insertSymptom (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        db.insert("Symptom", null, contentValues);
        return true;
    }

    public boolean insertSoundSymptom (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SymptomName", name);
        db.insert("Sound", null, contentValues);
        return true;
    }
    public boolean insertSmokeSymptom (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SmokeName", name);
        db.insert("Smoke", null, contentValues);
        return true;
    }    public boolean insertSmellSymptom (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SmellName", name);
        db.insert("Smell", null, contentValues);
        return true;
    }
    public boolean insertBehaviourSymptom (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("BehaviourName", name);
        db.insert("Behaviour", null, contentValues);
        return true;
    }
    public Cursor getSymptom(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Symptom where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, Mobo_TABLE_NAME);
        return numRows;
    }

    public boolean updateSymptom (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        db.update("Symptom", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteSymptom (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Symptom",
                "Name = ? ",
                new String[] { name });
    }
    public ArrayList<String> getAllSymptom() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Symptom", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(Symptom_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllSoundSymptom() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Sound", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("Sound")));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllSmokeSymptom() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Smoke", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("SmokeName")));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllSmellSymptom() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Smell", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("SmellName")));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllBehaviourSymptom() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Behaviour", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("BehaviourName")));
            res.moveToNext();
        }
        return array_list;
    }
}
