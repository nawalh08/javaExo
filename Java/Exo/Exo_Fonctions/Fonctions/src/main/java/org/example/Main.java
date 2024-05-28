package org.example;

import java.util.Locale;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static  String nom(String nom,String prenom){
        System.out.println(nom + " " + prenom);
        return nom + " " +  prenom;
    }
    public static int soustraire(int valeur1, int valeur2){
        System.out.println("Je soustrait " + valeur1 + " et " + valeur2);
        System.out.println("Ce qui nous donne : " + (valeur1-valeur2));
        return (valeur1 - valeur2) ;
    }

    public static void quelleheure(String heure){



            System.out.println("Il est "+heure);

    }
    public static void quelleheure(){



        System.out.println("Il est 12h00");
    }


    public static int compter_lettre_a(String phrase){
        int compte = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if(phrase.toLowerCase(Locale.ROOT).charAt(i) == 'a'){
                compte++;
            }
        }
        System.out.println(compte);
        return compte;
    }

    public static boolean verificationAdn(String chaineAdn){
        for (int i = 0; i <chaineAdn.length() ; i++) {
            if(chaineAdn.toLowerCase(Locale.ROOT).charAt(i) != 'a' && chaineAdn.toLowerCase(Locale.ROOT).charAt(i) != 't' && chaineAdn.toLowerCase(Locale.ROOT).charAt(i) != 'c' && chaineAdn.toLowerCase(Locale.ROOT).charAt(i) != 'g' ){
                return false;
            }
        }
        return true;
    }

    public static String saisieChaineAdn(){
        System.out.println("Veuillez entrer votre chaine d'ADN");
        String chaine = scanner.nextLine();
        while(!verificationAdn(chaine)){
            System.out.println("Erreur Veuillez réesayer ");
            chaine = scanner.nextLine();
        }
        System.out.println(chaine);
        return chaine;
    }

    public static double occurence(String str, String target) {
        int occur = (str.length() - str.replace(target, "").length()) / target.length();
        return (double) occur * target.length() /str.length() * 100;

    }


    public static void main(String[] args) {

        nom("John","Doe");

        soustraire(2,1);

        quelleheure();
        quelleheure("14h00");

        compter_lettre_a("c'est le b-a ba");
        compter_lettre_a("mixer");
        compter_lettre_a("J'aime les pâtes au beurre avec un peu de fromage");
        String chaine =  saisieChaineAdn();
        String chaine2 =  saisieChaineAdn();

        double occur = occurence(chaine,chaine2);
        System.out.println(occur + " %");

    }
}