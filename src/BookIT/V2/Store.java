/*
* Authors: DMO CONSULTING LLC
* Date: 7/8/2017
*  
* Purpose: TO DEVELOP AN IS SYSTEM FOR BOOK BURG BOOK STORE
* DESCRIPTION: THIS CLASS CREATES AN ENCYCLOPEDIA FOR OUR STORE OBJECTS
*/
package BookIT.V2;

import BookIT.*;

/**
 *
 * @author KP
 */
public class Store {

    private int storeID;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    public static int storeCount;

    // constructor
    public Store() {
        storeID = 0;
        street = "";
        city = "";
        state = "";
        zipCode = 0;
        storeCount = 1;

    }

    public Store(String street, String city, String state, int zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        storeID = storeCount;

    }

    public int getStoreID() {
        return this.storeID;
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

    public void setZipCode(int zipCdoe) {
        this.zipCode = zipCode;
    }

}
