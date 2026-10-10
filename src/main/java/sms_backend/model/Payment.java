package sms_backend.model;

import java.sql.Date;

public class Payment {

    private Integer paymentID;
    private Integer billID;
    private Date paymentDate;
    private String paymentMethod;
    private double paymentAmount;
    private String transactionID;

    // Default Constructor
    public Payment() {
    }

    // Parameterized Constructor
    public Payment(Integer paymentID, Integer billID, Date paymentDate,
                   String paymentMethod, double paymentAmount,
                   String transactionID) {
        this.paymentID = paymentID;
        this.billID = billID;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.transactionID = transactionID;
    }

    // Getters and Setters

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(Integer billID) {
        this.billID = billID;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
}