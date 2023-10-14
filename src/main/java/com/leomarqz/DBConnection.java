package com.leomarqz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/twitter_app_clone";
    private static final String USER = "admin";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager
                    .getConnection(
                            DBConnection.URL_CONNECTION,
                            DBConnection.USER,
                            DBConnection.PASSWORD
                    );

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return connection;
    }
}
