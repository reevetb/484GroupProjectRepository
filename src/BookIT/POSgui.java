/*
 * Author: Daniel Baker
 * Date: 
 * Assignment: 
 * Purpose: 
 */
package BookIT;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Daniel
 */
public class POSgui extends Application {
    
    ListView<Inventory> cafeView = new ListView<>();
    ListView<Inventory> bookView = new ListView<>();
    ListView<Inventory> totalsView = new ListView<>();
    
    
    TextArea taPay = new TextArea();
    
    
    Label lblSubtotal = new Label ("Subtotal: ");
    Label lblTax = new Label ("Tax: ");
    Label lblTotal = new Label ("Total: ");
    Label lblQty = new Label ("QTY: ");
    
    
    TabPane tbPane = new TabPane();
    Tab tab1 = new Tab ("Books");
    Tab tab2 = new Tab ("Cafe");
    
    
    GridPane overallPane = new GridPane();
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
    TextField txtSubtotal = new TextField();
    TextField txtTax = new TextField();
    TextField txtTotal = new TextField();
    TextField txtPayment= new TextField();
    VBox payButtons = new VBox();
    
    
    @Override
    public void start(Stage primaryStage) {
        
        overallPane.setAlignment(Pos.CENTER);
        
        tab1.setContent(bookPane);
        tab1.setClosable(false);
        tab2.setContent(cafePane);
        tab2.setClosable(false);
        
        tbPane.getTabs().addAll(tab1,tab2);
        
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
        
        
        overallPane.setHgap(10);
        overallPane.setVgap(10);
        
        overallPane.add(totalsView,0,0);
        overallPane.add(tbPane,1,0);
        overallPane.add(totalPane,0,1);
        overallPane.add(cashPane,1,1);
        
        Scene posScene = new Scene(overallPane,700,700);
        primaryStage.setScene(posScene);
        primaryStage.setTitle("POS");
        primaryStage.show();
        
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
