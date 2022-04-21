package com.example.mon_panier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterArticle extends AppCompatActivity {

    BDArticle bdArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_article);

        bdArticle = new BDArticle(this);

        /*
            Bouton enregister article
         */
        Button enregistrer = findViewById(R.id.btn_enregistrer);
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajouter_article();

                Intent mainActivity = new Intent(AjouterArticle.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });

    }

    public void ajouter_article(){

        EditText et_nom = findViewById(R.id.et_nomArticle);
        EditText et_qte = findViewById(R.id.et_quantiteArticle);
        String nom = et_nom.getText().toString();
        String qte = et_qte.getText().toString();

        Article article = new Article(nom, qte);

        bdArticle.open();
        bdArticle.insertArticle(article);
        bdArticle.close();

        Toast.makeText(this,"Article enregistrer!", Toast.LENGTH_LONG).show();

    }
}