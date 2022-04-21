package com.example.mon_panier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterArticle extends AppCompatActivity {

    String nom;
    String qte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_article);

        /*
            Enregistrer l'article
         */
        Button enregistrer = findViewById(R.id.btn_enregistrer);
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enregistrerArticle();

                Intent mainActivity = new Intent(AjouterArticle.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }

    public void enregistrerArticle () {
        // récupère le dossier sharedPreferences et on créer un
        SharedPreferences sharedPref = this.getSharedPreferences("listeCourse", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // récupère le nom et la qte que l'utilisateur a rentré
        EditText et_nom = findViewById(R.id.et_nomArticle);
        EditText et_qte = findViewById(R.id.et_quantiteArticle);
        nom = et_nom.getText().toString();
        qte = et_qte.getText().toString();

        editor.putString("nomArticle", nom);
        editor.putString("quantite", qte);

        editor.apply();

        Toast.makeText(this,"Article enregistrer!", Toast.LENGTH_LONG).show();
    }
}