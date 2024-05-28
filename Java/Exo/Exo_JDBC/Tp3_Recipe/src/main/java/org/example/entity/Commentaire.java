package org.example.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Commentaire {

    private int id;

    private String description;

    private Recipe recipe;

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
