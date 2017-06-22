package BookIT;

public class Manager extends Employee {

    private int managerID;
    private int storeID_FK;
    public static int manageCount;
    public static int storeCount;

    //constructors
    public Manager(){
        managerID = 0;
        storeID_FK = 0;
        manageCount = 1;
        storeCount = 1;
    }
    public Manager(String fName, String lName, String street, String city,
            String state, int zipCode, String cell,
            String userName, String password) {
        super(fName, lName, street, city, state, zipCode, cell, userName, password);
        managerID = manageCount++;
        storeID_FK = storeCount++;

    }

    //getters
    public int getManagerID() {
        return this.managerID;
    }

    public int getStoreID_FK() {
        return this.storeID_FK;

    }

    @Override
    public int getEmpID() {
        return super.getEmpID();
    }

    //method
    @Override
    public boolean checkCredentials(String userName, String password) {
        return super.checkCredentials(userName, password);
    }

}
