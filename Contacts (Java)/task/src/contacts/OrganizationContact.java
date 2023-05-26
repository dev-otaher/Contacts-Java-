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
    public String toString() {
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + (hasPhoneNumber() ? phoneNumber : "[no data]") + "\n" +
                "Time created: " + createdOn + "\n" +
                "Time last edit: " + lastEditedOn;
    }
}
