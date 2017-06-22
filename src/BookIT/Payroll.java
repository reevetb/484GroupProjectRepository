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
    private String date;
    private double hours;
    private double wage;
    private double otHours;
    private double otWage;
    private int empID_FK;
    private int storeID_FK;
    public static int payCount;
    public static int empCount;
    public static int storeCount;

    // constructor
    public Payroll() {
        payID = 0;
        date = "";
        hours = 0.0;
        wage = 0.0;
        otHours = 0.0;
        otWage = 0.0;
        empID_FK = 0;
        storeID_FK = 0;
        payCount = 1;
        empCount = 1;
        storeCount = 1;

    }

    public Payroll(String date, double hours, double wage, double otHours,
            double otWage) {
        this.date = date;
        this.hours = hours;
        this.wage = wage;
        this.otHours = otHours;
        this.otWage = otWage;
        payID = payCount++;
        empID_FK = empCount++;
        storeID_FK = storeCount++;
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

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHours() {
        return this.hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getWage() {
        return this.wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getOtHours() {
        return this.otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public double getOtWage() {
        return this.otWage;
    }

    public void setOtWage(double otWage) {
        this.otWage = otWage;
    }

}
