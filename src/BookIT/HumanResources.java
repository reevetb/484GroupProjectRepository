/*
Author: Kyle Porter
Date: 6/20/17
Assignment: CIS 484 Group Project
Purpose: Human Resource entity class used as a bridge table between employees
and stores
 */
package BookIT;
/**
 *
 * @author KP
 */
public class HumanResources {
    
    public int empID;
    public int storeID;
    public String empType;
    
    // constructor
    public HumanResources()
    {
        
        
        
        
    }
    
    // getters & setters
    public int getEmpID()
    {
        return this.empID;
    }
    
    public void setEmpID(int ID)
    {
        this.empID = ID;
    }
    
    public int getStoreID()
    {
        return this.storeID;
    }
    
    public void setStoreID(int ID)
    {
        this.storeID = ID;
    }
    
    public String getEmpType()
    {
        return this.empType;
    }
    
    public void setEmpType(String type)
    {
        this.empType = type;
    }
    
    
}
