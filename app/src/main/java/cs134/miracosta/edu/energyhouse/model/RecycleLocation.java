package cs134.miracosta.edu.energyhouse.model;

import android.os.Parcel;
import android.os.Parcelable;


public class RecycleLocation implements Parcelable
{
    private long mId;
    private String mName;
    private String mAddress;
    private String mCity;
    private String mState;
    private String mZipCode;
    private String mPhone;
    private double mLatitude;
    private double mLongitude;

    public RecycleLocation(long id, String name, String address, String city, String state,
                           String zipCode, String phone, double latitude, double longitude)
    {
        mId = id;
        mName = name;
        mAddress = address;
        mCity = city;
        mState = state;
        mZipCode = zipCode;
        mPhone = phone;
        mLatitude = latitude;
        mLongitude = longitude;
    }

    public RecycleLocation(String name, String address, String city, String state,
                           String zipCode, String phone, double latitude, double longitude)
    {
        this(-1, name, address, city, state, zipCode, phone, latitude, longitude);
    }

    protected RecycleLocation(Parcel in) {
        mId = in.readLong();
        mName = in.readString();
        mAddress = in.readString();
        mCity = in.readString();
        mState = in.readString();
        mZipCode = in.readString();
        mPhone = in.readString();
        mLatitude = in.readDouble();
        mLongitude = in.readDouble();
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String zipCode) {
        mZipCode = zipCode;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public String getFullAddress()
    {
        return mAddress + "\n" + mCity + ", " + mState + "  " + mZipCode;
    }

    public String getFormattedLatLng()
    {
        String latLng = String.valueOf(Math.abs(mLatitude));
        latLng += ((mLatitude < 0.0) ? " S  " : " N  ");
        latLng += String.valueOf(Math.abs(mLongitude));
        latLng += ((mLongitude < 0.0) ? " W" : "E");
        return latLng;
    }

    @Override
    public String toString() {
        return "RecycleLocation{" +
                "Id=" + mId +
                ", Name='" + mName + '\'' +
                ", Address='" + mAddress + '\'' +
                ", City='" + mCity + '\'' +
                ", State='" + mState + '\'' +
                ", Zip Code='" + mZipCode + '\'' +
                ", Phone='" + mPhone + '\'' +
                ", Latitude=" + mLatitude +
                ", Longitude=" + mLongitude +
                '}';
    }

    public String getInfo()
    {
        return mName + '\n' + mAddress + '\n' + mCity +
                '\n' + mState + '\n' + mZipCode +  + '\n' + mPhone;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mId);
        parcel.writeString(mName);
        parcel.writeString(mAddress);
        parcel.writeString(mCity);
        parcel.writeString(mState);
        parcel.writeString(mZipCode);
        parcel.writeString(mPhone);
        parcel.writeDouble(mLatitude);
        parcel.writeDouble(mLongitude);
    }

    public static final Creator<RecycleLocation> CREATOR = new Creator<RecycleLocation>() {
        @Override
        public RecycleLocation createFromParcel(Parcel in) {
            return new RecycleLocation(in);
        }

        @Override
        public RecycleLocation[] newArray(int size) {
            return new RecycleLocation[size];
        }
    };
}