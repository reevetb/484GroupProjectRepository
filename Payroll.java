/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Payroll entity class to keep track of employee shifts worked
 */
package BookIT;

/**
 *
 * @author KP
 */
public class Payroll {

    private int payID;
    private int empID_FK;
    private int storeID_FK;
    private Shifts instanceID_FK;
    public static int payCount;
    public static int empCount;
    public static int storeCount;

    // constructor
    public Payroll() {
        payID = 0;
        empID_FK = 0;
        storeID_FK = 0;
        payCount = 1;
    }

    public Payroll(int empID, int storeID, Shifts instanceID) {
        
        payID = payCount++;
        empID_FK = empID;
        storeID_FK = storeID;
        instanceID_FK = instanceID;
    }

    // getters & setters
    public int getPayID() {
        return this.payID;
    }

    public int getEmpID_FK() {
        return this.empID_FK;
    }

    public int getStoreID_FK() {
        return this.storeID_FK;
    }
    
    public Shifts getInstanceID_FK() {
        return this.instanceID_FK;
    }
}
