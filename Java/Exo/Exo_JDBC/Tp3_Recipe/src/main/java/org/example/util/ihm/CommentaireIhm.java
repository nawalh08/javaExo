package org.example.util.ihm;

import org.example.DAO.CommentaireDAO;
import org.example.DAO.RecipeDAO;
import org.example.DAO.StepDAO;
import org.example.entity.Commentaire;
import org.example.entity.Recipe;
import org.example.entity.Step;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CommentaireIhm {

    private Scanner scanner;
    private RecipeDAO recipeDAO;

    private CommentaireDAO commentaireDAO;


    public CommentaireIhm(Scanner scanner) {
        this.scanner = scanner;
        recipeDAO = new RecipeDAO();
        commentaireDAO = new CommentaireDAO();

    }

    public void start() {
        int entry;
        while (true) {
            System.out.println("--- Menu Commentaire ---");
            System.out.println("1/ cree un commentaire");
            System.out.println("2/ recupérer les commentaires");
            System.out.println("3/ modifier un commentaire");
            System.out.println("4/ supprimer un commentaire");

            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry) {
                case 1:
                    createCommentaire();
                    break;
                case 2:
                    getAllCommentaire();
                    break;
                case 3:
                    updateCommentaire();
                    break;
                case 4:
                    deleteCommentaire();
                    break;
                default:
                    return;
            }
        }
    }

    private void deleteCommentaire() {
        System.out.println("--- suppression d'un commentaire ---");
        System.out.println("Veuillez entrer l'id du commentaire que vous voulez supprimer");

        int id = scanner.nextInt();
        scanner.nextLine();


        try{

            boolean del =  commentaireDAO.delete(Commentaire.builder().id(id).build())  ;
            if(del){
                System.out.println("Le commentaire à bien été supprimer");
            }else{

                System.out.println("Erreur lors de la suppression ");
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void updateCommentaire() {
        System.out.println("-- modification de commentaire --");
        System.out.println("id du commentaire");
        int id_step = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Commentaire :");
        String description = scanner.nextLine();

        System.out.println("id de la recette");
        getAllRecipe();
        int id_recipe = scanner.nextInt();
        scanner.nextLine();

        try{

            Commentaire commentaire = commentaireDAO.update(Commentaire.builder().description(description).recipe(recipeDAO.get(id_recipe)).id(id_step).build())  ;
            System.out.println("l'étape a ete modifié  " + commentaire);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void getAllCommentaire() {

        System.out.println("-- recuperation des commentaires --");
        try {
            List<Commentaire> commentaires = commentaireDAO.get();
            for(Commentaire commentaire : commentaires){
                System.out.println(commentaire);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createCommentaire() {

        System.out.println("-- creation de commentaire --");
        System.out.println("Commentaire :");
        String commentaire = scanner.nextLine();
        getAllRecipe();
        System.out.println("id de la recette");
        int id_recipe = scanner.nextInt();
        scanner.nextLine();

        try {
            Commentaire comment = Commentaire.builder().description(commentaire).recipe(recipeDAO.get(id_recipe)).build();
            Commentaire commentaireCreated = commentaireDAO.save(comment);
            if(commentaireCreated != null){
                System.out.println("commentaire cree "+ commentaireCreated );
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
