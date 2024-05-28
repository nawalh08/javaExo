package Jeu;

import Jeu.Classe.impl.Chateau;
import Jeu.Classe.impl.Forge;
import org.example.Pizzas.Pizza;

public class Main {
    public static void main(String[] args) {

        Chateau chateauChambord = (Chateau) new Chateau.ChateauBuilder().setPiece(4).setStyle("Gothique").setTaille(500).build();
        Forge Forge1 = (Forge) new Forge.ForgeBuilder().setOwner("John").setStyle("Gothique").setTaille(500).build();

        System.out.println(chateauChambord.toString());

        System.out.println(Forge1);



    }
}
