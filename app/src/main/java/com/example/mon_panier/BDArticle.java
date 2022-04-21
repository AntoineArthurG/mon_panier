package com.example.mon_panier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BDArticle {

    private final static String SELECT_ALL = "SELECT * FROM articles;";

    private SQLiteDatabase bdd ;
    private MaBaseSQLite maBaseSQLite;

    public BDArticle (Context context) {
        maBaseSQLite = new MaBaseSQLite(context, "articles", null, 1);
    }

    public void open () {
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getBdd(){
        return bdd;
    }

    public long insertArticle(Article article){
        ContentValues values = new ContentValues();
        values.put("nom", article.getNom());
        values.put("quantite", article.getQte());

        return bdd.insert("articles", null, values);

    }

    public Article getAll(){
        Cursor cursor = bdd.rawQuery(SELECT_ALL, null);

        return cursorToArticle(cursor);
    }

    public Article cursorToArticle(Cursor cursor){
        if (cursor.getCount() == 0){
            return null;
        }

        cursor.moveToFirst();

        Article article = new Article();
        article.setId(cursor.getInt(0));
        article.setNom(cursor.getString(1));
        article.setQte(cursor.getString(2));

        return article;
    }
}
