package org.example;

import org.example.DAO.AnimalDAO;
import org.example.DAO.RepasDAO;
import org.example.Entity.Animal;
import org.example.Entity.Repas;
import org.example.Util.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {


       Scanner scanner = new Scanner(System.in);

//        System.out.println("Veuillez entrer le nom ");
//
//        String nom = scanner.nextLine();
//        System.out.println("Veuillez entrer la race ");
//
//        String race = scanner.nextLine();
//        System.out.println("Veuillez entrer la description ");
//
//        String description = scanner.nextLine();
//        System.out.println("Veuillez entrer l'habitat ");
//
//        String habitat = scanner.nextLine();
//        System.out.println("Veuillez entrer l'age ");
//
//        int age  = scanner.nextInt();

//        scanner.nextLine();

       Connection connection = DataBaseManager.getConnection();
      AnimalDAO animalDAO = new AnimalDAO(connection);
//        try{
//
//            Animal animal = animalDAO.save(Animal.builder().nom(nom).description(description).race(race).habitat(habitat).age(age).build())  ;
//            System.out.println("la plante a ete cree" + animal);
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("id de le animal :");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Veuillez entrer le nom ");
//
//         nom = scanner.nextLine();
//        System.out.println("Veuillez entrer la race ");
//
//         race = scanner.nextLine();
//        System.out.println("Veuillez entrer la description ");
//
//         description = scanner.nextLine();
//        System.out.println("Veuillez entrer l'habitat ");
//
//         habitat = scanner.nextLine();
//        System.out.println("Veuillez entrer l'age ");
//
//         age  = scanner.nextInt();
//
//        scanner.nextLine();
//
//
//        try{
//
//            Animal animal = animalDAO.update(Animal.builder().nom(nom).description(description).race(race).habitat(habitat).age(age).id_animal(id).build())  ;
//            System.out.println("l'animal a ete modifié" + animal);
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//
//               System.out.println("Nom de l'animal :");
//        String nom2 = scanner.nextLine();
//
//        try {
//            List<Animal> films = animalDAO.getByName(nom2);
//            for(Animal film : films){
//                System.out.println(film);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Race de l'animal :");
//        String Race = scanner.nextLine();
//
//        try {
//            List<Animal> AnimauxRace = animalDAO.getByRace(Race);
//            for(Animal film : AnimauxRace){
//                System.out.println(film);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Habitat de l'animal :");
//        String Habitat = scanner.nextLine();
//
//        try {
//            List<Animal> AnimauxHabitat = animalDAO.getByHabitat(Habitat);
//            for(Animal film : AnimauxHabitat){
//                System.out.println(film);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Age de l'animal :");
//        int age2 = scanner.nextInt();
//        scanner.nextLine();
//
//        try {
//            List<Animal> films = animalDAO.getByAge(age2);
//            for(Animal film : films){
//                System.out.println(film);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }




        LocalDateTime dateAujourdhui = LocalDateTime.now(ZoneId.of("UTC+2"));        ;
        System.out.println(dateAujourdhui);

        RepasDAO repasDAO = new RepasDAO(connection,animalDAO);

        System.out.println("-- ajout de repas --");

        LocalDate localDate = LocalDate.now();

        System.out.println("details de la bouffe");
        String details = scanner.nextLine();
        System.out.println("id de l'animal :");
        int idAnimal = scanner.nextInt();
        scanner.nextLine();

        try {
            Repas repas = Repas.builder().date(localDate).details(details).animal(animalDAO.getById(idAnimal)).build();
            System.out.println(repas);
            Repas repasCreated = repasDAO.save(repas);
            System.out.println("le repas commande a ete cree" + repasCreated);
            System.out.println("id de l'animal :");
            int idAnimal2 = scanner.nextInt();
            scanner.nextLine();
            List<Repas> repas1 = repasDAO.getByIdAnimal(idAnimal2);
            System.out.println("Les repas de l'animal ayant l'id " + idAnimal2 + " sont");
            for (Repas r : repas1){
                System.out.println(r.toString());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}