package contacts;

import java.util.Scanner;

public class PhoneBook {
    private Contact contact;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname of the person:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        contact = new Contact(name, surname, number);
        System.out.println("A record created!");
    }
}