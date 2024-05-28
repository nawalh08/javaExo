package Jeu.Classe.Factory;

import Jeu.Classe.Batiment;

public abstract class  Factory {

    public abstract Batiment createBatiment(Batiment.BatimentBuilder builder);


}

