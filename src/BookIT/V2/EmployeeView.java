//employee view window
//called from the loginMainForm and is the view that provides
//everything for the employees.
//pos tab
//clockin clockout tab
//shifts tab

package BookIT.V2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Trenton
 */
public class EmployeeView extends LoginMainForm{

    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;
    
    GridPane employeePane = new GridPane();
    GridPane employeePaneOverall = new GridPane();
    GridPane employeeViewPane = new GridPane();
    
    // Employee View Stuff
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
    ComboBox cbxManagerID = new ComboBox();
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
    ListView employeeView = new ListView();
    ArrayList<Employee> employeeArray = new ArrayList<>();
    
    //initial employee scene, tab pane, & tabs
    TabPane empTabs = new TabPane();
    Scene empScene = new Scene(empTabs, 300, 300);
    Tab empTimeClock = new Tab("Clock in/out");
    Tab empPosTab = new Tab("Point of Sale");
    Tab empShiftTab = new Tab("Shifts");
    
    //Pane & controls for employee check in/out tab
    GridPane empTimeClockPane = new GridPane();
    Label lblTime = new Label("Time:");
    TextField txtTime = new TextField();
    Button btnChkIn = new Button("Check In");
    Button btnChkOut = new Button("Check Out");
    
    // Pane & controls for employee shift tab
    GridPane empShiftPane = new GridPane();
    ListView empShiftView = new ListView();
    
    
    
    //Employee view constructor
    public EmployeeView()
    {
        //adding tabs to employee tab pane
        empTabs.getTabs().addAll(empPosTab, empTimeClock, empShiftTab);
        
        //setting tabs to uncloseable
        empPosTab.setClosable(false);
        empTimeClock. setClosable(false);
        empShiftTab.setClosable(false);
        
        //adding controls to employee check in/out tab
        empTimeClock.setContent(empTimeClockPane);
        empTimeClockPane.setAlignment(Pos.CENTER);
        empTimeClockPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        empTimeClockPane.setVgap(5);
        empTimeClockPane.setHgap(5);
        empTimeClockPane.add(lblTime, 0, 0);
        empTimeClockPane.add(txtTime, 1, 0);
        empTimeClockPane.add(btnChkIn, 1, 1);
        empTimeClockPane.add(btnChkOut, 1, 2);
        
        
    }

}