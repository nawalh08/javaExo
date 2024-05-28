package org.example.entity;

import lombok.Builder;
import lombok.Data;
import org.example.util.ihm.RecipeIhm;

@Data
@Builder

public class Step {

    private int id;

    private String description;

    private Recipe recipe;

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
