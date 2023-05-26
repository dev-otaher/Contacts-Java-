package contacts.command;

import contacts.PhoneBook;

public class AddContactCommand implements Command{
    PhoneBook phoneBook;

    public AddContactCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.add();
    }
}
