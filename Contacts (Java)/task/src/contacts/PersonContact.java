package contacts;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonContact extends Contact {
    private String surname;
    private LocalDate birthDate;
    private String gender;

    public PersonContact() {
        super();
    }

    @Override
    protected String getFullName() {
        return name + " " + surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        updateLastEditedOn();
    }

    public void setBirthDate(String birthDate) {
        try {
            this.birthDate = LocalDate.parse(birthDate);
            updateLastEditedOn();
        } catch (DateTimeParseException ignored) {
        }
    }

    public void setGender(String gender) {
        if (gender.length() == 1 && ("M".equals(gender) || "F".equals(gender))) {
            this.gender = gender;
            updateLastEditedOn();
        }
    }

    public boolean hasBirthDate() {
        return birthDate != null;
    }

    public boolean hasGender() {
        return gender != null;
    }

    @Override
    void updateField(String fieldName, Object newValue) {
        switch (fieldName) {
            case "name" -> setName((String) newValue);
            case "surname" -> setSurname((String) newValue);
            case "birth" -> setBirthDate((String) newValue);
            case "gender" -> setGender((String) newValue);
            case "number" -> setPhoneNumber((String) newValue);
        }
    }

    @Override
    Object getFieldValue(String fieldName) {
        return null;
    }

    @Override
    String[] getUpdatableFields() {
        return new String[] {"name", "surname", "birth", "gender", "number"};
    }

    @Override
    String getDetails() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + (hasBirthDate() ? birthDate : "[no data]") + "\n" +
                "Gender: " + (hasGender() ? gender : "[no data]") + "\n" +
                "Number: " + (hasPhoneNumber() ? phoneNumber : "[no data]") + "\n" +
                "Time created: " + createdOn + "\n" +
                "Time last edit: " + lastEditedOn;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", name, surname, birthDate, gender, phoneNumber);
    }
}
