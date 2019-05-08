package cs134.miracosta.edu.energyhouse.model;

import android.content.Context;

public class DBHelper {

    private Context mContext;

    //TASK: DEFINE THE DATABASE VERSION AND NAME  (DATABASE CONTAINS MULTIPLE TABLES)
    public static final String DATABASE_NAME = "ENERGYHOUSE";
    private static final int DATABASE_VERSION = 1;

    //TASK: DEFINE THE FIELDS (COLUMN NAMES) FOR THE SOLAR TABLE
    private static final String SOLAR_TABLE = "Solar";
    private static final String COURSES_KEY_FIELD_ID = "_id";
    private static final String FIELD_ALPHA = "alpha";
    private static final String FIELD_NUMBER = "number";
    private static final String FIELD_TITLE = "title";

    public DBHelper(Context context){
        //super(context,DATABASE_NAME,null,DATABASE_VERSION);
        mContext = context;
    }
}
