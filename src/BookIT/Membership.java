/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Membership entity class to keep track of customer's membership status
 */
package BookIT;
/**
 *
 * @author KP
 */
public class Membership {
    
    public int custID;
    public int storeID;
    public int points;
    public String status;
    
    // constructor
    public Membership()
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
    
    public int getStoreID()
    {
        return this.storeID;
    }
    
    public void setStoreID(int ID)
    {
        this.storeID = ID;
    }
    
    public int getPoints()
    {
        return this.points;
    }
    
    public void setPoints(int points)
    {
        this.points = points;
    }
    
    public String getStatus()
    {
        return this.status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
}
