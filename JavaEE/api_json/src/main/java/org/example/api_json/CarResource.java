package org.example.api_json;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarResource {
    @GET
    @Path("/one")
    @Produces("application/json")
    public Car getOneCar(){
        return new Car(1,"polo",2014, "red");

    }

    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getListCars(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(2,"toyota", 2002, "yellow"));
        carList.add(new Car(3,"nissan", 2023,"green"));
        return carList;

    }
}
