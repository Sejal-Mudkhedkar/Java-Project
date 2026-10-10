package sms_backend.model;

public class ServiceProvider {

    private Integer providerID;
    private String providerName;
    private String providerContact;
    private String providerEmail;

    // Default Constructor
    public ServiceProvider() {
    }

    // Parameterized Constructor
    public ServiceProvider(int providerID, String providerName,
                           String providerContact, String providerEmail) {
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerContact = providerContact;
        this.providerEmail = providerEmail;
    }

    // Getters and Setters

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderContact() {
        return providerContact;
    }

    public void setProviderContact(String providerContact) {
        this.providerContact = providerContact;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
    }
}