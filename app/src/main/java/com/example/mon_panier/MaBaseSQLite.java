package com.example.mon_panier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MaBaseSQLite extends SQLiteOpenHelper {

    private final static String CREATE_TABLE_ARTICLE = "CREATE TABLE IF NOT EXISTS articles (" +
            "id integer PRIMARY KEY AUTOINCREMENT," +
            "nom VARCHAR(50) not null," +
            "quantite int not null," +
            "categorie VARCHAR(50)," +
            "description VARCHAR(250) not null" +
            ");";

    public MaBaseSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ARTICLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
