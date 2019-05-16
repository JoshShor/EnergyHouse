package cs134.miracosta.edu.energyhouse.model;

public class MileageFuel {

    String dateStr;
    String unitMeasure;
    double fuelAmt;
    double odometerReading;
    double pricePerUnitFuel;

    public MileageFuel() {

    }

    public MileageFuel(String dateStr, String unitMeasure, double fuelAmt, double odometerReading, double pricePerUnitFuel) {
        this.dateStr = dateStr;
        this.unitMeasure = unitMeasure;
        this.fuelAmt = fuelAmt;
        this.odometerReading = odometerReading;
        this.pricePerUnitFuel = pricePerUnitFuel;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public double getFuelAmt() {
        return fuelAmt;
    }

    public void setFuelAmt(double fuelAmt) {
        this.fuelAmt = fuelAmt;
    }

    public double getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(double odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getPricePerUnitFuel() {
        return pricePerUnitFuel;
    }

    public void setPricePerUnitFuel(double pricePerUnitFuel) {
        this.pricePerUnitFuel = pricePerUnitFuel;
    }

    public double getTotalCostFillUp() {
        return pricePerUnitFuel * fuelAmt;
    }


    public double calculateTotalCost(){

        return pricePerUnitFuel*fuelAmt;
    }

}
