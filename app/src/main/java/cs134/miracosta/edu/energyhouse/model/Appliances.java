package cs134.miracosta.edu.energyhouse.model;

public class Appliances {

    private long mID;
    private String mName;
    private String mType;
    private double mPrice;
    private double mPowerUse;

    public Appliances() {
    }

    public Appliances(long ID, String name, String type, double price, double powerUse) {
        mID = ID;
        mName = name;
        mType = type;
        mPrice = price;
        mPowerUse = powerUse;
    }

    public Appliances(String name, String type, double price, double powerUse) {
        this(-1, name, type, price, powerUse);
    }

    public void setID(long ID) {
        mID = ID;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setType(String type) {
        mType = type;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public void setPowerUse(double powerUse) {
        mPowerUse = powerUse;
    }

    public long getID() {
        return mID;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public double getPrice() {
        return mPrice;
    }

    public double getPowerUse() {
        return mPowerUse;
    }

    @Override
    public String toString() {
        return "Appliances{" +
                "mID=" + mID +
                ", mName='" + mName + '\'' +
                ", mType='" + mType + '\'' +
                ", mPrice=" + mPrice +
                ", mPowerUse=" + mPowerUse +
                '}';
    }
}
