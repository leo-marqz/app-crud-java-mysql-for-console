
package com.leomarqz;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MessageService {


    public static void getAll() {
        MessageDAO.all();
    }

    public static void get() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write the id of the message: ");
        int idMessage = input.nextInt();
        MessageDAO.findById(idMessage);
    }

    public static void create() {
        Scanner input = new Scanner(System.in);

        System.out.print("Write your message: ");
        String contentMessage = input.nextLine();

        System.out.print("Write your name: ");
        String nameAuthor = input.nextLine();

        Message newMessage = new Message();
        newMessage.setMessage(contentMessage);
        newMessage.setCreatedBy(nameAuthor);
        newMessage.setCreatedAt(LocalDateTime.now().toString());

        MessageDAO.insert(newMessage);
    }

    public static void edit() {
        Scanner input = new Scanner(System.in);

        System.out.println("Write your new message: ");
        String newMessage = input.nextLine();

        System.out.println("Write the id of the message: ");
        String idMessage = input.nextLine();
        int id = Integer.parseInt(idMessage);

        System.out.println("Your id is: " + idMessage);
        System.out.println(newMessage);

        var updateMessage = new Message();
        updateMessage.setId(id);
        updateMessage.setMessage(newMessage);

        MessageDAO.update(updateMessage);
    }

    public static void delete() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write the id of the message: ");
        int idMessage = input.nextInt();
        MessageDAO.delete(idMessage);
    }

}
