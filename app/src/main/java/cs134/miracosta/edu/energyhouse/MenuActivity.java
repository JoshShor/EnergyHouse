package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

/**
 * The MenuActivity class serves as the main gateway between the three primary functions of this app
 * The energy portion, recycling portion, and transportation portion
 */

public class MenuActivity extends AppCompatActivity {

    private Button energyButton;
    private Button recycleButton;
    private Button transportButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        energyButton = findViewById(R.id.energyButton);
        recycleButton = findViewById(R.id.recycleButton);
        transportButton = findViewById(R.id.transportButton);
    }

    /**
     * Switches to the EnergyActivity.class
     * @param v
     */
    public void switchToEnergy(View v){
        Intent energyIntent = new Intent(this, EnergyActivity.class);
        startActivity(energyIntent);
    }

    /**
     * Switches to the RecyclingActivity.class
     * @param v
     */
    public void switchToRecycle(View v){
        Intent recyclingIntent = new Intent(this, RecyclingActivity.class);
        startActivity(recyclingIntent);
    }

    /**
     * Switches to the TransportSetupActivity.class
     * @param v
     */
    public void switchToTransport(View v){
        Intent transportIntent = new Intent(this, TransportSetupActivity.class);
        startActivity(transportIntent);
    }

}
