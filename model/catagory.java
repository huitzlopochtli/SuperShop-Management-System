package model;

import java.sql.Date;

/**
 *
 * @author PK
 */
public class catagory {
    private int id;
    private String name,brand,supplier,creator,discription;
    private Date dateAddedOn;

    public catagory() {
        this.id = 0;
        this.name = null;
        this.brand = null;
        this.supplier = null;
        this.creator = null;
        this.dateAddedOn = null;
        this.discription = null;
    }

    public catagory(int id, String name, String brand, String supplier, String creator, Date dateAddedOn, String discription) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.supplier = supplier;
        this.creator = creator;
        this.dateAddedOn = dateAddedOn;
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDateAddedOn() {
        return dateAddedOn;
    }

    public void setDateAddedOn(Date dateAddedOn) {
        this.dateAddedOn = dateAddedOn;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

}
