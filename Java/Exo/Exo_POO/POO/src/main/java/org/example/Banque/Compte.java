package org.example.Banque;
import java.util.List;

public abstract class Compte {

    public double solde;

    public String client ;//Objet Client
    private static int nbCompte = 1;

    public int idCompte;

    public List<Operation> operation;

    public Compte(double solde, String client, List<Operation> operation) {
        this.idCompte = nbCompte;
        this.solde = solde;
        this.client = client;
        this.operation = operation;
        nbCompte++;
    }

    public void depot(double valeur, Operation ope){
        this.solde +=valeur;
        this.operation.add(ope);
    };
    public void retrait(double valeur, Operation ope){
        this.solde -=valeur;
        this.operation.add(ope);
    };

    public List<org.example.Banque.Operation> getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        String liste ="";
        for (int i = 0; i < operation.size(); i++) {
            liste+= operation.get(i).toString() + "\n";
        }
        return "Compte{" + "id = " + idCompte +
                " solde=" + solde +
                ", client='" + client + '\'' +
                ", \nOperation=" + liste+
                '}';
    }
}
