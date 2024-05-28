package Jeu.Classe.impl;

import Jeu.Classe.Batiment;

public class Forge extends Batiment {

    private String owner;

    public Forge(Forge.ForgeBuilder builder) {
        super(builder);
        this.owner = builder.owner;
    }

    public static class ForgeBuilder extends Batiment.BatimentBuilder {


        private String owner;

        public Forge.ForgeBuilder setOwner(String owner) {
            this.owner = owner;
            return this;
        }

        @Override
        public Batiment build() {
            return new Forge(this);
        }


    }
    public String toString() {
        return  super.toString() + "  Propriètaire : " +  owner + " } " ;
    }
}
