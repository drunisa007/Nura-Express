package com.kk.as.nura.negavitionbyarun.activity.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kk.as.nura.negavitionbyarun.activity.model.Gates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chan Myae Thu on 8/2/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DBName = "nura_bus_ticket.sqlite";
    public static final String DBLocatoin = "/data/data/com.kk.as.nura.negavitionbyarun/databases/";
    public static final String TableGates = "gates";
    public static final String TableCities = "cities";
    private Context mContext;
    private SQLiteDatabase Database;

    public DatabaseHelper(Context context) {
        super(context, DBName, null, 1);
        this.mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBName).getPath();

        if (Database != null && Database.isOpen()) {
            return;
        }
        Database = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase() {
        if (Database != null) {
            Database.close();
        }
    }
    public List<Gates> getAllGates() {
        Gates gate = null;
        List<Gates> gateList = new ArrayList<>();
        openDatabase();
        Cursor cursor = Database.rawQuery("SELECT * FROM " +TableGates, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            gate = new Gates(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            gateList.add(gate);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return gateList;
    }

    public Gates getGateById(int id) {
        Gates gate = null;
        openDatabase();
        Cursor cursor = Database.rawQuery("SELECT * FROM " + TableGates + " WHERE _ID = ? ", new String[]{String.valueOf(id)});
        cursor.moveToFirst();
        gate = new Gates(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        cursor.close();
        closeDatabase();
        return gate;
    }

    public Gates getGateByName(String name) {
        Gates gate = null;
        openDatabase();
        Cursor cursor = Database.rawQuery("SELECT * FROM " + TableGates + " WHERE name = ? ", new String[]{name});
        cursor.moveToFirst();
        gate = new Gates(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        cursor.close();
        closeDatabase();
        return gate;
    }
    public List<String> getAllCities() {
        List<String> cityList = new ArrayList<>();
        openDatabase();
        Cursor cursor = Database.rawQuery("SELECT * FROM " + TableCities, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            cityList.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return cityList;
    }
    public List<String> getAllGateName() {
        String name = null;
        List<String> nameList = new ArrayList<>();
        openDatabase();
        Cursor cursor = Database.rawQuery("SELECT name FROM " + TableGates, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            name = cursor.getString(0);
            nameList.add(name);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return nameList;
    }
    public List<String> getAllRoute() {
        String route = null;
        List<String> routeList = new ArrayList<>();
        openDatabase();
        Cursor cursor = Database.rawQuery("SELECT routes FROM " + TableGates, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            route = cursor.getString(0);
            routeList.add(route);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return routeList;
    }


}
