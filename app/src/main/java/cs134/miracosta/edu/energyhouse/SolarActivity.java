package cs134.miracosta.edu.energyhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class SolarActivity extends AppCompatActivity {
    //format for decimal value
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    private EditText energyForSolarEditText;
    private TextView squarefootTextView;
    private TextView costTextView;

    double energyUsed;
    double solarPanelsNeeded;
    double costOfPanels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar);

        energyForSolarEditText = findViewById(R.id.energyForSolarEditText);
        squarefootTextView= findViewById(R.id.squarefootTextView);
        costTextView= findViewById(R.id.costTextView);

        String nrgUsedStr = energyForSolarEditText.getText().toString();
        energyUsed = Double.parseDouble(nrgUsedStr);
        solarPanelsNeeded = energyUsed/75;
        costOfPanels = solarPanelsNeeded * 150;

        String costString = currency.format(costOfPanels);
        String SolarPanelsNeeded = "number of Solar Panels will be" + solarPanelsNeeded;

        squarefootTextView.setText(SolarPanelsNeeded);
        costTextView.setText(costString);



    }
}
