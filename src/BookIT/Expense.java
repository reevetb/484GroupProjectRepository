///*
// * Author: Daniel Baker
// * Date: 
// * Assignment: 
// * Purpose: 
// */
//package BookIT;
//
//import java.time.LocalDate;
//
///**
// *
// * @author Daniel
// */
//public class Expense {
//    private int expenseID;
//    private String expenseType;
//    private double expensePrice;
//    private LocalDate expenseDate;
//    private String expenseComments;
//    
//    public static int expID = 0;
//    
//    public Expense(String type, double price, LocalDate date, String comments)
//    {
//        this.expenseID = ++expID;
//        this.expenseType = type;
//        this.expensePrice = price;
//        this.expenseDate = date;
//        this.expenseComments = comments;        
//    }
//    
//    public void setType (String type)
//    {
//        this.expenseType = type;
//    }
//    public void setPrice (double price)
//    {
//        this.expensePrice = price;
//    }
//    public void setDate (LocalDate date)
//    {
//        this.expenseDate = date;
//    }
//    public void setComments (String comments)
//    {
//        this.expenseComments = comments;
//    }
//   
//    
//    public String getType()
//    {
//        return this.expenseType;
//    }
//    public String getComments()
//    {
//        return this.expenseComments;
//    }
//    public double getPrice()
//    {
//        return this.expensePrice;
//    }
//    public int getID()
//    {
//        return this.expenseID;
//    }
//    public LocalDate getDate()
//    {
//        return this.expenseDate;
//    }
//}
