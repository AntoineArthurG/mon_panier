package com.example.mon_panier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
    Liaison entre la vue RecylerView et une liste de données.
    Gère affichage des éléments de la liste.
    Liaison entre les données à afficher et où les afficher.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    Context context;
    ArrayList<Article> listeArticle;

    public ArticleAdapter(Context context, ArrayList<Article> listeArticle) {
        this.context = context;
        this.listeArticle = listeArticle;
    }


    /*
        Contient les éléments qui composent un élément de la liste.
     */
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(context).inflate(R.layout.article_ligne,parent,false));
    }


    /*
        Lire les éléments de ViewHolder à leurs valeurs de base de données.
     */
    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.nom_article.setText(listeArticle.get(position).getNom());
        holder.qte_article.setText(listeArticle.get(position).getQte());
        //holder.descri_article.setText(listeArticle.get(position).getDescri());
    }

    /*
        Compte les items de la liste.
     */
    @Override
    public int getItemCount() {
        return listeArticle.size();
    }
}
