package org.example;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Chaise chaise1 = new Chaise("chaine",4,14.4,"bleu");
//        Chaise chaise2 = new Chaise();
//
//        System.out.println(chaise1.toString());
//        System.out.println(chaise2.toString());
//
//        Film film1 = new Film("La haine", "Mathieu Kassovitz",LocalDate.of(1995, 05, 31) , "Drame");
//
//        System.out.println(film1.toString());
//        Joueur warrior = new Joueur("WarriorDu59");
//
//        for (int compteur = 1; compteur < 21; compteur++) {
//            System.out.println("Le joueur effectue la quête n° " + compteur);
//            warrior.effectuerUneQuete();
//        }
//
//        warrior.setNom("LeGigaBossDuJava");
//
//        System.out.println(warrior.getNom());
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.

//        Thermo thermo = new Thermo(12.7);
//        System.out.println(thermo.toString());
//        System.out.println(thermo.getTemperatureCelcius());
//        System.out.println(thermo.getTemperatureFarenheit());
//        Thermo thermo1 = new Thermo(12.7, Thermo.UniteTemperature.Celcius);

        Plante rose = new Plante("Rose", 10.5 , "rouge");
        System.out.println(rose.toString());
        Arbre chene = new Arbre("Chêne" , 35, "Vert" , 10 );
        System.out.println(chene.toString());
        }
    }
