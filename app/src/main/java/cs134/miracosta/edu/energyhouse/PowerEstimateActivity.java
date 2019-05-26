package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import cs134.miracosta.edu.energyhouse.model.DBHelper;
import cs134.miracosta.edu.energyhouse.model.UsageTracker;

public class PowerEstimateActivity extends AppCompatActivity {

    //Objects carried from the List Adapters
    private List<UsageTracker> usageList;
    private UsageListViewAdapter usageListAdapter;
    private ListView usageListView;

    //mutable TextViews in current activity
    private TextView energyDailyTextView;
    private TextView energyWeeklyTextView;
    private TextView energyMonthlyTextView;

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
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        String currentTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(date);


        energyDailyTextView = findViewById(R.id.energyDailyTextView);
        energyWeeklyTextView = findViewById(R.id.energyWeeklyTextView);
        energyMonthlyTextView = findViewById(R.id.energyMonthlyTextView);

        Intent intent = getIntent();


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
     * Adds new entry to database
     * @param view
     */

    public void addToUsageLog(View view){



    }
}
