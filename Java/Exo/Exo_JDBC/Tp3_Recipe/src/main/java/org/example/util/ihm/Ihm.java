package org.example.util.ihm;

import org.example.entity.Recipe;

import java.util.Scanner;

public class Ihm {

    private Scanner scanner;

    private CategorieIhm categorieIhm;

    private IngredientIhm ingredientIhm;

    private RecipeIhm recipeIhm;

    private StepIhm stepIhm;

    private CommentaireIhm commentaireIhm;



    public Ihm (){
        scanner = new Scanner(System.in);
        categorieIhm = new CategorieIhm(scanner);
        ingredientIhm = new IngredientIhm(scanner);
        recipeIhm = new RecipeIhm(scanner);
        stepIhm = new StepIhm(scanner);
        commentaireIhm = new CommentaireIhm(scanner);


    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Application gestion de recette ---");
            System.out.println("1/ menu categorie");
            System.out.println("2/ menu Ingredient");
            System.out.println("3/ menu recette");
            System.out.println("4/ menu étape");
            System.out.println("5/ menu commentaire");

            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    categorieIhm.start();
                    break;
                case 2:
                    ingredientIhm.start();
                    break;
                case 3:
                    recipeIhm.start();
                    break;
                case 4:
                    stepIhm.start();
                    break;
                case 5:
                    commentaireIhm.start();
                    break;

                default:
                    return;
            }
        }
    }
}
