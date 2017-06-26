/*
Authors: Drink More Ovaltine Group
Date: 6/21/17
Assignment: CIS 484 Group Project
Purpose: Main UI Form
 */
package BookIT;

import java.time.LocalTime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author KP
 */
public class MainForm extends Application {
    
    // ArrayLists
    ArrayList<Customer> custArray = new ArrayList<>();
    ArrayList<Employee> empArray = new ArrayList<>();
    ArrayList<Manager> manArray = new ArrayList<>();
    
    // MY created objects to get login stuff working
    Customer kpCust = new Customer("Kyle", "Porter", "881 Port Republic Rd.", 
            "Harrisonburg", "VA", 23456, "5402149556", "porterkc@dukes.jmu.edu");
    Employee kpEmp = new Employee();
    Manager kpMan = new Manager(0, 0);
    
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
    
    //Overall pane for tab pane on manager scene
    GridPane overallPane = new GridPane();
    
    // tab pane and tabs
    TabPane tabPane = new TabPane();
    Tab tab1 = new Tab("Inventory");
    Tab tab2 = new Tab ("Employee");
    Tab tab3 = new Tab ("Expenses");
    Tab tab4 = new Tab("POS");
    Tab tab5 = new Tab ("Shifts");
    
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
    Button btnInventorySubmit = new Button ("Add Item");
    Button btnInventoryUpdate = new Button ("Update Item");
    Button btnInventoryDelete = new Button ("Delete Item");
    ListView inventoryView = new ListView();
    
    // Employee View Stuff
    Label lblEmployeeID = new Label ("ID:");
    Label lblEmployeeFName = new Label ("First Name:");
    Label lblEmployeeLName = new Label ("Last Name:");
    Label lblEmployeeUsername = new Label ("Username:");
    Label lblEmployeePassword = new Label ("Password:");
    Label lblEmployeePay = new Label ("Starting $/hr:");
    TextField txtEmployeeID = new TextField();
    TextField txtEmployeeFirst = new TextField();
    TextField txtEmployeeLast = new TextField();
    TextField txtEmployeeUsername = new TextField();
    TextField txtEmployeePassword = new TextField();
    TextField txtEmployeePay = new TextField();
    Button btnEmployeeAdd = new Button ("Add Employee");
    Button btnEmployeeUpdate = new Button ("Update Employee");
    Button btnEmployeeDelete = new Button ("Delete Employee");
    ListView employeeView = new ListView();
    
    
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
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        // created customer, setting username & password, & add to ArrayList
        kpCust.setUsername("KCP757");
        kpCust.setPassword("K3ll@mBB");
        custArray.add(kpCust);
        kpEmp.setUsername("empuser");
        kpEmp.setPassword("emppass");
        empArray.add(kpEmp);
        
        // adding login controls
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
        tblcBookID.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("invID"));
        tblcBook.setCellValueFactory(new PropertyValueFactory<Inventory, String>("itemName"));
        tblcGenre.setCellValueFactory(new PropertyValueFactory<Inventory, String>("itemDesc"));
        tblcBookPrice.setCellValueFactory(new PropertyValueFactory<Inventory, Double>("itemPrice"));
        tblcBookStore.setCellValueFactory(new PropertyValueFactory<Inventory, Store>("itemStore"));
        
        
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
        
        
        tabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);
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
        inventoryPane.add(btnInventorySubmit,0,5);
        inventoryPane.add(btnInventoryUpdate,1,5);
        inventoryPane.add(btnInventoryDelete,2,5);
        inventoryViewPane.setAlignment(Pos.CENTER);
        inventoryPaneOverall.setAlignment(Pos.CENTER);
        inventoryViewPane.add(inventoryView,0,0);
        inventoryPaneOverall.add(inventoryPane,0,0);
        inventoryPaneOverall.add(inventoryViewPane,1,0);
        
        
        // Employee View
        employeePane.setAlignment(Pos.CENTER);
        employeePane.add(lblEmployeeID,0,0);
        employeePane.add(txtEmployeeID,1,0);
        employeePane.add(lblEmployeeFName,0,1);
        employeePane.add(txtEmployeeFirst,1,1);
        employeePane.add(lblEmployeeLName,0,2);
        employeePane.add(txtEmployeeLast,1,2);
        employeePane.add(lblEmployeeUsername,0,3);
        employeePane.add(txtEmployeeUsername,1,3);
        employeePane.add(lblEmployeePassword,0,4);
        employeePane.add(txtEmployeePassword,1,4);
        employeePane.add(lblEmployeePay,0,5);
        employeePane.add(txtEmployeePay,1,5);
        employeePane.add(btnEmployeeAdd,0,6);
        employeePane.add(btnEmployeeUpdate,1,6);
        employeePane.add(btnEmployeeDelete,2,6);
        employeeViewPane.setAlignment(Pos.CENTER);
        employeePaneOverall.setAlignment(Pos.CENTER);
        employeeViewPane.add(employeeView,0,0);
        employeePaneOverall.add(employeePane, 0, 0);
        employeePaneOverall.add(employeeViewPane,1,0);
        
        
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
        
        
        Scene overallScene = new Scene(overallPane,600,550);
        
        
        
        // Login button action
        btnLogIn.setOnAction(e -> {
            // getting username & password entered
            String user = txtUser.getText();
            String pass = txtPass.getText();
            
            // if customer is selected
            if (cboLoginType.getSelectionModel().getSelectedItem() == "Customer")
            {
                // search through customer array looking for login credentials
                for (Customer c: custArray)
                {
                    if (user.equals(c.getUsername()) & pass.equals(c.getPassword()))
                    {
                        // open Customer GUI
                        primaryStage.setScene(custScene);
                        primaryStage.setTitle(c.getFName() + " " + c.getLName());
                        primaryStage.show();
                    }
                    else
                    {
                        // login error message
                        Alert loginAlert = new Alert(Alert.AlertType.ERROR);
                        loginAlert.setContentText("Invalid login credentials");
                        loginAlert.show();
                    }
                }
            }
            
            // if employee is selected
            if (cboLoginType.getSelectionModel().getSelectedItem() == "Employee")
            {
                // search thru employee array for login credentials
                for (Employee p: empArray)
                {
                    if (user.equals(p.getUsername()) & pass.equals(p.getPassword()))
                    {
                        // open employee GUI
                        primaryStage.setScene(empScene);
                        primaryStage.setTitle(p.getFName() + " " + p.getLName());
                        primaryStage.show();
                    }
                    else
                    {
                        // login error message
                        Alert loginAlert = new Alert(Alert.AlertType.ERROR);
                        loginAlert.setContentText("Invalid login credentials");
                        loginAlert.show();
                    }
                }
            }
            
            // if management is selected
            if (cboLoginType.getSelectionModel().getSelectedItem() == "Management")
            {
                // search thru manager array for login credentials
                for (Manager m: manArray)
                {
                    if (user.equals())
                }
                
                
                // if login successful, open Manager Gui
                
                primaryStage.setScene(overallScene);
                primaryStage.setTitle("Manager Name");
                primaryStage.show();
                
            }
            
        });
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
