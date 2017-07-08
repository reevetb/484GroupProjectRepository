/*
Author: Kyle Porter
Date: 6/20/17
Assignment: CIS 484 Group Project
Purpose: Human Resource entity class used as a bridge table between employees
and stores
 */
package BookIT.V2;

import BookIT.*;

/**
 *
 * @author KP
 */
public class HumanResources {

    private int empID;
    private int storeID;
    private String empType;
    public static int empCount;
    public static int storeCount;

    // constructor
    public HumanResources() {
        empID = 0;
        storeID = 0;
        empType = "";
        empCount = 1;
        storeCount = 1;
    }

    public HumanResources(String empType) {
        this.empType = empType;
        empID = empCount++;
        storeID = storeCount++;

    }

    // getters & setters
    public int getEmpID() {
        return this.empID;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public String getEmpType() {
        return this.empType;
    }

    public void setEmpType(String type) {
        this.empType = type;
    }

}
