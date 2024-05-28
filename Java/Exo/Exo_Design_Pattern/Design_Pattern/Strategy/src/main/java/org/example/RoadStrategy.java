package org.example;

public class RoadStrategy implements NavigationStrategy{

    @Override
    public boolean navigate(String destination){

        System.out.println("Vous êtes sur une route vous pouvez rouler a 70 km/h jusqu'a : " + destination);
        return true;
    }

}
