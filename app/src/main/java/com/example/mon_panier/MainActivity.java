package com.example.mon_panier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BDArticle bdArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdArticle = new BDArticle(this);
        afficher();


        /*
            Ajouter un article
         */
        Button ajouter = findViewById(R.id.btn_ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AjouterArticle.class);
                startActivity(intent);
            }
        });

        /*
            Réinitialiser la liste
         */
        Button reinitialiser = findViewById(R.id.btn_reinitialiser);
        reinitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdArticle.open();
                bdArticle.getBdd().execSQL("delete from articles ;");
                bdArticle.close();

                // refresh
                finish();
                startActivity(getIntent());
            }
        });
    }

    public void afficher (){
        TextView tv_nom = findViewById(R.id.nom);
        TextView tv_qte = findViewById(R.id.qte);

        bdArticle.open();

        ArrayList<Article> listeArticle = bdArticle.getAll();

        bdArticle.close();

        if (!listeArticle.isEmpty()) {
            for (int i = 0; i < listeArticle.size(); i++) {
                tv_nom.setText(listeArticle.get(i).getNom());
                tv_qte.setText(listeArticle.get(i).getQte());
            }
        } else {
            tv_nom.setText("vide");
            tv_qte.setText("vide");
        }




    }
}