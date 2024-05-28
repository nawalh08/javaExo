package org.example.Exo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Evolution> graphique = new ArrayList<>();
        double aPayer = 0;
        double montant = 0;
        System.out.println("Veuillez indiquer ce que vous avez en votre possesion");
        montant = scanner.nextDouble();
        TaxSystem t = TaxSystem.builder().income(montant).build();
        t.pay(new TvaStrategy());

        Evolution e1 = new Evolution(montant,(montant*0.055),"TVA");
        t.setIncome(montant - montant*0.055);
        System.out.println(t.getIncome());
        graphique.add(e1);

    }

}
