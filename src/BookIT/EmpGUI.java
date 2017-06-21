/*
Author: Kyle Porter
Date: 6/19/17
Assignment: CIS 484 Group Project
Purpose: Employee GUI after successful login
 */
package BookIT;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 *
 * @author KP
 */
public class EmpGUI extends Application {
    
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
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        // intializing employee scene & stage
        primaryStage.setTitle("EMPLOYEE NAME");
        primaryStage.setScene(empScene);
        primaryStage.show();
        
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
        
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}