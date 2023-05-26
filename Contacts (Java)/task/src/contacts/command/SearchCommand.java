package contacts.command;

import contacts.PhoneBook;
import contacts.command.Command;

public class SearchCommand implements Command {
    PhoneBook phoneBook;


    public SearchCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.search();
    }
}
