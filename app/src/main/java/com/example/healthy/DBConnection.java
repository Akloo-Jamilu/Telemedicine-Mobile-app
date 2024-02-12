package com.example.healthy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnection extends SQLiteOpenHelper {

    public DBConnection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table users(username text, email text, password text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username, String email, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("emil", email);
        contentValues.put("password", password);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("users", null, contentValues);
        sqLiteDatabase.close();
    }

    public int login(String username, String password){
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username=? and password=?", str);
        if (cursor.moveToFirst()){
            result = 1;
        }
        return result;
    }
}
