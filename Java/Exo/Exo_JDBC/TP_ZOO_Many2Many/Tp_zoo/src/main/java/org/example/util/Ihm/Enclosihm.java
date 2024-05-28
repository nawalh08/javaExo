package org.example.util.Ihm;

import org.example.DAO.AnimalDAO;
import org.example.DAO.EnclosAnimalDAO;
import org.example.DAO.EnclosDAO;
import org.example.DAO.MealDAO;
import org.example.entity.Animal;
import org.example.entity.Enclos;
import org.example.entity.EnclosAnimal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Enclosihm {

    private Scanner scanner;

    private EnclosDAO enclosDAO;

    private EnclosAnimalDAO enclosAnimalDAO;


    public Enclosihm (Scanner scanner){
        this.scanner = scanner;
        enclosDAO = new EnclosDAO();
        enclosAnimalDAO = new EnclosAnimalDAO();

    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Menu enclos ---");
            System.out.println("1/ cree un enclos");
            System.out.println("2/ ajouter un animal dans un  enclos");
            System.out.println("3/ recupérer les animaux d'un enclos");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    createEnclos();
                    break;
                case 2 :
                    addToEnclos();
                    break;
                case 3 :
                    getAnimalFromEnclosId();
                    break;

                default:
                    return;
            }
        }
    }

    private void createEnclos (){
        System.out.println("-- creation d'un enclos --");
        System.out.println("nom de l'enclos :");
        String name = scanner.nextLine();


        Enclos enclos = Enclos.builder().nom(name).build();

        try {
            Enclos enclosCreated = enclosDAO.save(enclos);
            if(enclosCreated != null){
                System.out.println("animale cree "+ enclosCreated );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void addToEnclos(){
        System.out.println("--- Ajout d'un animal à un enclos");
        System.out.println("Veuillez choisir l'animal via son id ");
        int idani = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez choisir l'enclos ");
        int idenclos = scanner.nextInt();
        scanner.nextLine();

        EnclosAnimal enclosAnimal = EnclosAnimal.builder().id_animal(idani).id_enclos(idenclos).build();

        try {
            EnclosAnimal enclosAnimalCreated = enclosAnimalDAO.save(enclosAnimal);
            if(enclosAnimalCreated != null){
                System.out.println("animale cree "+ enclosAnimalCreated );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAnimalFromEnclosId(){
        System.out.println("Récupérer les animaux de l'enclos");
        int id = scanner.nextInt();
        scanner.nextLine();
        List<Animal> animals;
        try {
           animals  = enclosAnimalDAO.getAllCommandeByFleuristeId(id);
            if(animals != null){
                System.out.println("animaux recup ");
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Animal animal : animals){
            System.out.println(animal.toString());
        }

    }
}
