package contacts;

public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        setPhoneNumber(phoneNumber);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        String regex = "\\+?(\\(\\w+\\)|\\w+[ \\-]\\(\\w{2,}\\)|\\w+)([ \\-]\\w{2,})*";
        this.phoneNumber = phoneNumber.matches(regex) ? phoneNumber : "";
    }

    public boolean hasPhoneNumber() {
        return !phoneNumber.equals("");
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", name, surname, hasPhoneNumber() ? phoneNumber : "[no number]");
    }
}