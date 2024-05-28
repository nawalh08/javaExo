package org.example.Banque;

import java.util.List;

public class ComptePayant extends Compte{

    public double frais;
    public ComptePayant(double solde, String client, List<Operation> operation, double frais) {
        super(solde, client, operation);
        this.frais = frais;
    }


    public void depot(double valeur, Operation ope){
        this.solde +=valeur - this.frais;
        this.operation.add(ope);
    }
    public void retrait(double valeur, Operation ope) {
        this.solde -=valeur - this.frais;
        this.operation.add(ope);
    }

    @Override
    public String toString() {
        String liste ="";
        for (int i = 0; i < operation.size(); i++) {
            liste+= operation.get(i).toStringPayant() + "\n";
        }
        return "Compte{" + "id = " + idCompte +
                " solde=" + solde +
                ", client='" + client + '\'' +
                ", \nOperation=" + liste+
                '}';
    }


}
