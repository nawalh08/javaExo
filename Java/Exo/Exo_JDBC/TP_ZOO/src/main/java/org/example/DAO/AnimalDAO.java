package org.example.DAO;

import org.example.Entity.Animal;
import org.example.Util.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO extends BaseDAO<Animal> {

    public AnimalDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Animal save(Animal element) throws SQLException {
        try {
            _connection = DataBaseManager.getConnection();
            request = "INSERT INTO Animaux (nom,race,descriptions,habitat,age) VALUE (?,?,?,?,?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, element.getNom());
            preparedStatement.setString(2, element.getRace());
            preparedStatement.setString(3, element.getDescription());
            preparedStatement.setString(4, element.getHabitat());
            preparedStatement.setInt(5, element.getAge());
            int nbrow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            Animal animal = null;
            if (resultSet.next()) {
                animal = Animal.builder().nom(element.getNom()).race(element.getRace()).description(element.getDescription()).habitat(element.getHabitat()).age(element.getAge()).build();
            }
            if (nbrow != 1) {
                _connection.rollback();
            }
            _connection.commit();
            return animal;
        } catch (SQLException e) {
            _connection.rollback();
            return null;
        } finally {
            close();
        }

    }

    @Override
    public Animal update(Animal element) throws SQLException {
        try {
            _connection = DataBaseManager.getConnection();
            request = "UPDATE Animaux SET nom=?, race = ?, descriptions = ?, habitat =?, age =? WHERE animal_id =?";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, element.getNom());
            preparedStatement.setString(2, element.getRace());
            preparedStatement.setString(3, element.getDescription());
            preparedStatement.setString(4, element.getHabitat());
            preparedStatement.setInt(5, element.getAge());
            preparedStatement.setInt(6, element.getId_animal());
            resultSet = preparedStatement.getGeneratedKeys();
            if (preparedStatement.executeUpdate() == 1) {
                _connection.commit();
                Animal animal = Animal.builder().nom(element.getNom()).race(element.getRace()).description(element.getDescription()).habitat(element.getHabitat()).age(element.getAge()).build();
                return animal;
            }
            throw new SQLException();
        } catch (SQLException e) {
            _connection.rollback();
            return null;
        } finally {
            close();
        }

    }

    public Animal getById(int id) throws SQLException {

        try {
            _connection = DataBaseManager.getConnection();
            request = "SELECT * FROM Animaux WHERE animal_id = ?";
            preparedStatement = _connection.prepareStatement(request);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (Animal.builder().id_animal(id).nom(resultSet.getString("nom"))
                        .race(resultSet.getString("race"))
                        .description(resultSet.getString("descriptions"))
                        .habitat(resultSet.getString("habitat")).age(resultSet.getInt("age")).build());
            }
        }catch (SQLException e){
            close();

        }

            return null;



    }


    @Override
    public List<Animal> getByName(String name) throws SQLException {
        List<Animal> animals = new ArrayList<>();
        try{
            _connection = DataBaseManager.getConnection();
            request = "SELECT * FROM Animaux WHERE nom = ?";
            preparedStatement = _connection.prepareStatement(request);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                animals.add(Animal.builder().nom(resultSet.getString("nom"))
                        .race(resultSet.getString("race"))
                        .description(resultSet.getString("descriptions"))
                        .habitat(resultSet.getString("habitat")).age(resultSet.getInt("age")).build());
            }
            return animals;
        }catch (SQLException e){
            return  null;
        }finally {
            close();
        }
    }
    @Override
    public List<Animal> getByHabitat(String habitat) throws SQLException {
        List<Animal> animalsH = new ArrayList<>();
        try{
            _connection = DataBaseManager.getConnection();
            request = "SELECT * FROM Animaux WHERE habitat = ?";
            preparedStatement = _connection.prepareStatement(request);
            preparedStatement.setString(1,habitat);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                animalsH.add(Animal.builder().nom(resultSet.getString("nom"))
                        .race(resultSet.getString("race"))
                        .description(resultSet.getString("descriptions"))
                        .habitat(resultSet.getString("habitat")).age(resultSet.getInt("age")).build());
            }
            return animalsH;
        }catch (SQLException e){
            return  null;
        }finally {
            close();
        }
    }
    @Override
    public List<Animal> getByRace(String race) throws SQLException {
        List<Animal> animalsR = new ArrayList<>();
        try{
            _connection = DataBaseManager.getConnection();
            request = "SELECT * FROM Animaux WHERE race = ?";
            preparedStatement = _connection.prepareStatement(request);
            preparedStatement.setString(1,race);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                animalsR.add(Animal.builder().nom(resultSet.getString("nom"))
                        .race(resultSet.getString("race"))
                        .description(resultSet.getString("descriptions"))
                        .habitat(resultSet.getString("habitat")).age(resultSet.getInt("age")).build());
            }
            return animalsR;
        }catch (SQLException e){
            return  null;
        }finally {
            close();
        }
    }
    @Override
    public List<Animal> getByAge(int age) throws SQLException {
        List<Animal> animalsA = new ArrayList<>();
        try{
            _connection = DataBaseManager.getConnection();
            request = "SELECT * FROM Animaux WHERE age = ?";
            preparedStatement = _connection.prepareStatement(request);
            preparedStatement.setInt(1,age);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                animalsA.add(Animal.builder().nom(resultSet.getString("nom"))
                        .race(resultSet.getString("race"))
                        .description(resultSet.getString("descriptions"))
                        .habitat(resultSet.getString("habitat")).age(resultSet.getInt("age")).build());
            }
            return animalsA;
        }catch (SQLException e){
            return  null;
        }finally {
            close();
        }
    }



}
