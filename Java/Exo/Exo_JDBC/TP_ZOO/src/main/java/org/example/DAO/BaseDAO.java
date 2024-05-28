package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public abstract class BaseDAO<T> {
        protected Connection _connection;
        protected PreparedStatement preparedStatement;
        protected String request;
        protected ResultSet resultSet;

        protected BaseDAO (Connection connection){
            this._connection = connection;
        }

        protected void close () throws SQLException {
                if(!_connection.isClosed()){
                        _connection.close();
                }
                if (!preparedStatement.isClosed()){
                        preparedStatement.close();
                }
                if(!resultSet.isClosed()){
                        resultSet.close();
                }
        }

        public abstract T save (T element)throws SQLException;
        public abstract T update (T element)throws  SQLException;
        //       public abstract boolean delete(T element)throws SQLException;

        public abstract List<T> getByName(String nom) throws SQLException;
        public abstract List<T> getByHabitat(String habitat) throws SQLException;
        public abstract List<T> getByRace(String race) throws SQLException;
        public abstract List<T> getByAge(int age) throws SQLException;
//        public abstract List<T> get() throws SQLException;


}
