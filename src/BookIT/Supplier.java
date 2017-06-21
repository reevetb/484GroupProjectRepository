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
    
    public int supplierID;
    public String name;
    public String street;
    public String city;
    public String state;
    public int zip;
    public String cell;
    
    // constructor
    public Supplier()
    {
        
        
        
        
    }
    
    // getters & setters
    public int getSupplierID()
    {
        return this.supplierID;
    }
    
    public void setSupplierID(int ID)
    {
        this.supplierID = ID;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
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
    
    
    
}
