package org.example.factory;

import org.example.entity.AbstractProductBuilder;
import org.example.entity.Product;

public class ComputerFactory extends ProductFactory {

    @Override
    public Product createProduct(AbstractProductBuilder computerBuilder) {return computerBuilder.build();
    }

}
