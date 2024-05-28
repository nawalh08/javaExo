package org.example.Banque;

public class Operation {

    public double value;
    public String intitule;

    public double frais;

    public float taux;

    public Operation(double value, String intitule) {
        this.value = value;
        this.intitule = intitule;
    }
    public Operation(double value, String intitule, double frais) {
        this.value = value;
        this.intitule = intitule;
        this.frais = frais;
    }
    public Operation(String intitule) {

        this.intitule = intitule;

    }


    @Override
    public String toString() {
        return "Operation{" +
                "value=" + value +
                ", intitule='" + intitule + '\'' +
                '}';
    }
    public String toStringPayant() {
        return "Operation{" +
                "value=" + value +
                ", intitule='" + intitule + ", frais='" + frais +'\'' +
                '}';
    }
    public String toStringEpargne() {
        return "Operation{"+                ", intitule='" + intitule + '\''
                ;
    }
}
