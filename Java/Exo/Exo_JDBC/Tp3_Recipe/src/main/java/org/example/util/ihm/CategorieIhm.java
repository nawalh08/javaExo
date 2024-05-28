package org.example.util.ihm;

import org.example.DAO.CategorieDAO;
import org.example.entity.Categorie;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CategorieIhm {

    private Scanner scanner;
    private CategorieDAO categorieDAO;


    public CategorieIhm (Scanner scanner){
        this.scanner = scanner;
        categorieDAO = new CategorieDAO();

    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Menu categorie ---");
            System.out.println("1/ cree une categorie");
            System.out.println("2/ recupérer les categories");
            System.out.println("3/ modifier une categorie");
            System.out.println("4/ supprimer une categorie");

            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    createCategorie();
                    break;
                case 2 :
                    getAllCategories();
                    break;
                case 3 :
                    updateCategorie();
                    break;
                case 4 :
                    deleteCategorie();
                    break;
                default:
                    return;
            }
        }
    }

    private void createCategorie (){
        System.out.println("-- creation de catégorie --");
        System.out.println("nom de la categorie :");
        String name = scanner.nextLine();


        Categorie categorie = Categorie.builder().nom(name).build();

        try {
            Categorie categorieCreated = categorieDAO.save(categorie);
            if(categorieCreated != null){
                System.out.println("categorie cree "+ categorieCreated );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void getAllCategories(){

            System.out.println("-- recuperation des categories --");
            try {
                List<Categorie> categories = categorieDAO.get();
                for(Categorie categorie : categories){
                        System.out.println(categorie);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    private void updateCategorie(){

        System.out.println("--- modification des categories ---");
        System.out.println("Veuillez entrer l'id de la categorie que vous voulez modifier");

        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Veuillez entrer le nouveau nom de la catégorie");

        String nom = scanner.nextLine();
        try{

            Categorie categorie = categorieDAO.update(Categorie.builder().id(id).nom(nom).build())  ;
            System.out.println("la catégorie a ete modifié  " + categorie);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    private void deleteCategorie(){
        System.out.println("--- suppression d'une categorie ---");
        System.out.println("Veuillez entrer l'id de la categorie que vous voulez supprimer");

        int id = scanner.nextInt();
        scanner.nextLine();


        try{

         boolean del =  categorieDAO.delete(Categorie.builder().id(id).build())  ;
            if(del){
                System.out.println("La catégorie à bien été supprimer");
            }else{

                System.out.println("Erreur lors de la suppression ");
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
    }



