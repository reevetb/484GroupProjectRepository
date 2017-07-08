/*
* Authors: DMO CONSULTING LLC
* Date: 7/8/2017
*  
* Purpose: TO DEVELOP AN IS SYSTEM FOR BOOK BURG BOOK STORE
* DESCRIPTION: THIS CLASS EXTENDS FROM INVENTORY TO DESCRIBE BOOK ITEMS
 */
//package BookIT.V2;

public class Book extends Inventory {

    private String isbn;
    private String genre;
    private String author;
    private String publisher;
    private int bookYr;

    public Book() {
        isbn = "";
        genre = "";
        author = "";
        publisher = "";
        bookYr = 0;
    }
    
    public Book(String itemName, String itemDesc, int quantity, double itemPrice, String itemType, 
                String isbn, String genre, String author, String publisher, int bookyear)
    {
        super(itemName, itemDesc, quantity, itemPrice, itemType);
       
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.bookYr = bookYr;
      
    }

    public Book(int invID, String itemName, String itemDesc, int quantity, double itemPrice, String itemType, 
                String isbn, String genre, String author, String publisher, int bookyear)
    {
        super(invID, itemName, itemDesc, quantity, itemPrice, itemType);
       
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.bookYr = bookYr;
    }

    //getters & setters
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getBookYr() {
        return this.bookYr;
    }

    public void setBookYr(int bookYr) {
        this.bookYr = bookYr;
    }
    
//    @Override
//    public String toString()
//    {
//        return "Book Title: " + this.getItemName() 
//                + "\n Author: " + author
//                + "\n Year: " + bookYr
//                + "\n Price: " + this.getPrice();
//    }
}
