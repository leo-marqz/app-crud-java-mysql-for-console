package com.leomarqz;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        DBConnection db = null;
        Connection connection = null;

        try{
            do{
                System.out.println("\n-----------------------------");
                System.out.println("Welcome to Twitter App Clone");
                System.out.println("** Developed by LeoMarqz **");
                System.out.println("-----------------------------");
                System.out.println("Select an option:");
                System.out.println("1. Create a message");
                System.out.println("2. Read all messages");
                System.out.println("3. Read a message");
                System.out.println("4. Update a message");
                System.out.println("5. Delete a message");
                System.out.println("6. Exit");
                System.out.println("-----------------------------");

                System.out.print("Option: ");
                option = sc.nextInt();

                switch (option){
                    case 1:
                        System.out.println("Create a message");
                        MessageService.create();
                        break;
                    case 2:
                        System.out.println("All messages");
                        MessageService.getAll();
                        break;
                    case 3:
                        System.out.println("Get message");
                        MessageService.get();
                        break;
                    case 4:
                        System.out.println("Update a message");
                        MessageService.edit();
                        break;
                    case 5:
                        System.out.println("Delete a message");
                        MessageService.delete();
                        break;
                    case 6:
                        System.out.println("Bye!");
                        break;
                }


            }while(option != 6);

            db = new DBConnection();
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