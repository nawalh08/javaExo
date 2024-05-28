package org.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Ingredient {

    private int id;

    private String nom;

    private int quantity;

    @Override
    public String toString() {
        return "Ingredient{" +
                ", nom='" + nom + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
