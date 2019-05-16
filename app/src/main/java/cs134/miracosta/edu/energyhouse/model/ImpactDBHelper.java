package cs134.miracosta.edu.energyhouse.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ImpactDBHelper extends SQLiteOpenHelper
{
    //TASK 1: DEFINE THE DATABASE VERSION, NAME AND TABLE NAME
    public static final String DATABASE_NAME = "EnergyHouse";
    private static final String DATABASE_TABLE = "ImpactItems";
    private static final int DATABASE_VERSION = 1;


    //TASK 2: DEFINE THE FIELDS (COLUMN NAMES) FOR THE TABLE
    private static final String KEY_FIELD_ID = "_id";
    private static final String FIELD_POUNDS_PAPER = "paper";
    private static final String FIELD_POUNDS_MIXED = "mixed";


    public ImpactDBHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase database){
        String table = "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + "("
                + KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_POUNDS_PAPER + " REAL, "
                + FIELD_POUNDS_MIXED + " REAL"
                + ")";
        database.execSQL (table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          int oldVersion,
                          int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(database);
    }

    //********** DATABASE OPERATIONS:  ADD, UPDATE, EDIT, DELETE

    public void addImpactItem(ImpactItem impactItem) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_POUNDS_PAPER, impactItem.getPoundsOfPaper());

        values.put(FIELD_POUNDS_MIXED, impactItem.getPoundsOfMixedRecyclables());

        // INSERT THE ROW IN THE TABLE
        long id = db.insert(DATABASE_TABLE, null, values);

        impactItem.setId(id);

        // CLOSE THE DATABASE CONNECTION
        db.close();
    }

    public List<ImpactItem> getAllImpactItems() {
        List<ImpactItem> impactItemsList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        // A cursor is the results of a database query (what gets returned)
        Cursor cursor = database.query(
                DATABASE_TABLE,
                new String[]{KEY_FIELD_ID, FIELD_POUNDS_PAPER, FIELD_POUNDS_MIXED},
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
        db.delete(DATABASE_TABLE, KEY_FIELD_ID + " = ?",
                new String[] {String.valueOf(impactItem.getId())});
        db.close();
    }

    public void deleteAllImpactItems()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DATABASE_TABLE, null, null);
        db.close();
    }

    public void updateImpactItem(ImpactItem impactItem){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_POUNDS_PAPER, impactItem.getPoundsOfPaper());
        values.put(FIELD_POUNDS_MIXED, impactItem.getPoundsOfMixedRecyclables());

        db.update(DATABASE_TABLE, values, KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(impactItem.getId())});
        db.close();
    }

    public ImpactItem getImpactItem(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                DATABASE_TABLE,
                new String[]{KEY_FIELD_ID, FIELD_POUNDS_PAPER, FIELD_POUNDS_MIXED},
                KEY_FIELD_ID + "=?",
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
}
