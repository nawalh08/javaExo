package org.example;
import java.util.Scanner;
import java.util.Random;
public class SiegeAvion {
    public static void main(String[] args) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(6);

        int saisi =0;
        int saisi2 =0;
        Scanner scanner = new Scanner(System.in);
        String[][] tab = new String[10][6];
        for (int i =0 ;i<tab.length;i++){
            for (int j =0 ;j<tab[j].length;j++){
                rand_int1 = rand.nextInt(6);
                if(j==rand_int1){
                    tab[i][j]="x";
                }else {
                    tab[i][j]="□";
                }
            }

        }
        boolean isFull=false;
        boolean tmp = false;
        do {
            for (int i =0 ;i<tab.length;i++){
                for (int j =0 ;j<tab[j].length;j++){
                    if(tab[i][j].equals("□")){
                        tmp = true;
                        break;
                    };
                }


            }
            System.out.println("Veuillez entrer une valeur pour la rangée de votre siège comprise entre 1 et 11 et veuillez entrer 0 pour quitter");
            saisi = scanner.nextInt();
            if (saisi == 0){
                System.out.println("Au revoir et merci de votre interêt");
                break;
            }
            System.out.println("Veuillez entrer une valeur pour le numéro de votre siège comprise entre 1 et 6");
            saisi2 = scanner.nextInt();
            if( !tab[saisi-1][saisi2-1].equals("x")  ){
                tab[saisi-1][saisi2-1]="x";
            }else {
                System.out.println("Siège dèja pris ");
            }



            for (int i =0 ;i<tab.length;i++){
                for (int j =0 ;j<tab[j].length;j++){
                    System.out.print(tab[i][j]);
                }
                System.out.println(" ");

            }
            if (tmp == false){
                isFull = true;
            }

        }while (!isFull  && saisi != (0));

    }









}
