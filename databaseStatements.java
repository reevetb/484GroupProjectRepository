public void sendDBCommand(String sqlQuery)
    {
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "summer484";
        String userPASS = "ovaltine";
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
    
     public void loadCustDataFromDB()
    {
        String sqlQuery = "";
        String listString = "";
        sqlQuery = "Select * from summer484.Customers";
        //calling the sendDBCommand method
        sendDBCommand(sqlQuery);
        Customers.counter = 0;
        customersArray.clear();
      

        //to test the sqlException
        try
        {
            //while there is a next customer
            while (dbResults.next())
            {

                int custID = Integer.parseInt(dbResults.getString(1));
                String fName = dbResults.getString(2);
                String lName = dbResults.getString(3);
                String cell = dbResults.getString(4);
                String street = dbResults.getString(5);
                String city = dbResults.getString(6);
                String state = dbResults.getString(7);
                int zip = Integer.parseInt(dbResults.getString(8));
                
                customersArray.add(new Customers(custID, fName, lName, cell,
                        street, city, state, zip));
                ++Customers.counter;

                //System.out.println(customersArray.get(customersArray.size() - 1).toString());
                 //set string to read from the DB
                
            }

        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }

    }
    //connection to the database and loading specifc view
    public void DBviewProducts()
    {
        String sqlQuery = "";
        String listString = "";

        txtaCustomerEntityOutput.clear();
        sqlQuery = "SELECT A.PRODUCT_ID, A.P_NAME, A.P_COST, A.P_DESC\n"
                + "FROM PRODUCTS A INNER JOIN LINE_ITEMS B\n"
                + "ON A.PRODUCT_ID = B.PRODUCT_ID \n"
                + "WHERE B.CUST_ID =" + cboCustPaneID.getValue();
        sendDBCommand(sqlQuery);

        //to test the sqlException
        try
        {
            //while there is a next product for the customer
            while (dbResults.next())
            {
                //set string to read from the DB
                listString = dbResults.getString(1) + ",\t"
                        + dbResults.getString(2) + ",\t"
                        + dbResults.getString(3) + ",\t"
                        + dbResults.getString(4) + "\n";
                txtaCustomerEntityOutput.appendText(listString);
                listString = "";
            }
        } catch (SQLException e)
        {
            System.out.println(e.toString());;
        }
    }
    
