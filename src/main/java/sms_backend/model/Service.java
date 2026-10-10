package sms_backend.model;

public class Service {

    private Integer serviceID;
    private String serviceName;
    private String serviceDescription;
    private String tier;
    private double pricePerBillingCycle;

    // Default Constructor
    public Service() {
    }

    // Parameterized Constructor
    public Service(Integer serviceID, String serviceName,
                   String serviceDescription, String tier,
                   double pricePerBillingCycle) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.tier = tier;
        this.pricePerBillingCycle = pricePerBillingCycle;
    }

    // Getters and Setters

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public double getPricePerBillingCycle() {
        return pricePerBillingCycle;
    }

    public void setPricePerBillingCycle(double pricePerBillingCycle) {
        this.pricePerBillingCycle = pricePerBillingCycle;
    }
}