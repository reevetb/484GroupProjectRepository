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
import java.sql.Time;
import java.time.LocalDate;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Trenton
 */
public class EmployeeView extends LoginMainForm
{

    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;

    //listview and array lists
    ListView<Inventory> cafeView = new ListView<>();
    ListView<Inventory> bookView = new ListView<>();
    ListView<Inventory> totalsView = new ListView<>();
    ArrayList<Inventory> mainArray = new ArrayList<>();
    ArrayList<Inventory> itemTotals = new ArrayList<>();
    ListView empShiftView = new ListView();
    ListView employeeView = new ListView();
    ArrayList<Employee> employeeArray = new ArrayList<>();
    ArrayList<Shifts> shiftArray = new ArrayList<>();
    ArrayList<Payroll> payrollArray = new ArrayList<>();

    //overall stuff
    TabPane empPane = new TabPane();
    Tab tab1 = new Tab("P.O.S.");
    Tab tab2 = new Tab("TimeClock");
    Tab tab3 = new Tab("Shifts");

    /**
     * ******************POS STUFF******************************************
     */
    TextArea taPay = new TextArea();

    ComboBox cbxMemberID = new ComboBox();
    ComboBox cbxGenre = new ComboBox();
    ComboBox cbxPrice = new ComboBox();

    Inventory newItem;
    Inventory newBook;

    double orderSubtotal;
    double orderTax;
    double orderTotal;
    double total = 0.00;

    Label lblSubtotal = new Label("Subtotal: ");
    Label lblTax = new Label("Tax: ");
    Label lblTotal = new Label("Total: ");
    Label lblQty = new Label("QTY: ");
    Label lblMemberID = new Label("Member ID: ");
    Label lblFilterGenre = new Label("Genre: ");
    Label lblFilterYear = new Label("Max Year: ");
    Label lblFilterPrice = new Label("Max Price: ");

    TabPane posPane = new TabPane();
    Tab tab4 = new Tab("Books");
    Tab tab5 = new Tab("Cafe");

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
    GridPane filterPane = new GridPane();

    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("3");
    Button btn4 = new Button("4");
    Button btn5 = new Button("5");
    Button btn6 = new Button("6");
    Button btn7 = new Button("7");
    Button btn8 = new Button("8");
    Button btn9 = new Button("9");
    Button btn0 = new Button("0");
    Button btnDecimal = new Button(".");
    Button btnDouble0 = new Button("00");
    Button btnHundred = new Button("100");
    Button btnFifty = new Button("50");
    Button btnTwenty = new Button("20");
    Button btnTen = new Button("10");
    Button btnItemUp = new Button("+");
    Button btnItemDown = new Button("-");
    Button btnCard = new Button("CC/Debit");
    Button btnPay = new Button("Pay");
    Button btnFilter = new Button("Filter");
    Button btnRefresh = new Button("Refresh");
    Button btnSearch = new Button("Search");
    Button btnAddBook = new Button("Add");
    Button btnAddCafe = new Button("Add");
//    Button btnFinalPay = new Button("Pay -->");
    Button btnFilterItem = new Button("Go!");
    Button btnDeleteItem = new Button("Remove Item");

    TextField txtFilterYear = new TextField();
    TextField txtSubtotal = new TextField();
    TextField txtTax = new TextField();
    TextField txtTotal = new TextField();
    TextField txtPayment = new TextField();
    VBox payButtons = new VBox();

    /**
     * ************************TC Stuff********************************
     */
    GridPane tcOverallPane = new GridPane();
    Employee loginEmp;

    //controls for employee check in/out tab
    Label lblShiftDate = new Label("Shift Date: "); 
    Label lblTime = new Label("Time:");
    TextField txtTime = new TextField();
    Button btnChkIn = new Button("Check In");
    Button btnChkOut = new Button("Check Out");
    Label lblShiftStart = new Label("Shift Start Time: ");
    Label lblShiftEnd = new Label("Shift End Time: ");
    TextField txtShiftDate = new TextField();
    TextField txtShiftStart = new TextField();
    TextField txtShiftEnd = new TextField();
    
    
    /**
     * ********************************************************
     */
    Stage primaryStage = new Stage();

    //Employee view constructor
    public EmployeeView() throws SQLException
    {
        //the overall view setup
        tab1.setContent(posOverallPane);
        tab1.setClosable(false);
        tab2.setContent(tcOverallPane);
        tab2.setClosable(false);
        //shift tab
        //tab3.setContent(shiftsOverallPane);

        empPane.getTabs().addAll(tab1, tab2, tab3);
        empPane.setStyle("-fx-background-image: url(https://ae01.alicdn.com/kf/HTB18yb5JVXXXXbjXXXXq6xXFXXXh/Photo-Backdrops-Children-Vinyl-Photo-Props-for-Studio-Photography-font-b-Background-b-font-font-b.jpg)");

        /**
         * ***********************Setting POS PANE**************************
         */
        posOverallPane.setAlignment(Pos.CENTER);
        posOverallPane.setPadding(new Insets(25,25,25,25));

        tab4.setContent(bookPane);
        tab4.setClosable(false);
        tab5.setContent(cafePane);
        tab5.setClosable(false);

        posPane.getTabs().addAll(tab4, tab5);

        bookPane.setAlignment(Pos.CENTER);
        bookPaneRight.setAlignment(Pos.CENTER);
        bookPaneLeft.setAlignment(Pos.CENTER);
        bookPaneRight.add(bookView, 0, 0);
        bookPaneLeft.add(btnFilter, 1, 0);
        bookPaneLeft.add(btnRefresh, 1, 1);
        bookPane.add(bookPaneRight, 0, 0);
        bookPane.add(bookPaneLeft, 1, 0);
        bookView.setMinSize(300, 300);

        cafePane.setAlignment(Pos.CENTER);
        cafePaneRight.setAlignment(Pos.CENTER);
        cafePaneLeft.setAlignment(Pos.CENTER);
        cafePaneRight.add(cafeView, 0, 0);
        cafePane.add(cafePaneRight, 0, 0);
        cafePane.add(cafePaneLeft, 1, 0);

        cashPane.setAlignment(Pos.CENTER);
         cashPane.setPadding(new Insets(25,25,25,25));
        cashPane.add(btnPay, 2, 0);
        btnPay.setMinSize(150, 100);

        totalPane.setAlignment(Pos.CENTER);
        totalPaneLeft.setAlignment(Pos.CENTER);
        totalPaneRight.setAlignment(Pos.CENTER);
        taPay.setMaxSize(200, 150);
        taPay.setScaleShape(true);
        totalPaneRight.add(taPay, 0, 0);
        totalPaneLeft.add(lblSubtotal, 1, 0);
        totalPaneLeft.add(txtSubtotal, 2, 0);
        totalPaneLeft.add(lblTax, 1, 1);
        totalPaneLeft.add(txtTax, 2, 1);
        totalPaneLeft.add(lblTotal, 1, 2);
        totalPaneLeft.add(txtTotal, 2, 2);
        totalPaneLeft.add(lblMemberID, 1, 3);
        totalPaneLeft.add(cbxMemberID, 2, 3);
//        totalPaneLeft.add(btnFinalPay, 1, 4);
        totalPane.add(totalPaneRight, 1, 0);
        totalPane.add(totalPaneLeft, 0, 0);

        filterPane.setAlignment(Pos.CENTER);
        filterPane.add(lblFilterGenre, 0, 0);
        filterPane.add(cbxGenre, 1, 0);
        filterPane.add(lblFilterYear, 0, 1);
        filterPane.add(txtFilterYear, 1, 1);
        filterPane.add(lblFilterPrice, 0, 2);
        filterPane.add(cbxPrice, 1, 2);
        filterPane.add(btnFilterItem, 1, 3, 3, 1);

        cbxGenre.getItems().addAll("Fiction", "Non-Fiction", "Mystery", "Sci-Fi", "Young Adult", "Educational",
                "Romance", "Horror", "Art");
        cbxPrice.getItems().addAll("$" + 10, "$" + 25, "$" + 50, "$" + 100, "$" + 200);

        Scene filterScene = new Scene(filterPane, 250, 300);
        Stage filterStage = new Stage();
        filterStage.setScene(filterScene);
        filterStage.setTitle("Filter Results");

        totalsView.setMaxSize(300, 450);

        posOverallPane.setHgap(10);
        posOverallPane.setVgap(10);

        posOverallPane.add(totalsView, 0, 0);
        posOverallPane.add(btnDeleteItem, 1, 0, 1, 1);
        posOverallPane.add(posPane, 2, 0);
        posOverallPane.add(totalPane, 0, 1, 2, 1);
        posOverallPane.add(cashPane, 1, 1, 2, 1);

        //logic
        fillInventoryBook();
        fillInventoryCafe();
        fillCbxMember();
        cbxMemberID.getItems().addAll("Guest");

        //refresh button 
        btnRefresh.setOnAction(r ->
        {
            try
            {
                fillInventoryBook();
            } catch (SQLException ex)
            {
                System.out.println(ex);
            }
        });

        //paying
        btnPay.setOnAction(p ->
        {
            GridPane paymentPane = new GridPane();
            Label lblPayCash = new Label("Cash: $ ");
            Label lblPayCard = new Label("CC #: ");
            Button btnPayment = new Button("ENTER");
            TextField txtPayCash = new TextField();
            TextField txtPayCard = new TextField();
            paymentPane.setAlignment(Pos.CENTER);
            paymentPane.add(lblPayCash, 0, 0);
            paymentPane.add(lblPayCard, 0, 1);
            paymentPane.add(txtPayCash, 1, 0);
            paymentPane.add(txtPayCard, 1, 1);
            paymentPane.add(btnPayment, 0, 2, 2, 1);
            Scene paymentScene = new Scene(paymentPane, 300, 250);
            Stage paymentStage = new Stage();
            paymentStage.setScene(paymentScene);
            paymentStage.show();

            btnPayment.setOnAction(pmt ->
            {
                String cashPay = txtPayCash.getText();
                String cardPay = txtPayCard.getText();
                String txtTotalOutput = "";
                Double balance = 0.0;

                if (txtPayCash.getText().isEmpty())
                {
                    if (txtPayCard.getText().isEmpty())
                    {
                        System.out.println("Please enter a payment amount");
                    } else
                    {
                        txtTotalOutput += "Total: " + txtTotal.getText();
                        txtTotalOutput += "\n Customer Paid: " + txtTotal.getText() + " with card " + cardPay;
                        txtTotalOutput += "\n---------------";
                    }
                } else
                {
                    Double customerPay = Double.valueOf(cashPay);
                    txtTotalOutput += "Total: " + txtTotal.getText();
                    txtTotalOutput += "\n Customer Pay: " + customerPay;
                    txtTotalOutput += "\n---------------";
                    balance = Double.valueOf(txtTotal.getText()) - customerPay;
                    if (balance == 0)
                    {
                        txtTotalOutput += "\n Customer has paid!";
                    }
                    if (balance < 0)
                    {
                        txtTotalOutput += "\n We owe the customer: $" + balance;
                    }
                    if (balance > 0)
                    {
                        double newBalance = balance;
                        txtTotalOutput += "\n Remaining Balance: " + newBalance;
                        txtTotalOutput += "\n Customer owes: " + newBalance;
                        txtTotal.setText(String.valueOf(newBalance));
                        if ((newBalance - balance) == 0)
                        {
                            System.out.println("Customer has paid!");

                        } else
                        {
                            taPay.clear();
                            balance = newBalance - customerPay;
                            txtTotalOutput += "\n Remaining Balance: " + balance;
                            txtTotalOutput += "\n Customer owes, " + balance;

                        }

                    }
                }
                taPay.setText(txtTotalOutput);

            });

        });

        btnDeleteItem.setOnAction(di ->
        {
            int itemPriceIndex = totalsView.getSelectionModel().getSelectedIndex();

            newItem = itemTotals.get(itemPriceIndex);

            double priceDelete = newItem.getPrice();
            System.out.println(priceDelete);
            deletePay(priceDelete);

            itemTotals.remove(newItem);
            ObservableList<Inventory> newTotal = FXCollections.observableArrayList(itemTotals);
            totalsView.setItems(newTotal);

            totalsView.refresh();

        });

        btnFilter.setOnAction(f ->
        {
            filterStage.show();

        });

        btnFilterItem.setOnAction(fi ->
        {
            if (!(cbxGenre.getSelectionModel().isEmpty()))
            {
                try
                {
                    filterGenre();
                } catch (SQLException ex)
                {
                    System.out.println(ex);
                }

                filterStage.close();
            }
            if (!(cbxPrice.getSelectionModel().isEmpty()))
            {
                try
                {
                    filterPrice();
                } catch (SQLException ex)
                {
                    System.out.println(ex);
                }
                filterStage.close();

            }
            if (!(txtFilterYear.getText().isEmpty()))
            {
                try
                {
                    filterYear();
                } catch (SQLException ex)
                {
                    System.out.println(ex);
                }
                filterStage.close();
            }
            if (cbxGenre.getSelectionModel().isEmpty() && cbxPrice.getSelectionModel().isEmpty() && txtFilterYear.getText().isEmpty())
            {
                GridPane errorPane = new GridPane();
                Label lblFilterError = new Label("PLEASE MAKE ONE SELECTION!");
                errorPane.setAlignment(Pos.CENTER);
                errorPane.add(lblFilterError, 0, 0);
                Scene errorScene = new Scene(errorPane, 225, 150);
                Stage errorStage = new Stage();
                errorStage.setScene(errorScene);
                errorStage.setTitle("ERROR");
                errorStage.show();
            }
        });

        //populating the nodes via a clicked listview item
        cafeView.setOnMouseClicked(e ->
        {
            newItem = cafeView.getSelectionModel().getSelectedItem();

            do
            {
                itemTotals.add(newItem);
                ObservableList<Inventory> cafeList = FXCollections.observableArrayList(itemTotals);
                totalsView.setItems(cafeList);
            } while (primaryStage.hasProperties());

            for (Inventory a : itemTotals)
            {
                total = a.getPrice();
            }
            orderSubtotal += total;

            txtSubtotal.setText(orderSubtotal + "");
            txtTax.setText((orderSubtotal * 0.06) + "");
            txtTotal.setText(Double.valueOf(txtTax.getText())
                    + Double.valueOf(txtSubtotal.getText()) + "");
        });

        //populating the nodes via a clicked listview item
        bookView.setOnMouseClicked(j ->
        {
            newBook = bookView.getSelectionModel().getSelectedItem();
            do
            {
                itemTotals.add(newBook);
                ObservableList<Inventory> bookList = FXCollections.observableArrayList(itemTotals);
                totalsView.setItems(bookList);
            } while (primaryStage.hasProperties());

            for (Inventory a : itemTotals)
            {
                total = a.getPrice();
            }

            orderSubtotal += total;

            txtSubtotal.setText(orderSubtotal + "");
            txtTax.setText((orderSubtotal * 0.06) + "");
            txtTotal.setText(Double.valueOf(txtTax.getText())
                    + Double.valueOf(txtSubtotal.getText()) + "");
        });

        /**
         * ************************Setting TimeClock*************************
         */
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
//        String hour = String.valueOf(LocalTime.now().getHour());
//        String min = String.valueOf(LocalTime.now().getMinute());
//        txtTime.setText(hour + ":" + min);
//        txtTime.setEditable(false);

        java.sql.Date todaysDate = java.sql.Date.valueOf(LocalDate.now());
        Time newTime = Time.valueOf(LocalTime.now());
        int hour = newTime.toLocalTime().getHour();
        int min = newTime.toLocalTime().getMinute();
        int sec = newTime.toLocalTime().getSecond();
        txtTime.setText(newTime.toString());
        txtTime.setEditable(false);
        
        
         // employee clock in button action
        btnChkIn.setOnAction(e -> {
            // create new employee shift instance &
            // add to employee arraylist
            Shifts newShift = new Shifts(todaysDate, newTime);
            shiftArray.add(newShift);
            System.out.println("Clocked in");
        });
        
        // employee clock out button action
        btnChkOut.setOnAction(e -> {
            System.out.println("clocked out");
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
      

        /**
         * ************************Setting ShiftPane*************************
         */
        /**
         * ******************************************************************
         */
        //needs to be converted to the overall employee view panes
        Scene empScene = new Scene(empPane, 900, 600);
        primaryStage.setScene(empScene);
        primaryStage.setTitle("Book IT Employee");
        primaryStage.show();

    }

    /**
     * ********************Methods****************
     */
   
    
    public void runPay(double price)
    {
        orderSubtotal += price;

        txtSubtotal.setText(orderSubtotal + "");
        txtTax.setText((orderSubtotal * 0.06) + "");
        txtTotal.setText(Double.valueOf(txtTax.getText()) + Double.valueOf(txtSubtotal.getText()) + "");
    }

    public void deletePay(double price)
    {
        orderSubtotal -= price;

        txtSubtotal.setText(orderSubtotal + "");
        txtTax.setText((orderSubtotal * 0.06) + "");
        txtTotal.setText(Double.valueOf(txtTax.getText()) + Double.valueOf(txtSubtotal.getText()) + "");
    }

    public void filterPrice() throws SQLException
    {
        String sqlQuery = "";
        String price;
        price = cbxPrice.getSelectionModel().getSelectedItem().toString();
        System.out.println(price);
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE ='Book' AND PRICE <=" + price;
        sendDBCommand(sqlQuery);

        ArrayList<Book> priceArray = new ArrayList<>();

        while (dbResults.next())
        {
//            priceArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
//                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
//                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
           
        }
        ObservableList<Inventory> priceList = FXCollections.observableArrayList(priceArray);
        bookView.setItems(priceList);

    }

    public void filterYear() throws SQLException
    {
        String sqlQuery = "";
        int year;
        year = Integer.valueOf(txtFilterYear.getText());
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE = 'Book' AND BOOK_YEAR <=" + year;

        sendDBCommand(sqlQuery);
        ArrayList<Book> yearArray = new ArrayList<>();

        while (dbResults.next())
        {
//            yearArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
//                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
//                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
//            
            yearArray.add(new Book(dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)), 
                    Double.valueOf(dbResults.getString(5)), dbResults.getString(11), dbResults.getString(6),
                    dbResults.getString(7), dbResults.getString(8), dbResults.getString(9), Integer.valueOf(dbResults.getString(10))));
        }
        ObservableList<Inventory> yearList = FXCollections.observableArrayList(yearArray);
        bookView.setItems(yearList);

    }

    public void filterGenre() throws SQLException
    {
        String sqlQuery = "";
        String genre;
        genre = cbxGenre.getSelectionModel().getSelectedItem().toString();
        String toUpperCase = genre.toUpperCase();
        System.out.println(toUpperCase);
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE ='Book' AND GENRE ='" + toUpperCase + "'";
        sendDBCommand(sqlQuery);

        ArrayList<Book> genreArray = new ArrayList<>();

        while (dbResults.next())
        {
//            genreArray.add(new Book(dbResults.getString(6), dbResults.getString(7), dbResults.getString(8), dbResults.getString(9),
//                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
//                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
            
            genreArray.add(new Book(dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)), 
                    Double.valueOf(dbResults.getString(5)), dbResults.getString(11), dbResults.getString(6),
                    dbResults.getString(7), dbResults.getString(8), dbResults.getString(9), Integer.valueOf(dbResults.getString(10))));
        }
        ObservableList<Inventory> genreList = FXCollections.observableArrayList(genreArray);
        bookView.setItems(genreList);

    }

    public void fillInventoryBook() throws SQLException
    {
        String sqlQuery = "";
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE = 'Book'";

        ArrayList<Book> bookArray = new ArrayList<>();

        sendDBCommand(sqlQuery);

        while (dbResults.next())
        {
//            bookArray.add(new Book(dbResults.getString(6), dbResults.getString(7),
//                    dbResults.getString(8), dbResults.getString(9),
//                    Integer.valueOf(dbResults.getString(10)), dbResults.getString(2),
//                    dbResults.getString(3), Integer.valueOf(dbResults.getString(4)),
//                    dbResults.getString(11), Double.valueOf(dbResults.getString(5))));
            bookArray.add(new Book(dbResults.getString(2), dbResults.getString(3), Integer.valueOf(dbResults.getString(4)), 
                    Double.valueOf(dbResults.getString(5)), dbResults.getString(11), dbResults.getString(6),
                    dbResults.getString(7), dbResults.getString(8), dbResults.getString(9), Integer.valueOf(dbResults.getString(10))));

        }
        ObservableList<Inventory> bookList = FXCollections.observableArrayList(bookArray);
        bookView.setItems(bookList);

    }

    public void fillInventoryCafe() throws SQLException
    {
        String sqlQuery = "";
        sqlQuery = "SELECT * FROM BOOKITDB.INVENTORY WHERE TYPE = 'Cafe'";

        ArrayList<Inventory> cafeArray = new ArrayList<>();

        sendDBCommand(sqlQuery);
        while (dbResults.next())
        {
            cafeArray.add(new Inventory(dbResults.getString(2), dbResults.getString(3),
                    Integer.valueOf(dbResults.getString(4)), Double.valueOf(dbResults.getString(5)),dbResults.getString(11)));
        }

        ObservableList<Inventory> cafeList = FXCollections.observableArrayList(cafeArray);

        cafeView.setItems(cafeList);
    }

    public void fillCbxMember() throws SQLException
    {
        String sqlQuery = "";
        sqlQuery = "SELECT * FROM BOOKITDB.MEMBERS";
        ArrayList<Member> memberEVArray = new ArrayList<>();

        sendDBCommand(sqlQuery);
        while (dbResults.next())
        {
            memberEVArray.add(new Member(Integer.valueOf(dbResults.getString(1)), dbResults.getString(2), dbResults.getString(3), dbResults.getString(4),
                    dbResults.getString(5), dbResults.getString(6), Integer.valueOf(dbResults.getString(7)), dbResults.getString(8), dbResults.getString(9)));
        }
        ObservableList<Member> memberList = FXCollections.observableArrayList(memberEVArray);
        cbxMemberID.getItems().addAll(memberList);

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
