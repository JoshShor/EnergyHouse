package cs134.miracosta.edu.energyhouse.model;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * SolarPanels.java - Class to fetch and handle information about solar panels
 *
 * @author JoshuaShor
 * @version 1.0
 */
public class SolarPanels implements Parcelable {







    protected SolarPanels(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SolarPanels> CREATOR = new Creator<SolarPanels>() {
        @Override
        public SolarPanels createFromParcel(Parcel in) {
            return new SolarPanels(in);
        }

        @Override
        public SolarPanels[] newArray(int size) {
            return new SolarPanels[size];
        }
    };
}
