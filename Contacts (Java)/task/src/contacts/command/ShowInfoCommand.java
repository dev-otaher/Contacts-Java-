package contacts.command;

import contacts.PhoneBook;

public class ShowInfoCommand implements Command{
    PhoneBook phoneBook;

    public ShowInfoCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.showInfo();
    }
}
