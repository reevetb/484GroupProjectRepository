package BookIT;

public class Coffee_Shop extends Inventory {

    private String food_genre;

    public Coffee_Shop() {
        food_genre = "";
    }

    public Coffee_Shop(String food_genre, String itemName, String itemDesc, double price, int quantity) {
        super(itemName, itemDesc, price, quantity);
        this.food_genre = food_genre;
    }

//getters & setters
    public String getFoodGenre() {
        return this.food_genre;
    }

    public void setFoodGenre(String food_genre) {
        this.food_genre = food_genre;
    }

}
