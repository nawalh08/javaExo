package org.example.Exo2;

public class Evolution {


    public Evolution(double montant, double montantAPayer,String type) {
        this.montant = montant;
        this.montantAPayer = montantAPayer;
        this.type = type;
    }

    public double montant;
    public double montantAPayer;


    public String type;

    @Override
    public String toString() {
        return "Evolution{" +
                "montant=" + montant +
                ", montantAPayer=" + montantAPayer +
                ", type='" + type + '\'' +
                '}';
    }
}
