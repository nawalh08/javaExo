package org.example.DAO;

import org.example.entity.Categorie;
import org.example.util.DataBaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO extends BaseDAO<Categorie> {

    @Override
    public Categorie save(Categorie element) throws SQLException {
        try{
            connection = DataBaseManager.getConnection();
            request = "INSERT INTO categorie (name) VALUE (?)";
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
    public boolean delete(Categorie element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "DELETE FROM categorie WHERE id =?";
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
        public Categorie update(Categorie element) throws SQLException {
            try {
                connection = DataBaseManager.getConnection();
                request = "UPDATE categorie SET name=? WHERE id =?";
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
    public Categorie get(int id) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM categorie WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return (Categorie.builder().id(resultSet.getInt("id")).nom(resultSet.getString("name")).build()) ;
            }
        }catch (SQLException e){
            connection.rollback();
            return null;
        }finally {
            close();
        }
        return null;
    }

    @Override
    public List<Categorie> get() throws SQLException {
        try{
            List<Categorie> categories = new ArrayList<>();
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM categorie";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                categories.add(Categorie.builder().id(resultSet.getInt("id")).nom(resultSet.getString("name")).build());
            }
            return categories;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
