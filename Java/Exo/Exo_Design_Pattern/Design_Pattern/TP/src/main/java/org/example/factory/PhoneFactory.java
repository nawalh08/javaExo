package org.example.factory;

import org.example.entity.AbstractProductBuilder;
import org.example.entity.Product;

public class PhoneFactory extends ProductFactory{
    @Override
    public Product createProduct(AbstractProductBuilder phoneBuilder) {return phoneBuilder.build();
    }
}
