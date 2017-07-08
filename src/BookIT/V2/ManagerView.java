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

    ///////////////////////////////////OVERALL VIEW STUFF/////////////////////
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
    ListView invView = new ListView();
    ListView empView = new ListView();
    ListView expenseView = new ListView();
    ListView shiftsView = new ListView();
    ListView memberView = new ListView();

    //overall stuff
    TabPane managerPane = new TabPane();
    Tab tab0 = new Tab("Reports");
    Tab tab1 = new Tab("P.O.S.");
    Tab tab2 = new Tab("Employee");
    Tab tab3 = new Tab("Member");
    Tab tab4 = new Tab("Inventory");
    Tab tab5 = new Tab("Expenses");
    Tab tab6 = new Tab("Shifts");

    ////////////////////////////////////POS STUFF/////////////////////////////
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
    GridPane memberPane = new GridPane();
    GridPane memberViewPane = new GridPane();
    GridPane memberPaneOverall = new GridPane();
    GridPane expensePane = new GridPane();
    GridPane expenseViewPane = new GridPane();
    GridPane expensePaneOverall = new GridPane();
    GridPane shiftsPane = new GridPane();
    GridPane shiftsViewPane = new GridPane();
    GridPane shiftsPaneOverall = new GridPane();
    GridPane employeePane = new GridPane();
    GridPane employeePaneOverall = new GridPane();
    GridPane employeeViewPane = new GridPane();


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

    /////////////////////////////////////EMPLOYEE STUFF////////////////////////
 
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

    ////////////////////////////////MEMBER STUFF//////////////////////////////
  
    Label lblMemberFN = new Label("First Name:");
    Label lblMemberLN = new Label("Last Name:");
    Label lblMemberEmail = new Label("eMail:");
    Label lblMemberPhone = new Label("Phone:");
    Label lblMemberStreet = new Label("Street:");
    Label lblMemberCity = new Label("City:");
    Label lblMemberState = new Label("State");
    Label lblMemberZip = new Label("ZIP:");
    TextField txtMemberFN = new TextField();
    TextField txtMemberLN = new TextField();
    TextField txtMemberEmail = new TextField();
    TextField txtMemberPhone = new TextField();
    TextField txtMemberStreet = new TextField();
    TextField txtMemberCity = new TextField();
    TextField txtMemberState = new TextField();
    TextField txtMemberZip = new TextField();
    Button btnMemberUpdate = new Button("Update Member");
    Button btnMemberAdd = new Button("Add Member");
    Button btnMemberDelete = new Button("Delete Member");

    //////////////////////////////////////INV STUFF///////////////////////////
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

    ////////////////////////////EXPENSES STUFF////////////////////////////////
    Label lblExpenseType = new Label("Expense Type: ");
    TextField txtExpenseType = new TextField();
    Label lblExpenseDate = new Label("Expense Date: ");
    TextField txtExpenseDate = new TextField();
    Label lblExpenseCost = new Label("Expense Cost: ");
    TextField txtExpenseCost = new TextField();
    Label lblExpenseDesc = new Label("Expense Desc: ");
    TextField txtExpenseDesc = new TextField();
    Label lblStoreID = new Label("Store ID: ");
    TextField txtStoreID = new TextField();
    ComboBox<String> cbxExpenseType = new ComboBox();
    Button btnAddExpense = new Button("Add Expense");
    Button btnUpdateExpense = new Button("Update Expense");
    Button btnDeleteExpense = new Button("Delete Expense");
    
    
    /////////////////////////////SHIFTS STUFF/////////////////////////////////
  
    
    
    //////////////////////////////////////////////////////////////////////////
    Stage primaryStage = new Stage();

    ///////////////////////////////////CONSTRUCTOR/////////////////////////////
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

        ///////////////////////////SETTING THE POS////////////////////////////
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
        ///////////////////////////SETTING EMPLOYEE PANE/////////////////////////
        loadEmployee();
        ObservableList<Employee> empData = FXCollections.observableArrayList(empArray);

        empView.setItems(empData);
        employeePane.setAlignment(Pos.CENTER);
//        employeePane.add(lblEmployeeID, 0, 0);
//        employeePane.add(txtEmployeeID, 1, 0);
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
        employeeViewPane.add(empView, 0, 0);
        employeePaneOverall.add(employeePane, 0, 0);
        employeePaneOverall.add(employeeViewPane, 1, 0);
        cbxEmployeeType.getItems().addAll("Manager", "Floor", "Cafe");

        empView.setOnMouseClicked(j ->
        {
            //filling in the nodes from the listview
            txtEmployeeFirst.setText(empArray.get(empView.getSelectionModel().getSelectedIndex()).getFName());
            txtEmployeeLast.setText(empArray.get(empView.getSelectionModel().getSelectedIndex()).getLName());
            txtEmployeeAddress.setText(empArray.get(empView.getSelectionModel().getSelectedIndex()).getStreet());
            txtEmployeeCity.setText(empArray.get(empView.getSelectionModel().getSelectedIndex()).getCity());
            txtEmployeeState.setText(empArray.get(empView.getSelectionModel().getSelectedIndex()).getState());
            txtEmployeeZip.setText(String.valueOf(empArray.get(empView.getSelectionModel().getSelectedIndex()).getZipCode()));
            txtEmployeePhone.setText(empArray.get(empView.getSelectionModel().getSelectedIndex()).getCell());
            txtEmployeeUsername.setText(empArray.get(empView.getSelectionModel().getSelectedIndex()).getUserName());
            txtEmployeePassword.setText(empArray.get(empView.getSelectionModel().getSelectedIndex()).getPassword());
            txtEmployeePay.setText(String.valueOf(empArray.get(empView.getSelectionModel().getSelectedIndex()).getWage()));
        });

        btnEmployeeAdd.setOnAction(e ->
        {
            insertEmployee();
        

        });

        btnEmployeeUpdate.setOnAction(e ->
        {
            updateEmployee();
       
        });

        btnEmployeeDelete.setOnAction(e ->
        {
            deleteEmployee();
         
        });

        ///////////////////////////SETTING MEMBER PANE/////////////////////////
        //Member View 
        
        loadMember();
        ObservableList<Member> memberData = FXCollections.observableArrayList(memberArray);

        memberView.setItems(memberData);
        memberPane.setAlignment(Pos.CENTER);
        memberPane.add(lblMemberFN, 0, 1);
        memberPane.add(txtMemberFN, 1, 1);
        memberPane.add(lblMemberLN, 0, 2);
        memberPane.add(txtMemberLN, 1, 2);
        memberPane.add(lblMemberStreet, 0, 3);
        memberPane.add(txtMemberStreet, 1, 3);
        memberPane.add(lblMemberCity, 0, 4);
        memberPane.add(txtMemberCity, 1, 4);
        memberPane.add(lblMemberState, 0, 5);
        memberPane.add(txtMemberState, 1, 5);
        memberPane.add(lblMemberZip, 0, 6);
        memberPane.add(txtMemberZip, 1, 6);
        memberPane.add(lblMemberPhone, 0, 7);
        memberPane.add(txtMemberPhone, 1, 7);
        memberPane.add(lblMemberEmail, 0, 8);
        memberPane.add(lblMemberEmail, 1, 8);

        memberViewPane.setAlignment(Pos.CENTER);
        memberPaneOverall.setAlignment(Pos.CENTER);
        memberViewPane.add(memberView, 0, 0);
        memberPaneOverall.add(memberPane, 0, 0);
        memberPaneOverall.add(memberViewPane, 1, 0);
     

        memberView.setOnMouseClicked(j ->
        {
            //filling in the nodes from the listview
            txtMemberFN.setText(memberArray.get(memberView.getSelectionModel().getSelectedIndex()).getFName());
            txtMemberLN.setText(memberArray.get(memberView.getSelectionModel().getSelectedIndex()).getLName());
            txtMemberStreet.setText(memberArray.get(memberView.getSelectionModel().getSelectedIndex()).getStreet());
            txtMemberCity.setText(memberArray.get(memberView.getSelectionModel().getSelectedIndex()).getCity());
            txtMemberState.setText(memberArray.get(memberView.getSelectionModel().getSelectedIndex()).getState());
            txtMemberZip.setText(String.valueOf(memberArray.get(memberView.getSelectionModel().getSelectedIndex()).getZipCode()));
            txtMemberPhone.setText(memberArray.get(memberView.getSelectionModel().getSelectedIndex()).getCell());
            lblMemberEmail.setText(memberArray.get(memberView.getSelectionModel().getSelectedIndex()).getEmail());
         });

        btnMemberAdd.setOnAction(e ->
        {
            insertMember();
     

        });

        btnMemberUpdate.setOnAction(e ->
        {
            updateMember();
    
        });

        btnMemberDelete.setOnAction(e ->
        {
            deleteMember();
        
        });
        
        
        //////////////////////////SETTING INV PANE/////////////////////////////
        loadInventory();
        ObservableList<Inventory> invData = FXCollections.observableArrayList(invArray);

        invView.setItems(invData);

        cbxType.getItems().addAll("Book", "Cafe");
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
        inventoryViewPane.add(invView, 0, 0);
        inventoryPaneOverall.add(inventoryPane, 0, 0);
        inventoryPaneOverall.add(inventoryViewPane, 1, 0);

        invView.setOnMouseClicked(j ->
        {
            //filling in the nodes from the listview
            txtItemName.setText(invArray.get(invView.getSelectionModel().getSelectedIndex()).getItemName());
            txtItemDesc.setText(invArray.get(invView.getSelectionModel().getSelectedIndex()).getItemDesc());
            txtItemPrice.setText(String.valueOf(invArray.get(invView.getSelectionModel().getSelectedIndex()).getPrice()));
            txtItemQuantity.setText(String.valueOf(invArray.get(invView.getSelectionModel().getSelectedIndex()).getQuantity()));

        });

        btnInventoryAdd.setOnAction(e ->
        {

            if (cbxType.getSelectionModel().getSelectedItem() == "Book")
            {
                insertBook();
                System.out.println("inserting book");
            }
            if (cbxType.getSelectionModel().getSelectedItem() == "Cafe")
            {
                insertCafe();
                System.out.println("inserting cafe");
            }
            invView.refresh();

        });

        btnInventoryUpdate.setOnAction(e ->
        {
            if (cbxType.getSelectionModel().getSelectedItem() == "Book")
            {
                updateBookInventory();
                System.out.println("updated book inventory");
            }
            if (cbxType.getSelectionModel().getSelectedItem() == "Cafe")
            {
                updateCafeInventory();
                System.out.println("updated cafe inventory");
            }

            invView.refresh();
        });

        btnInventoryDelete.setOnAction(e ->
        {
            deleteInventory();
            invView.refresh();
        });

        ///////////////////////////SETTING EXPENSE PANE/////////////////////////
        loadExpense();
        ObservableList<Expenses> expenseData = FXCollections.observableArrayList(expenseArray);

        expenseView.setItems(expenseData);
        expensePane.setAlignment(Pos.CENTER);
        expensePane.add(lblExpenseType, 0, 1);
        expensePane.add(cbxExpenseType, 1, 1);
        expensePane.add(lblExpenseDate, 0, 2);
        expensePane.add(txtExpenseDate, 1, 2);
        expensePane.add(lblExpenseCost, 0, 3);
        expensePane.add(txtExpenseCost, 1, 3);
        expensePane.add(lblExpenseDesc, 0, 4);
        expensePane.add(txtExpenseDesc, 1, 4);
        expensePane.add(lblStoreID, 0, 5);
        expensePane.add(txtStoreID , 1, 5);
        expensePane.add(btnAddExpense, 0, 7);
        expensePane.add(btnUpdateExpense, 1, 7);
        expensePane.add(btnDeleteExpense, 2, 7);
        expenseViewPane.setAlignment(Pos.CENTER);
        expensePaneOverall.setAlignment(Pos.CENTER);
        expenseViewPane.add(expenseView, 0, 0);
        expensePaneOverall.add(expensePane, 0, 0);
        expensePaneOverall.add(expenseViewPane, 1, 0);
        cbxExpenseType.getItems().addAll("Maintenance", "Utilities", "MISC");

        expenseView.setOnMouseClicked(j ->
        {
            //filling in the nodes from the listview
            txtExpenseDate.setText(expenseArray.get(expenseView.getSelectionModel().getSelectedIndex()).getExpType());
            txtExpenseCost.setText(String.valueOf(expenseArray.get(expenseView.getSelectionModel().getSelectedIndex()).getExpCost()));
            txtExpenseDesc.setText(expenseArray.get(expenseView.getSelectionModel().getSelectedIndex()).getExpDesc());
            txtStoreID.setText(String.valueOf(expenseArray.get(expenseView.getSelectionModel().getSelectedIndex()).getStoreID_FK()));
        });

        btnAddExpense.setOnAction(e ->
        {
            addExpense();
           
        });

        btnUpdateExpense.setOnAction(e ->
        {
            updateExpense();
    
        });

        btnDeleteExpense.setOnAction(e ->
        {
            deleteExpense();

        });
           

        ///////////////////////////SETTING SHIFTS PANE/////////////////////////
        ///////////////////////////////////////////////////////////////////////
        //needs to be converted to the overall employee view panes
        Scene managerScene = new Scene(managerPane, 800, 600);
        primaryStage.setScene(managerScene);
        primaryStage.setTitle("BookIT Manager");
        primaryStage.show();

    }

    ///////////////////////////METHODS/////////////////////////////////////////
    //connection to the database and loading inventory content
    public void loadInventory()
    {
        String sqlQuery = "";
        String listString = "";
        sqlQuery = "Select * from BOOKITDB.INVENTORY";

        //calling the sendDBCommand method
        sendDBCommand(sqlQuery);
        invArray.clear();
        Inventory.invCount = 0;
        invView.refresh();

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

                if (dbResults.getString(6).equalsIgnoreCase("n/a"))
                {
                    invArray.add(new Inventory(inv_id, item_name, item_desc, item_Quantity, item_price, type));

                    System.out.println("Inventory Count: " + Inventory.invCount);
                } else
                {
                    invArray.add(new Book(inv_id, item_name, item_desc, item_Quantity, item_price, type,
                            ISBN, genre, author, publisher, book_year));

                    System.out.println("Inventory Count: " + Inventory.invCount);
                }

                System.out.println(invArray.get(invArray.size() - 1).toString());

            }
        } catch (SQLException e)
        {
            System.out.println(e.toString());;
        }
        
        
    }

    public void insertBook()
    {
        // creating the bookstore items     

        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.Inventory (INV_ID, ITEM_NAME, ITEM_DESC, ITEM_QUANTITY, ITEM_PRICE,"
                + " ISBN, GENRE, AUTHOR, PUBLISHER, BOOK_YEAR, TYPE) VALUES (";
        sqlQuery += "'" + ++Inventory.invCount + "',";
        sqlQuery += "'" + txtItemName.getText() + "',";
        sqlQuery += "'" + txtItemDesc.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtItemQuantity.getText()) + "',";
        sqlQuery += "'" + Double.parseDouble(txtItemPrice.getText()) + "',";
        sqlQuery += "'" + txtBookISBN.getText() + "',";
        sqlQuery += "'" + cbxBookGenre.getSelectionModel().getSelectedItem().toString() + "',";
        sqlQuery += "'" + txtBookAuthor.getText() + "',";
        sqlQuery += "'" + txtBookPublisher.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtBookYear.getText()) + "',";
        sqlQuery += "'" + cbxType.getSelectionModel().getSelectedItem() + "')";
        sendDBCommand(sqlQuery);

        System.out.println("Inventory Count: " + Inventory.invCount);

        loadInventory();

    }

    public void insertCafe()
    {
        // creating the cafe items     

        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.Inventory (INV_ID, ITEM_NAME, ITEM_DESC, ITEM_QUANTITY, ITEM_PRICE,"
                + " ISBN, GENRE, AUTHOR, PUBLISHER, BOOK_YEAR, TYPE) VALUES (";
        sqlQuery += "'" + ++Inventory.invCount + "',";
        sqlQuery += "'" + txtItemName.getText() + "',";
        sqlQuery += "'" + txtItemDesc.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtItemQuantity.getText()) + "',";
        sqlQuery += "'" + Double.parseDouble(txtItemPrice.getText()) + "',";
        sqlQuery += "'n/a',";
        sqlQuery += "'n/a',";
        sqlQuery += "'n/a',";
        sqlQuery += "'n/a',";
        sqlQuery += "'" + 0 + "',";
        sqlQuery += "'" + cbxType.getSelectionModel().getSelectedItem() + "')";
        sendDBCommand(sqlQuery);

        System.out.println("Inventory Count: " + Inventory.invCount);

        loadInventory();
    }

    public void updateBookInventory()
    {

        String sqlQuery = "";
        sqlQuery = "UPDATE BOOKITDB.Inventory SET ITEM_NAME=" + "'" + txtItemName.getText()
                + "', ITEM_DESC=" + "'" + txtItemDesc.getText()
                + "', ITEM_QUANTITY=" + "'" + Integer.parseInt(txtItemQuantity.getText())
                + "', ITEM_PRICE=" + "'" + Double.parseDouble(txtItemPrice.getText())
                + "', ISBN=" + "'" + txtBookISBN.getText()
                + "', GENRE=" + "'" + cbxBookGenre.getSelectionModel().getSelectedItem().toString()
                + "', AUTHOR=" + "'" + txtBookAuthor.getText()
                + "', PUBLISHER=" + "'" + txtBookPublisher.getText()
                + "', BOOK_YEAR=" + "'" + Integer.parseInt(txtBookYear.getText())
                + "' WHERE INV_ID='" + Integer.valueOf(invView.getSelectionModel().getSelectedIndex()+1) + "'";

        sendDBCommand(sqlQuery);

        loadInventory();
    }

    public void updateCafeInventory()
    {

        String sqlQuery = "";
        sqlQuery = "UPDATE BOOKITDB.Inventory SET ITEM_NAME=" + "'" + txtItemName.getText()
                + "', ITEM_DESC=" + "'" + txtItemDesc.getText()
                + "', ITEM_QUANTITY=" + "'" + Integer.parseInt(txtItemQuantity.getText())
                + "', ITEM_PRICE=" + "'" + Double.parseDouble(txtItemPrice.getText())
                + "' WHERE INV_ID='" + Integer.valueOf(invView.getSelectionModel().getSelectedIndex()+1) + "'";

        sendDBCommand(sqlQuery);

        loadInventory();
    }

    public void deleteInventory()
    {
     
        String sqlQuery = "";
        // delete products  from DB
        sqlQuery = "DELETE FROM BOOKITDB.Inventory WHERE INV_ID='"
                + Integer.valueOf(invView.getSelectionModel().getSelectedIndex()) + "'";

        sendDBCommand(sqlQuery);
        loadInventory();
    }

    public void loadEmployee()
    {
        String sqlQuery = "";
        String listString = "";
        sqlQuery = "Select * from BOOKITDB.Employees";
        //calling the sendDBCommand method
        sendDBCommand(sqlQuery);
        Employee.empCount = 0;
        empArray.clear();
        //to test the sqlException
        try
        {
            //while there is a next employee
            while (dbResults.next())
            {

                int empID = Integer.parseInt(dbResults.getString(1));
                String fName = dbResults.getString(2);
                String lName = dbResults.getString(3);
                String street = dbResults.getString(4);
                String city = dbResults.getString(5);
                String state = dbResults.getString(6);
                int zipCode = Integer.parseInt(dbResults.getString(7));
                String cell = dbResults.getString(8);
                String userName = dbResults.getString(9);
                String password = dbResults.getString(10);
                double empWage = Double.parseDouble(dbResults.getString(11));
                double otWage = Double.parseDouble(dbResults.getString(12));
                String empType = dbResults.getString(13);

                empArray.add(new Employee(empID, fName, lName, street,
                        city, state, zipCode, cell, userName, password, empWage,
                        otWage, empType));

                System.out.println(empArray.get(empArray.size() - 1).toString());
                //set string to read from the DB
            }

        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        empView.refresh();
    }

    public void insertEmployee()
    {
        // creating the bookstore items     

        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.EMPLOYEES (EMP_ID, FNAME, LNAME, STREET, CITY,"
                + " STATE, ZIPCODE, CELL, USERNAME, PASSWORD, WAGE, OT_WAGE, EMP_TYPE) VALUES (";
        sqlQuery += "'" + ++Employee.empCount + "',";
        sqlQuery += "'" + txtEmployeeFirst.getText() + "',";
        sqlQuery += "'" + txtEmployeeLast.getText() + "',";
        sqlQuery += "'" + txtEmployeeAddress.getText() + "',";
        sqlQuery += "'" + txtEmployeeCity.getText() + "',";
        sqlQuery += "'" + txtEmployeeState.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtEmployeeZip.getText()) + "',";
        sqlQuery += "'" + txtEmployeePhone.getText() + "',";
        sqlQuery += "'" + txtEmployeeUsername.getText() + "',";
        sqlQuery += "'" + txtEmployeePassword.getText() + "',";
        sqlQuery += "'" + Double.parseDouble(txtEmployeePay.getText()) + "',";
        sqlQuery += "'" + Double.parseDouble(txtEmployeePay.getText()) * 1.5 + "',";
        sqlQuery += "'" + cbxEmployeeType.getSelectionModel().getSelectedItem() + "')";
        sendDBCommand(sqlQuery);

        System.out.println("Employee Count: " + Employee.empCount);

        loadEmployee();
    }

    public void updateEmployee()
    {
 
        String sqlQuery = "";
        sqlQuery = "UPDATE BOOKITDB.Employees SET FNAME=" + "'" + txtEmployeeFirst.getText()
                + "', LNAME=" + "'" + txtEmployeeLast.getText()
                + "', STREET=" + "'" + txtEmployeeAddress.getText()
                + "', CITY=" + "'" + txtEmployeeCity.getText()
                + "', STATE=" + "'" + txtEmployeeState.getText()
                + "', ZIPCODE=" + "'" + Integer.parseInt(txtEmployeeZip.getText())
                + "', CELL=" + "'" + txtEmployeePhone.getText()
                + "', USERNAME=" + "'" + txtEmployeeUsername.getText()
                + "', PASSWORD=" + "'" + txtEmployeePassword.getText()
                + "', WAGE=" + "'" + Double.parseDouble(txtEmployeePay.getText())
                + "', OT_WAGE=" + "'" + Double.parseDouble(txtEmployeePay.getText()) * 1.5
                + "', EMP_TYPE=" + "'" + cbxEmployeeType.getSelectionModel().getSelectedItem()
                + "' WHERE EMP_ID='" + (Integer.valueOf(empView.getSelectionModel().getSelectedIndex()+1)) + "'";

        sendDBCommand(sqlQuery);

        loadEmployee();
    }

    public void deleteEmployee()
    {
       
        String sqlQuery = "";
        // delete employee from the database
        sqlQuery = "DELETE FROM BOOKITDB.EMPLOYEES WHERE EMP_ID='"
                + Integer.valueOf(empView.getSelectionModel().getSelectedIndex()+1) + "'";

        sendDBCommand(sqlQuery);
        loadEmployee();
    }
    
    public void loadExpense()
    {
        String sqlQuery = "";
        String listString = "";
        sqlQuery = "Select * from BOOKITDB.EXPENSES";
        //calling the sendDBCommand method
        sendDBCommand(sqlQuery);
        Expenses.invoiceCount = 0;
        expenseArray.clear();
        //to test the sqlException
        try
        {
            //while there is a next expense
            while (dbResults.next())
            {

                int invoiceNum = Integer.parseInt(dbResults.getString(1));
                String expType = dbResults.getString(2);
                String expDate = dbResults.getString(3);
                Double expCost = Double.parseDouble(dbResults.getString(4));
                String expDesc = dbResults.getString(5);
                int store_id = Integer.parseInt(dbResults.getString(6));
                

                expenseArray.add(new Expenses(invoiceNum, expType, expDate, expCost,
                                    expDesc, store_id));

                System.out.println(expenseArray.get(expenseArray.size() - 1).toString());
                //set string to read from the DB
            }

        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        expenseView.refresh();
    }

    public void addExpense()
    {
        //creating an expense    

        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.EXPENSES (INVOICE_NUMBER, EXPENSE_TYPE,"
                + " EXPENSE_DATE, EXPENSE_COST, EXPENSE_DESC,"
                + "(";
        sqlQuery += "'" + ++Expenses.invoiceCount + "',";
        sqlQuery += "'" + cbxExpenseType.getSelectionModel().getSelectedItem() + "',";
        sqlQuery += "'" + txtExpenseDate.getText() + "',";
        sqlQuery += "'" + Double.parseDouble(txtExpenseCost.getText()) + "',";
        sqlQuery += "'" + txtExpenseDesc.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtStoreID.getText()) + "')";

        sendDBCommand(sqlQuery);

        System.out.println("Expense Count: " + Expenses.invoiceCount);

        loadExpense();
    }

    public void updateExpense()
    {
        //update an expense from the database
 
        String sqlQuery = "";
        sqlQuery = "UPDATE BOOKITDB.EXPENSES SET EXPENSE_TYPE=" + "'" + cbxExpenseType.getSelectionModel().getSelectedItem()
                + "', EXPENSE_DATE=" + "'" + txtExpenseDate.getText()
                + "', EXPENSE_COST=" + "'" + Double.parseDouble(txtExpenseCost.getText())
                + "', EXPENSE_DESC=" + "'" + txtExpenseDesc.getText()
                + "', STORE_ID=" + "'" + Integer.parseInt(txtStoreID.getText())
                + "' WHERE INVOICE_NUMBER='" + (Integer.valueOf(expenseView.getSelectionModel().getSelectedIndex()+1)) + "'";

        sendDBCommand(sqlQuery);

        loadExpense();
    }

    public void deleteExpense()
    {
       
        String sqlQuery = "";
        // delete and expense from the database
        sqlQuery = "DELETE FROM BOOKITDB.EXPENSES WHERE INVOICE_NUMBER='"
                + Integer.valueOf(expenseView.getSelectionModel().getSelectedIndex()+1) + "'";

        sendDBCommand(sqlQuery);
        loadExpense();
    }
    
    public void loadMember()
    {
        String sqlQuery = "";
        String listString = "";
        sqlQuery = "Select * from BOOKITDB.MEMBERS";
        //calling the sendDBCommand method
        sendDBCommand(sqlQuery);
        Member.memCount = 0;
        memberArray.clear();
        //to test the sqlException
        try
        {
            //while there is a next member
            while (dbResults.next())
            {

                int memID = Integer.parseInt(dbResults.getString(1));
                String memberFN = dbResults.getString(2);
                String memberLN = dbResults.getString(3);
                String memberStreet = dbResults.getString(4);
                String memberCity = dbResults.getString(5);
                String memberState = dbResults.getString(6);
                int zipCode = Integer.parseInt(dbResults.getString(7));
                String memberCell = dbResults.getString(8);
                String email = dbResults.getString(9);
              

                memberArray.add(new Member(memID, memberFN, memberLN, memberStreet,
                memberCity, memberState, zipCode, memberCell, email));

                System.out.println(memberArray.get(memberArray.size() - 1).toString());
                //set string to read from the DB
            }

        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
     
     
        cbxMemberID.getItems().addAll(memberView);
        memberView.refresh();
    }

    public void insertMember()
    {
        // creating the bookstore items     

        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.Members (MEMBER_ID, FNAME, LNAME,"
                + "STREET, CITY, STATE, ZIP, CELL, EMAIL) VALUES (";
        sqlQuery += "'" + ++Member.memCount + "',";
        sqlQuery += "'" + txtMemberFN.getText() + "',";
        sqlQuery += "'" + txtMemberLN.getText() + "',";
        sqlQuery += "'" + txtMemberStreet.getText() + "',";
        sqlQuery += "'" + txtMemberCity.getText() + "',";
        sqlQuery += "'" + txtMemberState.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtMemberZip.getText()) + "',";
        sqlQuery += "'" + txtMemberPhone.getText() + "',";
        sqlQuery += "'" + txtMemberEmail.getText() + "')";
       
        sendDBCommand(sqlQuery);

        System.out.println("Member Count: " + Member.memCount);

        loadMember();
    }

    public void updateMember()
    {
 
        String sqlQuery = "";
        sqlQuery = "UPDATE BOOKITDB.MEMBERS SET FNAME=" + "'" + txtMemberFN.getText()
                + "', LNAME=" + "'" + txtMemberLN.getText()
                + "', STREET=" + "'" + txtMemberStreet.getText()
                + "', CITY=" + "'" + txtMemberCity.getText()
                + "', STATE=" + "'" + txtMemberState.getText()
                + "', ZIPCODE=" + "'" + Integer.parseInt(txtMemberZip.getText())
                + "', CELL=" + "'" + txtMemberPhone.getText()
                + "', EMAIL=" + "'" + txtMemberEmail.getText()
                + "' WHERE MEMBER_ID='" + (Integer.valueOf(memberView.getSelectionModel().getSelectedIndex()+1)) + "'";

        sendDBCommand(sqlQuery);

        loadMember();
    }

    public void deleteMember()
    {
       
        String sqlQuery = "";
        // delete member from the database
        sqlQuery = "DELETE FROM BOOKITDB.MEMBERS WHERE MEMBER_ID='"
                + Integer.valueOf(memberView.getSelectionModel().getSelectedIndex()+1) + "'";

        sendDBCommand(sqlQuery);
        loadMember();
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
//            priceArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
//                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
//                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));

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
//            yearArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
//                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
//                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
//            
            yearArray.add(new Book(dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
                    Double.valueOf(dbResults.getString(5)), dbResults.getString(11), dbResults.getString(6),
                    dbResults.getString(7), dbResults.getString(8), dbResults.getString(9), Integer.valueOf(dbResults.getString(10))));
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
//            genreArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
//                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
//                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));

            genreArray.add(new Book(dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
                    Double.valueOf(dbResults.getString(5)), dbResults.getString(11), dbResults.getString(6),
                    dbResults.getString(7), dbResults.getString(8), dbResults.getString(9), Integer.valueOf(dbResults.getString(10))));
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
//            bookArray.add(new Book(dbResults.getString(6), dbResults.getString(7),
//                    dbResults.getString(8), dbResults.getString(9),
//                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2),
//                    dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
//                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
            bookArray.add(new Book(dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
                    Double.valueOf(dbResults.getString(5)), dbResults.getString(11), dbResults.getString(6),
                    dbResults.getString(7), dbResults.getString(8), dbResults.getString(9), Integer.valueOf(dbResults.getString(10))));

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
                    Integer.valueOf(dbResults.getString(4)), Double.valueOf(dbResults.getString(5)), dbResults.getString(11)));
        }

        ObservableList<Inventory> cafeList = FXCollections.observableArrayList(cafeArray);

        cafeView.setItems(cafeList);
    }

//    public void fillCbxMember() throws SQLException
//    {
//        String sqlQuery = "";
//        sqlQuery = "SELECT * FROM BOOKITDB.MEMBERS";
//        ArrayList<Member> memberArray = new ArrayList<>();
//
//        sendDBCommand(sqlQuery);
//        while (dbResults.next())
//        {
//           int memID = Integer.parseInt(dbResults.getString(1));
//                String memberFN = dbResults.getString(2);
//                String memberLN = dbResults.getString(3);
//                String memberStreet = dbResults.getString(4);
//                String memberCity = dbResults.getString(5);
//                String memberState = dbResults.getString(6);
//                int zipCode = Integer.parseInt(dbResults.getString(7));
//                String memberCell = dbResults.getString(8);
//                String email = dbResults.getString(9);
//              
//
//                memberArray.add(new Member(memID, memberFN, memberLN, memberStreet,
//                memberCity, memberState, zipCode, memberCell, email));
//        }
//        ObservableList<Member> memberList = FXCollections.observableArrayList(memberArray);
//        cbxMemberID.getItems().addAll(memberList);

//    }

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
