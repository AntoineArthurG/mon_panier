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
        nom_article = itemView.findViewById(R.id.tv_nomArticle);
        qte_article = itemView.findViewById(R.id.tv_quantiteArticle);
        categorie = itemView.findViewById(R.id.tv_categorieArticle);
        description_article = itemView.findViewById(R.id.tv_descriptionArticle);
    }
}
