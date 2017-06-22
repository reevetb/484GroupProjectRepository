/*
Author: Kyle Porter
Date: 6/20/17
Assignment: CIS 484 Group Project
Purpose: Supplier entity class
 */
package BookIT;

/**
 *
 * @author KP
 */
public class Supplier {

    private int supplierID;
    private String name;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String cell;
    public static int supplierCount;

    // constructor
    public Supplier() {
        supplierID = 0;
        name = "";
        street = "";
        city = "";
        state = "";
        zipCode = 0;
        cell = "";
        supplierCount = 1;
    }

    public Supplier(String name, String street, String city, String state,
            int zipCode, String cell) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cell = cell;
        supplierID = supplierCount++;
    }

    // getters & setters
    public int getSupplierID() {
        return this.supplierID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCell() {
        return this.cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

}
