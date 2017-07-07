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
import java.sql.Date;
import java.time.LocalDate;
import oracle.jdbc.pool.*;
import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author KP
 */
public class MainForm2 extends Application
{
    

    // ArrayLists
    ArrayList<Member> memberArray = new ArrayList<>();
    ArrayList<Employee> empArray = new ArrayList<>();
    
    // ******************* NEW ********************
    ArrayList<Shifts> shiftArray = new ArrayList<>();
    ArrayList<Payroll> payrollArray = new ArrayList<>();
    
    // ******************* END *************************
    
    

//    //Observable Lists
//    ObservableList<Employee> empList = FXCollections.observableArrayList(empArray);
//    //scroll bar
//    final ScrollBar scroll = new ScrollBar();
    
    
    // login controls
    Label lblLogIn = new Label("-------Log In---------");
    Label lblUser1 = new Label("Username:");
    Label lblPass1 = new Label("Password:");
    Label lblAccType = new Label("Select account type:");
//    Label lblCreate = new Label("------------------------");
//    Label lblFName = new Label("First Name:");
//    Label lblLName = new Label("Last Name:");
//    Label lblStreet = new Label("Street:");
//    Label lblCity = new Label("City:");
//    Label lblState = new Label("State:");
//    Label lblZipCode = new Label("Zip Code:");
//    Label lblCell = new Label("Cell#:");
//    Label lblEmail = new Label("Email:");
//    Label lblUser2 = new Label("Username:");
//    Label lblPass2 = new Label("Password:");
    TextField txtFName = new TextField();
    TextField txtLName = new TextField();
    TextField txtStreet = new TextField();
    TextField txtCity = new TextField();
    TextField txtState = new TextField();
    TextField txtZipCode = new TextField();
    TextField txtCell = new TextField();
    TextField txtEmail = new TextField();
    TextField txtUser2 = new TextField();
    TextField txtPass2 = new TextField();
    TextField txtUser1 = new TextField();
    TextField txtPass1 = new TextField();

    ComboBox<String> cboLoginType = new ComboBox();
    Button btnLogIn = new Button("Login");
    Button btnGuest = new Button("Continue as Guest");
    Button btnNewMember = new Button("Don't have an Account?");
    Button btnCreate = new Button("Become A Member!");
    GridPane mainPane = new GridPane();
    final Text blankText = new Text();
//        final Text txtLength = new Text();

    //logout controls
    Button btnLogOut = new Button("Logout");

    // intial Members scene, tab pane, & tabs
    TabPane memberTabs = new TabPane();
    Scene memberScene = new Scene(memberTabs, 500, 500);
    Tab memberInvTab = new Tab("Inventory:");
    Tab memberMemTab = new Tab("Membership Info:");
    Tab memberInfoTab = new Tab("Member Info:");

    // pane & controls for Members inventory tab
    GridPane memberInvPane = new GridPane();
    TableView memberInvTbl = new TableView();
    Button btnBuyProd = new Button("Buy Product");

    // pane & controls for Members membership tab
    GridPane memberMemPane = new GridPane();

    // pane & controls for Members info tab
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
    Tab tab2 = new Tab("Employee");
    Tab tab3 = new Tab("Expenses");
    Tab tab4 = new Tab("POS");
    Tab tab5 = new Tab("Shifts");
    Tab tab6 = new Tab("Member");

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
    GridPane posViewPane = new GridPane();
    GridPane posPaneOverall = new GridPane();
    GridPane shiftPane = new GridPane();
    GridPane shiftViewPane = new GridPane();
    GridPane shiftPaneOverall = new GridPane();
    GridPane MembersPane = new GridPane();
    GridPane MembersViewPane = new GridPane();
    GridPane MembersPaneOverall = new GridPane();
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
    ArrayList<Expenses> expenseArray = new ArrayList<>();

    // Inventory View stuff
    Label lblInventoryID = new Label("ID:");
    Label lblInventoryName = new Label("Name:");
    Label lblInventoryDescription = new Label("Description:");
    Label lblInventoryPrice = new Label("Price:");
    RadioButton rbInventoryBook = new RadioButton("Bookstore");
    RadioButton rbInventoryCoffee = new RadioButton("Coffee");
    ToggleGroup inventoryToggle = new ToggleGroup();
    TextField txtInventoryID = new TextField();
    TextField txtInventoryName = new TextField();
    TextField txtInventoryDescription = new TextField();
    TextField txtInventoryPrice = new TextField();
    Button btnInventoryAdd = new Button("Add Item");
    Button btnInventoryUpdate = new Button("Update Item");
    Button btnInventoryDelete = new Button("Delete Item");
    ListView inventoryView = new ListView();
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

    // Shifts View
    Label lblShiftDate = new Label("Shift Date: "); //Incorporate calendar
    Label lblShiftStart = new Label("Shift Start Time: ");
    Label lblShiftEnd = new Label("Shift End Time: ");
    TextField txtShiftDate = new TextField();
    TextField txtShiftStart = new TextField();
    TextField txtShiftEnd = new TextField();
    Button btnShiftAdd = new Button("Add Shift");
    Button btnShiftUpdate = new Button("Update Shift");
    Button btnShiftDelete = new Button("Delete Shift");
    ListView shiftView = new ListView();

    //Member view stuff
    Label lblMemberViewID = new Label("Member ID:");
    Label lblMemberViewFName = new Label("First Name: ");
    Label lblMemberViewLName = new Label("Last Name: ");
    Label lblMemberViewUsername = new Label("Username: ");
    Label lblMemberViewPassword = new Label("Password: ");
    Label lblMemberViewStreet = new Label("Address: ");
    Label lblMemberViewCity = new Label("City: ");
    Label lblMemberViewState = new Label("State: ");
    Label lblMemberViewZip = new Label("Zip: ");
    Label lblMemberViewCell = new Label("Cell#");
    TextField txtMemberViewID = new TextField();
    TextField txtMemberViewFName = new TextField();
    TextField txtMemberViewLName = new TextField();
    TextField txtMemberViewStreet = new TextField();
    TextField txtMemberViewCity = new TextField();
    TextField txtMemberViewState = new TextField();
    TextField txtMemberViewZip = new TextField();
    TextField txtMemberViewUsername = new TextField();
    TextField txtMemberViewPassword = new TextField();
    Button btnMemberViewAdd = new Button("Add Member");
    Button btnMemberViewUpdate = new Button("Update Member");
    Button btnMemberViewDelete = new Button("Delete Member");
    Button btnMemberViewReports = new Button("Member Reports");
    ListView MemberView = new ListView();
    
    //POS view stuff
    Label lblPosItem = new Label("Select Item:");
    ComboBox cboPosItem = new ComboBox();
    Label lblPosQuantity = new Label("Quantity:");
    TextField txtPosQuantity = new TextField();
    Label lblPosEmail = new Label("Member Email");
    TextField txtPosEmail = new TextField();
    ListView posView = new ListView();
    TextArea textaPosTotal = new TextArea();
    Label lblPosTotal = new Label("Total: ");
    
    
    // ************************* NEW ********************
    
    Employee loginEmp;

    // ************************* NEW *******************
    
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;

    @Override
    public void start(Stage primaryStage) throws SQLException
    {
        loadMemberData();
        

        /**
         * ***************************LOGIN*********************************
         */
//        cboLoginType.getItems().add("Member");
        cboLoginType.getItems().add("Employee");
        cboLoginType.getItems().add("Manager");
        //changint the aesthetics 
        mainPane.setStyle("-fx-background-color: lightgrey;");
//        mainPane.setStyle("-fx-background-image: url(http://allur.co/wp-content/uploads/2011/07/texture-preview-template2.jpg)");
        mainPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        lblLogIn.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lblLogIn.setTextFill(Color.DIMGREY);
        lblUser1.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lblUser1.setTextFill(Color.DIMGREY);
        lblPass1.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lblPass1.setTextFill(Color.DIMGREY);
        lblAccType.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblAccType.setTextFill(Color.DIMGREY);
//        lblCreate.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
//        lblCreate.setTextFill(Color.DIMGREY);
//        lblFName.setTextFill(Color.DIMGREY);
//        lblFName.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblLName.setTextFill(Color.DIMGREY);
//        lblLName.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblStreet.setTextFill(Color.DIMGREY);
//        lblStreet.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblCity.setTextFill(Color.DIMGREY);
//        lblCity.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblState.setTextFill(Color.DIMGREY);
//        lblState.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblZipCode.setTextFill(Color.DIMGREY);
//        lblZipCode.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblCell.setTextFill(Color.DIMGREY);
//        lblCell.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblEmail.setTextFill(Color.DIMGREY);
//        lblEmail.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblUser2.setTextFill(Color.DIMGREY);
//        lblUser2.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        lblPass2.setTextFill(Color.DIMGREY);
//        lblPass2.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
//        //adding stuff to the MainPane

        mainPane.setAlignment(Pos.CENTER);
        mainPane.setHgap(15);
        mainPane.setVgap(15);

        mainPane.add(lblLogIn, 0, 0);
        mainPane.add(lblUser1, 0, 1);
        mainPane.add(lblPass1, 0, 2);
        mainPane.add(txtUser1, 1, 1);
        mainPane.add(txtPass1, 1, 2);
        mainPane.add(btnLogIn, 1, 4);
//        mainPane.add(btnGuest, 1, 4);
        mainPane.add(lblAccType, 0, 3);
        mainPane.add(cboLoginType, 1, 3);
//        mainPane.add(lblCreate, 0, 6);
//        mainPane.add(btnNewMember, 0, 7);

//        btnNewMember.setOnAction(e ->
//        {
//            //         mainPane.add(lblCreate, 0, 5);
//            mainPane.add(lblFName, 0, 8);
//            mainPane.add(lblLName, 0, 9);
//            mainPane.add(lblStreet, 0, 10);
//            mainPane.add(lblCity, 0, 11);
//            mainPane.add(lblState, 0, 12);
//            mainPane.add(lblZipCode, 0, 13);
//            mainPane.add(lblCell, 0, 14);
//            mainPane.add(lblEmail, 0, 15);
//            mainPane.add(lblUser2, 0, 16);
//            mainPane.add(lblPass2, 0, 17);
//
//            mainPane.add(txtFName, 1, 8);
//            mainPane.add(txtLName, 1, 9);
//            mainPane.add(txtStreet, 1, 10);
//            mainPane.add(txtCity, 1, 11);
//            mainPane.add(txtState, 1, 12);
//            mainPane.add(txtZipCode, 1, 13);
//            mainPane.add(txtCell, 1, 14);
//            mainPane.add(txtEmail, 1, 15);
//            mainPane.add(txtUser2, 1, 16);
//            mainPane.add(txtPass2, 1, 17);
//
//            mainPane.add(btnCreate, 1, 18);
//            mainPane.add(blankText, 0, 18);
//           // mainPane.add(scroll, 20, 0);

//        txtLength.setOpacity(0);
//        txtLength.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 30));
//        txtLength.setText("-----------------------------");
//        });

        Scene scene = new Scene(mainPane, 350, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Form");
//        scroll.setLayoutX(scene.getWidth() - scroll.getWidth());
//        scroll.setMin(0);
//        scroll.setOrientation(Orientation.VERTICAL);
//        scroll.setPrefHeight(500);
//        scroll.setMax(800);
        primaryStage.show();

//        
        btnCreate.setOnAction(e ->
        {

            if (txtFName.getText().isEmpty() || txtLName.getText().isEmpty()
                    || txtStreet.getText().isEmpty() || txtCity.getText().isEmpty()
                    || txtState.getText().isEmpty() || txtZipCode.getText().isEmpty()
                    || txtCell.getText().isEmpty() || txtEmail.getText().isEmpty()
                    || txtUser2.getText().isEmpty() || txtPass2.getText().isEmpty())
            {
                blankText.setFill(Color.RED);
                blankText.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                blankText.setText("Please fill out all attributes");

            } //other error checking for creating a member
            else
            {
                createLoginMember();
                loadMemberData();
            }


        });

        /**
         * ************************MEMBERS*********************************
         */
        // adding tabs to Members tab pane
        memberTabs.getTabs().add(memberInvTab);
        memberTabs.getTabs().add(memberMemTab);
        memberTabs.getTabs().add(memberInfoTab);

        // making all Members tabs uncloseable to user
        memberInvTab.setClosable(false);
        memberMemTab.setClosable(false);
        memberInfoTab.setClosable(false);

        // adding controls to Members inventory tab
        memberInvTab.setContent(memberInvPane);
        memberInvPane.setAlignment(Pos.CENTER);
        memberInvPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        memberInvPane.setHgap(5);
        memberInvPane.setVgap(5);
        memberInvPane.add(memberInvTbl, 0, 0);
        memberInvPane.add(btnBuyProd, 0, 1);

        // adding controls to Members membership tab
        memberMemTab.setContent(memberMemPane);
        memberMemPane.setAlignment(Pos.CENTER);
        memberMemPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        memberMemPane.setHgap(5);
        memberMemPane.setVgap(5);

        // adding controls to Members info tab
        memberInfoTab.setContent(memberInfoPane);
        memberInfoPane.setAlignment(Pos.CENTER);
        memberInfoPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        memberInfoPane.setHgap(5);
        memberInfoPane.setVgap(5);
        memberInfoPane.add(lblMemberUser, 0, 0);
        memberInfoPane.add(lblMemberPass, 0, 1);
        memberInfoPane.add(lblMemberEmail, 0, 2);
        memberInfoPane.add(lblMemberPhone, 0, 3);
        memberInfoPane.add(lblMemberStreet, 0, 4);
        memberInfoPane.add(lblMemberCity, 0, 5);
        memberInfoPane.add(lblMemberState, 0, 6);
        memberInfoPane.add(lblMemberZip, 0, 7);
        memberInfoPane.add(txtMemberUser, 1, 0);
        memberInfoPane.add(txtMemberPass, 1, 1);
        memberInfoPane.add(txtMemberEmail, 1, 2);
        memberInfoPane.add(txtMemberPhone, 1, 3);
        memberInfoPane.add(txtMemberStreet, 1, 4);
        memberInfoPane.add(txtMemberCity, 1, 5);
        memberInfoPane.add(txtMemberState, 1, 6);
        memberInfoPane.add(txtMemberZip, 1, 7);
        memberInfoPane.add(btnMemberUpdate, 1, 8);

        // adding columns to Members inventory table
        TableColumn tblcBookID = new TableColumn("ID");
        TableColumn tblcBook = new TableColumn("Book");
        TableColumn tblcGenre = new TableColumn("Genre");
        TableColumn tblcBookPrice = new TableColumn("Price");
        TableColumn tblcBookStore = new TableColumn("Store");
        memberInvTbl.getColumns().addAll(tblcBookID, tblcBook, tblcGenre,
                tblcBookPrice, tblcBookStore);

        // populating Members inventory table cells
        
        
        /******************************Employees******************************/
        // adding tabs to employee tab pane
        empTabs.getTabs().addAll(empChkTab, empShiftTab);

        // setting tabs to uncloseable
        empChkTab.setClosable(false);
        empShiftTab.setClosable(false);

        // adding controls to employee check in/out tab
        empChkTab.setContent(empChkPane);
        empChkPane.setAlignment(Pos.CENTER);
        empChkPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        empChkPane.setVgap(5);
        empChkPane.setHgap(5);
        empChkPane.add(lblTime, 0, 0);
        empChkPane.add(txtTime, 1, 0);
        empChkPane.add(btnChkIn, 1, 1);
        empChkPane.add(btnChkOut, 1, 2);

        // adding controls to employee shift tab
        empShiftTab.setContent(empShiftPane);
        empShiftPane.setAlignment(Pos.CENTER);
        empShiftPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        empShiftPane.setVgap(5);
        empShiftPane.setHgap(5);
        empShiftPane.add(empShiftView, 0, 0);

        // setting the time text box equal to current time
        
        // ************************* NEW *********************
        
        Date todaysDate = Date.valueOf(LocalDate.now());
        Time newTime = Time.valueOf(LocalTime.now());
        int hour = newTime.toLocalTime().getHour();
        int min = newTime.toLocalTime().getMinute();
        int sec = newTime.toLocalTime().getSecond();
        txtTime.setText(newTime.toString());
        
        // ************************* END *********************
       
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
        tab6.setContent(MembersPaneOverall);
        tab6.setClosable(false);

        tabPane.getTabs().addAll(tab2, tab6, tab1, tab3, tab4, tab5);
        overallPane.setAlignment(Pos.TOP_CENTER);
        overallPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        overallPane.add(tabPane, 0, 0);
        /***************************POS**************************************/
        posPane.setAlignment(Pos.CENTER);
        posPane.setHgap(5);
        posPane.setVgap(5);
        posPane.setPadding(new Insets( 25, 25, 25, 25));
        posViewPane.setHgap(5);
        posViewPane.setVgap(5);
        posViewPane.setPadding(new Insets( 25, 25, 25, 25));
        posPaneOverall.setHgap(5);
        posPaneOverall.setVgap(5);
        posPaneOverall.setPadding(new Insets( 25, 25, 25, 25));
        
        posPane.add(lblPosItem, 0, 0);
        posPane.add(cboPosItem, 0, 1);
        posPane.add(lblPosQuantity, 0, 2);
        posPane.add(txtPosQuantity, 1, 2);
        posPane.add(lblPosEmail, 0, 3);
        posPane.add(txtPosEmail, 1, 3);
        posViewPane.setAlignment(Pos.CENTER);
        posPaneOverall.setAlignment(Pos.TOP_CENTER);
        posViewPane.add(posView, 0, 0);
        posViewPane.add(textaPosTotal, 0, 2);
        posViewPane.add(lblPosTotal, 0, 1);
        posPaneOverall.add(posPane, 0,0);
        posPaneOverall.add(posViewPane, 1, 0);
        
        
//        lblPosItem.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
//        lblPosItem.setTextFill(Color.DIMGREY);
//        lblPosQuantity.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
//        lblPosQuantity.setTextFill(Color.DIMGREY);
//        lblPosEmail.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
//        lblPosEmail.setTextFill(Color.DIMGREY);
//        lblPosTotal.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
//        lblPosTotal.setTextFill(Color.DIMGREY);
        
        
        
        
        //Expense Pane adds
        expensePane.setAlignment(Pos.CENTER);
        expensePane.add(lblExpenseID, 0, 0);
        expensePane.add(txtExpenseID, 1, 0);//Eventually this will be a field that pulls the current ID number from the class
        expensePane.add(lblExpenseType, 0, 1);
        expensePane.add(cbxExpenseType, 1, 1);
        expensePane.add(lblExpenseDate, 0, 2);
        expensePane.add(txtExpenseDate, 1, 2);
        expensePane.add(lblExpensePrice, 0, 3);
        expensePane.add(txtExpensePrice, 1, 3);
        expensePane.add(lblExpenseComments, 0, 4);
        expensePane.add(txtExpenseComments, 1, 4);
        expensePane.add(btnExpenseSubmit, 1, 5);
        expensePane.add(btnExpenseView, 0, 5);
        expensePane.add(btnExpenseUpdate, 2, 5);
        expensePane.add(btnExpenseDelete, 3, 5);
        expenseViewPane.setAlignment(Pos.CENTER);
        expensePaneOverall.setAlignment(Pos.TOP_CENTER);
        expenseViewPane.add(expenseView, 0, 0);
        expensePaneOverall.add(expensePane, 0, 0);
        expensePaneOverall.add(expenseViewPane, 1, 0);

        cbxExpenseType.getItems().addAll("Maintenance", "Purchase Order", "Utilities", "Payroll");

        // Inventory pane adds
        inventoryPane.setAlignment(Pos.CENTER);
        inventoryPane.add(lblInventoryID, 0, 0);
        inventoryPane.add(txtInventoryID, 1, 0);
        inventoryPane.add(lblInventoryName, 0, 1);
        inventoryPane.add(txtInventoryName, 1, 1);
        inventoryPane.add(lblInventoryDescription, 0, 2);
        inventoryPane.add(txtInventoryDescription, 1, 2);
        inventoryPane.add(lblInventoryPrice, 0, 3);
        inventoryPane.add(txtInventoryPrice, 1, 3);
        rbInventoryBook.setToggleGroup(inventoryToggle);
        rbInventoryCoffee.setToggleGroup(inventoryToggle);
        inventoryPane.add(rbInventoryBook, 0, 4);
        inventoryPane.add(rbInventoryCoffee, 1, 4);
        inventoryPane.add(btnInventoryAdd, 0, 5);
        inventoryPane.add(btnInventoryUpdate, 1, 5);
        inventoryPane.add(btnInventoryDelete, 2, 5);
        inventoryViewPane.setAlignment(Pos.CENTER);
        inventoryPaneOverall.setAlignment(Pos.CENTER);
        inventoryViewPane.add(inventoryView, 0, 0);
        inventoryPaneOverall.add(inventoryPane, 0, 0);
        inventoryPaneOverall.add(inventoryViewPane, 1, 0);

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

        // Employee View
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

        // Shift View
        shiftPane.setAlignment(Pos.CENTER);
        shiftPane.add(lblShiftDate, 0, 0);
        shiftPane.add(txtShiftDate, 1, 0);
        shiftPane.add(lblShiftStart, 0, 1);
        shiftPane.add(txtShiftStart, 1, 1);
        shiftPane.add(lblShiftEnd, 0, 2);
        shiftPane.add(txtShiftEnd, 1, 2);
        shiftPane.add(btnShiftAdd, 0, 3);
        shiftPane.add(btnShiftUpdate, 1, 3);
        shiftPane.add(btnShiftDelete, 2, 3);
        shiftPaneOverall.setAlignment(Pos.CENTER);
        shiftViewPane.setAlignment(Pos.CENTER);
        shiftViewPane.add(shiftView, 0, 0);
        shiftPaneOverall.add(shiftPane, 0, 0);
        shiftPaneOverall.add(shiftViewPane, 1, 0);

        //Member View 
        MembersPane.setAlignment(Pos.CENTER);
        MembersPane.add(lblMemberViewID, 0, 0);
        MembersPane.add(txtMemberViewID, 1, 0);
        MembersPane.add(lblMemberViewFName, 0, 1);
        MembersPane.add(txtMemberViewFName, 1, 1);
        MembersPane.add(lblMemberViewLName, 0, 2);
        MembersPane.add(txtMemberViewLName, 1, 2);
        MembersPane.add(lblMemberViewUsername, 0, 3);
        MembersPane.add(txtMemberViewUsername, 1, 3);
        MembersPane.add(lblMemberViewPassword, 0, 4);
        MembersPane.add(txtMemberViewPassword, 1, 4);
        MembersPane.add(lblMemberViewStreet, 0, 5);
        MembersPane.add(txtMemberViewStreet, 1, 5);
        MembersPane.add(lblMemberViewCity, 0, 6);
        MembersPane.add(txtMemberViewCity, 1, 6);
        MembersPane.add(lblMemberViewState, 0, 7);
        MembersPane.add(txtMemberViewState, 1, 7);
        MembersPane.add(lblMemberViewZip, 0, 8);
        MembersPane.add(txtMemberViewZip, 1, 8);
        MembersPane.add(btnMemberViewAdd, 0, 9);
        MembersPane.add(btnMemberViewUpdate, 1, 9);
        MembersPane.add(btnMemberViewDelete, 2, 9);
        MembersPaneOverall.setAlignment(Pos.CENTER);
        MembersViewPane.setAlignment(Pos.CENTER);
        MembersViewPane.add(MemberView, 0, 0);
        MembersPaneOverall.add(MembersPane, 0, 0);
        MembersPaneOverall.add(MembersViewPane, 1, 0);

        Scene overallScene = new Scene(overallPane, 600, 550);
/****************************************************************************/
        // Login button action
        btnLogIn.setOnAction(e ->
        {
            String user = txtUser1.getText();
            String pass = txtPass1.getText();

            // if Members is selected
            if (cboLoginType.getSelectionModel().getSelectedItem() == "Member")
            {
                for (Member m : memberArray)
                {
                    if (user.equals(m.getUserName()) & pass.equals(m.getPassword()))
                    {
                        // open Members GUI
                        primaryStage.setScene(memberScene);
                        primaryStage.setTitle(m.getFName() + " " + m.getLName());
                        primaryStage.show();
                    } else
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
                for (Employee p : empArray)
                {
                    if (user.equals(p.getUserName()) & pass.equals(p.getPassword()))
                    {
//                        // open employee GUI
                        loginEmp = p;
                        primaryStage.setTitle(loginEmp.getFName() + " " + loginEmp.getLName());
                        primaryStage.setScene(empScene);
                        // load employee shifts
                        
                        loadShifts(loginEmp);
                        
                        primaryStage.setTitle(p.getFName() + " " + p.getLName());
                        primaryStage.show();
                    } else
                    {
                        Alert loginAlert = new Alert(Alert.AlertType.ERROR);
                        loginAlert.setContentText("Invalid login credentials");
                        loginAlert.show();
                    }
                }
            }

            // if Manager is selected
            if (cboLoginType.getSelectionModel().getSelectedItem() == "Manager")
            {
                primaryStage.setScene(overallScene);
                primaryStage.setTitle("Manager View");
                primaryStage.show();
            }

        });

        //manager view inventory add button
        btnInventoryAdd.setOnAction(e ->
        {
            if (rbInventoryBook.isSelected())
            {
                bookStage.show();
            }

        });

        //manager view employee add button
        
//        String sqlEmpSizeQuery = "";
//        sqlEmpSizeQuery = "SELECT * FROM BOOKITDB.EMPLOYEES";
//        sendDBCommand(sqlEmpSizeQuery);
//
//        while (dbResults.next())
//        {
//           empArray.add(new Employee(dbResults.getString(2), dbResults.getString(3),
//                     dbResults.getString(4), dbResults.getString(5),
//                     dbResults.getString(6), Integer.valueOf(dbResults.getString(7)),
//                    dbResults.getString(8), dbResults.getString(9), dbResults.getString(10), Double.valueOf(dbResults.getString(11)), dbResults.getString(13)));
//          
//            empList.add(empArray);
//            employeeView.setItems(empList);
//        }

        // add employee button action
        btnEmployeeAdd.setOnAction(e ->
        {

            int empIDStart = empArray.size();
            empArray.add(new Employee(txtEmployeeFirst.getText(), txtEmployeeLast.getText(), txtEmployeeAddress.getText(),
                    txtEmployeeCity.getText(), txtEmployeeState.getText(), Integer.valueOf(txtEmployeeZip.getText()), txtEmployeePhone.getText(),
                    txtEmployeeUsername.getText(), txtEmployeePassword.getText(), Double.valueOf(txtEmployeePay.getText()),
                    cbxEmployeeType.getSelectionModel().getSelectedItem().toString()));

            Employee tempRef = empArray.get(empArray.size() - 1);

            // empList.add(tempRef);
            // employeeView.setItems(empList);

            String sqlQuery = "";

            sqlQuery += "INSERT INTO BOOKITDB.EMPLOYEES (EMP_ID,FNAME,LNAME,STREET,CITY,STATE,ZIPCODE,CELL,USERNAME,PASSWORD,WAGE,EMP_TYPE,MANAGER_ID) VALUES(";
            sqlQuery += (++empIDStart) + ",'";
            sqlQuery += txtEmployeeFirst.getText() + "','";
            sqlQuery += txtEmployeeLast.getText() + "','";
            sqlQuery += txtEmployeeAddress.getText() + "','";
            sqlQuery += txtEmployeeCity.getText() + "','";
            sqlQuery += txtEmployeeState.getText() + "',";
            sqlQuery += Integer.valueOf(txtEmployeeZip.getText()) + ",'";
            sqlQuery += txtEmployeePhone.getText() + "','";
            sqlQuery += txtEmployeeUsername.getText() + "','";
            sqlQuery += txtEmployeePassword.getText() + "',";
            sqlQuery += Double.valueOf(txtEmployeePay.getText()) + ",'";
            sqlQuery += cbxEmployeeType.getSelectionModel().getSelectedItem() + ",'";
            sqlQuery += cbxManagerID.getSelectionModel().getSelectedItem() + "')";
            sendDBCommand(sqlQuery);

        });
        
        
        // ************************* NEW **********************
        
        // employee clock in button action
        btnChkIn.setOnAction(e -> {
            // create new employee shift instance &
            // add to employee arraylist
            Shifts newShift = new Shifts(todaysDate, newTime);
            shiftArray.add(newShift);
        });
        
        // employee clock out button action
        btnChkOut.setOnAction(e -> {
            // take last shift in array and set clock out time 
            Time clockOutTime = Time.valueOf(LocalTime.now());
            Shifts shift = shiftArray.get(shiftArray.size() - 1);
            shift.setClockOut(clockOutTime);
            
            // getting clock out time variable
            int newHour = clockOutTime.toLocalTime().getHour();
            int newMin = clockOutTime.toLocalTime().getMinute();
            int newSec = clockOutTime.toLocalTime().getSecond();
            
            // differences between clock in time & clock out time
            int hourDiff = newHour - hour;
            double minDiff = newMin - min;
            double secDiff = newSec - sec;
            
            // calculating shift hours & setting them
            double hours = hourDiff;
            hours += (minDiff / 60);
            hours += ((secDiff / 60) / 60);
            shift.setHours(hours);
            
            // calculating if any overtime hours
            if (hours > 8)
            {
                double otHours = hours % 8;
                shift.setOTHours(otHours);
            }
            
            // create a payroll instance object
            Payroll newPay = new Payroll(loginEmp.getEmpID(), 1, 
                    shiftArray.get(shiftArray.size() - 1));
            payrollArray.add(newPay);
            
        });
        
        // ************************ END ****************************
    
    
    
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
    public void createLoginMember()
    {
        //from the login

        memberArray.add(new Member(txtFName.getText(),
                txtLName.getText(), txtStreet.getText(),txtCity.getText(),
                txtState.getText(), Integer.parseInt(txtZipCode.getText()),
                txtCell.getText(), txtEmail.getText(), txtUser2.getText(), txtPass2.getText()));
        System.out.println(Member.memCount);
        String sqlQuery = "";
        sqlQuery += "INSERT INTO BOOKITDB.MEMBERS (MEMBER_ID, FNAME, LNAME,"
                + "STREET, CITY, STATE, ZIP, CELL, EMAIL, USERNAME, PASSWORD)"
                + " VALUES (";
        sqlQuery += "'" + Member.memCount + "',";
        sqlQuery += "'" + txtFName.getText() + "',";
        sqlQuery += "'" + txtLName.getText() + "',";
        sqlQuery += "'" + txtStreet.getText() + "',";
        sqlQuery += "'" + txtCity.getText() + "',";
        sqlQuery += "'" + txtState.getText() + "',";
        sqlQuery += "'" + Integer.parseInt(txtZipCode.getText()) + "',";
        sqlQuery += "'" + txtCell.getText() + "',";
        sqlQuery += "'" + txtEmail.getText() + "',";
        sqlQuery += "'" + txtUser2.getText() + "',";
        sqlQuery += "'" + txtPass2.getText() + "')";
        sendDBCommand(sqlQuery);

    }
    
    public void loadMemberData()
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
            //while there is a next customer
            while (dbResults.next())
            {

                int memID = Integer.parseInt(dbResults.getString(1));
                String fName = dbResults.getString(2);
                String lName = dbResults.getString(3);
                String street = dbResults.getString(4);
                String city = dbResults.getString(5);
                String state = dbResults.getString(6);          
                int zipCode = Integer.parseInt(dbResults.getString(7));
                String cell = dbResults.getString(8);
                String email = dbResults.getString(9);
                String userName = dbResults.getString(10);
                String password = dbResults.getString(11);
                
                memberArray.add(new Member(memID, fName, lName, street,
                        city, state, zipCode, cell, email, userName, password));

                //System.out.println(customersArray.get(customersArray.size() - 1).toString());
                 //set string to read from the DB
                
            }

        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void loadShifts(Employee emp)
    {
        shiftArray.clear();
        
        // searching through payroll for employee pay stubs
        for (Payroll p: payrollArray)
        {
            if (p.getEmpID_FK() == emp.getEmpID())
            {
                shiftArray.add(p.getInstanceID_FK());
                shiftView.getItems().add(p);
            }
        }
    }

    public void sendDBCommand(String sqlQuery)
    {
        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "BOOKITDB"; // Change to YOUR Oracle username
        String userPASS = "OVALTINE"; // Change to YOUR Oracle password
        // OracleDataSource ds;

        // Clear Box Testing - Print each query to check SQL syntax
        //  sent to this method.
        // You can comment this line out when your program is finished
        System.out.println(sqlQuery);

        // Lets try to connect
        try
        {
            // instantiate a new data source object
       //      ds = new OracleDataSource();
            // Where is the database located? Web? Local?
        //    ds.setURL(URL);
            // Send the user/pass and get an open connection.
       //     dbConn = ds.getConnection(userID, userPASS);
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
        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
    }

}
