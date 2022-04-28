package com.example.mon_panier;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
    Permet de représenter visuellement un élément de la liste de données dans le recyclerView.
    Une ligne.
 */
public class ArticleViewHolder extends RecyclerView.ViewHolder {

    TextView nom_article;
    TextView qte_article;
    TextView descri_article;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        nom_article = itemView.findViewById(R.id.nom_article);
        qte_article = itemView.findViewById(R.id.qte_article);
        descri_article = itemView.findViewById(R.id.descri_article);
    }
}
