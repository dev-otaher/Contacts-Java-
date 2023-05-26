package contacts;

import java.time.LocalDateTime;

abstract public class Contact {
    protected String name;
    protected String phoneNumber;
    protected LocalDateTime createdOn;
    protected LocalDateTime lastEditedOn;

    protected Contact() {
        createdOn = LocalDateTime.now().withSecond(0).withNano(0);
        lastEditedOn = LocalDateTime.of(createdOn.toLocalDate(), createdOn.toLocalTime()).withSecond(0).withNano(0);
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
        lastEditedOn = LocalDateTime.now().withSecond(0).withNano(0);
    }

    abstract protected String getFullName();

    abstract void updateField(String fieldName, Object newValue);

    abstract Object getFieldValue(String fieldName);

    abstract String[] getUpdatableFields();

    abstract String getDetails();

    abstract public String toString();
}
