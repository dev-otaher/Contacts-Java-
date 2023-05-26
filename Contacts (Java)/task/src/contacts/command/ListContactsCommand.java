package contacts.command;

import contacts.PhoneBook;

public class ListContactsCommand implements Command{
    private final PhoneBook phoneBook;

    public ListContactsCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.list();
    }
}
