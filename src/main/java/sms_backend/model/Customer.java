package sms_backend.model;
import java.sql.Date;

public class Customer {

    private int customerID;
    private String customerName;
    private String customerEmail;
    private String contactNumber;
    private String address;
    private Date signupDate;
    private String status;

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(int customerID, String customerName, String customerEmail,
                    String contactNumber, String address, Date signupDate,
                    String status) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.contactNumber = contactNumber;
        this.address = address;
        this.signupDate = signupDate;
        this.status = status;
    }

    // Getters and Setters

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
