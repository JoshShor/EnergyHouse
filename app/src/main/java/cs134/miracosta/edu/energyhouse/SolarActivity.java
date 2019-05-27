package cs134.miracosta.edu.energyhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import cs134.miracosta.edu.energyhouse.model.SolarPanels;
import cs134.miracosta.edu.energyhouse.model.SolarPanelsJSONLoader;

/**
 * The SolarActivity class handles the "solar" portion of the Energy portion of this app.
 * The use will type in the amount of power he or she uses, selects a solar panel from the list
 * view, and then it will output how many solar panels they will need, how much space it occupies
 * and how much it will cost
 */
public class SolarActivity extends AppCompatActivity {

    //Objects carried from the List Adapters
    private List<SolarPanels> allSolarPanels;
    private SolarPanelsListViewAdapter panelListAdapter;
    private ListView solarPanelsListView;

    //format for decimal value
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    DecimalFormat df = new DecimalFormat("0.00");
    private EditText energyForSolarEditText;
    private TextView selSolarPanelTextView;
    private TextView numOfPanelsTextView;
    private TextView totalSqFtTextView;
    private TextView totalCostTextView;

    double userKiloWattPower = 0;
    double numberOfPanels = 0;
    double totalAreaOfPanels = 0;
    double totalCostsOfPanels = 0;

    String nrgUsedStr = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar);


        try {
            allSolarPanels = SolarPanelsJSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("Energy House", "Error loading JSON" + e.getMessage());
        }

        energyForSolarEditText = findViewById(R.id.energyForSolarEditText);
        selSolarPanelTextView = findViewById(R.id.selSolarPanelTextView);
        numOfPanelsTextView = findViewById(R.id.numOfPanelsTextView);
        totalSqFtTextView = findViewById(R.id.totalSqFtTextView);
        totalCostTextView = findViewById(R.id.totalCostTextView);

        solarPanelsListView = findViewById(R.id.solarPanelsListView);

        SolarPanelsListViewAdapter solarPanelsListViewAdapter = new SolarPanelsListViewAdapter(this, R.layout.solar_panel_list_item, allSolarPanels);

        solarPanelsListView.setAdapter(solarPanelsListViewAdapter);

    }

    /**
     * This method is invoked when the users chooses an item on the list
     * it will pass releveant information in to the various TextViews contained
     * in the solar activity class
     * @param v
     */
    public void calculateSolar(View v){

        nrgUsedStr = energyForSolarEditText.getText().toString();
        if(nrgUsedStr.isEmpty())
            userKiloWattPower = 0;
        else
            userKiloWattPower = Double.parseDouble(nrgUsedStr);

        SolarPanels selectedSolarPanels = (SolarPanels) v.getTag();
        selSolarPanelTextView.setText(selectedSolarPanels.getPanel());

        selectedSolarPanels.setNumberOfPanels(userKiloWattPower);
        numberOfPanels = selectedSolarPanels.getNumberOfPanels();

        selectedSolarPanels.setTotalArea(numberOfPanels);
        totalAreaOfPanels = selectedSolarPanels.getTotalArea();

        selectedSolarPanels.setTotalCosts(numberOfPanels);
        totalCostsOfPanels = selectedSolarPanels.getTotalCosts();

        String numOfPanelString = ((int)numberOfPanels + " panels");
        String panelAreaString = df.format(totalAreaOfPanels) + "ft²";


        numOfPanelsTextView.setText(numOfPanelString);
        totalSqFtTextView.setText(panelAreaString);
        totalCostTextView.setText(currency.format(totalCostsOfPanels));

    }

}
