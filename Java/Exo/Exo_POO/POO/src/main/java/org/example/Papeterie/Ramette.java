package org.example.Papeterie;

public class Ramette extends ArticleUnitaire{

    public double grammage;

    public Ramette(int reference, String nom, double prixUni, double grammage) {
        super(reference, nom, prixUni);
        this.grammage = grammage;
    }
}
