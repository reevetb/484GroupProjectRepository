package BookIT.V2;

public class Member {

    private int memID;
    private String fName;
    private String lName;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String cell;
    private String email;
 
    public static int memCount = 0;

    public Member(String fName, String lName, String street, String city,
            String state, int zipCode, String cell, String email) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cell = cell;
        this.email = email;

        memID = memCount++;

    }
    //loading from the database
    public Member(int memdID, String fName, String lName, String street, String city,
            String state, int zipCode, String cell, String email) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cell = cell;
        this.email = email;
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

   
    
     @Override
    public String toString()
    {
        return "Member ID: " + this.getMemID()
                + "\n\t First Name: " + this.getFName()
                + "\n\t Last Name: " + this.getLName()
                + "\n\t Street: " + this.getStreet()
                + "\n\t City: " + this.getCity()
                + "\n\t State: " + this.getState()
                + "\n\t Zipcode: " + this.getZipCode()
                + "\n\t Cell: " + this.getCell()
                + "\n\t email: " + this.getEmail();
    }

}
