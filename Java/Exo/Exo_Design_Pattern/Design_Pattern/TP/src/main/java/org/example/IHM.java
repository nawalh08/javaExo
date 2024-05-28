package org.example;

import org.example.entity.Computer;
import org.example.entity.Phone;
import org.example.entity.Product;
import org.example.entity.Velo;
import org.example.factory.ComputerFactory;
import org.example.factory.PhoneFactory;
import org.example.factory.VeloFactory;

import java.util.*;

public class IHM {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> myList = new ArrayList<Product>();


    public static void Start(){
        int choix = -1;


        do {
            System.out.println("Bienvenue dans la boutique de Fares\nEntrez 1 pour créer un Ordinateur.\nEntrez 2 pour créer un Velo\nEntrez 3 pour créer un Téléphone\nEntrez 4 pour afficher la liste de produit\nEntrez 0 pour quitter : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix){
                case 1:
                    choixOne();
                    break;
                case 2:
                    choixTwo();
                    break;
                case 3:
                    choixThree();
                    break;
                case 4:
                    choixFour();
                    break;
                case 0:
                    System.out.println("Au revoir !!!");
                    break;
                default:
                    System.out.println("Choix invalide !!!!");

            }

        }while(choix!=0);

        System.out.println("Vous avez quitter la boutique nous vous souhaitons une bonne journée");



    }
    public static void choixThree(){
        System.out.println("Pour commencer veuillez entrez le nom du modèle de téléphone :");
        String modele = scanner.nextLine();
        System.out.println("Veuillez indiquer le processeur de téléphone :");
        String processeur = scanner.nextLine();
        System.out.println("Veuillez indiquer la mémoire du téléphone :");
        int memoire = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez indiquer la couleur du téléphone :");
        String couleur = scanner.nextLine();
        Product Telephone = new PhoneFactory().createProduct(new Phone.PhoneBuilder().couleur(couleur).intitule(modele).memoire(memoire).processeur(processeur));
        myList.add(Telephone);

    }
    public static void choixOne(){
        System.out.println("Pour commencer veuillez entrez le nom du modèle du PC :");
        String modele = scanner.nextLine();
        System.out.println("Veuillez indiquer le processeur du PC :");
        String processeur = scanner.nextLine();
        System.out.println("Veuillez indiquer la mémoire du PC : ");
        int memoire = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez indiquer la couleur du PC :");
        String couleur = scanner.nextLine();
        Product PC = new ComputerFactory().createProduct(new Computer.ComputerBuilder().couleur(couleur).intitule(modele).memoire(memoire).processeur(processeur));
        myList.add(PC);
    }
    public static void choixTwo(){
        System.out.println("Pour commencer veuillez entrez le nom du modèle du Velo :");
        String modele = scanner.nextLine();
        System.out.println("Veuillez indiquer le nombre de roue sur le Velo :");
        int nbRoue = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez indiquer la couleur du Velo :");
        String couleur = scanner.nextLine();
        Product Velo = new VeloFactory().createProduct(new Velo.VeloBuilder().couleur(couleur).modele(modele).nbRoue(nbRoue));
        myList.add(Velo);
    }

    public static void choixFour(){
        for (Product p : myList){
            System.out.println(p.toString());
        }
    }
}
