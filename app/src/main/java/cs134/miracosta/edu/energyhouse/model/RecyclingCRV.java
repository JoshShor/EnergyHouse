package cs134.miracosta.edu.energyhouse.model;

/**
 * RecyclingCRV.java - Class to represent CRV
 *
 * @author Dennis La
 * @version 1.0
 */
public class RecyclingCRV
{
    private static final double ALUMINUM_VALUE_PER_POUND = 1.60;
    private static final double PET_VALUE_PER_POUND = 1.28;
    private static final double HDPE_VALUE_PER_POUND = 0.58;
    private static final double GLASS_VALUE_PER_POUND = 0.10;

    private double mPoundsAluminum;
    private double mPoundsPETBottles;
    private double mPoundsHDPEBottles;
    private double mPoundsGlassBottles;

    /**
     * Default constructor
     */
    public RecyclingCRV()
    {
        mPoundsAluminum = 0;
        mPoundsPETBottles = 0;
        mPoundsHDPEBottles = 0;
        mPoundsGlassBottles = 0;
    }

    /**
     * Full constructor to set all the values
     *
     * @param poundsAluminum pounds of aluminum
     * @param poundsPETBottles pounds of PET bottles
     * @param poundsHDPEBottles pounds of HDPE bottles
     * @param poundsGlassBottles pounds of glass bottles
     */
    public RecyclingCRV(double poundsAluminum, double poundsPETBottles,
                        double poundsHDPEBottles, double poundsGlassBottles)
    {
        mPoundsAluminum = poundsAluminum;
        mPoundsPETBottles = poundsPETBottles;
        mPoundsHDPEBottles = poundsHDPEBottles;
        mPoundsGlassBottles = poundsGlassBottles;
    }

    /**
     * Get pounds of aluminum
     *
     * @return pounds of aluminum
     */
    public double getPoundsAluminum() {
        return mPoundsAluminum;
    }

    /**
     * Set pounds of aluminum
     *
     * @param poundsAluminum pounds of aluminum
     */
    public void setPoundsAluminum(double poundsAluminum) {
        mPoundsAluminum = poundsAluminum;
    }

    /**
     * Get pounds of PET bottles
     *
     * @return pounds of PET bottles
     */
    public double getPoundsPETBottles() {
        return mPoundsPETBottles;
    }

    /**
     * Set pounds of PET bottles
     *
     * @param poundsPETBottles pounds of PET bottles
     */
    public void setPoundsPETBottles(double poundsPETBottles) {
        mPoundsPETBottles = poundsPETBottles;
    }

    /**
     * Get pounds of HDPE bottles
     *
     * @return pounds of HDPE bottles
     */
    public double getPoundsHDPEBottles() {
        return mPoundsHDPEBottles;
    }

    /**
     * Set pounds of HDPE bottles
     *
     * @param poundsHDPEBottles pounds of HDPE bottles
     */
    public void setPoundsHDPEBottles(double poundsHDPEBottles) {
        mPoundsHDPEBottles = poundsHDPEBottles;
    }

    /**
     * Get pounds of Glass bottles
     *
     * @return pounds of Glass bottles
     */
    public double getPoundsGlassBottles() {
        return mPoundsGlassBottles;
    }

    /**
     * Set pounds of Glass bottles
     *
     * @param poundsGlassBottles pounds of Glass bottles
     */
    public void setPoundsGlassBottles(double poundsGlassBottles) {
        mPoundsGlassBottles = poundsGlassBottles;
    }

    /**
     * Calculate the CRV from pounds
     *
     * @return the CRV
     */
    public double calcCRV()
    {
        return mPoundsAluminum * ALUMINUM_VALUE_PER_POUND + mPoundsPETBottles * PET_VALUE_PER_POUND
                + mPoundsHDPEBottles * HDPE_VALUE_PER_POUND + mPoundsGlassBottles * GLASS_VALUE_PER_POUND;
    }
}
