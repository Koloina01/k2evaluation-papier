package com.evaluation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DBConnection {

   private static final Dotenv dotenv = Dotenv.load();

    public Connection getConnection() {
        try {
            String url = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
