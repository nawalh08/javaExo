package org.example.util.ihm;

import org.example.DAO.IngredientDAO;
import org.example.DAO.RecipeDAO;
import org.example.DAO.StepDAO;
import org.example.entity.Recipe;
import org.example.entity.Step;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StepIhm {

    private Scanner scanner;
    private RecipeDAO recipeDAO;

    private StepDAO stepDAO;


    public StepIhm (Scanner scanner){
        this.scanner = scanner;
        recipeDAO = new RecipeDAO();
        stepDAO = new StepDAO();

    }

    public void start () {
        int entry;
        while (true) {
            System.out.println("--- Menu Etape ---");
            System.out.println("1/ cree une étape");
            System.out.println("2/ recupérer les étapes");
            System.out.println("3/ modifier une étape");
            System.out.println("4/ supprimer une étape");
            System.out.println("5/ recupere les étaps d'une recette");

            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry) {
                case 1:
                    createStep();
                    break;
                case 2:
                    getAllSteps();
                    break;
                case 3:
                    updateStep();
                    break;
                case 4:
                    deleteStep();
                    break;
                case 5:
                    getStepByIdRecipe();
                    break;
                default:
                    return;
            }
        }
    }

    private void getStepByIdRecipe() {

        System.out.println("--- obtention des étapes d'une recette --");
        System.out.println("Veuillez entrer l'id de la recette pour obtenire les étapesr");

        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            List<Step> steps = stepDAO.getByRecipeId(id);
            if(steps != null) {
                for (Step step : steps) {
                    System.out.println(step);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteStep() {

        System.out.println("--- suppression d'une étape ---");
        System.out.println("Veuillez entrer l'id de l'étape que vous voulez supprimer");

        int id = scanner.nextInt();
        scanner.nextLine();


        try{

            boolean del =  stepDAO.delete(Step.builder().id(id).build())  ;
            if(del){
                System.out.println("L'étape à bien été supprimer");
            }else{

                System.out.println("Erreur lors de la suppression ");
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void updateStep() {
        System.out.println("-- modification d'étape --");
        System.out.println("id de l'étape");
        int id_step = scanner.nextInt();
        scanner.nextLine();
        System.out.println("description de l'étape :");
        String description = scanner.nextLine();

        System.out.println("id de la recette");
        getAllRecipe();
        int id_recipe = scanner.nextInt();
        scanner.nextLine();

        try{

            Step step = stepDAO.update(Step.builder().description(description).recipe(recipeDAO.get(id_recipe)).id(id_step).build())  ;
            System.out.println("l'étape a ete modifié  " + step);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void getAllSteps() {
        System.out.println("-- recuperation des étapes --");
        try {
            List<Step> steps = stepDAO.get();
            for(Step step : steps){
                System.out.println(step);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createStep() {

        System.out.println("-- creation d'étape --");
        System.out.println("description de l'étape :");
        String description = scanner.nextLine();
        getAllRecipe();
        System.out.println("id de la recette");
        int id_recipe = scanner.nextInt();
        scanner.nextLine();

        try {
            Step step = Step.builder().description(description).recipe(recipeDAO.get(id_recipe)).build();
            Step stepCreated = stepDAO.save(step);
            if(stepCreated != null){
                System.out.println("étape cree "+ stepCreated );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAllRecipe() {
        System.out.println("-- recuperation des recettes --");
        try {
            List<Recipe> recipes = recipeDAO.get();
            for(Recipe recipe : recipes){
                System.out.println(recipe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
