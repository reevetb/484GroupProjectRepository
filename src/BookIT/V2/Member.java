package BookIT.V2;

public class Member {

    private int memID = 0;
    private String fName;
    private String lName;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String cell;
    private String email;
    private String userName;
    private String password;
    public static int memCount = 1;

    public Member(String fName, String lName, String street, String city,
            String state, int zipCode, String cell, String email,
            String userName, String password) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cell = cell;
        this.email = email;
        this.userName = userName;
        this.password = password;
        memID = ++memCount;

    }
    //loading from the database
    public Member(int memdID, String fName, String lName, String street, String city,
            String state, int zipCode, String cell, String email,
            String userName, String password) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cell = cell;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.memID = memID;
        memCount++;

    }

    public int getMemID() {
        return this.memID;
    }

    public String getFName() {
        return this.fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return this.lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCell() {
        return this.cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean checkCredentials(String userName, String password) {   //If username and password match return true
        if (this.userName.equals(userName) & this.password.equals(password)) {
            return true;
        } else //return false if username and password do not match
        {
            return false;
        }

    }
    
    @Override
    public String toString()
    {
        return "Member Email: \n" + this.email;
    }

}
