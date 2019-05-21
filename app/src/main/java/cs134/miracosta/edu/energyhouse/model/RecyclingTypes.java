package cs134.miracosta.edu.energyhouse.model;

/**
 * RecyclingTypes.java - Class to represent the different recyclable types
 *
 * @author Dennis La
 * @version 1.0
 */
public class RecyclingTypes
{
    private String mRecyclableName;
    private String mHowToDispose;

    /**
     * Default constructor
     */
    public RecyclingTypes()
    {
        mRecyclableName = "Unknown";
        mHowToDispose = "Unknown";
    }

    /**
     * Full constructor that takes in both data members
     *
     * @param recyclableName the name of the recyclable
     * @param howToDispose how to dispose the item
     */
    public RecyclingTypes(String recyclableName, String howToDispose) {
        mRecyclableName = recyclableName;
        mHowToDispose = howToDispose;
    }

    /**
     * Get the name of the recyclable type
     *
     * @return the name of the recyclable type
     */
    public String getRecyclableName() {
        return mRecyclableName;
    }

    /**
     * Set the name of the recyclable type
     *
     * @param recyclableName the name of the recyclable type
     */
    public void setRecyclableName(String recyclableName) {
        mRecyclableName = recyclableName;
    }

    /**
     * Get the description of how to dispose of the recyclable type
     *
     * @return the description of how to dispose of the recyclable type
     */
    public String getHowToDispose() {
        return mHowToDispose;
    }

    /**
     * Set the description of how to dispose of the recyclable type
     *
     * @param howToDispose the description of how to dispose of the recyclable type
     */
    public void setHowToDispose(String howToDispose) {
        mHowToDispose = howToDispose;
    }
}
