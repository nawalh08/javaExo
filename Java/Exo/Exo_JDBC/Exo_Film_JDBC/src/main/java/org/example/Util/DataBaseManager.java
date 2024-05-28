package org.example.Util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {
    private static final String URI = "jdbc:mysql://localhost:3306/movies";
    private static final String USER = "root";
    private static final String PASSWORD = "Fares_Dries_59";

    public static Connection getConnection () throws SQLException{
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
