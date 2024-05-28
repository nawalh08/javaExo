package org.example.Pizzas;
import java.util.*;

public class Pizza {

   private String taille;

   private String type;

   private String fromage;

   private  ArrayList listeIngredient = new ArrayList<String>();

   private String sauce;

    private Pizza(PizzaBuilder builder) {
        //Affectation des attributs
//        this.marque = builder.marque;
//        this.model = builder.model;
//        this.annee = builder.annee;
        this.taille = builder.taille;
        this.type = builder.type;
        this.fromage = builder.fromage;
        this.sauce = builder.sauce;
        this.listeIngredient = builder.listeIngredient;
    }




    public static class PizzaBuilder {

        private String taille;

        private String type;

        private String fromage;

        private  ArrayList listeIngredient = new ArrayList<String>();

        private String sauce;
        public PizzaBuilder taille(String taille) {
            this.taille = taille;
            return this;
        }

        public PizzaBuilder type(String type) {
            this.type = type;
            return this;
        }

        public PizzaBuilder fromage(String fromage) {
            this.fromage = fromage;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder listeIngredient(String[] tab){
            for ( String o:tab){
                this.listeIngredient.add(o);
            }
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "taille='" + taille + '\'' +
                ", type='" + type + '\'' +
                ", fromage='" + fromage + '\'' +
                ", listeIngredient=" + listeIngredient +
                ", sauce='" + sauce + '\'' +
                '}';
    }
}
