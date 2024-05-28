package org.example;

public class Arbre extends Plante{

    public double circonference;
    public Arbre(String nom, double hauteur, String couleur,double circonference) {
        super(nom, hauteur, couleur);
        this.circonference= circonference;
    }

    public void setCirconference(double circonference) {
        this.circonference = circonference;
    }

    public double getCirconference() {
        return circonference;
    }
    @Override
    public String toString() {
        return  super.toString() + " et de circonference " +  circonference + " m";
    }

}
