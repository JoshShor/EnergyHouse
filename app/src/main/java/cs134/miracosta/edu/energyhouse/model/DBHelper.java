package cs134.miracosta.edu.energyhouse.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private Context mContext;

    //TASK 1: DEFINE THE DATABASE VERSION, NAME AND TABLE NAME
    public static final String DATABASE_NAME = "ENERGYHOUSE";
    private static final int DATABASE_VERSION = 1;

    //Dennis's Table**********************************************************
    private static final String IMPACT_TABLE = "ImpactItems";
    //End Dennis's Table**********************************************************
  
  //TASK: DEFINE THE FIELDS (COLUMN NAMES) FOR THE SOLAR TABLE
    private static final String SOLAR_TABLE = "Solar";
    private static final String COURSES_KEY_FIELD_ID = "_id";
    private static final String FIELD_ALPHA = "alpha";
    private static final String FIELD_NUMBER = "number";
    private static final String FIELD_TITLE = "title";

    //Dennis's Fields**********************************************************
    private static final String KEY_IMPACT_FIELD_ID = "_id";
    private static final String FIELD_POUNDS_PAPER = "paper";
    private static final String FIELD_POUNDS_MIXED = "mixed";
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
        //End Dennis's Table onCreate**********************************************************
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          int oldVersion,
                          int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + MILAGELOG_TABLE);
        database.execSQL("DROP TABLE IF EXISTS " + LOCATIONS_TABLE);

        //Dennis's Table onUpgrade**********************************************************
        database.execSQL("DROP TABLE IF EXISTS " + IMPACT_TABLE);
        //End Dennis's Table onUpgrade**********************************************************

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

    public void deleteImpactItem(ImpactItem impactItem){
        SQLiteDatabase db = getWritableDatabase();

        // DELETE THE TABLE ROW
        db.delete(IMPACT_TABLE, KEY_IMPACT_FIELD_ID + " = ?",
                new String[] {String.valueOf(impactItem.getId())});
        db.close();
    }

    public void deleteAllImpactItems()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(IMPACT_TABLE, null, null);
        db.close();
    }

    public void updateImpactItem(ImpactItem impactItem){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_POUNDS_PAPER, impactItem.getPoundsOfPaper());
        values.put(FIELD_POUNDS_MIXED, impactItem.getPoundsOfMixedRecyclables());

        db.update(IMPACT_TABLE, values, KEY_IMPACT_FIELD_ID + " = ?",
                new String[]{String.valueOf(impactItem.getId())});
        db.close();
    }

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

    //End Dennis's DBHelper methods**********************************************************
}

