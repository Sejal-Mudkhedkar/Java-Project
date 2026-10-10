package sms_backend.model;

import java.sql.Date;

public class Discount {

    private Integer discountID;
    private Integer serviceID;
    private String discountCode;
    private double discountAmount;
    private Date validFrom;
    private Date validTill;
    private String discountType;

    // Default Constructor
    public Discount() {
    }

    // Parameterized Constructor
    public Discount(int discountID, Integer serviceID,
                    String discountCode, double discountAmount,
                    Date validFrom, Date validTill,
                    String discountType) {
        this.discountID = discountID;
        this.serviceID = serviceID;
        this.discountCode = discountCode;
        this.discountAmount = discountAmount;
        this.validFrom = validFrom;
        this.validTill = validTill;
        this.discountType = discountType;
    }

    // Getters and Setters

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
}