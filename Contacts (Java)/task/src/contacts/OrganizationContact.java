package contacts;

public class OrganizationContact extends Contact {
    private String address;

    protected OrganizationContact() {
        super();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    protected String getFullName() {
        return name;
    }

    @Override
    String[] getUpdatableFields() {
        return new String[]{"name", "address", "number"};
    }

    @Override
    void updateField(String fieldName, Object newValue) {
        switch (fieldName) {
            case "name" -> setName((String) newValue);
            case "address" -> setAddress((String) newValue);
            case "number" -> setPhoneNumber((String) newValue);
        }
    }

    @Override
    Object getFieldValue(String fieldName) {
        return null;
    }

    @Override
    public String getDetails() {
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + (hasPhoneNumber() ? phoneNumber : "[no data]") + "\n" +
                "Time created: " + createdOn + "\n" +
                "Time last edit: " + lastEditedOn;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", name, address, phoneNumber);
    }
}
