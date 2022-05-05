package com.example.mon_panier;

import android.graphics.Paint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    TextView nom_article;
    TextView qte_article;
    TextView categorie;
    TextView description_article;
    Button btn_supprimer;

    CheckBox checkBox;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        nom_article = itemView.findViewById(R.id.tv_nomArticle);
        qte_article = itemView.findViewById(R.id.tv_quantiteArticle);
        categorie = itemView.findViewById(R.id.tv_categorieArticle);
        description_article = itemView.findViewById(R.id.tv_descriptionArticle);
        btn_supprimer = itemView.findViewById(R.id.btn_supprimer);
        checkBox = itemView.findViewById(R.id.checkBox);
    }
}
