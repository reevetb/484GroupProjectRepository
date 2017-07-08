/*
* Authors: DMO CONSULTING LLC
* Date: 7/8/2017
*  
* Purpose: TO DEVELOP AN IS SYSTEM FOR BOOK BURG BOOK STORE
* DESCRIPTION: THIS CLASS CREATES AN ENCYCLOPEDIA FOR OUR ORDER OBJECTS
*/
package BookIT.V2;

import BookIT.*;

/**
 *
 * @author KP
 */
public class Orders {

    private int storeID;
    private int custID;
    private int invID;
    private String orderDate;
    public static int storeCount;
    public static int custCount;
    public static int invCount;

    // constructor
    public Orders() {
        storeID = 0;
        custID = 0;
        invID = 0;
        orderDate = "";
        storeCount = 1;
        custCount = 1;
        invCount = 1;

    }

    public Orders(String orderDate) {
        this.orderDate = orderDate;
        storeID = storeCount++;
        custID = custCount++;
        invID = invCount++;
    }

    // getters & setters
    public int getStoreID() {
        return this.storeID;
    }

    public int getCustID() {
        return this.custID;
    }

    public int getInvID() {
        return this.invID;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String date) {
        this.orderDate = date;
    }

}
