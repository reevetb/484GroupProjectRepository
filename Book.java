package BookIT;

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

    public Book(String isbn, String genre, String author, String publisher,
            int bookYr, String itemName, String itemDesc, double price, int quantity) {
        super(itemName, itemDesc, price, quantity);
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
}
