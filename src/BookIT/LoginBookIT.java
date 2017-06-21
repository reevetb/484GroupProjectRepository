/*
 * Author: Kyle Porter, Daniel Baker, Trent Reeve, Marvin Bogyah
 * Date: 6/19/17
 * Assignment: Group Project - BookIT Login GUI
 * Purpose: The BookIT Information System is an IS that customers, employees, and managers
   use to view/manage inventory and create/view reports. In addition has a 
   customer friendly system that rewards loyal customers
   by providing discounts to books purchased.
 */
package BookIT;

import javafx.application.Application;
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

public class LoginBookIT extends Application {

    Label lblUser = new Label("Username:");
    Label lblPass = new Label("Password:");
    TextField txtUser = new TextField();
    TextField txtPass = new TextField();
    ComboBox<String> cboLoginType = new ComboBox();
    Button btnLogIn = new Button("Login");

    @Override
    public void start(Stage primaryStage) {

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

    }

    public static void main(String[] args) {

    }

}