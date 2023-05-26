package contacts;

import java.time.LocalDateTime;

abstract public class Contact {
    protected String name;
    protected String phoneNumber;
    protected LocalDateTime createdOn;
    protected LocalDateTime lastEditedOn;

    protected Contact() {
        createdOn = LocalDateTime.now();
        lastEditedOn = LocalDateTime.of(createdOn.toLocalDate(), createdOn.toLocalTime());
    }

    protected void setName(String name) {
        this.name = name;
        updateLastEditedOn();
    }

    protected void setPhoneNumber(String phoneNumber) {
        String regex = "\\+?(\\(\\w+\\)|\\w+[ \\-]\\(\\w{2,}\\)|\\w+)([ \\-]\\w{2,})*";
        this.phoneNumber = phoneNumber.matches(regex) ? phoneNumber : "";
        updateLastEditedOn();
    }

    protected boolean hasPhoneNumber() {
        return !phoneNumber.equals("");
    }

    protected void updateLastEditedOn() {
        lastEditedOn = LocalDateTime.now();
    }

    abstract protected String getFullName();
}
