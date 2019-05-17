package cs134.miracosta.edu.energyhouse.model;

public class RecyclingCRV
{
    private static final double ALUMINUM_VALUE_PER_POUND = 1.60;
    private static final double PET_VALUE_PER_POUND = 1.28;
    private static final double HDPE_VALUE_PER_POUND = 0.58;
    private static final double GLASS_VALUE_PER_POUND = 0.10;

    double mPoundsAluminum;
    double mPoundsPETBottles;
    double mPoundsHDPEBottles;
    double mPoundsGlassBottles;

    public RecyclingCRV()
    {
        mPoundsAluminum = 0;
        mPoundsPETBottles = 0;
        mPoundsHDPEBottles = 0;
        mPoundsGlassBottles = 0;
    }

    public RecyclingCRV(double poundsAluminum, double poundsPETBottles,
                        double poundsHDPEBottles, double poundsGlassBottles)
    {
        mPoundsAluminum = poundsAluminum;
        mPoundsPETBottles = poundsPETBottles;
        mPoundsHDPEBottles = poundsHDPEBottles;
        mPoundsGlassBottles = poundsGlassBottles;
    }

    public double getPoundsAluminum() {
        return mPoundsAluminum;
    }

    public void setPoundsAluminum(double poundsAluminum) {
        mPoundsAluminum = poundsAluminum;
    }

    public double getPoundsPETBottles() {
        return mPoundsPETBottles;
    }

    public void setPoundsPETBottles(double poundsPETBottles) {
        mPoundsPETBottles = poundsPETBottles;
    }

    public double getPoundsHDPEBottles() {
        return mPoundsHDPEBottles;
    }

    public void setPoundsHDPEBottles(double poundsHDPEBottles) {
        mPoundsHDPEBottles = poundsHDPEBottles;
    }

    public double getPoundsGlassBottles() {
        return mPoundsGlassBottles;
    }

    public void setPoundsGlassBottles(double poundsGlassBottles) {
        mPoundsGlassBottles = poundsGlassBottles;
    }

    public double calcCRV()
    {
        return mPoundsAluminum * ALUMINUM_VALUE_PER_POUND + mPoundsPETBottles * PET_VALUE_PER_POUND
                + mPoundsHDPEBottles * HDPE_VALUE_PER_POUND + mPoundsGlassBottles * GLASS_VALUE_PER_POUND;
    }
}
