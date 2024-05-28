package org.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class IngredientRecipe {

    private int id;

    private int id_recipe;

    private int id_ingredient;

    private String quantite;
}
