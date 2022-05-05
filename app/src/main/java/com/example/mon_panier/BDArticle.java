package com.example.mon_panier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class BDArticle {

    private final static String SELECT_ALL = "SELECT * FROM articles;";

    private SQLiteDatabase bdd ;
    private MaBaseSQLite maBaseSQLite;

    public BDArticle (Context context) {
        maBaseSQLite = new MaBaseSQLite(context, "mon_panier", null, 1);
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

    public boolean insertArticle(Article article){

        boolean res;

        ContentValues values = new ContentValues();
        values.put("nom", article.getNom());
        values.put("quantite", article.getQte());
        values.put("categorie", article.getCategorie());
        values.put("description", article.getDescription());

        try {
            bdd.insertOrThrow("articles", null, values);
            res = true;
        } catch (SQLiteConstraintException e) {
            res = false;

        }

        return res;

    }

    public ArrayList<Article> getAll(){
        Cursor cursor = bdd.rawQuery(SELECT_ALL, null);

        return cursorToArticle(cursor);
    }

    public ArrayList<Article> cursorToArticle(Cursor cursor){
        ArrayList<Article> listeArticle = new ArrayList<>();

        if (cursor.getCount() == 0){
            return listeArticle;
        }

        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            Article article = new Article();
            article.setId(cursor.getInt(0));
            article.setNom(cursor.getString(1));
            article.setQte(cursor.getString(2));
            article.setCategorie(cursor.getString(3));
            article.setDescription(cursor.getString(4));

            listeArticle.add(article);
            cursor.moveToNext();
        }

        return listeArticle;
    }

    /*
        Permet de supprimer un article de la liste
     */
    public void deleteArticle(Article article) {
        bdd.delete("articles", "id = " + article.getId(), null);
    }

    public void resetListe (){

        bdd.delete("articles",null,null);
    }
}
