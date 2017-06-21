/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Customer entity class to keep track of customers within the system
 */
package BookIT;
/**
 *
 * @author KP
 */
public class Customer {
    
    public int custID;
    public String fName;
    public String lName;
    public String street;
    public String city;
    public String state;
    public int zip;
    public String cell;
    public String email;
    
    // constructor
    public Customer()
    {
        
        
        
        
    }
    
    // getters & settors
    public int getCustID()
    {
        return this.custID;
    }
    
    public void setCustID(int ID)
    {
        this.custID = ID;
    }
    
    public String getFName()
    {
        return this.fName;
    }
    
    public void setFName(String name)
    {
        this.fName = name;
    }
    
    public String getLName()
    {
        return this.lName;
    }
    
    public void setLName(String name)
    {
        this.lName = name;
    }
    
    public String getStreet()
    {
        return this.street;
    }
    
    public void setStreet(String street)
    {
        this.street = street;
    }
    
    public String getCity()
    {
        return this.city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getState()
    {
        return this.state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public int getZip()
    {
        return this.zip;
    }
    
    public void setZip(int zip)
    {
        this.zip = zip;
    }
    
    public String getCell()
    {
        return this.cell;
    }
    
    public void setCell(String cell)
    {
        this.cell = cell;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
}
