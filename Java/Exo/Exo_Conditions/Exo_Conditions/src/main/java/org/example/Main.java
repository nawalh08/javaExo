package org.example;
import java.util.Locale;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//Exercice 1
        Scanner scanner = new Scanner(System.in);
//       System.out.println("Vous vous trouvez devant le dortoir abandonné vous pouvez choisir d'y entrer en entrant 1 , " +
//                "d'appeller un professeur en entrant 2  ou d'ignorer l'appel à l'aide de votre ami en entrant 3, \nVotre choix : ");
//
//
//
//
//        String saisi = scanner.nextLine();
//
//
//        switch (saisi) {
//            case "1":
//                System.out.println("Après avoir remporté le duel face à Titan et sauver votre ami vous obtener des informations sur Atticus");
//                break;
//            case "2":
//                System.out.println("Vous avez appelé un professeur qui vous à aidé a vous en sortir mais vos amis on été bléssé");
//                break;
//            case "3":
//                System.out.println("Personne ne sais ce qu'il ai arrivé à vos amis mais vous senter votre âme pesé plus lourde");
//                break;
//            //....
//
//            default:
//                System.out.println("Veuillez entrer une valeur incluse");
//                break;
//        }

        //Exercice 2
        /*System.out.println("Pensez à un animal et je vais essayez de le trouvez. Votre animal vie il sous l'eau ? Repondez par vrai ou faux \nVotre choix : ");




        String saisi2 = scanner.nextLine();


        switch (saisi2.toLowerCase(Locale.ROOT)) {
            case "vrai":
                System.out.println("Votre animal est il connu pour ses attaques ? Repondez par vrai ou faux");
                String saisi3 = scanner.nextLine();
                if(saisi3.toLowerCase(Locale.ROOT).equals("vrai")){
                    System.out.println("Je pense au Requin");
                }else{
                    System.out.println("Je pense à la baleine");
                }
                break;
            case "faux":
                System.out.println("Votre animal est-il le meilleur ami de l'homme ? Repondez par vrai ou faux");
                String saisi4 = scanner.nextLine();
                if(saisi4.toLowerCase(Locale.ROOT).equals("vrai")){
                    System.out.println("Je pense au Chien");
                }else{
                    System.out.println("Je pense au chat");
                }
                break;


            default:
                System.out.println("Veuillez entrer une valeur incluse");
                break;
        }*/
        //Exercice 3

        /*System.out.println("Vous aimez les super-héros ? Si oui donner moi votre personalité parmi ces choix : Intelligent, Drôle , Brute, Agile\nVotre Choix : ");
        String Hero = scanner.nextLine();
        switch (Hero) {
            case "Intelligent":
                System.out.println("Je vous recommande Batman\nEn effet Batman est l'un des super-héros les plus intelligents comme ses aventures on pu le prouver de nombreuse fois");
                break;
            case "Drôle":
                System.out.println("Je vous recommande DeadPool\nDeadPool est bien connu pour ses moments délirants qui avec son histoire et son caractère peuvent vous correspondre");
                break;
            case "Brute":
                System.out.println("Je vous recommande Hulk\nEn effet qui de mieux que notre cher Dr.Banner dopé aux rayons Gamma qui devient plus fort et plus violent lorsqu'il s'énerve..... Faites attention si vous entendez HULK SMASH");
                break;
            case "Agile":
                System.out.println("Je vous recommande Spider-Man\nEn effet qui de mieux que notre cher Araignée sympa du quartier avec ses lance toiles et ses acrobaties");
                break;
            default:
                System.out.println("Veuillez entrer une personalité incluse dans le choix ");
                break;
        }*/

        //Exercice 4


        /*System.out.println("Vous ne savez pas quoi faire de votre journée ? Pas de panique veuillez nous indiquez votre humeur actuelle parmis ces choix et nous vous proposerons une activité \nVotre Choix : ");
        String Humeur = scanner.nextLine();
        switch (Humeur.toLowerCase(Locale.ROOT)) {
            case "joyeux":
                System.out.println("Je vous recommande une petite balade dans le parc qui viens d'ouvrir près de chez vous");
                break;
            case "triste":
                System.out.println("Je vous recommande une petite journée Netflix and Chill avec un bon chocolat chaud");
                break;
            case "aventurier":
                System.out.println("Je vous recommande une petite randonné dans le sentier près de chez vous ");
                break;
            case "curieux":
                System.out.println("Je vous recommande une visite du musée d'histoire naturelle près de chez vous  ");

            default:
                System.out.println("Veuillez entrer une personalité incluse dans le choix ");
                break;
        }*/
    }






}