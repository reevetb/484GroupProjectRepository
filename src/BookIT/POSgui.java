/*
 * Author: Daniel Baker
 * Date: 
 * Assignment: 
 * Purpose: 
 */
package BookIT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;



/**
 *
 * @author Daniel
 */
public class POSgui extends Application {
    
      Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;
    
    ListView<Inventory> cafeView = new ListView<>();
    ListView<Inventory> bookView = new ListView<>();
    ListView<Inventory> totalsView = new ListView<>();
    ArrayList<Inventory> mainArray = new ArrayList<>();
    
    
    
    TextArea taPay = new TextArea();
    
    
    Label lblSubtotal = new Label ("Subtotal: ");
    Label lblTax = new Label ("Tax: ");
    Label lblTotal = new Label ("Total: ");
    Label lblQty = new Label ("QTY: ");
    Button btnFinalPay = new Button ("Pay -->");
    Label lblMemberID = new Label ("Member ID: ");
    ComboBox cbxMemberID = new ComboBox();
    
    
    TabPane tbPane = new TabPane();
    Tab tab1 = new Tab ("Books");
    Tab tab2 = new Tab ("Cafe");
    
    
    GridPane overallPane = new GridPane();
    GridPane cashPane = new GridPane();
    GridPane bookPane = new GridPane();
    GridPane bookPaneRight = new GridPane();
    GridPane bookPaneLeft = new GridPane();
    GridPane cafePane = new GridPane();
    GridPane cafePaneRight = new GridPane();
    GridPane cafePaneLeft = new GridPane();
    GridPane totalPane = new GridPane();
    GridPane totalPaneRight = new GridPane();
    GridPane totalPaneLeft = new GridPane();
    
    
    Button btn1 = new Button ("1");
    Button btn2 = new Button ("2");
    Button btn3 = new Button ("3");
    Button btn4 = new Button ("4");
    Button btn5 = new Button ("5");
    Button btn6 = new Button ("6");
    Button btn7 = new Button ("7");
    Button btn8 = new Button ("8");
    Button btn9 = new Button ("9");
    Button btn0 = new Button ("0");
    Button btnDecimal = new Button (".");
    Button btnDouble0 = new Button ("00");
    Button btnHundred = new Button ("100");
    Button btnFifty = new Button ("50");
    Button btnTwenty = new Button ("20");
    Button btnTen = new Button ("10");
    Button btnItemUp = new Button ("+");
    Button btnItemDown = new Button ("-");
    Button btnCard = new Button ("CC/Debit");
    Button btnPay = new Button ("Pay");
    Button btnFilter = new Button ("Filter");
    Button btnSearch = new Button ("Search");
    Button btnAddBook = new Button ("Add");
    Button btnAddCafe = new Button ("Add");
    TextField txtSubtotal = new TextField();
    TextField txtTax = new TextField();
    TextField txtTotal = new TextField();
    TextField txtPayment= new TextField();
    VBox payButtons = new VBox();
    
    Inventory newItem;
    Inventory newBook;
    
    ArrayList <Inventory> itemTotals = new ArrayList<>();
    
    double orderSubtotal;
    double orderTax;
    double orderTotal;
    double total = 0.00;
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
        
        overallPane.setAlignment(Pos.CENTER);
        
        tab1.setContent(bookPane);
        tab1.setClosable(false);
        tab2.setContent(cafePane);
        tab2.setClosable(false);
        
        tbPane.getTabs().addAll(tab1,tab2);
        
        bookPane.setAlignment(Pos.CENTER);        
        bookPaneRight.setAlignment(Pos.CENTER);        
        bookPaneLeft.setAlignment(Pos.CENTER);        
        bookPaneRight.add(bookView,0,0);
        bookPaneLeft.add(btnFilter,1,0);
        bookPaneLeft.add(btnSearch,1,1);
        bookPaneLeft.add(btnAddBook,1,2);
        bookPane.add(bookPaneRight,0,0);
        bookPane.add(bookPaneLeft,1,0);
        
        cafePane.setAlignment(Pos.CENTER);
        cafePaneRight.setAlignment(Pos.CENTER);
        cafePaneLeft.setAlignment(Pos.CENTER);
        cafePaneRight.add(cafeView,0,0);
        cafePaneLeft.add(btnAddCafe,0,0);
        cafePane.add(cafePaneRight,0,0);
        cafePane.add(cafePaneLeft,1,0);
        
        cashPane.setAlignment(Pos.CENTER);
        cashPane.add(btn7,0,0);
        cashPane.add(btn8,1,0);
        cashPane.add(btn9,2,0);
        cashPane.add(btnHundred,3,0);
        cashPane.add(btn4,0,1);
        cashPane.add(btn5,1,1);
        cashPane.add(btn6,2,1);
        cashPane.add(btnFifty,3,1);
        cashPane.add(lblQty,4,0);
        cashPane.add(btnItemUp,5,0);
        cashPane.add(btn1,0,3);
        cashPane.add(btn2,1,3);
        cashPane.add(btn3,2,3);
        cashPane.add(btnTwenty,3,3);
        cashPane.add(btnItemDown,5,1);
        cashPane.add(btn0,0,4);
        cashPane.add(btnDecimal,1,4);
        cashPane.add(btnDouble0,2,4);
        cashPane.add(btnCard,2,5);
        cashPane.add(btnPay,0,5);
        txtPayment.setMaxWidth(35);        
        cashPane.add(txtPayment,1,5);
        
        
        
        totalPane.setAlignment(Pos.CENTER);
        totalPaneLeft.setAlignment(Pos.CENTER);
        totalPaneRight.setAlignment(Pos.CENTER);
        taPay.setMaxSize(150,150);
        totalPaneRight.add(taPay,0,0);
        totalPaneLeft.add(lblSubtotal,1,0);
        totalPaneLeft.add(txtSubtotal,2,0);
        totalPaneLeft.add(lblTax,1,1);
        totalPaneLeft.add(txtTax,2,1);
        totalPaneLeft.add(lblTotal,1,2);
        totalPaneLeft.add(txtTotal,2,2);
        totalPaneLeft.add(lblMemberID,1,3);
        totalPaneLeft.add(cbxMemberID,2,3);
        totalPaneLeft.add(btnFinalPay,1,4);
        totalPane.add(totalPaneRight,1,0);
        totalPane.add(totalPaneLeft,0,0);
        
        totalsView.setMaxSize(300, 450);
        
        
        overallPane.setHgap(10);
        overallPane.setVgap(10);
        
        overallPane.add(totalsView,0,0);
        overallPane.add(tbPane,1,0);
        overallPane.add(totalPane,0,1);
        overallPane.add(cashPane,1,1);
        
        Scene posScene = new Scene(overallPane,700,700);
        primaryStage.setScene(posScene);
        primaryStage.setTitle("POS");
        primaryStage.show(); 
        
        fillInventoryBook();
        fillInventoryCafe();  
        fillCbxMember();
        cbxMemberID.getItems().addAll("Guest");
        
        
        cafeView.setOnMouseClicked(e->{            
            
            newItem = cafeView.getSelectionModel().getSelectedItem();            
            
            do{
            itemTotals.add(newItem);
            ObservableList<Inventory> cafeList = FXCollections.observableArrayList(itemTotals);
            totalsView.setItems(cafeList);
            }
            while(primaryStage.hasProperties());   
            
            for(Inventory a: itemTotals)
            {
                total = a.getPrice();
                
            }
           orderSubtotal+=total;
        
            txtSubtotal.setText(orderSubtotal+""); 
            txtTax.setText((orderSubtotal*0.06)+"");
            txtTotal.setText( Double.valueOf(txtTax.getText()) + Double.valueOf(txtSubtotal.getText()) +"");
        });
        
        bookView.setOnMouseClicked(j->{
            newBook = bookView.getSelectionModel().getSelectedItem();
            
            
            do{
                itemTotals.add(newBook);
                ObservableList<Inventory> bookList = FXCollections.observableArrayList(itemTotals);
                totalsView.setItems(bookList);
            }
            while(primaryStage.hasProperties());

            for(Inventory a: itemTotals)
            {
                total = a.getPrice();
                
            }
           orderSubtotal+=total;
        
            txtSubtotal.setText(orderSubtotal+"");
            txtTax.setText((orderSubtotal*0.06)+"");
            txtTotal.setText( Double.valueOf(txtTax.getText()) + Double.valueOf(txtSubtotal.getText()) +"");
        });        
        
    }
    

    
    public void fillInventoryBook() throws SQLException
    {
        String sqlQuery ="";
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE = 'Book'";
        
        ArrayList<Book> bookArray = new ArrayList<>();
        
        sendDBCommand(sqlQuery);
        while(dbResults.next())
              {
                  bookArray.add(new Book(dbResults.getString(6),dbResults.getString(7),dbResults.getString(8),dbResults.getString(9),
                  Integer.valueOf(dbResults.getString(10)),dbResults.getString(2),dbResults.getString(3),Integer.valueOf(dbResults.getString(4)),
                  dbResults.getString(11),Double.valueOf(dbResults.getString(5)))); 
                                   
              } 
         
                ObservableList<Inventory> bookList = FXCollections.observableArrayList(bookArray);
                  
                bookView.setItems(bookList);              
          }       
    
    public void fillInventoryCafe () throws SQLException
    {
        String sqlQuery = "";
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE = 'Cafe'";
        
        ArrayList <Inventory> cafeArray = new ArrayList<>();
        
        sendDBCommand(sqlQuery);
        while(dbResults.next())
        {
            cafeArray.add(new Inventory(dbResults.getString(2),dbResults.getString(3),
                    Integer.valueOf(dbResults.getString(4)),dbResults.getString(11),Double.valueOf(dbResults.getString(5))));
        }
        
        ObservableList<Inventory> cafeList = FXCollections.observableArrayList(cafeArray);
        
        cafeView.setItems(cafeList);
    }
    
    public void fillCbxMember() throws SQLException
    {
        String sqlQuery = "";
        sqlQuery ="SELECT * FROM BOOKITDB.MEMBERS";
        ArrayList<Member> memberArray = new ArrayList<>();
        
        sendDBCommand(sqlQuery);
        while(dbResults.next())
        {
            memberArray.add(new Member(Integer.valueOf(dbResults.getString(1)),dbResults.getString(2),dbResults.getString(3),dbResults.getString(4),
            dbResults.getString(5),dbResults.getString(6),Integer.valueOf(dbResults.getString(7)),dbResults.getString(8),dbResults.getString(9),dbResults.getString(10),
            dbResults.getString(11)));
        }
        ObservableList<Member> memberList = FXCollections.observableArrayList(memberArray);
        cbxMemberID.getItems().addAll(memberList);

    }
    

    
    public void sendDBCommand(String sqlQuery)
    {
        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "BOOKITDB"; // Change to YOUR Oracle username
        String userPASS = "OVALTINE"; // Change to YOUR Oracle password
        OracleDataSource ds;
        
        // Clear Box Testing - Print each query to check SQL syntax
        //  sent to this method.
        // You can comment this line out when your program is finished
        System.out.println(sqlQuery);
        
        // Lets try to connect
        try
        {
            // instantiate a new data source object
            ds = new OracleDataSource();
            // Where is the database located? Web? Local?
            ds.setURL(URL);
            // Send the user/pass and get an open connection.
            dbConn = ds.getConnection(userID,userPASS);
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
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
