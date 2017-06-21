/*
Author: Kyle Porter
Date: 6/20/17
Assignment: CIS 484 Group Project
Purpose: Store entity class
 */
package BookIT;
/**
 *
 * @author KP
 */
public class Store {
    
    public int storeID;
    public String street;
    public String city;
    public String state;
    public int zip;
    public double utilExp;
    
    // constructor
    public Store()
    {
        
        
        
        
        
    }
    
    public int getStoreID()
    {
        return this.storeID;
    }
    
    public void setStoreID(int ID)
    {
        this.storeID = ID;
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
    
    public double getUtilExp()
    {
        return this.utilExp;
    }
    
    public void setUtilExp(double util)
    {
        this.utilExp = util;
    }
    
}
