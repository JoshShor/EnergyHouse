package cs134.miracosta.edu.energyhouse.model;

public class Appliances {

    private long mID;
    private String mName;
    private String mType;
    private double mPrice;
    private double mWatts;
    private double mHours;
    private double mWattHour;
    private double mTotalWH;
    private double mKiloWattHourPerWeek;
    private double mKiloWattHourPerMonth;
    private int DAYS_OF_WEEK = 7;
    private int DAYS_OF_MONTH = 30; //precise number is 30.4167 if you average out number of days in year/12


    public Appliances() {
    }

    public Appliances(long ID, String name, String type, double price, double wattHour) {
        mID = ID;
        mName = name;
        mType = type;
        mPrice = price;
        mWattHour = wattHour;
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

    public void setWatts(double watts) {
        mWatts = watts;
    }

    public void setHours(double hours) {
        mHours = hours;
    }

    public void setWattHour(double w, double h) {
        mWattHour = mWatts*mHours;
    }

    public void setTotalWH(double total){
        mTotalWH = total;
    }

    public void setEnergyPerWeek(double total){
        mKiloWattHourPerWeek = (total/1000)*DAYS_OF_WEEK;
    }

    public void setEnergyPerMonth(double total){
        mKiloWattHourPerMonth = (total/1000)*DAYS_OF_MONTH;
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

    public double getWattHour() {
        return mWattHour;
    }

    public double getTotalWH(){
        return mTotalWH;
    }

    public double getEnergyPerWeek(){
         return mKiloWattHourPerWeek;
    }

    public double getEnergyPerMonth(){
        return mKiloWattHourPerMonth;
    }

    @Override
    public String toString() {
        return "Appliances{" +
                "mID=" + mID +
                ", mName='" + mName + '\'' +
                ", mType='" + mType + '\'' +
                ", mPrice=" + mPrice +
                ", mWattHour=" + mWattHour +
                '}';
    }
}
