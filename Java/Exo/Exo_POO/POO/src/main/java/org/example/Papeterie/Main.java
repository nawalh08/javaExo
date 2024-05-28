package org.example.Papeterie;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Stylo stylo1 = new Stylo(1,"Stylo Plume",2.50,"Bleu");
        Stylo stylo2 = new Stylo(2,"Stylo Encre",2.75,"Rouge");
        Stylo stylo3 = new Stylo(3,"Stylo Effaceur",2.25,"Noir");

        HashMap<Integer, ArticleUnitaire> hashMap = new HashMap<>();
        hashMap.put(stylo1.reference,stylo1);
        hashMap.put(stylo2.reference,stylo2);
        hashMap.put(stylo3.reference,stylo3);

        System.out.println("\nHashMap : "+ hashMap);

        Ligne test = new Ligne(1,50,0, hashMap.get(1).nom);
        test.prixUnique = stylo1.prixUni;
        test.prixTotal= test.qte*hashMap.get(test.reference).prixUni;
        Ligne test2 = new Ligne(2,50,0, hashMap.get(2).nom);
        test2.prixUnique = hashMap.get(2).prixUni;
        test2.prixTotal= test2.qte*hashMap.get(test2.reference).prixUni;
        Ligne test3 = new Ligne(3,50,0, hashMap.get(3).nom);
        test3.prixUnique = stylo3.prixUni;
        test3.prixTotal= test3.qte*hashMap.get(test3.reference).prixUni;

        System.out.println(test.toString());
        System.out.println(test2.toString());
        System.out.println(test3.toString());

        Facture facture1 = new Facture("John Doe",3,"20/04/2001");
        facture1.ajouterLigne(test);
        facture1.ajouterLigne(test2);
        facture1.ajouterLigne(test3);
        System.out.println(facture1.toString());

        System.out.println(facture1.getPrixTotal());

//
    }
}

