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
public class ManagerView extends LoginMainForm
{

    /**
     * ********************Overall View stuff**********************
     */
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
    public static ArrayList<Inventory> invArray = new ArrayList();
    public static ArrayList<Book> bookArray = new ArrayList();
    public static ArrayList<Coffee_Shop> coffeeArray = new ArrayList();

    //overall stuff
    TabPane managerPane = new TabPane();
    Tab tab0 = new Tab("Reports");
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
    ComboBox cbxGenre = new ComboBox();
    ComboBox cbxPrice = new ComboBox();

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
    Label lblFilterGenre = new Label("Genre: ");
    Label lblFilterYear = new Label("Max Year: ");
    Label lblFilterPrice = new Label("Max Price: ");

    TabPane posPane = new TabPane();
    Tab booksTab = new Tab("Books");
    Tab cafeTab = new Tab("Cafe");

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
    GridPane filterPane = new GridPane();
    GridPane inventoryPane = new GridPane();
    GridPane inventoryViewPane = new GridPane();
    GridPane inventoryPaneOverall = new GridPane();

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
    Button btnRefresh = new Button("Refresh");
    Button btnSearch = new Button("Search");

//    Button btnFinalPay = new Button("Pay -->");
    Button btnFilterItem = new Button("Go!");
    Button btnDeleteItem = new Button("Remove Item");

    TextField txtFilterYear = new TextField();
    TextField txtSubtotal = new TextField();
    TextField txtTax = new TextField();
    TextField txtTotal = new TextField();
    TextField txtPayment = new TextField();
    VBox payButtons = new VBox();

    /**
     * ********Employee Stuff*****************************************
     */
    GridPane employeePane = new GridPane();
    GridPane employeePaneOverall = new GridPane();
    GridPane employeeViewPane = new GridPane();

    Label lblEmployeeID = new Label("ID:");
    Label lblEmployeeFName = new Label("First Name: ");
    Label lblEmployeeLName = new Label("Last Name: ");
    Label lblEmployeeUsername = new Label("Username: ");
    Label lblEmployeePassword = new Label("Password: ");
    Label lblEmployeePay = new Label("Starting wage: ");
    Label lblEmployeeAddress = new Label("Address: ");
    Label lblEmployeeCity = new Label("City: ");
    Label lblEmployeeState = new Label("State: ");
    Label lblEmployeeZip = new Label("Zip: ");
    Label lblEmployeePhone = new Label("Phone #: ");
    Label lblEmployeeType = new Label("Employee Type: ");
    ComboBox cbxEmployeeType = new ComboBox();
    TextField txtEmployeeID = new TextField();
    TextField txtEmployeeFirst = new TextField();
    TextField txtEmployeeLast = new TextField();
    TextField txtEmployeeUsername = new TextField();
    TextField txtEmployeePassword = new TextField();
    TextField txtEmployeePay = new TextField();
    TextField txtEmployeeAddress = new TextField();
    TextField txtEmployeeCity = new TextField();
    TextField txtEmployeeState = new TextField();
    TextField txtEmployeeZip = new TextField();
    TextField txtEmployeePhone = new TextField();
    Button btnEmployeeAdd = new Button("Add Employee");
    Button btnEmployeeUpdate = new Button("Update Employee");
    Button btnEmployeeDelete = new Button("Delete Employee");

    /**
     * *********Member Stuff***********************************************
     */
    GridPane memberInfoPane = new GridPane();
    Label lblMemberUser = new Label("Username:");
    Label lblMemberPass = new Label("Password:");
    Label lblMemberEmail = new Label("eMail:");
    Label lblMemberPhone = new Label("Phone:");
    Label lblMemberStreet = new Label("Street:");
    Label lblMemberCity = new Label("City:");
    Label lblMemberState = new Label("State");
    Label lblMemberZip = new Label("ZIP:");
    TextField txtMemberUser = new TextField();
    TextField txtMemberPass = new TextField();
    TextField txtMemberEmail = new TextField();
    TextField txtMemberPhone = new TextField();
    TextField txtMemberStreet = new TextField();
    TextField txtMemberCity = new TextField();
    TextField txtMemberState = new TextField();
    TextField txtMemberZip = new TextField();
    Button btnMemberUpdate = new Button("Update");

    /**
     * ********Inventory Stuff*********************************************
     */
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
    Button btnAddBook = new Button("Add Book");
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

    /**
     * ********Expenses Stuff***********************************************
     */
    /**
     * ********Shifts Stuff ************************************************
     */
    /**
     * *********************************************************************
     */
    Stage primaryStage = new Stage();

    /**
     * *****************************CONSTRUCTOR**************************
     */
    //Manager View constructor
    public ManagerView() throws SQLException
    {
        //the overall view setup
        tab0.setClosable(false);
        tab1.setContent(posOverallPane);
        tab1.setClosable(false);
        tab2.setContent(employeePaneOverall);
        tab2.setClosable(false);
        tab3.setClosable(false);
        tab4.setContent(inventoryPaneOverall);
        tab4.setClosable(false);
        tab5.setClosable(false);
        tab6.setClosable(false);

        managerPane.getTabs().addAll(tab0, tab1, tab2, tab3, tab4, tab5, tab6);
        managerPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        /**
         * ***********************Setting POS PANE**************************
         */
        posOverallPane.setAlignment(Pos.CENTER);
        //   posOverallPane.setStyle("-fx-background-color: BLACK;");

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
        bookPaneLeft.add(btnRefresh, 1, 1);
        bookPane.add(bookPaneRight, 0, 0);
        bookPane.add(bookPaneLeft, 1, 0);
        bookView.setMinSize(300, 300);

        cafePane.setAlignment(Pos.CENTER);
        cafePaneRight.setAlignment(Pos.CENTER);
        cafePaneLeft.setAlignment(Pos.CENTER);
        cafePaneRight.add(cafeView, 0, 0);
        cafePane.add(cafePaneRight, 0, 0);
        cafePane.add(cafePaneLeft, 1, 0);

        cashPane.setAlignment(Pos.CENTER);
        cashPane.add(btnPay, 0, 0);
        btnPay.setMinSize(150, 100);

        totalPane.setAlignment(Pos.CENTER);
        totalPaneLeft.setAlignment(Pos.CENTER);
        totalPaneRight.setAlignment(Pos.CENTER);
        taPay.setMaxSize(200, 150);
        taPay.setScaleShape(true);
        totalPaneRight.add(taPay, 0, 0);
        totalPaneLeft.add(lblSubtotal, 1, 0);
        totalPaneLeft.add(txtSubtotal, 2, 0);
        totalPaneLeft.add(lblTax, 1, 1);
        totalPaneLeft.add(txtTax, 2, 1);
        totalPaneLeft.add(lblTotal, 1, 2);
        totalPaneLeft.add(txtTotal, 2, 2);
        totalPaneLeft.add(lblMemberID, 1, 3);
        totalPaneLeft.add(cbxMemberID, 2, 3);
//        totalPaneLeft.add(btnFinalPay, 1, 4);
        totalPane.add(totalPaneRight, 1, 0);
        totalPane.add(totalPaneLeft, 0, 0);

        filterPane.setAlignment(Pos.CENTER);
        filterPane.add(lblFilterGenre, 0, 0);
        filterPane.add(cbxGenre, 1, 0);
        filterPane.add(lblFilterYear, 0, 1);
        filterPane.add(txtFilterYear, 1, 1);
        filterPane.add(lblFilterPrice, 0, 2);
        filterPane.add(cbxPrice, 1, 2);
        filterPane.add(btnFilterItem, 1, 3, 3, 1);

        cbxGenre.getItems().addAll("Fiction", "Non-Fiction", "Mystery", "Sci-Fi", "Young Adult", "Educational",
                "Romance", "Horror", "Art");
        cbxPrice.getItems().addAll("$" + 10, "$" + 25, "$" + 50, "$" + 100, "$" + 200);

        Scene filterScene = new Scene(filterPane, 250, 300);
        Stage filterStage = new Stage();
        filterStage.setScene(filterScene);
        filterStage.setTitle("Filter Results");

        totalsView.setMaxSize(300, 450);

        posOverallPane.setHgap(10);
        posOverallPane.setVgap(10);

        posOverallPane.add(totalsView, 0, 0);
        posOverallPane.add(btnDeleteItem, 1, 0, 1, 1);
        posOverallPane.add(posPane, 2, 0);
        posOverallPane.add(totalPane, 0, 1, 2, 1);
        posOverallPane.add(cashPane, 1, 1, 2, 1);

        //logic
        fillInventoryBook();
        fillInventoryCafe();
        fillCbxMember();
        cbxMemberID.getItems().addAll("Guest");

        //refresh button 
        btnRefresh.setOnAction(r ->
        {
            try
            {
                fillInventoryBook();
            } catch (SQLException ex)
            {
                System.out.println(ex);
            }
        });

        //paying
        btnPay.setOnAction(p ->
        {
            GridPane paymentPane = new GridPane();
            Label lblPayCash = new Label("Cash: $ ");
            Label lblPayCard = new Label("CC #: ");
            Button btnPayment = new Button("ENTER");
            TextField txtPayCash = new TextField();
            TextField txtPayCard = new TextField();
            paymentPane.setAlignment(Pos.CENTER);
            paymentPane.add(lblPayCash, 0, 0);
            paymentPane.add(lblPayCard, 0, 1);
            paymentPane.add(txtPayCash, 1, 0);
            paymentPane.add(txtPayCard, 1, 1);
            paymentPane.add(btnPayment, 0, 2, 2, 1);
            Scene paymentScene = new Scene(paymentPane, 300, 250);
            Stage paymentStage = new Stage();
            paymentStage.setScene(paymentScene);
            paymentStage.show();

            btnPayment.setOnAction(pmt ->
            {
                String cashPay = txtPayCash.getText();
                String cardPay = txtPayCard.getText();
                String txtTotalOutput = "";
                Double balance = 0.0;

                if (txtPayCash.getText().isEmpty())
                {
                    if (txtPayCard.getText().isEmpty())
                    {
                        System.out.println("Please enter a payment amount");
                    } else
                    {
                        txtTotalOutput += "Total: " + txtTotal.getText();
                        txtTotalOutput += "\n Customer Paid: " + txtTotal.getText() + " with card " + cardPay;
                        txtTotalOutput += "\n---------------";
                    }
                } else
                {
                    Double customerPay = Double.valueOf(cashPay);
                    txtTotalOutput += "Total: " + txtTotal.getText();
                    txtTotalOutput += "\n Customer Pay: " + customerPay;
                    txtTotalOutput += "\n---------------";
                    balance = Double.valueOf(txtTotal.getText()) - customerPay;
                    if (balance == 0)
                    {
                        txtTotalOutput += "\n Customer has paid!";
                    }
                    if (balance < 0)
                    {
                        txtTotalOutput += "\n We owe the customer: $" + balance;
                    }
                    if (balance > 0)
                    {
                        double newBalance = balance;
                        txtTotalOutput += "\n Remaining Balance: " + newBalance;
                        txtTotalOutput += "\n Customer owes: " + newBalance;
                        txtTotal.setText(String.valueOf(newBalance));
                        if ((newBalance - balance) == 0)
                        {
                            System.out.println("Customer has paid!");

                        } else
                        {
                            taPay.clear();
                            balance = newBalance - customerPay;
                            txtTotalOutput += "\n Remaining Balance: " + balance;
                            txtTotalOutput += "\n Customer owes, " + balance;

                        }

                    }
                }
                taPay.setText(txtTotalOutput);

            });

        });

        btnDeleteItem.setOnAction(di ->
        {
            int itemPriceIndex = totalsView.getSelectionModel().getSelectedIndex();

            newItem = itemTotals.get(itemPriceIndex);

            double priceDelete = newItem.getPrice();
            System.out.println(priceDelete);
            deletePay(priceDelete);

            itemTotals.remove(newItem);
            ObservableList<Inventory> newTotal = FXCollections.observableArrayList(itemTotals);
            totalsView.setItems(newTotal);

            totalsView.refresh();

        });

        btnFilter.setOnAction(f ->
        {
            filterStage.show();

        });

        btnFilterItem.setOnAction(fi ->
        {
            if (!(cbxGenre.getSelectionModel().isEmpty()))
            {
                try
                {
                    filterGenre();
                } catch (SQLException ex)
                {
                    System.out.println(ex);
                }

                filterStage.close();
            }
            if (!(cbxPrice.getSelectionModel().isEmpty()))
            {
                try
                {
                    filterPrice();
                } catch (SQLException ex)
                {
                    System.out.println(ex);
                }
                filterStage.close();

            }
            if (!(txtFilterYear.getText().isEmpty()))
            {
                try
                {
                    filterYear();
                } catch (SQLException ex)
                {
                    System.out.println(ex);
                }
                filterStage.close();
            }
            if (cbxGenre.getSelectionModel().isEmpty() && cbxPrice.getSelectionModel().isEmpty() && txtFilterYear.getText().isEmpty())
            {
                GridPane errorPane = new GridPane();
                Label lblFilterError = new Label("PLEASE MAKE ONE SELECTION!");
                errorPane.setAlignment(Pos.CENTER);
                errorPane.add(lblFilterError, 0, 0);
                Scene errorScene = new Scene(errorPane, 225, 150);
                Stage errorStage = new Stage();
                errorStage.setScene(errorScene);
                errorStage.setTitle("ERROR");
                errorStage.show();
            }
        });

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
         * ***********************Setting Employee
         * Pane*************************
         */
        employeePane.setAlignment(Pos.CENTER);
        employeePane.add(lblEmployeeID, 0, 0);
        employeePane.add(txtEmployeeID, 1, 0);
        employeePane.add(lblEmployeeFName, 0, 1);
        employeePane.add(txtEmployeeFirst, 1, 1);
        employeePane.add(lblEmployeeLName, 0, 2);
        employeePane.add(txtEmployeeLast, 1, 2);
        employeePane.add(lblEmployeeAddress, 0, 3);
        employeePane.add(txtEmployeeAddress, 1, 3);
        employeePane.add(lblEmployeeCity, 0, 4);
        employeePane.add(txtEmployeeCity, 1, 4);
        employeePane.add(lblEmployeeState, 0, 5);
        employeePane.add(txtEmployeeState, 1, 5);
        employeePane.add(lblEmployeeZip, 0, 6);
        employeePane.add(txtEmployeeZip, 1, 6);
        employeePane.add(lblEmployeePhone, 0, 7);
        employeePane.add(txtEmployeePhone, 1, 7);
        employeePane.add(lblEmployeeUsername, 0, 8);
        employeePane.add(txtEmployeeUsername, 1, 8);
        employeePane.add(lblEmployeePassword, 0, 9);
        employeePane.add(txtEmployeePassword, 1, 9);
        employeePane.add(lblEmployeeType, 0, 10);
        employeePane.add(cbxEmployeeType, 1, 10);
        employeePane.add(lblEmployeePay, 0, 11);
        employeePane.add(txtEmployeePay, 1, 11);
        employeePane.add(btnEmployeeAdd, 0, 12);
        employeePane.add(btnEmployeeUpdate, 1, 12);
        employeePane.add(btnEmployeeDelete, 2, 12);
        employeeViewPane.setAlignment(Pos.CENTER);
        employeePaneOverall.setAlignment(Pos.CENTER);
        employeeViewPane.add(employeeView, 0, 0);
        employeePaneOverall.add(employeePane, 0, 0);
        employeePaneOverall.add(employeeViewPane, 1, 0);
        cbxEmployeeType.getItems().addAll("Manager", "Floor", "Cafe");

        /**
         * *********Setting Member
         * Pane*****************************************
         */
        //Member View 
        /**
         * ******Setting Inventory Pane*************************************
         */
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
        inventoryPane.add(btnInventoryAdd, 2, 3);
        inventoryPane.add(btnInventoryUpdate, 2, 4);
        inventoryPane.add(btnInventoryDelete, 2, 5);
        cbxBookGenre.getItems().addAll("Fiction", "Non-Fiction", "Mystery", "Fantasy/Sci-Fi", "Childrens", "Young Adult", "Educational",
                "Romance", "Horror", "Art");

        inventoryPane.add(lblBookISBN, 0, 5);
        inventoryPane.add(txtBookISBN, 1, 5);
        inventoryPane.add(lblBookAuthor, 0, 6);
        inventoryPane.add(txtBookAuthor, 1, 6);
        inventoryPane.add(lblBookGenre, 0, 7);
        inventoryPane.add(cbxBookGenre, 1, 7);
        inventoryPane.add(lblBookPublisher, 0, 8);
        inventoryPane.add(txtBookPublisher, 1, 8);
        inventoryPane.add(lblBookYear, 0, 9);
        inventoryPane.add(txtBookYear, 1, 9);

        inventoryViewPane.setAlignment(Pos.CENTER);
        inventoryPaneOverall.setAlignment(Pos.CENTER);
        inventoryViewPane.add(lstInv, 0, 0);
        inventoryPaneOverall.add(inventoryPane, 0, 0);
        inventoryPaneOverall.add(inventoryViewPane, 1, 0);

        btnInventoryAdd.setOnAction(e ->
        {

            if (cbxType.getSelectionModel().getSelectedItem().equals("Book"))
            {
                insertBook();
            } else if (cbxType.getSelectionModel().getSelectedItem().equals("Cafe"))
            {
                insertCafe();
            }

        });

        btnInventoryUpdate.setOnAction(e ->
        {
            updateInventory();
        });

        btnInventoryDelete.setOnAction(e ->
        {
            deleteInventory();
        });

        /**
         * ********Setting ExpensesPane************************************
         */
        //Expense Pane adds
        /**
         * *******Shifts Shifts Pane**************************************
         */
        /**
         * **********************************************
         */
        //needs to be converted to the overall employee view panes
        Scene managerScene = new Scene(managerPane, 1000, 600);
        primaryStage.setScene(managerScene);
        primaryStage.setTitle("BookIT Manager");
        primaryStage.show();

    }

    /**
     * ********************Methods****************
     */
    //CREATE A LOAD STATEMENT FOR INVENTORY
    
     //connection to the database and loading inventory content
    public void loadSuppliersDataFromDB()
    {
        String sqlQuery = "";
        String listString = "";
        sqlQuery = "Select * from BOOKITDB.INVENTORY";

        //calling the sendDBCommand method
        sendDBCommand(sqlQuery);
        invArray.clear();

        //to test the sqlException
        try
        {
            //while there is a next item
            while (dbResults.next())
            {
                int inv_id = Integer.parseInt(dbResults.getString(1));
                String item_name = dbResults.getString(2);
                String item_desc = dbResults.getString(3);
                int item_Quantity = Integer.parseInt(dbResults.getString(4));
                double item_price = Double.parseDouble(dbResults.getString(5));
                String ISBN = dbResults.getString(6);
                String genre = dbResults.getString(7);
                String author = dbResults.getString(8);
                String publisher = dbResults.getString(9);
                int book_year = Integer.parseInt(dbResults.getString(10));
                String type = dbResults.getString(11);

                invArray.add(new Inventory(supplierID, supplierName,
                        supplierStreet, supplierCity, supplierState, supplierZip, srFName,
                        srLName, srCell, srEmail));
                System.out.println(suppliersArray.get(suppliersArray.size() - 1).toString());

            }
        } catch (SQLException e)
        {
            System.out.println(e.toString());;
        }
    }
    public void insertBook()
    {
        // creating the products     
        Inventory invRef = new Inventory();
        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.Inventory (INV_ID, ITEM_NAME, ITEM_DESC, ITEM_QUANTITY, ITEM_PRICE"
                + " ISBN, GENRE, AUTHOR, PUBLISHER, BOOK_YEAR, TYPE) VALUES (";
        sqlQuery += "'" + Inventory.invCount + "',";
        sqlQuery += "'" + txtItemName.getText() + "',";
        sqlQuery += "'" + txtItemDesc.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtItemQuantity.getText()) + "',";
        sqlQuery += "'" + Double.parseDouble(txtItemPrice.getText()) + "',";
        sqlQuery += "'" + txtBookISBN.getText() + "',";
        sqlQuery += "'" + cbxBookGenre.getSelectionModel().getSelectedItem().toString() + "',";
        sqlQuery += "'" + txtBookAuthor.getText() + "',";
        sqlQuery += "'" + txtBookPublisher.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtBookYear.getText()) + "')";
        sqlQuery += "'" + cbxType.getSelectionModel().getSelectedItem().toString() + "',";
        sendDBCommand(sqlQuery);
        lstInv.getItems().add(sqlQuery);

    }

    public void insertCafe()
    {
        // creating the products     
        Inventory invRef = new Inventory();
        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.Inventory (INV_ID, ITEM_NAME, ITEM_DESC, ITEM_QUANTITY, ITEM_PRICE"
                + " ISBN, GENRE, AUTHOR, PUBLISHER, BOOK_YEAR, TYPE) VALUES (";
        sqlQuery += "'" + Inventory.invCount + "',";
        sqlQuery += "'" + txtItemName.getText() + "',";
        sqlQuery += "'" + txtItemDesc.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtItemQuantity.getText()) + "',";
        sqlQuery += "'" + Double.parseDouble(txtItemPrice.getText()) + "',";
        sqlQuery += "'" + "null" + "',";
        sqlQuery += "'" + "null" + "',";
        sqlQuery += "'" + "null" + "',";
        sqlQuery += "'" + "null" + "',";
        sqlQuery += "'" + Integer.parseInt("null") + "')";
        sqlQuery += "'" + cbxType.getSelectionModel().getSelectedItem().toString() + "',";
        sendDBCommand(sqlQuery);
        lstInv.getItems().add(sqlQuery);

    }

    public void updateInventory()
    {
        Inventory invRef = new Inventory();
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

    public void runPay(double price)
    {
        orderSubtotal += price;

        txtSubtotal.setText(orderSubtotal + "");
        txtTax.setText((orderSubtotal * 0.06) + "");
        txtTotal.setText(Double.valueOf(txtTax.getText()) + Double.valueOf(txtSubtotal.getText()) + "");
    }

    public void deletePay(double price)
    {
        orderSubtotal -= price;

        txtSubtotal.setText(orderSubtotal + "");
        txtTax.setText((orderSubtotal * 0.06) + "");
        txtTotal.setText(Double.valueOf(txtTax.getText()) + Double.valueOf(txtSubtotal.getText()) + "");
    }

    public void filterPrice() throws SQLException
    {
        String sqlQuery = "";
        String price;
        price = cbxPrice.getSelectionModel().getSelectedItem().toString();
        System.out.println(price);
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE ='Book' AND PRICE <=" + price;
        sendDBCommand(sqlQuery);

        ArrayList<Book> priceArray = new ArrayList<>();

        while (dbResults.next())
        {
            priceArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
        }
        ObservableList<Inventory> priceList = FXCollections.observableArrayList(priceArray);
        bookView.setItems(priceList);

    }

    public void filterYear() throws SQLException
    {
        String sqlQuery = "";
        int year;
        year = Integer.valueOf(txtFilterYear.getText());
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE = 'Book' AND BOOK_YEAR <=" + year;

        sendDBCommand(sqlQuery);
        ArrayList<Book> yearArray = new ArrayList<>();

        while (dbResults.next())
        {
            yearArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
        }
        ObservableList<Inventory> yearList = FXCollections.observableArrayList(yearArray);
        bookView.setItems(yearList);

    }

    public void filterGenre() throws SQLException
    {
        String sqlQuery = "";
        String genre;
        genre = cbxGenre.getSelectionModel().getSelectedItem().toString();
        String toUpperCase = genre.toUpperCase();
        System.out.println(toUpperCase);
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE ='Book' AND GENRE ='" + toUpperCase + "'";
        sendDBCommand(sqlQuery);

        ArrayList<Book> genreArray = new ArrayList<>();

        while (dbResults.next())
        {
            genreArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
        }
        ObservableList<Inventory> genreList = FXCollections.observableArrayList(genreArray);
        bookView.setItems(genreList);

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
