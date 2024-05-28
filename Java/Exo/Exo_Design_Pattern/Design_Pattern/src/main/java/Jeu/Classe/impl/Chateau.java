package Jeu.Classe.impl;

import Jeu.Classe.Batiment;

public class Chateau extends Batiment {



        private int pieces;

        public Chateau(ChateauBuilder builder) {
            super(builder);
            this.pieces = builder.piece;
        }

    public static class ChateauBuilder extends Batiment.BatimentBuilder {


        private int piece;

        public ChateauBuilder setPiece(int piece) {
            this.piece = piece;
            return this;
        }

        @Override
        public Batiment build() {
            return new Chateau(this);
        }


    }

    public String toString() {
        return  super.toString() + " pièces : " +  pieces + " } " ;
    }




}
