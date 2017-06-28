/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookIT;

import BookIT.CustGUI;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
//import oracle.jdbc.pool.*;
/**
 *
 * @author Marvin
 */
public class LoginBookIT extends Application {
    Label lblLogIn = new Label("-------Log In---------");
    Label lblUser1 = new Label("Username:");
    Label lblPass1 = new Label("Password:");
    Label lblAccType = new Label("Select account type:");
    Label lblCreate = new Label("------------------------");
    Label lblFName = new Label("First Name:");
    Label lblLName = new Label("Last Name:");
    Label lblStreet = new Label("Street:");
    Label lblCity = new Label("City:");
    Label lblState = new Label("State:");
    Label lblZipCode = new Label("Zip Code:");
    Label lblCell = new Label("Cell#:");
    Label lblEmail = new Label("Email:");
    Label lblUser2 = new Label("Username:");
    Label lblPass2 = new Label("Password:");
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
    Button btnNewMember = new Button("Don't have an Account?");
    Button btnCreate = new Button("Become A Member!");

    @Override
    public void start(Stage primaryStage) {
        
       
        cboLoginType.getItems().add("Member");
        cboLoginType.getItems().add("Employee");
        cboLoginType.getItems().add("Manager");
        GridPane mainPane = new GridPane();
        final Text blankText = new Text();
//        final Text txtLength = new Text();

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
        lblCreate.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lblCreate.setTextFill(Color.DIMGREY);
        lblFName.setTextFill(Color.DIMGREY);
        lblFName.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblLName.setTextFill(Color.DIMGREY);
        lblLName.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblStreet.setTextFill(Color.DIMGREY);
        lblStreet.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblCity.setTextFill(Color.DIMGREY);
        lblCity.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblState.setTextFill(Color.DIMGREY);
        lblState.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblZipCode.setTextFill(Color.DIMGREY);
        lblZipCode.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblCell.setTextFill(Color.DIMGREY);
        lblCell.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblEmail.setTextFill(Color.DIMGREY);
        lblEmail.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblUser2.setTextFill(Color.DIMGREY);
        lblUser2.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblPass2.setTextFill(Color.DIMGREY);
        lblPass2.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        //adding stuff to the MainPane
       
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setHgap(15);
        mainPane.setVgap(15);
        
        mainPane.add(lblLogIn, 0, 0);
        mainPane.add(lblUser1, 0, 1);
        mainPane.add(lblPass1, 0, 2);
        mainPane.add(txtUser1, 1, 1);
        mainPane.add(txtPass1, 1, 2);
        mainPane.add(lblAccType, 0, 3);
        mainPane.add(cboLoginType, 0, 4);
        mainPane.add(btnLogIn, 1, 3);
        mainPane.add(lblCreate, 0, 6);
        mainPane.add(btnNewMember, 0, 7); 
        
        btnNewMember.setOnAction(e ->{
//         mainPane.add(lblCreate, 0, 5);
        mainPane.add(lblFName, 0, 8);
        mainPane.add(lblLName, 0, 9);
        mainPane.add(lblStreet, 0, 10);
        mainPane.add(lblCity, 0, 11);
        mainPane.add(lblState, 0, 12);
        mainPane.add(lblZipCode, 0, 13);
        mainPane.add(lblCell, 0, 14);
        mainPane.add(lblEmail, 0, 15);
        mainPane.add(lblUser2, 0, 16);
        mainPane.add(lblPass2, 0, 17);
    
        mainPane.add(txtFName, 1, 8);
        mainPane.add(txtLName, 1, 9);
        mainPane.add(txtStreet, 1, 10);
        mainPane.add(txtCity, 1, 11);
        mainPane.add(txtState, 1, 12);
        mainPane.add(txtZipCode, 1, 13);
        mainPane.add(txtCell, 1, 14);
        mainPane.add(txtEmail, 1, 15);
        mainPane.add(txtUser2, 1, 16);
        mainPane.add(txtPass2, 1, 17);

        mainPane.add(btnCreate, 1, 18);
        mainPane.add(blankText, 0, 18);

//        txtLength.setOpacity(0);
//        txtLength.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 30));
//        txtLength.setText("-----------------------------");
        });
        
        
        
        
        Scene scene = new Scene(mainPane, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Form");
        primaryStage.show();
        
       
        
//        
        btnCreate.setOnAction(e ->{
            
            if(txtFName.getText().isEmpty() || txtLName.getText().isEmpty() ||
               txtStreet.getText().isEmpty() || txtCity.getText().isEmpty() ||
               txtState.getText().isEmpty() || txtZipCode.getText().isEmpty() ||
               txtCell.getText().isEmpty() || txtEmail.getText().isEmpty() ||
               txtUser2.getText().isEmpty() || txtPass2.getText().isEmpty())
            {
                blankText.setFill(Color.RED);
                blankText.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                blankText.setText("Please fill out all attributes");
                
            }
            //other error checking for creating a member
            
            else
            {
     
                int newCustID = ++Customers.counter;

                customersArray.add(new Customers(newCustID, txtCustFName.getText(),
                txtCustLName.getText(), txtCustCell.getText(), txtCustStreet.getText(),
                txtCustCity.getText(), txtCustState.getText(), Integer.parseInt(txtCustZip.getText())));
                System.out.println(newCustID);
               String sqlQuery = "";
                    sqlQuery += "INSERT INTO SUMMER484.CUSTOMERS (CUST_ID, FNAME, LNAME, CELL, STREET, CITY, STATE, ZIP) VALUES (";
                    sqlQuery += "'" + newCustID + "',";
                    sqlQuery += "'" + txtCustFName.getText() + "',";
                    sqlQuery += "'" + txtCustLName.getText() + "',";
                    sqlQuery += "'" + txtCustCell.getText() + "',";
                    sqlQuery += "'" + txtCustStreet.getText() + "',";
                    sqlQuery += "'" + txtCustCity.getText() + "',";
                    sqlQuery += "'" + txtCustState.getText() + "',";
                    sqlQuery += "'" + Integer.parseInt(txtCustZip.getText()) + "')";

                sendDBCommand(sqlQuery);
    
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
