package org.example.Papeterie;

public class Stylo extends ArticleUnitaire{

    public String couleur;

    public Stylo(int reference, String nom, double prixUni,String couleur) {
        super(reference, nom, prixUni);
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Stylo{" +
                "couleur='" + couleur + '\'' +
                ", nom='" + nom + '\'' +
                ", prixUni=" + prixUni +
                ", reference=" + reference +
                '}';
    }
}
