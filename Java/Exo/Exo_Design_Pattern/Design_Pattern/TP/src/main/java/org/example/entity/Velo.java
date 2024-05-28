package org.example.entity;

public class Velo extends Product{

    protected String modele;

    protected int nbRoue;

    protected String couleur;

    public Velo(VeloBuilder builder) {
        modele = builder.modele;
        nbRoue = builder.nbRoue;
        couleur = builder.couleur;
    }

    public static class VeloBuilder extends AbstractProductBuilder{

        protected String modele;

        protected int nbRoue;

        protected String couleur;

        public VeloBuilder modele(String modele){

            this.modele = modele;
            return this;
        }
        public VeloBuilder nbRoue(int nbRoue){

            this.nbRoue = nbRoue;
            return this;
        }
        public VeloBuilder couleur(String couleur){

            this.couleur = couleur;
            return this;
        }


        public Velo build() {
            return new Velo(this);
        }

    }

    @Override
    public String toString() {
        return "Velo{" +
                "modele='" + modele + '\'' +
                ", nbRoue=" + nbRoue +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
