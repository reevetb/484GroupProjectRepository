/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookIT.V2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Trenton
 */
public class ManagerView extends LoginMainForm {
    
    /**********************Overall View stuff***********************/
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;

    //listview and array lists
    ListView<Inventory> cafeView = new ListView<>();
    ListView<Inventory> bookView = new ListView<>();
    ListView<Inventory> totalsView = new ListView<>();
    ArrayList<Inventory> mainArray = new ArrayList<>();
    ArrayList<Inventory> itemTotals = new ArrayList<>();
    ListView empShiftView = new ListView();
    ListView employeeView = new ListView();
    ArrayList<Employee> employeeArray = new ArrayList<>();

    //overall stuff
    TabPane managerPane = new TabPane();
    Tab tab1 = new Tab("P.O.S.");
    Tab tab2 = new Tab("Employee");
    Tab tab3 = new Tab("Member");
    Tab tab4 = new Tab("Inventory");
    Tab tab5 = new Tab("Expenses");
    Tab tab6 = new Tab("Shifts");
    
    /**
     * ******************POS STUFF******************************************
     */
    TextArea taPay = new TextArea();

    ComboBox cbxMemberID = new ComboBox();

    Inventory newItem;
    Inventory newBook;

    double orderSubtotal;
    double orderTax;
    double orderTotal;
    double total = 0.00;

    Label lblSubtotal = new Label("Subtotal: ");
    Label lblTax = new Label("Tax: ");
    Label lblTotal = new Label("Total: ");
    Label lblQty = new Label("QTY: ");
    Label lblMemberID = new Label("Member ID: ");

    TabPane posPane = new TabPane();
    Tab booksTab = new Tab("Books");
    Tab cafeTab = new Tab("Cafe");

    //GridPane overallPane = new GridPane();
    GridPane posOverallPane = new GridPane();
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

    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("3");
    Button btn4 = new Button("4");
    Button btn5 = new Button("5");
    Button btn6 = new Button("6");
    Button btn7 = new Button("7");
    Button btn8 = new Button("8");
    Button btn9 = new Button("9");
    Button btn0 = new Button("0");
    Button btnDecimal = new Button(".");
    Button btnDouble0 = new Button("00");
    Button btnHundred = new Button("100");
    Button btnFifty = new Button("50");
    Button btnTwenty = new Button("20");
    Button btnTen = new Button("10");
    Button btnItemUp = new Button("+");
    Button btnItemDown = new Button("-");
    Button btnCard = new Button("CC/Debit");
    Button btnPay = new Button("Pay");
    Button btnFilter = new Button("Filter");
    Button btnSearch = new Button("Search");
    Button btnAddBook = new Button("Add");
    Button btnAddCafe = new Button("Add");
    Button btnFinalPay = new Button("Pay -->");

    TextField txtSubtotal = new TextField();
    TextField txtTax = new TextField();
    TextField txtTotal = new TextField();
    TextField txtPayment = new TextField();
    VBox payButtons = new VBox();
    
    Stage primaryStage = new Stage();
    
    //Manager View constructor
    public ManagerView() throws SQLException
    {
         //the overall view setup
        tab1.setContent(posOverallPane);
        tab1.setClosable(false);
        

        managerPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5, tab6);
        managerPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
 /**
         * ***********************Setting POS PANE**************************
         */
        posOverallPane.setAlignment(Pos.CENTER);

        booksTab.setContent(bookPane);
        booksTab.setClosable(false);
        cafeTab.setContent(cafePane);
        cafeTab.setClosable(false);

        posPane.getTabs().addAll(booksTab, cafeTab);

        bookPane.setAlignment(Pos.CENTER);
        bookPaneRight.setAlignment(Pos.CENTER);
        bookPaneLeft.setAlignment(Pos.CENTER);
        bookPaneRight.add(bookView, 0, 0);
        bookPaneLeft.add(btnFilter, 1, 0);
        bookPaneLeft.add(btnSearch, 1, 1);
        bookPaneLeft.add(btnAddBook, 1, 2);
        bookPane.add(bookPaneRight, 0, 0);
        bookPane.add(bookPaneLeft, 1, 0);

        cafePane.setAlignment(Pos.CENTER);
        cafePaneRight.setAlignment(Pos.CENTER);
        cafePaneLeft.setAlignment(Pos.CENTER);
        cafePaneRight.add(cafeView, 0, 0);
        cafePaneLeft.add(btnAddCafe, 0, 0);
        cafePane.add(cafePaneRight, 0, 0);
        cafePane.add(cafePaneLeft, 1, 0);

        cashPane.setAlignment(Pos.CENTER);
        cashPane.add(btn7, 0, 0);
        cashPane.add(btn8, 1, 0);
        cashPane.add(btn9, 2, 0);
        cashPane.add(btnHundred, 3, 0);
        cashPane.add(btn4, 0, 1);
        cashPane.add(btn5, 1, 1);
        cashPane.add(btn6, 2, 1);
        cashPane.add(btnFifty, 3, 1);
        cashPane.add(lblQty, 4, 0);
        cashPane.add(btnItemUp, 5, 0);
        cashPane.add(btn1, 0, 3);
        cashPane.add(btn2, 1, 3);
        cashPane.add(btn3, 2, 3);
        cashPane.add(btnTwenty, 3, 3);
        cashPane.add(btnItemDown, 5, 1);
        cashPane.add(btn0, 0, 4);
        cashPane.add(btnDecimal, 1, 4);
        cashPane.add(btnDouble0, 2, 4);
        cashPane.add(btnCard, 2, 5);
        cashPane.add(btnPay, 0, 5);
        txtPayment.setMaxWidth(35);
        cashPane.add(txtPayment, 1, 5);

        totalPane.setAlignment(Pos.CENTER);
        totalPaneLeft.setAlignment(Pos.CENTER);
        totalPaneRight.setAlignment(Pos.CENTER);
        taPay.setMaxSize(150, 150);
        totalPaneRight.add(taPay, 0, 0);
        totalPaneLeft.add(lblSubtotal, 1, 0);
        totalPaneLeft.add(txtSubtotal, 2, 0);
        totalPaneLeft.add(lblTax, 1, 1);
        totalPaneLeft.add(txtTax, 2, 1);
        totalPaneLeft.add(lblTotal, 1, 2);
        totalPaneLeft.add(txtTotal, 2, 2);
        totalPaneLeft.add(lblMemberID, 1, 3);
        totalPaneLeft.add(cbxMemberID, 2, 3);
        totalPaneLeft.add(btnFinalPay, 1, 4);
        totalPane.add(totalPaneRight, 1, 0);
        totalPane.add(totalPaneLeft, 0, 0);

        totalsView.setMaxSize(300, 450);

        posOverallPane.setHgap(10);
        posOverallPane.setVgap(10);

        posOverallPane.add(totalsView, 0, 0);
        posOverallPane.add(posPane, 1, 0);
        posOverallPane.add(totalPane, 0, 1);
        posOverallPane.add(cashPane, 1, 1);

        //logic
        fillInventoryBook();
        fillInventoryCafe();
        fillCbxMember();
        cbxMemberID.getItems().addAll("Guest");

        //populating the nodes via a clicked listview item
        cafeView.setOnMouseClicked(e ->
        {
            newItem = cafeView.getSelectionModel().getSelectedItem();

            do
            {
                itemTotals.add(newItem);
                ObservableList<Inventory> cafeList = FXCollections.observableArrayList(itemTotals);
                totalsView.setItems(cafeList);
            } while (primaryStage.hasProperties());

            for (Inventory a : itemTotals)
            {
                total = a.getPrice();
            }
            orderSubtotal += total;

            txtSubtotal.setText(orderSubtotal + "");
            txtTax.setText((orderSubtotal * 0.06) + "");
            txtTotal.setText(Double.valueOf(txtTax.getText())
                    + Double.valueOf(txtSubtotal.getText()) + "");
        });

        //populating the nodes via a clicked listview item
        bookView.setOnMouseClicked(j ->
        {
            newBook = bookView.getSelectionModel().getSelectedItem();
            do
            {
                itemTotals.add(newBook);
                ObservableList<Inventory> bookList = FXCollections.observableArrayList(itemTotals);
                totalsView.setItems(bookList);
            } while (primaryStage.hasProperties());

            for (Inventory a : itemTotals)
            {
                total = a.getPrice();
            }

            orderSubtotal += total;

            txtSubtotal.setText(orderSubtotal + "");
            txtTax.setText((orderSubtotal * 0.06) + "");
            txtTotal.setText(Double.valueOf(txtTax.getText())
                    + Double.valueOf(txtSubtotal.getText()) + "");
        });
        
        /**
         * ******************************************************************
         */
        //needs to be converted to the overall employee view panes
        Scene empScene = new Scene(managerPane, 700, 700);
        primaryStage.setScene(empScene);
        primaryStage.setTitle("BookIT Manager");
        primaryStage.show();
        
        
    }
        public void fillInventoryBook() throws SQLException
    {
        String sqlQuery = "";
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE = 'Book'";

        ArrayList<Book> bookArray = new ArrayList<>();

        sendDBCommand(sqlQuery);
        
            while (dbResults.next())
            {
                bookArray.add(new Book(dbResults.getString(6), dbResults.getString(7),
                        dbResults.getString(8), dbResults.getString(9),
                        Integer.valueOf(dbResults.getString(10)), dbResults.getString(2),
                        dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
                        dbResults.getString(11), Double.valueOf(dbResults.getString(5))));

            }
            ObservableList<Inventory> bookList = FXCollections.observableArrayList(bookArray);
            bookView.setItems(bookList);

    }

    public void fillInventoryCafe() throws SQLException
    {
        String sqlQuery = "";
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE = 'Cafe'";

        ArrayList<Inventory> cafeArray = new ArrayList<>();

        sendDBCommand(sqlQuery);
        while (dbResults.next())
        {
            cafeArray.add(new Inventory(dbResults.getString(2), dbResults.getString(3),
                    Integer.valueOf(dbResults.getString(4)), dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
        }

        ObservableList<Inventory> cafeList = FXCollections.observableArrayList(cafeArray);

        cafeView.setItems(cafeList);
    }

    public void fillCbxMember() throws SQLException
    {
        String sqlQuery = "";
        sqlQuery = "SELECT * FROM BOOKITDB.MEMBERS";
        ArrayList<Member> memberArray = new ArrayList<>();

        sendDBCommand(sqlQuery);
        while (dbResults.next())
        {
            memberArray.add(new Member(Integer.valueOf(dbResults.getString(1)), dbResults.getString(2), dbResults.getString(3), dbResults.getString(4),
                    dbResults.getString(5), dbResults.getString(6), Integer.valueOf(dbResults.getString(7)), dbResults.getString(8), dbResults.getString(9), dbResults.getString(10),
                    dbResults.getString(11)));
        }
        ObservableList<Member> memberList = FXCollections.observableArrayList(memberArray);
        cbxMemberID.getItems().addAll(memberList);

    }

    public void sendDBCommand(String sqlQuery)
    {
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "BOOKITDB";
        String userPASS = "OVALTINE";
        OracleDataSource ds;

        System.out.println(sqlQuery);

        try
        {
            ds = new OracleDataSource();
            ds.setURL(URL);
            dbConnection = ds.getConnection(userID, userPASS);
            commStmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dbResults = commStmt.executeQuery(sqlQuery);
        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
    }    
    
    
}