package com.group4.model;

public class Drug {
    private String code;
    private String name;
    private double price;
    private int quantity;
    private String supplier;
    private String dateAdded;
    private String location;


    //Constructor for Drugs 
    public Drug(String code, String name, double price, int quantity, String supplier, String dateAdded,String location) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.dateAdded = dateAdded;
        this.location = location;
    }

    

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

}
