package cs134.miracosta.edu.energyhouse.model;

public class Location{

    private long mid, mLongitude, mLatitude;
    private String mLocationName, mAddress, mCity, mState, mZipCode, mPhone;
    private int mDistance;

    public Location(long mid, long longitude, long latitude, String locationName, String address,
        String city, String state, String zipCode, String phone, int distance) {

        this.mid = mid;
        mLongitude = longitude;
        mLatitude = latitude;
        mLocationName = locationName;
        mAddress = address;
        mCity = city;
        mState = state;
        mZipCode = zipCode;
        mPhone = phone;
        mDistance = distance;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public long getLongitude() {
        return mLongitude;
    }

    public void setLongitude(long longitude) {
        mLongitude = longitude;
    }

    public long getLatitude() {
        return mLatitude;
    }

    public void setLatitude(long latitude) {
        mLatitude = latitude;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String locationName) {
        mLocationName = locationName;
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

    public int getDistance() {
        return mDistance;
    }

    public void setDistance(int distance) {
        mDistance = distance;
    }

}