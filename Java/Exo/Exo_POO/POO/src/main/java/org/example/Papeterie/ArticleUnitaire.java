package org.example.Papeterie;

public abstract class ArticleUnitaire extends Article{


    public String nom;

    public double prixUni;
    public ArticleUnitaire(int reference,String nom, double prixUni) {
        super(reference);
        this.nom = nom;
        this.prixUni = prixUni;
    }
}
