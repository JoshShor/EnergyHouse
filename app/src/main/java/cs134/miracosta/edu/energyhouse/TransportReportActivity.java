package cs134.miracosta.edu.energyhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cs134.miracosta.edu.energyhouse.model.DBHelper;
import cs134.miracosta.edu.energyhouse.model.FuelMileage;

public class TransportReportActivity extends AppCompatActivity {

    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    private NumberFormat decimal = NumberFormat.getNumberInstance(Locale.getDefault());
    private DBHelper db;
    private List<FuelMileage> allFuelLogData;
    private TextView totalSpentTextView;
    private TextView totalFuelTextView;
    private TextView fromDateTextView;
    private TextView toDateTextView;
    private TextView totalKWTextView;
    private TextView totalDistanceTextView;

    private double totalCost=0;
    private double totalMiles = 0;
    private double totalFuel = 0;
    private int numberOfDays = 0;
    private String sDate1;
    private String sDate2;
    private double totalKW = 0;
    private double totalDistance = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_report);

        totalSpentTextView = findViewById(R.id.totalSpentTextView);
        totalFuelTextView = findViewById(R.id.totalFuelUsedTextView);
        fromDateTextView = findViewById(R.id.dateFromTextView);
        toDateTextView = findViewById(R.id.toDateTextView);
        totalKWTextView = findViewById(R.id.totalKWUsedTextView);
        totalDistanceTextView = findViewById(R.id.totalDistanceDrivenTextView);


        //Get all the data from the Database and put it into a List
        db = new DBHelper(this);
        allFuelLogData = db.getAllMilageLogs();

        //Calculate the stats
        calculateStats();

        //Display the results
        fromDateTextView.setText(sDate1);
        toDateTextView.setText(sDate2);
        totalSpentTextView.setText(currency.format(totalCost));
        totalFuelTextView.setText(decimal.format(totalFuel));
        totalKWTextView.setText(decimal.format(totalKW));
        totalDistanceTextView.setText(decimal.format(totalDistance));
    }

    public void calculateKW(){
        //there are 33.41kwh of energy in 1 gallon of Gasoline
        //there is 37.95kwh of energy in 1 gallon of Diesel
        //

        double gasPerKW = 33.41;
    }

    public void carCompare(){
        //Tesla model s will travel 6.25KM per 1 kwh of electricity
    }

    public void calculateCostTravel(){
        //Calculate the cost to travel the same distance with an electric car
    }

    public void calculateStats(){
        totalCost=0;
        sDate1 = allFuelLogData.get(0).getDateStr();
        sDate2 = allFuelLogData.get(allFuelLogData.size() - 1).getDateStr();
        try {
            Date date1 = new SimpleDateFormat("MMMM, dd yyyy").parse(sDate1);
            Date date2 = new SimpleDateFormat("MMMM, dd yyyy").parse(sDate2);
            numberOfDays = Math.round((date2.getTime() - date1.getTime())/ 86400000);
        }catch(ParseException e){
            Log.e("ParseError-calStats", e.getLocalizedMessage());
        }
        for(FuelMileage entry : allFuelLogData){
            totalCost += entry.getTotalCostFillUp();
            totalFuel =+ entry.getFuelAmt();
        }

        totalKW = totalFuel * 33.45;
        totalDistance = (allFuelLogData.get(allFuelLogData.size()-1).getOdometerReading()) - (allFuelLogData.get(0).getOdometerReading());
    }


}
