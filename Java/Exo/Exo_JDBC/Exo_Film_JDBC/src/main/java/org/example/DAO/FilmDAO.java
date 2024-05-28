package org.example.DAO;

import org.example.Entity.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String request;
    private ResultSet resultSet;


    public FilmDAO (Connection connection){
        this.connection = connection;
    }

    public Film createFilm (String nom , String color , int age) throws SQLException {
        request = "INSERT INTO plante (name,color,age) VALUE (?,?,?)";
        preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,nom);
        preparedStatement.setString(2,color);
        preparedStatement.setInt(3,age);
        preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        Film film = null;
        if(resultSet.next()){
            film = Film.builder().name(nom).color(color).age(age).id_plante(resultSet.getInt(1)).build();
        }

        return film;
    }

    public List<Film> getAllPlante () throws SQLException {
        List<Film> movies = new ArrayList<>();
        request = "SELECT * FROM movies";
        preparedStatement = connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            movies.add(Film.builder().id_plante(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .color(resultSet.getString("color"))
                    .age(resultSet.getInt("age"))
                    .build());
        }
        return movies;
    }
}
