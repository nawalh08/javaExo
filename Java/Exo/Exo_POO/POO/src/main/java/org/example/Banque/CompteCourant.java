package org.example.Banque;

import java.util.List;

public class CompteCourant extends Compte {
    public CompteCourant(double solde, String client, List<Operation> operation) {
        super(solde, client, operation);
    }
}
