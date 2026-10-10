package sms_backend.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Billing {

    private Integer billID;
    private Integer subscriptionID;
    private Date billingDate;
    private BigDecimal amountBilled;
    private Date paymentDueDate;
    private String paymentStatus;

    // Default Constructor
    public Billing() {
    }

    // Parameterized Constructor
    public Billing(Integer billID, Integer subscriptionID, Date billingDate,
                   BigDecimal amountBilled, Date paymentDueDate,
                   String paymentStatus) {
        this.billID = billID;
        this.subscriptionID = subscriptionID;
        this.billingDate = billingDate;
        this.amountBilled = amountBilled;
        this.paymentDueDate = paymentDueDate;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters

    public int getBillID() {
        return billID;
    }

    public void setBillID(Integer billID) {
        this.billID = billID;
    }

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(Integer subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public BigDecimal getAmountBilled() {
        return amountBilled;
    }

    public void setAmountBilled(BigDecimal amountBilled) {
        this.amountBilled = amountBilled;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}