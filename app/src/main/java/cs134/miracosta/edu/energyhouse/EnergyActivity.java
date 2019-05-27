package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * EnergyActivity.java serves at the entry point for EnergyUsage and solar recommendation activities
 */
public class EnergyActivity extends AppCompatActivity {
    private Button applianceButton;
    private Button solarButton;
    private Animation shakeAnim;
    private ImageView eHLogoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);

        applianceButton = findViewById(R.id.applianceButton);
        solarButton = findViewById(R.id.solarButton);
        eHLogoImageView = findViewById(R.id.eHLogoImageView);
    }

    /**
     * Switches the user to the "Appliance" portion of the Energyhouse app. Goes to
     * ApplianceActivity.class
     * @param v
     */
    public void switchToAppliance(View v){
        Intent applianceIntent = new Intent(this, ApplianceActivity.class);
        startActivity(applianceIntent);
    }

    /**
     * Switches the user to the "Solar" portion of the Energyhuse app. Goes to the
     * SolarActivity.class
     * @param v
     */
    public void switchToSolar(View v){
        Intent solarIntent = new Intent(this, SolarActivity.class);
        startActivity(solarIntent);
    }

    /**
     * Toggles a shake animation which causes the ImageView "eHLogoImageView" to shake
     * momentarily
     * @param v
     */
    public void toggleShakeAnim(View v){
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_animation);
        eHLogoImageView.startAnimation(shakeAnim);
    }
}