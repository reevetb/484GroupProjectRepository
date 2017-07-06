/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Inventory entity class 
 */
package BookIT.V2;

/**
 *
 * @author KP
 */
public class Inventory {

    private int invID;
    private String itemName;
    private String itemDesc;
    private int quantity;
    private String itemType;
    private double itemPrice;
    public static int invCount;

    // constructor
    public Inventory() {
        invID = 0;
        itemName = "";
        itemDesc = "";
        quantity = 0;
        itemType ="";
        itemPrice =0.00;
        invCount = 1;
    }

    public Inventory(String itemName, String itemDesc, int quantity, String type, double price) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.quantity = quantity;
        this.itemType = type;
        this.itemPrice = price;
        invID = invCount++;

    }

    // getters & setters
    public int getInvID() {
        return this.invID;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String item) {
        this.itemName = item;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public void setItemDesc(String desc) {
        this.itemDesc = desc;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice()
    {
        return this.itemPrice;
    }
    
    public void setPrice(double price)
    {
        this.itemPrice = price;
    }
    public String getType()
    {
        return this.itemType;
    }
    
    @Override
    public String toString()
    {
        return "Item: " + this.getItemName()
                + "\n Price: " + this.getPrice();
    }

}