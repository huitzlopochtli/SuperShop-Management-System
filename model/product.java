/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author PK
 */
public class product {
    private int id,quantity;
    private double price;
    private String productID,name,description,addedBy,supplier,brand,catagory;
    private Date dateAddedOn;

    public product(int id, int quantity, double price, String productID, String name, String description, String addedBy, String supplier, String brand, String catagory, Date dateAddedOn) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.addedBy = addedBy;
        this.supplier = supplier;
        this.brand = brand;
        this.catagory = catagory;
        this.dateAddedOn = dateAddedOn;
    }

    public product(int quantity, double price, String productID, String name, String description, String addedBy, String supplier, String brand, String catagory, Date dateAddedOn) {
        this.quantity = quantity;
        this.price = price;
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.addedBy = addedBy;
        this.supplier = supplier;
        this.brand = brand;
        this.catagory = catagory;
        this.dateAddedOn = dateAddedOn;
    }

    public product() {
        this.id = 0;
        this.quantity = 0;
        this.price = 0;
        this.productID = "";
        this.name = "fdgdf";
        this.description = "";
        this.addedBy = "";
        this.supplier = "";
        this.brand = "";
        this.catagory = "";
        this.dateAddedOn = null;
    }

    public product(int parseInt, double parseDouble, String text, String text0, String text1, String userName, String value, String value0, String value1, LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public Date getDateAddedOn() {
        return dateAddedOn;
    }

    public void setDateAddedOn(Date dateAddedOn) {
        this.dateAddedOn = dateAddedOn;
    }

    
}
