package BookIT;

public class Expenses {

    private int invoiceNum;
    private String expType;
    private String expDate;
    private double expCost;
    private String expDesc;
    private int storeID_FK;
    public static int invoiceCount;
    public static int storeCount;

    public Expenses() {
        invoiceNum = 0;
        expType = "";
        expDate = "";
        expCost = 0.0;
        expDesc = "";
        storeID_FK = 0;
        invoiceCount = 1;
        storeCount = 1;
    }

    public Expenses(String expType, String expDate, double expCost,
            String expDesc) {
        this.expType = expType;
        this.expDate = expDate;
        this.expCost = expCost;
        this.expDesc = expDesc;
        invoiceNum = invoiceCount++;
        storeID_FK = storeCount++;
    }

    public int getInvoiceNum() {
        return this.invoiceNum;
    }

    public int getStoreID_FK() {
        return this.storeID_FK;
    }

    public String getExpType() {
        return this.expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public double getExpCost() {
        return this.expCost;
    }

    public void setExpCost(double expCost) {
        this.expCost = expCost;
    }

    public String getExpDesc() {
        return this.expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
    }
}
