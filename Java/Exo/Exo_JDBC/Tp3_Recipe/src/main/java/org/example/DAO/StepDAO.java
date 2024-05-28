package org.example.DAO;

import org.example.entity.Step;
import org.example.util.DataBaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StepDAO extends BaseDAO<Step> {
    @Override
    public Step save(Step element) throws SQLException {
        try{
            connection = DataBaseManager.getConnection();
            request = "INSERT INTO step (description,id_recipe) VALUE (?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,element.getDescription());
            statement.setInt(2,element.getRecipe().getId());
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
    public boolean delete(Step element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "DELETE FROM step WHERE id =?";
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
    public Step update(Step element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "UPDATE step SET description=?, id_recipe=? WHERE id =?";
            statement = connection.prepareStatement(request);
            statement.setString(1, element.getDescription());
            statement.setInt(2, element.getRecipe().getId());
            statement.setInt(3, element.getId());

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
    public Step get(int id) throws SQLException {
        return null;
    }

    public List<Step> getByRecipeId(int id) throws SQLException{
        try {
            connection = DataBaseManager.getConnection();
            List<Step> steps = new ArrayList<>();
            request = "SELECT * FROM Step WHERE id_recipe = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                steps.add(Step.builder().description(resultSet.getString("description")).id(resultSet.getInt("id")).build());
            }
            return steps;
        }catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public List<Step> get() throws SQLException {
        try{
            List<Step> steps = new ArrayList<>();
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM step";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                steps.add(Step.builder().id(resultSet.getInt("id")).description(resultSet.getString("description")).build());
            }
            return steps;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
