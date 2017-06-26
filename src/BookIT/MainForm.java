/*
Authors: Drink More Ovaltine Group
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Main UI Form
 */
package BookIT;

import java.time.LocalTime;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;
import oracle.jdbc.pool.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author KP
 */
public class MainForm extends Application {
    
    // ArrayLists
    ArrayList<Member> memberArray = new ArrayList<>();
    ArrayList<Employee> empArray = new ArrayList<>();
    
    //Observable Lists
    ObservableList<Employee> empList = FXCollections.observableArrayList(empArray);

    // login controls
    Label lblUser = new Label("Username:");
    Label lblPass = new Label("Password:");
    TextField txtUser = new TextField();
    TextField txtPass = new TextField();
    ComboBox<String> cboLoginType = new ComboBox();
    Button btnLogIn = new Button("Login");
    
    // intial customer scene, tab pane, & tabs
    TabPane custTabs = new TabPane();
    Scene custScene = new Scene(custTabs, 500, 500);
    Tab custInvTab = new Tab("Inventory:");
    Tab custMemTab = new Tab("Membership Info:");
    Tab custInfoTab = new Tab("Customer Info:");
    
    // pane & controls for customer inventory tab
    GridPane custInvPane = new GridPane();
    TableView custInvTbl = new TableView();
    Button btnBuyProd = new Button("Buy Product");
    
    // pane & controls for customer membership tab
    GridPane custMemPane = new GridPane();
    
    
    // pane & controls for customer info tab
    GridPane custInfoPane = new GridPane();
    Label lblCustUser = new Label("Username:");
    Label lblCustPass = new Label("Password:");
    Label lblCustEmail = new Label("eMail:");
    Label lblCustPhone = new Label("Phone:");
    Label lblCustStreet = new Label("Street:");
    Label lblCustCity = new Label("City:");
    Label lblCustState = new Label("State");
    Label lblCustZip = new Label("ZIP:");
    TextField txtCustUser = new TextField();
    TextField txtCustPass = new TextField();
    TextField txtCustEmail = new TextField();
    TextField txtCustPhone = new TextField();
    TextField txtCustStreet = new TextField();
    TextField txtCustCity = new TextField();
    TextField txtCustState = new TextField();
    TextField txtCustZip = new TextField();
    Button btnCustUpdate = new Button("Update");
    
    // intial employee scene, tab pane, & tabs
    TabPane empTabs = new TabPane();
    Scene empScene = new Scene(empTabs, 300, 300);
    Tab empChkTab = new Tab("Check in/out");
    Tab empShiftTab = new Tab("Shifts");
    
    // Pane & controls for employee check in/out tab
    GridPane empChkPane = new GridPane();
    Label lblTime = new Label("Time:");
    TextField txtTime = new TextField();
    Button btnChkIn = new Button("Check In");
    Button btnChkOut = new Button("Check Out");
    
    // Pane & controls for employee shift tab
    GridPane empShiftPane = new GridPane();
    ListView empShiftView = new ListView();
    
     //Overall pane for tab pane
    GridPane overallPane = new GridPane();
    
    // tab pane and tabs
    TabPane tabPane = new TabPane();
    Tab tab1 = new Tab("Inventory");
    Tab tab2 = new Tab ("Employee");
    Tab tab3 = new Tab ("Expenses");
    Tab tab4 = new Tab("POS");
    Tab tab5 = new Tab ("Shifts");
    Tab tab6 = new Tab ("Member");
    
    // grid panes
    GridPane expensePane = new GridPane();
    GridPane expenseViewPane = new GridPane();
    GridPane expensePaneOverall = new GridPane();
    GridPane inventoryPane = new GridPane();
    GridPane inventoryViewPane = new GridPane();
    GridPane inventoryPaneOverall = new GridPane();
    GridPane employeePane = new GridPane();
    GridPane employeePaneOverall = new GridPane();
    GridPane employeeViewPane = new GridPane();
    GridPane posPane = new GridPane();
    GridPane posPaneOverall = new GridPane();
    GridPane shiftPane = new GridPane();
    GridPane shiftViewPane = new GridPane();
    GridPane shiftPaneOverall = new GridPane();
    GridPane customerPane = new GridPane();
    GridPane customerViewPane = new GridPane();
    GridPane customerPaneOverall = new GridPane();
    GridPane reportsPane = new GridPane();
    
    //Expense View Stuff
    Label lblExpenseID = new Label("ID:");
    Label lblExpenseType = new Label("Expense Type:");
    Label lblExpenseDate = new Label("Date:");
    Label lblExpensePrice = new Label("Price:");
    Label lblExpenseComments = new Label("Comments:");
    TextField txtExpenseID = new TextField(); // this text field will eventually be pulled from the expense class after creation
    ComboBox cbxExpenseType = new ComboBox();
    TextField txtExpenseType = new TextField();
    TextField txtExpenseDate = new TextField();
    TextField txtExpensePrice = new TextField();
    TextField txtExpenseComments = new TextField();
    Button btnExpenseSubmit = new Button("Submit");
    Button btnExpenseView = new Button("View");
    Button btnExpenseDelete = new Button("Delete");
    Button btnExpenseUpdate = new Button("Update");    
    ListView expenseView = new ListView();
    ArrayList <Expense> expenseArray = new ArrayList<>();
    
    // Inventory View stuff
    Label lblInventoryID = new Label("ID:");
    Label lblInventoryName = new Label ("Name:");
    Label lblInventoryDescription = new Label ("Description:");
    Label lblInventoryPrice = new Label ("Price:");
    RadioButton rbInventoryBook = new RadioButton("Bookstore");
    RadioButton rbInventoryCoffee = new RadioButton ("Coffee");
    ToggleGroup inventoryToggle = new ToggleGroup();
    TextField txtInventoryID = new TextField();
    TextField txtInventoryName = new TextField();
    TextField txtInventoryDescription = new TextField();
    TextField txtInventoryPrice = new TextField();
    Button btnInventoryAdd = new Button ("Add Item");
    Button btnInventoryUpdate = new Button ("Update Item");
    Button btnInventoryDelete = new Button ("Delete Item");
    ListView inventoryView = new ListView();
    GridPane bookPane = new GridPane();
    Label lblBookAuthor = new Label("Author: ");
    Label lblBookGenre = new Label ("Genre: ");
    Label lblBookISBN = new Label ("ISBN: ");
    Label lblBookPublisher = new Label("Publisher: ");
    Label lblBookYear = new Label ("Year: ");
    TextField txtBookAuthor = new TextField();
    TextField txtBookISBN = new TextField();
    ComboBox cbxBookGenre = new ComboBox();
    TextField txtBookPublisher = new TextField();
    TextField txtBookYear = new TextField();
    Button btnAddBook = new Button ("Add Book");
    
    // Employee View Stuff
    Label lblEmployeeID = new Label ("ID:");
    Label lblEmployeeFName = new Label ("First Name: ");
    Label lblEmployeeLName = new Label ("Last Name: ");
    Label lblEmployeeUsername = new Label ("Username: ");
    Label lblEmployeePassword = new Label ("Password: ");
    Label lblEmployeePay = new Label ("Starting wage: ");
    Label lblEmployeeAddress = new Label ("Address: ");
    Label lblEmployeeCity = new Label ("City: ");
    Label lblEmployeeState = new Label ("State: ");
    Label lblEmployeeZip = new Label ("Zip: ");
    Label lblEmployeePhone = new Label ("Phone #: ");
    Label lblEmployeeType = new Label ("Employee Type: ");
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
    Button btnEmployeeAdd = new Button ("Add Employee");
    Button btnEmployeeUpdate = new Button ("Update Employee");
    Button btnEmployeeDelete = new Button ("Delete Employee");
    ListView employeeView = new ListView();
    ArrayList<Employee> employeeArray = new ArrayList<>();
    
    // Shifts View
    Label lblShiftDate = new Label("Shift Date: "); //Incorporate calendar
    Label lblShiftStart = new Label ("Shift Start Time: ");
    Label lblShiftEnd = new Label ("Shift End Time: ");
    TextField txtShiftDate = new TextField();
    TextField txtShiftStart = new TextField();
    TextField txtShiftEnd = new TextField();
    Button btnShiftAdd = new Button ("Add Shift");
    Button btnShiftUpdate = new Button ("Update Shift");
    Button btnShiftDelete = new Button ("Delete Shift");
    ListView shiftView = new ListView();
    
    
    //Customer view stuff
    Label lblCustomerID = new Label("Member ID:");
    Label lblCustomerFName = new Label ("First Name: ");
    Label lblCustomerLName = new Label ("Last Name: ");
    Label lblCustomerUsername = new Label ("Username: ");
    Label lblCustomerPassword = new Label ("Password: ");
    Label lblCustomerStreet = new Label ("Address: ");
    Label lblCustomerCity  = new Label ("City: ");
    Label lblCustomerState = new Label ("State: ");
    Label lblCustomerZip = new Label ("Zip: ");
    TextField txtCustomerID = new TextField();
    TextField txtCustomerFName = new TextField();
    TextField txtCustomerLName = new TextField();
    TextField txtCustomerStreet = new TextField();
    TextField txtCustomerCity = new TextField();
    TextField txtCustomerState = new TextField();
    TextField txtCustomerZip = new TextField();
    TextField txtCustomerUsername = new TextField();    
    TextField txtCustomerPassword = new TextField();    
    Button btnCustomerAdd = new Button ("Add Member");
    Button btnCustomerUpdate = new Button ("Update Member");
    Button btnCustomerDelete = new Button ("Delete Member");
    Button btnCustomerReports = new Button ("Member Reports");
    ListView customerView = new ListView();
    
     Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
     
        
        
        cboLoginType.getItems().add("Customer");
        cboLoginType.getItems().add("Employee");
        cboLoginType.getItems().add("Management");

        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setHgap(15);
        mainPane.setVgap(7);
        mainPane.add(lblUser, 0, 0);
        mainPane.add(lblPass, 0, 1);
        mainPane.add(cboLoginType, 0, 2);
        mainPane.add(txtUser, 1, 0);
        mainPane.add(txtPass, 1, 1);
        mainPane.add(btnLogIn, 1, 2);

        Scene scene = new Scene(mainPane, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Form");
        primaryStage.show();
        
        // adding tabs to customer tab pane
        custTabs.getTabs().add(custInvTab);
        custTabs.getTabs().add(custMemTab);
        custTabs.getTabs().add(custInfoTab);
        
        // making all customer tabs uncloseable to user
        custInvTab.setClosable(false);
        custMemTab.setClosable(false);
        custInfoTab.setClosable(false);
        
        // adding controls to customer inventory tab
        custInvTab.setContent(custInvPane);
        custInvPane.setAlignment(Pos.CENTER);
        custInvPane.setHgap(5);
        custInvPane.setVgap(5);
        custInvPane.add(custInvTbl, 0, 0);
        custInvPane.add(btnBuyProd, 0, 1);
        
        // adding controls to customer membership tab
        custMemTab.setContent(custMemPane);
        custMemPane.setAlignment(Pos.CENTER);
        custMemPane.setHgap(5);
        custMemPane.setVgap(5);
        
        
        
        
        // adding controls to customer info tab
        custInfoTab.setContent(custInfoPane);
        custInfoPane.setAlignment(Pos.CENTER);
        custInfoPane.setHgap(5);
        custInfoPane.setVgap(5);
        custInfoPane.add(lblCustUser, 0, 0);
        custInfoPane.add(lblCustPass, 0, 1);
        custInfoPane.add(lblCustEmail, 0, 2);
        custInfoPane.add(lblCustPhone, 0, 3);
        custInfoPane.add(lblCustStreet, 0, 4);
        custInfoPane.add(lblCustCity, 0, 5);
        custInfoPane.add(lblCustState, 0, 6);
        custInfoPane.add(lblCustZip, 0, 7);
        custInfoPane.add(txtCustUser, 1, 0);
        custInfoPane.add(txtCustPass, 1, 1);
        custInfoPane.add(txtCustEmail, 1, 2);
        custInfoPane.add(txtCustPhone, 1, 3);
        custInfoPane.add(txtCustStreet, 1, 4);
        custInfoPane.add(txtCustCity, 1, 5);
        custInfoPane.add(txtCustState, 1, 6);
        custInfoPane.add(txtCustZip, 1, 7);
        custInfoPane.add(btnCustUpdate, 1, 8);
           
        // adding columns to customer inventory table
        TableColumn tblcBookID = new TableColumn("ID");
        TableColumn tblcBook = new TableColumn("Book");
        TableColumn tblcGenre = new TableColumn("Genre");
        TableColumn tblcBookPrice = new TableColumn("Price");
        TableColumn tblcBookStore = new TableColumn("Store");
        custInvTbl.getColumns().addAll(tblcBookID, tblcBook, tblcGenre, 
                tblcBookPrice, tblcBookStore);
                
        // populating customer inventory table cells
        
        
        
        
        // adding tabs to employee tab pane
        empTabs.getTabs().addAll(empChkTab, empShiftTab);
        
        // setting tabs to uncloseable
        empChkTab.setClosable(false);
        empShiftTab.setClosable(false);
        
        // adding controls to employee check in/out tab
        empChkTab.setContent(empChkPane);
        empChkPane.setAlignment(Pos.CENTER);
        empChkPane.setVgap(5);
        empChkPane.setHgap(5);
        empChkPane.add(lblTime, 0, 0);
        empChkPane.add(txtTime, 1, 0);
        empChkPane.add(btnChkIn, 1, 1);
        empChkPane.add(btnChkOut, 1, 2);
        
        // adding controls to employee shift tab
        empShiftTab.setContent(empShiftPane);
        empShiftPane.setAlignment(Pos.CENTER);
        empShiftPane.setVgap(5);
        empShiftPane.setHgap(5);
        empShiftPane.add(empShiftView, 0, 0);
        
        // setting the time text box equal to current time
        String hour = String.valueOf(LocalTime.now().getHour());
        String min = String.valueOf(LocalTime.now().getMinute());
        txtTime.setText(hour + ":" + min);
        txtTime.setEditable(false);
        
        
        
        
        tab1.setContent(inventoryPaneOverall);
        tab1.setClosable(false);
        tab2.setContent(employeePaneOverall);
        tab2.setClosable(false);
        tab3.setContent(expensePaneOverall);
        tab3.setClosable(false);
        tab4.setContent(posPaneOverall);
        tab4.setClosable(false);
        tab5.setContent(shiftPaneOverall);
        tab5.setClosable(false);
        tab6.setContent(customerPaneOverall);
        tab6.setClosable(false);
        
        
        tabPane.getTabs().addAll(tab2,tab6,tab1,tab3,tab4,tab5);
        overallPane.setAlignment(Pos.TOP_CENTER);
        overallPane.add(tabPane,0,0);
        
        //Expense Pane adds
        expensePane.setAlignment(Pos.CENTER);
        expensePane.add(lblExpenseID,0,0);
        expensePane.add(txtExpenseID,1,0);//Eventually this will be a field that pulls the current ID number from the class
        expensePane.add(lblExpenseType,0,1);
        expensePane.add(cbxExpenseType,1,1);
        expensePane.add(lblExpenseDate,0,2);
        expensePane.add(txtExpenseDate,1,2);
        expensePane.add(lblExpensePrice,0,3);
        expensePane.add(txtExpensePrice,1,3);
        expensePane.add(lblExpenseComments,0,4);
        expensePane.add(txtExpenseComments,1,4);
        expensePane.add(btnExpenseSubmit,1,5);
        expensePane.add(btnExpenseView,0,5);
        expensePane.add(btnExpenseUpdate,2,5);
        expensePane.add(btnExpenseDelete,3,5);
        expenseViewPane.setAlignment(Pos.CENTER);
        expensePaneOverall.setAlignment(Pos.TOP_CENTER);
        expenseViewPane.add(expenseView,0,0);        
        expensePaneOverall.add(expensePane,0,0);
        expensePaneOverall.add(expenseViewPane,1,0);
        
        cbxExpenseType.getItems().addAll("Maintenance","Purchase Order","Utilities", "Payroll");
        
        
         // Inventory pane adds
        inventoryPane.setAlignment(Pos.CENTER);
        inventoryPane.add(lblInventoryID,0,0);
        inventoryPane.add(txtInventoryID,1,0);
        inventoryPane.add(lblInventoryName,0,1);
        inventoryPane.add(txtInventoryName,1,1);
        inventoryPane.add(lblInventoryDescription,0,2);
        inventoryPane.add(txtInventoryDescription,1,2);
        inventoryPane.add(lblInventoryPrice,0,3);
        inventoryPane.add(txtInventoryPrice,1,3);
        rbInventoryBook.setToggleGroup(inventoryToggle);
        rbInventoryCoffee.setToggleGroup(inventoryToggle);
        inventoryPane.add(rbInventoryBook,0,4);
        inventoryPane.add(rbInventoryCoffee,1,4);
        inventoryPane.add(btnInventoryAdd,0,5);
        inventoryPane.add(btnInventoryUpdate,1,5);
        inventoryPane.add(btnInventoryDelete,2,5);
        inventoryViewPane.setAlignment(Pos.CENTER);
        inventoryPaneOverall.setAlignment(Pos.CENTER);
        inventoryViewPane.add(inventoryView,0,0);
        inventoryPaneOverall.add(inventoryPane,0,0);
        inventoryPaneOverall.add(inventoryViewPane,1,0);
        
        cbxBookGenre.getItems().addAll("Fiction","Non-Fiction","Mystery","Fantasy/Sci-Fi","Childrens","Young Adult","Educational",
                "Romance","Horror","Art");
        bookPane.setAlignment(Pos.CENTER);
        bookPane.add(lblBookISBN,0,0);
        bookPane.add(txtBookISBN,1,0);
        bookPane.add(lblBookAuthor,0,1);
        bookPane.add(txtBookAuthor,1,1);
        bookPane.add(lblBookGenre,0,2);
        bookPane.add(cbxBookGenre,1,2);
        bookPane.add(lblBookPublisher,0,3);
        bookPane.add(txtBookPublisher,1,3);
        bookPane.add(lblBookYear,0,4);
        bookPane.add(txtBookYear,1,4);
        bookPane.add(btnAddBook,0,5);
        
        Stage bookStage = new Stage();
        
        Scene bookScene = new Scene(bookPane,400,300);
        bookStage.setScene(bookScene);
        
        
        // Employee View
        employeePane.setAlignment(Pos.CENTER);
        employeePane.add(lblEmployeeID,0,0);
        employeePane.add(txtEmployeeID,1,0);
        employeePane.add(lblEmployeeFName,0,1);
        employeePane.add(txtEmployeeFirst,1,1);
        employeePane.add(lblEmployeeLName,0,2);
        employeePane.add(txtEmployeeLast,1,2);
        employeePane.add(lblEmployeeAddress,0,3);
        employeePane.add(txtEmployeeAddress,1,3);
        employeePane.add(lblEmployeeCity,0,4);
        employeePane.add(txtEmployeeCity,1,4);
        employeePane.add(lblEmployeeState,0,5);
        employeePane.add(txtEmployeeState,1,5);
        employeePane.add(lblEmployeeZip,0,6);
        employeePane.add(txtEmployeeZip,1,6);
        employeePane.add(lblEmployeePhone,0,7);
        employeePane.add(txtEmployeePhone,1,7);
        employeePane.add(lblEmployeeUsername,0,8);
        employeePane.add(txtEmployeeUsername,1,8);
        employeePane.add(lblEmployeePassword,0,9);
        employeePane.add(txtEmployeePassword,1,9);
        employeePane.add(lblEmployeeType,0,10);
        employeePane.add(cbxEmployeeType,1,10);
        employeePane.add(lblEmployeePay,0,11);
        employeePane.add(txtEmployeePay,1,11);
        employeePane.add(btnEmployeeAdd,0,12);
        employeePane.add(btnEmployeeUpdate,1,12);
        employeePane.add(btnEmployeeDelete,2,12);
        employeeViewPane.setAlignment(Pos.CENTER);
        employeePaneOverall.setAlignment(Pos.CENTER);
        employeeViewPane.add(employeeView,0,0);
        employeePaneOverall.add(employeePane, 0, 0);
        employeePaneOverall.add(employeeViewPane,1,0);
        cbxEmployeeType.getItems().addAll("Manager","Floor","Cafe");
        
        
        // Shift View
        shiftPane.setAlignment(Pos.CENTER);
        shiftPane.add(lblShiftDate,0,0);
        shiftPane.add(txtShiftDate,1,0);
        shiftPane.add(lblShiftStart,0,1);
        shiftPane.add(txtShiftStart,1,1);
        shiftPane.add(lblShiftEnd,0,2);
        shiftPane.add(txtShiftEnd,1,2);
        shiftPane.add(btnShiftAdd,0,3);
        shiftPane.add(btnShiftUpdate,1,3);
        shiftPane.add(btnShiftDelete,2,3);
        shiftPaneOverall.setAlignment(Pos.CENTER);
        shiftViewPane.setAlignment(Pos.CENTER);
        shiftViewPane.add(shiftView,0,0);
        shiftPaneOverall.add(shiftPane,0,0);
        shiftPaneOverall.add(shiftViewPane,1,0);
        
        
        //Customer View 
        customerPane.setAlignment(Pos.CENTER);
        customerPane.add(lblCustomerID,0,0);
        customerPane.add(txtCustomerID,1,0);
        customerPane.add(lblCustomerFName, 0,1);
        customerPane.add(txtCustomerFName,1,1);
        customerPane.add(lblCustomerLName,0,2);
        customerPane.add(txtCustomerLName,1,2);
        customerPane.add(lblCustomerUsername,0,3);
        customerPane.add(txtCustomerUsername,1,3);
        customerPane.add(lblCustomerPassword,0,4);
        customerPane.add(txtCustomerPassword,1,4);
        customerPane.add(lblCustomerStreet,0,5);
        customerPane.add(txtCustomerStreet,1,5);
        customerPane.add(lblCustomerCity,0,6);
        customerPane.add(txtCustomerCity,1,6);
        customerPane.add(lblCustomerState,0,7);
        customerPane.add(txtCustomerState,1,7);
        customerPane.add(lblCustomerZip,0,8);
        customerPane.add(txtCustomerZip,1,8);
        customerPane.add(btnCustomerAdd,0,9);
        customerPane.add(btnCustomerUpdate,1,9);
        customerPane.add(btnCustomerDelete,2,9);
        customerPaneOverall.setAlignment(Pos.CENTER);
        customerViewPane.setAlignment(Pos.CENTER);
        customerViewPane.add(customerView,0,0);
        customerPaneOverall.add(customerPane,0,0);
        customerPaneOverall.add(customerViewPane,1,0);
        
        
        Scene overallScene = new Scene(overallPane,600,550);
     
        
        
        
        // Login button action
        btnLogIn.setOnAction(e -> {
            String user = txtUser.getText();
            String pass = txtPass.getText();
            
            // if customer is selected
            if (cboLoginType.getSelectionModel().getSelectedItem() == "Customer")
            {
                for (Member m: memberArray)
                {
                    if (user.equals(m.getUserName()) & pass.equals(m.getPassword()))
                    {
                        // open customer GUI
                        primaryStage.setScene(custScene);
                        primaryStage.setTitle(m.getFName() + " " + m.getLName());
                        primaryStage.show();
                    }
                    else
                    {
                        Alert loginAlert = new Alert(Alert.AlertType.ERROR);
                        loginAlert.setContentText("Invalid login credentials");
                        loginAlert.show();
                    }
                }
            }
            
            // if employee is selected
            if (cboLoginType.getSelectionModel().getSelectedItem() == "Employee")
            {
                for (Employee p: empArray)
                {
                    if (user.equals(p.getUserName()) & pass.equals(p.getPassword()))
                    {
                        // open employee GUI
                        primaryStage.setScene(empScene);
                        primaryStage.setTitle(p.getFName() + " " + p.getLName());
                        primaryStage.show();
                    }
                    else
                    {
                        Alert loginAlert = new Alert(Alert.AlertType.ERROR);
                        loginAlert.setContentText("Invalid login credentials");
                        loginAlert.show();
                    }
                }
            }
            
            // if management is selected
            if (cboLoginType.getSelectionModel().getSelectedItem() == "Management")
            {
                primaryStage.setScene(overallScene);
                primaryStage.setTitle("Manager View");
                primaryStage.show();                
            }
            
        });
        
        
        //manager view inventory add button
        btnInventoryAdd.setOnAction(e->{
            if(rbInventoryBook.isSelected())
        {
            bookStage.show();
        }
            
        });
        
        //manager view employee add button
        
        ArrayList<Employee> employees = new ArrayList<>();
        String sqlEmpSizeQuery = "";
        sqlEmpSizeQuery = "SELECT * FROM JAVAUSER.EMPLOYEES";
        sendDBCommand(sqlEmpSizeQuery);
        
            while(dbResults.next())
            {
                 Employee empArray = new Employee(dbResults.getString(2),dbResults.getString(3)
                     , dbResults.getString(4),dbResults.getString(5)
                        ,dbResults.getString(6),Integer.valueOf(dbResults.getString(7)),
                        dbResults.getString(8),dbResults.getString(9), dbResults.getString(10),Double.valueOf(dbResults.getString(11)),dbResults.getString(13));
                 employees.add(empArray);
                 empList.add(empArray);
                 employeeView.setItems(empList);
            }
            
        
        
        btnEmployeeAdd.setOnAction(e->{
            
            int empIDStart = employees.size();
            
            empArray.add(new Employee(txtEmployeeFirst.getText(),txtEmployeeLast.getText(),txtEmployeeAddress.getText(),
            txtEmployeeCity.getText(),txtEmployeeState.getText(),Integer.valueOf(txtEmployeeZip.getText()),txtEmployeePhone.getText(),
            txtEmployeeUsername.getText(),txtEmployeePassword.getText(),Double.valueOf(txtEmployeePay.getText()),
            cbxEmployeeType.getSelectionModel().getSelectedItem().toString()));            
            
            Employee tempRef = empArray.get(empArray.size()-1);
            
            empList.add(tempRef);
            employeeView.setItems(empList);
            
            
            
            String sqlQuery = "";
            
            sqlQuery +="INSERT INTO JAVAUSER.EMPLOYEES (EMP_ID,FNAME,LNAME,STREET,CITY,STATE,ZIPCODE,CELL,USERNAME,PASSWORD,WAGE,EMP_TYPE) VALUES(";
            sqlQuery += (++empIDStart) + ",'";
            sqlQuery += txtEmployeeFirst.getText() +"','";
            sqlQuery += txtEmployeeLast.getText() + "','";
            sqlQuery += txtEmployeeAddress.getText() +"','";
            sqlQuery += txtEmployeeCity.getText() + "','";
            sqlQuery += txtEmployeeState.getText() +"',";
            sqlQuery += Integer.valueOf(txtEmployeeZip.getText()) +",'";
            sqlQuery += txtEmployeePhone.getText() +"','";
            sqlQuery += txtEmployeeUsername.getText() +"','";
            sqlQuery += txtEmployeePassword.getText() +"',";
            sqlQuery += Double.valueOf(txtEmployeePay.getText()) + ",'";
            sqlQuery += cbxEmployeeType.getSelectionModel().getSelectedItem() +"')";
            
            sendDBCommand(sqlQuery);
            
            
            
        });
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public void sendDBCommand(String sqlQuery)
    {
        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser"; // Change to YOUR Oracle username
        String userPASS = "javapass"; // Change to YOUR Oracle password
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
    
}
