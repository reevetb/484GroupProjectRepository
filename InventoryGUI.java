package BookIT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Marvin
 */

   
public class InventoryGUI extends Application {
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;
    
    Label lblItemName = new Label("Item Name:");
    Label lblItemDesc = new Label("Item Desc:");
    Label lblItemQuantity = new Label("Item Quantity:");
    Label lblItemType = new Label("Item Type:");
    Label lblItemPrice = new Label("Item Price:");
    TextField txtItemName = new TextField();
    TextField txtItemDesc = new TextField();
    TextField txtItemQuantity = new TextField();
    TextField txtItemType = new TextField();
    TextField txtItemPrice = new TextField();
    ComboBox<String> cbxType = new ComboBox();
    ListView lstInv = new ListView();
    Button btnInventoryAdd = new Button("Add Item");
    Button btnInventoryUpdate = new Button("Update Item");
    Button btnInventoryDelete = new Button("Delete Item");
    GridPane bookPane = new GridPane();
    Label lblBookAuthor = new Label("Author: ");
    Label lblBookGenre = new Label("Genre: ");
    Label lblBookISBN = new Label("ISBN: ");
    Label lblBookPublisher = new Label("Publisher: ");
    Label lblBookYear = new Label("Year: ");
    TextField txtBookAuthor = new TextField();
    TextField txtBookISBN = new TextField();
    ComboBox cbxBookGenre = new ComboBox();
    TextField txtBookPublisher = new TextField();
    TextField txtBookYear = new TextField();
    Button btnAddBook = new Button("Add Book");
    public static ArrayList<Inventory> invArray = new ArrayList();
    public static ArrayList<Book> bookArray = new ArrayList();
    public static ArrayList<Coffee_Shop> coffeeArray = new ArrayList();

    @Override
    public void start(Stage primaryStage) {

        GridPane inventoryPane = new GridPane();
        GridPane inventoryViewPane = new GridPane();
        GridPane inventoryPaneOverall = new GridPane();
        cbxType.getItems().addAll("Book", "Coffee");
        inventoryPane.setAlignment(Pos.CENTER);
        inventoryPane.add(lblItemName, 0, 0);
        inventoryPane.add(txtItemName, 1, 0);
        inventoryPane.add(lblItemDesc, 0, 1);
        inventoryPane.add(txtItemDesc, 1, 1);
        inventoryPane.add(lblItemPrice, 0, 2);
        inventoryPane.add(txtItemPrice, 1, 2);
        inventoryPane.add(lblItemQuantity, 0, 3);
        inventoryPane.add(txtItemQuantity, 1, 3);
        inventoryPane.add(lblItemType, 0, 4);
        inventoryPane.add(cbxType, 1, 4);
        inventoryPane.add(btnInventoryAdd, 0, 5);
        inventoryPane.add(btnInventoryUpdate, 1, 5);
        inventoryPane.add(btnInventoryDelete, 2, 5);
        inventoryViewPane.setAlignment(Pos.CENTER);
        inventoryPaneOverall.setAlignment(Pos.CENTER);
        inventoryViewPane.add(lstInv, 0, 0);
        inventoryPaneOverall.add(inventoryPane, 0, 0);
        inventoryPaneOverall.add(inventoryViewPane, 1, 0);
        Scene scene = new Scene(inventoryPaneOverall, 600, 400);
        primaryStage.setTitle("Inventory");
        primaryStage.setScene(scene);
        primaryStage.show();

        cbxBookGenre.getItems().addAll("Fiction", "Non-Fiction", "Mystery", "Fantasy/Sci-Fi", "Childrens", "Young Adult", "Educational",
                "Romance", "Horror", "Art");
        bookPane.setAlignment(Pos.CENTER);
        bookPane.add(lblBookISBN, 0, 0);
        bookPane.add(txtBookISBN, 1, 0);
        bookPane.add(lblBookAuthor, 0, 1);
        bookPane.add(txtBookAuthor, 1, 1);
        bookPane.add(lblBookGenre, 0, 2);
        bookPane.add(cbxBookGenre, 1, 2);
        bookPane.add(lblBookPublisher, 0, 3);
        bookPane.add(txtBookPublisher, 1, 3);
        bookPane.add(lblBookYear, 0, 4);
        bookPane.add(txtBookYear, 1, 4);
        bookPane.add(btnAddBook, 0, 5);

        Stage bookStage = new Stage();

        Scene bookScene = new Scene(bookPane, 400, 300);
        bookStage.setScene(bookScene);

        btnInventoryAdd.setOnAction(e -> {
            if (cbxType.getSelectionModel().getSelectedItem().equals("Book")) {
               
                      bookStage.show(); 

//                invArray.add(new Inventory(txtItemName.getText(), txtItemDesc.getText(),
//                            Integer.valueOf(txtItemQuantity.getText()), cbxType.getSelectionModel().getSelectedItem().toString(),
//                            Double.valueOf(txtItemPrice.getText())));
//
//                    Inventory tempRef1 = invArray.get(invArray.size() - 1);
//                 System.out.println("inventory array size: " + invArray.size());
//                    lstInv.getItems().add(tempRef1);
//                    System.out.println("Here is the index: " + tempRef1);
//                    tempRef1.setInvID(invArray.size());
            }
            if (cbxType.getSelectionModel().getSelectedItem().equals("Cafe")){
//                invArray.add(new Inventory(txtItemName.getText(), txtItemDesc.getText(),
//                            Integer.valueOf(txtItemQuantity.getText()), cbxType.getSelectionModel().getSelectedItem().toString(),
//                            Double.valueOf(txtItemPrice.getText())));
//
//                    Inventory tempRef1 = invArray.get(invArray.size() - 1);
//                    tempRef1.setInvID(invArray.size());
//                 System.out.println("inventory array size: " + invArray.size());
//                    lstInv.getItems().add(tempRef1);
//                    System.out.println("Here is the index: " + tempRef1);
                    insertInventory();
            }
        });
        btnAddBook.setOnAction(e->{
            
//            bookArray.add(new Book(txtBookISBN.getText(), cbxBookGenre.getSelectionModel().getSelectedItem().toString(),
//         txtBookAuthor.getText(), txtBookPublisher.getText(), Integer.valueOf(txtBookYear.getText()),
//         txtItemName.getText(), txtItemDesc.getText(), Integer.valueOf(txtItemQuantity.getText()),
//         cbxType.getSelectionModel().getSelectedItem().toString(), Double.valueOf(txtItemPrice.getText())));
//         
//             
//             Book tempRef2 = bookArray.get(bookArray.size() - 1);
//             invArray.add(tempRef2);
//             tempRef2.setInvID(invArray.size());
////             tempRef2.setBookID(invArray.get(invArray.size() - 1).getInvID());
//             lstInv.getItems().add(tempRef2);
//             
             insertInventory();
             
//             
//             System.out.println("Here is the index: " + tempRef2);
//             System.out.println(tempRef2.getInvID());
        });
        btnInventoryUpdate.setOnAction(e->{
//            for (int i = 0; i < invArray.size(); i++) {
//                invArray.get(i).setItemName(String.valueOf(txtItemName.getText()));
//                invArray.get(i).setItemDesc(String.valueOf(txtItemDesc.getText()));
//                invArray.get(i).setQuantity(Integer.valueOf(txtItemQuantity.getText()));
//                invArray.get(i).setType(String.valueOf(cbxType.getSelectionModel().getSelectedItem().toString()));
//                invArray.get(i).setPrice(Double.valueOf(txtItemPrice.getText()));
//                lstInv.getItems().remove(i).toString();
//                lstInv.getItems().add(invArray.get(invArray.size() - 1));
//                System.out.println("update! here: " + invArray.get(i));
//            }
            updateInventory();
        });
        btnInventoryDelete.setOnAction(e->{
            //when you delete it changes the id numbers around its not setting them to where the last item stopped
//            for (int i = 0; i < invArray.size(); i++) {
//                invArray.get(invArray.size() - 1);
//                lstInv.getItems().remove(i);
//               
//            }
             deleteInventory();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
public void insertInventory()
    {
        // creating the products     
        Inventory invRef = new Inventory();
        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.Inventory (Inv_ID, Item_Name, Item_Desc, Item_Price, Item_Quantity,"
                + " ISBN, Genre, Author, Publisher, Book_Year, Type) VALUES (";
        sqlQuery += "'" + Integer.valueOf(invRef.getInvID()) + "',";
        sqlQuery += "'" + txtItemName.getText() + "',";
        sqlQuery += "'" + txtItemDesc.getText() + "',";
        sqlQuery += "'" + Double.parseDouble(txtItemPrice.getText()) + "',";
        sqlQuery += "'" + Integer.parseInt(txtItemQuantity.getText()) + "',";
        sqlQuery += "'" + cbxType.getSelectionModel().getSelectedItem().toString() + "',";
        sqlQuery += "'" + txtBookISBN.getText() + "',";
        sqlQuery += "'" + cbxBookGenre.getSelectionModel().getSelectedItem().toString() + "',";
        sqlQuery += "'" + txtBookAuthor.getText() + "',";
        sqlQuery += "'" + txtBookPublisher.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtBookYear.getText()) + "')";
        sendDBCommand(sqlQuery);
        lstInv.getItems().add(sqlQuery);
    }
public void updateInventory()
{      Inventory invRef = new Inventory();
    String sqlQuery = "";
        sqlQuery = "UPDATE BOOKITDB.Inventory SET ITEM_NAME=" 
                + "'" + txtItemName.getText() + "', Item_Desc=" 
                + "'" + txtItemDesc.getText() + "', Item_Price=" 
                + "'" + Double.parseDouble(txtItemPrice.getText()) + "', Item_Quantity=" 
                + "'" + Integer.parseInt(txtItemQuantity.getText()) + "', ISBN=" 
                + "'" + txtBookISBN.getText() + "', Genre=" 
                + "'" + cbxBookGenre.getSelectionModel().getSelectedItem().toString() + "', Author=" 
                + "'" + txtBookAuthor.getText() + "', Publisher=" 
                + "'" + txtBookPublisher.getText() + "', Book_Year=" 
                + "'" + Integer.parseInt(txtBookYear.getText()) + "' WHERE INV_ID='" + Integer.valueOf(invRef.getInvID()) + "'";
        lstInv.getItems().add(sqlQuery);
        sendDBCommand(sqlQuery);
}
public void deleteInventory()
{
    Inventory invRef = new Inventory();
     String sqlQuery = "";
        // delete products  from DB
        sqlQuery = "DELETE FROM BOOKITDB.Inventory WHERE Inv_ID='"
                + Integer.valueOf(invRef.getInvID()) + "'";
        
        sendDBCommand(sqlQuery);
}
 public void sendDBCommand(String sqlQuery) {
        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:derby://localhost:1527/BOOKITDB [BOOKITDB on BOOKITDB]";
        String userID = "BOOKITDB"; // Change to YOUR Oracle username
        String userPASS = "OVALTINE"; // Change to YOUR Oracle password
        OracleDataSource ds;

        // Clear Box Testing - Print each query to check SQL syntax
        //  sent to this method.
        // You can comment this line out when your program is finished
        System.out.println(sqlQuery);

        // Lets try to connect
        try {
            // instantiate a new data source object
            ds = new OracleDataSource();
            // Where is the database located? Web? Local?
            ds.setURL(URL);
            // Send the user/pass and get an open connection.
            dbConn = ds.getConnection(userID, userPASS);
            // When we get results
            //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
            //   will see our resultset update in real time.
            //  -CONCUR_READ_ONLY means that we cannot accidentally change the
            //   data in our database by using the .update____() methods of
            //   the ResultSet class - TableView controls are impacted by
            //   this setting as well.
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // We send the query to the DB. A ResultSet object is instantiated
            //  and we are returned a reference to it, that we point to from
            // dbResults.
            // Because we declared dbResults at the datafield level
            // we can see the results from anywhere in our Class.
            dbResults = commStmt.executeQuery(sqlQuery); // Sends the Query to the DB
            // The results are stored in a ResultSet structure object
            // pointed to by the reference variable dbResults
            // Because we declared this variable globally above, we can use
            // the results in any method in the class.
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}

        

