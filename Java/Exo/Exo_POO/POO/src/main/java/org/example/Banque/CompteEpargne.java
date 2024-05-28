package org.example.Banque;

import java.util.List;

public class CompteEpargne extends Compte{

    public double taux;
    public CompteEpargne(double solde, String client, List<Operation> operation,double taux) {
        super(solde, client, operation);
        this.taux = taux;
    }

    public void invest(Operation ope){
        this.solde *=1+(taux/100);
        this.operation.add(ope);
    }

    @Override
    public String toString() {
        String liste ="";
        for (int i = 0; i < operation.size(); i++) {
            liste+= operation.get(i).toStringEpargne()+ "taux = " + this.taux +"}" +  "\n";
        }
        return "Compte{" + "id = " + idCompte +
                " solde=" + solde +
                ", client='" + client + '\'' +
                ", \nOperation=" + liste+
                '}';
    }
}
