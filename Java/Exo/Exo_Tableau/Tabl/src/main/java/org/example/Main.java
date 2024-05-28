package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tab = {"1", "2", "3", "4","5","6","7"};
        String saisi = "";
        boolean isInside = false;

        do {

            if(!saisi.equals("")) {
                System.out.println("Votre chiffre " + saisi + " n'est pas dans le tableau ");
            }
            System.out.println("Veuillez entrer une valeur pour vérifier si elle est dans le tableau et vous obtenerez son indice : ");
            saisi = scanner.nextLine();
            for (int i = 0;i<tab.length;i++){
                if(saisi.equals(tab[i])){
                    isInside = true;
                    i=i+1;
                    System.out.println("Votre chiffre "+ saisi + " est à l'indice "  + i );
                }

            }
        }while(!isInside);
    }
}