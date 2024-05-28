package org.example.DAO;

import org.example.entity.Commentaire;
import org.example.entity.Step;
import org.example.util.DataBaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentaireDAO extends BaseDAO<Commentaire>{

    @Override
    public Commentaire save(Commentaire element) throws SQLException {
        try{
            connection = DataBaseManager.getConnection();
            request = "INSERT INTO commentaire (description,id_recipe) VALUE (?,?)";
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
    public boolean delete(Commentaire element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "DELETE FROM commentaire WHERE id =?";
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
    public Commentaire update(Commentaire element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "UPDATE commentaire SET description=?, id_recipe=? WHERE id =?";
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
    public Commentaire get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Commentaire> get() throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            List<Commentaire> commentaires = new ArrayList<>();
            request = "SELECT * FROM commentaire ";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                commentaires.add(Commentaire.builder().description(resultSet.getString("description")).id(resultSet.getInt("id")).build());
            }
            return commentaires;
        }catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    public List<Commentaire> getByRecipeId(int id) throws SQLException{
        try {
            connection = DataBaseManager.getConnection();
            List<Commentaire> commentaires = new ArrayList<>();
            request = "SELECT * FROM commentaire WHERE id_recipe = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                commentaires.add(Commentaire.builder().description(resultSet.getString("description")).id(resultSet.getInt("id")).build());
            }
            return commentaires;
        }catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }
}
