package com.example.mon_panier;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BDArticle bdArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdArticle = new BDArticle(this);
        bdArticle.open();
        ArrayList<Article> listeArticle = bdArticle.getAll();
        bdArticle.close();

        RecyclerView recyclerView = findViewById(R.id.rv_listeArticle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ArticleAdapter(getApplicationContext(), listeArticle));

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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.dialog_title);

                builder.setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        bdArticle.open();
                        bdArticle.resetListe();
                        bdArticle.close();
                        dialog.dismiss();
                        // refresh
                        finish();
                        startActivity(getIntent());
                    }
                });
                builder.setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}