package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private final List<Contact> contacts;
    private final Scanner scanner;

    public PhoneBook() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void count() {
        System.out.printf("The Phone Book has %d records\n", contacts.size());
    }

    public void add() {
        System.out.print("Enter the type (person, organization): ");
        String type = scanner.nextLine();
        if (type.equals("person")) {
            addPerson();
        } else if (type.equals("organization")) {
            addOrganization();
        }
    }

    private void addPerson() {
        PersonContact contact = new PersonContact();
        System.out.print("Enter the name: ");
        contact.setName(scanner.nextLine());
        System.out.print("Enter the surname: ");
        contact.setSurname(scanner.nextLine());
        System.out.print("Enter the birth date: ");
        contact.setBirthDate(scanner.nextLine());
        if (!contact.hasBirthDate()) {
            System.out.println("Bad birth date!");
        }
        System.out.print("Enter the gender (M, F): ");
        contact.setGender(scanner.nextLine());
        if (!contact.hasGender()) {
            System.out.println("Bad gender!");
        }
        System.out.print("Enter the number: ");
        contact.setPhoneNumber(scanner.nextLine());
        if (!contact.hasPhoneNumber()) {
            System.out.println("Wrong number format!");
        }
        contacts.add(contact);
        System.out.println("The record added.");
    }

    private void addOrganization() {
        OrganizationContact contact = new OrganizationContact();
        System.out.print("Enter the organization name: ");
        contact.setName(scanner.nextLine());
        System.out.print("Enter the address: ");
        contact.setAddress(scanner.nextLine());
        System.out.print("Enter the number: ");
        contact.setPhoneNumber(scanner.nextLine());
        if (!contact.hasPhoneNumber()) {
            System.out.println("Wrong number format!");
        }
        contacts.add(contact);
        System.out.println("The record added.");
    }

    public void showInfo() {
        printContacts();
        System.out.print("Enter index to show info: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        System.out.println(contacts.get(index).toString());
    }

    public void edit() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        printContacts();
        System.out.print("Select a record: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (contacts.get(index) instanceof PersonContact contact) {
            editPersonContact(contact);
        }
        if (contacts.get(index) instanceof OrganizationContact contact) {
            editOrganizationContact(contact);
        }
    }

    private void editPersonContact(PersonContact contact) {
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        String field = scanner.nextLine();
        System.out.printf("Enter %s: ", field);
        switch (field) {
            case "name" -> contact.setName(scanner.nextLine());
            case "surname" -> contact.setSurname(scanner.nextLine());
            case "birth" -> contact.setBirthDate(scanner.nextLine());
            case "gender" -> contact.setGender(scanner.nextLine());
            case "number" -> contact.setPhoneNumber(scanner.nextLine());
        }
        System.out.println("The record updated");
    }

    private void editOrganizationContact(OrganizationContact contact) {
        System.out.println("Select a field (address, number): ");
        String field = scanner.nextLine();
        System.out.printf("Enter %s: ", field);
        switch (field) {
            case "address" -> contact.setAddress(scanner.nextLine());
            case "number" -> contact.setPhoneNumber(scanner.nextLine());
        }
        System.out.println("The record updated");
    }

    public void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, contacts.get(i).getFullName());
        }
    }

    public void remove() {
        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        printContacts();
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        contacts.remove(index);
    }
}