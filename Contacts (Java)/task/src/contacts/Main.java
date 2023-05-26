package contacts;


import contacts.command.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter action (add, list, search, count, exit): ");
            String action = scanner.nextLine();
            switch (action) {
                case "add" -> new AddContactCommand(phoneBook).execute();
                case "list" -> new ListContactsCommand(phoneBook).execute();
                case "search" -> new SearchCommand(phoneBook).execute();
                case "count" -> new CountContactsCommand(phoneBook).execute();
                case "exit" -> exit = true;
            }
            System.out.println();
        }
    }
}


