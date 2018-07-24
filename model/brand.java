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
public class brand {
    private int id,creatorID;
    private String name,description,supplier;
    private Date dateAddedOn;

    public brand() {
        this.id = 0;
        this.creatorID = 0;
        this.name = "";
        this.description = "";
        this.supplier = "";
        this.dateAddedOn = null;
    }

    public brand(int id, int creatorID, String name, String description, String supplier, Date dateAddedOn) {
        this.id = id;
        this.creatorID = creatorID;
        this.name = name;
        this.description = description;
        this.supplier = supplier;
        this.dateAddedOn = dateAddedOn;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getDateAddedOn() {
        return dateAddedOn;
    }

    public void setDateAddedOn(Date dateAddedOn) {
        this.dateAddedOn = dateAddedOn;
    }

    
}
