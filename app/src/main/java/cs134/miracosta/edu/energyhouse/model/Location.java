package cs134.miracosta.edu.energyhouse.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("AddressLine1")
    @Expose
    private String addressLine1;
    @SerializedName("AddressLine2")
    @Expose
    private Object addressLine2;
    @SerializedName("Town")
    @Expose
    private String town;
    @SerializedName("StateOrProvince")
    @Expose
    private String stateOrProvince;
    @SerializedName("Postcode")
    @Expose
    private String postcode;
    @SerializedName("CountryID")
    @Expose
    private Integer countryID;
    @Expose
    private Double latitude;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("ContactTelephone1")
    @Expose
    private String contactTelephone1;
    @SerializedName("ContactTelephone2")
    @Expose
    private Object contactTelephone2;
    @SerializedName("ContactEmail")
    @Expose
    private Object contactEmail;
    @SerializedName("AccessComments")
    @Expose
    private String accessComments;
    @SerializedName("RelatedURL")
    @Expose
    private String relatedURL;
    @SerializedName("Distance")
    @Expose
    private Double distance;
    @SerializedName("DistanceUnit")
    @Expose
    private Integer distanceUnit;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Object getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(Object addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getContactTelephone1() {
        return contactTelephone1;
    }

    public void setContactTelephone1(String contactTelephone1) {
        this.contactTelephone1 = contactTelephone1;
    }

    public Object getContactTelephone2() {
        return contactTelephone2;
    }

    public void setContactTelephone2(Object contactTelephone2) {
        this.contactTelephone2 = contactTelephone2;
    }

    public Object getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(Object contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getAccessComments() {
        return accessComments;
    }

    public void setAccessComments(String accessComments) {
        this.accessComments = accessComments;
    }

    public String getRelatedURL() {
        return relatedURL;
    }

    public void setRelatedURL(String relatedURL) {
        this.relatedURL = relatedURL;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(Integer distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

}

class Connection {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ConnectionTypeID")
    @Expose
    private Integer connectionTypeID;
    @SerializedName("ConnectionType")
    @Expose
    private ConnectionType connectionType;
    @SerializedName("Reference")
    @Expose
    private Object reference;
    @SerializedName("StatusTypeID")
    @Expose
    private Integer statusTypeID;
    @SerializedName("StatusType")
    @Expose
    private StatusType_ statusType;
    @SerializedName("LevelID")
    @Expose
    private Integer levelID;
    @SerializedName("Amps")
    @Expose
    private Integer amps;
    @SerializedName("Voltage")
    @Expose
    private Integer voltage;
    @SerializedName("PowerKW")
    @Expose
    private Integer powerKW;
    @SerializedName("CurrentTypeID")
    @Expose
    private Integer currentTypeID;
    @SerializedName("CurrentType")
    @Expose
    private CurrentType currentType;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("Comments")
    @Expose
    private Object comments;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getConnectionTypeID() {
        return connectionTypeID;
    }

    public void setConnectionTypeID(Integer connectionTypeID) {
        this.connectionTypeID = connectionTypeID;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public Object getReference() {
        return reference;
    }

    public void setReference(Object reference) {
        this.reference = reference;
    }

    public Integer getStatusTypeID() {
        return statusTypeID;
    }

    public void setStatusTypeID(Integer statusTypeID) {
        this.statusTypeID = statusTypeID;
    }

    public StatusType_ getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType_ statusType) {
        this.statusType = statusType;
    }

    public Integer getLevelID() {
        return levelID;
    }

    public void setLevelID(Integer levelID) {
        this.levelID = levelID;
    }


    public Integer getAmps() {
        return amps;
    }

    public void setAmps(Integer amps) {
        this.amps = amps;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getPowerKW() {
        return powerKW;
    }

    public void setPowerKW(Integer powerKW) {
        this.powerKW = powerKW;
    }

    public Integer getCurrentTypeID() {
        return currentTypeID;
    }

    public void setCurrentTypeID(Integer currentTypeID) {
        this.currentTypeID = currentTypeID;
    }

    public CurrentType getCurrentType() {
        return currentType;
    }

    public void setCurrentType(CurrentType currentType) {
        this.currentType = currentType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

}

class StatusType_ {

    @SerializedName("IsOperational")
    @Expose
    private Boolean isOperational;
    @SerializedName("IsUserSelectable")
    @Expose
    private Boolean isUserSelectable;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Title")
    @Expose
    private String title;

    public Boolean getIsOperational() {
        return isOperational;
    }

    public void setIsOperational(Boolean isOperational) {
        this.isOperational = isOperational;
    }

    public Boolean getIsUserSelectable() {
        return isUserSelectable;
    }

    public void setIsUserSelectable(Boolean isUserSelectable) {
        this.isUserSelectable = isUserSelectable;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}


class ConnectionType {

    @SerializedName("FormalName")
    @Expose
    private Object formalName;
    @SerializedName("IsDiscontinued")
    @Expose
    private Boolean isDiscontinued;
    @SerializedName("IsObsolete")
    @Expose
    private Boolean isObsolete;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Title")
    @Expose
    private String title;

    public Object getFormalName() {
        return formalName;
    }

    public void setFormalName(Object formalName) {
        this.formalName = formalName;
    }

    public Boolean getIsDiscontinued() {
        return isDiscontinued;
    }

    public void setIsDiscontinued(Boolean isDiscontinued) {
        this.isDiscontinued = isDiscontinued;
    }

    public Boolean getIsObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean isObsolete) {
        this.isObsolete = isObsolete;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

class CurrentType {

    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Title")
    @Expose
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

class StatusType {

    @SerializedName("IsOperational")
    @Expose
    private Boolean isOperational;
    @SerializedName("IsUserSelectable")
    @Expose
    private Boolean isUserSelectable;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Title")
    @Expose
    private String title;

    public Boolean getIsOperational() {
        return isOperational;
    }

    public void setIsOperational(Boolean isOperational) {
        this.isOperational = isOperational;
    }

    public Boolean getIsUserSelectable() {
        return isUserSelectable;
    }

    public void setIsUserSelectable(Boolean isUserSelectable) {
        this.isUserSelectable = isUserSelectable;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}


