package org.example.util.ihm;

import org.example.DAO.CategorieDAO;
import org.example.DAO.IngredientDAO;
import org.example.DAO.IngredientRecipeDAO;
import org.example.entity.Categorie;
import org.example.entity.Ingredient;
import org.example.entity.IngredientRecipe;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class IngredientIhm {

    private Scanner scanner;
    private IngredientDAO ingredientDAO;
    



    public IngredientIhm (Scanner scanner){
        this.scanner = scanner;
        ingredientDAO = new IngredientDAO();


    }
    public void start () {
        int entry;
        while (true) {
            System.out.println("--- Menu Ingredient ---");
            System.out.println("1/ cree un ingredient");
            System.out.println("2/ recupérer les ingredient");
            System.out.println("3/ modifier un ingredient");
            System.out.println("4/ supprimer un ingredient");


            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry) {
                case 1:
                    createIngredient();
                    break;
                case 2:
                    getAllIngredient();
                    break;
                case 3:
                    updateIngredient();
                    break;
                case 4:
                    deleteIngredient();
                    break;

                default:
                    return;
            }
        }
    }



    private void createIngredient(){
            System.out.println("-- creation d'ingredient --");
            System.out.println("nom de l'ingredient :");
            String name = scanner.nextLine();


            Ingredient ingredient = Ingredient.builder().nom(name).build();

            try {
                Ingredient ingredientCreated = ingredientDAO.save(ingredient);
                if(ingredientCreated != null){
                    System.out.println("ingredient cree "+ ingredientCreated );
                }else{
                    System.out.println("erreure lors de la creation");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        private void getAllIngredient(){

            System.out.println("-- recuperation des ingredients --");
            try {
                List<Ingredient> ingredients = ingredientDAO.get();
                for(Ingredient ingredient : ingredients){
                    System.out.println(ingredient);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        private void updateIngredient(){

            System.out.println("--- modification des ingredients ---");
            System.out.println("Veuillez entrer l'id de l'ingredient que vous voulez modifier");

            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Veuillez entrer le nouveau nom de l'ingredient");

            String nom = scanner.nextLine();
            try{

                Ingredient ingredient = ingredientDAO.update(Ingredient.builder().id(id).nom(nom).build())  ;
                System.out.println("l'ingredient a ete modifié  " + ingredient);
            }catch(SQLException e){
                throw new RuntimeException(e);
            }

        }

        private void deleteIngredient(){
            System.out.println("--- suppression d'un ingredient ---");
            System.out.println("Veuillez entrer l'id de l'ingredient que vous voulez supprimer");

            int id = scanner.nextInt();
            scanner.nextLine();


            try{

                boolean del =  ingredientDAO.delete(Ingredient.builder().id(id).build())  ;
                if(del){
                    System.out.println("L'ingredient à bien été supprimer");
                }else{

                    System.out.println("Erreur lors de la suppression ");
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }

        }
    }

