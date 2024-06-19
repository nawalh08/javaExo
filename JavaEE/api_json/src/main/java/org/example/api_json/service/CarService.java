package org.example.api_json.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.api_json.model.Car;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarService {

    List<Car> carList = new ArrayList<>();
    public  Car save(int id, String brand, int fabrication, String color){
        carList.add(new Car(id, brand, fabrication, color));
        return new Car(id, brand, fabrication, color);
    }

    public List<Car> getCarList() {
        return carList;
    }


}
