package org.example.Classe;

public class StockManager implements Observer{

    @Override
    public void update(Product product) {
        System.out.println("Attention le stock à été modifié .\n Le stock actuel du produit est de  "+product.getStockLevel());
    }
}
