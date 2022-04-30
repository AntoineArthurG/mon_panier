package com.example.mon_panier;

public class Article {

    private int num = 0;
    private int id;
    private String nom;
    private String qte;
    private String description;
    private String categorie;

    public Article(){}

    public Article(int id, String nom, String qte){
        this.id = id;
        this.nom = nom;
        this.qte = qte;
        this.num++;
    }

    public Article(String nom, String qte,String categorie, String description){
        this.nom = nom;
        this.qte = qte;
        this.description = description;
        this.categorie = categorie;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}

