package org.example;

public class Chaise {
    // Attributs
    private String materiaux; // attribut avec valeur par défaut
    private int pied;
    private double prix;

    private String couleur;

    // Constructeur polymorphique (2 formes)
    public Chaise(){
        this("bambou" ,3,130.99,"grise");
    }
    public Chaise(String materiaux, int pied,double prix,String couleur){

        this.materiaux = materiaux;
        this.pied = pied;
        this.prix = prix;
        this.couleur = couleur;
    }


    // Méthodes


    public String toString(){
        return "Je suis une chaise avec " + this.pied + " pied(s) en " + this.materiaux + " de couleur " + this.couleur + " à un prix de " + this.prix;
    }
    // Méthode appelée lorsque l'on essaie d'afficher ou de concaténer un chat
    // par défaut, toString affiche ce genre de résultat :
    // org.example.demos.demo01.Chat@65ab7765
}
