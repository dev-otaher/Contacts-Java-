package contacts;


import contacts.command.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            String action = scanner.nextLine();
            switch (action) {
                case "add" -> new AddContactCommand(phoneBook).execute();
                case "remove" -> new RemoveContactCommand(phoneBook).execute();
                case "edit" -> new EditContactCommand(phoneBook).execute();
                case "count" -> new CountContactsCommand(phoneBook).execute();
                case "info" -> new ShowInfoCommand(phoneBook).execute();
                case "exit" -> exit = true;
            }
            System.out.println();
        }
    }
}


