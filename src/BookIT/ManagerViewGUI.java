/*
 * Author: Team DMO
 * Date: 6/19/2017  
 * Assignment: Final Project   
 * Purpose: Do the damn thing
 */
package BookIT;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;

/**
 *
 * @author Daniel
 */
public class ManagerViewGUI extends Application {
    
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
    Button btnInventorySubmit = new Button ("Add Item");
    Button btnInventoryUpdate = new Button ("Update Item");
    Button btnInventoryDelete = new Button ("Delete Item");
    ListView inventoryView = new ListView();
    
    // Employee View Stuff
    Label lblEmployeeID = new Label ("ID:");
    Label lblEmployeeFName = new Label ("First Name: ");
    Label lblEmployeeLName = new Label ("Last Name: ");
    Label lblEmployeeUsername = new Label ("Username: ");
    Label lblEmployeePassword = new Label ("Password: ");
    Label lblEmployeePay = new Label ("Starting $/hr: ");
    Label lblEmployeeAddress = new Label ("Address: ");
    Label lblEmployeeCity = new Label ("City: ");
    Label lblEmployeeState = new Label ("State: ");
    Label lblEmployeeZip = new Label ("Zip: ");
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
    
    @Override
    public void start(Stage primaryStage) {
        
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
        employeePane.add(lblEmployeeAddress,0,3);
        employeePane.add(txtEmployeeAddress,1,3);
        employeePane.add(lblEmployeeCity,0,4);
        employeePane.add(txtEmployeeCity,1,4);
        employeePane.add(lblEmployeeState,0,5);
        employeePane.add(txtEmployeeState,1,5);
        employeePane.add(lblEmployeeZip,0,6);
        employeePane.add(txtEmployeeZip,1,6);
        employeePane.add(lblEmployeeUsername,0,7);
        employeePane.add(txtEmployeeUsername,1,7);
        employeePane.add(lblEmployeePassword,0,8);
        employeePane.add(txtEmployeePassword,1,8);
        employeePane.add(lblEmployeePay,0,9);
        employeePane.add(txtEmployeePay,1,9);
        employeePane.add(btnEmployeeAdd,0,10);
        employeePane.add(btnEmployeeUpdate,1,10);
        employeePane.add(btnEmployeeDelete,2,10);
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
        
        
        Scene overallScene = new Scene(overallPane,700,650);
        
        primaryStage.setScene(overallScene);
        primaryStage.setTitle("Manager View");
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
