package org.example.Entity;


import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String nom;
    protected double price;


    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", price=" + price +
                '}';
    }
}
