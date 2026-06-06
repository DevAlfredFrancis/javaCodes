package com.example.luxeauraapp.models;

public class BookingModel {

    private int id;
    private String bookingReference;
    private String dateTime;
    private String customerName;
    private String services;
    private double totalPrice;
    private String contactNumber;
    private String status;
    //private Customer customer;
    //private Service service;
    private TimeSlotModel timeSlotModel;

    public BookingModel(int id, String bookingReference, String dateTime, String customerName, String services, double totalPrice, String contactNumber, String status) {
        this.id = id;
        this.bookingReference = bookingReference;
        this.dateTime = dateTime;
        this.customerName = customerName;
        this.services = services;
        this.totalPrice = totalPrice;
        this.contactNumber = contactNumber;
        this.status = status;
    }

    //getters
    public int getId() { return  id; }
    public String getBookingReference() { return bookingReference; }
    public String getDateTime() { return dateTime; }
    public String getCustomerName() { return customerName; }
    public String getServices() { return services; }
    public double getTotalPrice() { return totalPrice; }
    public String getContactNumber() { return contactNumber; }
    public String getStatus() { return status; }
}
