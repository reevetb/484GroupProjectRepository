/*
Author: Kyle Porter
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Purchase Orders entity class to see which items suppliers are supplying
 */
package BookIT.V2;

import BookIT.*;

/**
 *
 * @author KP
 */
public class PurchaseOrders {

    private int supplierID;
    private int invID;
    private int quantity;
    public static int supplierCount;
    public static int invCount;

    // constructor
    public PurchaseOrders() {
        supplierID = 0;
        invID = 0;
        quantity = 0;
        supplierCount = 1;
        invCount = 1;
    }

    public PurchaseOrders(int quantity) {
        this.quantity = quantity;
        supplierID = supplierCount++;
        invID = invCount++;

    }

    // getters & setters
    public int getSupplierID() {
        return this.supplierID;
    }

    public int getInvID() {
        return this.invID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
