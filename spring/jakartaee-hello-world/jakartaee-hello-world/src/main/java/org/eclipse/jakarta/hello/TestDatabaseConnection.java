package org.eclipse.jakarta.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://172.17.32.1:5433/train";
        String user = "postgres";
        String password = "postgres";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");
            connection.close();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
