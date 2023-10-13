package com.leomarqz;

import com.leomarqz.config.Database;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Database db = null;
        Connection connection = null;

        try{

            db = new Database();
            connection = db.getConnection();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try{
                if(connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
    
}