/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author PK
 */
public class supplier {
    private int id,creatorID,phone;
    private String name,address,description;
    Date dateAddedOn;

    public supplier(int id, int creatorID, int phone, String name, String address, String description, Date dateAddedOn) {
        this.id = id;
        this.creatorID = creatorID;
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.description = description;
        this.dateAddedOn = dateAddedOn;
    }

    public supplier() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAddedOn() {
        return dateAddedOn;
    }

    public void setDateAddedOn(Date dateAddedOn) {
        this.dateAddedOn = dateAddedOn;
    }

    
    
}
