package org.example.entity;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class Recipe {

    private int id;

    private String name;

    private int tempsCuisson;

    private int tempsPrep;

    private int difficulte;


    private List<Ingredient> ingredients;

    private List<Step> steps;

    private List<Commentaire> commentaire;

    private Categorie categorie;

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ",\n name='" + name + '\'' +
                ",\n tempsCuisson=" + tempsCuisson +
                ",\n tempsPrep=" + tempsPrep +
                ",\n difficulte=" + difficulte +
                ",\n ingredients=" + ingredients +
                ",\n steps=" + steps +
                ",\n commentaire='" + commentaire + '\'' +
                ",\n categorie='" + categorie + '\'' +
                '}';
    }
}
