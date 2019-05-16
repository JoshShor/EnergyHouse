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
  
  //TASK: DEFINE THE FIELDS (COLUMN NAMES) FOR THE SOLAR TABLE
    private static final String SOLAR_TABLE = "Solar";
    private static final String COURSES_KEY_FIELD_ID = "_id";
    private static final String FIELD_ALPHA = "alpha";
    private static final String FIELD_NUMBER = "number";
    private static final String FIELD_TITLE = "title";


    // DEFINE THE FIELDS (COLUMN NAMES) FOR THE MilageFuelLog TABLE
    private static final String MILAGELOG_TABLE = "MFLog";
    private static final String MILAGELOG_KEY_FIELD_ID = "_id";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_UNIT_OF_MEASURE = "unit_of_measure";
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

    // DEFINE THE FIELDS (COLUMN NAMES) FOR THE CarInfo TABLE
    private static final String CARINFO_TABLE = "CarInfo";
    private static final String CARINFO_KEY_FIELD_ID = "_id";
    private static final String FIELD_CAR = "car";
    private static final String FIELD_CITYRANGE= "city_range";
    private static final String FIELD_HIGHWAYRANGE = "highway_range";
    private static final String FIELD_CITYEFFICIENCY = "city_efficiency";
    private static final String FIELD_HIGHWAYEFFICIENCY = "highway_efficiency";


    public DBHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate (SQLiteDatabase database){
        String createQuery = "CREATE TABLE " + MILAGELOG_TABLE + "("
                + MILAGELOG_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_DATE + " DATE, "
                + FIELD_UNIT_OF_MEASURE + " TEXT, "
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

        //DONE:  Write the query to create the relationship table "Offerings"
        //DONE:  Make sure to include foreign keys to the Courses and Instructors tables
        createQuery = "CREATE TABLE " + CARINFO_TABLE + "("
                + CARINFO_KEY_FIELD_ID + " INTEGER, "
                + FIELD_CAR + " TEXT, "
                + FIELD_CITYRANGE + " INTEGER, "
                + FIELD_CITYEFFICIENCY + " INTEGER, "
                + FIELD_HIGHWAYRANGE + " INTEGER, "
                + FIELD_HIGHWAYEFFICIENCY + " INTEGER" + ")";
        database.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          int oldVersion,
                          int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + MILAGELOG_TABLE);
        database.execSQL("DROP TABLE IF EXISTS " + LOCATIONS_TABLE);
        database.execSQL("DROP TABLE IF EXISTS " + CARINFO_TABLE);
        onCreate(database);
    }

    //add Fuel Milage Log to the database

    public void addMilageLog(MileageFuel entry) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_DATE, pet.getName());
        values.put(FIELD_UNIT_OF_MEASURE, pet.getDetails());
        values.put(FIELD_FUELAMT, pet.getPhone());
        values.put(FIELD_IMAGE_URI, pet.getImageURI().toString());
        long id = db.insert(DATABASE_TABLE, null, values);
        pet.setId(id);

        //Close the database
        db.close();
    }

    public List<MileageFuel> getAllMilageLog() {
        List<Pet> petList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        // A cursor is the results of a database query (what gets returned)
        Cursor cursor = database.query(
                DATABASE_TABLE,
                new String[]{KEY_FIELD_ID, FIELD_NAME, FIELD_DETAILS, FIELD_PHONE, FIELD_IMAGE_URI},
                null,
                null,
                null, null, null, null );

        //COLLECT EACH ROW IN THE TABLE
        if (cursor.moveToFirst()){
            do {
                String uriString = cursor.getString(4);
                Uri uri = Uri.parse(uriString);

                Pet pet =
                        new Pet(cursor.getLong(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                uri);

                petList.add(pet);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return petList;
    }

    public void addLocation(MileageFuel location) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, pet.getName());
        values.put(FIELD_DETAILS, pet.getDetails());
        values.put(FIELD_PHONE, pet.getPhone());
        values.put(FIELD_IMAGE_URI, pet.getImageURI().toString());
        long id = db.insert(DATABASE_TABLE, null, values);
        pet.setId(id);

        //Close the database
        db.close();
    }

    public void addCar(MileageFuel car) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, pet.getName());
        values.put(FIELD_DETAILS, pet.getDetails());
        values.put(FIELD_PHONE, pet.getPhone());
        values.put(FIELD_IMAGE_URI, pet.getImageURI().toString());
        long id = db.insert(DATABASE_TABLE, null, values);
        pet.setId(id);

        //Close the database
        db.close();
    }

    public List<Pet> getAllPets() {
        List<Pet> petList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        // A cursor is the results of a database query (what gets returned)
        Cursor cursor = database.query(
                DATABASE_TABLE,
                new String[]{KEY_FIELD_ID, FIELD_NAME, FIELD_DETAILS, FIELD_PHONE, FIELD_IMAGE_URI},
                null,
                null,
                null, null, null, null );

        //COLLECT EACH ROW IN THE TABLE
        if (cursor.moveToFirst()){
            do {
                String uriString = cursor.getString(4);
                Uri uri = Uri.parse(uriString);

                Pet pet =
                        new Pet(cursor.getLong(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                uri);

                petList.add(pet);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return petList;
    }

    public void deletePet(Pet pet){
        SQLiteDatabase db = getWritableDatabase();

        // DELETE THE TABLE ROW
        db.delete(DATABASE_TABLE, KEY_FIELD_ID + " = ?",
                new String[] {String.valueOf(pet.getId())});
        db.close();
    }

    public void deleteAllPets()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DATABASE_TABLE, null, null);
        db.close();
    }

    public void updatePet(Pet pet){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_NAME, pet.getName());
        values.put(FIELD_DETAILS, pet.getDetails());
        values.put(FIELD_PHONE, pet.getPhone());
        values.put(FIELD_IMAGE_URI, pet.getImageURI().toString());

        db.update(DATABASE_TABLE, values, KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(pet.getId())});
        db.close();
    }

    public Pet getPet(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                DATABASE_TABLE,
                new String[]{KEY_FIELD_ID, FIELD_NAME, FIELD_DETAILS, FIELD_PHONE, FIELD_IMAGE_URI},
                KEY_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null );

        Pet pet = null;
        if (cursor != null) {
            cursor.moveToFirst();

            String uriString = cursor.getString(4);
            Uri uri = Uri.parse(uriString);

            pet = new Pet(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    uri);

            cursor.close();
        }
        db.close();
        return pet;
    }
