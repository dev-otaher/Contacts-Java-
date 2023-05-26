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

    public void add() {
        Contact contact;
        System.out.print("Enter the type (person, organization): ");
        String type = scanner.nextLine();
        if (type.equals("person")) {
            contact = new PersonContact();
        } else {
            contact = new OrganizationContact();
        }
        for (String field : contact.getUpdatableFields()) {
            System.out.printf("Enter the %s: ", field);
            contact.updateField(field, scanner.nextLine());
        }
        contacts.add(contact);
        System.out.println("The record added.");
    }

    public void list() {
        printContactsFullName();
        System.out.print("\n[list] Enter action (number, back): ");
        String action = scanner.nextLine();
        if ("back".equals(action)) {
            return;
        }
        int contactIndex = Integer.parseInt(action) - 1;
        editDeleteContact(contacts.get(contactIndex));
    }

    public void search() {
        while (true) {
            System.out.print("Enter search query: ");
            String term = scanner.nextLine();
            List<Contact> contactsFound = find(term);
            System.out.printf("Found %d results:\n", contactsFound.size());
            printContactsFullName(contactsFound);
            System.out.print("\n[search] Enter action (number, back, again): ");
            String action = scanner.nextLine();
            if (action.equals("back")) {
                return;
            }
            if (action.equals("again")) {
                continue;
            }
            int contactIndex = Integer.parseInt(action) - 1;
            Contact selectedContact = contactsFound.get(contactIndex);
            editDeleteContact(selectedContact);
            printContactDetails(selectedContact);
            break;
        }
    }

    public void count() {
        System.out.printf("The Phone Book has %d records\n", contacts.size());
    }

    private void editDeleteContact(Contact contact) {
        printContactDetails(contact);
        System.out.print("\n[record] Enter action (edit, delete, menu): ");
        switch (scanner.nextLine()) {
            case "edit" -> editContact(contact);
            case "delete" -> delete(contact);
        }
    }

    private void printContactDetails(Contact contact) {
        System.out.println(contact.getDetails());
    }

    private void editContact(Contact contact) {
        System.out.printf("Select a field (%s): ", String.join(", ", contact.getUpdatableFields()));
        String selectedField = scanner.nextLine();
        System.out.printf("Enter %s: ", selectedField);
        contact.updateField(selectedField, scanner.nextLine());
        System.out.println("Saved");
    }

    private void printContactsFullName() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, contacts.get(i).getFullName());
        }
    }

    private void printContactsFullName(List<Contact> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, contacts.get(i).getFullName());
        }
    }

    private List<Contact> find(String term) {
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.toString().toLowerCase().contains(term)) {
                foundContacts.add(contact);
            }
        }
        return foundContacts;
    }

    private void delete(Contact contact) {
        contacts.remove(contact);
    }
}