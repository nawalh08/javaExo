package org.example.DAO;

import org.example.entity.Ingredient;
import org.example.entity.IngredientRecipe;
import org.example.util.DataBaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientRecipeDAO extends BaseDAO<IngredientRecipe>{
    @Override
    public IngredientRecipe save(IngredientRecipe element) throws SQLException {
        try{
            connection = DataBaseManager.getConnection();
            request = "INSERT INTO ingredient_recipe (id_ingredient,id_recipe,quantity) VALUE (?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,element.getId_ingredient());
            statement.setInt(2,element.getId_recipe());
            statement.setString(3,element.getQuantite());
            int nbrow = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if(nbrow != 1){
                throw new SQLException();
            }
            if(resultSet.next()){
                element.setId(resultSet.getInt(1));
            }
            connection.commit();
            return element;
        }catch(SQLException e){
            connection.rollback();
            return null;
        }
    }

    @Override
    public boolean delete(IngredientRecipe element) throws SQLException {
        return false;
    }

    @Override
    public IngredientRecipe update(IngredientRecipe element) throws SQLException {
        return null;
    }

    @Override
    public IngredientRecipe get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<IngredientRecipe> get() throws SQLException {
        return null;
    }

    public List<Ingredient> getByRecipeId(int id) throws SQLException{
        List<Ingredient> ingredients = new ArrayList<>();
        connection = DataBaseManager.getConnection();
        request ="SELECT i.name as name , ir.quantity as quantity FROM ingredient as i INNER JOIN ingredient_recipe as ir on ir.id_ingredient = i.id WHERE ir.id_recipe = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            ingredients.add(Ingredient.builder().nom(resultSet.getString("name")).quantity(resultSet.getInt("quantity")).build());
        }
        return ingredients;
    }
}
