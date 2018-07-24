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
public class customer {

    private int phone,id,creatorID,age;
    private double totalBought;
    private String name,address;
    private Date dateAddedOn;

    public customer(int phone, int id, int creatorID, int age, double totalBought, String name, String address, Date dateAddedOn) {
        this.phone = phone;
        this.id = id;
        this.creatorID = creatorID;
        this.age = age;
        this.totalBought = totalBought;
        this.name = name;
        this.address = address;
        this.dateAddedOn = dateAddedOn;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTotalBought() {
        return totalBought;
    }

    public void setTotalBought(double totalBought) {
        this.totalBought = totalBought;
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

    public Date getDateAddedOn() {
        return dateAddedOn;
    }

    public void setDateAddedOn(Date dateAddedOn) {
        this.dateAddedOn = dateAddedOn;
    }

    
}
