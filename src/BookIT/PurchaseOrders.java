/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Purchase Orders entity class to see which items suppliers are supplying
 */
package BookIT;

/**
 *
 * @author KP
 */
public class PurchaseOrders {
    
    public int supplierID;
    public int invID;
    public int quantity;
    
    // constructor
    public PurchaseOrders()
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
    
    public int getInvID()
    {
        return this.invID;
    }
    
    public void setInvID(int ID)
    {
        this.invID = ID;
    }
    
    public int getQuantity()
    {
        return this.quantity;
    }
    
    public void setQuantity(int quan)
    {
        this.quantity = quan;
    }
    
    
}
