/*
Author: Kyle Porter
Date: 6/20/17
Assignment: CIS 484 Group Project
Purpose: Employee entity class
 */
package BookIT;

/**
 *
 * @author KP
 */
public class Employee {

    private int empID;
    private String fName;
    private String lName;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String cell;
    private String userName;
    private String password;
    private double wage;
    private double otWage = wage* 1.5;
    private String type;
    public static int empCount;

    // constructor
    public Employee() {
        empID = 0;
        fName = "";
        lName = "";
        street = "";
        city = "";
        state = "";
        zipCode = 0;
        cell = "";
        userName = "";
        password = "";
        wage = 0.0;
        type = "";
        empCount = 1;

    }

    public Employee(String fName, String lName, String street, String city,
            String state, int zipCode, String cell,
            String userName, String password,double wage, String type) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cell = cell;
        this.userName = userName;
        this.password = password;
        this.wage = wage;
        this.type = type;
        empID = empCount++;

    }

    public int getEmpID() {
        return this.empID;
    }

    public String getFName() {
        return this.fName;
    }

    public void setFName(String name) {
        this.fName = name;
    }

    public String getLName() {
        return this.lName;
    }

    public void setLName(String name) {
        this.lName = name;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(int zip) {
        this.zipCode = zip;
    }

    public String getCell() {
        return this.cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public double getWage()
    {
        return this.wage;
    }
    
    public void setWage(double wage)
    {
        this.wage = wage;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    

    //methods
    public boolean checkCredentials(String userName, String password) {   //If username and password match return true
        if (this.userName.equals(userName) & this.password.equals(password)) {
            return true;
        } else //return false if username and password do not match
        {
            return false;
        }
  
    }
    @Override
    public String toString(){
        return "First Name: " + fName + ", Last Name: " + lName + ", Street: "
                + street + ", City: " + city + ", State: " + state + ", ZipCode: " +
                zipCode + ", Cell: " + cell + ", Username: " + userName + ", password: "
                + password + ", Wage: " + wage + ", Type: " + type;
    }
}
