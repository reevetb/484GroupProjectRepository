/*
 DMO Group

 */
package BookIT.V2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

public class LoginMainForm extends Application
{

    /**
     * ********************ArrayLists*****************************************
     */
    ArrayList<Member> memberArray = new ArrayList<>();
    ArrayList<Employee> empArray = new ArrayList<>();
    ArrayList<Expenses> expenseArray = new ArrayList<>();

    /**
     * ********************Observable Lists**********************************
     */
    ObservableList<Employee> empList = FXCollections.observableArrayList(empArray);

    /**
     * ********************Panes*********************************************
     */
    GridPane loginPane = new GridPane();
    GridPane overallPane = new GridPane();
    GridPane companyPane = new GridPane();

    /**
     * *********************Login Controls***********************************
     */
    Label lblLogIn = new Label("-------Log In---------");
    Label lblUser1 = new Label("Username:");
    Label lblPass1 = new Label("Password:");
    Label lblAccType = new Label("Select account type:");
    Label lblCompany = new Label("Developed by: D.M.O. LLC");
    TextField txtUser1 = new TextField();
    TextField txtPass1 = new TextField();
    ComboBox<String> cboLoginType = new ComboBox();
    Button btnLogIn = new Button("Login");

    /**
     * ********************Logout Controls **********************************
     */
    Button btnLogOut = new Button("Logout");

    /**
     * ********************CONNECTING TO DATABASE****************************
     */
    //connecting to the database
    Connection dbConnection;
    Statement commStmt;
    ResultSet dbResults;

    @Override
    public void start(Stage primaryStage)
    {
        //PULLING THE DATA FROM THE DATABASE
        loadEmployeeData();

        /**
         * *********************APPEARANCE*********************************
         */
        login();

        //setting the scene and stage to display everything
        Scene primaryScene = new Scene(overallPane, 700, 400);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("BookIt Information System Login");
        primaryStage.show();

        /**
         * ************************Logic*************************************
         */
        btnLogIn.setOnAction(e ->
        {
            if (txtUser1.getText().isEmpty() && txtPass1.getText().isEmpty()
                    && cboLoginType.getSelectionModel().isEmpty())
            {
                Alert loginAlert = new Alert(Alert.AlertType.ERROR);
                loginAlert.setContentText("Nothing Entered");
                loginAlert.show();
            } else if (txtUser1.getText().isEmpty())
            {
                Alert loginAlert = new Alert(Alert.AlertType.WARNING);
                loginAlert.setContentText("Please enter a Username");
                loginAlert.show();
            } else if (txtPass1.getText().isEmpty())
            {
                Alert loginAlert = new Alert(Alert.AlertType.WARNING);
                loginAlert.setContentText("Please enter a Password");
                loginAlert.show();
            } else if (cboLoginType.getSelectionModel().isEmpty())
            {
                Alert loginAlert = new Alert(Alert.AlertType.WARNING);
                loginAlert.setContentText("Please select select a Login Type");
                loginAlert.show();
            }
            else
            {
                String usernameInput = txtUser1.getText();
                String passwordInput = txtPass1.getText();
                String empTypeInput = cboLoginType.getSelectionModel().getSelectedItem();
                for(Employee emp: empArray)
                {
                    //check username

                   if(usernameInput.equals(emp.getUserName()))
                   {
                       //check password

                       if(passwordInput.equals(emp.getPassword()))
                       {
                          if(cboLoginType.getSelectionModel().getSelectedItem() == "Employee")
                          {
                              if(!emp.getType().equals(cboLoginType.getSelectionModel().getSelectedItem()))
                              {
                                  System.out.println("open employee window");
                                  //works
                                  EmployeeView newWindow = new EmployeeView();
                                  txtUser1.clear();
                                  txtPass1.clear();
                                  cboLoginType.getSelectionModel().clearSelection();
            
                                  break;
                              }
                              else
                              {
                                  Alert loginAlert = new Alert(Alert.AlertType.WARNING);
                                  loginAlert.setContentText("Choose valid Employee Type");
                                  loginAlert.show();
                            
                                  break;
                              }
                          }
                          if(cboLoginType.getSelectionModel().getSelectedItem() == "Manager")
                          {
                              if(emp.getType().equalsIgnoreCase(cboLoginType.getSelectionModel().getSelectedItem()))
                              {
                                  System.out.println("open MANAGER window");
//                                  ManagerView newWindow 
                                  break;
                              }
                              else
                              {
                                  Alert loginAlert = new Alert(Alert.AlertType.WARNING);
                                  loginAlert.setContentText("Choose valid Employee Type");
                                  loginAlert.show();
                            
                                  break;
                              }
                          }

                       }
                       
                           
                   }
                   
                       
                }
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    public void login()
    {
        cboLoginType.getItems().add("Employee");
        cboLoginType.getItems().add("Manager");

        overallPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");
        overallPane.setAlignment(Pos.CENTER);
        overallPane.setHgap(25);
        overallPane.setVgap(25);

        lblLogIn.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lblLogIn.setTextFill(Color.DIMGREY);
        lblUser1.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lblUser1.setTextFill(Color.DIMGREY);
        lblPass1.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lblPass1.setTextFill(Color.DIMGREY);
        lblAccType.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblAccType.setTextFill(Color.DIMGREY);

        loginPane.setPadding(new Insets(25, 25, 25, 25));
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setHgap(25);
        loginPane.setVgap(25);
        loginPane.add(lblUser1, 0, 1);
        loginPane.add(lblPass1, 0, 2);
        loginPane.add(lblAccType, 0, 3);
        loginPane.add(txtUser1, 1, 1);
        loginPane.add(txtPass1, 1, 2);
        loginPane.add(cboLoginType, 1, 3);
        loginPane.add(btnLogIn, 1, 4);

        companyPane.setPadding(new Insets(25, 25, 25, 25));
        companyPane.setAlignment(Pos.CENTER);
        companyPane.setHgap(25);
        companyPane.setVgap(25);
        companyPane.add(lblCompany, 0, 0);

        overallPane.add(loginPane, 0, 0);
        overallPane.add(companyPane, 0, 1);

    }
    

    //needs to be employees
    public void loadEmployeeData()
    {
        String sqlQuery = "";
        String listString = "";
        sqlQuery = "Select * from BOOKITDB.Employees";
        //calling the sendDBCommand method
        sendDBCommand(sqlQuery);
        Employee.empCount = 0;
        memberArray.clear();
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
