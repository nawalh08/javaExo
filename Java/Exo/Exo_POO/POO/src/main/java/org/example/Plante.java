package org.example;

public class Plante {

    public  String nom;

    public  double hauteur;

    public  String couleur;

    public Plante (String nom,double hauteur,String couleur){
        this.nom = nom;
        this.couleur = couleur;
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String toString(){
        return "La Plante est une " + nom + " de couleur " + couleur + " et qui mesure " + hauteur + "cm";
    }
}
