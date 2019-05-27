package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import cs134.miracosta.edu.energyhouse.model.DBHelper;
import cs134.miracosta.edu.energyhouse.model.UsageTracker;

/**
 * PowerEstimateActivity used to display to the user how much energy they are using per day
 * accompined by a listView which allows the user to log their daily power usage.
 */
public class PowerEstimateActivity extends AppCompatActivity {

    //Objects carried from the List Adapters
    private List<UsageTracker> usageList;
    private UsageListViewAdapter usageListAdapter;
    private ListView usageListView;


    //mutable TextViews in current activity
    private TextView energyDailyTextView;
    private TextView energyWeeklyTextView;
    private TextView energyMonthlyTextView;

    //local variables that are needed to pass values to the database
    String currentDate;
    String currentTime;
    double kiloWattsHoursValue = 0;

    //Database helper object
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_estimate);

        //call the dbhelper
        db = new DBHelper(this);

        //get Dates set them to string
        Date date = new Date();
        currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        currentTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(date);

        energyDailyTextView = findViewById(R.id.energyDailyTextView);
        energyWeeklyTextView = findViewById(R.id.energyWeeklyTextView);
        energyMonthlyTextView = findViewById(R.id.energyMonthlyTextView);

        Intent intent = getIntent();

        //get kWH for the day from string ... convert to double
        String kWhValueString = intent.getStringExtra("DayKiloNRG");
        kiloWattsHoursValue = Double.parseDouble(kWhValueString);

        energyDailyTextView.setText(intent.getStringExtra("DailyNRG"));
        //energyDailyTextView.setText(currentTime); //testing purposes
        energyWeeklyTextView.setText(intent.getStringExtra("WeeklyNRG"));
        energyMonthlyTextView.setText(intent.getStringExtra("MonthlyNRG"));

        //connect the ListView with the layout
        usageListView = findViewById(R.id.usageListView);
        usageList = db.getAllUsageLogs();
        usageListAdapter = new UsageListViewAdapter(this,R.layout.usage_entry_list_item,usageList);
        usageListView.setAdapter(usageListAdapter);

        //close the database so it does flood
        db.close();
    }

    /**
     * Adds new entry to database which will then get diplayed on the ListView
     * @param view
     */
    public void addToUsageLog(View view){

        //pass values to the UserTracker model
        UsageTracker newUsageEntry = new UsageTracker(currentDate,currentTime,kiloWattsHoursValue);
        //store value in database
        db.addUsageLog(newUsageEntry);

        usageListAdapter.add(newUsageEntry);

        db.close();
    }

    /**
     * Clears the entire UsageTracker database and list view
     * @param view
     */
    public void clearUsageLog(View view){
        db.deleteAllUsageLogs();
        usageList.clear();
        usageListAdapter.notifyDataSetChanged();

    }
}
