package com.example.mon_panier;

import android.graphics.Paint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    TextView nom_article;
    TextView qte_article;
    TextView categorie;
    TextView description_article;

    CheckBox checkBox;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        nom_article = itemView.findViewById(R.id.tv_nomArticle);
        qte_article = itemView.findViewById(R.id.tv_quantiteArticle);
        categorie = itemView.findViewById(R.id.tv_categorieArticle);
        description_article = itemView.findViewById(R.id.tv_descriptionArticle);

        checkBox = itemView.findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    nom_article.setPaintFlags(nom_article.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else if (!checkBox.isChecked()) {
                    nom_article.setPaintFlags(nom_article.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });
    }
}
