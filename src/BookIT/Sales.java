/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Sales entity class in order to see which inventory is in what store
 */
package BookIT;
/**
 *
 * @author KP
 */
public class Sales {
    
    public int invID;
    public int storeID;
    public int qis;
    public double price;
    
    // constructor
    public Sales()
    {
        
        
        
        
    }
    
    // getters & setters
    public int getInvID()
    {
        return this.invID;
    }
    
    public void setInvID(int ID)
    {
        this.invID = ID;
    }
    
    public int getStoreID()
    {
        return this.storeID;
    }
    
    public void setStoreID(int ID)
    {
        this.storeID = ID;
    }
    
    public int getQIS()
    {
        return this.qis;
    }
    
    public void setQIS(int qis)
    {
        this.qis = qis;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
}
