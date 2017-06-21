/*
Author: Kyle Porter
Date: 6/20/17
Assignment: CIS 484 Group Project
Purpose: Employee entity class
 */
package BookIT;
/**
 *
 * @author KP
 */
public class Employee {
    
    public int empID;
    public String fName;
    public String lName;
    public String street;
    public String city;
    public String state;
    public int zipCode;
    public String permLevel;
    public int managerID;
    public String username;
    public String password;
    
    // constructor
    public Employee()
    {
        
        
        
        
    }
    
    public int getEmpID()
    {
        return this.empID;
    }
    
    public void setEmpID(int empID)
    {
        this.empID = empID;
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
    
    public int getZipCode()
    {
        return this.zipCode;
    }
    
    public void setZipCode(int zip)
    {
        this.zipCode = zip;
    }
    
    public String getPermLevel()
    {
        return this.permLevel;
    }
    
    public void setPermLevel(String level)
    {
        this.permLevel = level;
    }
    
    public int getManagerID()
    {
        return this.managerID;
    }
    
    public void setManagerID(int ID)
    {
        this.managerID = ID;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setUsername(String user)
    {
        this.username = user;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String pass)
    {
        this.password = pass;
    }
    
    
}
