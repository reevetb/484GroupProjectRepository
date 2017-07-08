/*
* Authors: DMO CONSULTING LLC
* Date: 7/8/2017
*  
* Purpose: TO DEVELOP AN IS SYSTEM FOR BOOK BURG BOOK STORE
* DESCRIPTION: THIS CLASS CREATES AN ENCYCLOPEDIA FOR OUR SALES OBJECTS
*/
package BookIT.V2;

import BookIT.*;

/**
 *
 * @author KP
 */
public class Sales {

    private int invID;
    private int storeID;
    private int qis;
    private double price;
    public static int invCount;
    public static int storeCount;

    // constructor
    public Sales() {
        invID = 0;
        storeID = 0;
        qis = 0;
        price = 0.0;
        invCount = 1;
        storeCount = 1;
    }

    public Sales(int qis, double price) {
        this.qis = qis;
        this.price = price;
        invID = invCount++;
        storeID = storeCount++;

    }
    // getters & setters

    public int getInvID() {
        return this.invID;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public int getQis() {
        return this.qis;
    }

    public void setQis(int qis) {
        this.qis = qis;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
