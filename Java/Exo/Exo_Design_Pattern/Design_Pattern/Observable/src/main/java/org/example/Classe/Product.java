package org.example.Classe;

public class Product {
    public int stockLevel;
    public Product(ProductBuilder builder) {
     stockLevel = builder.stockLevel;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public static class ProductBuilder {
        public int stockLevel;

        public ProductBuilder stockLevel(int stockLevel) {
            this.stockLevel = stockLevel;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }
}
