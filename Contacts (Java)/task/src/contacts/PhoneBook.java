package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private final List<Contact> contacts;
    private Scanner scanner;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void start() {
        scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            String action = scanner.nextLine();
            switch (action) {
                case "add":
                    addContact();
                    break;
                case "remove":
                    removeContact();
                    break;
                case "edit":
                    editContact();
                    break;
                case "count":
                    System.out.printf("The Phone Book has %d records\n", contacts.size());
                    break;
                case "list":
                    printContacts();
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
    }

    private void addContact() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter the number: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name, surname, phoneNumber);
        contacts.add(contact);
        if (contact.hasPhoneNumber()) {
            System.out.println("The record added.");
        } else {
            System.out.println("Wrong number format!");
        }
    }

    private void editContact() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }

        printContacts();
        System.out.print("Select a record: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        System.out.println("Select a field (name, surname, number): ");
        String field = scanner.nextLine();
        System.out.printf("Enter %s: ", field);
        switch (field) {
            case "name":
                contacts.get(index).setName(scanner.nextLine());
                break;
            case "surname":
                contacts.get(index).setSurname(scanner.nextLine());
                break;
            case "number":
                contacts.get(index).setPhoneNumber(scanner.nextLine());
                break;
        }
    }

    public void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, contacts.get(i).toString());
        }
    }

    public void removeContact() {
        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        printContacts();
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        contacts.remove(index);
    }
}