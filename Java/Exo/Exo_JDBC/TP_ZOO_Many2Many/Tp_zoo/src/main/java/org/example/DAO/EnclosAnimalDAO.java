package org.example.DAO;

import org.example.entity.Animal;
import org.example.entity.Enclos;
import org.example.entity.EnclosAnimal;
import org.example.util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnclosAnimalDAO extends BaseDAO<EnclosAnimal>{

    private AnimalDAO animalDAO;

    public EnclosAnimalDAO() {
        animalDAO = new AnimalDAO();
    }


    @Override
    public EnclosAnimal save(EnclosAnimal element) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO enclos_animal (id_animal,id_enclos) VALUE (?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,element.getId_animal());
            statement.setInt(2,element.getId_enclos());
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
    public boolean delete(EnclosAnimal element) throws SQLException {
        return false;
    }

    @Override
    public EnclosAnimal update(EnclosAnimal element) throws SQLException {
        return null;
    }

    @Override
    public EnclosAnimal get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<EnclosAnimal> get() throws SQLException {
        return null;
    }
    public List<Animal> getAllCommandeByFleuristeId (int id)throws SQLException{
        List<Animal> animaux = new ArrayList<>();
        connection = DatabaseManager.getConnection();
        request ="SELECT a.id  as animaux_id , a.name as animaux_name, a.race as animaux_race , a.description as animaux_desc , a.habitat as animaux_habitat , a.age as animaux_age  FROM animal AS a INNER JOIN enclos_animal as ea ON ea.id_animal = a.id WHERE ea.id_enclos = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            animaux.add(Animal.builder().id(resultSet.getInt("animaux_id")).name(resultSet.getString("animaux_name")).age(resultSet.getInt("animaux_age")).race(resultSet.getString("animaux_race")).description(resultSet.getString("animaux_desc")).habitat(resultSet.getString("animaux_habitat")).build());
        }
        return animaux;
    }
}
