package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, "");
    }

    public static void main(String[] args) throws SQLException {

        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Gotcha");
        }
    }
}
