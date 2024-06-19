package org.example.api_json;

import java.time.LocalDate;

public class Car {
    private int id ;
    private String brand ;
    private int fabrication ;
    private String color;

    public Car(int id, String brand, int fabrication, String color) {
        this.id = id;
        this.brand = brand;
        this.fabrication = fabrication;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getFabrication() {
        return fabrication;
    }

    public void setFabrication(int fabrication) {
        this.fabrication = fabrication;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", fabrication=" + fabrication +
                ", color='" + color + '\'' +
                '}';
    }
}
