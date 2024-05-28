package org.example.DAO;

import org.example.entity.Categorie;
import org.example.entity.Ingredient;
import org.example.entity.Recipe;
import org.example.entity.Step;
import org.example.util.DataBaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO extends BaseDAO<Recipe> {

    CategorieDAO categorieDAO = new CategorieDAO();
    StepDAO stepDAO = new StepDAO();

    CommentaireDAO commentaireDAO =  new CommentaireDAO();

    IngredientRecipeDAO ingredientRecipeDAO = new IngredientRecipeDAO();
    @Override
    public Recipe save(Recipe element) throws SQLException {
        try{
            connection = DataBaseManager.getConnection();
            request = "INSERT INTO recipe (name,prepTime,prepCuisson,difficulty,id_categorie) VALUE (?,?,?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,element.getName());
            statement.setInt(2,element.getTempsPrep());
            statement.setInt(3,element.getTempsCuisson());
            statement.setInt(4,element.getDifficulte());
            statement.setInt(5,element.getCategorie().getId());
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
    public boolean delete(Recipe element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "DELETE FROM recipe WHERE id =?";
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
    public Recipe update(Recipe element) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            request = "UPDATE recipe SET name=?, prepTime=?,prepCuisson=?,difficulty=?,id_categorie=? WHERE id =?";
            statement = connection.prepareStatement(request);
            statement.setString(1, element.getName());
            statement.setInt(2, element.getTempsPrep());
            statement.setInt(3, element.getTempsCuisson());
            statement.setInt(4, element.getDifficulte());
            statement.setInt(5, element.getCategorie().getId());
            statement.setInt(6, element.getId());
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
    public Recipe get(int id) throws SQLException {
        try {

            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM recipe WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return (Recipe.builder()
                        .name(resultSet.getString("name"))
                        .tempsPrep(resultSet.getInt("prepTime"))
                        .tempsCuisson(resultSet.getInt("prepCuisson"))
                        .difficulte(resultSet.getInt("difficulty"))
                        .id(resultSet.getInt("id"))
                        .categorie(categorieDAO.get(resultSet.getInt("id_categorie")))
                        .steps(stepDAO.getByRecipeId(resultSet.getInt("id")))
                        .commentaire(commentaireDAO.getByRecipeId(resultSet.getInt("id")))
                        .ingredients(ingredientRecipeDAO.getByRecipeId(resultSet.getInt("id")))
                        .build()) ;
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
    public List<Recipe> get() throws SQLException {

            try{
                List<Recipe> recipes = new ArrayList<>();
                connection = DataBaseManager.getConnection();
                request = "SELECT * FROM recipe";
                statement = connection.prepareStatement(request);
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                    recipes.add(Recipe.builder()
                            .commentaire(commentaireDAO.getByRecipeId(resultSet.getInt("id")))
                            .name(resultSet.getString("name"))
                            .tempsPrep(resultSet.getInt("prepTime"))
                            .tempsCuisson(resultSet.getInt("prepCuisson"))
                            .difficulte(resultSet.getInt("difficulty"))
                            .id(resultSet.getInt("id"))
                            .categorie(categorieDAO.get(resultSet.getInt("id_categorie")))
                            .steps(stepDAO.getByRecipeId(resultSet.getInt("id")))
                            .ingredients(ingredientRecipeDAO.getByRecipeId(resultSet.getInt("id")))
                            .build());
                }
                return recipes;
            }catch (SQLException e){
                System.out.println(e.getMessage());
                return new ArrayList<>();
            }finally {
                close();
            }
        }
    }

