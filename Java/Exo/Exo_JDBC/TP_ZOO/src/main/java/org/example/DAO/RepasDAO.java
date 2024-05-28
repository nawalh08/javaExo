package org.example.DAO;

import org.example.Entity.Animal;
import org.example.Entity.Repas;
import org.example.Util.DataBaseManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepasDAO extends BaseDAO<Repas> {

    private AnimalDAO animauxDAO;

    public RepasDAO(Connection connection, AnimalDAO animalDAO) {
        super(connection);
        animalDAO = animauxDAO;
    }

    @Override
    public Repas save(Repas element) throws SQLException {
        try{
            _connection = DataBaseManager.getConnection();
            request = "INSERT INTO Repas (quand,details,id_animal) VALUE (?,?,?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, Date.valueOf(element.getDate()));
            preparedStatement.setString(2,element.getDetails());
            preparedStatement.setInt(3,element.getAnimal().getId_animal());
            int nbrow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            System.out.println(resultSet);
            Repas meal = null;
            if(resultSet.next()){

                meal = Repas.builder().date(LocalDate.now()).details(element.getDetails()).animal(element.getAnimal()).build();
            }
            if(nbrow != 1){
                _connection.rollback();
            }
            _connection.commit();
            return meal;
        }catch(SQLException e){
            _connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public Repas update(Repas element) throws SQLException {
        return null;
    }
    //       public abstract boolean delete(T element)throws SQLException;
    @Override
    public List<Repas> getByName(String nom) throws SQLException {
        return null;
    }
    @Override
    public List<Repas> getByHabitat(String habitat) throws SQLException {
        return null;
    }
    @Override
    public List<Repas> getByRace(String Race) throws SQLException {
        return null;
    }
    @Override
    public List<Repas> getByAge(int id) throws SQLException {
        return null;
    }
    public List<Repas> getByIdAnimal(int id) throws SQLException {

        try {
            _connection = DataBaseManager.getConnection();
            List<Repas> repas = new ArrayList<>();
            request = "SELECT * FROM Repas WHERE id_animal = ?";
            preparedStatement = _connection.prepareStatement(request);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                repas.add(Repas.builder().date(resultSet.getDate("quand").toLocalDate()).details(resultSet.getString("details")).build());
            }
            return repas;
        }catch (SQLException e){
            close();

        }

        return null;



    }







}
