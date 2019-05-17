package cs134.miracosta.edu.energyhouse.model;

public class RecyclingTypes
{
    private String mRecyclableName;
    private String mHowToDispose;

    public RecyclingTypes()
    {
        mRecyclableName = "Unknown";
        mHowToDispose = "Unknown";
    }

    public RecyclingTypes(String recyclableName, String howToDispose) {
        mRecyclableName = recyclableName;
        mHowToDispose = howToDispose;
    }

    public String getRecyclableName() {
        return mRecyclableName;
    }

    public void setRecyclableName(String recyclableName) {
        mRecyclableName = recyclableName;
    }

    public String getHowToDispose() {
        return mHowToDispose;
    }

    public void setHowToDispose(String howToDispose) {
        mHowToDispose = howToDispose;
    }
}
