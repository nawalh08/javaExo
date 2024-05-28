package org.example.DAO;

import org.example.entity.Categorie;
import org.example.entity.Ingredient;
import org.example.util.DataBaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO extends BaseDAO<Ingredient> {
    @Override
    public Ingredient save(Ingredient element) throws SQLException {
        try{
            connection = DataBaseManager.getConnection();
            request = "INSERT INTO ingredient (name) VALUE (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,element.getNom());
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
    public boolean delete(Ingredient element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "DELETE FROM ingredient WHERE id =?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, element.getId());
            if (statement.executeUpdate() == 1) {
                connection.commit();
                return true;
            }
            throw new SQLException();
        } catch (SQLException e) {
            connection.rollback();
            return false;
        } finally {
            close();
        }

    }




    @Override
    public Ingredient update(Ingredient element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "UPDATE ingredient SET name=? WHERE id =?";
            statement = connection.prepareStatement(request);
            statement.setString(1, element.getNom());
            statement.setInt(2, element.getId());
            if (statement.executeUpdate() == 1) {
                connection.commit();
                return element;
            }
            throw new SQLException();
        } catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }

    }


    @Override
    public Ingredient get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Ingredient> get() throws SQLException {
        try{
            List<Ingredient> ingredients = new ArrayList<>();
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM ingredient";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                ingredients.add(Ingredient.builder().id(resultSet.getInt("id")).nom(resultSet.getString("name")).build());
            }
            return ingredients;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
