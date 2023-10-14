package com.leomarqz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {

    public static void insert(Message message) {
        Connection db = null;
        PreparedStatement ps = null;
        try{
            db = new DBConnection().getConnection();
            String query = "INSERT INTO messages(message, created_by, created_at) VALUES(?, ?, ?)";
            ps = db.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getCreatedBy());
            ps.setString(3, message.getCreatedAt());
            ps.executeUpdate();

            System.out.println("Message created successfully!");

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }finally {
            try {
                ps.close();
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void all() {
        Connection db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            db = new DBConnection().getConnection();
            String query = "SELECT id, message, created_by, created_at FROM messages";
            ps = db.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Created by: " + rs.getString("created_by"));
                System.out.println("Created at: " + rs.getString("created_at"));
                System.out.println("-----------------------------");
            }


        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }finally {
            try {
                ps.close();
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void findById(int idMessage) {
        Connection db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            db = new DBConnection().getConnection();
            String query = "SELECT id, message, created_by, created_at FROM messages WHERE id = ?";
            ps = db.prepareStatement(query);
            ps.setInt(1, idMessage);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Created by: " + rs.getString("created_by"));
                System.out.println("Created at: " + rs.getString("created_at"));
                System.out.println("-----------------------------");
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                ps.close();
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(Message message) {
        Connection db = null;
        PreparedStatement ps = null;
        try {
            db = new DBConnection().getConnection();
            String query = "UPDATE messages SET message = ? WHERE id = ?";
            ps = db.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setInt(2, message.getId());
            ps.executeUpdate();

            System.out.println("Message updated successfully!");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                ps.close();
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(int idMessage) {
        Connection db = null;
        PreparedStatement ps = null;
        try {
            db = new DBConnection().getConnection();
            String query = "DELETE FROM messages WHERE id = ?";
            ps = db.prepareStatement(query);
            ps.setInt(1, idMessage);
            ps.executeUpdate();

            System.out.println("Message deleted successfully!");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                ps.close();
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
