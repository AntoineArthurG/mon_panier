package com.example.mon_panier;

import android.content.Context;
import android.view.LayoutInflater;
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
        holder.description_article.setText(listeArticle.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return listeArticle.size();
    }
}
