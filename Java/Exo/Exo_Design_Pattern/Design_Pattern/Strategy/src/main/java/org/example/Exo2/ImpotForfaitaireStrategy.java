package org.example.Exo2;

import java.util.Scanner;

public class ImpotForfaitaireStrategy implements TaxStrategy {

    @Override
    public double calculateTax(double income){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez indiquer le temps de votre contract");
        int temps = scanner.nextInt();
        if(temps>8){
            System.out.println(income*0.075);
            return (income*0.075) ;
        }else {
            System.out.println(income*0.128);
            return (income*0.128);
        }
    }


}
