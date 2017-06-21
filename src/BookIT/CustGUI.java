/*
Author: Kyle Porter
Date: 6/19/17
Assignment: CIs 484 Group Project
Purpose: FX form for customer GUI after successful login
 */
package BookIT;

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
public class CustGUI extends Application {
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
    Label lblCustAddress = new Label("Address:");
    TextField txtCustUser = new TextField();
    TextField txtCustPass = new TextField();
    TextField txtCustEmail = new TextField();
    TextField txtCustPhone = new TextField();
    TextField txtCustAddress = new TextField();
    Button btnCustUpdate = new Button("Update");
    
    
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        // showing intital customer scene & stage
        primaryStage.setTitle("CUSTOMER NAME");
        primaryStage.setScene(custScene);
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
        custInfoPane.add(lblCustAddress, 0, 4);
        custInfoPane.add(txtCustUser, 1, 0);
        custInfoPane.add(txtCustPass, 1, 1);
        custInfoPane.add(txtCustEmail, 1, 2);
        custInfoPane.add(txtCustPhone, 1, 3);
        custInfoPane.add(txtCustAddress, 1, 4);
        custInfoPane.add(btnCustUpdate, 1, 5);
           
        // adding columns to customer inventory table
        TableColumn tblcBookID = new TableColumn("ID");
        TableColumn tblcBook = new TableColumn("Book");
        TableColumn tblcBookPrice = new TableColumn("Price");
        TableColumn tblcBookStore = new TableColumn("Store");
        custInvTbl.getColumns().addAll(tblcBookID, tblcBook, tblcBookPrice,
                tblcBookStore);
                
        // populating customer inventory table cells
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}