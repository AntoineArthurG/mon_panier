package com.example.mon_panier;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    Context context;
    ArrayList<Article> listeArticle;

    public ArticleAdapter(Context context, ArrayList<Article> listeArticle) {
        this.context = context;
        this.listeArticle = listeArticle;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(context).inflate(R.layout.article_ligne,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.nom_article.setText(listeArticle.get(position).getNom());
        holder.qte_article.setText(listeArticle.get(position).getQte());
        holder.categorie.setText(listeArticle.get(position).getCategorie());
        holder.description_article.setText(listeArticle.get(position).getDescription());

        // Barre l'article lorsque le checkbox est cliqué
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.checkBox.isChecked()) {
                    holder.nom_article.setPaintFlags(holder.nom_article.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else if (!holder.checkBox.isChecked()) {
                    holder.nom_article.setPaintFlags(holder.nom_article.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        // Supprime un article unique de la base et du recyclerView
        holder.btn_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getLayoutPosition();

                BDArticle bdArticle = new BDArticle(context);
                bdArticle.open();
                bdArticle.deleteArticle(listeArticle.get(position));
                bdArticle.close();

                listeArticle.remove(position);

                notifyItemRemoved(position);
                notifyItemRangeChanged(position, listeArticle.size());
            }
        });


    }

    @Override
    public int getItemCount() {
        return listeArticle.size();
    }
}
