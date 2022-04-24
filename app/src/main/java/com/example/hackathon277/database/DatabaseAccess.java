package com.example.hackathon277.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    public static final String GDP_GROWTH_TABLE = "gdp_growth";
    public static final String COLUMN_YEAR ="year";
    public static final String COLUMN_INDIA = "growth_annual_india";
    public static final String COLUMN_CHINA = "growth_annual_china";
    public static final String COLUMN_US = "growth_annual_usa";


    public static final String GDP_USD_TABLE = "gdp_current_usd";

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }


    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }



    public List<String> getGDPGrowthYear() {
        List<String> list = new ArrayList<>();

        String [] tableColumns = {COLUMN_YEAR};

        Cursor cursor = database.query(false, GDP_GROWTH_TABLE,tableColumns,null,null,null,null,null,null);
        //Cursor cursor = database.rawQuery("SELECT year FROM gdp_growth", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }


        cursor.close();
        return list;
       
    }


    public List<String> getGDPUS() {
        List<String> growthUSList = new ArrayList<>();


        String [] tableColumns = {COLUMN_US};

        Cursor cursor = database.query(false, GDP_GROWTH_TABLE,tableColumns,null,null,null,null,null,null);
        //Cursor cursor = database.rawQuery("SELECT year FROM gdp_growth", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            growthUSList.add(cursor.getString(0));
            cursor.moveToNext();
        }


        cursor.close();
        return growthUSList;

    }

    public List<String> getGDPIndia() {
        List<String> growthIndiaList = new ArrayList<>();


        String [] tableColumns = {COLUMN_INDIA};

        Cursor cursor = database.query(false, GDP_GROWTH_TABLE,tableColumns,null,null,null,null,null,null);
        //Cursor cursor = database.rawQuery("SELECT year FROM gdp_growth", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            growthIndiaList.add(cursor.getString(0));
            cursor.moveToNext();
        }


        cursor.close();
        return growthIndiaList;

    }

    public List<String> getGDPChina() {
        List<String> growthChinaList = new ArrayList<>();


        String [] tableColumns = {COLUMN_CHINA};

        Cursor cursor = database.query(false, GDP_GROWTH_TABLE,tableColumns,null,null,null,null,null,null);
        //Cursor cursor = database.rawQuery("SELECT year FROM gdp_growth", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            growthChinaList.add(cursor.getString(0));
            cursor.moveToNext();
        }


        cursor.close();
        return growthChinaList;

    }



}
