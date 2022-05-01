package com.example.mon_panier;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    TextView nom_article;
    TextView qte_article;
    TextView categorie;
    TextView description_article;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        nom_article = itemView.findViewById(R.id.nom_article);
        qte_article = itemView.findViewById(R.id.qte_article);
        categorie = itemView.findViewById(R.id.categorie);
        description_article = itemView.findViewById(R.id.description_article);
    }
}
