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
import java.time.LocalTime;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Trenton
 */
public class EmployeeView extends LoginMainForm{

    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;
    
    //listview and array lists
    ListView<Inventory> cafeView = new ListView<>();
    ListView<Inventory> bookView = new ListView<>();
    ListView<Inventory> totalsView = new ListView<>();
    ArrayList<Inventory> mainArray = new ArrayList<>();
    ListView empShiftView = new ListView();
    ListView employeeView = new ListView();
    ArrayList<Employee> employeeArray = new ArrayList<>();
    
    
    //overall stuff
    TabPane empPane = new TabPane();
    Tab tab1 = new Tab("P.O.S.");
    Tab tab2 = new Tab("TimeClock");
    Tab tab3 = new Tab("Shifts");
    
    /********************POS STUFF*******************************************/
     
    TextArea taPay = new TextArea();

    Label lblSubtotal = new Label ("Subtotal: ");
    Label lblTax = new Label ("Tax: ");
    Label lblTotal = new Label ("Total: ");
    Label lblQty = new Label ("QTY: ");
   
    TabPane posPane = new TabPane();
    Tab tab4 = new Tab ("Books");
    Tab tab5 = new Tab ("Cafe");
  
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
    Button btnFinalPay = new Button ("Pay -->");
    TextField txtSubtotal = new TextField();
    TextField txtTax = new TextField();
    TextField txtTotal = new TextField();
    TextField txtPayment= new TextField();
    VBox payButtons = new VBox();
    
   /**************************Employee Stuff*********************************/
    GridPane tcOverallPane = new GridPane();
   
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
    
    
    //controls for employee check in/out tab
    Label lblTime = new Label("Time:");
    TextField txtTime = new TextField();
    Button btnChkIn = new Button("Check In");
    Button btnChkOut = new Button("Check Out");

    Stage primaryStage = new Stage();
       

    //Employee view constructor
    public EmployeeView()
    {
        //the overall view setup
        tab1.setContent(posOverallPane);
        tab1.setClosable(false);
        tab2.setContent(tcOverallPane);
        tab2.setClosable(false);
        
        empPane.getTabs().addAll(tab1, tab2, tab3);
        empPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        

        /*************************Setting POS PANE***************************/
        posOverallPane.setAlignment(Pos.CENTER);
        
        tab4.setContent(bookPane);
        tab4.setClosable(false);
        tab5.setContent(cafePane);
        tab5.setClosable(false);
        
        posPane.getTabs().addAll(tab4,tab5);
        
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
        totalPane.add(totalPaneRight,1,0);
        totalPane.add(totalPaneLeft,0,0);
        
        totalsView.setMaxSize(300, 450);       
        
        posOverallPane.setHgap(10);
        posOverallPane.setVgap(10);
        
        posOverallPane.add(totalsView,0,0);
        posOverallPane.add(posPane,1,0);
        posOverallPane.add(totalPane,0,1);
        posOverallPane.add(cashPane,1,1);
        
        /**************************Setting TimeClock**************************/
     
      // adding controls to employee check in/out tab
        tcOverallPane.setAlignment(Pos.CENTER);
//        tcOverallPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        tcOverallPane.setVgap(5);
        tcOverallPane.setHgap(5);
        tcOverallPane.add(lblTime, 0, 0);
        tcOverallPane.add(txtTime, 1, 0);
        tcOverallPane.add(btnChkIn, 1, 1);
        tcOverallPane.add(btnChkOut, 1, 2);
         // setting the time text box equal to current time
        String hour = String.valueOf(LocalTime.now().getHour());
        String min = String.valueOf(LocalTime.now().getMinute());
        txtTime.setText(hour + ":" + min);
        txtTime.setEditable(false);
        
        
        /**************************Setting ShiftPane**************************/
        
        
        /*********************************************************************/
        
        //needs to be converted to the overall employee view panes
        Scene empScene = new Scene(empPane,700,700);
        primaryStage.setScene(empScene);
        primaryStage.setTitle("Book IT Employee");
        primaryStage.show(); 
        
    }
    public void fillInventoryBook()
    {
        String sqlQuery ="";
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY";
        
        ArrayList<Book> bookArray = new ArrayList<>();
        
        sendDBCommand(sqlQuery);
          try {
              while(dbResults.next())
              {
                  
              } } catch (SQLException ex) {
              Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
          }
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