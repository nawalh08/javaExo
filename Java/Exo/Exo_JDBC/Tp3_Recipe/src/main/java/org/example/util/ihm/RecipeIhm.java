package org.example.util.ihm;

import org.example.DAO.CategorieDAO;
import org.example.DAO.IngredientDAO;
import org.example.DAO.IngredientRecipeDAO;
import org.example.DAO.RecipeDAO;
import org.example.entity.Categorie;
import org.example.entity.Ingredient;
import org.example.entity.IngredientRecipe;
import org.example.entity.Recipe;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class RecipeIhm {

    private Scanner scanner;
    private RecipeDAO recipeDAO;

    private CategorieDAO categorieDAO;


    private IngredientRecipeDAO ingredientRecipeDAO;

    private IngredientDAO ingredientDAO;

    public RecipeIhm (Scanner scanner){
        this.scanner = scanner;
        recipeDAO = new RecipeDAO();
        categorieDAO = new CategorieDAO();
        ingredientRecipeDAO = new IngredientRecipeDAO();
        ingredientDAO = new IngredientDAO();

    }

    public void start () {
        int entry;
        while (true) {
            System.out.println("--- Menu Recette ---");
            System.out.println("1/ cree une recette");
            System.out.println("2/ recupérer les recette");
            System.out.println("3/ modifier une recette");
            System.out.println("4/ supprimer une recette");
            System.out.println("5/ Ajouter un ingrédient à une recette");
            System.out.println("6/ Récupérer les ingredients d'une recette");

            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry) {
                case 1:
                    createRecipe();
                    break;
                case 2:
                    getAllRecipe();
                    break;
                case 3:
                    updateRecipe();
                    break;
                case 4:
                    deleteRecipe();
                    break;
                case 5:
                    addToRecipe();
                    break;
                case 6 :
                    getIngredientOfRecipe();
                default:
                    return;
            }
        }
    }

    private void getIngredientOfRecipe() {


        System.out.println("-- recuperation des recettes --");
        System.out.println("Id de la recette");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            List<Ingredient> ingrs = ingredientRecipeDAO.getByRecipeId(id);
            for(Ingredient ingr : ingrs){
                System.out.println(ingr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addToRecipe() {

        System.out.println("--- ajout d'un ingrédient dans une recette");

        getAllRecipe();

        System.out.println("id recette : ");

        int id_recipe = scanner.nextInt();
        scanner.nextLine();

        getAllIngredient();
        System.out.println("id ingredient");
        int id_ingredient = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Quantité");
        String quantity = scanner.nextLine();

        try {
            IngredientRecipe ingredientRecipe = IngredientRecipe.builder().id_ingredient(id_ingredient).id_recipe(id_recipe).quantite(quantity).build();
            IngredientRecipe ingredientRecipeCreated = ingredientRecipeDAO.save(ingredientRecipe);
            if(ingredientRecipeCreated != null){
                System.out.println("Lien créer :  "+ ingredientRecipeCreated );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteRecipe() {
        System.out.println("--- suppression d'une recette ---");
        System.out.println("Veuillez entrer l'id de la recette que vous voulez supprimer");

        int id = scanner.nextInt();
        scanner.nextLine();


        try{

            boolean del =  recipeDAO.delete(Recipe.builder().id(id).build())  ;
            if(del){
                System.out.println("La recette à bien été supprimer");
            }else{

                System.out.println("Erreur lors de la suppression ");
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void updateRecipe() {

        System.out.println("-- modification de recette --");
        System.out.println("id de la recette");
        int id_recipe = scanner.nextInt();
        scanner.nextLine();
        System.out.println("nom de la recette :");
        String name = scanner.nextLine();
        System.out.println("temps de préparation");
        int prepTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("temps de cuisson");
        int cuissonTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("diffculte");
        int difficulte = scanner.nextInt();
        scanner.nextLine();
        System.out.println("id de la catégorie de cuisine");
        getAllCategories();
        int categorieId = scanner.nextInt();
        scanner.nextLine();

        try{

            Recipe recipe = recipeDAO.update(Recipe.builder().id(id_recipe).name(name).tempsPrep(prepTime).tempsCuisson(cuissonTime).difficulte(difficulte).categorie(categorieDAO.get(categorieId)).build())  ;
            System.out.println("l'ingredient a ete modifié  " + recipe);
        }catch(SQLException e){
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

    private void createRecipe(){
        System.out.println("-- creation de recette --");
        System.out.println("nom de la recette :");
        String name = scanner.nextLine();
        System.out.println("temps de préparation");
        int prepTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("temps de cuisson");
        int cuissonTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("diffculte");
        int difficulte = scanner.nextInt();
        scanner.nextLine();
        System.out.println("id de la catégorie de cuisine");
        getAllCategories();
        int categorieId = scanner.nextInt();
        scanner.nextLine();




        try {
            Recipe recipe = Recipe.builder().name(name).tempsPrep(prepTime).tempsCuisson(cuissonTime).difficulte(difficulte).categorie(categorieDAO.get(categorieId)).build();
            Recipe recipeCreated = recipeDAO.save(recipe);
            if(recipeCreated != null){
                System.out.println("recette cree "+ recipeCreated );
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


}
