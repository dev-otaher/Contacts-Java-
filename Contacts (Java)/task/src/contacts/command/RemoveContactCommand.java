package contacts.command;

import contacts.PhoneBook;

public class RemoveContactCommand implements Command{
    PhoneBook phoneBook;

    public RemoveContactCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.remove();
    }
}
