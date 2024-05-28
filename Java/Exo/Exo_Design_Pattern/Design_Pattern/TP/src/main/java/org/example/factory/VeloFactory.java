package org.example.factory;

import org.example.entity.AbstractProductBuilder;
import org.example.entity.Product;

public class VeloFactory extends ProductFactory{

    @Override
    public Product createProduct(AbstractProductBuilder veloBuilder) {return veloBuilder.build();
    }
}
