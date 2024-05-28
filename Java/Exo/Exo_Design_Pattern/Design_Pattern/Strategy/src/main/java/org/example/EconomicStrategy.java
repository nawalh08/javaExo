package org.example;

public class EconomicStrategy implements NavigationStrategy{

    @Override
    public boolean navigate(String destination){

        System.out.println("Vous êtes sur une route et pour économiser l'essence  vous pouvez rouler a 100 km/h constant jusqu'a : " + destination);
        return true;
    }
}
