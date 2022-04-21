package com.example.mon_panier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // données stocker dans sharedPreferences
        SharedPreferences sharedPref = this.getSharedPreferences("listeCourse", MODE_PRIVATE);
        String produit = sharedPref.getString("nomArticle", null);


        // données pour le recyclerView
        ArrayList<String> listeProduit = new ArrayList<>();
        //listeProduit = (ArrayList<String>) sharedPref.getAll();


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
}