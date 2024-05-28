package org.example.Entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Data
@Builder


public class Repas {

    private int id_repas;

    private LocalDate date;

    private String details;

    private Animal animal;

    @Override
    public String toString() {
        return "Repas{" +

                ", date=" + date +
                ", details='" + details + '\'' +

                '}';
    }
}
