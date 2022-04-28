package com.example.mon_panier;

/*
    Classe Article composé d'attributs.
 */
public class Article {

    private int num = 0;
    private int id;
    private String nom;
    private String qte;

    public Article(){}

    public Article(int id, String nom, String qte){
        this.id = id;
        this.nom = nom;
        this.qte = qte;
        this.num++;
    }

    public Article(String nom, String qte){
        //this.id = num;
        this.nom = nom;
        this.qte = qte;
        //this.num++;
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

    //public String getDescri() { return descri;}
    //public void setDescri(String descri) {this.descri = descri;}


}

