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
//import oracle.jdbc.pool.*;
/**
 *
 * @author Marvin
 */
public class LoginBookIT extends Application {
    Label lblLogIn = new Label("-------Log In---------");
    Label lblUser1 = new Label("Username:");
    Label lblPass1 = new Label("Password:");
    Label lblCreate = new Label("-------Create User---------");
    Label lblFName = new Label("First Name:");
    Label lblLName = new Label("Last Name:");
    Label lblStreet = new Label("Street:");
    Label lblCity = new Label("City:");
    Label lblState = new Label("State:");
    Label lblZipCode = new Label("Zip Code:");
    Label lblCell = new Label("Cell#:");
    Label lblUser2 = new Label("Username:");
    Label lblPass2 = new Label("Password:");
    TextField txtFName = new TextField();
    TextField txtLName = new TextField();
    TextField txtStreet = new TextField();
    TextField txtCity = new TextField();
    TextField txtState = new TextField();
    TextField txtZipCode = new TextField();
    TextField txtCell = new TextField();
    TextField txtUser2 = new TextField();
    TextField txtPass2 = new TextField();
    TextField txtUser1 = new TextField();
    TextField txtPass1 = new TextField();

    ComboBox<String> cboLoginType = new ComboBox();
    ComboBox<String> cboCreateType = new ComboBox();
    Button btnLogIn = new Button("Login");
    Button btnCreate = new Button("Create");

    @Override
    public void start(Stage primaryStage) {

        cboLoginType.getItems().add("Member");
        cboLoginType.getItems().add("Employee");
        
        cboCreateType.getItems().add("Member");
        cboCreateType.getItems().add("Employee");

        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setHgap(15);
        mainPane.setVgap(7);
        mainPane.add(lblLogIn, 0, 0);
        mainPane.add(lblUser1, 0, 1);
        mainPane.add(lblPass1, 0, 2);
        mainPane.add(txtUser1, 1, 1);
        mainPane.add(txtPass1, 1, 2);
        mainPane.add(cboLoginType, 0, 3);
        mainPane.add(lblCreate, 0, 5);
        mainPane.add(lblFName, 0, 6);
        mainPane.add(lblLName, 0, 7);
        mainPane.add(lblStreet, 0, 8);
        mainPane.add(lblCity, 0, 9);
        mainPane.add(lblState, 0, 10);
        mainPane.add(lblZipCode, 0, 11);
        mainPane.add(lblCell, 0, 12);
        mainPane.add(lblUser2, 0, 13);
        mainPane.add(lblPass2, 0, 14);
        mainPane.add(cboCreateType, 0, 15);
        mainPane.add(txtFName, 1, 6);
        mainPane.add(txtLName, 1, 7);
        mainPane.add(txtStreet, 1, 8);
        mainPane.add(txtCity, 1, 9);
        mainPane.add(txtState, 1, 10);
        mainPane.add(txtZipCode, 1, 11);
        mainPane.add(txtCell, 1, 12);
        mainPane.add(txtUser2, 1, 13);
        mainPane.add(txtPass2, 1, 14);
        mainPane.add(btnLogIn, 1, 3);
        mainPane.add(btnCreate, 1, 15);


   
        Scene scene = new Scene(mainPane, 650, 550);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Form");
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
