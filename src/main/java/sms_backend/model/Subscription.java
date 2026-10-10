package sms_backend.model;

import java.sql.Date;

public class Subscription {

    private Integer subscriptionID;
    private int customerID;
    private Integer serviceID;
    private Date subscriptionStartDate;
    private Date subscriptionEndDate;
    private Date renewalDate;
    private String status;

    // Default Constructor
    public Subscription() {
    }

    // Parameterized Constructor
    public Subscription(Integer subscriptionID, int customerID, Integer serviceID,
                        Date subscriptionStartDate, Date subscriptionEndDate,
                        Date renewalDate, String status) {
        this.subscriptionID = subscriptionID;
        this.customerID = customerID;
        this.serviceID = serviceID;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
        this.renewalDate = renewalDate;
        this.status = status;
    }

    // Getters and Setters

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(Integer subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public Date getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(Date subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}