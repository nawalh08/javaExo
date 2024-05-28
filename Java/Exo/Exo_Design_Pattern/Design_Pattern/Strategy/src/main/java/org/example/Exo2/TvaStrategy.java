package org.example.Exo2;

import java.util.Scanner;

public class TvaStrategy implements TaxStrategy{

    @Override
    public double calculateTax(double income){
        System.out.println(income*0.055);
       return income*0.055;
    }
}
