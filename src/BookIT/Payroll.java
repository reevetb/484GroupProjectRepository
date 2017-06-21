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
    
    public String date;
    public double hours;
    public double wage;
    public double otHours;
    public double otWage;
    public int empID;
    
    // constructor
    public Payroll()
    {
        
        
        
        
    }
    
    // getters & setters
    public String getDate()
    {
        return this.date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public double getHours()
    {
        return this.hours;
    }
    
    public void setHours(double hours)
    {
        this.hours = hours;
    }
    
    public double getWage()
    {
        return this.wage;
    }
    
    public void setWage(double wage)
    {
        this.wage = wage;
    }
    
    public int getEmpID()
    {
        return this.empID;
    }
    
    public void setEmpID(int ID)
    {
        this.empID = ID;
    }
    
}
