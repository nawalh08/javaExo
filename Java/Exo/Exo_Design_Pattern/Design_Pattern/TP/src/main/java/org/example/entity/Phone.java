package org.example.entity;

public class Phone extends Product {
    protected String intitule;

    protected String processeur;

    protected int memoire;

    protected String couleur;

    //TODO ajouter d'autres params

    public Phone(PhoneBuilder builder) {
        intitule = builder.intitule;
        processeur = builder.processeur;
        memoire = builder.memoire;
        couleur = builder.couleur;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "intitule='" + intitule + '\'' +
                ", processeur='" + processeur + '\'' +
                ", memoire=" + memoire +
                "GO , couleur='" + couleur + '\'' +
                '}';
    }

    public static class PhoneBuilder extends AbstractProductBuilder {
        protected String intitule;

        protected String processeur;

        protected int memoire;

        protected String couleur;

        public PhoneBuilder intitule(String intitule) {
            this.intitule = intitule;
            return this;
        }
        public PhoneBuilder processeur(String processeur) {
            this.processeur = processeur;
            return this;
        }
        public PhoneBuilder memoire(int memoire) {
            this.memoire = memoire;
            return this;
        }

        public PhoneBuilder couleur(String couleur) {
            this.couleur = couleur;
            return this;
        }



        public Phone build() {
            return new Phone(this);
        }
    }
}
