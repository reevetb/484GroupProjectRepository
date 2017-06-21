/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Inventory entity class 
 */
package BookIT;
/**
 *
 * @author KP
 */
public class Inventory {
    
    public int invID;
    public String itemName;
    public String itemDesc;
    public int quantity;
    
    // constructor
    public Inventory()
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
    
    public String getItemName()
    {
        return this.itemName;
    }
    
    public void setItemName(String item)
    {
        this.itemName = item;
    }
    
    public String getItemDesc()
    {
        return this.itemDesc;
    }
    
    public void setItemDesc(String desc)
    {
        this.itemDesc = desc;
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
