package org.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Categorie {

    private int id;

    private String nom;

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}

