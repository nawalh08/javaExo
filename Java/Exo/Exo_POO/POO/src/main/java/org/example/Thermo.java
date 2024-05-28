package org.example;

import java.time.LocalDate;

public class Thermo {

    public enum UniteTemperature {
        Kelvin,Celcius,Farenheit
    };
    private double temperature;






    public Thermo(double temperatureKelvin) {
        this.temperature = temperatureKelvin;
    }
    public Thermo(double temperature, UniteTemperature unit) {
        this.temperature = temperature;
    }

    public void setTemperatureCelcius(double temp) {
        this.temperature = temp + 273.15;
    }
    public double getTemperatureCelcius() {
        return this.temperature - 273.15;
    }
    public void setTemperatureFarenheit(double temp) {
        this.temperature =  (temp - 32) * 5/9 + 273.15;

    }
    public double getTemperatureFarenheit() {
        return  ((this.temperature - 273.15) * 9/5 + 32);
    }
    public void setTemperatureKelvin( double temp) {
        this.temperature = temp;
    }
    public double getTemperatureKelvin() {
        return this.temperature ;
    }

    public String toString(){
        return("Valeur : " + this.temperature);
    }






}
