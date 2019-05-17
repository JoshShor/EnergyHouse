package cs134.miracosta.edu.energyhouse.model;


public class ImpactItem
{
    private long mId;
    private double mPoundsOfPaper;
    private double mPoundsOfMixedRecyclables;

    public ImpactItem()
    {
        mId = -1;
        mPoundsOfPaper = 0.0;
        mPoundsOfMixedRecyclables = 0.0;
    }

    public ImpactItem(double poundsOfPaper, double poundsOfMixedRecyclables)
    {
        mId = -1;
        mPoundsOfPaper = poundsOfPaper;
        mPoundsOfMixedRecyclables = poundsOfMixedRecyclables;
    }

    public ImpactItem(long id, double poundsOfPaper, double poundsOfMixedRecyclables)
    {
        mId = id;
        mPoundsOfPaper = poundsOfPaper;
        mPoundsOfMixedRecyclables = poundsOfMixedRecyclables;
    }

    public double getPoundsOfPaper() {
        return mPoundsOfPaper;
    }

    public void setPoundsOfPaper(double poundsOfPaper) {
        mPoundsOfPaper = poundsOfPaper;
    }

    public double getPoundsOfMixedRecyclables() {
        return mPoundsOfMixedRecyclables;
    }

    public void setPoundsOfMixedRecyclables(double poundsOfMixedRecyclables) {
        mPoundsOfMixedRecyclables = poundsOfMixedRecyclables;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public double calcNumTreesSaved()
    {
        return -0.049 + 0.14 * mPoundsOfPaper;
    }

    public double calcNumGallonsOfOilSaved()
    {
        double numGallons = 0;

        numGallons += -0.008 + 1.328 * mPoundsOfPaper;
        numGallons += 0.083 + 1.94 * mPoundsOfMixedRecyclables;

        return numGallons;
    }

    public double calcHoursOfElectricitySaved()
    {
        double numHours = 0;

        numHours += -1.75 + 13.91 * mPoundsOfPaper;
        numHours += 0.046 + 12.27 * mPoundsOfMixedRecyclables;

        return numHours;
    }

    public double calcNumGallonsOfWaterSaved()
    {
        return 0.2 + 41.6 * mPoundsOfPaper;
    }


}
