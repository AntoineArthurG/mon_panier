package com.example.mon_panier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AjouterArticle extends AppCompatActivity {

    BDArticle bdArticle;
    public String categorie;

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

        /*
            Alimente le spinner de catégorie
         */
        Spinner spinner = findViewById(R.id.categorie_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.listeCategorie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // récupère la catégorie selectionner par l'utilisateur
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                categorie = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /*
        Méthode qui permet d'enregistrer un article. Cette méthode est appeler dans le onClickListener du bouton 'AjouterArticle'
     */
    public void ajouter_article(){

        EditText et_nom = findViewById(R.id.et_nomArticle);
        EditText et_qte = findViewById(R.id.et_quantiteArticle);
        EditText et_description = findViewById(R.id.et_descriptionArticle);
        String nom = et_nom.getText().toString();
        String qte = et_qte.getText().toString();
        String description = et_description.getText().toString();

        Article article = new Article(nom, qte, categorie, description);


        bdArticle.open();
        bdArticle.insertArticle(article);
        bdArticle.close();

        Toast.makeText(this,"Article enregistrer!", Toast.LENGTH_LONG).show();

    }

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        categorie = adapterView.getItemAtPosition(i).toString();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
}