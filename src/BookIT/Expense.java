/*
 * Author: Daniel Baker
 * Date: 
 * Assignment: 
 * Purpose: 
 */
package BookIT;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class Expense {
    public int expenseID;
    public String expenseType;
    public double expensePrice;
    public LocalDate expenseDate;
    public String expenseComments;
    
    public static int expID = 0;
    
    public Expense(String type, double price, LocalDate date, String comments)
    {
        this.expenseID = ++expID;
        this.expenseType = type;
        this.expensePrice = price;
        this.expenseDate = date;
        this.expenseComments = comments;        
    }
    
    public void setType (String type)
    {
        this.expenseType = type;
    }
    public void setPrice (double price)
    {
        this.expensePrice = price;
    }
    public void setDate (LocalDate date)
    {
        this.expenseDate = date;
    }
    public void setComments (String comments)
    {
        this.expenseComments = comments;
    }
    public void setID(int id)
    {
        this.expenseID = id;
    }
    
    public String getType()
    {
        return this.expenseType;
    }
    public String getComments()
    {
        return this.expenseComments;
    }
    public double getPrice()
    {
        return this.expensePrice;
    }
    public int getID()
    {
        return this.expenseID;
    }
    public LocalDate getDate()
    {
        return this.expenseDate;
    }
}
