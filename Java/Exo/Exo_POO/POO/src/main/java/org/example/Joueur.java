package org.example;



public class Joueur {
    private String nom;
    private int niveau = 1;
    private int xp = 0;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public void setNom(String nom) {
        System.out.println(this.nom + " change de pseudo : " + nom);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getXp() {
        return xp;
    }

    public void effectuerUneQuete() {
        this.xp += 10; // setXp(getXp() + 10);
//        if(this.xp >= 100)
        levelUp();
    }

    private void levelUp(){
        if (this.xp >= 100) {
            this.niveau++;
            this.xp = 0;
            System.out.printf("Le joueur: %s passe au niveau %d !\n", nom, niveau);
        }
    }
}

