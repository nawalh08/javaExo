package org.example;
import java.util.Scanner;
import java.util.Random;
public class BatailleNavale {
    public static void main(String[] args) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(4);
        int rand_int2 = rand.nextInt(4);
        int saisi =0;
        int saisi2 =0;
        int tour = 0;
        int trouveOrdi = 0;
        int trouveJoueur = 0;
        boolean partieTermine = false;
        Scanner scanner = new Scanner(System.in);
        String[][] tabJoueur = new String[12][12];
        String[][] tabOrdinateur = new String[12][12];
        for (int i =0 ;i<tabOrdinateur.length;i++){
            for (int j =0 ;j<tabOrdinateur[i].length;j++){
                    tabOrdinateur[i][j]="□";
                    tabJoueur[i][j]="□";
            }
        }
        for (int i =0 ;i<3;i++){
            rand_int1 = rand.nextInt(12);
            rand_int2 = rand.nextInt(12);
            tabOrdinateur[rand_int1][rand_int2] = "P";
        }
        for (int i =0 ;i<3;i++){
            System.out.println("Veuillez entrer une valeur pour la rangée de votre Bateau comprise entre 1 et 12");
            saisi = scanner.nextInt();

            System.out.println("Veuillez entrer une valeur pour la ligne de votre Bateau comprise entre 1 et 12 ");
            saisi2 = scanner.nextInt();
            tabJoueur[saisi-1][saisi2-1] = "P";
        }
        for (int i =0 ;i<tabOrdinateur.length;i++){
            for (int j =0 ;j<tabOrdinateur[i].length;j++){
                System.out.print(tabOrdinateur[i][j]);
            }
            System.out.println(" ");
        }

        System.out.println("______________________________________________");
        for (int i =0 ;i<tabOrdinateur.length;i++){
            for (int j =0 ;j<tabOrdinateur[i].length;j++){
                System.out.print(tabJoueur[i][j]);
            }
            System.out.println(" ");
        }




        do {
            if(trouveOrdi == 3 || trouveJoueur == 3){
                partieTermine = true;
            }
            if (tour%2 == 0){
                System.out.println("Tour de l'utilisateur");
                System.out.println("Veuillez entrer une valeur pour votre choix de ligne sur le plateau de l'ordinateur entre 1 et 12");
                saisi = scanner.nextInt();

                System.out.println("Veuillez entrer une valeur pour votre choix de colonne sur le plateau de l'ordinateur entre 1 et 12");
                saisi2 = scanner.nextInt();
                if(tabOrdinateur[saisi-1][saisi2-1].equals("P")){
                    trouveJoueur++;
                    tabOrdinateur[saisi-1][saisi2-1] = "X";
                    System.out.println("Touché");
                }
            }else {
                System.out.println("Tour de l'Ordinateur");
                rand_int1 = rand.nextInt(12);
                rand_int2 = rand.nextInt(12);
                System.out.println(rand_int1);
                System.out.println(rand_int2);
                if(rand_int1==0){
                    rand_int1=1;
                }
                if(rand_int2==0){
                    rand_int2=1;
                }
                if(tabJoueur[rand_int1-1][rand_int2-1].equals("B")){
                    trouveOrdi++;
                    tabJoueur[rand_int1-1][rand_int2-1] = "X";
                    System.out.println("Touché");
                }
            }
            tour++;
        }while (!partieTermine);
        for (int i =0 ;i<tabOrdinateur.length;i++){
            for (int j =0 ;j<tabOrdinateur[i].length;j++){
                System.out.print(tabOrdinateur[i][j]);
            }
            System.out.println(" ");
        }

        System.out.println("______________________________________________");
        for (int i =0 ;i<tabOrdinateur.length;i++){
            for (int j =0 ;j<tabOrdinateur[i].length;j++){
                System.out.print(tabJoueur[i][j]);
            }
            System.out.println(" ");
        }
        if(trouveJoueur == 3){
            System.out.println("Bien joué joueur vous avez gagné");
        }else{
            System.out.println("L'ordinateur à gagné ");
        }
    }

}
