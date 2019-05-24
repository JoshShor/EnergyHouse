package cs134.miracosta.edu.energyhouse.model;


import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private Context mContext;

    //TASK 1: DEFINE THE DATABASE VERSION, NAME AND TABLE NAME
    public static final String DATABASE_NAME = "ENERGYHOUSE";
    private static final int DATABASE_VERSION = 1;

    //Dennis's Table**********************************************************
    private static final String IMPACT_TABLE = "ImpactItems";
    private static final String RECYCLING_LOCATIONS_TABLE = "Recycling_Locations";
    //End Dennis's Table**********************************************************

    private static final String SOLAR_TABLE = "Solar";
  //TASK: DEFINE THE FIELDS (COLUMN NAMES) FOR THE SOLAR TABLE
    private static final String SOLAR_KEY_FIELD_ID = "_id";
    private static final String SOLAR_PANEL_NAME = "panel";
    private static final String SOLAR_PANEL_COST = "costs";
    private static final String SOLAR_PANEL_WATTAGE = "watts";
    private static final String SOLAR_PANEL_SQFT = "SqFootage";

    //Dennis's Fields**********************************************************
    private static final String KEY_IMPACT_FIELD_ID = "_id";
    private static final String FIELD_POUNDS_PAPER = "paper";
    private static final String FIELD_POUNDS_MIXED = "mixed";

    private static final String RECYCLING_LOCATIONS_KEY_FIELD_ID = "_id";
    private static final String RECYCLING_FIELD_NAME = "name";
    private static final String RECYCLING_FIELD_ADDRESS = "address";
    private static final String RECYCLING_FIELD_CITY = "city";
    private static final String RECYCLING_FIELD_STATE = "state";
    private static final String RECYCLING_FIELD_ZIP_CODE = "zip_code";
    private static final String RECYCLING_FIELD_PHONE = "phone";
    private static final String RECYCLING_FIELD_LATITUDE = "latitude";
    private static final String RECYCLING_FIELD_LONGITUDE = "longitude";
    //End Dennis's Fields**********************************************************


    // DEFINE THE FIELDS (COLUMN NAMES) FOR THE MilageFuelLog TABLE
    private static final String MILAGELOG_TABLE = "MFLog";
    private static final String MILAGELOG_KEY_FIELD_ID = "_id";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_FUELAMT = "fuel_amount";
    private static final String FIELD_ODOMETER = "odometer";
    private static final String FIELD_FUEL_PRICE_PER_UNIT = "fuel_price";

    //TASK: DEFINE THE FIELDS (COLUMN NAMES) FOR THE ChargingLocations TABLE
    private static final String LOCATIONS_TABLE = "Locations";
    private static final String LOCATIONS_KEY_FIELD_ID = "_id";
    private static final String FIELD_LOCATION_NAME = "name";
    private static final String FIELD_ADDRESS = "address";
    private static final String FIELD_CITY = "city";
    private static final String FIELD_STATE = "state";
    private static final String FIELD_ZIP_CODE = "zip_code";
    private static final String FIELD_LATITUDE = "latitude";
    private static final String FIELD_LONGITUDE = "longitude";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    /**
     * Creates the tables
     *
     * @param database the database of the tables
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        String createQuery = "CREATE TABLE " + MILAGELOG_TABLE + "("
                + MILAGELOG_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_DATE + " DATE, "
                + FIELD_FUELAMT + " DOUBLE, "
                + FIELD_ODOMETER + " DOUBLE, "
                + FIELD_FUEL_PRICE_PER_UNIT + " DOUBLE" + ")";
        database.execSQL(createQuery);

        createQuery = "CREATE TABLE " + LOCATIONS_TABLE + "("
                + LOCATIONS_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_LOCATION_NAME + " TEXT, "
                + FIELD_ADDRESS + " TEXT, "
                + FIELD_CITY + " TEXT, "
                + FIELD_STATE + " TEXT, "
                + FIELD_ZIP_CODE + " TEXT, "
                + FIELD_LATITUDE + " REAL, "
                + FIELD_LONGITUDE + " REAL" + ")";
        database.execSQL(createQuery);

        //Dennis's Table onCreate**********************************************************
        String table = "CREATE TABLE IF NOT EXISTS " + IMPACT_TABLE + "("
                + KEY_IMPACT_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_POUNDS_PAPER + " REAL, "
                + FIELD_POUNDS_MIXED + " REAL"
                + ")";
        database.execSQL (table);

        createQuery = "CREATE TABLE IF NOT EXISTS " + RECYCLING_LOCATIONS_TABLE + "("
                + RECYCLING_LOCATIONS_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + RECYCLING_FIELD_NAME + " TEXT, "
                + RECYCLING_FIELD_ADDRESS + " TEXT, "
                + RECYCLING_FIELD_CITY + " TEXT,"
                + RECYCLING_FIELD_STATE + " TEXT,"
                + RECYCLING_FIELD_ZIP_CODE + " TEXT,"
                + RECYCLING_FIELD_PHONE + " TEXT,"
                + RECYCLING_FIELD_LATITUDE + " REAL,"
                + RECYCLING_FIELD_LONGITUDE + " REAL"
                + ")";

        database.execSQL(createQuery);

        //End Dennis's Table onCreate**********************************************************

        //Creation of the table for solar panels
        createQuery = "CREATE TABLE IF NOT EXISTS " + SOLAR_TABLE + "("
                + SOLAR_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + SOLAR_PANEL_NAME + " TEXT, "
                + SOLAR_PANEL_COST + " DOUBLE, "
                + SOLAR_PANEL_WATTAGE + " DOUBLE, "
                + SOLAR_PANEL_SQFT + " DOUBLE" + ")";
        database.execSQL(createQuery);

    }

    /**
     * Upgrades the database
     *
     * @param database the database
     * @param oldVersion old version number
     * @param newVersion new version number
     */
    @Override
    public void onUpgrade(SQLiteDatabase database,
                          int oldVersion,
                          int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + MILAGELOG_TABLE);
        database.execSQL("DROP TABLE IF EXISTS " + LOCATIONS_TABLE);

        //Dennis's Table onUpgrade**********************************************************
        database.execSQL("DROP TABLE IF EXISTS " + IMPACT_TABLE);
        database.execSQL("DROP TABLE IF EXISTS " + RECYCLING_LOCATIONS_TABLE);
        //End Dennis's Table onUpgrade**********************************************************
        database.execSQL("DROP TABLE IF EXISTS " + SOLAR_TABLE);

        onCreate(database);
    }

    //add Fuel Mileage Log to the database

    public void addMileageLog(FuelMileage entry) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_DATE, entry.getDateStr());
        values.put(FIELD_FUELAMT, entry.getFuelAmt());
        values.put(FIELD_ODOMETER, entry.getOdometerReading());
        values.put(FIELD_FUEL_PRICE_PER_UNIT, entry.getPricePerUnitFuel());

        long id = db.insert(MILAGELOG_TABLE, null, values);
        entry.setId(id);

        //Close the database
        db.close();
    }

    public List<FuelMileage> getAllMilageLogs() {
        List<FuelMileage> mileageLog = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        // A cursor is the results of a database query (what gets returned)
        Cursor cursor = database.query(
                MILAGELOG_TABLE,
                new String[]{MILAGELOG_KEY_FIELD_ID, FIELD_DATE, FIELD_FUELAMT, FIELD_ODOMETER, FIELD_FUEL_PRICE_PER_UNIT},
                null,
                null,
                null, null, null, null);

        //COLLECT EACH ROW IN THE TABLE
        if (cursor.moveToFirst()) {
            do {
                FuelMileage entry =
                        new FuelMileage(cursor.getLong(0),
                                cursor.getString(1),
                                cursor.getDouble(2),
                                cursor.getDouble(3),
                                cursor.getDouble(4));

                mileageLog.add(entry);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return mileageLog;
    }


    public void deleteFuelMileage(FuelMileage entry) {
        SQLiteDatabase db = getWritableDatabase();

        // DELETE THE TABLE ROW
        db.delete(MILAGELOG_TABLE, MILAGELOG_KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(entry.getId())});
        db.close();
    }

    public void deleteAllFuelMileages() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(MILAGELOG_TABLE, null, null);
        db.close();
    }

    public void updateFuelMileage(FuelMileage entry) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_DATE, entry.getDateStr());
        values.put(FIELD_FUELAMT, entry.getFuelAmt());
        values.put(FIELD_ODOMETER, entry.getOdometerReading());
        values.put(FIELD_FUEL_PRICE_PER_UNIT, entry.getPricePerUnitFuel());

        db.update(MILAGELOG_TABLE, values, MILAGELOG_KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(entry.getId())});
        db.close();
    }

    public FuelMileage getFuelMileage(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                MILAGELOG_TABLE,
                new String[]{MILAGELOG_KEY_FIELD_ID, FIELD_DATE, FIELD_FUELAMT, FIELD_ODOMETER, FIELD_FUEL_PRICE_PER_UNIT},
                MILAGELOG_KEY_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        FuelMileage entry = null;
        if (cursor != null) {
            cursor.moveToFirst();

            String uriString = cursor.getString(4);
            Uri uri = Uri.parse(uriString);

            entry = new FuelMileage(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getDouble(2),
                    cursor.getDouble(3));

            cursor.close();
        }
        db.close();
        return entry;
    }



    //Dennis's DBHelper methods**********************************************************

    /**
     * Adds Impact item to db
     *
     * @param impactItem the item to add
     */
    public void addImpactItem(ImpactItem impactItem) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_POUNDS_PAPER, impactItem.getPoundsOfPaper());

        values.put(FIELD_POUNDS_MIXED, impactItem.getPoundsOfMixedRecyclables());

        // INSERT THE ROW IN THE TABLE
        long id = db.insert(IMPACT_TABLE, null, values);

        impactItem.setId(id);

        // CLOSE THE DATABASE CONNECTION
        db.close();
    }

    /**
     * Gets all the ImpactItems from the db
     * @return a list of the items
     */
    public List<ImpactItem> getAllImpactItems() {
        List<ImpactItem> impactItemsList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        // A cursor is the results of a database query (what gets returned)
        Cursor cursor = database.query(
                IMPACT_TABLE,
                new String[]{KEY_IMPACT_FIELD_ID, FIELD_POUNDS_PAPER, FIELD_POUNDS_MIXED},
                null,
                null,
                null, null, null, null );

        //COLLECT EACH ROW IN THE TABLE
        if (cursor.moveToFirst()){
            do {
                ImpactItem impactItem =
                        new ImpactItem(cursor.getLong(0),
                                cursor.getDouble(1),
                                cursor.getDouble(2));
                impactItemsList.add(impactItem);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return impactItemsList;
    }

    /**
     * Deletes an ImpactItem in the db
     *
     * @param impactItem item to delete
     */
    public void deleteImpactItem(ImpactItem impactItem){
        SQLiteDatabase db = getWritableDatabase();

        // DELETE THE TABLE ROW
        db.delete(IMPACT_TABLE, KEY_IMPACT_FIELD_ID + " = ?",
                new String[] {String.valueOf(impactItem.getId())});
        db.close();
    }

    /**
     * Deletes all ImpactItems in the db
     */
    public void deleteAllImpactItems()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(IMPACT_TABLE, null, null);
        db.close();
    }

    /**
     * Update an ImpactItem in the db
     *
     * @param impactItem item to update
     */
    public void updateImpactItem(ImpactItem impactItem){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_POUNDS_PAPER, impactItem.getPoundsOfPaper());
        values.put(FIELD_POUNDS_MIXED, impactItem.getPoundsOfMixedRecyclables());

        db.update(IMPACT_TABLE, values, KEY_IMPACT_FIELD_ID + " = ?",
                new String[]{String.valueOf(impactItem.getId())});
        db.close();
    }

    /**
     * Get an ImpactItem from the db
     *
     * @param id the id of the item
     * @return the item
     */
    public ImpactItem getImpactItem(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                IMPACT_TABLE,
                new String[]{KEY_IMPACT_FIELD_ID, FIELD_POUNDS_PAPER, FIELD_POUNDS_MIXED},
                KEY_IMPACT_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null );

        ImpactItem impactItem = null;
        if (cursor != null) {
            cursor.moveToFirst();

            impactItem = new ImpactItem(
                    cursor.getLong(0),
                    cursor.getDouble(1),
                    cursor.getDouble(2));

            cursor.close();
        }
        db.close();
        return impactItem;
    }

    //Dennis's Recycling locations db helper methods************************************

    /**
     * Add a recycling location to the db
     * @param location the location to add
     */
    public void addRecyclingLocation(RecycleLocation location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(RECYCLING_FIELD_NAME, location.getName());
        values.put(RECYCLING_FIELD_ADDRESS, location.getAddress());
        values.put(RECYCLING_FIELD_CITY, location.getCity());
        values.put(RECYCLING_FIELD_STATE, location.getState());
        values.put(RECYCLING_FIELD_ZIP_CODE, location.getZipCode());
        values.put(RECYCLING_FIELD_PHONE, location.getPhone());
        values.put(RECYCLING_FIELD_LATITUDE, location.getLatitude());
        values.put(RECYCLING_FIELD_LONGITUDE, location.getLongitude());

        long id = db.insert(RECYCLING_LOCATIONS_TABLE, null, values);
        location.setId(id);
        // CLOSE THE DATABASE CONNECTION
        db.close();
    }

    /**
     * Get all the recycling locations from the db
     *
     * @return list of all the recycling locations
     */
    public List<RecycleLocation> getAllRecyclingLocations() {
        ArrayList<RecycleLocation> locationsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                RECYCLING_LOCATIONS_TABLE,
                new String[]{RECYCLING_LOCATIONS_KEY_FIELD_ID, RECYCLING_FIELD_NAME,
                        RECYCLING_FIELD_ADDRESS, RECYCLING_FIELD_CITY, RECYCLING_FIELD_STATE,
                        RECYCLING_FIELD_ZIP_CODE, RECYCLING_FIELD_PHONE, RECYCLING_FIELD_LATITUDE,
                        RECYCLING_FIELD_LONGITUDE},
                null,
                null,
                null, null, null, null);

        //COLLECT EACH ROW IN THE TABLE
        if (cursor.moveToFirst()) {
            do {
                RecycleLocation location =
                        new RecycleLocation(cursor.getLong(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5),
                                cursor.getString(6),
                                cursor.getDouble(7),
                                cursor.getDouble(8));
                locationsList.add(location);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return locationsList;
    }

    /**
     * Delete a recycling location in the db
     *
     * @param location the recycling location to delete
     */
    public void deleteRecylingLocation(RecycleLocation location) {
        SQLiteDatabase db = this.getWritableDatabase();

        // DELETE THE TABLE ROW
        db.delete(RECYCLING_LOCATIONS_TABLE, RECYCLING_LOCATIONS_KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(location.getId())});
        db.close();
    }

    /**
     * Delete all recycling locations in the db
     */
    public void deleteAllRecyclingLocations() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(RECYCLING_LOCATIONS_TABLE, null, null);
        db.close();
    }

    /**
     * Get a recycling location from the db
     *
     * @param id the id of the recycling location
     * @return the recycling location
     */
    public RecycleLocation getRecyclingLocation(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                RECYCLING_LOCATIONS_TABLE,
                new String[]{RECYCLING_LOCATIONS_KEY_FIELD_ID, RECYCLING_FIELD_NAME,
                        RECYCLING_FIELD_ADDRESS, RECYCLING_FIELD_CITY, RECYCLING_FIELD_STATE,
                        RECYCLING_FIELD_ZIP_CODE, RECYCLING_FIELD_PHONE, RECYCLING_FIELD_LATITUDE,
                        RECYCLING_FIELD_LONGITUDE},
                RECYCLING_LOCATIONS_KEY_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        RecycleLocation location =
                new RecycleLocation(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getDouble(7),
                        cursor.getDouble(8));
        cursor.close();
        db.close();
        return location;
    }

    /**
     * Imports recycling location data from CSV into the db
     *
     * @param csvFileName the csv file name
     * @return whether or not the operation was successful
     */
    public boolean importRecyclingLocationsFromCSV(String csvFileName) {
        AssetManager manager = mContext.getAssets();
        InputStream inStream;
        try {
            inStream = manager.open(csvFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));
        String line;
        try {
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 9) {
                    Log.d("Caffeine Locations", "Skipping Bad CSV Row: " + Arrays.toString(fields));
                    continue;
                }
                long id = Long.parseLong(fields[0].trim());
                String name = fields[1].trim();
                String address = fields[2].trim();
                String city = fields[3].trim();
                String state = fields[4].trim();
                String zipCode = fields[5].trim();
                String phone = fields[6].trim();
                double latitude = Double.parseDouble(fields[7].trim());
                double longitude = Double.parseDouble(fields[8].trim());
                addRecyclingLocation(new RecycleLocation(id, name, address, city, state, zipCode, phone, latitude, longitude));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //End Dennis's DBHelper methods**********************************************************
}

