package contacts.command;

import contacts.PhoneBook;

public class EditContactCommand implements Command{
    PhoneBook phoneBook;

    public EditContactCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.edit();
    }
}
