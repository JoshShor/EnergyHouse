package cs134.miracosta.edu.energyhouse.model;

/**
 * SolarPanels.java - Class to fetch and handle information about solar panels
 *
 * @author JoshuaShor
 * @version 1.0
 */
public class SolarPanels{


    private String mPanel;
    private double mCosts;
    private double mWatts;
    private double mSqft;
    private double HOURS_OF_SUNLIGHT = 6.2;

    private double mTotalPanels;
    private double mTotalArea;
    private double mTotalCosts;


    /**
     * default constructor
     */
    public SolarPanels() {
        mPanel = "Solar Panel";
        mCosts = 0;
        mWatts = 0;
        mSqft = 0;
    }

    /**
     * Full constructor for the Solar Panels

     * @param panel
     * @param costs
     * @param watts
     * @param sqft
     */
    public SolarPanels(String panel, double costs, double watts, double sqft) {

        mPanel = panel;
        mCosts = costs;
        mWatts = watts;
        mSqft = sqft;
    }

    /**
     *  Instantiates the name (or Type) of Solar Panel.
     * @param panel
     */
    public void setPanel(String panel) {
        mPanel = panel;
    }

    /**
     * Instantiates the costs of the Solar Panel.
     * @param costs
     */
    public void setCosts(double costs) {
        mCosts = costs;
    }

    /**
     * Instantiates the wattage of the Solar Panel.
     * @param watts
     */
    public void setWatts(double watts) {
        mWatts = watts;
    }

    /**
     * Instantiates the square feet of the Solar Panel.
     * @param sqft
     */
    public void setSqft(double sqft) {
        mSqft = sqft;
    }

    /**
     * gets total number of solar panels needed to power up a person's home
     * @param userKiloWatts
     */
    public void setNumberOfPanels(double userKiloWatts){
        mTotalPanels = Math.round((userKiloWatts/(mWatts*HOURS_OF_SUNLIGHT))*1000);
    }

    /**
     * gets the total area that all the solar panels will cover(helps to know
     * if they have enough roof space to put up all those panels)
     * @param totalPanels
     */
    public void setTotalArea(double totalPanels){
        mTotalArea = (totalPanels * mSqft);
    }

    /**
     * Computes the total cost of the entire solar panel array
     * @param totalPanels
     */
    public void setTotalCosts(double totalPanels){
        mTotalCosts = (totalPanels*mCosts);
    }
    /**
     * Gets the name of solar panel
     * @return name of SolarPanel
     */
    public String getPanel() {
        return mPanel;
    }

    /**
     * Gets the cost of solar panel
     * @return cost of Solar Panel
     */
    public double getCosts() {
        return mCosts;
    }

    /**
     * Gets the wattage of solar panel
     * @return wattage of Solar Panel
     */
    public double getWatts() {
        return mWatts;
    }

    /**
     * Gets the square footag of solar panel
     * @return square footage of Solar Panel
     */
    public double getSqft() {
        return mSqft;
    }

    /**
     * Gets the total number of panels needed to the solar panel array
     * @return total number of panels needed
     */
    public double getNumberOfPanels(){
        return mTotalPanels;
    }

    /**
     * gets the total area that all the solar panels will cover
     * @return totalArea
     */
    public double getTotalArea(){
        return mTotalArea;
    }

    /**
     * gets the estimated costs on how much all those solar panels will cost
     * @return totalCost
     */
    public double getTotalCosts(){
        return mTotalCosts;
    }



    /**
     * toString method for the Solar Panel Class
     * @return a String of all the values
     */
    @Override
    public String toString() {
        return "SolarPanels{" +
                ", mPanel='" + mPanel + '\'' +
                ", mCosts=" + mCosts +
                ", mWatts=" + mWatts +
                ", mSqft=" + mSqft +
                '}';
    }
}
