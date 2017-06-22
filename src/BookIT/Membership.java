package BookIT;

public class Membership {

    private int storeID;
    private int memID;
    private double points;
    private String status;
    public static int storeCount;
    public static int memCount;

    public Membership() {
        storeID = 0;
        memID = 0;
        points = 0.0;
        status = "";
        storeCount = 1;
        memCount = 1;
    }

    public Membership(double points, String status) {
        this.points = points;
        this.status = status;
        storeID = storeCount++;
        memID = memCount++;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public int getMemID() {
        return this.memID;
    }

    public double getPoints() {
        return this.points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
