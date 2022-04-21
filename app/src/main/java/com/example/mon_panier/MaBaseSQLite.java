package com.example.mon_panier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MaBaseSQLite extends SQLiteOpenHelper {

    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS articles (" +
            "id int PRIMARY KEY," +
            "nom VARCHAR(50) not null," +
            "quantite int not null" +
            ");";

    public MaBaseSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}