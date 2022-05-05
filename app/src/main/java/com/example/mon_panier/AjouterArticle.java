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
                EditText et_nom = findViewById(R.id.et_nomArticle);

                // Check si le nom de l'article a bien était renseigné par l'utilisateur
                if (et_nom.getText().toString().equals("")) {
                    Toast.makeText(AjouterArticle.this, "Veuillez saisir un nom d'article !", Toast.LENGTH_LONG).show();
                } else if (ajouter_article()) {
                    Intent mainActivity = new Intent(AjouterArticle.this, MainActivity.class);
                    startActivity(mainActivity);
                }
            }
        });

        /*
            Alimente le spinner de catégorie avec les valeurs fourni dans le string-array 'listeCategorie' du fichier ressource strings.xml
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
    public boolean ajouter_article(){

        boolean insertReussi;

        EditText et_nom = findViewById(R.id.et_nomArticle);
        EditText et_qte = findViewById(R.id.et_quantiteArticle);
        EditText et_description = findViewById(R.id.et_descriptionArticle);
        String nom = et_nom.getText().toString();
        String qte = et_qte.getText().toString();
        String description = et_description.getText().toString();

        // Formattage du nom d'article avant enregistrement en base
        String nomArticle = nom.trim();
        String nomFinal = nomArticle.substring(0, 1).toUpperCase() + nomArticle.substring(1);

        Article article = new Article(nomFinal, qte, categorie, description);

        bdArticle.open();
        insertReussi = bdArticle.insertArticle(article);
        bdArticle.close();

        if (insertReussi) {
            Toast.makeText(this,"Article enregistré !", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Article deja présent dans votre liste !", Toast.LENGTH_LONG).show();
        }

        return insertReussi;
    }
}