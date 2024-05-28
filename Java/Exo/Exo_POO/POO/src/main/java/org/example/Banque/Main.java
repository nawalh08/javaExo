package org.example.Banque;


import java.util.ArrayList;

public class Main {


    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

        public static void main(String[] args) {
            CompteCourant compte1 = new CompteCourant(150.0,"John Doe",new ArrayList<Operation>());
            compte1.depot(10,new Operation(10,"depot de 10 euros"));
            compte1.depot(10,new Operation(10,"depot de 10 euros"));
            compte1.depot(10,new Operation(10,"depot de 10 euros"));
            compte1.depot(10,new Operation(10,"depot de 10 euros"));
            System.out.println(compte1.toString());

            ComptePayant compte2 = new ComptePayant(150.0,"John Doe",new ArrayList<Operation>(),2.50);
            compte2.depot(10,new Operation(10,"depot de 10 euros", compte2.frais));
            compte2.depot(10,new Operation(10,"depot de 10 euros" , compte2.frais));
            compte2.depot(10,new Operation(10,"depot de 10 euros" , compte2.frais));
            compte2.depot(10,new Operation(10,"depot de 10 euros" , compte2.frais));
            System.out.println(compte2.toString());
            CompteEpargne compte3 = new CompteEpargne(150.0,"John Doe",new ArrayList<Operation>(),2.50);
            compte3.invest(new Operation(" Resultat de votre Epargne  "));
            compte3.invest(new Operation(" Resultat de votre Epargne  "));
            compte3.invest(new Operation(" Resultat de votre Epargne  "));
            compte3.invest(new Operation(" Resultat de votre Epargne  "));

            System.out.println(compte3.toString());

        }
    }


