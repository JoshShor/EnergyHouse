package cs134.miracosta.edu.energyhouse.model;

public class FuelMileage {

        long mId;
        String dateStr;
        double fuelAmt;
        double odometerReading;
        double pricePerUnitFuel;

        public FuelMileage() {

        }

        public FuelMileage(long id, String dateStr, double fuelAmt, double odometerReading, double pricePerUnitFuel) {
            this.mId = id;
            this.dateStr = dateStr;
            this.fuelAmt = fuelAmt;
            this.odometerReading = odometerReading;
            this.pricePerUnitFuel = pricePerUnitFuel;
        }

        public long getId() {
        return mId;
    }

        void setId(long id)
    {
        mId = id;
    }

        public String getDateStr() {
            return dateStr;
        }

        public void setDateStr(String dateStr) {
            this.dateStr = dateStr;
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
