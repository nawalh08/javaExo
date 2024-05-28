package org.example.Papeterie;

public class Ligne extends Lot{

    public String nomArticle;

    public double prixTotal;

    public double prixUnique;

    public Ligne(int reference, int qte, double remise,String nomArticle) {
        super(reference, qte, remise);
        this.nomArticle = nomArticle;
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "Quantité='" + qte + '\'' +
                ", Référence=" + reference +
                ", Prix Unique=" + prixUnique +
                ", Prix Total=" + prixTotal +
                ", Nom Article=" + nomArticle +

                '}';
    }
}
