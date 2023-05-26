package contacts.command;

import contacts.PhoneBook;

public class CountContactsCommand implements Command{
    PhoneBook phoneBook;

    public CountContactsCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.count();
    }
}
