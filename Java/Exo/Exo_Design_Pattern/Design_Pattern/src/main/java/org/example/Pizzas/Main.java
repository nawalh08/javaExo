package org.example.Pizzas;

public class Main {
    public static void main(String[] args) {
        String[] Ingredient = new String[] {"Jambon", "Origan", "Poivrons", "Champignon"};
        Pizza pizza = new Pizza.PizzaBuilder().fromage("Mozzarella").taille("Grande").type("Fine").sauce("Tomate").listeIngredient(Ingredient).build();

        System.out.println(pizza.toString());



    }
}