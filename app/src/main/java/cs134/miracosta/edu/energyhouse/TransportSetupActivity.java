package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TransportSetupActivity extends AppCompatActivity {

    private Button saveSettingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_transport_setup);

        saveSettingsButton = findViewById(R.id.doneButton);

        checkFirstRun();
    }


    private void checkFirstRun() {

        final String PREFS_NAME = "MyPrefsFile";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;

        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {

            Intent transportIntent = new Intent(this, FuelMileageDataEntryActivity.class);
            startActivity(transportIntent);
            return;

        } else if (savedVersionCode == DOESNT_EXIST) {

            setContentView(R.layout.activity_transport_setup);

        } else if (currentVersionCode > savedVersionCode) {

            Intent transportIntent = new Intent(this, TransportSetupActivity.class);
            startActivity(transportIntent);
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();
    }

    public void saveSetupButtonClick(View view){

        EditText electricityCost = findViewById(R.id.electricityPriceEditText);
        Intent transportIntent = new Intent(this, FuelMileageDataEntryActivity.class);
        startActivity(transportIntent);
    }

}