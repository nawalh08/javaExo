package org.example.Papeterie;

import java.util.Arrays;

public class Facture {

    public String client;

    public int nbLigne;

    public String date;
    private static int nbFacture = 1;

    public int idFacture;

    Ligne[] tabLigne;



    public Facture(String client, int nbLigne, String date) {
        this.client = client;
        this.nbLigne = nbLigne;
        this.date = date;
        this.idFacture = nbFacture;
        this.tabLigne = new Ligne[nbLigne];
        nbFacture++;
    }

    public Facture(String client, String date) {
        this.client = client;
        this.nbLigne = 10;
        this.date = date;
        this.idFacture = nbFacture;
        this.tabLigne = new Ligne[nbLigne];
        nbFacture++;
    }

    public void ajouterLigne(Ligne ligne){
        for (int i = 0; i <this.tabLigne.length; i++) {
            if (this.tabLigne[i] ==null){
                this.tabLigne[i]=ligne;
                break;
            }
        }

    }

    public String getPrixTotal(){
        double prixTotal = 0;
        for (int i = 0; i <this.tabLigne.length; i++) {
            if (this.tabLigne[i] !=null){
                prixTotal+= this.tabLigne[i].prixTotal;

            }
        }
        return ("Prix total de la facutre n° " + this.idFacture + "  "  +  prixTotal);
    }

    @Override
    public String toString() {
        return "Facture{" +
                "client='" + client + '\'' +
                ", nbLigne=" + nbLigne +
                ", date='" + date + '\'' +
                ", idFacture=" + idFacture +
                ", tabLigne=" + Arrays.toString(tabLigne) +
                '}';
    }
}
