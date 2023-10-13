package com.leomarqz.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/twitter_app_clone";
    private static final String USER = "admin";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager
                    .getConnection(
                            Database.URL_CONNECTION,
                            Database.USER,
                            Database.PASSWORD
                    );

            if(connection != null) {
                System.out.println("Connection established!");
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return connection;
    }
}
