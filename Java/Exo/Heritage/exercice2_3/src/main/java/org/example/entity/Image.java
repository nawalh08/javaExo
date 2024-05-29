package org.example.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id ;
    private String url ;

}
