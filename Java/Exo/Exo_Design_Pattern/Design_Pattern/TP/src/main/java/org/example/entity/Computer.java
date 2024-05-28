package org.example.entity;

public class Computer extends Product {

    protected String intitule;

    protected String processeur;

    protected double memoire;
    protected String couleur;

    //TODO ajouter d'autres params

    public Computer(ComputerBuilder builder) {
        intitule = builder.intitule;
        processeur = builder.processeur;
        memoire = builder.memoire;
        couleur = builder.couleur;
    }
    @Override
    public String toString() {
        return "Computer{" +
                "intitule='" + intitule + '\'' +
                ", processeur='" + processeur + '\'' +
                ", memoire=" + memoire +
                ", couleur='" + couleur + '\'' +
                '}';
    }
    public static class ComputerBuilder extends AbstractProductBuilder {
        protected String intitule;

        protected String processeur;

        protected double memoire;
        protected String couleur;



        public ComputerBuilder intitule(String intitule) {
            this.intitule = intitule;
            return this;
        }
        public ComputerBuilder processeur(String processeur) {
            this.processeur = processeur;
            return this;
        }
        public ComputerBuilder memoire(double memoire) {
            this.memoire = memoire;
            return this;
        }
        public ComputerBuilder couleur(String couleur) {
            this.couleur = couleur;
            return this;
        }



        public Computer build() {
            return new Computer(this);
        }
    }


}
