package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cs134.miracosta.edu.energyhouse.model.Appliances;

public class ApplianceActivity extends AppCompatActivity {
    private EditText ledPowerEditText;
    private EditText ledHoursEditText;
    private EditText tvPowerEditText;
    private EditText tvHoursEditText;
    private EditText acPowerEditText;
    private EditText acHoursEditText;
    private EditText heaterPowerEditText;
    private EditText heaterHoursEditText;
    private EditText microwavePowerEditText;
    private EditText microwaveHoursEditText;
    private EditText ovenPowerEditText;
    private EditText ovenHoursEditText;
    private EditText refrigeratorPowerEditText;
    private EditText refrigeratorHoursEditText;
    private EditText dishwasherPowerEditText;
    private EditText dishwasherHoursEditText;
    private EditText washingMachinePowerEditText;
    private EditText washingMachineHoursEditText;
    private EditText dryerPowerEditText;
    private EditText dryerHoursEditText;
    private Button energyUsageCalcButton;

    double wats = 0;
    double hrs = 0;
    double wattHour = 0;
    double totalEnergy = 0;
    double weekEnergy;
    double monthEnergy;

    //This would be much better if I used an array.
    double lightNRG;
    double tvNRG;
    double acNRG;
    double heatNRG;
    double microwaveNRG;
    double ovenNRG;
    double fridgeNRG;
    double dishNRG;
    double washNRG;
    double dryerNRG;

    private Appliances appliance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance);
        ledPowerEditText = findViewById(R.id.ledPowerEditText);
        ledHoursEditText = findViewById(R.id.ledHoursEditText);
        tvPowerEditText = findViewById(R.id.tvPowerEditText);
        tvHoursEditText = findViewById(R.id.tvHoursEditText);
        acPowerEditText = findViewById(R.id.acPowerEditText);
        acHoursEditText = findViewById(R.id.acHoursEditText);
        heaterPowerEditText = findViewById(R.id.heaterPowerEditText);
        heaterHoursEditText = findViewById(R.id.heaterHoursEditText);
        microwavePowerEditText = findViewById(R.id.microwavePowerEditText);
        microwaveHoursEditText = findViewById(R.id.microwaveHoursEditText);
        ovenPowerEditText = findViewById(R.id.ovenPowerEditText);
        ovenHoursEditText = findViewById(R.id.ovenHoursEditText);
        refrigeratorPowerEditText = findViewById(R.id.refrigeratorPowerEditText);
        refrigeratorHoursEditText = findViewById(R.id.refrigeratorHoursEditText);
        dishwasherPowerEditText = findViewById(R.id.dishwasherPowerEditText);
        dishwasherHoursEditText = findViewById(R.id.dishwasherHoursEditText);
        washingMachinePowerEditText = findViewById(R.id.washingMachinePowerEditText);
        washingMachineHoursEditText = findViewById(R.id.washingMachineHoursEditText);
        dryerPowerEditText = findViewById(R.id.dryerPowerEditText);
        dryerHoursEditText = findViewById(R.id.dryerHoursEditText);
        energyUsageCalcButton = findViewById(R.id.energyUsageCalcButton);

        appliance = new Appliances();

    }

    public void computeEnergyConsumed(View v){

        String lightPowerStr = ledPowerEditText.getText().toString();
        String lightHoursStr = ledHoursEditText.getText().toString();
        String tvPowerStr = tvPowerEditText.getText().toString();
        String tvHoursStr = tvHoursEditText.getText().toString();
        String acPowerStr = acPowerEditText.getText().toString();
        String acHoursStr = acHoursEditText.getText().toString();
        String heaterPowerStr = heaterPowerEditText.getText().toString();
        String heaterHoursStr = heaterHoursEditText.getText().toString();
        String microwavePowerStr = microwavePowerEditText.getText().toString();
        String microwaveHoursStr = microwaveHoursEditText.getText().toString();
        String ovenPowerStr = ovenPowerEditText.getText().toString();
        String ovenHoursStr = ovenHoursEditText.getText().toString();
        String refrigeratorPowerStr = refrigeratorPowerEditText.getText().toString();
        String refrigeratorHoursStr = refrigeratorHoursEditText.getText().toString();
        String dishwasherPowerStr = dishwasherPowerEditText.getText().toString();
        String dishwasherHoursStr = dishwasherHoursEditText.getText().toString();
        String washingMachinePowerStr = washingMachinePowerEditText.getText().toString();
        String washingMachineHoursStr = washingMachineHoursEditText.getText().toString();
        String dryerPowerStr = dryerPowerEditText.getText().toString();
        String dryerHoursStr = dryerHoursEditText.getText().toString();

        appliance.setWatts(Double.parseDouble(lightPowerStr));
        appliance.setHours(Double.parseDouble(lightHoursStr));
        appliance.setWattHour(Double.parseDouble(lightPowerStr), Double.parseDouble(lightHoursStr));
        totalEnergy += appliance.getWattHour();
        Log.e("Lights outs", "Lights here " + totalEnergy);
        Log.e("Lights outs", lightPowerStr);

        appliance.setWatts(Double.parseDouble(tvPowerStr));
        appliance.setHours(Double.parseDouble(tvHoursStr));
        appliance.setWattHour(Double.parseDouble(tvPowerStr), Double.parseDouble(tvHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setWatts(Double.parseDouble(acPowerStr));
        appliance.setHours(Double.parseDouble(acHoursStr));
        appliance.setWattHour(Double.parseDouble(acPowerStr), Double.parseDouble(acHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setWatts(Double.parseDouble(heaterPowerStr));
        appliance.setHours(Double.parseDouble(heaterHoursStr));
        appliance.setWattHour(Double.parseDouble(heaterPowerStr), Double.parseDouble(heaterHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setWatts(Double.parseDouble(microwavePowerStr));
        appliance.setHours(Double.parseDouble(microwaveHoursStr));
        appliance.setWattHour(Double.parseDouble(microwavePowerStr), Double.parseDouble(microwaveHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setWatts(Double.parseDouble(ovenPowerStr));
        appliance.setHours(Double.parseDouble(ovenHoursStr));
        appliance.setWattHour(Double.parseDouble(ovenPowerStr), Double.parseDouble(ovenHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setWatts(Double.parseDouble(refrigeratorPowerStr));
        appliance.setHours(Double.parseDouble(refrigeratorHoursStr));
        appliance.setWattHour(Double.parseDouble(refrigeratorPowerStr), Double.parseDouble(refrigeratorHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setWatts(Double.parseDouble(dishwasherPowerStr));
        appliance.setHours(Double.parseDouble(dishwasherHoursStr));
        appliance.setWattHour(Double.parseDouble(dishwasherPowerStr), Double.parseDouble(dishwasherHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setWatts(Double.parseDouble(washingMachinePowerStr));
        appliance.setHours(Double.parseDouble(washingMachineHoursStr));
        appliance.setWattHour(Double.parseDouble(washingMachinePowerStr), Double.parseDouble(washingMachineHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setWatts(Double.parseDouble(dryerPowerStr));
        appliance.setHours(Double.parseDouble(dryerHoursStr));
        appliance.setWattHour(Double.parseDouble(dryerPowerStr), Double.parseDouble(dryerHoursStr));
        totalEnergy += appliance.getWattHour();

        appliance.setTotalWH(totalEnergy);
        double total = appliance.getTotalWH();
        appliance.setEnergyPerWeek(total);
        weekEnergy = appliance.getEnergyPerWeek();
        appliance.setEnergyPerMonth(total);
        monthEnergy = appliance.getEnergyPerMonth();

        //create new intent to share data between activities and switch to them
        Intent estimateIntent = new Intent(this, PowerEstimate.class);

        String dailyEnergyUseString = (totalEnergy) + " wattHours/Day";
        String weeklyEnergyUseString = weekEnergy + " kWh/week";
        String monthlyEnergyUseString = monthEnergy + " kWh/month";

        estimateIntent.putExtra("DailyNRG", dailyEnergyUseString);
        estimateIntent.putExtra("WeeklyNRG", weeklyEnergyUseString);
        estimateIntent.putExtra("MonthlyNRG", monthlyEnergyUseString);

        startActivity(estimateIntent);



        /*
        lightNRG = (Double.parseDouble(lightPowerStr) * Double.parseDouble(lightHoursStr));
        tvNRG = (Double.parseDouble(tvPowerStr) * Double.parseDouble(tvHoursStr));
        acNRG = (Double.parseDouble(acPowerStr) * Double.parseDouble(acHoursStr));
        heatNRG = (Double.parseDouble(heaterPowerStr) * Double.parseDouble(heaterHoursStr));
        microwaveNRG = (Double.parseDouble(microwavePowerStr) * Double.parseDouble(microwaveHoursStr));
        ovenNRG = (Double.parseDouble(ovenPowerStr) * Double.parseDouble(ovenHoursStr));
        fridgeNRG = (Double.parseDouble(refrigeratorPowerStr) * Double.parseDouble(refrigeratorHoursStr));
        dishNRG = (Double.parseDouble(dishwasherPowerStr) * Double.parseDouble(dishwasherHoursStr));
        washNRG = (Double.parseDouble(washingMachinePowerStr) * Double.parseDouble(washingMachineHoursStr));
        dryerNRG = (Double.parseDouble(dryerPowerStr) * Double.parseDouble(dryerHoursStr));
        */



    }
}
