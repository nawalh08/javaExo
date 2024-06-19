package org.example.api_json.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.api_json.model.Car;
import org.example.api_json.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarResource {

    private final CarService carService;

    @Inject
    public CarResource(CarService carService){
        this.carService = carService;
    }
    @GET
    @Path("/one")
    @Produces("application/json")
    public Car getOneCar(){
        return new Car(1,"polo",2014, "red");

    }

    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getListCars(){
        return carService.getCarList();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Car postCar(@QueryParam("brand") String brand, @QueryParam("fabrication") int fabrication, @QueryParam("color") String color){
        return carService.save(1 , "toyota", 2022, "rouge");
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car postCars(Car car){
        return carService.save(car.getId(), car.getBrand(), car.getFabrication(), car.getColor());

    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Car> postListCars(){
//        List<Car> carList = new ArrayList<>();
//        carList.add(new Car(2,"toyota", 2002, "yellow"));
//        carList.add(new Car(3,"nissan", 2023,"green"));
//        return carList;
//
//    }


    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car delete(@PathParam("id")int id){

        return carService.getCarList().remove(id-1);
    }

}
