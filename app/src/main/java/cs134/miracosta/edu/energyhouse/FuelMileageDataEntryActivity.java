package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cs134.miracosta.edu.energyhouse.model.DBHelper;
import cs134.miracosta.edu.energyhouse.model.FuelMileage;

public class FuelMileageDataEntryActivity extends AppCompatActivity {

    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    private List<FuelMileage> entryList;
    private FuelMileageListAdapter entryListAdapter;
    private ListView entryListView;

    private EditText dateEditText;
    private EditText fuelAmtEditText;
    private EditText priceOfFuelEditText;
    private EditText odometerReadingEditText;

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_mileage_data_entry);

        db = new DBHelper(this);

        //get Date
        String currentDate = DateFormat.getDateInstance().format(new Date());
        dateEditText = findViewById(R.id.dateEditText);
        dateEditText.setText(currentDate);

        //connect the ListView with he layout
        entryListView = findViewById(R.id.fuelEntryListView);
        entryList = db.getAllMilageLogs();
        entryListAdapter = new FuelMileageListAdapter(this, R.layout.fuel_log_list_item, entryList);
        entryListView.setAdapter(entryListAdapter);

        priceOfFuelEditText = findViewById(R.id.pricePerUnitEditText);

        db.close();

    }

    public void addEntry(View view){

        fuelAmtEditText = findViewById(R.id.fuelAmtEditText);
        priceOfFuelEditText = findViewById(R.id.pricePerUnitEditText);
        odometerReadingEditText = findViewById(R.id.odometerReadingEditText);

        String date = dateEditText.getText().toString();
        double fuelAmt = Double.parseDouble(fuelAmtEditText.getText().toString());
        double priceOfFuel = Double.parseDouble(priceOfFuelEditText.getText().toString());
        double odometerReading = Double.parseDouble(odometerReadingEditText.getText().toString());

        FuelMileage newEntry = new FuelMileage(date, fuelAmt, odometerReading, priceOfFuel);

        db.addMileageLog(newEntry);

        entryListAdapter.add(newEntry);


        fuelAmtEditText.setText("");
        priceOfFuelEditText.setText("");
        odometerReadingEditText.setText("");

        db.close();

    }

    public void toReport(View view){

        Intent report = new Intent(this, TransportReportActivity.class);
        startActivity(report);
    }}
