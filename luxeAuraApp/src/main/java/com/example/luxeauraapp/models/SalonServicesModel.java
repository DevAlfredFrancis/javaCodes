package com.example.luxeauraapp.models;

public class SalonServicesModel {
    private int id;
    private String serviceName;
    private String serviceCategory;
    private String description;
    private int serviceDuration;
    private double servicePrice;

    public SalonServicesModel(int id, String serviceName, String category, String description, int serviceDuration, double servicePrice) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceCategory = category;
        this.description = description;
        this.serviceDuration = serviceDuration;
        this.servicePrice = servicePrice;
    }

    //getters
    public int getId() { return id; }
    public String getServiceName() { return serviceName; }
    public String getServiceCategory() { return serviceCategory; }
    public String getDescription() { return description; }
    public int getServiceDuration() { return serviceDuration; }
    public double getServicePrice() { return servicePrice; }

    // Setters
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public void setServiceCategory(String serviceCategory) { this.serviceCategory = serviceCategory; }
    public void setDescription(String description) { this.description = description; }
    public void setServiceDuration(int serviceDuration) { this.serviceDuration = serviceDuration; }
    public void setServicePrice(double servicePrice) { this.servicePrice = servicePrice; }
}
