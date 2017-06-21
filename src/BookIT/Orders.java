/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Order entity class storing orders that customers purchase
 */
package BookIT;
/**
 *
 * @author KP
 */
public class Orders {
    
    public int storeID;
    public int custID;
    public int invID;
    public String orderDate;
    
    // constructor
    public Orders()
    {
        
        
        
    }
    
    // getters & setters
    public int getStoreID()
    {
        return this.storeID;
    }
    
    public void setStoreID(int ID)
    {
        this.storeID = ID;
    }
    
    public int getCustID()
    {
        return this.custID;
    }
    
    public void setCustID(int ID)
    {
        this.custID = ID;
    }
    
    public int getInvID()
    {
        return this.invID;
    }
    
    public void setInvID(int ID)
    {
        this.invID = ID;
    }
    
    public String getOrderDate()
    {
        return this.orderDate;
    }
    
    public void setOrderDate(String date)
    {
        this.orderDate = date;
    }
    
    
}
