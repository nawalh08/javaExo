package org.example;
import java.io.Console;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Bienvenue au Festival Odiapason");
        String result ="";
        Scanner scanner = new Scanner(System.in);
        double energie = 100.0;
        System.out.println("Veuillez indiquez le temps que vous souhaiter passer en minutes");
        int tempsDispo = scanner.nextInt();


        do {
            if(energie>15.6 && tempsDispo>28) {
                System.out.println("Nous vous proposons trois type de Musiqe : Rock, Phonk et Rap veuillez faire votre choix");
                int choixUser = scanner.nextInt();

                switch (choixUser) {
                    case 1:
                        System.out.println("Rock");
                        System.out.println("Les trois représentations sont : \n1)Three Day Grace Durée: 85min énergie : 27\n2)Disturbed Durée: 60 minutes énérgie : 22 \n3)Showndown Durée: 28 minutes énérgie :15.6");
                        if (energie > 15.6 && tempsDispo > 28) {
                            int choixUserRock = scanner.nextInt();
                            switch (choixUserRock) {
                                case 1:
                                    if (energie >27  && tempsDispo >85 ) {
                                        energie = energie - 27;
                                        tempsDispo = tempsDispo - 85;
                                        result += "\n Artiste : Three Day Grace Durée: 85 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;
                                case 2:
                                    if (energie >22  && tempsDispo >60) {
                                        energie = energie - 22;
                                        tempsDispo = tempsDispo - 60;
                                        result += "\n Artiste : Disturbed Durée: 60 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;
                                case 3:
                                    if (energie >15.6  && tempsDispo >28 ) {
                                        energie = energie - 15.6;
                                        tempsDispo = tempsDispo - 28;
                                        result += "\n Artiste : Showndown Durée: 28 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;


                                default:
                                    break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Phonk");
                        System.out.println("Les trois représentations sont : \n1)Kordhell Durée: 85min énergie : 27\n2)Onimcru Durée: 60 minutes énérgie : 22 \n3)Moon Deity Durée: 28 minutes énérgie :15.6");
                        if (energie > 15.6 && tempsDispo > 28) {
                            int choixUserPhonk = scanner.nextInt();
                            switch (choixUserPhonk) {
                                case 1:
                                    if (energie >27  && tempsDispo >85 ) {
                                        energie = energie - 27;
                                        tempsDispo = tempsDispo - 85;
                                        result += "\n Artiste : Kordhell Durée: 85 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;
                                case 2:
                                    if (energie >22  && tempsDispo >60) {
                                        energie = energie - 22;
                                        tempsDispo = tempsDispo - 60;
                                        result += "\n Artiste : Onimxru Durée: 60 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;
                                case 3:
                                    if (energie >15.6  && tempsDispo >28 ) {
                                        energie = energie - 15.6;
                                        tempsDispo = tempsDispo - 28;
                                        result += "\n Artiste : Moon Deity Durée: 28 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;

                                default:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Rap");
                        System.out.println("Les trois représentations sont : \n1)Vald Durée: 85min énergie : 27\n2)Lorenzo Durée: 60 minutes énérgue : 22 \n3)Zach Diamond Durée: 28 minutes énérgie :15.6");

                            int choixUserRap = scanner.nextInt();
                            switch (choixUserRap) {
                                case 1:
                                    if (energie >27  && tempsDispo >85 ) {
                                        energie = energie - 27;
                                        tempsDispo = tempsDispo - 85;
                                        result += "\n Artiste : Vald Durée: 85 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;
                                case 2:
                                    if (energie >22  && tempsDispo >60) {
                                        energie = energie - 22;
                                        tempsDispo = tempsDispo - 60;
                                        result += "\n Artiste : Lorenzo Durée: 60 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;
                                case 3:
                                    if (energie >15.6  && tempsDispo >28 ) {
                                        energie = energie - 15.6;
                                        tempsDispo = tempsDispo - 28;
                                        result += "\n Artiste : Zach Diamond Durée: 28 min";
                                    }else {
                                        System.out.println("Le choix n'est pas possible");
                                    }
                                    break;
                                //....

                                default:
                                    break;
                            }

                        break;
                    //....

                    default:
                        System.out.println("Veuillez choisir une option valide");
                        break;

                }
            }else {break;}
        }while (energie>0 && tempsDispo>0);

        if(result.equals("")){
            System.out.println("Les valeurs que vous avez entrés ne vous permettent pas d'accéder au festival Odiapason");
        }else {
            System.out.println(result);
        }
        System.out.println(energie);
        System.out.println(tempsDispo);


    }
}