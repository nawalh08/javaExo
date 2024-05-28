package org.example.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Animal {

    private int id_animal;

    private String nom;

    private String race;

    private String description;

    private String habitat;

    private int age;

    @Override
    public String toString() {
        return "Animal{" +
                "id_animal=" + id_animal +
                ", nom='" + nom + '\'' +
                ", race='" + race + '\'' +
                ", description='" + description + '\'' +
                ", habitat='" + habitat + '\'' +
                ", age=" + age +
                '}';
    }
}
