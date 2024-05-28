package org.example.DAO;

import org.example.entity.Meal;
import org.example.util.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MealDAO extends BaseDAO<Meal> {

    private AnimalDAO animalDAO;

    public MealDAO (){
        animalDAO = new AnimalDAO();
    }


    @Override
    public Meal save(Meal element) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO meal(description,meal_date,animal_id) VALUE (?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,element.getDescription());
            statement.setTimestamp(2, Timestamp.valueOf(element.getMealDate()));
            statement.setInt(3,element.getAnimal().getId());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(row != 1){
                throw new SQLException();
            }
            if(resultSet.next()){
                element.setId(resultSet.getInt(1));
            }
            connection.commit();
            return element;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public boolean delete(Meal element) throws SQLException {
        return false;
    }

    @Override
    public Meal update(Meal element) throws SQLException {
        return null;
    }

    @Override
    public Meal get(int id) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM meal WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                return Meal.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .mealDate(LocalDateTime.ofInstant(resultSet.getTimestamp("meal_date").toInstant(), ZoneId.of("UTC+2")))
                        .animal(animalDAO.get(resultSet.getInt("animal_id"))).build();
            }
            return null;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            close();
        }
    }

    @Override
    public List<Meal> get() throws SQLException {
        try{
            List<Meal> meals = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM meal";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                meals.add(Meal.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .mealDate(LocalDateTime.ofInstant(resultSet.getTimestamp("meal_date").toInstant(), ZoneId.of("UTC+2")))
                        .animal(animalDAO.get(resultSet.getInt("animal_id"))).build());
            }
            return meals;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }

    public List<Meal> getMealByAnimalId (int id_animal)throws SQLException{
        try{
            List<Meal> meals = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM meal WHERE animal_id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id_animal);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                meals.add(Meal.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .mealDate(LocalDateTime.ofInstant(resultSet.getTimestamp("meal_date").toInstant(), ZoneId.of("UTC+2")))
                        .animal(animalDAO.get(resultSet.getInt("animal_id"))).build());
            }
            return meals;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            close();
        }
    }
}
