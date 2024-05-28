package org.example;

public class OffRoeadStrategy implements NavigationStrategy {

    @Override
    public boolean navigate(String destination){

        System.out.println("Vous êtes sur une route tout-terrain  vous pouvez rouler a 50 km/h jusqu'a : " + destination);
        return true;
    }
}
