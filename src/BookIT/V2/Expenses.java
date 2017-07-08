/*
* Authors: DMO CONSULTING LLC
* Date: 7/8/2017
*  
* Purpose: TO DEVELOP AN IS SYSTEM FOR BOOK BURG BOOK STORE
* DESCRIPTION: THIS CLASS CREATES AN ENCYCLOPEDIA FOR OUR EXPENSE OBJECTS
*/

package BookIT.V2;

import BookIT.*;

public class Expenses {

    private int invoiceNum;
    private String expType;
    private String expDate;
    private double expCost;
    private String expDesc;
    private int storeID_FK;
    public static int invoiceCount = 0;
    public static int storeCount = 0;

    public Expenses() {
        invoiceNum = invoiceCount++;
        expType = "";
        expDate = "";
        expCost = 0.0;
        expDesc = "";
        storeID_FK = 0;
        
        storeCount++;
    }

    public Expenses(String expType, String expDate, double expCost,
            String expDesc, int store_id) {
        this.expType = expType;
        this.expDate = expDate;
        this.expCost = expCost;
        this.expDesc = expDesc;
        invoiceNum = invoiceCount++;
        this.storeID_FK = store_id;
        storeCount++;
    }
    
    public Expenses(int invoiceNum, String expType, String expDate, double expCost,
            String expDesc, int store_id) {
        this.expType = expType;
        this.expDate = expDate;
        this.expCost = expCost;
        this.expDesc = expDesc;
        this.invoiceNum = invoiceNum;
        this.storeID_FK = store_id;
        storeCount++;
        invoiceCount++;
    }

    public int getInvoiceNum() {
        return this.invoiceNum;
    }

    public int getStoreID_FK() {
        return this.storeID_FK;
    }

    public String getExpType() {
        return this.expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public double getExpCost() {
        return this.expCost;
    }

    public void setExpCost(double expCost) {
        this.expCost = expCost;
    }

    public String getExpDesc() {
        return this.expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
    }
     @Override
    public String toString()
    {
        return "InvoiceNumber: " + this.getInvoiceNum()
                + "\n\t Expense Type: " + this.getExpType()
                + "\n\t Expense Date: " + this.getExpDate()
                + "\n\t Expense Cost: " + this.getExpCost()
                + "\n\t Expense Desc: " + this.getExpDesc()
                + "\n\t Store ID: " + this.getStoreID_FK();
    }
}
