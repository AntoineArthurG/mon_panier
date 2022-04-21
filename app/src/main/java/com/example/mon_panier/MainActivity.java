package com.example.mon_panier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    }

    public void afficher (){
        TextView tv_nom = findViewById(R.id.nom);
        TextView tv_qte = findViewById(R.id.qte);

        bdArticle.open();

        Article article = bdArticle.getAll();

        bdArticle.close();

        tv_nom.setText(article.getNom());
        tv_qte.setText(article.getQte());


    }
}