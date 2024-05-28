package org.example.util.Ihm;

import java.util.Scanner;

public class Ihm {
    private Scanner scanner;

    private AnimalIhm animalIhm;

    private MealIhm mealIhm;

    private Enclosihm enclosihm;

    public Ihm (){
        scanner = new Scanner(System.in);
        animalIhm = new AnimalIhm(scanner);
        mealIhm = new MealIhm(scanner);
        enclosihm = new Enclosihm(scanner);

    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Application gestion de zoo ---");
            System.out.println("1/ menu animal");
            System.out.println("2/ menu meal");
            System.out.println("3/ menu enclos");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    animalIhm.start();
                    break;
                case 2:
                    mealIhm.start();
                    break;
                case 3:
                    enclosihm.start();
                    break;
                default:
                    return;
            }
        }
    }
}
